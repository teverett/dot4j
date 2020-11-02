package com.khubla.dot4j.domain;

import java.io.*;

public class Attribute implements Renderable {
	private final String lhs;
	private final String rhs;

	public Attribute(String lhs, String rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public String getLhs() {
		return lhs;
	}

	public String getRhs() {
		return rhs;
	}

	@Override
	public void render(OutputStreamWriter outputStreamWriter, RenderContext renderContext) throws IOException {
		outputStreamWriter.write(lhs + "=" + rhs);
	}
}
