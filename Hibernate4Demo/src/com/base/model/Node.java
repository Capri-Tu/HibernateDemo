package com.base.model;

import java.util.HashSet;
import java.util.Set;

public class Node {
	private int id;
	private String name;
	
	private Node parentNode;
	
	private Set<Node> childNodes = new HashSet<Node>();

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

	/**
	 * @return parentNode
	 */
	public Node getParentNode() {
		return parentNode;
	}

	/**
	 * @param parentNode 要设置的 parentNode
	 */
	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}

	/**
	 * @return childNodes
	 */
	public Set<Node> getChildNodes() {
		return childNodes;
	}

	/**
	 * @param childNodes 要设置的 childNodes
	 */
	public void setChildNodes(Set<Node> childNodes) {
		this.childNodes = childNodes;
	}
	
}
