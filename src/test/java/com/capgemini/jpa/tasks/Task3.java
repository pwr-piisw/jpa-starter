package com.capgemini.jpa.tasks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jpa.entities.Event;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Task3 {

	@Test
	public void shouldReturnThirdPageOfEventsSortedByTime() throws Exception {
		// given
		int page = 3;
		int pageSize = 10;
		Sort sort = new Sort("time");

		// when
		Page<Event> result = null; //TODO: add repository method call here

		// then
		assertNotNull(result);
		assertEquals(page, result.getNumber());
		assertEquals(pageSize, result.getNumberOfElements());
	}
	
}
