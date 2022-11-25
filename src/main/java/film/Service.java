package film;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.FilmDao;
import dao.TraitementDao;
import dto.FilmDto;

/**
 * @author cmich
 *	Classe d'import du fichier json 
 */
public class Service {
	/** sdf1 pour traitement des dates au format aaaa-MM-dd */
	private SimpleDateFormat sdf1;
	/** m1 */
	private ObjectMapper m1;
	/** filmDtos liste des objets film à traiter individuellement */
	private List<FilmDto> filmDtos;
	/** eMF */
	private EntityManagerFactory eMF;
	/** eM */
	private EntityManager eM;
	/** trans transaction unitaire au niveau d'un film */
	private EntityTransaction trans;
	
	
	
	/** Constructeur
	 * 
	 */
	public Service() {
		super();
	}

	/**
	 * Traitement du fichier JSON pour insertion en base de données via jpa
	 * @param jSonFile
	 * @throws Exception
	 * 
	 */
	public void traitementFichier(String jSonFile) throws Exception {
		sdf1 = new SimpleDateFormat("aaaa-MM-dd");
		m1 = new ObjectMapper();
		m1.setDateFormat(sdf1);
		filmDtos = m1.readValue(new File(jSonFile), new TypeReference<List<FilmDto>>() {});
		
		
		eMF = Persistence.createEntityManagerFactory("films");
		eM = eMF.createEntityManager();
		trans = eM.getTransaction();
		
		TraitementDao.seteM(eM);
		
		FilmDao filmDao = new FilmDao();
		// Parcours des films json pour traitement jpa et insersion en base 
		for (FilmDto filmDto : filmDtos) {
			trans.begin();
			filmDao.getFilm(filmDto);
			trans.commit();
		}

	}

	/** @return the sdf1 */
	public SimpleDateFormat getSdf1() {
		return sdf1;
	}

	/** @param sdf1 the sdf1 to set */
	public void setSdf1(SimpleDateFormat sdf1) {
		this.sdf1 = sdf1;
	}

	/** @return the m1 */
	public ObjectMapper getM1() {
		return m1;
	}

	/** @param m1 the m1 to set */
	public void setM1(ObjectMapper m1) {
		this.m1 = m1;
	}

	/** @return the filmDtos */
	public List<FilmDto> getFilmDtos() {
		return filmDtos;
	}

	/** @param filmDtos the filmDtos to set */
	public void setFilmDtos(List<FilmDto> filmDtos) {
		this.filmDtos = filmDtos;
	}

	/** @return the eMF */
	public EntityManagerFactory geteMF() {
		return eMF;
	}

	/** @param eMF the eMF to set */
	public void seteMF(EntityManagerFactory eMF) {
		this.eMF = eMF;
	}

	/** @return the eM */
	public EntityManager geteM() {
		return eM;
	}

	/** @param eM the eM to set */
	public void seteM(EntityManager eM) {
		this.eM = eM;
	}

	/** @return the trans */
	public EntityTransaction getTrans() {
		return trans;
	}

	/** @param trans the trans to set */
	public void setTrans(EntityTransaction trans) {
		this.trans = trans;
	}
	
}
