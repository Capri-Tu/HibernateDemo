/**
 * 使用了JUnit 的setUp 等关于在JUnit方法开始前与后使用的方法
 */
package com.base.service;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.base.model.Class;
import com.base.model.Student;
import com.base.util.HibernateUtil;

public class StudentCalssTest2Test {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	//由于每个步骤都会用到所以移到外面来
	Session session;
	@Before
	public void setUp() throws Exception {
		session = sessionFactory.openSession();	//生成一个新的session
		session.beginTransaction();	//开启事物
	}

	@After
	public void tearDown() throws Exception {
		session.getTransaction().commit();	//提交事务
		session.close();					//关闭session
	}

	@Test
	public void testTestAdd() {
		//简单添加示例
		Class c = new Class();
		c.setName("2013级");
		session.save(c);				//因为使用了级联,可以不写save
		
		Student s1 = new Student();		//创建一个学生
		s1.setName("zhansan");			//设置名称
		//s1.setC(c);
		session.save(s1);				//保存学生
		
		Student s2 = new Student();		//创建一个学生
		s2.setName("李四");			//设置名称
		//s2.setC(c);
		//session.save(s2);				//保存学生
		
		/*c.getStudents().add(s1);
		c.getStudents().add(s2);
		
		session.save(c);*/
	}
	
	/**
	 * 通过Class 打印学生
	 */
	@Test
	public void getStudentByClass(){
		Class c = (Class)session.get(Class.class, Integer.valueOf(1));	//取得Class对象
		Set<Student> students = c.getStudents();
		for (Iterator iterator = students.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			System.out.println(student);
		}
	}
	@Test
	public void testInverse(){
		Class c = (Class)session.get(Class.class, Integer.valueOf(1));	//取得Class对象
		Student s = (Student) session.get(Student.class, Integer.valueOf(1));
		
		s.setC(c);
		c.getStudents().add(s);
	}

	@Test
	public void testTestDelete() {
		fail("尚未实现");
	}

	@Test
	public void testTestUpdate() {
		fail("尚未实现");
	}

	@Test
	public void testTestGetAllStudent() {
		fail("尚未实现");
	}

}
