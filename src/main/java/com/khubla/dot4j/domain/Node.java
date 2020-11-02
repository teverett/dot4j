package com.khubla.dot4j.domain;

public class Node implements Vertex {
	private final Attributes attributes = new Attributes();
	private String id;

	public void addAttributes(Attributes attributeList) {
		attributes.addAttributes(attributeList);
	}

	public Attributes getAttributes() {
		return attributes;
	}

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
