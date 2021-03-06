package nl.cge.wicket;

import nl.cge.wicket.aantekeningen.page.AantekeningenPage;
import nl.cge.wicket.page.ant.QueueinfoPage;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see nl.cge.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{    	
	@Override
	public Class<? extends WebPage> getHomePage() {
		return AantekeningenPage.class;
	}

	@Override
	public void init() {
		super.init();
	}
}
