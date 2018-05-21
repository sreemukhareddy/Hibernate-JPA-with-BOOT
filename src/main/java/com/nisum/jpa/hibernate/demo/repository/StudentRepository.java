package com.nisum.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.jpa.hibernate.demo.entity.Course;
import com.nisum.jpa.hibernate.demo.entity.Passport;
import com.nisum.jpa.hibernate.demo.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager entityManager;
	
	public Student findById(Long id) {
		return entityManager.find(Student.class, id);
	}
	
	public void deleteById(Long id) {
		Student student = entityManager.find(Student.class, id);
		entityManager.remove(student);
	}
	
	public Student insertORupdate(Student student) {
		if(student.getId()==null) {
			entityManager.persist(student);
		}
		else {
			entityManager.merge(student);
		}
		return student;
	}
	
	public void saveStudentWithPassport() {
		Passport passport=new Passport("Z123456");
		Student student=new Student("Mike");
		student.setPassport(passport);
		entityManager.persist(passport);
		entityManager.persist(student);
	}
	
	public void insertStudentAndCourse() {
		Student student=new Student("Jack");
		Course course=new Course("JACK AND JILL");
		entityManager.persist(student);
		entityManager.persist(course);
		
		student.addCourse(course);
		course.addStudent(student);
		
		entityManager.persist(student);
	}
}
