package com.base.model;

import java.util.HashSet;
import java.util.Set;

public class Class {
	private int id;
	private String name;
	private Set<Student> students = new HashSet<Student>();	//班级对应的学生
	/**
	 * @return students
	 */
	public Set<Student> getStudents() {
		return students;
	}
	/**
	 * @param students 要设置的 students
	 */
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	/**
	 * @return id
	 */
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

}
