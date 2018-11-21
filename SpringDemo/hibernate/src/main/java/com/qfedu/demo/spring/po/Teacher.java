package com.qfedu.demo.spring.po;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 老师
 * @author cailei
 * @date 2018年11月21日
 */
@Entity
@Table(name = "t_teacher")
public class Teacher {
	
	private static Logger LOG = LogManager.getLogger(Teacher.class);
	
	/**
	 * ID
	 */
	@Id
	@Column (length = 50)
	private String id;
	
	/**
	 * 姓名
	 */
	@Column (length = 50, nullable = false)
	private String name;
	
	/**
	 * 薪资
	 */
	@Column (precision = 10, scale = 2)
	private Double salary;
	
	/**
	 * 任课班级
	 */
	@ManyToMany(mappedBy = "courseTeachers") // 放弃关系数据的维护
	private List<Clazz> clazzs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public List<Clazz> getClazzs() {
		return clazzs;
	}

	public void setClazzs(List<Clazz> clazzs) {
		this.clazzs = clazzs;
	}
	
}
