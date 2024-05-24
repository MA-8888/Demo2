package com.example.demo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo2.entity.Users;
import com.example.demo2.repository.UsersRepository;

@Service
public class AccountUserDetailsService implements UserDetailsService {
	@Autowired
	private UsersRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		if(userName == null || "".equals(userName)) {
			throw new UsernameNotFoundException("ユーザー名が空です");
		}
		Users user = repository.findById(userName).get();
		if(user != null) {
			return new AccountUserDetails(user);
		}
		throw new UsernameNotFoundException(userName + "は見つかりません。");
	}
}