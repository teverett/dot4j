package com.khubla.dot4j.domain;

import java.util.*;

public class Attribute {
	private String lhs;
	private final List<String> rhs = new ArrayList<String>();

	public void addRHS(String id) {
		rhs.add(id);
	}

	public String getLhs() {
		return lhs;
	}

	public List<String> getRhs() {
		return rhs;
	}

	public void setLhs(String lhs) {
		this.lhs = lhs;
	}
}
