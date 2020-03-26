import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
// Table client
@Entity // obligatoire
@Table(name = "compo") // optionnel, si le nom de la Classe est différent de celui de la table

public class Compo {
	@Id // obligatoire = indique la clé primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY)// IDENTITY => pour les bases qui font AUTO_INCREMENT (MySQL, MariaDB, ...)
	private Integer ID;
	private String ID_LIV;
	private String ID_EMP;
	
	@ManyToMany
	@JoinTable(name="compo",
	joinColumns=@JoinColumn(name="ID_EMP", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_LIV", referencedColumnName=
	"ID")
	)
	private Set<Livre> livres;
	
	/** Constructeur
	 * @param iD
	 * @param iD_LIV
	 * @param iD_EMP
	 */
	public Compo(Integer ID, String ID_LIV, String ID_EMP) {
		this.ID = ID;
		this.ID_LIV = ID_LIV;
		this.ID_EMP = ID_EMP;
	}
	
	public Compo() {
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		ID = ID;
	}

	public String getID_LIV() {
		return ID_LIV;
	}

	public void setID_LIV(String ID_LIV) {
		ID_LIV = ID_LIV;
	}

	public String getID_EMP() {
		return ID_EMP;
	}

	public void setID_EMP(String ID_EMP) {
		ID_EMP = ID_EMP;
	}
	
	

}
