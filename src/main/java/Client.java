import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// Table client
@Entity // obligatoire
@Table(name = "client") // optionnel, si le nom de la Classe est différent de celui de la table

public class Client {
	@Id // obligatoire = indique la clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY => pour les bases qui font AUTO_INCREMENT (MySQL,
														// MariaDB, ...)
	private Integer ID;
	private String NOM;
	private String PRENOM;
	
	@OneToMany(mappedBy="client")
	private Set<Emprunt> emprunts; // référence vers les livres
	public Client() {
	emprunts = new HashSet<Emprunt>();
	}
	
	/** Constructeur
	 * @param ID
	 * @param NOM
	 * @param PRENOM
	 */
	public Client(Integer ID, String NOM, String PRENOM) {
		this.ID = ID;
		this.NOM = NOM;
		this.PRENOM = PRENOM;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		ID = ID;
	}

	public String getNOM() {
		return NOM;
	}

	public void setNOM(String NOM) {
		NOM = NOM;
	}

	public String getPRENOM() {
		return PRENOM;
	}

	public void setPRENOM(String PRENOM) {
		PRENOM = PRENOM;
	}

	@Override
	public String toString() {
		return "Client [ID=" + ID + ", NOM=" + NOM + ", PRENOM=" + PRENOM + "]";
	}

}
