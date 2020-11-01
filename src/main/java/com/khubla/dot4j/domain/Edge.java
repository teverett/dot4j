package com.khubla.dot4j.domain;

import java.util.*;

public class Edge {
	private Vertex vertex;
	private AttributeList attributeList;
	private List<Vertex> vertices = new ArrayList<Vertex>();

	public AttributeList getAttributeList() {
		return attributeList;
	}

	public void setAttributeList(AttributeList attributeList) {
		this.attributeList = attributeList;
	}

	public Vertex getVertex() {
		return vertex;
	}

	public void setVertex(Vertex vertex) {
		this.vertex = vertex;
	}

	public List<Vertex> getVertices() {
		return vertices;
	}

	public void setVertices(List<Vertex> vertices) {
		this.vertices = vertices;
	}
}
