package com.capgemini.jpa;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jpa.entities.Server;
import com.capgemini.jpa.services.ServerService;
import com.capgemini.jpa.services.ServerServiceImpl;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ServerServiceTest {

	@TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public ServerService serverService() {
            return new ServerServiceImpl();
        }
    }
	
	@Autowired
	private ServerService serverService;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test
	public void shouldReturnServerByName() throws Exception {
		// given
		String serverName = "myServerName";
		String ip = "127.0.0.1";
		Server server = new Server(serverName, ip);
		testEntityManager.persistAndFlush(server);
		
		// when
		Optional<Server> result = serverService.findByName(serverName);
		
		// then
		assertTrue(result.isPresent());
		assertEquals(serverName, result.get().getName());
		assertEquals(ip, result.get().getIp());
		assertEquals(server.getId(), result.get().getId());
	}

}
