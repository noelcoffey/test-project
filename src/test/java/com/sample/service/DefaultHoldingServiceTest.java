package com.sample.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.sample.dao.HoldingsDao;
import com.sample.domain.Holding;
import com.sample.domain.Instrument;
import com.sample.domain.Person;
import com.sample.domain.Portfolio;
import com.sample.web.CreateHolding;

@RunWith(MockitoJUnitRunner.class)
public class DefaultHoldingServiceTest {

	@Mock
	PricingService pricingService;
	
	@Mock
	HoldingsDao holdingsDao;
	
	@InjectMocks
	DefaultHoldingService holdingService = new DefaultHoldingService();

	@Test
	public void whenCreateHoldingPriceisCalculatedAndPersisted() {
		//Arrange
		BigDecimal testPrice = BigDecimal.TEN;
		Person testPerson = new Person(1l, "John", "Doe", "Dublin");
		Portfolio testPortfolio = new Portfolio(1l, "Test Portfolio", testPerson , LocalDate.now(), null);
		Instrument testInstrument = new Instrument("130A14569", "AAPL", "test security", "test Security");
		CreateHolding createHolding = new CreateHolding(testPortfolio , testInstrument , 100);

		Mockito.when(pricingService.getPrice("AAPL")).thenReturn(testPrice);
		ArgumentCaptor<Holding> holdingArg = ArgumentCaptor.forClass(Holding.class);
		

		//Act
		holdingService.addHolding(createHolding);

		//Assert
		Mockito.verify(holdingsDao).save(holdingArg.capture());
		assertEquals(new BigDecimal(1000), holdingArg.getValue().getMarketValue());
		Integer expectedUnits = 100;
		assertEquals(expectedUnits, holdingArg.getValue().getUnits());
	}

}
