package nl.cge.wicket.page.simpleformpage;


import nl.cge.domein.Pizza;
import nl.cge.wicket.bootstrap.BootstrapPage;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

public class SimpleFormPage extends BootstrapPage {
	
	public SimpleFormPage() {
		add(new FeedbackPanel("feedback"));
		Form<Pizza> form = new Form<Pizza>("form", new CompoundPropertyModel<Pizza>(new Pizza()));
		form.add(new TextField<String>("naam").setRequired(true));
		form.add(new TextField<Integer>("prijs").setRequired(true));
		add(form);
	}

}
