package com.sample.web;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.sample.dao.PortfolioDao;
import com.sample.domain.Portfolio;

@Component
public class PortfolioResolver implements ObjectIdResolver {

	private PortfolioDao portfolioDao;
	
	@Autowired
	public PortfolioResolver(PortfolioDao portfolioDao) {
		super();
		this.portfolioDao = portfolioDao;
	}

	@Override
	public void bindItem(IdKey id, Object pojo) {}

	@Override
	public Object resolveId(IdKey id) {
		Optional<Portfolio> portfolio = portfolioDao.findById((Long) id.key);
		if(portfolio.isEmpty()) {
			throw new EntityNotFoundException("portfolio cannot be found: " + id.key);
		}
		
		return portfolio.get();
	}

	@Override
	public ObjectIdResolver newForDeserialization(Object context) {
		return this;
	}

	@Override
	public boolean canUseFor(ObjectIdResolver resolverType) {
		return getClass().isAssignableFrom(resolverType.getClass());
	}

}
