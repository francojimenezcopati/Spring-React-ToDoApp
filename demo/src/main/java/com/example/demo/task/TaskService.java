package com.example.demo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class TaskService {
	
	private final TaskRepository taskRepository;
	
	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public List<Task> listTasks() {
		return taskRepository.findAll();
	}
	
	public void createTask(Task task) {
		if (taskRepository.findTaskByTitle(task.getTitle()).isPresent()) {
			throw new IllegalComponentStateException("Title already taken");
		}
		
		taskRepository.save(task);
	}
	
	public void deleteTask(Long taskId) {
		if (!taskRepository.existsById(taskId))
			throw new IllegalComponentStateException("Task with id " + taskId + " not found");
		
		taskRepository.deleteById(taskId);
	}
	
	public void updateTask(Long taskId, Task task) {
		Task taskToUpdate = taskRepository.findById(taskId).orElseThrow(() -> new IllegalComponentStateException("Task with id " + taskId + " not found"));
		
		if (taskRepository.findTaskByTitle(task.getTitle()).isPresent())
			throw new IllegalComponentStateException("Title already taken");
		
		taskToUpdate.setTitle(task.getTitle());
		taskToUpdate.setDescription(task.getDescription());
		taskToUpdate.setDone(task.getDone());
		
		taskRepository.save(taskToUpdate);
	}
	
	public Task getSingleTask(Long taskId) {
		Task task = taskRepository.findById(taskId).orElseThrow(() -> new IllegalComponentStateException("Task with id " + taskId + " not found"));
		return task;
	}
}
