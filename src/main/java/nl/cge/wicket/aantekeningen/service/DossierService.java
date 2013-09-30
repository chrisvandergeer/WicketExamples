package nl.cge.wicket.aantekeningen.service;

import java.util.ArrayList;
import java.util.List;

import nl.cge.wicket.aantekeningen.domein.Aantekening;
import nl.cge.wicket.aantekeningen.domein.Dossier;

public class DossierService {
	
	private static List<Dossier> dossierList = new ArrayList<Dossier>();
	static {
		dossierList.add(create("BZ-35551", "Toezicht"));
		dossierList.add(create("VZ-30228", "Verzoek", "Gebeld met indiener, maar geen gehoor"));
		dossierList.add(create("BZ-30227", "Bezwaar"));
		dossierList.add(create("BZ-20811", "Bezwaar", "Dit is een aantekening over ..."));
	}
	
	private static Dossier create(String kenmerk, String type) {
		Dossier dossier = new Dossier();
		dossier.setKenmerk(kenmerk);
		dossier.setType(type);
		return dossier;
	}
	
	private static Dossier create(String kenmerk, String type, String aantekening) {
		Dossier dossier = create(kenmerk, type);
		dossier.addAantekening(Aantekening.create(aantekening));
		return dossier;
	}

	public static List<Dossier> findAll() {
		return new ArrayList<Dossier>(dossierList);
	}

	public void save(Aantekening aantekening) {
		
	}

}
