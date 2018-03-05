package com.capgemini.jpa.entities;

import javax.persistence.Entity;

@Entity
public class ExceptionEvent extends Event {

	private String exceptionName;
	private String occuranceClass;
	private String occuranceMethod;
	private Integer occuranceLine;

	public String getExceptionName() {
		return exceptionName;
	}

	public void setExceptionName(String exceptionName) {
		this.exceptionName = exceptionName;
	}

	public String getOccuranceClass() {
		return occuranceClass;
	}

	public void setOccuranceClass(String occuranceClass) {
		this.occuranceClass = occuranceClass;
	}

	public String getOccuranceMethod() {
		return occuranceMethod;
	}

	public void setOccuranceMethod(String occuranceMethod) {
		this.occuranceMethod = occuranceMethod;
	}

	public Integer getOccuranceLine() {
		return occuranceLine;
	}

	public void setOccuranceLine(Integer occuranceLine) {
		this.occuranceLine = occuranceLine;
	}

}
