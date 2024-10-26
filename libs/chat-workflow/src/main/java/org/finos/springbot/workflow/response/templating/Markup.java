package org.finos.springbot.workflow.response.templating;

public interface Markup {

	public static final Markup EMPTY_MARKUP = () -> "";

	public String getContents();

	public static Markup of(String string) {
		return () -> string;
	}
}
