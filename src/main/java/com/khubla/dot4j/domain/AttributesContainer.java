package com.khubla.dot4j.domain;

public abstract class AttributesContainer {
	private final Attributes attributes;

	public AttributesContainer(AttributeType attributeType) {
		attributes = new Attributes(attributeType);
	}

	public void addAttribute(Attribute attribute) {
		attributes.addAttribute(attribute);
	}

	public void addAttributes(Attributes attributes) {
		this.attributes.addAttributes(attributes);
	}

	public Attributes getAttributes() {
		return attributes;
	}
}
