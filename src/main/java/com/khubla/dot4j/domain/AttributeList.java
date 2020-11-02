package com.khubla.dot4j.domain;

import java.util.*;

public class AttributeList {
	private final List<Attribute> attributes = new ArrayList<Attribute>();

	public void add(AttributeList attributeList) {
		if (null != attributeList) {
			for (final Attribute attribute : attributeList.getAttributes()) {
				attributes.add(attribute);
			}
		}
	}

	public void addAttribute(Attribute attribute) {
		attributes.add(attribute);
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}
}
