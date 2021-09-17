package com.sample.service;

import com.sample.domain.Person;

public interface PersonService {

	Person create(Person person);

	Person retrieve(Long id);

}
