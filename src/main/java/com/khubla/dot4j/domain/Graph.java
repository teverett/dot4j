package com.khubla.dot4j.domain;

import java.util.*;

public class Graph extends Vertex {
	private boolean strict;
	private GraphType graphType;
	private Map<String, Node> nodes = new HashMap<String, Node>();
	private List<Edge> edges = new ArrayList<Edge>();
	private Map<String, Graph> subGraphs = new HashMap<String, Graph>();
	private AttributeList nodeAttributes;
	private AttributeList graphAttributes;
	private AttributeList edgeAttributes;

	public void addEdge(Edge edge) {
		edges.add(edge);
	}

	public void addEdgeAttributes(AttributeList attributeList) {
		throw new RuntimeException("Not Implemented");
	}

	public void addGraphAttributes(AttributeList attributeList) {
		throw new RuntimeException("Not Implemented");
	}

	public void addNode(Node node) {
		nodes.put(node.getId(), node);
	}

	public void addNodeAttributes(AttributeList attributeList) {
		throw new RuntimeException("Not Implemented");
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

	public void setEdgeAttributes(AttributeList edgeAttributes) {
		this.edgeAttributes = edgeAttributes;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public void setGraphAttributes(AttributeList graphAttributes) {
		this.graphAttributes = graphAttributes;
	}

	public void setGraphType(GraphType graphType) {
		this.graphType = graphType;
	}

	public void setNodeAttributes(AttributeList nodeAttributes) {
		this.nodeAttributes = nodeAttributes;
	}

	public void setNodes(Map<String, Node> nodes) {
		this.nodes = nodes;
	}

	public void setStrict(boolean strict) {
		this.strict = strict;
	}

	public void setSubGraphs(Map<String, Graph> subGraphs) {
		this.subGraphs = subGraphs;
	}
}
