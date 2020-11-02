package com.khubla.dot4j.domain;

import java.io.*;

public class Node extends AttributesContainer implements Vertex, Renderable {
	private String id;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void render(OutputStreamWriter outputStreamWriter, RenderContext renderContext) throws IOException {
		outputStreamWriter.write(renderContext.spaces() + id);
		getAttributes().render(outputStreamWriter, renderContext);
		outputStreamWriter.write(";\n");
	}

	public void setId(String id) {
		this.id = id;
	}
}
