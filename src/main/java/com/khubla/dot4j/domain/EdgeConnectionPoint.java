package com.khubla.dot4j.domain;

/**
 * Only one of nodeId and subGraph should be valid.
 *
 * @author tom
 */
public class EdgeConnectionPoint {
	private final NodeId nodeId;
	private final Graph subGraph;

	public EdgeConnectionPoint(Graph subGraph) {
		super();
		nodeId = null;
		this.subGraph = subGraph;
	}

	public EdgeConnectionPoint(NodeId nodeId) {
		super();
		this.nodeId = nodeId;
		subGraph = null;
	}

	public NodeId getNodeId() {
		return nodeId;
	}

	public Graph getSubGraph() {
		return subGraph;
	}
}
