package jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
* RealisateurDto.java
* Classe des réalisateurs pour la base de donnée
*/
@Entity
@Table(name = "realisateur")
public class Realisateur extends Personne {

	/** Constructeur
	 * 
	 */
	public Realisateur() {
		super();
	}
}
