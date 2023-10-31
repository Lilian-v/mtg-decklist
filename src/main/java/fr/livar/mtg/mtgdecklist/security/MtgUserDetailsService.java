package fr.livar.mtg.mtgdecklist.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.livar.mtg.mtgdecklist.persistence.model.User;
import fr.livar.mtg.mtgdecklist.persistence.model.UserRepository;

@Service
public class MtgUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<User> results = userRepository.findByUserName(username);
		if (results.size() == 1) {
			return new MtgUserDetails(results.get(0));
		}
		
		throw new UsernameNotFoundException("Could not find " + username);
	}

}
