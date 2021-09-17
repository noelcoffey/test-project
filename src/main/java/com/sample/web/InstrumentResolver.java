package com.sample.web;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.sample.dao.InstrumentDao;
import com.sample.domain.Instrument;

@Component
public class InstrumentResolver implements ObjectIdResolver {

	private InstrumentDao instrumentDao;
	
	@Autowired
	public InstrumentResolver(InstrumentDao instrumentDao) {
		super();
		this.instrumentDao = instrumentDao;
	}

	@Override
	public void bindItem(IdKey id, Object pojo) {}

	@Override
	public Object resolveId(IdKey id) {
		Optional<Instrument> instrument = instrumentDao.findById((Long) id.key);
		
		if(instrument.isEmpty()) {
			throw new EntityNotFoundException("instrument cannot be found: " + id.key);
		}
		
		return instrument.get();
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
