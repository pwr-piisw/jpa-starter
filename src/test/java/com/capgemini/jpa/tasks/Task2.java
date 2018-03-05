package com.capgemini.jpa.tasks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jpa.entities.Event;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Task2 {

	
	@Test
	public void shouldFindOneEntryBetweenDatesThatMustBeAnalyzed() throws Exception {
		// given
		LocalDateTime start = LocalDateTime.of(2018, 4, 9, 3, 25);
		LocalDateTime end = LocalDateTime.of(2018, 4, 9, 3, 26);
		boolean toBeAnalyzed = false;
		
		// when
		List<Event> result = null; //TODO: add repository method call here

		// then
		assertNotNull(result);
		assertEquals(1, result.size());
	}
}
