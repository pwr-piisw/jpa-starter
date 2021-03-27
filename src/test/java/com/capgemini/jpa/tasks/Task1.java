package com.capgemini.jpa.tasks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jpa.entities.Server;
import com.capgemini.jpa.repositories.ServerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Task1 {

	@Autowired
	private ServerRepository serverRepository;
	
	@Test
	public void shouldIncrementVersionCounterOnSave() throws Exception {
		// given 
		Server server = serverRepository.getOne(1);
		Long currentVersion = server.getVersion();
		
		// when
		server.setName("name2");
		serverRepository.saveAndFlush(server); // we need to force a flush to demonstrate the feature, under normal execution this would happen during transaction commit
		
		// then
		assertEquals("Version counter must be incremented", 2, server.getVersion().longValue());
		assertEquals("Expected increment is 1", currentVersion+1, server.getVersion().longValue());
	}
	
	@Test
	public void shouldUpdateLastUpdateDateOnServerAfterUpdate() throws Exception {
		// given 
		Server server = serverRepository.getOne(1);
		LocalDateTime base = LocalDateTime.now();
		
		// when
		server.setName("name2");
		serverRepository.saveAndFlush(server); // we need to force a flush to demonstrate the feature, under normal execution this would happen during transaction commit
		
		// then
		assertNotNull("Last update date must be set", server.getLastUpdateDate());
		assertTrue("Last update date must be updated with current date", base.isBefore(server.getLastUpdateDate()));
	}
}
