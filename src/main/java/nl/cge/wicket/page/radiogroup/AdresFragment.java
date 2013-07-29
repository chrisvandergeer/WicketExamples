package nl.cge.wicket.page.radiogroup;

import nl.cge.wicket.page.radio.Adres;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

public class AdresFragment extends Fragment {

	public AdresFragment(String id, String markupId, MarkupContainer markupProvider, IModel<Adres> model) {
		super(id, markupId, markupProvider, model);
		add(new Label("straat", new PropertyModel<String>(model, "straat")));
		add(new Label("huisnummer", new PropertyModel<Integer>(model, "huisnummer")));
		add(new Label("postcode", new PropertyModel<String>(model, "postcode")));
		add(new Label("plaats", new PropertyModel<String>(model, "plaats")));
	}

}
