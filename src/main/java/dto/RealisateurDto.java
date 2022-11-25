package dto;

/**
* RealisateurDto.java
* Classe pour import JSON
*/
public class RealisateurDto {
	/**
	 * identite
	 */
	private String identite;
	/**
	 * url
	 */
	private String url;
	
	/**
	 * Constructeur
	 */
	public RealisateurDto() {
		super();
	}
	
	/**
	 * Renvoie l'objet sous forme de chaine de caractères
	 */
	@Override
	public String toString() {
		return "RealisateurDto [identite=" + identite + ", url=" + url + "]";
	}
	
	/** @return the identite */
	public String getIdentite() {
		return identite;
	}
	
	/** @param identite the identite to set */
	public void setIdentite(String identite) {
		this.identite = identite;
	}
	
	/** @return the url */
	public String getUrl() {
		return url;
	}
	
	/** @param url the url to set */
	public void setUrl(String url) {
		this.url = url;
	}
}
