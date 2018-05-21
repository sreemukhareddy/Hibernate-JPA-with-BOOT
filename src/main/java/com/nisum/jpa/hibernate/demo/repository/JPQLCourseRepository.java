package com.nisum.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.jpa.hibernate.demo.entity.Course;

@Repository
@Transactional
public class JPQLCourseRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager entityManager;
	
	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(Long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
	
	public Course insertORupdate(Course course) {
		if(course.getId()==null) {
			entityManager.persist(course);
		}
		else {
			entityManager.merge(course);
		}
		return course;
	}
	
	public void playWithEntityManager() {
		Course course1=new Course("Web services in 100 steps");
		entityManager.persist(course1);
		
		Course course2=new Course("Angular JS in 100 steps");
		entityManager.persist(course2);
		
		
		entityManager.flush();
		
		entityManager.clear();
				
		course1.setName("Web Services got updated");
		entityManager.flush();
		
		/*Course course2=new Course("Angular JS in 100 steps");
		entityManager.persist(course2);*/
		entityManager.flush();
		
		entityManager.detach(course2);
		
		course2.setName("Angular JS got updated");
		entityManager.flush();
	}
	
	public void playWithEntityManagerWithRefreshMethod() {
		Course course1=new Course("Web services in 100 steps");
		entityManager.persist(course1);
		
		Course course2=new Course("Angular JS in 100 steps");
		entityManager.persist(course2);
		
		entityManager.flush();
		
		course1.setName("Web Services got updated");
		course2.setName("Angular JS got updated");
		
		entityManager.refresh(course1);

		entityManager.flush();
	}

}
