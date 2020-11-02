package com.khubla.dot4j.domain;

import java.io.*;

public class Node implements Vertex, Renderable {
	private final Attributes attributes = new Attributes();
	private String id;

	public void addAttributes(Attributes attributeList) {
		attributes.addAttributes(attributeList);
	}

	public Attributes getAttributes() {
		return attributes;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void render(OutputStreamWriter outputStreamWriter, RenderContext renderContext) throws IOException {
		outputStreamWriter.write(renderContext.spaces() + id);
		attributes.render(outputStreamWriter, renderContext);
		outputStreamWriter.write(";\n");
	}

	public void setId(String id) {
		this.id = id;
	}
}
