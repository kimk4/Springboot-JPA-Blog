package com.cos.blog.MySpringApp.ToDoItem;

import org.springframework.stereotype.Service;

@Service
public class ToDoItemService {

	public ToDoItem get(final String id) {
		
		return ToDoItem.builder()
				.id(id)
				.title("Add an id validation")
				.build();
	}
}
