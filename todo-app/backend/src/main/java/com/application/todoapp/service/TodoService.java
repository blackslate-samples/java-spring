package com.application.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.todo.entity.Todo;
import com.application.todo.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepo;

	public List<Todo> fetchAllTodos(){
		return todoRepo.fetchAllTodos(); 
	}
	
	public Todo updateTodoItem(Integer id, Todo todoItem) {
		
		Optional<Todo> todoOpt = todoRepo.fetchAllTodos()
				.stream()
				.filter(item -> item.getId().equals(id))
				.findAny();
		
		if (todoOpt.isPresent()) {
			Todo item = todoOpt.get();
			item.setIsDone(todoItem.getIsDone());
			item.setTask(todoItem.getTask());
			return item;
		}
		
		return null;
		
	}
	
	public Todo createNewTodoItem() {
		Todo todoItem = new Todo();
		todoItem.setIsDone(false);
		todoItem = todoRepo.save(todoItem);
		todoItem.setTask("Click to edit task name");
		return todoItem;
	}
	
	public void deleteTodoItem(Integer id) {
		todoRepo.delete(id);
	}
}

