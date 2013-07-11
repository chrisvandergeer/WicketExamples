package nl.cge.wicket.page.radio;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class Adresgegevens implements Serializable {
	private static final long serialVersionUID = 3026533970396620485L;
	
	private Adres woonadres;
	private Adres postadres;
	private Adres notarisadres;
	
	public static Adresgegevens dummy() {
		Adresgegevens adresgegevens = new Adresgegevens();
		adresgegevens.setNotarisadres(Adres.create("Vlietweg", 42, "7335JE", "Apeldoorn"));
		adresgegevens.setPostadres(Adres.create("Fuutweg", 1, "7334AS", "Apeldoorn"));
		adresgegevens.setWoonadres(Adres.create("Fuutweg", 1, "7334AS", "Apeldoorn"));
		return adresgegevens;
	}
	
	public List<Adres> getAdressen() {
		return Arrays.asList(new Adres[] { woonadres, postadres, notarisadres });
	}
	
}
