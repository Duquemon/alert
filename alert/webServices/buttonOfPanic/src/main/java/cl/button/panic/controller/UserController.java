package cl.button.panic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.button.panic.model.ApplicationUser;
import cl.button.panic.repository.UserRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/demo")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping(path = "/add")
	public @ResponseBody void addNewUser(@RequestParam String name, @RequestParam String email,  @RequestParam String lastNameClient) {
		ApplicationUser user = new ApplicationUser();
		user.setNameClient(name);
		user.setLastNameClient(lastNameClient);
		user.setEmailClient(email);
		userRepository.save(user);
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<ApplicationUser> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
	
	@GetMapping(path="/userId")
	public @ResponseBody ApplicationUser getUserById(@RequestParam long id) {
		// This returns a JSON or XML with the users
		return userRepository.findOne(id);
	}

}
