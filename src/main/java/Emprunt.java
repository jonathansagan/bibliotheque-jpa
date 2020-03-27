import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
// Table client
@Entity // obligatoire
@Table(name = "emprunt") // optionnel, si le nom de la Classe est différent de celui de la table

public class Emprunt {
	@Id // obligatoire = indique la clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY => pour les bases qui font AUTO_INCREMENT (MySQL,
														// MariaDB, ...)
	private Integer ID;
	private LocalDateTime DATE_DEBUT;
	private LocalDateTime  DATE_FIN;
	private Integer DELAI;
	private Integer ID_CLIENT;
	
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;

	@ManyToMany
	@JoinTable ( name = "compo", 
				joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"),
				inverseJoinColumns = @JoinColumn(name = "ID_EMP",referencedColumnName = "ID")
	)
	private Set<Livre> livre;
	
	/** Constructeur
	 * @param iD
	 * @param dATE_DEBUT
	 * @param dATE_FIN
	 * @param dELAI
	 * @param iD_CLIENT
	 */
	public Emprunt(Integer ID, LocalDateTime DATE_DEBUT, LocalDateTime DATE_FIN, Integer DELAI, Integer ID_CLIENT) {
		super();
		this.ID = ID;
		this.DATE_DEBUT = DATE_DEBUT;
		this.DATE_FIN = DATE_FIN;
		this.DELAI = DELAI;
		this.ID_CLIENT = ID_CLIENT;
	}
	public Emprunt() {
		
	}
	
	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		ID = ID;
	}

	public LocalDateTime getDATE_DEBUT() {
		return DATE_DEBUT;
	}

	public void setDATE_DEBUT(Date DATE_DEBUT) {
		DATE_DEBUT = DATE_DEBUT;
	}

	public LocalDateTime getDATE_FIN() {
		return DATE_FIN;
	}

	public void setDATE_FIN(Date DATE_FIN) {
		DATE_FIN = DATE_FIN;
	}

	public Integer getDELAI() {
		return DELAI;
	}

	public void setDELAI(Integer DELAI) {
		DELAI = DELAI;
	}

	public Integer getID_CLIENT() {
		return ID_CLIENT;
	}

	public void setID_CLIENT(Integer ID_CLIENT) {
		ID_CLIENT = ID_CLIENT;
	}
	
	
}
