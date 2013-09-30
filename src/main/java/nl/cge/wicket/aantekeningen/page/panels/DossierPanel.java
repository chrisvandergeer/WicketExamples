package nl.cge.wicket.aantekeningen.page.panels;

import java.util.List;

import nl.cge.wicket.aantekeningen.domein.Aangifte;
import nl.cge.wicket.aantekeningen.domein.Dossier;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public abstract class DossierPanel extends Panel {
	private static final long serialVersionUID = 1L;
	
	public DossierPanel(String id, IModel<Aangifte> aangifteModel) {
		super(id, aangifteModel);
		add(newDossierListView("dossierList", aangifteModel.getObject().getDossierList()));
	}	
	
	private ListView<Dossier> newDossierListView(String id, List<Dossier> dossiers) {
		ListView<Dossier> list = new ListView<Dossier>(id, Model.ofList(dossiers)) {
			private static final long serialVersionUID = 1L;
			@Override
			protected void populateItem(final ListItem<Dossier> item) {
				final Dossier dossier = item.getModelObject();
				item.add(new Label("kenmerk", new PropertyModel<String>(dossier, "kenmerk")));
				item.add(new Label("type", new PropertyModel<String>(dossier, "type")));
				item.add(newNieuweAantekeningLink(item));
			}
		};
		return list;
	}

	private AjaxFallbackLink<Dossier> newNieuweAantekeningLink(final ListItem<Dossier> item) {
		return new AjaxFallbackLink<Dossier>("nieuweAantekening", item.getModel()) {
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick(AjaxRequestTarget target) {
				newAantekeningClicked(item.getModel(), target);
			}
		};
	}

	abstract protected void newAantekeningClicked(IModel<Dossier> dossierModel, AjaxRequestTarget target);
}
