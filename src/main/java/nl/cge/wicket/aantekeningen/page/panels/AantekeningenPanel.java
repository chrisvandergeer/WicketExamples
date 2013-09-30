package nl.cge.wicket.aantekeningen.page.panels;

import java.util.List;

import nl.cge.wicket.aantekeningen.domein.Aangifte;
import nl.cge.wicket.aantekeningen.domein.Aantekening;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class AantekeningenPanel extends Panel {
	private static final long serialVersionUID = 1L;
	
	private ListView<Aantekening> listview;
	private IModel<Aangifte> aangifteModel;

	public AantekeningenPanel(String id, IModel<Aangifte> aangifteModel) {
		super(id);
		this.aangifteModel = aangifteModel;
		add(newAantekeningList("aantekeningenList", aangifteModel.getObject().getAantekeningen()));
	}

	private ListView<Aantekening> newAantekeningList(String id, List<Aantekening> aantekeningen) {
		listview = new ListView<Aantekening>(id, Model.ofList(aantekeningen)) {
			private static final long serialVersionUID = 1L;
			@Override
			protected void populateItem(ListItem<Aantekening> item) {
				Aantekening aantekening = item.getModelObject();
				item.add(new Label("kenmerk", new PropertyModel<String>(aantekening.getDossier(), "kenmerk")));
				item.add(new Label("tekst", new PropertyModel<String>(aantekening, "tekst")));				
			}			
		};
		return listview;
	}
	
	@Override
	protected void onBeforeRender() {
		listview.setModelObject(aangifteModel.getObject().getAantekeningen());
		super.onBeforeRender();
	}

}
