package com.qfedu.demo.spring.ioc.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qfedu.demo.spring.ioc.Person;

public class BeanTest {

	private Logger LOG = LogManager.getLogger(BeanTest.class);

	/**
	 * 根据id或者名称或者类型获取bean
	 */
	@Test
	public void testIdAndName() {
		// spring上下文
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LOG.info("Spring started...");
		// 根据类型获取bean
		Person p = context.getBean(Person.class);
		LOG.info(p);
		// 根据id+类型获取bean
		Person p2 = context.getBean("person1", Person.class);
		LOG.info(p2);
		// 根据name+类型获取bean
		Person p3 = context.getBean("personName", Person.class);
		LOG.info(p3);
		// 根据name获取bean
		Person p4 = (Person)context.getBean("personName");
		LOG.info(p4);
		
		LOG.info("p == p4 : " + (p == p4));
	}
	
	/**
	 * bean的scope属性
	 */
	@Test
	public void testScope() {
		// spring上下文
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-scope.xml");
		LOG.info("Spring started...");
		// 根据类型获取bean
		Person p = context.getBean(Person.class);
		LOG.info(p);
		// 根据id+类型获取bean
		Person p2 = context.getBean("person1", Person.class);
		LOG.info(p2);
		LOG.info("p == p2 : " + (p == p2));
	}
	
	/**
	 * bean的lazy-init属性
	 */
	@Test
	public void testLazy() {
		// spring上下文
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-lazy.xml");
		LOG.info("Spring started...");
		// 根据类型获取bean
		Person p = context.getBean(Person.class);
		LOG.info(p);
	}
	
	/**
	 * bean的primary属性
	 */
	@Test
	public void testPrimary() {
		// spring上下文
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-primary.xml");
		LOG.info("Spring started...");
		// 根据类型获取bean
		Person p = context.getBean(Person.class);
		LOG.info(p);
	}
	
	/**
	 * bean的init-method和destroy-method属性
	 */
	@Test
	public void testInitDestroy() {
		// spring上下文
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-init-destroy.xml");
		LOG.info("Spring started...");
		// 根据类型获取bean
		Person p = context.getBean(Person.class);
		LOG.info(p);
		// 关闭spring
		context.close();
	}
	
	/**
	 * bean的静态工厂方法构建
	 */
	@Test
	public void testStaticFactory() {
		// spring上下文
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-static-factory.xml");
		LOG.info("Spring started...");
		// 根据类型获取bean
		Person p = context.getBean(Person.class);
		LOG.info(p);
	}
	
	/**
	 * bean的非静态工厂方法构建
	 */
	@Test
	public void testNonStaticFactory() {
		// spring上下文
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-nonstatic-factory.xml");
		LOG.info("Spring started...");
		// 根据类型获取bean
		Person p = context.getBean(Person.class);
		LOG.info(p);
	}
}
