package com.khubla.dot4j.domain;

public class Node extends Vertex {
	private final AttributeList attributeList = new AttributeList();

	public void addAttributeList(AttributeList attributeList) {
		this.attributeList.add(attributeList);
	}

	public AttributeList getAttributeList() {
		return attributeList;
	}
}
