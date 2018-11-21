package com.qfedu.demo.spring.ioc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Car {
	private static Logger LOG = LogManager.getLogger(Car.class);
	
	private String name;
	
	private String color;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + "]";
	}

	public Car() {
		super();
		LOG.info("new Car...");
	}

	public Car(String name, String color) {
		super();
		this.name = name;
		this.color = color;
		LOG.info("new Car(name, color)...");
	}
	
}
