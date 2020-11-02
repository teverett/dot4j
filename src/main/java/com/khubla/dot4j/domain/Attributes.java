package com.khubla.dot4j.domain;

import java.util.*;

public class Attributes {
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

	public int size() {
		return attributes.size();
	}
}
