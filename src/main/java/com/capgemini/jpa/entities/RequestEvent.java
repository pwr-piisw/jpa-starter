package com.capgemini.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class RequestEvent extends Event {

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private HttpMethod method;

	public HttpMethod getMethod() {
		return method;
	}

	public void setMethod(HttpMethod method) {
		this.method = method;
	}

}
