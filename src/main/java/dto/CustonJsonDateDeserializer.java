package dto;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustonJsonDateDeserializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-M-d");
		String dateChaine = p.getText();
		try {
			return format.parse(dateChaine);
		} catch (Exception e) {
			return null;
		}
	}

}
