package nl.cge.wicket.page.radio;

import nl.cge.wicket.bootstrap.BootstrapPage;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class RadiogroupPage extends BootstrapPage {
	private static final long serialVersionUID = 1L;

	public RadiogroupPage() {
		Adresgegevens adresgegevens = Adresgegevens.dummy();		
		Form<Void> myForm = new Form<Void>("myForm") {
			@Override
			protected void onSubmit() {
				System.out.println(((RadioGroup<Adres>) get("adresRadioGroup")).getModelObject());
			}			
		};
		RadioGroup<Adres> adresRadioGroup = new RadioGroup<Adres>("adresRadioGroup");
		adresRadioGroup.setModel(Model.of(adresgegevens.getWoonadres()));
		ListView<Adres> listview = new ListView<Adres>("adressen", adresgegevens.getAdressen()) {
			@Override
			protected void populateItem(ListItem<Adres> item) {
				item.add(new Radio<Adres>("radio", item.getModel()));
				item.add(new Label("straat", new PropertyModel<String>(item.getModel(), "straat")));
				item.add(new Label("huisnummer", new PropertyModel<Integer>(item.getModel(), "huisnummer")));
				item.add(new Label("postcode", new PropertyModel<String>(item.getModel(), "postcode")));
				item.add(new Label("plaats", new PropertyModel<String>(item.getModel(), "plaats")));
			}
		};
		adresRadioGroup.add(listview);
		myForm.add(adresRadioGroup);
		add(myForm);
	}

}
