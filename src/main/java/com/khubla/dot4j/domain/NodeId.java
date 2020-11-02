package com.khubla.dot4j.domain;

import java.io.*;

public class NodeId implements Renderable {
	private String id;
	private Port port;

	public NodeId(String name) {
		if (name.contains(":")) {
			final String[] names = name.split(":");
			id = names[0];
			port = new Port(names[1]);
		} else {
			id = name;
		}
	}

	public NodeId(String id, Port port) {
		this.id = id;
		this.port = port;
	}

	public String getId() {
		return id;
	}

	public Port getPort() {
		return port;
	}

	@Override
	public void render(OutputStreamWriter outputStreamWriter, RenderContext renderContext) throws IOException {
		outputStreamWriter.write(id);
		if (null != port) {
			outputStreamWriter.write(":" + port.getId());
		}
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPort(Port port) {
		this.port = port;
	}

	@Override
	public String toString() {
		if (null != port) {
			return id + ":" + port.toString();
		} else {
			return id;
		}
	}
}
