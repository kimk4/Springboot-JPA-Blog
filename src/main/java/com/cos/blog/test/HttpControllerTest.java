package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest";
	
	// http://localhost:8000/blog/http/lombok
	@GetMapping("/http/lombok")
	public String lombokTest() {
		//Member m = new Member(1, "username", "password", "email");
		Member m = Member.builder().username("ssar").password("1234").email("email").build();
		System.out.println(TAG + " : getter : " + m.getUsername());	
		m.setUsername("aa");
		System.out.println(TAG + " : getter : " + m.getUsername());
		//Member m2 = new Member();
				
		return "lombok test 완료";
	}

	// http://localhost:8000/blog/http/get (select)
	@GetMapping("/http/get")
	public String getTest(Member m) {		
		return "get 요청" + m.getId() + " , " + m.getUsername() + " , " + m.getPassword() + " , " + m.getEmail();
	}
	
	// http://localhost:8000/blog/http/post (insert)
	@PostMapping("/http/post")	//text/plain, application/json
	public String postTest(@RequestBody Member m) {	//MessageConvert(스프링부트)
		//return "post 요청" + text;
		return "post 요청" + m.getId() + " , " + m.getUsername() + " , " + m.getPassword() + " , " + m.getEmail();
	}
	
	// http://localhost:8000/blog/http/put (update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		//return "put 요청";
		return "put 요청" + m.getId() + " , " + m.getUsername() + " , " + m.getPassword() + " , " + m.getEmail();
	}
	
	// http://localhost:8000/blog/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}	
}
