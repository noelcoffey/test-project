package com.sample.web;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

@JsonComponent
public class PricingDeserializer extends JsonDeserializer<PricingResponse>{

	@Override
	public PricingResponse deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
        TreeNode treeNode = p.getCodec().readTree(p);
        JsonNode quoteReponse = (JsonNode) treeNode.get("quoteResponse");
        JsonNode result = ((ArrayNode) quoteReponse.get("result")).get(0);
        BigDecimal price = new BigDecimal(result.get("regularMarketPrice").asDouble());
        return new PricingResponse(price);
	}

}
