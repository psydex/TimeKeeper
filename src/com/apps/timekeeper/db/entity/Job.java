package com.apps.timekeeper.db.entity;

import com.j256.ormlite.field.DatabaseField;

public class Job {

	@DatabaseField(generatedId = true)
	int id;

	@DatabaseField
	String clientName;

	@DatabaseField
	String jobName;

	@DatabaseField
	long startTime;

	@DatabaseField
	long stopTime;

	@DatabaseField
	long timeWorked;

	public Job() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getStopTime() {
		return stopTime;
	}

	public void setStopTime(long stopTime) {
		this.stopTime = stopTime;
	}

	public long getTimeWorked() {
		return timeWorked;
	}

	public void setTimeWorked(long timeWorked) {
		this.timeWorked = timeWorked;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("id: ").append(id).append(", ");
		sb.append("clientName: ").append(clientName).append(", ");
		sb.append("jobName: ").append(jobName).append(", ");
		sb.append("startTime: ").append(startTime).append(", ");
		sb.append("stopTime: ").append(stopTime).append(", ");
		sb.append("timeWorked: ").append(timeWorked);
		return sb.toString();
	}
}
