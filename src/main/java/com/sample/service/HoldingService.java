package com.sample.service;

import java.time.LocalDate;
import java.util.Set;

import com.sample.domain.Holding;
import com.sample.web.CreateHolding;

public interface HoldingService {

	Set<Holding> retrieveHoldings(Long portfolioId, LocalDate asOfDate);

	Holding addHolding(CreateHolding holding);

}
