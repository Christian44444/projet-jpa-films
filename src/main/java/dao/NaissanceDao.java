package dao;

import java.text.SimpleDateFormat;

import dto.NaissanceDto;
import jpa.Naissance;
import jpa.Pays;

/**
 * @author cmich
 * Classe de manipulation des naissances
 */
public class NaissanceDao extends TraitementDao {
	/** Transfère l'entité Dto dans l'entité jpa 
	 * @param sNDto
	 * @return
	 */
	public static Naissance getNaissance(NaissanceDto sNDto) {
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
			Pays p = PaysDao.getPays(sStrings[sStrings.length -1]);
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
			Pays p = PaysDao.getPays(sStrings[sStrings.length -1]);
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
			Pays p = PaysDao.getPays(sStrings[sStrings.length -1]);
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
				
				n.setLieuNaissance(LieuDao.getLieu(sRecherche.toString()));
			}
			eM.persist(n);
		}
		return n;
	}

}
