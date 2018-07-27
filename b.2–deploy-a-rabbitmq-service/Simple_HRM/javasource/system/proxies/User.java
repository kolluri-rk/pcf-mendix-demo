// This file was generated by Mendix Modeler.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package system.proxies;

public class User
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject userMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "System.User";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		Name("Name"),
		Password("Password"),
		LastLogin("LastLogin"),
		Blocked("Blocked"),
		Active("Active"),
		FailedLogins("FailedLogins"),
		WebServiceUser("WebServiceUser"),
		IsAnonymous("IsAnonymous"),
		UserRoles("System.UserRoles"),
		User_Language("System.User_Language"),
		User_TimeZone("System.User_TimeZone");

		private java.lang.String metaName;

		MemberNames(java.lang.String s)
		{
			metaName = s;
		}

		@Override
		public java.lang.String toString()
		{
			return metaName;
		}
	}

	public User(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, "System.User"));
	}

	protected User(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject userMendixObject)
	{
		if (userMendixObject == null)
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		if (!com.mendix.core.Core.isSubClassOf("System.User", userMendixObject.getType()))
			throw new java.lang.IllegalArgumentException("The given object is not a System.User");

		this.userMendixObject = userMendixObject;
		this.context = context;
	}

	/**
	 * @deprecated Use 'User.load(IContext, IMendixIdentifier)' instead.
	 */
	@Deprecated
	public static system.proxies.User initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		return system.proxies.User.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 */
	public static system.proxies.User initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		if (com.mendix.core.Core.isSubClassOf("Administration.Account", mendixObject.getType()))
			return administration.proxies.Account.initialize(context, mendixObject);

		return new system.proxies.User(context, mendixObject);
	}

	public static system.proxies.User load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return system.proxies.User.initialize(context, mendixObject);
	}

	public static java.util.List<? extends system.proxies.User> load(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String xpathConstraint) throws com.mendix.core.CoreException
	{
		java.util.List<system.proxies.User> result = new java.util.ArrayList<system.proxies.User>();
		for (com.mendix.systemwideinterfaces.core.IMendixObject obj : com.mendix.core.Core.retrieveXPathQuery(context, "//System.User" + xpathConstraint))
			result.add(system.proxies.User.initialize(context, obj));
		return result;
	}

	/**
	 * Commit the changes made on this proxy object.
	 */
	public final void commit() throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Commit the changes made on this proxy object using the specified context.
	 */
	public final void commit(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Delete the object.
	 */
	public final void delete()
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}

	/**
	 * Delete the object using the specified context.
	 */
	public final void delete(com.mendix.systemwideinterfaces.core.IContext context)
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}
	/**
	 * @return value of Name
	 */
	public final java.lang.String getName()
	{
		return getName(getContext());
	}

	/**
	 * @param context
	 * @return value of Name
	 */
	public final java.lang.String getName(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Name.toString());
	}

	/**
	 * Set value of Name
	 * @param name
	 */
	public final void setName(java.lang.String name)
	{
		setName(getContext(), name);
	}

	/**
	 * Set value of Name
	 * @param context
	 * @param name
	 */
	public final void setName(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String name)
	{
		getMendixObject().setValue(context, MemberNames.Name.toString(), name);
	}

	/**
	 * Set value of Password
	 * @param password
	 */
	public final void setPassword(java.lang.String password)
	{
		setPassword(getContext(), password);
	}

	/**
	 * Set value of Password
	 * @param context
	 * @param password
	 */
	public final void setPassword(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String password)
	{
		getMendixObject().setValue(context, MemberNames.Password.toString(), password);
	}

	/**
	 * @return value of LastLogin
	 */
	public final java.util.Date getLastLogin()
	{
		return getLastLogin(getContext());
	}

	/**
	 * @param context
	 * @return value of LastLogin
	 */
	public final java.util.Date getLastLogin(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.util.Date) getMendixObject().getValue(context, MemberNames.LastLogin.toString());
	}

	/**
	 * Set value of LastLogin
	 * @param lastlogin
	 */
	public final void setLastLogin(java.util.Date lastlogin)
	{
		setLastLogin(getContext(), lastlogin);
	}

	/**
	 * Set value of LastLogin
	 * @param context
	 * @param lastlogin
	 */
	public final void setLastLogin(com.mendix.systemwideinterfaces.core.IContext context, java.util.Date lastlogin)
	{
		getMendixObject().setValue(context, MemberNames.LastLogin.toString(), lastlogin);
	}

	/**
	 * @return value of Blocked
	 */
	public final java.lang.Boolean getBlocked()
	{
		return getBlocked(getContext());
	}

	/**
	 * @param context
	 * @return value of Blocked
	 */
	public final java.lang.Boolean getBlocked(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Boolean) getMendixObject().getValue(context, MemberNames.Blocked.toString());
	}

	/**
	 * Set value of Blocked
	 * @param blocked
	 */
	public final void setBlocked(java.lang.Boolean blocked)
	{
		setBlocked(getContext(), blocked);
	}

	/**
	 * Set value of Blocked
	 * @param context
	 * @param blocked
	 */
	public final void setBlocked(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Boolean blocked)
	{
		getMendixObject().setValue(context, MemberNames.Blocked.toString(), blocked);
	}

	/**
	 * @return value of Active
	 */
	public final java.lang.Boolean getActive()
	{
		return getActive(getContext());
	}

	/**
	 * @param context
	 * @return value of Active
	 */
	public final java.lang.Boolean getActive(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Boolean) getMendixObject().getValue(context, MemberNames.Active.toString());
	}

	/**
	 * Set value of Active
	 * @param active
	 */
	public final void setActive(java.lang.Boolean active)
	{
		setActive(getContext(), active);
	}

	/**
	 * Set value of Active
	 * @param context
	 * @param active
	 */
	public final void setActive(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Boolean active)
	{
		getMendixObject().setValue(context, MemberNames.Active.toString(), active);
	}

	/**
	 * @return value of FailedLogins
	 */
	public final java.lang.Integer getFailedLogins()
	{
		return getFailedLogins(getContext());
	}

	/**
	 * @param context
	 * @return value of FailedLogins
	 */
	public final java.lang.Integer getFailedLogins(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Integer) getMendixObject().getValue(context, MemberNames.FailedLogins.toString());
	}

	/**
	 * Set value of FailedLogins
	 * @param failedlogins
	 */
	public final void setFailedLogins(java.lang.Integer failedlogins)
	{
		setFailedLogins(getContext(), failedlogins);
	}

	/**
	 * Set value of FailedLogins
	 * @param context
	 * @param failedlogins
	 */
	public final void setFailedLogins(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Integer failedlogins)
	{
		getMendixObject().setValue(context, MemberNames.FailedLogins.toString(), failedlogins);
	}

	/**
	 * @return value of WebServiceUser
	 */
	public final java.lang.Boolean getWebServiceUser()
	{
		return getWebServiceUser(getContext());
	}

	/**
	 * @param context
	 * @return value of WebServiceUser
	 */
	public final java.lang.Boolean getWebServiceUser(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Boolean) getMendixObject().getValue(context, MemberNames.WebServiceUser.toString());
	}

	/**
	 * Set value of WebServiceUser
	 * @param webserviceuser
	 */
	public final void setWebServiceUser(java.lang.Boolean webserviceuser)
	{
		setWebServiceUser(getContext(), webserviceuser);
	}

	/**
	 * Set value of WebServiceUser
	 * @param context
	 * @param webserviceuser
	 */
	public final void setWebServiceUser(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Boolean webserviceuser)
	{
		getMendixObject().setValue(context, MemberNames.WebServiceUser.toString(), webserviceuser);
	}

	/**
	 * @return value of IsAnonymous
	 */
	public final java.lang.Boolean getIsAnonymous()
	{
		return getIsAnonymous(getContext());
	}

	/**
	 * @param context
	 * @return value of IsAnonymous
	 */
	public final java.lang.Boolean getIsAnonymous(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Boolean) getMendixObject().getValue(context, MemberNames.IsAnonymous.toString());
	}

	/**
	 * Set value of IsAnonymous
	 * @param isanonymous
	 */
	public final void setIsAnonymous(java.lang.Boolean isanonymous)
	{
		setIsAnonymous(getContext(), isanonymous);
	}

	/**
	 * Set value of IsAnonymous
	 * @param context
	 * @param isanonymous
	 */
	public final void setIsAnonymous(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Boolean isanonymous)
	{
		getMendixObject().setValue(context, MemberNames.IsAnonymous.toString(), isanonymous);
	}

	/**
	 * @return value of UserRoles
	 */
	public final java.util.List<system.proxies.UserRole> getUserRoles() throws com.mendix.core.CoreException
	{
		return getUserRoles(getContext());
	}

	/**
	 * @param context
	 * @return value of UserRoles
	 */
	@SuppressWarnings("unchecked")
	public final java.util.List<system.proxies.UserRole> getUserRoles(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		java.util.List<system.proxies.UserRole> result = new java.util.ArrayList<system.proxies.UserRole>();
		Object valueObject = getMendixObject().getValue(context, MemberNames.UserRoles.toString());
		if (valueObject == null)
			return result;
		for (com.mendix.systemwideinterfaces.core.IMendixObject mendixObject : com.mendix.core.Core.retrieveIdList(context, (java.util.List<com.mendix.systemwideinterfaces.core.IMendixIdentifier>) valueObject))
			result.add(system.proxies.UserRole.initialize(context, mendixObject));
		return result;
	}

	/**
	 * Set value of UserRoles
	 * @param userroles
	 */
	public final void setUserRoles(java.util.List<system.proxies.UserRole> userroles)
	{
		setUserRoles(getContext(), userroles);
	}

	/**
	 * Set value of UserRoles
	 * @param context
	 * @param userroles
	 */
	public final void setUserRoles(com.mendix.systemwideinterfaces.core.IContext context, java.util.List<system.proxies.UserRole> userroles)
	{
		java.util.List<com.mendix.systemwideinterfaces.core.IMendixIdentifier> identifiers = new java.util.ArrayList<com.mendix.systemwideinterfaces.core.IMendixIdentifier>();
		for (system.proxies.UserRole proxyObject : userroles)
			identifiers.add(proxyObject.getMendixObject().getId());
		getMendixObject().setValue(context, MemberNames.UserRoles.toString(), identifiers);
	}

	/**
	 * @return value of User_Language
	 */
	public final system.proxies.Language getUser_Language() throws com.mendix.core.CoreException
	{
		return getUser_Language(getContext());
	}

	/**
	 * @param context
	 * @return value of User_Language
	 */
	public final system.proxies.Language getUser_Language(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		system.proxies.Language result = null;
		com.mendix.systemwideinterfaces.core.IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.User_Language.toString());
		if (identifier != null)
			result = system.proxies.Language.load(context, identifier);
		return result;
	}

	/**
	 * Set value of User_Language
	 * @param user_language
	 */
	public final void setUser_Language(system.proxies.Language user_language)
	{
		setUser_Language(getContext(), user_language);
	}

	/**
	 * Set value of User_Language
	 * @param context
	 * @param user_language
	 */
	public final void setUser_Language(com.mendix.systemwideinterfaces.core.IContext context, system.proxies.Language user_language)
	{
		if (user_language == null)
			getMendixObject().setValue(context, MemberNames.User_Language.toString(), null);
		else
			getMendixObject().setValue(context, MemberNames.User_Language.toString(), user_language.getMendixObject().getId());
	}

	/**
	 * @return value of User_TimeZone
	 */
	public final system.proxies.TimeZone getUser_TimeZone() throws com.mendix.core.CoreException
	{
		return getUser_TimeZone(getContext());
	}

	/**
	 * @param context
	 * @return value of User_TimeZone
	 */
	public final system.proxies.TimeZone getUser_TimeZone(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		system.proxies.TimeZone result = null;
		com.mendix.systemwideinterfaces.core.IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.User_TimeZone.toString());
		if (identifier != null)
			result = system.proxies.TimeZone.load(context, identifier);
		return result;
	}

	/**
	 * Set value of User_TimeZone
	 * @param user_timezone
	 */
	public final void setUser_TimeZone(system.proxies.TimeZone user_timezone)
	{
		setUser_TimeZone(getContext(), user_timezone);
	}

	/**
	 * Set value of User_TimeZone
	 * @param context
	 * @param user_timezone
	 */
	public final void setUser_TimeZone(com.mendix.systemwideinterfaces.core.IContext context, system.proxies.TimeZone user_timezone)
	{
		if (user_timezone == null)
			getMendixObject().setValue(context, MemberNames.User_TimeZone.toString(), null);
		else
			getMendixObject().setValue(context, MemberNames.User_TimeZone.toString(), user_timezone.getMendixObject().getId());
	}

	/**
	 * @return the IMendixObject instance of this proxy for use in the Core interface.
	 */
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return userMendixObject;
	}

	/**
	 * @return the IContext instance of this proxy, or null if no IContext instance was specified at initialization.
	 */
	public final com.mendix.systemwideinterfaces.core.IContext getContext()
	{
		return context;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;

		if (obj != null && getClass().equals(obj.getClass()))
		{
			final system.proxies.User that = (system.proxies.User) obj;
			return getMendixObject().equals(that.getMendixObject());
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		return getMendixObject().hashCode();
	}

	/**
	 * @return String name of this class
	 */
	public static java.lang.String getType()
	{
		return "System.User";
	}

	/**
	 * @return String GUID from this object, format: ID_0000000000
	 * @deprecated Use getMendixObject().getId().toLong() to get a unique identifier for this object.
	 */
	@Deprecated
	public java.lang.String getGUID()
	{
		return "ID_" + getMendixObject().getId().toLong();
	}
}
