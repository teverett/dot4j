package com.khubla.dot4j.domain;

/**
 * An Edge.
 *
 * @author tom
 */
public class Edge {
	private EdgeConnectionPoint from;
	private EdgeConnectionPoint to;
	private final Attributes attributes = new Attributes();

	public void addAttributes(Attributes attributes) {
		this.attributes.addAttributes(attributes);
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public EdgeConnectionPoint getFrom() {
		return from;
	}

	public EdgeConnectionPoint getTo() {
		return to;
	}

	public void setFrom(EdgeConnectionPoint from) {
		this.from = from;
	}

	public void setTo(EdgeConnectionPoint to) {
		this.to = to;
	}
}
