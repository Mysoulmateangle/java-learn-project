package com.qfedu.demo.spring.ioc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Person3 {
	
	private Logger LOG = LogManager.getLogger (Person3.class);	
	
	private String name = "张三";
	
	private Integer age = 30;

	private Car car;
	
	public Person3 () {
		LOG.info("new Person3...");
	}
	
	public Person3(String name, Integer age) {
		super();
		LOG.info("new Person3 (name, age)...");
		this.name = name;
		this.age = age;
	}

	public Person3(String name, Car car) {
		super();
		LOG.info("new Person3 (name, car)...");
		this.name = name;
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		LOG.info("setName...");
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
		LOG.info("setAge...");
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
		LOG.info("setCar...");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", car=" + car + "]";
	}

	public void init () {
		LOG.info("init...");
	}
	
	public void destroy () {
		LOG.info("destroy...");
	}
}
