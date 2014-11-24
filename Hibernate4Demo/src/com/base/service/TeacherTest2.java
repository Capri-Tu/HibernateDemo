package com.base.service;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.base.model.Teacher;
import com.base.util.HibernateUtil;

public class TeacherTest2 {
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	//由于每个步骤都会用到所以移到外面来
	
	@Test
	public void testAdd() {
		//只有通过session才能进行对象的操作, 获得持久化
				Session session = sessionFactory.openSession();	//生成一个新的session
				session.beginTransaction();	//开启事物

				//简单添加示例
				Teacher s = new Teacher();		//创建一个学生
				s.setName("zhansan");			//设置名称
				session.save(s);				//保存学生
				
				session.getTransaction().commit();	//提交事务
				session.close();					//关闭session
	}

	@Test
	public void testDelete() {
		Session session = sessionFactory.openSession();	//生成一个新的session
		session.beginTransaction();	//开启事物

		Teacher Teacher = (Teacher) session.get(Teacher.class, Integer.valueOf(1));	//取得对象
		session.delete(Teacher);		
		
		session.getTransaction().commit();	//提交事务
		session.close();					//关闭session
	}

	@Test
	public void testUpdate() {
		Session session = sessionFactory.openSession();	//生成一个新的session
		session.beginTransaction();	//开启事物

		Teacher Teacher = (Teacher) session.get(Teacher.class, Integer.valueOf(2));
		Teacher.setName("张三");
		session.save(Teacher);
		
		session.getTransaction().commit();	//提交事务
		session.close();					//关闭session
//		sessionFactory.close();				//关闭session工厂
	}

	@Test
	public void testGetAllTeacher() {
		Session session = sessionFactory.openSession();	//生成一个新的session
		session.beginTransaction();	//开启事物

		String hql = "from Teacher";	//from 类, 内部封装类转表
		Query quert = session.createQuery(hql);	
		List<Teacher> TeacherList = quert.list();
		for (Teacher Teacher : TeacherList) {
			System.out.println(Teacher.toString());
		}
		
		session.getTransaction().commit();	//提交事务
		session.close();					//关闭session
	}

}
