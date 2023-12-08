package com.application.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.todo.entity.Todo;
import com.application.todo.service.TodoService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	// Fetch Todo Items
	@GetMapping("/api/todoItems")
	public ResponseEntity<?> fetchAllTodos(){
		List<Todo> todoItems = todoService.fetchAllTodos();		
		return ResponseEntity.ok(todoItems);
		
	}
	
	@PostMapping("/api/todoItems")
	public ResponseEntity<?> createNewTodoItem(){
		// calling the service for addition
		Todo todoItem = todoService.createNewTodoItem();
		//Return
		return ResponseEntity.ok(todoItem);
	}
	
	@PutMapping("/api/todoItems/{id}")
	public ResponseEntity<?> updateTodoItem(@PathVariable Integer id, @RequestBody Todo todoItem){
		// Calling service for updation
		Todo updatedTodoItem = todoService.updateTodoItem(id,todoItem);
		// Return
		return ResponseEntity.ok(updatedTodoItem); 
		
	}
	
	@DeleteMapping("/api/todoItems/{id}")
	public ResponseEntity<?> deleteTodoItem(@PathVariable Integer id){
		// Calling service for deletion
		todoService.deleteTodoItem(id);
		// Return
		return ResponseEntity.ok("ok");	
	}
}

