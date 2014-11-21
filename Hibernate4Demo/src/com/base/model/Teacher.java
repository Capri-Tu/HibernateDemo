package com.base.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//注解版 官方推荐
@Entity  //映射实体
@Table(name="t_teacher")	//import javax.persistence.Table;
public class Teacher {

	private int id;
	private String name;
	/**
	 * @return id
	 */

	@Id			//设置主键
	@GeneratedValue(generator="_native")	//注册主属性的生成策略, 使用生成策略
	@GenericGenerator(name="_native",strategy="increment")	//生成策略,定义
	public int getId() {
		return id;
	}
	/**
	 * @param id 要设置的 id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + "]";
	}
	
	
}
