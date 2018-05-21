insert into course(id,name) values(10001,'JPA IN 50 STEPS');
insert into course(id,name) values(10002,'JPA IN 500 STEPS');
insert into course(id,name) values(10003,'JPA IN 5000 STEPS');

insert into passport(id,number) values(40001,'E123456');
insert into passport(id,number) values(40002,'N123457');
insert into passport(id,number) values(40003,'L123890');

insert into student(id,name,passport_id) values(20001,'Ranga',40001);
insert into student(id,name,passport_id) values(20002,'Adam',40002);
insert into student(id,name,passport_id) values(20003,'Jane',40003);

insert into review(id,rating,description,course_id) values(40001,'5','Great Course',10001);
insert into review(id,rating,description,course_id) values(40002,'5','Wonderful Course',10001);
insert into review(id,rating,description,course_id) values(40003,'4.5','Awesome Course',10003);

insert into student_course(student_id,course_id) values(20001,10001);
insert into student_course(student_id,course_id) values(20002,10001);
insert into student_course(student_id,course_id) values(20003,10001);
insert into student_course(student_id,course_id) values(20001,10003);