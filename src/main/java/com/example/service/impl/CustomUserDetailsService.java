package com.example.service.impl;

import com.example.entity.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AuthServiceImpl authServiceImpl;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String personnelID) throws UsernameNotFoundException {
        Auth auth = authServiceImpl.getById(personnelID);
        if (auth == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        String role = auth.getRole();
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_" + role));

        return new User(
                auth.getPersonnelId(),
//              passwordEncoder.encode(auth.getPassword()),
                auth.getPassword(),
                grantedAuthorityList
        );
    }
}
