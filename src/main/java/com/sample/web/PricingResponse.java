package com.sample.web;

import java.math.BigDecimal;

public class PricingResponse {

	private BigDecimal price;

	public PricingResponse(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPrice() {
		return price;
	}

}
