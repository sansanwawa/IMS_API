package com.ims.api.jakarta.entities;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="apicredential")
public class ApiCredentials extends User implements UserDetails, CredentialsContainer {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "username", columnDefinition = "VARCHAR(80)")
	private String username;
	
	@Column(name = "password", columnDefinition = "VARCHAR(100)")
	private String password;

	
	public ApiCredentials(String username, String password,Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.username = username;
		this.password = password;
	}
	
	public ApiCredentials() {
		 this("x","x",false,false,false,false,toAuthorities(Arrays.asList(new String[] {  "USER_ADMIN" })));
	}
	
	
	private static Collection<GrantedAuthority> toAuthorities( List<String> authorities) {
			Collection<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
			for (String authority : authorities) {
				authorityList.add(new SimpleGrantedAuthority(authority));
			}
			return authorityList;
	}

	
	public ApiCredentials(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
			this.username = username;
			this.password = password;
	}


	
	
	@Override
	public void eraseCredentials() {
		
	}
	 
	 

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
}
