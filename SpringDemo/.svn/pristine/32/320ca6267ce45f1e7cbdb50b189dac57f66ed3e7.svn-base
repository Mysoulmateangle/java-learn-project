package com.qfedu.demo.spring.po;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 班级
 * @author cailei
 * @date 2018年11月21日
 */
@Entity
@Table(name = "t_clazz")
public class Clazz {

	private static Logger LOG = LogManager.getLogger(Clazz.class);
	
	/**
	 * ID
	 */
	@Id
	@Column (length = 50)
	private String id;
	
	/**
	 * 名称
	 */
	@Column (length = 50, nullable = false)
	private String name;
	
	/**
	 * 学生
	 */
	@OneToMany(mappedBy = "clazz") // 表示放弃对关系数据的维护
	// @JoinColumn(name = "clazz_id") // 需要维护关系数据
	private List<Student> students;
	
	/**
	 * 任课老师
	 */
	@ManyToMany
	@JoinTable(name = "t_clazz_courseTeacher", joinColumns = @JoinColumn (name = "clazz_id"), 
		inverseJoinColumns = @JoinColumn (name = "teacher_id"))
	private List<Teacher> courseTeachers;
	
	/**
	 * 班主任
	 */
	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;

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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Teacher> getCourseTeachers() {
		return courseTeachers;
	}

	public void setCourseTeachers(List<Teacher> courseTeachers) {
		this.courseTeachers = courseTeachers;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
