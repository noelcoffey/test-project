package com.sample.web;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.domain.Holding;
import com.sample.service.HoldingService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/holdings")
public class HoldingsController {

	@Autowired
	private HoldingService holdingsService;

	@GetMapping
	@ApiOperation(value = "Retrieve the holdings of a particular portfolio on a specific date")
	public Set<Holding> retrieveHoldings(@RequestParam Long portfolioId, @RequestParam LocalDate asOfDate) {

		return holdingsService.retrieveHoldings(portfolioId, asOfDate);
		
	}
	
	@PostMapping
	@ApiOperation(value = "Make an investment for a particular portfolio in a particular security based on a price retrieve via 3rd party market data API")
	public Holding addHolding(@Valid @RequestBody CreateHolding holding) {

		return holdingsService.addHolding(holding);
		
	}
}
