package com.example;

import java.util.List;
import java.util.Map;

public interface UserRepositoryCustom {

	Map<String, Object> findUserBySearcher(int pageNo, int pageSize, String username);

	List<UserDoc> userDocList(int pageNo, int pageSize, String username);

	void saveJson(String json);

	void aggregate();
}
