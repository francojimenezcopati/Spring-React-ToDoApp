package com.example.demo.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class TaskConfig {
	
	
	@Bean
	CommandLineRunner commandLineRunner(TaskRepository taskRepository) {
		return args -> {
			Task task1 = new Task("Title Test", "desc x", true);
			Task task2 = new Task("Task 2", "desc xaaaaaaaaa", true);

//			taskRepository.save(task1);
//			taskRepository.save(task2);
			taskRepository.saveAll(
					List.of(task1, task2)
			);
		};
	}
}
