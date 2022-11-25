package dto;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * @author cmich
 * Classe permettant de traiter les entiers valides d'une chaine du fichier JSON en excluant les invalides. 
 * Renvoi 0 en cas d'échec
 */
public class CustonJsonIntDeserializer extends JsonDeserializer<Integer> {

	/**
	 * Surdéfinition de la classe deserialize de jackson
	 */
	@Override
	public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		String intChaine = p.getText();
		try {
			return Integer.parseInt(intChaine);
		} catch (Exception e) {
			return 0;
		}
	}

}
