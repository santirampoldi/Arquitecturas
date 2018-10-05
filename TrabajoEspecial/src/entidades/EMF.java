package entidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class EMF implements ServletContextListener {
	private static EntityManagerFactory emf;

	public void contextInitialized(ServletContextEvent arg0) {
		emf = Persistence.createEntityManagerFactory("TrabajoEspecial-ApacheDerby");
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		emf.close();
	}

	public static EntityManager createEntityManager() {
		new Persistence();
		//		if (emf == null) {
		//			throw new IllegalStateException("Context is not initialized yet.");
		//		}
		emf = Persistence.createEntityManagerFactory("TrabajoEspecial-ApacheDerby");
		return emf.createEntityManager();
	}
}