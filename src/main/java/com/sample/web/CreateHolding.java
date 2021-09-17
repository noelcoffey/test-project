package com.sample.web;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sample.domain.Instrument;
import com.sample.domain.Portfolio;

public class CreateHolding {

	@JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            resolver = PortfolioResolver.class,
            scope = Portfolio.class)
	@NotNull(message = "portfolio is required")
	private Portfolio portfolio;
	
	@JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id",
            resolver = InstrumentResolver.class,
            scope = Instrument.class)
	@NotNull(message = "instrument is required")
	private Instrument instrument;
	
	private Integer units;

	public CreateHolding(Portfolio portfolio, Instrument instrument, Integer units) {
		super();
		this.portfolio = portfolio;
		this.instrument = instrument;
		this.units = units;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public Integer getUnits() {
		return units;
	}
	
}
