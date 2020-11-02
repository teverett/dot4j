package com.khubla.dot4j.domain;

public class RenderContext {
	private static final int INDENT_SIZE = 3;
	private int indent = 0;
	private GraphType graphType;
	private boolean isGraph;

	public GraphType getGraphType() {
		return graphType;
	}

	public int getIndent() {
		return indent;
	}

	public void indent() {
		indent = indent + 1;
	}

	public boolean isGraph() {
		return isGraph;
	}

	public void outdent() {
		indent = indent - 1;
	}

	public void setGraph(boolean isGraph) {
		this.isGraph = isGraph;
	}

	public void setGraphType(GraphType graphType) {
		this.graphType = graphType;
	}

	public void setIndent(int indent) {
		this.indent = indent;
	}

	public String spaces() {
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < (indent * INDENT_SIZE); i++) {
			sb.append(" ");
		}
		return sb.toString();
	}
}
