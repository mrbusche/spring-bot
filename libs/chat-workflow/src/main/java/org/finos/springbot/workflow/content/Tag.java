package org.finos.springbot.workflow.content;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface Tag extends Content {

	public interface Type {

		public char getPrefix();

	}

	public static Type CASH = () -> '$';

	public static Type HASH = () -> '#';


	public static Type MENTION = () -> '@';

	@JsonIgnore
	public Type getTagType();

	/**
	 * Screen, display name
	 */
	public String getName();

	@JsonIgnore
	public default String getText() {
		return getTagType().getPrefix() + getName();
	}

}
