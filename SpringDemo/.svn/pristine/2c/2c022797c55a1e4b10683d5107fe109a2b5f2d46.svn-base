package com.qfedu.demo.spring.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.qfedu.demo.spring.dao.UserDao;
import com.qfedu.demo.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static Logger LOG = LogManager.getLogger(UserServiceImpl.class);

	public UserServiceImpl() {
		super();
		LOG.info("new UserServiceImpl()...");
	}

	/**
	 * 此处通过spring的xml文件注入
	 */
	@Resource // @Autowired // @Resource 
	private UserDao userDao;
	
	public void getUser() {
		LOG.info("getUser in service....");
		userDao.getUser();
	}
}
