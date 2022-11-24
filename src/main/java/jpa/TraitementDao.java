package jpa;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.persistence.EntityManager;
import dto.ActeurDto;
import dto.CastingPrincipalDto;
import dto.GenreDto;
import dto.NaissanceDto;
import dto.PaysDto;
import dto.RealisateurDto;
import dto.RoleDto;

/**
 * @author cmich
 *	Classe de méthodes permettant de traiter les objets pays avec la base
 */
public class TraitementDao {
	private static HashMap <String, Pays> cHashMap = new HashMap<String,Pays>();
	private static HashMap <String, Realisateur> cHashMapR = new HashMap<String,Realisateur>();
	private static HashMap <String, Acteur> cHashMapA = new HashMap<String,Acteur>();
	private static HashMap <String, Naissance> cHashMapN = new HashMap<String,Naissance>();
	private static HashMap <String, Lieu> cHashMapL = new HashMap<String, Lieu>();
	private static HashMap <String, Role> cHashMapRo = new HashMap<String,Role>();
	private static HashMap <String, Genre> cHashMapG = new HashMap<String,Genre>();
	/**
	 * Constructeur par défaut
	 */
	public TraitementDao() {
		super();
	}
	
	public static Pays getPays(EntityManager eM, PaysDto pDto) {
		// Permet dans un premier temps de récupérer un Pays
		if (pDto == null) {
			return null;
		}
		Pays p = cHashMap.get(pDto.getNom());
		if (p == null) {
			p = new Pays();
			p.setNom(pDto.getNom());
			p.setUrl(pDto.getUrl());
			eM.persist(p);
			cHashMap.put(pDto.getNom(), p);
		}
		return p; 
	}
	public static Pays getPays(EntityManager eM, String sPDto) {
		// Permet dans un premier temps de récupérer un Pays
		if (sPDto == null) {
			return null;
		}
		Pays p = cHashMap.get(sPDto);
		if (p == null) {
			p = new Pays();
			p.setNom(sPDto);
			p.setUrl(null);
			eM.persist(p);
			cHashMap.put(sPDto, p);
		}
		return p; 
	}
	public static Realisateur getRealisateur(EntityManager eM, RealisateurDto sRDto) {
		if (sRDto == null) {
			return null;
		}
		Realisateur r = cHashMapR.get(sRDto.getIdentite()); 
		if (r == null) {
			r = new Realisateur();
			r.setIdentite(sRDto.getIdentite());
			r.setUrl(sRDto.getUrl());
			eM.persist(r);
			cHashMapR.put(sRDto.getIdentite(),r);
		}
		return r;
	}
	public static Acteur getActeur(EntityManager eM, CastingPrincipalDto sCDto) {
		if (sCDto == null) {
			return null;
		}
		Acteur a = cHashMapA.get(sCDto.getIdRef()); 
		if (a == null) {
			a = new Acteur();
			a.setIdRef(sCDto.getIdRef());
			a.setIdentite(sCDto.getIdentite());
			a.setNaissance(getNaissance(eM, sCDto.getNaissance()));
			a.setUrl(sCDto.getUrl());
			a.setHeight(sCDto.getHeight());
			// pas de rôle à ce niveau là
			eM.persist(a);
			cHashMapA.put(sCDto.getIdRef(),a);
		}
		return a;
	}
	public static Acteur getActeur(EntityManager eM, ActeurDto sADto) {
		if (sADto == null) {
			return null;
		}
		Acteur a = cHashMapA.get(sADto.getIdRef()); 
		if (a == null) {
			a = new Acteur();
			a.setIdRef(sADto.getIdRef());
			a.setIdentite(sADto.getIdentite());
			a.setNaissance(getNaissance(eM, sADto.getNaissance()));
			a.setUrl(sADto.getUrl());
			a.setHeight(sADto.getHeight());
			// pas de rôle à ce niveau là
			eM.persist(a);
			cHashMapA.put(sADto.getIdRef(),a);
		}
		return a;
	}
	
	public static Role getRole(EntityManager eM, RoleDto sRDto) {
		if (sRDto == null) {
			return null;
		}
		// Construction d'un champ d'unicité charactername,idRef(acteur),film
		StringBuilder sB = new StringBuilder();
		if (sRDto.getCharacterName() == null) {
			sB.append("null");
		} else {
			sB.append(sRDto.getCharacterName());
		}
		sB.append(",");
		if (sRDto.getActeur() == null || sRDto.getActeur().getIdRef() == null) {
			sB.append("null"); 
		} else {
			sB.append(sRDto.getActeur().getIdRef());
		} 
		sB.append(",");
		if (sRDto.getIdRef() == null) {
			sB.append("null");
		} else {
			sB.append(sRDto.getIdRef());
		} 
		
		if (sB.toString() == "null,null,null") {
			return null;
		}
		Role r = cHashMapRo.get(sB.toString());  
		if (r == null) {
			r = new Role();
			r.setCharacterName(sRDto.getCharacterName());
			r.setActeur(TraitementDao.getActeur(eM, sRDto.getActeur()));
			r.setIdRef(sRDto.getIdRef());
			// Pas de rôle à ce niveau
			eM.persist(r);
			cHashMapRo.put(sB.toString(),r);
		}
		return r;
	}
	
