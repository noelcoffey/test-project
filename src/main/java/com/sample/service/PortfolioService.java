package com.sample.service;

import com.sample.domain.Portfolio;

public interface PortfolioService {

	Portfolio retrieve(Long id);

	Portfolio create(Portfolio portfolio);
}
