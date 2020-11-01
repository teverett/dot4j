package com.khubla.dot4j.domain;

import java.util.*;

public class Edge {
	private NodeId nodeId;
	private Graph subGraph;
	private AttributeList attributeList;
	private List<Vertex> vertices = new ArrayList<Vertex>();

	public AttributeList getAttributeList() {
		return attributeList;
	}

	public NodeId getNodeId() {
		return nodeId;
	}

	public Graph getSubGraph() {
		return subGraph;
	}

	public List<Vertex> getVertices() {
		return vertices;
	}

	public void setAttributeList(AttributeList attributeList) {
		this.attributeList = attributeList;
	}

	public void setNodeId(NodeId nodeId) {
		this.nodeId = nodeId;
	}

	public void setSubGraph(Graph subGraph) {
		this.subGraph = subGraph;
	}

	public void setVertices(List<Vertex> vertices) {
		this.vertices = vertices;
	}
}
