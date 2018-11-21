package com.qfedu.demo.spring.ioc.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qfedu.demo.spring.ioc.Person;
import com.qfedu.demo.spring.service.UserService;

public class InjectionTest {
	private static Logger LOG = LogManager.getLogger(InjectionTest.class);

	/**
	 * 属性注入
	 */
	@Test
	public void testProperty() {
		// spring上下文
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-injection.xml");
		LOG.info("Spring started...");
		// 根据类型获取bean
		Person p = context.getBean(Person.class);
		LOG.info(p);
	}

	/**
	 * bean注入
	 */
	@Test
	public void testBean() {
		// spring上下文
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-injection-bean.xml");
		LOG.info("Spring started...");
		// 根据类型获取bean
		Person p = context.getBean(Person.class);
		LOG.info(p);
	}

	/**
	 * 构造方法注入
	 */
	@Test
	public void testConstructor() {
		// spring上下文
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-injection-constructor.xml");
		LOG.info("Spring started...");
		// 根据类型获取bean
		Person p = context.getBean(Person.class);
		LOG.info(p);
	}

	/**
	 * EL表达式
	 */
	@Test
	public void testEl() {
		// spring上下文
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-el.xml");
		LOG.info("Spring started...");
		// 根据类型获取bean
		Person p = context.getBean("person1", Person.class);
		LOG.info(p);
	}

	@Test
	public void testService() {
		// spring上下文
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-service-dao.xml");
		LOG.info("Spring started...");
		UserService userService = context.getBean(UserService.class);
		userService.getUser();
	}
}
