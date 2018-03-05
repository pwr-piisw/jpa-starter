package com.capgemini.jpa.repositories;

import com.capgemini.jpa.entities.Server;

public class ServerStatistic {

	public ServerStatistic(Server server, long count) {
		super();
		this.server = server;
		this.count = count;
	}

	private Server server;
	private long count;

	public Server getServer() {
		return server;
	}

	public long getCount() {
		return count;
	}

}
