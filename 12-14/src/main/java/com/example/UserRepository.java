package com.example;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDoc, Long>,UserRepositoryCustom{
	UserDoc findByUsername(String Username);
	UserDoc findByArticleName(String articename);
	List<UserDoc> findByUsernameLikeAndArticleNameLike(String username,String articleName);
	List<UserDoc> findById(String userid);
	List<UserDoc> findByIdBetween(String userid1,String userid2);
	Map<String, Object> findUserBySearcher(int pageNo, int pageSize, String username);
	@Query("{'_id':?0,'article.name':{'$regex':?1}}")
	List<UserDoc> searchUsers(String userid,String desc);
	
}
