package com.khubla.dot4j.domain;

import java.io.*;
import java.util.*;

/**
 * Graoh
 *
 * @author tom
 */
public class Graph implements Vertex, Renderable {
	private boolean strict;
	private GraphType graphType;
	private final Map<String, Node> nodes = new HashMap<String, Node>();
	private final List<Edge> edges = new ArrayList<Edge>();
	/*
	 * subgraphs can have the same name....
	 */
	private final List<Graph> subGraphs = new ArrayList<Graph>();
	private final Attributes nodeAttributes = new Attributes();
	private final Attributes graphAttributes = new Attributes();
	private final Attributes edgeAttributes = new Attributes();
	private String id;

	public void addEdge(Edge edge) {
		edges.add(edge);
	}

	public void addEdgeAttributes(Attributes attributeList) {
		edgeAttributes.addAttributes(attributeList);
	}

	public void addEdges(List<Edge> edges) {
		for (final Edge edge : edges) {
			this.edges.add(edge);
		}
	}

	public void addGraphAttribute(Attribute attribute) {
		graphAttributes.addAttribute(attribute);
	}

	public void addGraphAttributes(Attributes attributeList) {
		graphAttributes.addAttributes(graphAttributes);
	}

	public void addNode(Node node) {
		nodes.put(node.getId(), node);
	}

	public void addNodeAttributes(Attributes attributeList) {
		nodeAttributes.addAttributes(attributeList);
	}

	public void addSubgraph(Graph graph) {
		subGraphs.add(graph);
	}

	public Attributes getEdgeAttributes() {
		return edgeAttributes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public Attributes getGraphAttributes() {
		return graphAttributes;
	}

	public GraphType getGraphType() {
		return graphType;
	}

	@Override
	public String getId() {
		return id;
	}

	public Attributes getNodeAttributes() {
		return nodeAttributes;
	}

	public Map<String, Node> getNodes() {
		return nodes;
	}

	public List<Graph> getSubGraphs() {
		return subGraphs;
	}

	public boolean isStrict() {
		return strict;
	}

	@Override
	public void render(OutputStreamWriter outputStreamWriter, RenderContext renderContext) throws IOException {
		/*
		 * graph type into the context, sadly
		 */
		renderContext.setGraphType(graphType);
		/*
		 * strict
		 */
		if (strict) {
			outputStreamWriter.write("strict ");
		}
		/*
		 * type
		 */
		outputStreamWriter.write(renderContext.spaces() + graphType.toString() + " ");
		/*
		 * id
		 */
		outputStreamWriter.write(renderContext.spaces() + id + " ");
		/*
		 * open brace and indent
		 */
		outputStreamWriter.write(renderContext.spaces() + "{\n");
		renderContext.indent();
		/*
		 * nodes
		 */
		for (final Node node : nodes.values()) {
			node.render(outputStreamWriter, renderContext);
		}
		/*
		 * edges
		 */
		for (final Edge edge : edges) {
			edge.render(outputStreamWriter, renderContext);
		}
		/*
		 * close brace and outdent
		 */
		renderContext.outdent();
		outputStreamWriter.write(renderContext.spaces() + "}\n");
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
