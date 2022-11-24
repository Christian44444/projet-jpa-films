package dto;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jpa.Acteur;
import jpa.Film;
import jpa.Genre;
import jpa.Lieu;
import jpa.Pays;
import jpa.TraitementDao;
import jpa.Realisateur;
import jpa.Role;


public class Apllication {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("aaaa-MM-dd");
		
		ObjectMapper m1 = new ObjectMapper();
		m1.setDateFormat(sdf1);
		List<FilmDto> filmDtos = m1.readValue(new File("./src/main/resources/films.json"), new TypeReference<List<FilmDto>>() {});
		
		// Génération des tables et renseignement des données
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("films");
		EntityManager eM = eMF.createEntityManager();
		EntityTransaction trans = eM.getTransaction();
		
		Film f1;  
		Lieu l1;
		LieuDto lDto1;
		List<RealisateurDto> lRealisateurDtos;
		Realisateur r1;
		List<CastingPrincipalDto> lCastingPrincipalDtos;
		Acteur a1;
		List<RoleDto> lRoleDtos;
		Role ro1; 
		List<GenreDto> lGenreDtos;
		Genre g1; 
		for (FilmDto filmDto : filmDtos) {
			trans.begin();
			f1 = new Film();
			f1.setIdRef(filmDto.getIdRef());
			f1.setNom(filmDto.getNom());
			f1.setUrl(filmDto.getUrl());
			f1.setPlot(filmDto.getPlot());
			f1.setPays(TraitementDao.getPays(eM, filmDto.getPays()));
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
					pL = TraitementDao.getPays(eM, lDto1.getPays());
					sB.append(pL.getNom());
				}
				l1 = new Lieu();
				if (sB.toString().endsWith(",,null")) {
					l1 = null;
				} else {
					l1 = TraitementDao.getLieu(eM, sB.toString());
				} 
				eM.persist(l1);	
				f1.setLieuTournage(l1);
			}
			// traitement des réalisateurs
			lRealisateurDtos = filmDto.getRealisateurs();
			for (RealisateurDto realisateurDto : lRealisateurDtos) {
				if (realisateurDto != null) {
					r1 = TraitementDao.getRealisateur(eM, realisateurDto);
					eM.persist(r1);
					f1.getRealisateurs().add(r1);
				}
			}
			// traitement des acteurs (pour le casting principal)
			lCastingPrincipalDtos = filmDto.getCastingPrincipaux();
			for (CastingPrincipalDto castingPrincipalDto : lCastingPrincipalDtos) {
				if (castingPrincipalDto != null) {
					a1 = TraitementDao.getActeur(eM, castingPrincipalDto);
					eM.persist(a1);
					f1.getActeurs().add(a1);
				}
			}
			lRoleDtos = filmDto.getRoles();
			for (RoleDto roleDto : lRoleDtos) {
				if (roleDto != null) {
					ro1 = TraitementDao.getRole(eM, roleDto);
					eM.persist(ro1);
					f1.getRoles().add(ro1);
				}
			}
			lGenreDtos = filmDto.getGenres();
			for (GenreDto genreDto : lGenreDtos) {
				if (genreDto != null) {
					g1 = TraitementDao.getGenre(eM, genreDto);
					eM.persist(g1);
					f1.getGenres().add(g1);
				}
			}
			eM.persist(f1);
			trans.commit();
			//System.out.println(filmDto);
		}
	}

}
