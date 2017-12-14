package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class UserRepositoryCustomImpl implements UserRepositoryCustom{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Map<String, Object> findUserBySearcher(int pageNo, int pageSize, String username) {
		Criteria criteria = new Criteria();
		if(null != username && !username.equals("")) {
			criteria.andOperator(
					Criteria.where("username").exists(true),
					Criteria.where("article.name").exists(true));
		}
		
		Query query = new Query(criteria);
		query.skip((pageNo-1)*pageSize);
		query.limit(pageSize);
		List<Order> ltOrder = Arrays.asList(Order.asc("article.name"),Order.desc("_id"));
		query.with(Sort.by(ltOrder));
		List<UserDoc> users = this.mongoTemplate.find(query, UserDoc.class);
		long count = this.mongoTemplate.count(query, UserDoc.class);
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("recordsTotal", count);
		result.put("recordsFiltered", count);
		result.put("data", users);
		
		return result;
	}

	public List<UserDoc> userDocList(int pageNo, int pageSize, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveJson(String json) {
		// TODO Auto-generated method stub
		
	}

	public void aggregate() {
		// TODO Auto-generated method stub
		
	}

}
