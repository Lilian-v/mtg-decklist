package fr.livar.mtg.mtgdecklist.api;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.livar.mtg.mtgdecklist.persistence.model.User;
import fr.livar.mtg.mtgdecklist.persistence.model.UserRepository;

@RestController
public class UserController {
	private UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@PostMapping("/user/create")
	public User createUser(@RequestBody User userParam) {
		if (StringUtils.isBlank(userParam.getUserName()) || StringUtils.isBlank(userParam.getUserPassword())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parameters 'userName' and 'userPassword' are mandatory");
		}
		if (userRepository.findByUserName(userParam.getUserName()).size() > 0) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "User " + userParam.getUserName() + " already exist.");
		}
		
		User user = new User(userParam.getUserName(), userParam.getUserPassword(), Locale.getDefault().getLanguage());
		userRepository.save(user);
		return user;
	}
	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable String userId) {
		return null;
	}
	@PutMapping("/user/{userId}")
	public User updateUser(@PathVariable String userId) {
		return null;
	}
	@DeleteMapping("/user/{userId}")
	public void deleteUser(@PathVariable String userId) {
		
	}
	
}
