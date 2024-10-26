package org.finos.springbot.tool.rssbot.feed;

import java.util.function.Predicate;

import org.finos.springbot.workflow.annotations.Work;

@Work
public class Filter implements Predicate<String> {

	String toMatch;

	public enum Type { INCLUDE, EXCLUDE }

	private Type usage = Type.EXCLUDE;

	public String getToMatch() {
		return toMatch;
	}

	public void setToMatch(String toMatch) {
		this.toMatch = toMatch;
	}

	public Type getUsage() {
		return usage;
	}

	public void setUsage(Type type) {
		this.usage = type;
	}

	@Override
	public boolean test(String t) {
		boolean contains = t.toLowerCase().contains(toMatch.toLowerCase());
        return switch (getUsage()) {
            case INCLUDE -> contains;
            default -> !contains;
        };
	}

}
