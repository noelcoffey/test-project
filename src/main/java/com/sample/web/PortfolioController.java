package com.sample.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.domain.Portfolio;
import com.sample.service.PortfolioService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

	private PortfolioService portfolioService;

	@Autowired
	public PortfolioController(PortfolioService portfolioService) {
		super();
		this.portfolioService = portfolioService;
	}

	@PostMapping
	@ApiOperation(value = "Register a new portfolio in the system")
	public Portfolio create(@Valid @RequestBody Portfolio portfolio)  {
		return portfolioService.create(portfolio);
	}
	
	@GetMapping
	@ApiOperation(value = "Retrieve a portfolio definition")
	public Portfolio retrieve(@RequestParam Long id) {
		
		Portfolio portfolio = portfolioService.retrieve(id);
		return portfolio;
	}
	
}
