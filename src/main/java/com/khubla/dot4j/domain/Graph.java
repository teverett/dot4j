package com.khubla.dot4j.domain;

import java.util.*;

public class Graph implements Vertex {
	private boolean strict;
	private GraphType graphType;
	private final Map<String, Node> nodes = new HashMap<String, Node>();
	private final List<Edge> edges = new ArrayList<Edge>();
	private final Map<String, Graph> subGraphs = new HashMap<String, Graph>();
	private final AttributeList nodeAttributes = new AttributeList();
	private final AttributeList graphAttributes = new AttributeList();
	private final AttributeList edgeAttributes = new AttributeList();
	private String id;

	public void addEdge(Edge edge) {
		edges.add(edge);
	}

	public void addEdgeAttributes(AttributeList attributeList) {
		edgeAttributes.add(attributeList);
	}

	public void addEdges(List<Edge> edges) {
		for (final Edge edge : edges) {
			this.edges.add(edge);
		}
	}

	public void addGraphAttribute(Attribute attribute) {
		graphAttributes.addAttribute(attribute);
	}

	public void addGraphAttributes(AttributeList attributeList) {
		graphAttributes.add(graphAttributes);
	}

	public void addNode(Node node) {
		nodes.put(node.getId(), node);
	}

	public void addNodeAttributes(AttributeList attributeList) {
		nodeAttributes.add(attributeList);
	}

	public void addSubgraph(Graph graph) {
		subGraphs.put(graph.getId(), graph);
	}

	public AttributeList getEdgeAttributes() {
		return edgeAttributes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public AttributeList getGraphAttributes() {
		return graphAttributes;
	}

	public GraphType getGraphType() {
		return graphType;
	}

	@Override
	public String getId() {
		return id;
	}

	public AttributeList getNodeAttributes() {
		return nodeAttributes;
	}

	public Map<String, Node> getNodes() {
		return nodes;
	}

	public Map<String, Graph> getSubGraphs() {
		return subGraphs;
	}

	public boolean isStrict() {
		return strict;
	}

	public void setGraphType(GraphType graphType) {
		this.graphType = graphType;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setStrict(boolean strict) {
		this.strict = strict;
	}
}
