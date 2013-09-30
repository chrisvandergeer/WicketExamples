package nl.cge.wicket.aantekeningen.service;

import nl.cge.wicket.aantekeningen.domein.Aangifte;

public class AangifteService {
	
	public static Aangifte read() {
		Aangifte aangifte = new Aangifte();
		aangifte.setDossierList(DossierService.findAll());
		return aangifte;
	}

}
