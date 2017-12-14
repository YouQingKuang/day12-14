package com.example;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class MongoService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public MongoService() {
		
	}
	
	public void saveUser(UserDoc user) {
		userRepository.save(user);
	}
	
	public UserDoc findUserByName(String username) {
		return userRepository.findByUsername(username);
	}
	
	public Map<String, Object> searcherUser(int pageNo,int pageSize,String username){
		Map<String, Object> findUserBySearcher = userRepository.findUserBySearcher(pageNo, pageSize, username);
		return findUserBySearcher;
	}
}
