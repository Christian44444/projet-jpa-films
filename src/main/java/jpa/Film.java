package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author cmich
 * Classe des films 
 */
/**
 * @author cmich
 * Classe des films pour la base de donnée
 */
@Entity
@Table(name = "film")
public class Film {
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, nullable = false)
	private Integer id;
	
	/** idRef */
	@Column(name = "idRef", length = 10, nullable = false, unique = true)
	private String  idRef;
	
	/** nom */
	@Column(name = "nom", length = 100, nullable = false)
	private String  nom;
	
	/** url */
	@Column(name = "url", length = 1000)
	private String  url;
	
	/** plot */
	@Column(name = "plot", columnDefinition = "TEXT")
	private String  plot;
	
	/** anneeSortie */
	@Column(name = "anneeSortie", columnDefinition = "YEAR")
	private int     anneeSortie;
	
	@ManyToOne
	@JoinColumn(name = "paysId")
	private Pays    pays;
	
	@Column(name = "langue", length = 50, nullable = true)
	private String  langue;
	
	@ManyToOne
	@JoinColumn(name = "lieuId")
	private Lieu    lieuTournage;
	
	@ManyToMany
	@JoinTable(name = "film_realisateur",
			   joinColumns = @JoinColumn(name = "filmId", referencedColumnName = "id"),
			   inverseJoinColumns = @JoinColumn(name = "realisateurId", referencedColumnName = "id"))
	private List<Realisateur> realisateurs = new ArrayList<Realisateur>();
	
	@ManyToMany
	@JoinTable(name = "film_acteur",
			   joinColumns = @JoinColumn(name = "filmId", referencedColumnName = "id"),
			   inverseJoinColumns = @JoinColumn(name = "acteurId", referencedColumnName = "id")) 
	private List<Acteur> acteurs = new ArrayList<Acteur>();
	
	@ManyToMany
	@JoinTable(name = "film_role",
			   joinColumns = @JoinColumn(name = "filmId", referencedColumnName = "id"),
			   inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "id")) 
	private List<Role> roles = new ArrayList<Role>();
	
	
	@ManyToMany
	@JoinTable(name = "film_genre",
			   joinColumns = @JoinColumn(name = "filmId", referencedColumnName = "id"),
			   inverseJoinColumns = @JoinColumn(name = "genreId", referencedColumnName = "id")) 
	private List<Genre> genres = new ArrayList<Genre>();
	
	/**
	 * Constructeur vide
	 */
	public Film() {
		super();
	}

	/**
	 * Renvoie l'objet sous forme de chaine de caractères
	 */
	@Override
	public String toString() {
		return "Film [id=" + id + ", idRef=" + idRef + ", nom=" + nom + ", url=" + url + ", plot=" + plot
				+ ", anneeSortie=" + anneeSortie + "]";
	}

	/** @return the id */
	public Integer getId() {
		return id;
	}

	/** @param id the id to set */
	public void setId(Integer id) {
		this.id = id;
	}

	/** @return the idRef */
	public String getIdRef() {
		return idRef;
	}

	/** @param idRef the idRef to set */
	public void setIdRef(String idRef) {
		this.idRef = idRef;
	}

	/** @return the nom */
	public String getNom() {
		return nom;
	}

	/** @param nom the nom to set */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** @return the url */
	public String getUrl() {
		return url;
	}

	/** @param url the url to set */
	public void setUrl(String url) {
		this.url = url;
	}

	/** @return the plot */
	public String getPlot() {
		return plot;
	}

	/** @param plot the plot to set */
	public void setPlot(String plot) {
		this.plot = plot;
	}

	/** @return the anneeSortie */
	public int getAnneeSortie() {
		return anneeSortie;
	}

	/** @param anneeSortie the anneeSortie to set */
	public void setAnneeSortie(int anneeSortie) {
		this.anneeSortie = anneeSortie;
	}

	/** @return the pays */
	public Pays getPays() {
		return pays;
	}

	/** @param pays the pays to set */
	public void setPays(Pays pays) {
		this.pays = pays;
	}

	/** @return the langue */
	public String getLangue() {
		return langue;
	}

	/** @param langue the langue to set */
	public void setLangue(String langue) {
		this.langue = langue;
	}

	/** @return the lieuTournage */
	public Lieu getLieuTournage() {
		return lieuTournage;
	}

	/** @param lieuTournage the lieuTournage to set */
	public void setLieuTournage(Lieu lieuTournage) {
		this.lieuTournage = lieuTournage;
	}

	/** @return the realisateurs */
	public List<Realisateur> getRealisateurs() {
		return realisateurs;
	}

	/** @return the acteurs */
	public List<Acteur> getActeurs() {
		return acteurs;
	}

	/** @return the roles */
	public List<Role> getRoles() {
		return roles;
	}

	/** @return the genres */
	public List<Genre> getGenres() {
		return genres;
	}


	
}
