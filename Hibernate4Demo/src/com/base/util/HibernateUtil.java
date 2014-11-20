package com.base.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory sessionfaction = buildSessionFactory();
	
	/**
	 * 获取session工厂
	 * @return
	 */
	private static SessionFactory buildSessionFactory() {
		// TODO 自动生成的方法存根
		Configuration configuration = new Configuration(); // 实例化配置文件
		ServiceRegistry serviceRegistry = // 实例化服务登记
		new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();

		final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
		try {
			return new AnnotationConfiguration().configure()
					.buildSessionFactory(); // 获取session工厂
		} catch (Throwable ex) {
			// Log the exception.
			System.err.println("对不起数据工厂构建失败." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	/**
	 * 创建公开获取session工厂方法
	 * @return
	 */
	public static SessionFactory getSessionFactory(){
		return sessionfaction;
	}
}
