package org.finos.springbot.workflow.content;

import java.util.Objects;

public interface Image extends Content {

	@Override
	public default String getText() {
		return "";
	}

	public String url();

	public String alt();

	public record ImageImpl(String url, String alt) implements Image {


		@Override
			public boolean equals(Object obj) {
				if (this == obj) {
					return true;
				} else if (obj instanceof Image other) {
					return Objects.equals(alt, other.alt()) && Objects.equals(url, other.url());
				} else {
					return false;
				}
			}

	}

	public static Image of(String url, String alt) {
		return new ImageImpl(url, alt);
	}

}
