package nl.cge.wicket.aantekeningen.domein;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dossier implements Serializable {
	private static final long serialVersionUID = 1L;

	private String kenmerk;
	private String type;
	private List<Aantekening> aantekeningen = new ArrayList<Aantekening>();
	
	public String getKenmerk() {
		return kenmerk;
	}
	public void setKenmerk(String kenmerk) {
		this.kenmerk = kenmerk;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Aantekening> getAantekeningen() {
		return aantekeningen;
	}
	public void setAantekeningen(List<Aantekening> aantekeningen) {
		this.aantekeningen = aantekeningen;
	}
	public void addAantekening(Aantekening aantekening) {
		aantekening.setDossier(this);
		aantekeningen.add(aantekening);
	}
	public Aantekening createAantekening() {
		Aantekening aantekening = new Aantekening();
		aantekening.setDossier(this);
		return aantekening;
	}
	
	

}
