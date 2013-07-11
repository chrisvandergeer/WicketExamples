package nl.cge.wicket.page.radio;

import nl.cge.wicket.bootstrap.BootstrapPage;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

public class CopyOfRadiobuttonPage extends BootstrapPage {
	private static final long serialVersionUID = 1L;

	public CopyOfRadiobuttonPage() {
		Adresgegevens adresgegevens = Adresgegevens.dummy();		
		CompoundPropertyModel<Adresgegevens> model = new CompoundPropertyModel<Adresgegevens>(Model.of(adresgegevens));
		Form<Adresgegevens> form = new Form<Adresgegevens>("myForm", model);
		form.add(new AdresPanel("postadres", new CompoundPropertyModel<Adres>(adresgegevens.getPostadres())));
		form.add(new AdresPanel("woonadres", new CompoundPropertyModel<Adres>(adresgegevens.getWoonadres())));
		form.add(new AdresPanel("notarisadres", new CompoundPropertyModel<Adres>(adresgegevens.getNotarisadres())));
		add(form);
		add(new FeedbackPanel("feedback"));
	}

}
