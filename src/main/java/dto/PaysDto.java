package dto;

/**
 * @author cmich
 * Classe des pays pour import JSON
 */
public class PaysDto {
	/**
	 * Nom du pays
	 */
	private String nom;
	/**
	 * url de l'entité sur le site
	 */
	private String url;
	
	/**
	 * Constructeur vide
	 */
	public PaysDto() {
		super();
	}
	/**
	 * Renvoie l'objet sous forme de chaine de caractères 
	 */
	@Override
	public String toString() {
		return "PaysDto [nom=" + nom + ", url=" + url + "]";
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
}
