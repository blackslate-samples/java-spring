package com.application.todo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.application.todo.entity.Todo;

@Repository
public class TodoRepository {

	private Integer idCounter =0;
	private List<Todo> todoItems = new ArrayList<>();
	
	public List<Todo> fetchAllTodos(){
		if (todoItems.size() == 0) {
			Todo item1 = new Todo();
			item1.setIsDone(false);
			item1.setTask("Click to edit task name");
			item1.setId(idCounter++);
			
			todoItems.add(item1);
			
		}
		return todoItems;
		 
	}
	
	public Todo save (Todo todoItem) {
		todoItem.setId(idCounter++);
		todoItems.add(todoItem); 
		return todoItem;
		
	}
	
	public void delete(Integer id) {
		todoItems = todoItems.stream()
				 .filter(todoItem -> !todoItem.getId().equals(id))
				 .collect(Collectors.toList());
	}
}

