package com.capgemini.jpa.tasks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jpa.entities.Event;
import com.capgemini.jpa.entities.RequestEvent;
import com.capgemini.jpa.entities.Server;
import com.capgemini.jpa.repositories.ServerRepository;
import com.capgemini.jpa.repositories.ServerStatistic;
import com.capgemini.jpa.services.ServerService;
import com.capgemini.jpa.services.ServerServiceImpl;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Task7 {

	@TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public ServerService serverService() {
            return new ServerServiceImpl();
        }
    }
	
	@Autowired
	private ServerService serverService;
	
	@Autowired // TODO: configure as mockrepository
	private ServerRepository serverRepositoryMock;
	
	@Test
	public void shouldReturnMockServer() throws Exception {
		// given
		String serverName = "dummyName";
		String mockServerName = "Alex";
		String mockServerIp = "noIp";
		Server dummyServer = new Server(mockServerName, mockServerIp);
		whenSerachingForNameReturn(serverName, dummyServer);
		
		// when
		Optional<Server> result = serverService.findByName(serverName);
		
		// then
		assertTrue("should return mocked result", result.isPresent());
		assertEquals(mockServerName, result.get().getName());
		assertEquals(mockServerIp, result.get().getIp());
	}

	private void whenSerachingForNameReturn(String serverName, Server dummyServer) {
		// TODO: add your mock definition here
	}
}
