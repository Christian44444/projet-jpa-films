package jpa;

import java.util.ArrayList;
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

/**
 * @author cmich
 * Lieu de tournage ou de naissance pour import JSON
 */
@Entity
@Table(name = "lieu")
public class Lieu {
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, nullable = false)
	private Integer id;
	
	/** Ville du lieu */
	@Column(name = "ville", length = 120, nullable = true)
	private String ville;
	
	/** Etat région de la ville */
	@Column(name = "etatDept", length = 120, nullable = true)
	private String etatDept;
	
	/** Pays de la ville */
	@ManyToOne
	@JoinColumn(name = "paysId")
	private Pays pays;
	
	/** naissances */
	@OneToMany(mappedBy = "lieuNaissance")
	private List<Naissance> naissances = new ArrayList<Naissance>();
	
	/** films */
	@OneToMany(mappedBy = "lieuTournage")
	private List<Film> films = new ArrayList<Film>();
	
	/**
	 * Constructeur
	 */
	public Lieu() {
		super();
	}
	
	/**
	 * Renvoie l'objet sous forme de chaine de caractères
	 */
	@Override
	public String toString() {
		return "LieuDto [ville=" + ville + ", etatDept=" + etatDept + ", pays=" + pays + "]";
	}
	
	/** @return the id */
	public Integer getId() {
		return id;
	}

	/** @param id the id to set */
	public void setId(Integer id) {
		this.id = id;
	}

	/** @return the ville */
	public String getVille() {
		return ville;
	}
	
	/** @param ville the ville to set */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	/** @return the etatDept */
	public String getEtatDept() {
		return etatDept;
	}
	
	/** @param etatDept the etatDept to set */
	public void setEtatDept(String etatDept) {
		this.etatDept = etatDept;
	}
	
	/** @return the pays */
	public Pays getPays() {
		return pays;
	}
	
	/** @param pays the pays to set */
	public void setPays(Pays pays) {
		this.pays = pays;
	}

	/** @return the naissances */
	public List<Naissance> getNaissances() {
		return naissances;
	}
}
