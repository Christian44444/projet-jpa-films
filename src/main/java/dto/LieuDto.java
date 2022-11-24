package dto;

/**
 * @author cmich
 * Lieu de tournage ou de naissance pour import JSON
 */
public class LieuDto {
	/**
	 * Ville du lieu
	 */
	private String ville;
	/**
	 * Etat région de la ville
	 */
	private String etatDept;
	/**
	 * Pays de la ville
	 */
	// TODO voir si nécessaire de mapper avec PaysDto
	private String pays;
	
	
	/**
	 * Constructeur
	 */
	public LieuDto() {
		super();
	}
	
	
	/**
	 * Renvoie l'objet sous forme de chaine de caractères
	 */
	@Override
	public String toString() {
		return "LieuDto [ville=" + ville + ", etatDept=" + etatDept + ", pays=" + pays + "]";
	}


	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * @return the etatDept
	 */
	public String getEtatDept() {
		return etatDept;
	}
	/**
	 * @param etatDept the etatDept to set
	 */
	public void setEtatDept(String etatDept) {
		this.etatDept = etatDept;
	}
	/**
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}
	/**
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
}
