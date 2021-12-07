package com.phucdn.learnSpringSecurity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.phucdn.learnSpringSecurity.entity.UserEntity;
import com.phucdn.learnSpringSecurity.repository.RoleOfUserRepository;
import com.phucdn.learnSpringSecurity.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleOfUserRepository roleOfUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = this.userRepository.findUserAccount(username);
		if (userEntity == null) {
			throw new UsernameNotFoundException("User " + userEntity + " was not found in the database");
		}

		List<String> roleNames = this.roleOfUserRepository.getRoleNames(userEntity.getUserId());
		List<GrantedAuthority> grantList = new ArrayList<>();
		if (roleNames != null) {
			for (String role : roleNames) {
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantList.add(authority);
			}
		}
		UserDetails userDetails = (UserDetails) new User(userEntity.getUserId(), userEntity.getPassword(), grantList);
		return userDetails;
	}

}
