package film;

/**
 * @author cmich
 * Classe exécutable Lanceur de l'appication projet-jpa-films
 * A partir d'un fichier JSON extrait d'un site de notation de films : Imdb 
 * insertion en base "films" de type MySQL 
 */
public class Apllication {

	/**
	 * Point d'entrée de l'application
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Service s1 = new Service();
		s1.traitementFichier("./src/main/resources/films.json");
	}

}
