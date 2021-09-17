package com.sample.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Holding {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
    @JoinColumn(name = "portfolio_id", referencedColumnName = "id")	
	private Portfolio portfolio;
	
	@OneToOne
    @JoinColumn(name = "instrument_id", referencedColumnName = "id")	
	private Instrument instrument;
	
	private BigDecimal marketValue;
	
	private Integer units;
	
	private LocalDate asOfDate;

	
	public Holding() {
		super();
	}

	public Holding(Portfolio portfolio, Instrument instrument, BigDecimal value, Integer units, LocalDate asOfDate) {
		super();
		this.portfolio = portfolio;
		this.instrument = instrument;
		this.units = units;
		this.marketValue = value;
		this.asOfDate = asOfDate;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public BigDecimal getMarketValue() {
		return marketValue;
	}

	public Integer getUnits() {
		return units;
	}

	public LocalDate getAsOfDate() {
		return asOfDate;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}	
	
}
