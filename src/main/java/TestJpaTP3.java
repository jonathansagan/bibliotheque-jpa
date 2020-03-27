import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestJpaTP3 {
	private static final Logger LOGGER = Logger.getLogger(TestJpaTP3.class.getName());

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblio_essai");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		// vérification que la connexion est ok
		LOGGER.log(Level.INFO, "EntityManager : " + entityManager.isOpen());
		if (entityManager.isOpen() == true) {
			System.out.println("la connexion est ok");
		}
		// liste de livres pour un emprunt
		TypedQuery<Emprunt> createQuery2 = entityManager.createQuery("SELECT e FROM Emprunt e",Emprunt.class);
		       List<Emprunt> resultList = createQuery2.getResultList();

		       for (Emprunt emprunt : resultList) {
		    	   System.out.println(emprunt);
	       }
		    // extraire tous les emprunts d'un client donné
		       Client client1 = entityManager.find(Client.class, 2);
		       System.out.println(client1.getEmprunts());
		
		
		// étape 5 - Fermeture EntityManager
				entityManager.close();

		// A la fin de l'application, fermeture de l'EntityManagerFactory
				entityManagerFactory.close();
	}

}
