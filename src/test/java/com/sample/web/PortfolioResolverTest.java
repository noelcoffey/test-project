package com.sample.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.sample.dao.PortfolioDao;
import com.sample.domain.Portfolio;

@RunWith(MockitoJUnitRunner.class)
public class PortfolioResolverTest {

	@Mock
	private PortfolioDao mockPortfolioDao;
	
	@Test(expected = EntityNotFoundException.class)
	public void whenIdToResolveDoesntExistThrowsException() {
		IdKey idKey = new IdKey(Long.class, Long.class, 1l) ;
		Mockito.when(mockPortfolioDao.findById(1l)).thenReturn(Optional.empty());

		PortfolioResolver portfolioResolver = new PortfolioResolver(mockPortfolioDao);
		portfolioResolver.resolveId(idKey);
	}

	@Test
	public void whenIdToResolveExistsReturnobject() {
		IdKey idKey = new IdKey(Long.class, Long.class, 1l) ;
		Portfolio testPortfolio = new Portfolio(1l);
		Mockito.when(mockPortfolioDao.findById(1l)).thenReturn(Optional.of(testPortfolio));
		
		PortfolioResolver portfolioResolver = new PortfolioResolver(mockPortfolioDao);

		Portfolio result = (Portfolio) portfolioResolver.resolveId(idKey);
		assertEquals(testPortfolio, result);
	}
}
