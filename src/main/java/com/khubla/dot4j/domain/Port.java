package com.khubla.dot4j.domain;

public class Port {
	private final String id;
	private final CompassPoint compassPoint;

	public Port(String port) {
		if (port.contains(":")) {
			final String[] names = port.split(":");
			id = names[0];
			compassPoint = CompassPoint.valueOf(names[1]);
		} else {
			id = port;
			compassPoint = null;
		}
	}

	public Port(String id, CompassPoint compassPoint) {
		this.id = id;
		this.compassPoint = compassPoint;
	}

	public CompassPoint getCompassPoint() {
		return compassPoint;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		if (null != compassPoint) {
			return id + ":" + compassPoint.toString();
		} else {
			return id;
		}
	}
}
