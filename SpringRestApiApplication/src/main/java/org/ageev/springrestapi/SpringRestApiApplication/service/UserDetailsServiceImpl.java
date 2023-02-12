package org.ageev.springrestapi.SpringRestApiApplication.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service("myUserService")
public class UserDetailsServiceImpl implements UserDetailsService {
    private final Map<String, UserDetails> repository = new HashMap<>();
    
    {
        UserDetails userAdmin = new User("admin", "123", Collections.singleton(new SimpleGrantedAuthority("ADMIN")));
        UserDetails userSimple = new User("user", "pass", Collections.singleton(new SimpleGrantedAuthority("USER")));
        repository.put(userAdmin.getUsername(), userAdmin);
        repository.put(userSimple.getUsername(), userSimple);
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.get(username);
    }
}
