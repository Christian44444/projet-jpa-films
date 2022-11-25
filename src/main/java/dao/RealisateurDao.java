package dao;

import dto.RealisateurDto;
import jpa.Realisateur;
/**
 * @author cmich
 * Classe de manipulation des réalisateurs 
 */
public class RealisateurDao extends TraitementDao {
	
	/** Transfère l'entité Dto dans l'entité jpa 
	 * @param sRDto
	 * @return
	 */
	public static Realisateur getRealisateur(RealisateurDto sRDto) {
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

}
