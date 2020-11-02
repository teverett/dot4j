package com.khubla.dot4j.domain;

import java.io.*;
import java.util.*;

public class Attributes implements Renderable {
	private final Map<String, Attribute> attributes = new HashMap<String, Attribute>();

	public void addAttribute(Attribute attribute) {
		attributes.put(attribute.getLhs(), attribute);
	}

	public void addAttributes(Attributes attributeList) {
		if (null != attributeList) {
			for (final Attribute attribute : attributeList.getAttributes().values()) {
				addAttribute(attribute);
			}
		}
	}

	public Attribute getAttribute(String lhs) {
		return attributes.get(lhs);
	}

	public Map<String, Attribute> getAttributes() {
		return attributes;
	}

	@Override
	public void render(OutputStreamWriter outputStreamWriter, RenderContext renderContext) throws IOException {
		throw new RuntimeException("Not Implemented");
	}

	public int size() {
		return attributes.size();
	}
}
