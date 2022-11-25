package dao;


import dto.PaysDto;
import jpa.Pays;

/**
 * @author cmich
 * Classe de manipulation des pays 
 */
public class PaysDao extends TraitementDao{
	/** Transfère l'entité Dto dans l'entité jpa 
	 * @param eM
	 * @param cHashMap
	 * @param pDto
	 * @return
	 */
	public static Pays getPays(PaysDto pDto) {
		// Permet dans un premier temps de récupérer un Pays
		if (pDto == null) {
			return null;
		}
		Pays p = cHashMapP.get(pDto.getNom());
		if (p == null) {
			p = new Pays();
			p.setNom(pDto.getNom());
			p.setUrl(pDto.getUrl());
			eM.persist(p);
			cHashMapP.put(pDto.getNom(), p);
		}
		return p; 
	}
	/** Transfère l'entité Dto sous forme de String dans l'entité jpa 
	 * @param eM
	 * @param cHashMap
	 * @param sPDto
	 * @return
	 */
	public static Pays getPays(String sPDto) {
		// Permet dans un premier temps de récupérer un Pays
		if (sPDto == null) {
			return null;
		}
		Pays p = cHashMapP.get(sPDto);
		if (p == null) {
			p = new Pays();
			p.setNom(sPDto);
			p.setUrl(null);
			eM.persist(p);
			cHashMapP.put(sPDto, p);
		}
		return p; 
	}
	
}
