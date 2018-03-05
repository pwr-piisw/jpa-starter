package com.capgemini.jpa.tasks;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import com.capgemini.jpa.repositories.ServerStatistic;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Task6 {

	@Test
	public void shouldCountEventsByServer() throws Exception {
		// given ensured by script
		int expectedServer_1 = 15;
		int expectedServer_2 = 14;
		int expectedServer_3 = 11;

		// when
		List<ServerStatistic> result = new ArrayList<>();// replace by repository method call

		// then
		assertEquals(3, result.size());

		// convert to map
		Map<Integer, Long> map = result.stream()//
				.collect(Collectors.toMap(s -> s.getServer().getId(), s -> s.getCount()));

		assertEquals(expectedServer_1, map.get(1).intValue());
		assertEquals(expectedServer_2, map.get(2).intValue());
		assertEquals(expectedServer_3, map.get(3).intValue());
	}
}
