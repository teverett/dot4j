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

	public boolean isStrict() {
		return strict;
	}

	public void setStrict(boolean strict) {
		this.strict = strict;
	}

	public GraphType getGraphType() {
		return graphType;
	}

	public void setGraphType(GraphType graphType) {
		this.graphType = graphType;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public void addNode(Node node) {
		this.nodes.add(node);
	}

	public void addEdge(Edge edge) {
		this.edges.add(edge);
	}

	public AttributeList getNodeAttributes() {
		return nodeAttributes;
	}

	public void setNodeAttributes(AttributeList nodeAttributes) {
		this.nodeAttributes = nodeAttributes;
	}

	public AttributeList getGraphAttributes() {
		return graphAttributes;
	}

	public void setGraphAttributes(AttributeList graphAttributes) {
		this.graphAttributes = graphAttributes;
	}

	public AttributeList getEdgeAttributes() {
		return edgeAttributes;
	}

	public void setEdgeAttributes(AttributeList edgeAttributes) {
		this.edgeAttributes = edgeAttributes;
	}

	public void addSubgraph(Graph graph) {
		this.subGraphs.put(graph.getId(), arg1)
	}

	public Map<String, Node> getNodes() {
		return nodes;
	}

	public void setNodes(Map<String, Node> nodes) {
		this.nodes = nodes;
	}

	public Map<String, Graph> getSubGraphs() {
		return subGraphs;
	}

	public void setSubGraphs(Map<String, Graph> subGraphs) {
		this.subGraphs = subGraphs;
	}

	public void addNodeAttributes(AttributeList attributeList) {
		throw new RuntimeException("Not Implemented");
	}

	public void addEdgeAttributes(AttributeList attributeList) {
		throw new RuntimeException("Not Implemented");
	}

	public void addGraphAttributes(AttributeList attributeList) {
		throw new RuntimeException("Not Implemented");
	}
}
