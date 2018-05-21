package com.nisum.jpa.hibernate.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nisum.jpa.hibernate.demo.entity.Employee;
import com.nisum.jpa.hibernate.demo.entity.FullTimeEmployee;
import com.nisum.jpa.hibernate.demo.entity.PartTimeEmployee;
import com.nisum.jpa.hibernate.demo.entity.Review;
import com.nisum.jpa.hibernate.demo.repository.CourseRepository;
import com.nisum.jpa.hibernate.demo.repository.EmployeeRepository;
import com.nisum.jpa.hibernate.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*studentRepository.saveStudentWithPassport();*/
		
		/*List<Review> reviews=new ArrayList<Review>();
		Review review1=new Review("5", "Great hands on stuff");
		Review review2=new Review("5", "hands ogg");
		reviews.add(review1);
		reviews.add(review2);
*/		/*Course course = courseRepository.findById(10001L);
		logger.info("Course Details -> {}",course);
		courseRepository.deleteById(10003L);
		courseRepository.insertORupdate(new Course("MicroServices in 100 steps"));
		courseRepository.playWithEntityManager();*/
		//courseRepository.addReviewsForCourse();
		/*courseRepository.addReviewsForCourse(10003L, reviews);*/
		
		/*studentRepository.insertStudentAndCourse();*/
		
		employeeRepository.insert(new FullTimeEmployee("Jack",new BigDecimal("10000")));
		employeeRepository.insert(new PartTimeEmployee("Jill",new BigDecimal("10")));
		logger.info("All Employees -> {}",employeeRepository.getAllEmployees());
	}
}
