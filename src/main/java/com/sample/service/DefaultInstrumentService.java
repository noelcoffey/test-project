package com.sample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.InstrumentDao;
import com.sample.domain.Instrument;

@Service
public class DefaultInstrumentService implements InstrumentService {

	private InstrumentDao instrumentDao;

	@Autowired
	public DefaultInstrumentService(InstrumentDao instrumentDao) {
		super();
		this.instrumentDao = instrumentDao;
	}

	@Override
	public Instrument create(Instrument instrument) {
		return instrumentDao.save(instrument);
	}

	@Override
	public Instrument retrieve(Long id) {
		Optional<Instrument> instrument = instrumentDao.findById(id);
		return instrument.get();
	}

}
