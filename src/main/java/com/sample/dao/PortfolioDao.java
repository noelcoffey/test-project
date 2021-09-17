package com.sample.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sample.domain.Portfolio;

public interface PortfolioDao extends CrudRepository<Portfolio, Long>{

	Optional<Portfolio> findById(Long id);

}
