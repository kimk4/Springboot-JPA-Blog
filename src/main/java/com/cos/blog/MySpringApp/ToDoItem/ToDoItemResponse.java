package com.cos.blog.MySpringApp.ToDoItem;

import java.util.List;

import com.cos.blog.MySpringApp.ApiResponse.ApiResponse;

import lombok.*;

public class ToDoItemResponse extends ApiResponse<ToDoItem>{

	@Builder
	public ToDoItemResponse(final ToDoItem toDoItem, final List<String> errors) {
		super(toDoItem);

		this.setErros(errors);
	}

}
