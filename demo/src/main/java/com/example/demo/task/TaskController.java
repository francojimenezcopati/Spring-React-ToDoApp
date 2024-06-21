package com.example.demo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tasks")
public class TaskController {
	
	private final TaskService taskService;
	
	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping(path = {"/", ""})
	public List<Task> listTasks() {
		return taskService.listTasks();
	}
	
	@PostMapping(path = {"/", ""})
	public void createTask(@RequestBody Task task) {
		taskService.createTask(task);
	}
	
	@GetMapping(path = {"{taskId}", "{taskId}/"})
	public Task getSingleTask(@PathVariable("taskId") Long taskId){
		return taskService.getSingleTask(taskId);
	}
	
	@PutMapping(path = {"{taskId}", "{taskId}/"})
	public void updateTask(@PathVariable("taskId") Long taskId, @RequestBody Task task) {
		taskService.updateTask(taskId, task);
	}
	
	@DeleteMapping(path = {"{taskId}", "{taskId}/"})
	public void deleteTask(@PathVariable("taskId") Long taskId) {
		taskService.deleteTask(taskId);
	}
}
