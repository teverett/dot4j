package com.khubla.dot4j.domain;

/**
 * An Edge. Only one of nodeId and subGraph should be valid.
 *
 * @author tom
 */
public class Edge {
	private EdgeConnectionPoint from;
	private EdgeConnectionPoint to;
	private final AttributeList attributeList = new AttributeList();

	public void addAttributeList(AttributeList attributeList) {
		this.attributeList.add(attributeList);
	}

	public AttributeList getAttributeList() {
		return attributeList;
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
