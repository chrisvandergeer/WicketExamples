package nl.cge.wicket.page.radiogroup;

import java.util.List;

import nl.cge.wicket.bootstrap.BootstrapPage;
import nl.cge.wicket.page.radio.Adres;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class RadiogroupPage2 extends BootstrapPage {
	
	public RadiogroupPage2() {
		List<Adres> adressen = Adres.findAll();
		adressen.add(new Adres());
		final Form<Void> form = new Form<Void>("form") {

			@Override
			protected void onSubmit() {
				RadioGroup<Adres> radioGroup = (RadioGroup<Adres>) get("radioGroup");				
				System.out.println(radioGroup.getModelObject());
			}
			
		};
		final RadioGroup<Adres> radioGroup = new RadioGroup<Adres>("radioGroup", new  Model<Adres>());		
 		final ListView<Adres> listView = new ListView<Adres>("listView", adressen) {
			@Override
			protected void populateItem(ListItem<Adres> item) {
				item.add(new Radio<Adres>("radio", item.getModel()));
				if (item.getModelObject().isLeeg()) {
					item.add(new AdresInputPanel("adrespanel", item.getModel()));
				} else {
					item.add(new AdresPanel("adrespanel", item.getModel()));
				}				
			}			
			
		};
		radioGroup.add(listView);
		form.add(radioGroup);
		add(form);
	}
	
	

}
