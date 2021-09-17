package com.sample.service;

import com.sample.domain.Instrument;

public interface InstrumentService {

	Instrument create(Instrument security);

	Instrument retrieve(Long id);

}
