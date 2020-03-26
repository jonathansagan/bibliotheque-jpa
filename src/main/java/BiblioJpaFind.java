import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class BiblioJpaFind {
	private static final Logger LOGGER = Logger.getLogger(BiblioJpaFind.class.getName());

	public static void main(String[] args) {

		// étape 2 - Construction de l'usine à EntityManager (EntityManagerFactory - vie
		// durant toute l'application)
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblio_essai");

		// étape 3 - Obtention d'une instance d'EntityManager (idéalement durée de vie
		// courte)
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// vérification que la connexion est ok
		LOGGER.log(Level.INFO, "EntityManager : " + entityManager.isOpen());
		if (entityManager.isOpen() == true) {
			System.out.println("la connexion est ok");
		}

		// étape 4 - utilisation de l'EntityManager pour échanger avec la base de
		// données - ici livre avec id 1
		Livre livre1 = entityManager.find(Livre.class, 1);

		LOGGER.log(Level.INFO, "nom du livre avec l'id 1 : " + livre1.getTITRE()+ " - "+ livre1.getAUTEUR());
		
		// Récupération d'un livre par son titre
		TypedQuery<Livre> query = entityManager.createQuery("SELECT l FROM Livre l WHERE l.TITRE='Germinal'",Livre.class);
		List<Livre> livre2 = query.getResultList();
		LOGGER.log(Level.INFO, "livre germinal : " + livre2);
		
				
				
		// étape 5 - Fermeture EntityManager
		entityManager.close();

		// A la fin de l'application, fermeture de l'EntityManagerFactory
		entityManagerFactory.close();

	}

}
