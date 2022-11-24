package jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author cmich
 * Classe des genres des films pour la base de données 
 */
@Entity
@Table(name = "genre")
public class Genre {
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 11, nullable = false)
	private Integer id;
	
	/** libelle */
	@Column(name = "libelle", length = 50, nullable = false, unique = true )
	private String libelle;

	/** Constructeur
	 * 
	 */
	public Genre() {
		super();
	}
	
	/** Constructeur
	 * @param libelle spécificité de jackson qui peut découper un [] de chaines en plusieurs objets chaines
	 */
	public Genre(String libelle) {
		super();
		this.libelle = libelle;
	}


	/**
	 * Renvoie l'objet sous forme de chaine de caractères
	 */
	@Override
	public String toString() {
		return "GenreDto [libelle=" + libelle + "]";
	}

	/** @return the libelle */
	public String getLibelle() {
		return libelle;
	}

	/** @param libelle the libelle to set */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
