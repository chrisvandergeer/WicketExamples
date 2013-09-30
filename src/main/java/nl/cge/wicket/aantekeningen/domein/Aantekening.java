package nl.cge.wicket.aantekeningen.domein;

import java.io.Serializable;

public class Aantekening implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String tekst;
	private Dossier dossier;

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public Dossier getDossier() {
		return dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}

	public static Aantekening create(String aantekening) {
		Aantekening a = new Aantekening();
		a.setTekst(aantekening);
		return a;
	}

}
