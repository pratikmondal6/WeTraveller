package com.weTraveller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class SpringSecurityUtil {

	@Autowired
	private Environment env;

	/**
	 * Get current logged in user model
	 * @return UserModel
	 */
	public AuthUser getLoggedUser() {
		AuthUser uModel = null;
		try {
			if(SecurityContextHolder.getContext() != null && 
			   SecurityContextHolder.getContext().getAuthentication() != null && 
			   SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null &&
			   SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof AuthUser){
				uModel = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return uModel;
	}

	/**
	 * Get current logged in user id
	 * @return String
	 */
    public long getLoggedUserId() {
        long userId = 0;
        try {
			AuthUser uModel = getLoggedUser();
			userId = uModel != null ? uModel.getId() : 0;
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return userId;
    }
    
    public boolean isAuthenticated() {
    	try {
    		return getLoggedUser() != null;
		} catch (Throwable t) {
			t.printStackTrace();
		}
        return false;
    }

	public boolean hasRole(String role) {
		// get security context from thread local
		SecurityContext context = SecurityContextHolder.getContext();
		if (context == null)
			return false;

		Authentication authentication = context.getAuthentication();
		if (authentication == null)
			return false;

		for (GrantedAuthority auth : authentication.getAuthorities()) {
			if (role.equals(auth.getAuthority()))
				return true;
		}

		return false;
	}

	public boolean isAdmin() {
		return hasRole(env.getProperty("role.admin"));
	}

	public boolean isReviewer() {
		return hasRole(env.getProperty("role.reviewer"));
	}

}
