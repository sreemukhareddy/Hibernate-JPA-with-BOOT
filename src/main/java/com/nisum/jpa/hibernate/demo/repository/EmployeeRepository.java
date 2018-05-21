package com.nisum.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nisum.jpa.hibernate.demo.entity.Course;
import com.nisum.jpa.hibernate.demo.entity.Employee;
import com.nisum.jpa.hibernate.demo.entity.Review;

@Repository
@Transactional
public class EmployeeRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager entityManager;
	
	public void insert(Employee employee) {
		entityManager.persist(employee);
	}
	
	public List<Employee> getAllEmployees(){
		return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
	}
}
