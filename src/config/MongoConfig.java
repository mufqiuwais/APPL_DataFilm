package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories("film.db")
public class MongoConfig extends AbstractMongoConfiguration {
	
	@Override
	protected String getDatabaseName() {
		return "OrdersDB";
	}
	
	public Mongo mongo() throws Exception {
		return new MongoClient();
	}

	@Override
	public MongoClient mongoClient() {
		// TODO Auto-generated method stub
		return null;
	}
}
