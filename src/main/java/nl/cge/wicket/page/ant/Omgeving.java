package nl.cge.wicket.page.ant;


public enum Omgeving {
	
	TST1_1("robtst1u1", "TST1"),
	TST1_2("robtst1u2", "TST1"),
	TST2_1("robtst2u1", "TST2"),
	TST2_2("robtst2u2", "TST2");
	
	private String host;
	private String prefix;
	
	private Omgeving(String host, String prefix) {
		this.host = host;
		this.prefix = prefix;
	}
	
	public String getHost() {
		return host;
	}
	
	public String getPrefix() {
		return prefix;
	}

}
