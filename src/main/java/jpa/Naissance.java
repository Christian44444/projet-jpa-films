package jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author cmich
 * Classe Naissance pour la base de données
 */
@Entity
@Table(name = "naissance")
public class Naissance {
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, nullable = false)
	private Integer id;
	
	/** dateNaissanceDate */
	@Column(name = "dateNaissane")
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	/** lieuNaissance */
	@ManyToOne
	@JoinColumn(name = "lieuId")
	private Lieu lieuNaissance;
	
	/** acteurs */
	@OneToMany(mappedBy = "naissance")
	private List<Acteur> acteurs = new ArrayList<Acteur>();

	/** Constructeur
	 * 
	 */
	public Naissance() {
		super();
	}
	
	/**
	 * Renvoie l'objet sous forme de chaine de caractères
	 */
	@Override
	public String toString() {
		return "Naissance [dateNaissance=" + dateNaissance + ", lieuNaissance=" + lieuNaissance + "]";
	}
	
	/** @return the dateNaissance */
	public Date getDateNaissance() {
		return dateNaissance;
	}
	
	/** @param dateNaissance the dateNaissance to set */
	public void setDateNaiss(Date dateNaissance) {
		this.dateNaissance = dateNaissance;  
	}
	
	/** @return the lieuNaissance */
	public Lieu getLieuNaissance() {
		return lieuNaissance;
	}
	
	/** @param lieuNaissance the lieuNaissance to set */
	public void setLieuNaissance(Lieu lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
}
