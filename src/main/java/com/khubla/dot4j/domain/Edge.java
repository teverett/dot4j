package com.khubla.dot4j.domain;

import java.util.*;

/**
 * An Edge. Only one of nodeId and subGraph should be valid.
 *
 * @author tom
 */
public class Edge {
	private NodeId fromNodeId;
	private Graph fromSubGraph;
	private final AttributeList attributeList = new AttributeList();
	private final List<NodeId> rhsNodeIds = new ArrayList<NodeId>();
	private final List<Graph> rhsGraphs = new ArrayList<Graph>();

	public void addAttributeList(AttributeList attributeList) {
		this.attributeList.add(attributeList);
	}

	public void addRHSGraph(Graph graph) {
		rhsGraphs.add(graph);
	}

	public void addRHSNodeId(NodeId nodeId) {
		rhsNodeIds.add(nodeId);
	}

	public AttributeList getAttributeList() {
		return attributeList;
	}

	public List<Graph> getRhsGraphs() {
		return rhsGraphs;
	}

	public List<NodeId> getRhsNodeIds() {
		return rhsNodeIds;
	}

	public NodeId getFromNodeId() {
		return fromNodeId;
	}

	public void setFromNodeId(NodeId fromNodeId) {
		this.fromNodeId = fromNodeId;
	}

	public Graph getFromSubGraph() {
		return fromSubGraph;
	}

	public void setFromSubGraph(Graph fromSubGraph) {
		this.fromSubGraph = fromSubGraph;
	}
}
