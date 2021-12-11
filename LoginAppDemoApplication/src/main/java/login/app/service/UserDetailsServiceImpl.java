package login.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import login.app.entity.UserForm;
import login.app.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<UserForm> userList = userRepository.findByname(username);
		UserForm userForm = userList.get(0);

		if (null == userList || userList.isEmpty() ) {
            throw new UsernameNotFoundException("Username not found");
        }
		
		String dbUserName = userForm.getName();

		if (dbUserName == null) {
			throw new UsernameNotFoundException("User not authorized.");
		}
				
		Collection <GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		
		
//		GrantedAuthority authority = new SimpleGrantedAuthority(userForm.getAuthority());

		grantList.add(userForm.getAuthority());

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = encoder.encode(userForm.getPassword());

		UserDetails userDetails = (UserDetails) new User(username, password, grantList);
		return userDetails;
	}

}
