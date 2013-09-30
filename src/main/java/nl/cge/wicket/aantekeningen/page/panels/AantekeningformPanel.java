package nl.cge.wicket.aantekeningen.page.panels;

import nl.cge.wicket.aantekeningen.domein.Aantekening;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public class AantekeningformPanel extends Panel {
	private static final long serialVersionUID = 1L;
	
	private Form<Aantekening> aantekeningForm;
	private WebMarkupContainer container;
	private CompoundPropertyModel<Aantekening> model;

	public AantekeningformPanel(String id) {
		super(id);
		setVisible(false);
		setOutputMarkupPlaceholderTag(true);		
		model = new CompoundPropertyModel<Aantekening>(new Aantekening());
		setDefaultModel(model);
		container = new WebMarkupContainer("aantekeningpanel");
		container.add(new Label("dossier.kenmerk"));
		aantekeningForm = new Form<Aantekening>("form", model);
		aantekeningForm.add(new TextField<String>("tekst"));
		aantekeningForm.add(newAnnuleerButton("annuleer", model));
		aantekeningForm.add(newOpslaanButton("opslaan"));
		container.add(aantekeningForm);
		add(container);
	}
	
	private Button newOpslaanButton(String id) {
		Button link = new Button(id) {
			private static final long serialVersionUID = 1L;
			@Override
			public void onSubmit() {
				Aantekening aantekening = aantekeningForm.getModelObject();
				aantekening.getDossier().addAantekening(aantekening);
				AantekeningformPanel.this.setVisible(false);
			}
		};
		return link;
	}
	
	private AjaxFallbackLink<Aantekening> newAnnuleerButton(String id, final IModel<Aantekening> model) {
		AjaxFallbackLink<Aantekening> link = new AjaxFallbackLink<Aantekening>(id, model) {
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick(AjaxRequestTarget target) {
				model.setObject(new Aantekening());
				AantekeningformPanel.this.setVisible(false);
				target.add(AantekeningformPanel.this);
			}
		};
		return link;
	}
	
	public void setModelObject(Aantekening aantekening) {
		model.setObject(aantekening);
	}

}
