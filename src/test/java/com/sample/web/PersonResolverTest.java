package com.sample.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.sample.dao.PersonDao;
import com.sample.domain.Person;

@RunWith(MockitoJUnitRunner.class)
public class PersonResolverTest {

	@Mock
	private PersonDao mockPersonDao;
	
	@Test(expected = EntityNotFoundException.class)
	public void whenIdToResolveDoesntExistThrowsException() {
		IdKey idKey = new IdKey(Long.class, Long.class, 1l) ;
		Mockito.when(mockPersonDao.findById(1l)).thenReturn(Optional.empty());

		PersonResolver personResolver = new PersonResolver(mockPersonDao);
		personResolver.resolveId(idKey);
	}

	@Test
	public void whenIdToResolveExistsReturnobject() {
		IdKey idKey = new IdKey(Long.class, Long.class, 1l) ;
		Person testPerson = new Person(1l, "Jon", "Doe", "Dublin");
		Mockito.when(mockPersonDao.findById(1l)).thenReturn(Optional.of(testPerson));
		
		PersonResolver personResolver = new PersonResolver(mockPersonDao);

		Person result = (Person) personResolver.resolveId(idKey);
		assertEquals(testPerson, result);
	}
}
