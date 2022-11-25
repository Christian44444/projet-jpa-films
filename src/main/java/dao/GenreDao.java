package dao;

import dto.GenreDto;
import jpa.Genre;

/**
 * @author cmich
 * Classe de manipulation des genres de films
 */
public class GenreDao extends TraitementDao {
	/** Transfère l'entité Dto dans l'entité jpa 
	 * @param gDto
	 * @return
	 */
	public static Genre getGenre(GenreDto gDto) {
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
