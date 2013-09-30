package nl.cge.wicket.page.explist;

import nl.cge.domein.Pizza;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

public class PizzaForm extends Form<Pizza> {
	
	private ListView<Pizza> listview;

	public PizzaForm(String id) {
		super(id, new CompoundPropertyModel<Pizza>(new Pizza()));
		WebMarkupContainer wmc = new WebMarkupContainer("wmc");
		wmc.setOutputMarkupId(true);
		listview = new ListView<Pizza>("listview", Pizza.findAll()) {
			@Override
			protected void populateItem(ListItem<Pizza> item) {
				item.add(new Label("naam", new PropertyModel<String>(item.getModelObject(), "naam")));
				item.add(new Label("prijs", new PropertyModel<Double>(item.getModelObject(), "prijs")));
			}			
		};
		wmc.add(listview);
		add(wmc);
		add(new TextField<String>("naam"));
		add(new TextField<Double>("prijs"));
		add(new Button("addPizzaLink"));		
	}
	
	@Override
	protected void onSubmit() {
		listview.getModelObject().add(getModelObject());
		setModelObject(new Pizza());
		
	}

}
