package org.jboss.examples.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jboss.examples.model.Intern;
import org.jboss.examples.repo.InternDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("deprecation")
@Service("userDetailsService")
public class InternsDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private InternDao dao;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		List<Intern> interns = dao.getAll();
		Intern intern = null;
		for (Intern intern2 : interns) {
			if(intern2.getFullName().equals(username)){
				intern = intern2;
			}
		}
		
		if (intern == null)
			throw new UsernameNotFoundException("user not found");

		String name = intern.getFullName();
	    String password = intern.getEmail();
	    boolean enabled = true;
	    boolean accountNonExpired = true;
	    boolean credentialsNonExpired = true;
	    boolean accountNonLocked = true;

	    Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	    authorities.add(new GrantedAuthorityImpl("ROLE_INTERN"));

	    User user = new User(name, password, enabled,
	      accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	    return user;
	}

}
