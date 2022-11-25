package dao;

import java.util.List;


import dto.CastingPrincipalDto;
import dto.FilmDto;
import dto.GenreDto;
import dto.LieuDto;
import dto.RealisateurDto;
import dto.RoleDto;
import jpa.Acteur;
import jpa.Film;
import jpa.Genre;
import jpa.Lieu;
import jpa.Pays;
import jpa.Realisateur;
import jpa.Role;

/**
 * @author cmich
 * Classe de manipulation des films 
 */
public class FilmDao extends TraitementDao{
	private Film f1;  
	private Lieu l1;
	private LieuDto lDto1;
	private List<RealisateurDto> lRealisateurDtos;
	private Realisateur r1;
	private List<CastingPrincipalDto> lCastingPrincipalDtos;
	private Acteur a1;
	private List<RoleDto> lRoleDtos;
	private Role ro1; 
	private List<GenreDto> lGenreDtos;
	private Genre g1; 
	
	/** Transfère l'entité Dto dans l'entité jpa 
	 * @param filmDto
	 */
	public void getFilm(FilmDto filmDto) {
		f1 = new Film();
		f1.setIdRef(filmDto.getIdRef());
		f1.setNom(filmDto.getNom());
		f1.setUrl(filmDto.getUrl());
		f1.setPlot(filmDto.getPlot());
		f1.setPays(PaysDao.getPays(filmDto.getPays()));
		f1.setLangue(filmDto.getLangue());
		// traitement du lieu en string pour homogénisation avec Lieu de naissance
		lDto1 = filmDto.getLieuTournage();
		if (lDto1 != null) {
			// On va traiter le lieu en chaine de caractères
			StringBuilder sB = new StringBuilder();
			Pays pL;
			if (lDto1.getVille() == null) {
				sB.append("");
			} else {
				sB.append(lDto1.getVille());
			}
			sB.append(",");
			if (lDto1.getEtatDept() == null) {
				sB.append("");
			} else {
				sB.append(lDto1.getEtatDept());
			}
			sB.append(",");
			if (lDto1.getPays() == null ) {
				sB.append("null");
			} else {
				pL = PaysDao.getPays(lDto1.getPays());
				sB.append(pL.getNom());
			}
			l1 = new Lieu();
			if (sB.toString().endsWith(",,null")) {
				l1 = null;
			} else {
				l1 = LieuDao.getLieu(sB.toString());
			} 
			eM.persist(l1);	
			f1.setLieuTournage(l1);
		}
		// traitement des réalisateurs
		lRealisateurDtos = filmDto.getRealisateurs();
		for (RealisateurDto realisateurDto : lRealisateurDtos) {
			if (realisateurDto != null) {
				r1 = RealisateurDao.getRealisateur(realisateurDto);
				eM.persist(r1);
				f1.getRealisateurs().add(r1);
			}
		}
		// traitement des acteurs (pour le casting principal)
		lCastingPrincipalDtos = filmDto.getCastingPrincipaux();
		for (CastingPrincipalDto castingPrincipalDto : lCastingPrincipalDtos) {
			if (castingPrincipalDto != null) {
				a1 = ActeurDao.getActeur(castingPrincipalDto);
				eM.persist(a1);
				f1.getActeurs().add(a1);
			}
		}
		lRoleDtos = filmDto.getRoles();
		for (RoleDto roleDto : lRoleDtos) {
			if (roleDto != null) {
				ro1 = RoleDao.getRole(roleDto);
				eM.persist(ro1);
				f1.getRoles().add(ro1);
			}
		}
		lGenreDtos = filmDto.getGenres();
		for (GenreDto genreDto : lGenreDtos) {
			if (genreDto != null) {
				g1 = GenreDao.getGenre(genreDto);
				eM.persist(g1);
				f1.getGenres().add(g1);
			}
		}
		eM.persist(f1);

	}
	
}
