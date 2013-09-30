package nl.cge.wicket.page.explist;

import nl.cge.domein.Pizza;
import nl.cge.wicket.bootstrap.BootstrapPage;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

public class ExpandableListPage extends BootstrapPage {
	
	private ListView<Pizza> listview;
	private Form<Pizza> form;

	public ExpandableListPage() {
		super();
		form = new Form<Pizza>("pizzaForm", new CompoundPropertyModel<Pizza>(new Pizza())) {
			@Override
			protected void onSubmit() {
				listview.getModelObject().add(getModelObject());
				setModelObject(new Pizza());
			}			
		};
		
		listview = new ListView<Pizza>("listview", Pizza.findAll()) {
			@Override
			protected void populateItem(final ListItem<Pizza> item) {
				item.add(new Label("naam", new PropertyModel<String>(item.getModelObject(), "naam")));
				item.add(new Label("prijs", new PropertyModel<Double>(item.getModelObject(), "prijs")));
				item.add(new AjaxFallbackLink<Pizza>("removePizza", item.getModel()) {
					@Override
					public void onClick(AjaxRequestTarget target) {
						listview.getModelObject().remove(item.getModelObject());
						target.add(form);
					}
				});
			}			
		};

		form.add(listview);
		form.add(new TextField<String>("naam"));
		form.add(new TextField<Double>("prijs"));
		form.add(new Button("addPizza"));		
		add(form);
	}
	
	

}
