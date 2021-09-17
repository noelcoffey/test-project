package com.sample.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Instrument {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "cusip is required")
	private String cusip;	
	
	@NotBlank(message = "symbol is required")
	private String symbol;
	
	@NotBlank(message = "short name is required")
	private String shortName;
	
	@NotBlank(message = "long name is required")
	private String longName;

	
	public Instrument() {
		super();
	}

	public Instrument(String cusip, String symbol, String shortName, String longName) {
		super();
		this.cusip = cusip;
		this.symbol = symbol;
		this.shortName = shortName;
		this.longName = longName;
	}

	public Instrument(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getCusip() {
		return cusip;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getShortName() {
		return shortName;
	}

	public String getLongName() {
		return longName;
	}

}
