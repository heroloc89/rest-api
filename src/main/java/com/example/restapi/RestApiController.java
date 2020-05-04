package com.example.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/v1")
@EnableConfigurationProperties
public class RestApiController {
	private List<Todo> todoList;

	@Autowired
	LodaAppProperties lodaAppProperties;

	@PostConstruct
	public void init(){
		// Thêm null vào List để bỏ qua vị trí số 0;
//		todoList.add(null);
		todoList = IntStream.range(0, 10)
				.mapToObj(i -> new Todo(lodaAppProperties.getEmail() + i, lodaAppProperties.getGoogleAnalyticsId() + i))
				.collect(Collectors.toList());
	}

	@GetMapping("/todo")
	public List<Todo> getTodoList() {
		return todoList;
	}

	@GetMapping("/todo/{todoId}")
	public Todo getToDo(@PathVariable(name = "todoId") Integer todoId) {
		return todoList.get(todoId);
	}

	@PutMapping("/todo/{todoId}")
	public Todo editTodo(@PathVariable(name = "todoId") Integer todoId, @RequestBody Todo todo) {
		todoList.set(todoId, todo);
		return todo;
	}

	@DeleteMapping("/todo/{todoId}")
	public ResponseEntity deleteTodo(@PathVariable(name = "todoId") Integer todoId){
		todoList.remove(todoId.intValue());
		return ResponseEntity.ok().build();
	}

	@PostMapping("/todo")
	public ResponseEntity addTodo(@RequestBody Todo todo) {
		todoList.add(todo);
		// Trả về response với STATUS CODE = 200 (OK)
		// Body sẽ chứa thông tin về đối tượng todo vừa được tạo.
		return ResponseEntity.ok().body(todo);
	}

}
