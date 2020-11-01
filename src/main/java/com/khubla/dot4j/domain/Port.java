package com.khubla.dot4j.domain;

public class Port {
	private String id;
	private CompassPoint compassPoint;

	public Port() {
	}

	public Port(String port) {
		if (port.contains(":")) {
			final String[] names = port.split(":");
			id = names[0];
			compassPoint = CompassPoint.valueOf(names[1]);
		} else {
			id = port;
		}
	}

	public CompassPoint getCompassPoint() {
		return compassPoint;
	}

	public String getId() {
		return id;
	}

	public void setCompassPoint(CompassPoint compassPoint) {
		this.compassPoint = compassPoint;
	}

	public void setId(String id) {
		this.id = id;
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
