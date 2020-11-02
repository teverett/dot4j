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
		outputStreamWriter.write(renderContext.spaces());
		if (null != attributeType) {
			if (attributeType != AttributeType.anonymous) {
				outputStreamWriter.write(attributeType.toString() + " ");
			}
		}
		if (attributeType != AttributeType.anonymous) {
			outputStreamWriter.write("[");
		}
		outputStreamWriter.write(lhs + "=");
		boolean first = true;
		for (final String v : rhs) {
			if (first) {
				first = false;
			} else {
				outputStreamWriter.write(" ");
			}
			outputStreamWriter.write(v);
		}
		if (attributeType != AttributeType.anonymous) {
			outputStreamWriter.write("]");
		}
		if (attributeType != null) {
			outputStreamWriter.write(";\n");
		}
	}

	public void setAttributeType(AttributeType attributeType) {
		this.attributeType = attributeType;
	}

	public void setLhs(String lhs) {
		this.lhs = lhs;
	}
}
