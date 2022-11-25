package jpa;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


/**
* Realisateur.java
* Classe mère des acteurs et réalisateurs la base de donnée
*/
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "personne")
public class Personne {
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, nullable = false)
	private Integer id;
	
	/** identite */
	@Column(name = "identite", length = 100, nullable = false)
	private String identite;

	/** url */
	@Column(name = "url", length = 1000, nullable = true)
	private String url;
	
	/**
	 * Constructeur
	 */
	public Personne() {
		super();
	}
	
	/**
	 * Renvoie l'objet sous forme de chaine de caractères
	 */
	@Override
	public String toString() {
		return "Personne [identite=" + identite + ", url=" + url + "]";
	}
	
	/** @return the identite */
	public String getIdentite() {
		return identite;
	}
	
	/** @param identite the identite to set */
	public void setIdentite(String identite) {
		this.identite = identite;
	}
	 
	/** @return the url */
	public String getUrl() {
		return url;
	}
	
	/** @param url the url to set */
	public void setUrl(String url) {
		this.url = url;
	}
}
