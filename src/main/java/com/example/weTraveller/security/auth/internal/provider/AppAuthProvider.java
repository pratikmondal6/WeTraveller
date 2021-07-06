package com.example.weTraveller.security.auth.internal.provider;


import com.example.weTraveller.security.AuthUser;
import com.example.weTraveller.security.auth.internal.adapter.UserDetailsAdapter;
import com.example.weTraveller.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppAuthProvider implements AuthenticationProvider, Serializable, UserDetailsService {

    private static final long serialVersionUID = 1L;

    private final UserService userService;
    private List<GrantedAuthority> authorityList;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    public AppAuthProvider(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        authorityList = new ArrayList<GrantedAuthority>();
        AuthUser obj = isUserAuthenticated(auth.getPrincipal().toString(), auth.getCredentials().toString());
        if (obj != null) {
            return new UsernamePasswordAuthenticationToken(obj, "", this.getAuthorityList());
        }
        throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(arg0));
    }

    private AuthUser isUserAuthenticated(String username, String password) {
        AuthUser userModel = null;
        try {
            UserDetailsAdapter userDetails = loadUserByUsername(username);
            if (userDetails.isEnabled() &&  passwordEncoder.matches(password, userDetails.getPassword())) {
                return userDetails.getAuthUser();
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return userModel;
    }


    @Override
    public UserDetailsAdapter loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailsAdapter userDetails = null;
        try {
            AuthUser authUser = new AuthUser(userService.findByEmail(username));
            userDetails = new UserDetailsAdapter(authUser);
            this.setAuthorityList((List<GrantedAuthority>) userDetails.getAuthorities());
        } catch (NoResultException e) {
            throw new UsernameNotFoundException(username);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return userDetails;
    }

    public List<GrantedAuthority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<GrantedAuthority> authorityList) {
        this.authorityList = authorityList;
    }
}
