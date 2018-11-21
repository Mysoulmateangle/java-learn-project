package com.qfedu.demo.spring.dao.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.qfedu.demo.spring.dao.UserDao;

public class UserDaoImpl implements UserDao {
	private static Logger LOG = LogManager.getLogger(UserDaoImpl.class);

	public void getUser() {
		LOG.debug(null);
		LOG.info("getUser from db...");
		LOG.warn(null);
		LOG.error(null);
	}
}
