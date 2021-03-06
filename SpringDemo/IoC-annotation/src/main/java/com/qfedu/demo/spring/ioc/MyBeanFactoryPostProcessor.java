package com.qfedu.demo.spring.ioc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;



@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	private static Logger LOG = LogManager.getLogger(MyBeanFactoryPostProcessor.class);

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFacotry) throws BeansException {
		LOG.info("postProcessBeanFactory...");
		// UserService userService = beanFacotry.getBean(UserService.class);
		beanFacotry.getBeanDefinition("userServiceImpl").setScope("prototype");
	}
}
