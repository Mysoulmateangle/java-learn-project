package com.qfedu.demo.spring.ioc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
	private static Logger LOG = LogManager.getLogger(MyBeanPostProcessor.class);
	
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		LOG.info("postProcessBeforeInitialization:" + beanName);
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		LOG.info("postProcessAfterInitialization:" + beanName);
		return bean;
	}
}
