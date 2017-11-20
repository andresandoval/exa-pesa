package com.exa.pesa.core.security;

import com.exa.pesa.core.exceptions.BusinessException;
import com.exa.pesa.core.model.parties.User;
import com.exa.pesa.core.services.parties.PartyService;
import com.exa.pesa.core.util.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Created by Andres on 9/10/2017.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PartyService partyService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = partyService.getUserByLogin(username);
            Asserts.nonNull(user, "El usuario no existe");
            return new org.springframework.security.core.userdetails.User(username, user.getPasswordWeb(), true,
                    true, true, true, this.authorities(user));
        } catch (BusinessException ex) {
            ex.printStackTrace();
            throw new UsernameNotFoundException(username);
        }
    }

    private Collection<SimpleGrantedAuthority> authorities(User user) {
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(user.getRole().getName()));
        return roles;
    }
}
