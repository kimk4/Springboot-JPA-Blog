package com.cos.blog.MySpringApp.ToDoItem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.*;

@Getter @Setter
@RestController
@RequestMapping("/todo")
public class ToDoItemController {
	
	@Autowired
	private ToDoItemService todoItemService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody ToDoItemResponse get(@PathVariable(value="id") String id) {
		
		List<String> errors = new ArrayList<>();		
		ToDoItem toDoItem = null;		
		try {
			toDoItem = todoItemService.get(id);			
		} catch (final Exception e) {
			errors.add(e.getMessage());
		}
		
		
		return ToDoItemAdapter.toDoItemResponse(toDoItem, errors);
	}
		
}
