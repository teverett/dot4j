package com.khubla.dot4j.domain;

public class NodeId {
	private String id;
	private Port port;

	public NodeId() {
	}

	public NodeId(String name) {
		if (name.contains(":")) {
			final String[] names = name.split(":");
			id = names[0];
			port = new Port(names[1]);
		} else {
			id = name;
		}
	}

	public String getId() {
		return id;
	}

	public Port getPort() {
		return port;
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
