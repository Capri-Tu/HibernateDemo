/**
 * 一对多 双向自身关联关系映射
 * 
 * 使用了JUnit 的setUp 等关于在JUnit方法开始前与后使用的方法
 * 
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
import com.base.model.Node;
import com.base.model.Student;
import com.base.util.HibernateUtil;

public class NodeTest {
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
	public void TestAdd() {
		
		Node node = new Node();
		node.setName("根节点");
		
		Node subNode1 = new Node();
		subNode1.setName("子节点1");
		
		Node subNode2 = new Node();
		subNode2.setName("子节点2");
		
		subNode1.setParentNode(node);
		subNode2.setParentNode(node);
		
		session.save(subNode1);
		session.save(subNode2);
		
	}
}
