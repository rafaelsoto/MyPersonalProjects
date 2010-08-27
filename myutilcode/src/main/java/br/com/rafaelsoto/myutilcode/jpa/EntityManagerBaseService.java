package br.com.rafaelsoto.myutilcode.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;

/**
 * A Class EntityManagerBaseService.
 * 
 * @author rafael
 * @version ${svn_version}
 */
public abstract class EntityManagerBaseService implements EntityManager {

	Logger log = Logger.getLogger(EntityManagerBaseService.class);
	
	/** O em. */
	private EntityManager em;
	

	protected static EntityManagerBaseService myself = null;
	
	/**
	 * Create a new entity manager by persistence unit.
	 * 
	 * @param persistenceUnitName o persistence unit name
	 */
	public EntityManagerBaseService(String persistenceUnitName)
	{
		log.info("Create a entitymanager by persistence unit " + persistenceUnitName);
		this.em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
		log.info("EntityManager was created");
	}
	
	

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#clear()
	 */
	public void clear() {
		
		this.em.clear();
		
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#close()
	 */
	public void close() {
		
		this.em.close();
		
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#contains(java.lang.Object)
	 */
	public boolean contains(Object entity) {
	
		return this.em.contains(entity);
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#createNamedQuery(java.lang.String)
	 */
	public Query createNamedQuery(String query) {
		
		return this.em.createNamedQuery(query);
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#createNativeQuery(java.lang.String, java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public Query createNativeQuery(String arg0, Class arg1) {
		
		return this.em.createNativeQuery(arg0, arg1);
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#createNativeQuery(java.lang.String)
	 */
	public Query createNativeQuery(String arg0) {
	
		return this.em.createNativeQuery(arg0);
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#find(java.lang.Class, java.lang.Object)
	 */
	public <T> T find(Class<T> arg0, Object arg1) {
	
		return this.em.find(arg0, arg1);
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#flush()
	 */
	public void flush() {
		
		this.em.flush();
		
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#getDelegate()
	 */
	public Object getDelegate() {
		
		return this.em.getDelegate();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#getFlushMode()
	 */
	public FlushModeType getFlushMode() {
	
		return this.em.getFlushMode();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#getReference(java.lang.Class, java.lang.Object)
	 */
	public <T> T getReference(Class<T> arg0, Object arg1) {
		
		return this.em.getReference(arg0, arg1);
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#getTransaction()
	 */
	public EntityTransaction getTransaction() {
		
		return this.em.getTransaction();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#isOpen()
	 */
	public boolean isOpen() {
		
		return this.em.isOpen();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#joinTransaction()
	 */
	public void joinTransaction() {
		
		this.em.joinTransaction();
		
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#lock(java.lang.Object, javax.persistence.LockModeType)
	 */
	public void lock(Object arg0, LockModeType arg1) {
		
		this.em.lock(arg0, arg1);
		
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#merge(java.lang.Object)
	 */
	public <T> T merge(T arg0) {
		
		return this.em.merge(arg0);
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#persist(java.lang.Object)
	 */
	public void persist(Object arg0) {
		
		this.em.persist(arg0);
		
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#refresh(java.lang.Object)
	 */
	public void refresh(Object arg0) {
		
		this.em.refresh(arg0);
		
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#remove(java.lang.Object)
	 */
	public void remove(Object arg0) {
		
		this.em.remove(arg0);
		
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#setFlushMode(javax.persistence.FlushModeType)
	 */
	public void setFlushMode(FlushModeType arg0) {
	
		this.em.setFlushMode(arg0);
		
	}
	
	public Query createNativeQuery(String sqlString, String resultSetMapping) {
		
		return this.em.createNativeQuery(sqlString, resultSetMapping); 
	}

	public Query createQuery(String qlString) {
		
		return this.em.createQuery(qlString);

	}
	
}
