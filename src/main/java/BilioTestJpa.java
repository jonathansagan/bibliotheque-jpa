import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BilioTestJpa {
	
		private static final Logger LOGGER = Logger.getLogger(BilioTestJpa.class.getName());
		
		public static void main(String[] args) {	
	        // étape 1 - Configuration

	        // étape 2 - Construction de l'usine � EntityManager (EntityManagerFactory - vie durant toute l'application)
	        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");

	        // étape 3 - Obtention d'une instance d'EntityManager (id�alement dur�e de vie courte)
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        
	        // vérification que la connexion est ok
	        LOGGER.log(Level.INFO, "EntityManager : "+entityManager.isOpen());
	        if (entityManager.isOpen()== true) {
	        	System.out.println("la connexion est ok");
	        }
	     
	        // étape 5 - Fermeture EntityManager
	        // entityManager.close();

	        // A la fin de l'application, fermeture de l'EntityManagerFactory
	        // entityManagerFactory.close();

	}

}
