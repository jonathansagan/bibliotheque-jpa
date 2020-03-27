import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

// Table livre
	@Entity // obligatoire
	@Table(name = "livre") // optionnel, si le nom de la Classe est différent de celui de la table


public class Livre {
		
	@Id // obligatoire = indique la clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY)// IDENTITY => pour les bases qui font AUTO_INCREMENT (MySQL, MariaDB, ...)
	private Integer ID;
	private String TITRE;
	private String AUTEUR;
	
	@ManyToMany(mappedBy = "livre")
	private List<Emprunt> emprunt;
	
	/** Constructeur
	 * @param ID
	 * @param TITRE
	 * @param AUTEUR
	 */
	public Livre(Integer ID, String TITRE, String AUTEUR) {
		this.ID = ID;
		this.TITRE = TITRE;
		this.AUTEUR = AUTEUR;
	}
	
	// tjs mettre un constructeur vide, = contrainte imposée par JPA
	public Livre() {
		
	}
	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		ID = ID;
	}

	public String getTITRE() {
		return TITRE;
	}

	public void setTITRE(String TITRE) {
		TITRE = TITRE;
	}

	public String getAUTEUR() {
		return AUTEUR;
	}

	public void setAUTEUR(String AUTEUR) {
		AUTEUR = AUTEUR;
	}

	@Override
	public String toString() {
		return "Livre [ID=" + ID + ", TITRE=" + TITRE + ", AUTEUR=" + AUTEUR + "]";
	}
	
	public List<Emprunt> getEmprunt() {
		return emprunt;
	}
	
	


}
