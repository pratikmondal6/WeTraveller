package com.example.weTraveller.security.auth.internal.adapter;


import com.example.weTraveller.security.AuthUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsAdapter implements UserDetails{

	
	private AuthUser authUser;
	private String userId;
	
	public AuthUser getAuthUser() {
		return authUser;
	}

	public void setUserModel(AuthUser authUser) {
		this.authUser = authUser;
	}

	public UserDetailsAdapter(AuthUser authUser) {
		this.authUser = authUser;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();

		if(this.getAuthUser() != null){
			// set role name
			if(StringUtils.isNotEmpty(this.getAuthUser().getRole())) {
				authorityList.add(new AuthorizationAdapter(this.getAuthUser().getRole()));
			}

			// set right name
			if(this.getAuthUser().getRights() != null) {
				for (String right : this.getAuthUser().getRights()) {
					authorityList.add(new AuthorizationAdapter(right));
				}
			}
		}
		return authorityList;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	@Override
	public String getPassword() {
		return authUser.getPassword();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	@Override
	public String getUsername() {
		return authUser.getName();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 */
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 */
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return this.getAuthUser().isActive();
	}

	public long getUserId() {
		return this.getAuthUser().getId();
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

}
