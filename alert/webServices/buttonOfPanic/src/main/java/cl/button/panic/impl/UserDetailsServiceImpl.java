package cl.button.panic.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.button.panic.model.ApplicationUser;
import cl.button.panic.repository.UserRepository;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



	@Override
	public UserDetails loadUserByUsername(String emailClient) throws UsernameNotFoundException {
		ApplicationUser user = userRepository.findByEmailClient(emailClient);
		if (user == null) {
			throw new UsernameNotFoundException(emailClient);
		}
		return new User(user.getEmailClient(), user.getPassword(), emptyList());
	}

}
