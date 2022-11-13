package com.springorm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;


import com.springorm.enity.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insert(Student student) {
		
		Integer i=(Integer)this.hibernateTemplate.save(student);
		
		return i;
	}
   // get single data
	public Student getStudent(int StudentId) {
		Student student=this.hibernateTemplate.get(Student.class,StudentId);
		return student;
	}
	// get all data
	public List<Student> getAllStudent(){
		List<Student> students=this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	// delete data
	@Transactional
	public void deleteStudent(int studentId) {
		Student student=this.hibernateTemplate.get(Student.class,studentId);
		this.hibernateTemplate.delete(student);
	}

	
	//update the data
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
