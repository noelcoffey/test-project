package com.sample.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sample.domain.Instrument;

public interface InstrumentDao extends CrudRepository<Instrument, Long>{

	Optional<Instrument> findById(Long id);

}
