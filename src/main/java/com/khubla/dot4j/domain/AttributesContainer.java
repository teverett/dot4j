package com.khubla.dot4j.domain;

public abstract class AttributesContainer {
	private final Attributes attributes;

	public AttributesContainer(AttributeType attributeType) {
		attributes = new Attributes(attributeType);
	}

	public void addAttribute(Attribute attribute) {
		attributes.addAttribute(attribute);
	}

	public void addAttribute(String key, String value) {
		attributes.addAttribute(new Attribute(key, value));
	}

	public void addAttributes(Attributes attributes) {
		this.attributes.addAttributes(attributes);
	}

	public Attributes getAttributes() {
		return attributes;
	}
}
