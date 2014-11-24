package com.base.model;

public class Student {
	
	private int id;
	private String name;
	private Class c;
	/**
	 * @return c
	 */
	public Class getC() {
		return c;
	}
	/**
	 * @param c 要设置的 c
	 */
	public void setC(Class c) {
		this.c = c;
	}
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id 设置 id
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
	 * @param name 设置 name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
}
