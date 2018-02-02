package cl.button.panic.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.button.panic.model.ApplicationUser;
import cl.button.panic.repository.UserRepository;

@RestController
@RequestMapping(path = "/login")
public class LoginController {

	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public LoginController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping(path ="/sign-up")
	public void addNewUser(@RequestBody ApplicationUser user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		
	}
	
}
