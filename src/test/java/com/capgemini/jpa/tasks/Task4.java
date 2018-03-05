package com.capgemini.jpa.tasks;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jpa.entities.Event;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Task4 {

	@Autowired
	EntityManager entityManager;
	
	@Test
	public void shouldDeleteInBulkEventsOlderThan() throws Exception {
		// given
		LocalDateTime givenDate = LocalDateTime.of(2017, 12, 31, 0, 0);

		// when
		//repository.deleteInBulkBeforDate(givenDate); // replace with repository method call

		// then
		assertEquals(32, new SimpleJpaRepository<Event, Long>(Event.class, entityManager).findAll().size());
	}
	
}
