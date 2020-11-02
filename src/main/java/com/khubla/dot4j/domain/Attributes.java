package com.khubla.dot4j.domain;

import java.io.*;
import java.util.*;

public class Attributes implements Renderable {
	private final AttributeType attributeType;
	/*
	 * make it a list so that naming overlaps are allowed
	 */
	private final List<Attribute> attributes = new ArrayList<Attribute>();

	public Attributes(AttributeType attributeType) {
		super();
		this.attributeType = attributeType;
	}

	public void addAttribute(Attribute attribute) {
		attributes.add(attribute);
	}

	public void addAttributes(Attributes attributes) {
		if (null != attributes) {
			for (final Attribute attribute : attributes.attributes) {
				addAttribute(attribute);
			}
		}
	}

	public void addAttributes(List<Attribute> attributes) {
		if (null != attributes) {
			for (final Attribute attribute : attributes) {
				addAttribute(attribute);
			}
		}
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public AttributeType getAttributeType() {
		return attributeType;
	}

	@Override
	public void render(OutputStreamWriter outputStreamWriter, RenderContext renderContext) throws IOException {
		if (attributes.size() > 0) {
			/*
			 * spaces
			 */
			if (renderContext.isGraph()) {
				outputStreamWriter.write(renderContext.spaces());
			} else {
				outputStreamWriter.write(" ");
			}
			/*
			 * show the type of it's not anonymous and we're rendering graph level attributes
			 */
			if ((attributeType != AttributeType.anonymous) && (renderContext.isGraph())) {
				outputStreamWriter.write(attributeType.toString() + " ");
			}
			if (attributeType != AttributeType.anonymous) {
				outputStreamWriter.write("[");
			}
			boolean first = true;
			for (final Attribute attribute : attributes) {
				if (first) {
					first = false;
				} else {
					if ((attributeType == AttributeType.anonymous) && (renderContext.isGraph())) {
						outputStreamWriter.write("\n" + renderContext.spaces());
					} else {
						outputStreamWriter.write(" ");
					}
				}
				attribute.render(outputStreamWriter, renderContext);
			}
			if (attributeType != AttributeType.anonymous) {
				outputStreamWriter.write("]");
			}
			if (true == renderContext.isGraph()) {
				outputStreamWriter.write(";\n");
			}
		}
	}

	public int size() {
		return attributes.size();
	}
}
