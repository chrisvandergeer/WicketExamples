package nl.cge.wicket.page.ant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;

import nl.cge.wicket.bootstrap.BootstrapPage;

public class QueueinfoPage extends BootstrapPage {
	
	public QueueinfoPage() {
		super();
		Form<Void> form = new Form<Void>("form") {
			@Override
			protected void onSubmit() {
				 Omgeving omgeving = ((DropDownChoice<Omgeving>)get("omgeving")).getModelObject();
				 Queue queue = ((DropDownChoice<Queue>)get("queue")).getModelObject();
				 if (omgeving == null || queue == null) {
					 return;
				 }
				 Map<String, String> userProperties = userProperties();
				 userProperties.put("omgeving", omgeving.getHost());
				 userProperties.put("queue", queue(omgeving, queue));
				 AntRunner antRunner = new AntRunner();
				 antRunner.executeTask("hello", userProperties);
				 getPage().get("result").setDefaultModelObject(antRunner.getStdOut());
				 getPage().get("errors").setDefaultModelObject(antRunner.getStdErr());
			}			
		};
		add(form);
		form.add(new DropDownChoice<Omgeving>("omgeving", new Model<Omgeving>(), Arrays.asList(Omgeving.values())));
		form.add(new DropDownChoice<Queue>("queue", new Model<Queue>(), Arrays.asList(Queue.values())));
		add(new Label("result", Model.of("")));
		add(new Label("errors", Model.of("")));
	}
	
	@Override
	protected void onBeforeRender() {
		super.onBeforeRender();
		hideOnEmpty("result", "errors");
	}
	
	private void hideOnEmpty(String... ids) {
		for (String id : ids) {
			Component component = getPage().get(id);
			component.setVisible(!"".equals(component.getDefaultModelObjectAsString()));
		}		
	}

	private Map<String, String> userProperties() {
		return new HashMap<String, String>();
	}
	
	private String queue(Omgeving omgeving, Queue queue) {
		StringBuilder builder = new StringBuilder("ROB.");
		builder.append(omgeving.getPrefix()).append(".");
		builder.append(queue);
		return builder.toString();
	}
	
}
