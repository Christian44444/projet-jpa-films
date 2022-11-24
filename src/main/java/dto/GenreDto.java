package dto;

/**
 * @author cmich
 * Classe des genres des films pour import JSON 
 */
public class GenreDto {
	/** libelle */
	private String libelle;

	/** Constructeur
	 * 
	 */
	public GenreDto() {
		super();
	}
	
	/** Constructeur
	 * @param libelle spécificité de jackson qui peut découper un [] de chaines en plusieurs objets chaines
	 */
	public GenreDto(String libelle) {
		super();
		this.libelle = libelle;
	}


	/**
	 * Renvoie l'objet sous forme de chaine de caractères
	 */
	@Override
	public String toString() {
		return "GenreDto [libelle=" + libelle + "]";
	}

	/** @return the libelle */
	public String getLibelle() {
		return libelle;
	}

	/** @param libelle the libelle to set */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
