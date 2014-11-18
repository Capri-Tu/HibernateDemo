package com.base.service;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.base.model.Student;

public class StudentTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Configuration configuration = new Configuration(); 	//实例化配置文件
		ServiceRegistry serviceRegistry = 		//实例化服务登记
			new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			//applySettings(
			//configuration.getProperties()).build();
//		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);	//获取session工厂(出错,原因未明)

	    SessionFactory sessionFactory = null;  		 //获取session工厂
        final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();  
            try {  
                sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();  
            } catch (Throwable ex) {  
                // Log the exception.   
                System.err.println("�Բ�����ݹ�������ʧ��." + ex);  
                throw new ExceptionInInitializerError(ex);  
            }  
        
		
          //只有通过session才能进行对象的操作, 获得持久化
		Session session = sessionFactory.openSession();	//生成一个新的session
		session.beginTransaction();	//开启事物

		//简单添加示例
		Student s = new Student();		//创建一个学生
		s.setName("zhansan");			//设置名称
		session.save(s);				//保存学生
		
		
		session.getTransaction().commit();	//提交事务
		session.close();					//关闭session
		sessionFactory.close();				//关闭session工厂
	}
}
