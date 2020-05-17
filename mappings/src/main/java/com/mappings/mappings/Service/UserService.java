package com.mappings.mappings.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mappings.mappings.Domain.Post;
import com.mappings.mappings.Domain.User;
import com.mappings.mappings.Repository.PostRepository;
import com.mappings.mappings.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	public String persistUser(User user) {
		try {
			//user.setAddress(user.getAddress());
			userRepository.save(user);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "Error";
		}
		return "Success";
	}

	public List<User> getUser(String name) {
		List<User> user = null;
		try {
			user = userRepository.findByFirstName(name);
		} catch (Exception e) {

		}
		return user;
	}
	
	public Post getpost(String title) {
		Post user = null;
		try {
			user = postRepository.findByTitle(title);
			System.out.println(user.getDetails().getCreatedOn());
		} catch (Exception e) {
			System.out.println("error "+e.getLocalizedMessage());
		}
		return user;
	}
	
	public String savePost(Post post) {
		
		
		/*
		 * PostDetails postDetails = new PostDetails();
		 * postDetails.setCreatedBy("kamal"); postDetails.setCreatedOn(new Date());
		 */
		try {
			post.setDetails(post.getDetails());
			postRepository.save(post);
		}catch(Exception e) {
			return "Error";
		}

		return "Success";
	}

}
