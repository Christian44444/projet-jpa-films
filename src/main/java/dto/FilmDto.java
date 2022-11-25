package dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author cmich
 * Classe des films pour import JSON
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmDto {
	/** idRef */
	@JsonProperty("id")
	private String  idRef;
	/** pays */
	private PaysDto pays;
	/** nom */
	private String  nom;
	/** url */
	private String  url;
	/** plot */
	private String  plot;
	/** langue */
	private String  langue;
	/** lieuTournage */
	private LieuDto lieuTournage;
	/** realisateurs */
	private List<RealisateurDto> realisateurs;
	/** castingPrincipaux */
	@JsonProperty("castingPrincipal")
	private List<CastingPrincipalDto> castingPrincipaux; 
	/** anneeSortie */
	@JsonDeserialize(using = CustonJsonIntDeserializer.class)
	private int     anneeSortie;
	/** roles */
	private List<RoleDto> roles; 
	/** genres */
	private List<GenreDto> genres;
	
	/**
	 * Constructeur vide
	 */
	public FilmDto() {
		super();
	}

	/**
	 * Renvoie l'objet sous forme de chaine de caractères
	 */
	@Override
	public String toString() {
		return "FilmDto [idRef=" + idRef + ", pays=" + pays + ", nom=" + nom + ", url=" + url + ", plot=" + plot
				+ ", langue=" + langue + ", lieuTournage=" + lieuTournage + ", realisateurs=" + realisateurs
				+ ", castingPrincipaux=" + castingPrincipaux + ", anneeSortie=" + anneeSortie + ", roles=" + roles
				+ ", genres=" + genres + "]";
	}

	/** @return the idRef */
	public String getIdRef() {
		return idRef;
	}

	/** @param idRef the idRef to set */
	public void setIdRef(String idRef) {
		this.idRef = idRef;
	}

	/** @return the pays */
	public PaysDto getPays() {
		return pays;
	}

	/** @param pays the pays to set */
	public void setPays(PaysDto pays) {
		this.pays = pays;
	}

	/** @return the nom */
	public String getNom() {
		return nom;
	}

	/** @param nom the nom to set */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** @return the url */
	public String getUrl() {
		return url;
	}

	/** @param url the url to set */
	public void setUrl(String url) {
		this.url = url;
	}

	/** @return the plot */
	public String getPlot() {
		return plot;
	}

	/** @param plot the plot to set */
	public void setPlot(String plot) {
		this.plot = plot;
	}

	/** @return the langue */
	public String getLangue() {
		return langue;
	}

	/** @param langue the langue to set */
	public void setLangue(String langue) {
		this.langue = langue;
	}

	/** @return the lieuTournage */
	public LieuDto getLieuTournage() {
		return lieuTournage;
	}

	/** @param lieuTournage the lieuTournage to set */
	public void setLieuTournage(LieuDto lieuTournage) {
		this.lieuTournage = lieuTournage;
	}

	/** @return the realisateurs */
	public List<RealisateurDto> getRealisateurs() {
		return realisateurs;
	}

	/** @param realisateurs the realisateurs to set */
	public void setRealisateurs(List<RealisateurDto> realisateurs) {
		this.realisateurs = realisateurs;
	}

	/** @return the castingPrincipaux */
	public List<CastingPrincipalDto> getCastingPrincipaux() {
		return castingPrincipaux;
	}

	/** @param castingPrincipaux the castingPrincipaux to set */
	public void setCastingPrincipaux(List<CastingPrincipalDto> castingPrincipaux) {
		this.castingPrincipaux = castingPrincipaux;
	}

	/** @return the anneeSortie */
	public int getAnneeSortie() {
		return anneeSortie;
	}

	/** @param anneeSortie the anneeSortie to set */
	public void setAnneeSortie(int anneeSortie) {
		this.anneeSortie = anneeSortie;
	}

	/** @return the roles */
	public List<RoleDto> getRoles() {
		return roles;
	}

	/** @param roles the roles to set */
	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}

	/** @return the genres */
	public List<GenreDto> getGenres() {
		return genres;
	}

	/** @param genres the genres to set */
	public void setGenres(List<GenreDto> genres) {
		this.genres = genres;
	}
}
