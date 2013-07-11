package nl.cge.wicket.page.radio;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

public class AdresPanel extends Panel {
	private static final long serialVersionUID = -6455858355659652781L;

	public AdresPanel(String id, CompoundPropertyModel<Adres> model) {
		super(id, model);
		add(new TextField<String>("straat"));
		add(new TextField<Integer>("huisnummer"));
		add(new TextField<String>("postcode"));
		add(new TextField<String>("plaats"));		
	}
}
