package com.khubla.dot4j.domain;

import java.io.*;
import java.util.*;

public class Attribute implements Renderable {
	private String lhs;
	private final List<String> rhs = new ArrayList<String>();
	private AttributeType attributeType;

	public void addRHS(String id) {
		rhs.add(id);
	}

	public AttributeType getAttributeType() {
		return attributeType;
	}

	public String getLhs() {
		return lhs;
	}

	public List<String> getRhs() {
		return rhs;
	}

	@Override
	public void render(OutputStreamWriter outputStreamWriter, RenderContext renderContext) throws IOException {
		throw new RuntimeException("Not Implemented");
	}

	public void setAttributeType(AttributeType attributeType) {
		this.attributeType = attributeType;
	}

	public void setLhs(String lhs) {
		this.lhs = lhs;
	}
}
