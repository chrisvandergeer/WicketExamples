package nl.cge.wicket.page.radio;

import java.io.Serializable;

import lombok.Data;

@Data
public class Adres implements Serializable {
	private static final long serialVersionUID = 3746981288653588952L;

	private String straat;
	private int huisnummer;
	private String postcode;
	private String plaats;
	
	public static Adres create(String straat, int huisnummer, String postcode, String plaats) {
		Adres adres = new Adres();
		adres.setStraat(straat);
		adres.setHuisnummer(huisnummer);
		adres.setPostcode(postcode);
		adres.setPlaats(plaats);
		return adres;
	}

}
