/**
 * 使用了JUnit, 未使用setUp 等方法 
 */
package com.base.service;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.base.model.Class;
import com.base.model.Student;
import com.base.util.HibernateUtil;

public class StudentCalssTest2 {
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	//由于每个步骤都会用到所以移到外面来
	
	@Test
	public void testAdd() {
		//只有通过session才能进行对象的操作, 获得持久化
				Session session = sessionFactory.openSession();	//生成一个新的session
				session.beginTransaction();	//开启事物

				
				//简单添加示例
				Class c = new Class();
				c.setName("2013级");
				session.save(c);
				
				Student s1 = new Student();		//创建一个学生
				s1.setName("zhansan");			//设置名称
				s1.setC(c);
				session.save(s1);				//保存学生
				
				Student s2 = new Student();		//创建一个学生
				s2.setName("李四");			//设置名称
				s2.setC(c);
				session.save(s2);				//保存学生
				
				session.getTransaction().commit();	//提交事务
				session.close();					//关闭session
	}

	@Test
	public void testDelete() {
		Session session = sessionFactory.openSession();	//生成一个新的session
		session.beginTransaction();	//开启事物

		Student Student = (Student) session.get(Student.class, Integer.valueOf(1));	//取得对象
		session.delete(Student);		
		
		session.getTransaction().commit();	//提交事务
		session.close();					//关闭session
	}

	@Test
	public void testUpdate() {
		Session session = sessionFactory.openSession();	//生成一个新的session
		session.beginTransaction();	//开启事物

		Student Student = (Student) session.get(Student.class, Integer.valueOf(2));
		Student.setName("张三");
		session.save(Student);
		
		session.getTransaction().commit();	//提交事务
		session.close();					//关闭session
//		sessionFactory.close();				//关闭session工厂
	}

	@Test
	public void testGetAllStudent() {
		Session session = sessionFactory.openSession();	//生成一个新的session
		session.beginTransaction();	//开启事物

		String hql = "from Student";	//from 类, 内部封装类转表
		Query quert = session.createQuery(hql);	
		List<Student> StudentList = quert.list();
		for (Student Student : StudentList) {
			System.out.println(Student.toString());
		}
		
		session.getTransaction().commit();	//提交事务
		session.close();					//关闭session
	}

}
