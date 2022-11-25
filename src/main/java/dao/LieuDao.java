package dao;

import jpa.Lieu;

/**
 * @author cmich
 * Classe de manipulation des lieux
 */
public class LieuDao extends TraitementDao {
	/** Transfère l'entité Dto dans l'entité jpa 
	 * @param sLDto
	 * @return
	 */
	public static Lieu getLieu(String sLDto) {
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
				l.setPays(PaysDao.getPays(sLieu[2]));
			}
			eM.persist(l);
			cHashMapL.put(sLDto, l);
		}
		return l; 
	}
}
