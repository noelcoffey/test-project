package com.sample.web;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.sample.dao.PersonDao;
import com.sample.domain.Person;

@Component
public class PersonResolver implements ObjectIdResolver {

	private PersonDao personDao;
	
	@Autowired
	public PersonResolver(PersonDao personDao) {
		super();
		this.personDao = personDao;
	}

	@Override
	public void bindItem(IdKey id, Object pojo) {}

	@Override
	public Object resolveId(IdKey id) {
		Optional<Person> person = personDao.findById((Long) id.key);
		if(person.isEmpty()) {
			throw new EntityNotFoundException("person cannot be found: " + id.key);
		}
		return person.get();
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
