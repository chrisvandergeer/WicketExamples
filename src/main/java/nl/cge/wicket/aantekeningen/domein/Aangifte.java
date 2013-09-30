package nl.cge.wicket.aantekeningen.domein;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Aangifte implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Dossier> dossierList = new ArrayList<Dossier>();

	public List<Dossier> getDossierList() {
		return dossierList;
	}

	public void setDossierList(List<Dossier> dossierList) {
		this.dossierList = dossierList;
	}

	public List<Aantekening> getAantekeningen() {
		List<Aantekening> list = new ArrayList<Aantekening>();
		for (Dossier dossier : dossierList) {
			for (Aantekening aantekening : dossier.getAantekeningen()) {
				list.add(aantekening);
			}
		}
		return list;
	}

}
