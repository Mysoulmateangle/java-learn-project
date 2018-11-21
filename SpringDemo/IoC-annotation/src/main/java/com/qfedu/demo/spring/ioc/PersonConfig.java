package com.qfedu.demo.spring.ioc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PersonConfig {
	private static Logger LOG = LogManager.getLogger(PersonConfig.class);
	
	@Bean// ("xxx")
	@Primary
	public Person createPerson () {
		LOG.info("createPerson...");
		return new Person ("李四", 33);
	}
	
	@Bean// ("xxx")
	public Person2 createPerson2 (Person3 person3) {
		return new Person2 (person3.getName(), 33);
	}
	
}
