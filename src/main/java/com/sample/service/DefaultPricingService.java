package com.sample.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sample.web.PricingResponse;

@Service
public class DefaultPricingService implements PricingService {

	private static final String X_RAPIDAPI_HOST = "x-rapidapi-host";

	private static final String X_RAPIDAPI_KEY = "x-rapidapi-key";

	private RestTemplateBuilder builder;
	
	private String pricingUrl;

	private String apiHost;

	private String apiKey;
	
	@Autowired
	public DefaultPricingService(RestTemplateBuilder builder, @Value("${pricing.url}") String pricingUrl,
			@Value("${pricing.api.host}") String apiHost, @Value("${pricing.api.key}") String apiKey) {
		super();
		this.apiHost = apiHost;
		this.apiKey = apiKey;
		this.builder = builder;
		this.pricingUrl = pricingUrl;
	}

	@Override
	public BigDecimal getPrice(String symbol) {
		RestTemplate restTemplate = builder
				.defaultHeader(X_RAPIDAPI_KEY, apiKey)
				.defaultHeader(X_RAPIDAPI_HOST, apiHost)
				.build();
		PricingResponse response = restTemplate.getForObject(pricingUrl, PricingResponse.class, symbol);
		return response.getPrice();
	}

}
