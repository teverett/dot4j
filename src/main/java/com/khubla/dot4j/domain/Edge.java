package com.khubla.dot4j.domain;

import java.util.*;

/**
 * An Edge. Only one of nodeId and subGraph should be valid.
 *
 * @author tom
 */
public class Edge {
	private NodeId nodeId;
	private Graph subGraph;
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

	public NodeId getNodeId() {
		return nodeId;
	}

	public List<Graph> getRhsGraphs() {
		return rhsGraphs;
	}

	public List<NodeId> getRhsNodeIds() {
		return rhsNodeIds;
	}

	public Graph getSubGraph() {
		return subGraph;
	}

	public void setNodeId(NodeId nodeId) {
		this.nodeId = nodeId;
	}

	public void setSubGraph(Graph subGraph) {
		this.subGraph = subGraph;
	}
}
