package dao;

import java.util.HashMap;
import javax.persistence.EntityManager;
import jpa.Acteur;
import jpa.Genre;
import jpa.Lieu;
import jpa.Naissance;
import jpa.Pays;
import jpa.Realisateur;
import jpa.Role;

/**
 * @author cmich
 *	Classe Mère des classes Dao pour traitement des objets jpa et chargement dans les HashMap dédiées
 */
public class TraitementDao {
	protected static HashMap <String, Pays> cHashMapP = new HashMap<String,Pays>();
	protected static HashMap <String, Realisateur> cHashMapR = new HashMap<String,Realisateur>();
	protected static HashMap <String, Acteur> cHashMapA = new HashMap<String,Acteur>();
	protected static HashMap <String, Naissance> cHashMapN = new HashMap<String,Naissance>();
	protected static HashMap <String, Lieu> cHashMapL = new HashMap<String, Lieu>();
	protected static HashMap <String, Role> cHashMapRo = new HashMap<String,Role>();
	protected static HashMap <String, Genre> cHashMapG = new HashMap<String,Genre>();
	protected static EntityManager eM; 
	/**
	 * Constructeur par défaut
	 */
	public TraitementDao() {
		super();
	}

	/** @param eM the eM to set */
	public static void seteM(EntityManager eM) {
		TraitementDao.eM = eM;
	}
}
