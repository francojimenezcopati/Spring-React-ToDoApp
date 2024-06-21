package com.example.demo.task;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Task {
	@Id
	@SequenceGenerator(
			name = "tasks_sequence",
			sequenceName = "tasks_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "tasks_sequence"
	)
	private Long id;
	private String title;
	private String description;
	private Boolean done;
	private LocalDate created;
	
	public Task() {
		this.created = LocalDate.now();
	}
	
	public Task(Long id, String title, String description, Boolean done) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.done = done;
		this.created = LocalDate.now();
	}
	
	public Task(String title, String description, Boolean done) {
		this.title = title;
		this.description = description;
		this.done = done;
		this.created = LocalDate.now();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Boolean getDone() {
		return done;
	}
	
	public void setDone(Boolean done) {
		this.done = done;
	}
	
	public LocalDate getCreated() {
		return created;
	}
	
	public void setCreated(LocalDate created) {
		this.created = created;
	}
	
	@Override
	public String toString() {
		return "Task{" +
				"id=" + id +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", done=" + done +
				", created=" + created +
				'}';
	}
}
