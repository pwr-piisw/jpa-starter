package com.capgemini.jpa.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jpa.entities.Server;
import com.capgemini.jpa.repositories.ServerRepository;

@Service
@Transactional
public class ServerServiceImpl implements ServerService {

	@Autowired
	private ServerRepository repository;
	
	@Override
	public Optional<Server> findByName(String name) {
		return repository.findByName(name);
	}

}
