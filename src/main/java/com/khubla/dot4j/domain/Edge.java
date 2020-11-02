package com.khubla.dot4j.domain;

import java.io.*;

/**
 * An Edge.
 *
 * @author tom
 */
public class Edge extends AttributesContainer implements Renderable {
	private EdgeConnectionPoint from;
	private EdgeConnectionPoint to;

	public Edge() {
		super(AttributeType.edge);
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

	public void setFrom(EdgeConnectionPoint from) {
		this.from = from;
	}

	public void setTo(EdgeConnectionPoint to) {
		this.to = to;
	}
}
