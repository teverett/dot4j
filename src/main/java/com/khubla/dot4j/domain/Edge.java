package com.khubla.dot4j.domain;

import java.io.*;

/**
 * An Edge.
 *
 * @author tom
 */
public class Edge extends AttributesContainer implements Renderable {
	private final EdgeConnectionPoint from;
	private final EdgeConnectionPoint to;

	public Edge(EdgeConnectionPoint from, EdgeConnectionPoint to) {
		super(AttributeType.edge);
		this.from = from;
		this.to = to;
	}

	public Edge(Graph fromGraoh, Graph toGraoh) {
		super(AttributeType.edge);
		from = new EdgeConnectionPoint(fromGraoh);
		to = new EdgeConnectionPoint(toGraoh);
	}

	public Edge(Graph fromGraoh, NodeId toNode) {
		super(AttributeType.edge);
		from = new EdgeConnectionPoint(fromGraoh);
		to = new EdgeConnectionPoint(toNode);
	}

	public Edge(Graph fromGraoh, String toNode) {
		super(AttributeType.edge);
		from = new EdgeConnectionPoint(fromGraoh);
		to = new EdgeConnectionPoint(new NodeId(toNode));
	}

	public Edge(NodeId fromNode, Graph toGraoh) {
		super(AttributeType.edge);
		from = new EdgeConnectionPoint(fromNode);
		to = new EdgeConnectionPoint(toGraoh);
	}

	public Edge(NodeId fromNode, NodeId toNode) {
		super(AttributeType.edge);
		from = new EdgeConnectionPoint(fromNode);
		to = new EdgeConnectionPoint(toNode);
	}

	public Edge(String fromNode, Graph toGraoh) {
		super(AttributeType.edge);
		from = new EdgeConnectionPoint(new NodeId(fromNode));
		to = new EdgeConnectionPoint(toGraoh);
	}

	public Edge(String fromNode, String toNode) {
		super(AttributeType.edge);
		from = new EdgeConnectionPoint(new NodeId(fromNode));
		to = new EdgeConnectionPoint(new NodeId(toNode));
	}

	public EdgeConnectionPoint getFrom() {
		return from;
	}

	public EdgeConnectionPoint getTo() {
		return to;
	}

	@Override
	public void render(OutputStreamWriter outputStreamWriter, RenderContext renderContext) throws IOException {
		outputStreamWriter.write(renderContext.spaces());
		/*
		 * from
		 */
		if (from.getNodeId() != null) {
			from.getNodeId().render(outputStreamWriter, renderContext);
		} else {
			from.getSubGraph().render(outputStreamWriter, renderContext);
		}
		/*
		 * ugh
		 */
		if (renderContext.getGraphType() == GraphType.graph) {
			outputStreamWriter.write(" -- ");
		} else {
			outputStreamWriter.write(" -> ");
		}
		/*
		 * to
		 */
		if (to.getNodeId() != null) {
			to.getNodeId().render(outputStreamWriter, renderContext);
		} else {
			to.getSubGraph().render(outputStreamWriter, renderContext);
		}
		renderContext.setGraph(false);
		getAttributes().render(outputStreamWriter, renderContext);
		outputStreamWriter.write(";\n");
	}
}
