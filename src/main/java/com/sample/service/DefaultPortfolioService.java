package com.sample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.PortfolioDao;
import com.sample.domain.Portfolio;

@Service
public class DefaultPortfolioService implements PortfolioService {

	private PortfolioDao portfolioDao;
	
	@Autowired
	public DefaultPortfolioService(PortfolioDao portfolioDao) {
		super();
		this.portfolioDao = portfolioDao;
	}

	@Override
	public Portfolio retrieve(Long id) {
		Optional<Portfolio> portfolio = portfolioDao.findById(id);
		return portfolio.get();
	}

	@Override
	public Portfolio create(Portfolio portfolio) {
		Portfolio persistedPortfolio = portfolioDao.save(portfolio);
		return persistedPortfolio;
	}

}
