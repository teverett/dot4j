package com.khubla.dot4j.domain;

import java.io.*;

public class Attribute implements Renderable {
	private String lhs;
	private String rhs;

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

	public void setLhs(String lhs) {
		this.lhs = lhs;
	}

	public void setRhs(String rhs) {
		this.rhs = rhs;
	}
}
