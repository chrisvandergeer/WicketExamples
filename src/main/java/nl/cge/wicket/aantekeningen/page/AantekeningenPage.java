package nl.cge.wicket.aantekeningen.page;

import nl.cge.wicket.aantekeningen.domein.Aangifte;
import nl.cge.wicket.aantekeningen.domein.Dossier;
import nl.cge.wicket.aantekeningen.page.panels.AantekeningenPanel;
import nl.cge.wicket.aantekeningen.page.panels.AantekeningformPanel;
import nl.cge.wicket.aantekeningen.page.panels.DossierPanel;
import nl.cge.wicket.aantekeningen.service.AangifteService;
import nl.cge.wicket.bootstrap.BootstrapPage;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class AantekeningenPage extends BootstrapPage {
	private static final long serialVersionUID = 1L;
	
	private AantekeningformPanel aantekeningformPanel;
	
	public AantekeningenPage() {
		Aangifte aangifte = AangifteService.read();
		Model<Aangifte> aangifteModel = Model.of(aangifte);		
		add(newAantekeningFormPanel());
		add(newDossierPanel(aangifteModel));
		add(new AantekeningenPanel("aantekeningen", aangifteModel));
	}

	private AantekeningformPanel newAantekeningFormPanel() {
		aantekeningformPanel = new AantekeningformPanel("aantekengingForm");
		return aantekeningformPanel;
	}

	private DossierPanel newDossierPanel(Model<Aangifte> aangifteModel) {
		return new DossierPanel("dossiers", aangifteModel) {
			private static final long serialVersionUID = 1L;
			@Override
			protected void newAantekeningClicked(IModel<Dossier> model, AjaxRequestTarget target) {
				aantekeningformPanel.setModelObject(model.getObject().createAantekening());
				aantekeningformPanel.setVisible(true);
				target.add(aantekeningformPanel);
			}
		};
	}

}
