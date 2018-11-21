package com.qfedu.demo.spring.test;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qfedu.demo.spring.dao.StudentDao;
import com.qfedu.demo.spring.po.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentTest {
	private static Logger LOG = LogManager.getLogger(StudentTest.class);
	
	@Resource // - byName // @Autowired - byType
	private StudentDao studentDao;
	
	@Test
	@Transactional
	@Rollback (false)
	public void test () {
		Student s = new Student ();
		s.setId("1");
		s.setName("张三");
		this.studentDao.create(s);
	}
	
}
