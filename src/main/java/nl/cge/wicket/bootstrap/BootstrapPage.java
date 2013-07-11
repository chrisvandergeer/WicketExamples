package nl.cge.wicket.bootstrap;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

public abstract class BootstrapPage extends WebPage {
	
	private static final long serialVersionUID = -8749243894976136666L;
	private static final ResourceReference BOOTSTRAP_JS = new JavaScriptResourceReference(BootstrapPage.class, "js/bootstrap.min.js");
	private static final ResourceReference BOOTSTRAP_CSS = new CssResourceReference(BootstrapPage.class, "css/bootstrap.min.css");
	

	public BootstrapPage() {
		super();
	}

	public BootstrapPage(IModel<?> model) {
		super(model);
	}

	public BootstrapPage(PageParameters parameters) {
		super(parameters);
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		response.render(CssHeaderItem.forReference(BOOTSTRAP_CSS));
		response.render(JavaScriptHeaderItem.forReference(BOOTSTRAP_JS));
	}

	
	
	

	
}
