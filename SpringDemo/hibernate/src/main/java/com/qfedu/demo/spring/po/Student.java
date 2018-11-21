package com.qfedu.demo.spring.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 学生
 * @author cailei
 * @date 2018年11月21日
 */
@Entity
@Table(name = "t_student")
public class Student {
	private static Logger LOG = LogManager.getLogger(Student.class);
	
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
	 * 班级
	 */
	@ManyToOne
	@JoinColumn(name = "clazz_id")
	private Clazz clazz;

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

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
	
}
