package com.qfedu.demo.spring.ioc.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qfedu.demo.spring.ioc.Person;
import com.qfedu.demo.spring.ioc.Person2;
import com.qfedu.demo.spring.ioc.Person3;
import com.qfedu.demo.spring.service.UserService;

public class AnnotationTest {
	private static Logger LOG = LogManager.getLogger(AnnotationTest.class);
	
	/**
	 * 根据名称和类型获取bean
	 */
	@Test
	public void test01() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person p = context.getBean(Person.class);
		LOG.info(p);
		Person p2 = context.getBean("person1", Person.class);
		LOG.info(p2);
	}
	
	/**
	 * scope=prototype
	 */
	@Test
	public void test02() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LOG.info("spring started...");
		Person2 p = context.getBean(Person2.class);
		LOG.info(p);
		Person2 p2 = context.getBean("person2", Person2.class);
		LOG.info(p2);
		LOG.info("p == p2:" + (p == p2));
	}
	
	/**
	 * lazy
	 */
	@Test
	public void test03() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LOG.info("spring started...");
		Person3 p = context.getBean(Person3.class);
		LOG.info(p);
		Person3 p2 = context.getBean(Person3.class);
		LOG.info(p2);
		LOG.info("p == p2 : " + (p == p2));
	}
	
	/**
	 * @Configuration @Bean @Primary
	 */
	@Test
	public void test04 () {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LOG.info("spring started...");
		Person p = context.getBean(Person.class);
		LOG.info(p);
		Person p2 = context.getBean("createPerson", Person.class);
		LOG.info(p2);
		LOG.info("p == p2 : " + (p == p2));
	}
	
	/**
	 * @Configuration @Bean @Primary 通过方法参数类型注入bean
	 */
	@Test
	public void test05 () {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LOG.info("spring started...");
		Person2 p = context.getBean("createPerson2", Person2.class);
		LOG.info(p);
	}
	
	/**
	 * service-dao
	 */
	@Test
	public void test06 () {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LOG.info("spring started...");
		UserService userService = context.getBean(UserService.class);
		userService.getUser();
	}
	
	/**
	 * 在BeanFactoryPostProcessor中更改userService的scope为prototype
	 */
	@Test
	public void test07 () {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LOG.info("spring started...");
		UserService userService = context.getBean(UserService.class);
		UserService userService2 = context.getBean(UserService.class);
		LOG.info("userService == userService2 - " + (userService == userService2));
	}
	
	/**
	 * 在BeanPostProcessor
	 */
	@Test
	public void test08 () {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LOG.info("spring started...");
	}
}
