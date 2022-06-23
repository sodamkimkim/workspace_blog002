package com.example.jpa_basic_crud.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa_basic_crud.model.User;
import com.example.jpa_basic_crud.repository.UserRepository;

@Service
public class UserService {

	@Autowired // 자동으로 초기화까지 해줌
	private UserRepository userRepository;

	public int joinUser(User user) {

		try {
			userRepository.save(user);
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}
	
	@Transactional(readOnly = true)
	public User login(User user) {
		// repository select 요청
		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
}
