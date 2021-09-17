package com.sample.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.HoldingsDao;
import com.sample.domain.Holding;
import com.sample.web.CreateHolding;

@Service
public class DefaultHoldingService implements HoldingService {

	@Autowired
	private HoldingsDao holdingsDao;

	@Autowired
	private PricingService pricingService;

	@Override
	public Set<Holding> retrieveHoldings(Long portfolioId, LocalDate asOfDate) {
		return holdingsDao.findHoldingsByPortfolioAndDate(portfolioId, asOfDate);
	}

	@Override
	public Holding addHolding(CreateHolding createHolding) {
		BigDecimal price = pricingService.getPrice(createHolding.getInstrument().getSymbol());
		
		BigDecimal marketValue = price.multiply(new BigDecimal(createHolding.getUnits()));
		Holding holding = new Holding(createHolding.getPortfolio(), createHolding.getInstrument(), marketValue , 
				createHolding.getUnits(), LocalDate.now());
		
		return holdingsDao.save(holding);
	}

}
