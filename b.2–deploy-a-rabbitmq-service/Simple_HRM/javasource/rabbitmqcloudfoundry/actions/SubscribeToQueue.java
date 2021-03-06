// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package rabbitmqcloudfoundry.actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;
import org.apache.commons.lang.exception.ExceptionUtils;
import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.thirdparty.org.json.JSONObject;
import com.mendix.webui.CustomJavaAction;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class SubscribeToQueue extends CustomJavaAction<java.lang.Boolean>
{
	private java.lang.String queueName;
	private java.lang.String callbackMicroflow;

	public SubscribeToQueue(IContext context, java.lang.String queueName, java.lang.String callbackMicroflow)
	{
		super(context);
		this.queueName = queueName;
		this.callbackMicroflow = callbackMicroflow;
	}

	@Override
	public java.lang.Boolean executeAction() throws Exception
	{
		// BEGIN USER CODE
		Connection connection = null;

		try {
			connection = buildConnectionFactoryFromVcapServices().newConnection();
			final Channel channel = connection.createChannel();
			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
						byte[] body) throws IOException {
					String message = new String(body, "UTF-8");
					Core.getLogger("Handle message").debug("Message received: " + message);
					HashMap<String, Object> parameters = new HashMap<String, Object>();
					parameters.put("message", message);
					IContext systemContext = Core.createSystemContext();
					try {
						Core.execute(systemContext, callbackMicroflow, parameters);
					} catch (CoreException e) {
						Core.getLogger("Handle message").error("Error handling message: " + message, e);
					} finally {
						channel.basicAck(envelope.getDeliveryTag(), false);
					}
				}
			};
			channel.basicConsume(queueName, false, consumer);
		} catch (Exception e) {
			if (connection != null)
				connection.close();
			throw new MendixRuntimeException("Failed to subscribe to exchange " + queueName + ".", e);
		}

		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "SubscribeToQueue";
	}

	// BEGIN EXTRA CODE

	private ConnectionFactory buildConnectionFactoryFromVcapServices() throws Exception {
		try {

			ConnectionFactory factory = new ConnectionFactory();

			JSONObject vcapServices = new JSONObject(Optional.ofNullable(System.getenv("VCAP_SERVICES")).orElse(
					"{\"cleardb\":[{\"name\":\"mendix-demo-db\",\"instance_name\":\"mendix-demo-db\",\"binding_name\":null,\"credentials\":{\"jdbcUrl\":\"jdbc:mysql://us-cdbr-iron-east-04.cleardb.net/ad_22335e0086f6df5?user=b0b82c05f28bfb&password=11df61b2\",\"uri\":\"mysql://b0b82c05f28bfb:11df61b2@us-cdbr-iron-east-04.cleardb.net:3306/ad_22335e0086f6df5?reconnect=true\",\"name\":\"ad_22335e0086f6df5\",\"hostname\":\"us-cdbr-iron-east-04.cleardb.net\",\"port\":\"3306\",\"username\":\"b0b82c05f28bfb\",\"password\":\"11df61b2\"},\"syslog_drain_url\":null,\"volume_mounts\":[],\"label\":\"cleardb\",\"provider\":null,\"plan\":\"spark\",\"tags\":[\"Cloud Databases\",\"Data Stores\",\"Developer Tools\",\"Web-based\",\"Data Store\",\"Online Backup & Storage\",\"Development and Test Tools\",\"Single Sign-On\",\"Buyable\",\"relational\",\"mysql\",\"Cloud Security and Monitoring\"]}],\"cloudamqp\":[{\"name\":\"mendix-demo-broker\",\"instance_name\":\"mendix-demo-broker\",\"binding_name\":null,\"credentials\":{\"uri\":\"amqp://cvvtqais:QQupCcl0-jDFSKnALqnykbBV60Kg6BcO@eagle.rmq.cloudamqp.com/cvvtqais\",\"http_api_uri\":\"https://cvvtqais:QQupCcl0-jDFSKnALqnykbBV60Kg6BcO@eagle.rmq.cloudamqp.com/api/\"},\"syslog_drain_url\":null,\"volume_mounts\":[],\"label\":\"cloudamqp\",\"provider\":null,\"plan\":\"lemur\",\"tags\":[\"Customer Service\",\"Web-based\",\"User Provisioning\",\"Messaging and Queuing\",\"IT Service Management\",\"amqp\",\"Online Backup & Storage\",\"Backup\",\"Single Sign-On\",\"Cloud Security and Monitoring\",\"New Product\",\"rabbitmq\",\"Android\",\"Developer Tools\",\"Cloud Deployment & Management\",\"Development and Test Tools\",\"Buyable\",\"Messaging\",\"Importable\",\"IT Management\"]}]}"));

			factory.setUri(
					// Transform VCAP_SERVICES to an array.
					StreamSupport
							.stream(Spliterators.spliteratorUnknownSize(vcapServices.keys(), Spliterator.NONNULL),
									false)
							.map(key -> vcapServices.getJSONArray(key))

							.flatMap(jsonArray -> jsonArray.toJSONObjectCollection().stream())

							// Filter any service that does not have an amqp tag.
							.filter(jsonObject ->

							// Transforms all the tags to String
							jsonObject.getJSONArray("tags").toCollection().stream().map(Object::toString)

									// Filters tags that does not match amqp
									.filter(tag -> "amqp".equals(tag)).findAny().isPresent())
							.findFirst()
							.orElseThrow(
									() -> new MendixRuntimeException("Could not find any service tagged with amqp"))

							.getJSONObject("credentials").getString("uri").toString());

			return factory;
		} catch (Exception ex) {
			Core.getLogger("MyLogger").info("Exception : " + ExceptionUtils.getFullStackTrace(ex));

			throw ex;
		}
	}

	// END EXTRA CODE
}
