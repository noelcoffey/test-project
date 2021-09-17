package com.sample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.PersonDao;
import com.sample.domain.Person;

@Service
public class DefaultPersonService implements PersonService {

	private PersonDao personDao;

	@Autowired
	public DefaultPersonService(PersonDao personDao) {
		super();
		this.personDao = personDao;
	}

	@Override
	public Person create(Person person) {
		return personDao.save(person);
	}

	@Override
	public Person retrieve(Long id) {
		Optional<Person> person = personDao.findById(id);
		return person.get();
	}

}
