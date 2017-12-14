package com.example;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringMongoConfig.class,
loader=AnnotationConfigContextLoader.class)
public class MongdbTestTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MongoService mongoService;
	
	@Test
	public void saveUserTest() {
		UserDoc user = new UserDoc();
		Article article1 = new Article();
		article1.setName("the second day");
		article1.setUrl("http://www.sina.com.cn");
		user.setId("50");
		user.setUsername("xxx");
		user.setArticle(article1);
		
		mongoService.saveUser(user);
		UserDoc user1 = userRepository.findByArticleName("the first day");
		System.out.println(user.getArticle().getName());
	}
	
	@Test
	public void searchUser() {
		Map<String, Object> searcherUser = mongoService.searcherUser(1, 5, "王五");
		System.out.println(searcherUser);
	}
	
}
