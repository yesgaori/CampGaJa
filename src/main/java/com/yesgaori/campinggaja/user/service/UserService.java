package com.yesgaori.campinggaja.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yesgaori.campinggaja.common.EncryptUtils;
import com.yesgaori.campinggaja.user.domain.User;
import com.yesgaori.campinggaja.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Boolean isDuplicateName(String name) {
		
		int count = userRepository.countByName(name);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public Boolean isDuplicateId(String loginId) {
		
		int count = userRepository.countByLoginId(loginId);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public User loginUser(String loginId
					, String password) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		Optional<User> optionalUser = userRepository.findByLoginIdAndPassword(loginId, encryptPassword);
		User user = optionalUser.orElse(null);
		
		return user;
		
	}
	
	public User addUser(
			String loginId
			, String password
			, String name
			, String email) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		User user = User.builder()
						.loginId(loginId)
						.password(encryptPassword)
						.name(name)
						.email(email)
						.build();
		
		return userRepository.save(user);
		
	}
	
	
	
}
