package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author cmich
 * Classe des pays pour la base de donnée
 */
@Entity
@Table(name = "pays")
public class Pays {
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, nullable = false)
	private Integer id;
	
	/** Nom du pays */
	@Column(name = "nom", length = 100, nullable = false)
	private String nom;
	
	/** url de l'entité sur le site */
	@Column(name = "url", columnDefinition = "TEXT")
	private String url;
	
	/** films */
	@OneToMany(mappedBy = "pays")
	private List<Film> films = new ArrayList<Film>();
	
	/**
	 * Constructeur vide
	 */
	public Pays() {
		super();
	}
	
	/**
	 * Renvoie l'objet sous forme de chaine de caractères 
	 */
	@Override
	public String toString() {
		return "PaysDto [nom=" + nom + ", url=" + url + "]";
	}
	
	/** @return the id */
	public Integer getId() {
		return id;
	}
	
	/** @param id the id to set */
	public void setId(Integer id) {
		this.id = id;
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
	
	/** @return the films */
	public List<Film> getFilms() {
		return films;
	}
}
