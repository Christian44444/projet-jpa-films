package dao;

import dto.ActeurDto;
import dto.CastingPrincipalDto;
import jpa.Acteur;

/**
 * @author cmich
 * Classe de manipulation des acteurs 
 */
public class ActeurDao extends TraitementDao {
	/** Transfère l'entité Dto sous forme de CastingPrincipal dans l'entité jpa 
	 * @param sCDto
	 * @return
	 */
	public static Acteur getActeur(CastingPrincipalDto sCDto) {
		if (sCDto == null) {
			return null;
		}
		Acteur a = cHashMapA.get(sCDto.getIdRef()); 
		if (a == null) {
			a = new Acteur();
			a.setIdRef(sCDto.getIdRef());
			a.setIdentite(sCDto.getIdentite());
			a.setNaissance(NaissanceDao.getNaissance(sCDto.getNaissance()));
			a.setUrl(sCDto.getUrl());
			a.setHeight(sCDto.getHeight());
			// pas de rôle à ce niveau là
			eM.persist(a);
			cHashMapA.put(sCDto.getIdRef(),a);
		}
		return a;
	}
	
	/** Transfère l'entité Dto sous forme d'Acteur dans l'entité jpa 
	 * @param sADto
	 * @return
	 */
	public static Acteur getActeur(ActeurDto sADto) {
		if (sADto == null) {
			return null;
		}
		Acteur a = cHashMapA.get(sADto.getIdRef()); 
		if (a == null) {
			a = new Acteur();
			a.setIdRef(sADto.getIdRef());
			a.setIdentite(sADto.getIdentite());
			a.setNaissance(NaissanceDao.getNaissance(sADto.getNaissance()));
			a.setUrl(sADto.getUrl());
			a.setHeight(sADto.getHeight());
			// pas de rôle à ce niveau là
			eM.persist(a);
			cHashMapA.put(sADto.getIdRef(),a);
		}
		return a;
	}
}
