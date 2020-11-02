package com.khubla.dot4j.domain;

/**
 * Only one of nodeId and subGraph should be valid.
 *
 * @author tom
 */
public class EdgeConnectionPoint {
	private NodeId nodeId;
	private Graph subGraph;

	public NodeId getNodeId() {
		return nodeId;
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
