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
import com.capgemini.jpa.entities.RequestEvent;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Task5 {

	@Autowired
	EntityManager entityManager;
	
	@Test
	public void shouldUpdateEventsLongerThanInBulk() throws Exception {
		// given
		int threshold = 1000;
		Class<RequestEvent> clazz = RequestEvent.class;

		// when
//		repository.updateInBulkToBeAnalyzedByType(clazz, threshold);

		// then
		assertEquals(3,
				new SimpleJpaRepository<Event, Long>(Event.class, entityManager).findAll().stream()//
						.filter(e -> e.getDuration() > threshold)//
						.filter(Event::isAnalysisRequired)//
						.count());
	}
	
}
