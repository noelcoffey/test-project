package com.sample.dao;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sample.domain.Holding;

public interface HoldingsDao extends  CrudRepository<Holding, Long>{

	@Query("SELECT h FROM Holding h WHERE h.portfolio.id = ?1 and h.asOfDate = ?2")
	Set<Holding> findHoldingsByPortfolioAndDate(Long portfolioId, LocalDate asOfDate);
}
