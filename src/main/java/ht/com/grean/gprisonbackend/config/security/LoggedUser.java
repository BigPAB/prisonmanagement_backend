package ht.com.grean.gprisonbackend.config.security;

import ht.com.grean.gprisonbackend.model.Gestionneur;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class LoggedUser extends org.springframework.security.core.userdetails.User {

    @Getter
    private Gestionneur user;

    public LoggedUser(Gestionneur user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), authorities);
        this.user = user;
    }
}
