package com.capgemini.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class SqlEvent extends Event {

	@Column(length = 4000, nullable = false)
	private String sqlQuery;

	public String getSqlQuery() {
		return sqlQuery;
	}

	public void setSqlQuery(String sqlQuery) {
		this.sqlQuery = sqlQuery;
	}

}
