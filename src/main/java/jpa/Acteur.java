package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author cmich
 * Classe des acteurs pour la base de données
 */
@Entity
@Table(name = "Acteur")
public class Acteur extends Personne {
	/** idRef */
	@Column(name = "idRef", length = 10, nullable = false, unique = true)
	private String idRef;
	
	/** naissance */
	@ManyToOne
	@JoinColumn(name = "naissanceId")
	private Naissance naissance;
	
	/** height */
	@Column(name = "height",  precision = 2)
	private double height;
	
	/** roles */
	@OneToMany(mappedBy = "acteur")
	private List<Role> roles = new ArrayList<Role>();

	/** Constructeur
	 * 
	 */
	public Acteur() {
		super();
	}
	
	/**
	 * Renvoie l'objet sous forme de chaine de caractères
	 */
	@Override
	public String toString() {
		return "Acteur [idRef=" + idRef + ", height=" + height + "]";
	}

	/** @return the idRef */
	public String getIdRef() {
		return idRef;
	}
	
	/** @param idRef the idRef to set */
	public void setIdRef(String idRef) {
		this.idRef = idRef;
	}
	
	/** @return the naissance */
	public Naissance getNaissance() {
		return naissance;
	}
	
	/** @param naissance the naissance to set */
	public void setNaissance(Naissance naissance) {
		this.naissance = naissance;
	}
	
	/** @return the height */
	public double getHeight() {
		return height;
	}
	
	/** @param height the height to set */
	public void setHeight(double height) {
		this.height = height;
	}
	/** @return the roles */
	public List<Role> getRoles() {
		return roles;
	}
}
