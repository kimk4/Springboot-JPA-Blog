package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

//스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌.IOC를 해줌
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;	
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public void 회원가입(User user) {
		/*try {
			userRepository.save(user);
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("UserService : 회원가입();" + e.getMessage());
		}
		return -1;*/
		
		String rawPassword = user.getPassword();			//원문
		String encPassword = encoder.encode(rawPassword);	//해쉬
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
	
	/*
	@Transactional(readOnly = true) // Select 할때 트렉잭션 시작, 서비스 종료시에 트렌잭션 종료(정합성)
	public User 로그인(User user) { 
		//System.out.println("user===>" + user );
		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}*/
	
}
