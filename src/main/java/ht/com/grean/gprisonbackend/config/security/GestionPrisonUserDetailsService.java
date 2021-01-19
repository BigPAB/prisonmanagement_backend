package ht.com.grean.gprisonbackend.config.security;

import ht.com.grean.gprisonbackend.model.Gestionneur;
import ht.com.grean.gprisonbackend.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class GestionPrisonUserDetailsService implements UserDetailsService {

    private UserService service;

    public GestionPrisonUserDetailsService(UserService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Gestionneur user = service.loadUserByUsername(username);
        if (user != null) {
            return new LoggedUser(user, Collections.emptyList());
        }
        else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
