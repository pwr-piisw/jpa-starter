package com.capgemini.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.jpa.entities.Server;

public interface ServerRepository extends JpaRepository<Server, Integer> {

	public Optional<Server> findByName(String name);
}
