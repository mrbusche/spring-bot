package org.finos.springbot.teams.templating.adaptivecard;

import org.finos.springbot.workflow.response.WorkResponse;

import com.fasterxml.jackson.databind.JsonNode;

public record AdaptiveCardPassthrough(JsonNode jsonNode) {

	private final static String ADAPTIVE_CARD = "AdaptiveCard";
	private final static String ADAPTIVE_CARD_TYPE = "type";


	public static boolean isAdaptiveCard(WorkResponse wr) {
		if (wr.getFormObject() instanceof AdaptiveCardPassthrough passthrough) {
            JsonNode node = passthrough.jsonNode();
			JsonNode adaptiveNode = node.get(ADAPTIVE_CARD_TYPE);
			return adaptiveNode.asText().equals(ADAPTIVE_CARD);
		}

		return false;
	}

}
