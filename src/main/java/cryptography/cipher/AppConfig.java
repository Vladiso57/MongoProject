package cryptography.cipher;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

import cryptography.cipher.businesslogic.Constants;
import datarepo.IDAO;
import datarepo.MongoHandling;

@Configuration
@EnableMongoRepositories(basePackages = "com.acme.repositories.mongo")
public class AppConfig implements Constants{

	@Bean
	public MongoClient mongoClient() {
		return new MongoClient(HOST, PORT);
	}

	@Bean 
	public MongoOperations mongoTemplate() {
		return new MongoTemplate(mongoClient(), DBNAME);
	}
	
	@Bean
	public IDAO idao() {
		return new MongoHandling();
	}

}
