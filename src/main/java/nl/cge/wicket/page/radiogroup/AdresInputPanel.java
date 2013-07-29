package nl.cge.wicket.page.radiogroup;

import nl.cge.wicket.page.radio.Adres;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

public class AdresInputPanel extends Panel {

	public AdresInputPanel(String id, IModel<Adres> model) {
		super(id, model);
		add(new TextField<String>("straat", new PropertyModel<String>(model, "straat")));
		add(new TextField<Integer>("huisnummer", new PropertyModel<Integer>(model, "huisnummer")));
		add(new TextField<String>("postcode", new PropertyModel<String>(model, "postcode")));
		add(new TextField<String>("plaats", new PropertyModel<String>(model, "plaats")));
	}
	

}
