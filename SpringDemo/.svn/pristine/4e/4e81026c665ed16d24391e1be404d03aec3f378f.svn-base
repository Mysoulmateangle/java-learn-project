package com.qfedu.demo.spring.service.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qfedu.demo.spring.dao.UserDao;
import com.qfedu.demo.spring.service.UserService;

public class UserServiceImpl implements UserService {
	private static Logger LOG = LogManager.getLogger(UserServiceImpl.class);

	/**
	 * 此处通过spring的xml文件注入
	 */
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void getUser() {
		LOG.info("getUser in service....");
		userDao.getUser();
	}
}
