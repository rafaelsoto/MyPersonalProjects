package br.gov.demoiselle.internal.factory;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.slf4j.Logger;

import br.gov.demoiselle.annontation.AuditEntityManager;
import br.gov.demoiselle.internal.proxy.EntityManagerProxy;

public class AuditEntityManagerFactory {

	@Inject
	private Logger logger;

	@Produces
	@AuditEntityManager
	@SessionScoped
	public EntityManager create() {
		String persistenceUnitName = "audit";
		javax.persistence.EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);

		EntityManager entityManager = emf.createEntityManager();
		this.logger.debug("Entity manager was created with \"" + persistenceUnitName + "\" persistence unit");

		return new EntityManagerProxy(entityManager);
	}

	public void destroy(@Disposes @AuditEntityManager final EntityManager entityManager) {
		entityManager.close();
		this.logger.debug("Entity manager was closed");
	}

}