	public static Naissance getNaissance(EntityManager eM, NaissanceDto sNDto) {
		StringBuilder sRecherche = new StringBuilder(); 
		SimpleDateFormat f = new SimpleDateFormat("aaaa-MM-dd");

		if (sNDto == null) {
			return null;
		}
		if (sNDto.getDateNaissance() == null && (sNDto.getLieuNaissance() == null || sNDto.getLieuNaissance().equals("") )){
			return null; // il n'y a rien de renseigné, cela ne sert à rien de créer
		}
		// Traitement de la Date de naissance à part 
		String sD = "";
		if (sNDto.getDateNaissance() == null) {
			sD = "null";
		} else {
			sD = f.format(sNDto.getDateNaissance());
		}		
		
		
		// Pour le lieu on essaye de faire au mieux pour découper
		String s1 = sNDto.getLieuNaissance();
		String sVille = "";
		String sEtatDept = "";
		String sPays = "null";
		String[] sStrings = s1.split(",",-1);
		
		// On vire les blancs
		for (int i = 0; i < sStrings.length; i++) {
			sStrings[i].trim();
		}
		// On gère les cas de découpage du Lieu
		if (sStrings.length >= 3) {
			// ville en dernier -2, etatDept en dernier -1, Pays dernier
			sVille = sStrings[sStrings.length -3];
			sRecherche.append(sVille);
			sRecherche.append(","); 

			sEtatDept = sStrings[sStrings.length -2];
			sRecherche.append(sEtatDept);
			sRecherche.append(","); 
			
			sPays = sStrings[sStrings.length -1];
			Pays p = TraitementDao.getPays(eM, sStrings[sStrings.length -1]);
			if (p != null) {
				sRecherche.append(sPays);
			} else {
				sRecherche.append("null");
			}
		} else if (sStrings.length == 2) {
			// On décide ville et Pays
			sVille = sStrings[0];
			sRecherche.append(sVille);
			sRecherche.append(","); 
			sEtatDept = "";
			sRecherche.append(",");
			sPays = sStrings[sStrings.length -1];
			Pays p = TraitementDao.getPays(eM, sStrings[sStrings.length -1]);
			if (p != null) {
				sRecherche.append(sPays);
			} else {
				sRecherche.append("null");
			}
		} else if (sStrings.length == 1) {
			// On décide pays seul
			sVille = "";
			sRecherche.append(","); 
			sEtatDept = "";
			sRecherche.append(",");
			sPays = sStrings[sStrings.length -1];
			Pays p = TraitementDao.getPays(eM, sStrings[sStrings.length -1]);
			if (p != null) {
				sRecherche.append(sPays);
			} else {
				sRecherche.append("null");
			}
		} 
			
		Naissance n = cHashMapN.get(sD + "," + sRecherche);
		if (n == null) {
			// Création du lieu et date de naissance
			n = new Naissance();
			n.setDateNaiss(sNDto.getDateNaissance());
			// Création ou récupération du lieu si il existe rappel ville|etatDept|pays
			if (sRecherche.toString().endsWith(",,null") || sRecherche.toString().endsWith(",,") ) {
				n.setLieuNaissance(null);
			} else {
				
				n.setLieuNaissance(TraitementDao.getLieu(eM, sRecherche.toString()));
			}
			eM.persist(n);
		}
		return n;
	}
	public static Lieu getLieu(EntityManager eM, String sLDto) {
		// Permet dans un premier temps de récupérer un String séparé par des ","
		if (sLDto == null) {
			return null;
		}
		// On découpe la chaine
		String[] sLieu = sLDto.split(",",-1);
		if (sLieu.length == 0) {
			return null;
		}
		Lieu l = cHashMapL.get(sLDto);
		
		if (l == null) {
			l = new Lieu();
			l.setVille(sLieu[0]);
			l.setEtatDept(sLieu[1]);
			if (sLieu[2] == "null") {
				l.setPays(null);
			} else {
				l.setPays(getPays(eM, sLieu[2]));
			}
			eM.persist(l);
			cHashMapL.put(sLDto, l);
		}
		return l; 
	}
	public static Genre getGenre(EntityManager eM, GenreDto gDto) {
		// Permet dans un premier temps de récupérer un genre
		if (gDto == null) {
			return null;
		}
		Genre g = cHashMapG.get(gDto.getLibelle());
		if (g == null) {
			g = new Genre();
			g.setLibelle(gDto.getLibelle());
			eM.persist(g);
			cHashMapG.put(gDto.getLibelle(), g);
		}
		return g; 
	}

	
}
