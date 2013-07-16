package nl.cge.wicket.page.radio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Adres implements Serializable {
	private static final long serialVersionUID = 3746981288653588952L;

	private String straat;
	private int huisnummer;
	private String postcode;
	private String plaats;
	
	public boolean isLeeg() {
		return straat == null || "".equals(straat.trim());
	}
	
	public static Adres create(String straat, int huisnummer, String postcode, String plaats) {
		Adres adres = new Adres();
		adres.setStraat(straat);
		adres.setHuisnummer(huisnummer);
		adres.setPostcode(postcode);
		adres.setPlaats(plaats);
		return adres;
	}
	
	public static List<Adres> findAll() {
		List<Adres> adressen = new ArrayList<Adres>();
		adressen.add(create("Vlietweg", 42, "7335JE", "Apeldoorn"));
		adressen.add(create("Kalverstraat", 1, "1234AA", "Amsterdam"));
		adressen.add(create("Neude", 2, "2345QQ", "Utrecht"));
		return adressen;
	}
	
	public static List<Adres> getAdressen() {
		List<Adres> findAll = findAll();
		findAll.add(new Adres());
		return findAll;
	}

}
