package dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author cmich
 * Classe castingPrincipal pour import JSON	
 */
public class CastingPrincipalDto {
	/** idRef */
	@JsonProperty("id")
	private String idRef;
	/** identite */
	private String identite;
	/** naissance */
	private NaissanceDto naissance;
	/** url */
	private String url;
	/** height */
	private double height;
	/** roles */
	private List<RoleDto> roles;
	/** Constructeur
	 *  
	 */
	public CastingPrincipalDto() {
		super();
	}
	/**
	 * Renvoie l'objet sous forme de chaine de caractères
	 */
	@Override
	public String toString() {
		return "castingPrincipalDto [idRef=" + idRef + ", identite=" + identite + ", naissance=" + naissance + ", url="
				+ url + ", height=" + height + ", roles=" + roles + "]";
	}
	/** @return the idRef */
	public String getIdRef() {
		return idRef;
	}
	/** @param idRef the idRef to set */
	public void setIdRef(String idRef) {
		this.idRef = idRef;
	}
	/** @return the identite */
	public String getIdentite() {
		return identite;
	}
	/** @param identite the identite to set */
	public void setIdentite(String identite) {
		this.identite = identite;
	}
	/** @return the naissance */
	public NaissanceDto getNaissance() {
		return naissance;
	}
	/** @param naissance the naissance to set */
	public void setNaissance(NaissanceDto naissance) {
		this.naissance = naissance;
	}
	/** @return the url */
	public String getUrl() {
		return url;
	}
	/** @param url the url to set */
	public void setUrl(String url) {
		this.url = url;
	}
	/** @return the height */
	public double getHeight() {
		return height;
	}
	/** @param height the height to set */
	public void setHeight(double height) {
		this.height = height;
	}
	/** @return the roles */
	public List<RoleDto> getRoles() {
		return roles;
	}
	/** @param roles the roles to set */
	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}
	
	
	
	
}
