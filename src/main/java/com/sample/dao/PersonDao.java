package com.sample.dao;

import org.springframework.data.repository.CrudRepository;

import com.sample.domain.Person;

public interface PersonDao extends CrudRepository<Person, Long> {

	
}
