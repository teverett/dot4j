package com.khubla.dot4j.domain;

public class RenderContext {
	private int indent = 0;
	private GraphType graphType;

	public GraphType getGraphType() {
		return graphType;
	}

	public int getIndent() {
		return indent;
	}

	public void indent() {
		indent = indent + 1;
	}

	public void outdent() {
		indent = indent - 1;
	}

	public void setGraphType(GraphType graphType) {
		this.graphType = graphType;
	}

	public void setIndent(int indent) {
		this.indent = indent;
	}

	public String spaces() {
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < indent; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}
}
