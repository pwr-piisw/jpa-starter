package com.capgemini.jpa.services;

import java.util.Optional;

import com.capgemini.jpa.entities.Server;

public interface ServerService {
	Optional<Server> findByName(String name);
}
