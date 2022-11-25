package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author cmich
 * Classe des rôles pour import JSON
 */
public class RoleDto {
	/** characterName */
	private String characterName;
	/** acteur */
	private ActeurDto acteur;
	/** idRef */
	@JsonProperty("film")
	private String idRef;
	
	/** Constructeur
	 * 
	 */
	public RoleDto() {
		super();
	}
	
	/**
	 * Renvoie l'objet sous forme de chaine de caractères
	 */
	@Override
	public String toString() {
		return "RoleDto [characterName=" + characterName + ", acteur=" + acteur + ", idRef=" + idRef + "]";
	}
	
	/** @return the characterName */
	public String getCharacterName() {
		return characterName;
	}
	/** @param characterName the characterName to set */
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	/** @return the acteur */
	public ActeurDto getActeur() {
		return acteur;
	}
	/** @param acteur the acteur to set */
	public void setActeur(ActeurDto acteur) {
		this.acteur = acteur;
	}
	/** @return the idRef */
	public String getIdRef() {
		return idRef;
	}
	/** @param idRef the idRef to set */
	public void setIdRef(String idRef) {
		this.idRef = idRef;
	}
}
