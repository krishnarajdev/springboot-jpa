package com.mappings.mappings.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mappings.mappings.Domain.Post;
import com.mappings.mappings.Domain.User;
import com.mappings.mappings.Service.UserService;

@RestController()
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public ResponseEntity<?> saveUser(@RequestBody User user) {

		String status = userService.persistUser(user);

		if (status.equalsIgnoreCase("Success")) {
			return new ResponseEntity<>("Success", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Error", HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping("/user/info")
	public ResponseEntity<?> getUser(@RequestParam(name = "firstName", defaultValue = "abirami") String firstName){
		List<User> user = null;
		user = userService.getUser(firstName);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	
	@PostMapping("/post")
	public ResponseEntity<?> saveUser(@RequestBody Post post) {

		String status = userService.savePost(post);

		if (status.equalsIgnoreCase("Success")) {
			return new ResponseEntity<>("Success", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Error", HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping("/post/info")
	public ResponseEntity<?> getPostInfo(@RequestParam(name = "title") String title) throws Exception{
		Post post = userService.getpost(title);
		
		HashMap<String, Object> map = new HashMap<>();
	    map.put("results", post);
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

}
