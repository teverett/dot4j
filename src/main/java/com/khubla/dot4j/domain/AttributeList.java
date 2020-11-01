package com.khubla.dot4j.domain;

import java.util.*;

public class AttributeList {
	private List<Attribute> attributes = new ArrayList<Attribute>();

	public void addAttribute(Attribute attribute) {
		attributes.add(attribute);
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
}
