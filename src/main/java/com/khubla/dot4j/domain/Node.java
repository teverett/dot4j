package com.khubla.dot4j.domain;

public class Node implements Vertex {
	private final AttributeList attributeList = new AttributeList();
	private String id;

	public void addAttributeList(AttributeList attributeList) {
		this.attributeList.add(attributeList);
	}

	public AttributeList getAttributeList() {
		return attributeList;
	}

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
