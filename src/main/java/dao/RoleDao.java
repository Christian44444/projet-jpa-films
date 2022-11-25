package dao;

import dto.RoleDto;
import jpa.Role;

/**
 * @author cmich
 * Classe de manipulation des rôles
 */
public class RoleDao extends TraitementDao {
	/** Transfère l'entité Dto dans l'entité jpa 
	 * @param sRDto
	 * @return
	 */
	public static Role getRole(RoleDto sRDto) {
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
			r.setActeur(ActeurDao.getActeur(sRDto.getActeur()));
			r.setIdRef(sRDto.getIdRef());
			// Pas de rôle à ce niveau
			eM.persist(r);
			cHashMapRo.put(sB.toString(),r);
		}
		return r;
	}
}
