package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;

import com.mongodb.MongoClient;
/**
 * 
 * 类名称：SpringMongoConfig   
 * 类描述：   
 * 创建人：xxx   
 * 创建时间：2017年12月14日 下午3:20:02 
 * @version
 */
@Configuration
@ComponentScan("com.example")
@EnableMongoRepositories(basePackages= {"com.example"})
public class SpringMongoConfig extends AbstractMongoConfiguration{


	@Override
	protected String getDatabaseName() {
		return "mydb";
	}
	@Override
	@Bean
	public MongoClient mongoClient() {
		return new MongoClient("127.0.0.1");
	}

}
