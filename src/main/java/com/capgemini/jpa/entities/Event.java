package com.capgemini.jpa.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Event {

	@Id
	@SequenceGenerator(name = "EVENT_ID_GENERATOR", sequenceName = "EVENT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENT_ID_GENERATOR")
	private Integer id;

	@Column(nullable=false)
	private LocalDateTime time;
	private int duration;
	@Column(length = 10)
	private String threadId;
	@Column(length = 30)
	private String userId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SERVER_ID", nullable=false)
	private Server server;
	@Column
	private boolean analysisRequired;

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getThreadId() {
		return threadId;
	}

	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public Integer getId() {
		return id;
	}

	public boolean isAnalysisRequired() {
		return analysisRequired;
	}

	public void setAnalysisRequired(boolean analysisRequired) {
		this.analysisRequired = analysisRequired;
	}

}
