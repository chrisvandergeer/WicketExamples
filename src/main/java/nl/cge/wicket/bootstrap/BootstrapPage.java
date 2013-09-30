package nl.cge.wicket.bootstrap;

import nl.cge.wicket.page.ant.QueueinfoPage;
import nl.cge.wicket.page.explist.ExpandableListPage;
import nl.cge.wicket.page.radiogroup.RadiogroupPage2;
import nl.cge.wicket.page.simpleformpage.SimpleFormPage;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
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
		init();
	}

	public BootstrapPage(IModel<?> model) {
		super(model);
		init();
	}

	public BootstrapPage(PageParameters parameters) {
		super(parameters);
		init();
	}
	
	private void init() {
		add(new BookmarkablePageLink<QueueinfoPage>("pagelinkQueueinfo", QueueinfoPage.class));
		add(new BookmarkablePageLink<QueueinfoPage>("pagelinkOther", RadiogroupPage2.class));
		add(new BookmarkablePageLink<QueueinfoPage>("expandableList", ExpandableListPage.class));
		add(new BookmarkablePageLink<QueueinfoPage>("simpleForm", SimpleFormPage.class));
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		response.render(CssHeaderItem.forReference(BOOTSTRAP_CSS));
		response.render(JavaScriptHeaderItem.forReference(BOOTSTRAP_JS));
	}

	
	
	

	
}
