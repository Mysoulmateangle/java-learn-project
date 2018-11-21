package com.qfedu.demo.spring.ioc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PersonFactory {
	private static Logger LOG = LogManager.getLogger(PersonFactory.class);
	
	public PersonFactory () {
		LOG.info("new PersonFactory...");
	}
	
	public static Person createPerson () {
		LOG.info ("static createPerson()...");
		return new Person ("李四", 22);
	}
	
	public Person createPerson2 () {
		LOG.info ("nonstatic createPerson2()...");
		return new Person ("王五", 18);
	}
}
