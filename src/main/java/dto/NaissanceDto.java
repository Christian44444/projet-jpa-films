package dto;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author cmich
 * Classe Naissance pour import JSON
 */
public class NaissanceDto {
//	/** s1 pour travailler la date - autre méthode ne faisant pas intervenir la redéfinition de la méthode jackson deserialize */
//  voir plus bas le setter de s1 avant mise en commentaire cela marche	
//	@JsonProperty("dateNaissance")
//	private String s1;
	
	
	/** dateNaissanceDate */
	@JsonDeserialize(using = CustonJsonDateDeserializer.class)
	private Date dateNaissance;
	/** lieuNaissance */
	private String lieuNaissance;
	
	/** Constructeur
	 * 
	 */
	public NaissanceDto() {
		super();
	}
	/**
	 * Renvoie l'objet sous forme de chaine de caractères
	 */
	@Override
	public String toString() {
		return "NaissanceDto [dateNaissance=" + dateNaissance + ", lieuNaissance=" + lieuNaissance + "]";
	}
	/** @return the dateNaissance */
	public Date getDateNaissance() {
		return dateNaissance;
	}
	/** @param dateNaissance the dateNaissance to set */
	public void setDateNaiss(Date dateNaissance) {
		this.dateNaissance = dateNaissance;  
	}
	/** @return the lieuNaissance */
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	/** @param lieuNaissance the lieuNaissance to set */
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
//	/** @return the s1 */
//	public String getS1() {
//		return s1;
//	}
//	/** @param s1 the s1 to set */
//	public void setS1(String s1) {
//		this.s1 = s1;
//		// not null
//		if (s1 != null) {
//			// les parties à 0
//			if (s1.indexOf("-0-") >= 0 || s1.endsWith("-0") || s1.startsWith("0-") ) {
//				return;
//			}	
//			// les entrées mois et jours sur 1 digit
//			String[] d1 = s1.split("-");
//			if (d1.length != 3) {
//				return;
//			}	
//			this.dateNaiss = new Date(Integer.parseInt(d1[0]) - 1900, Integer.parseInt(d1[1]) - 1, Integer.parseInt(d1[2]),0,0,0 );
//		}
//	}
}
