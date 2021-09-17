package com.sample.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.domain.Instrument;
import com.sample.service.InstrumentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/instrument")
public class InstrumentController {

	@Autowired
	private InstrumentService instrumentService;

	@PostMapping
	@ApiOperation(value = "Register a new instrument in the system for investment in a portfolio")
	public Instrument create(@Valid @RequestBody Instrument instrument)  {
		return instrumentService.create(instrument);
	}
	
	@GetMapping
	@ApiOperation(value = "Retrieve the details of an registered security/instrument in the system by id")
	public Instrument retrieve(@RequestParam Long id) {
		return instrumentService.retrieve(id);
	}
	
	
}
