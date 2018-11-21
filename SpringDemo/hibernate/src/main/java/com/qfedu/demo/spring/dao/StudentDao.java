package com.qfedu.demo.spring.dao;

import com.qfedu.demo.spring.po.Student;

public interface StudentDao {

	void create (Student s);
	
	void update (Student s);
	
	Student findById (String id);
	
	void delete (String id);
}
