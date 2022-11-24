package jpa;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author cmich
 * Classe des rôles pour la base de données
 */
@Entity
@Table(name = "role")
public class Role {
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, nullable = false)
	private Integer id;
	
	/** characterName */
	@Column(name = "characterName", length = 255, nullable = false)
	private String characterName;
	
	/** acteur */
	@ManyToOne
	@JoinColumn(name = "acteurId")
	private Acteur acteur;
	
	/** idRef */
	private String idRef;
	
	/** Constructeur
	 * 
	 */
	public Role() {
		super();
	}
	/**
	 * Renvoie l'objet sous forme de chaine de caractères
	 */
	@Override
	public String toString() {
		return "Role [characterName=" + characterName + ", idRef=" + idRef + "]";
	}
	/** @return the id */
	public Integer getId() {
		return id;
	}
	/** @param id the id to set */
	public void setId(Integer id) {
		this.id = id;
	}
	/** @return the characterName */
	public String getCharacterName() {
		return characterName;
	}
	/** @param characterName the characterName to set */
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	/** @return the idRef */
	public String getIdRef() {
		return idRef;
	}
	/** @param idRef the idRef to set */
	public void setIdRef(String idRef) {
		this.idRef = idRef;
	}
	/** @return the acteurs */
	public Acteur getActeur() {
		return acteur;
	}
	/** @param acteur the acteur to set */
	public void setActeur(Acteur acteur) {
		this.acteur = acteur;
	}
	
	
}
