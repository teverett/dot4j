package com.khubla.dot4j;

import java.io.*;

import org.junit.jupiter.api.*;

import com.khubla.dot4j.domain.*;

public class Test7 {
	@Test
	public void testProgrammatic() {
		try {
			final ByteArrayOutputStream baos = new ByteArrayOutputStream();
			final Graph g = new Graph(false, GraphType.digraph, "mygraph");
			final Node n1 = new Node("n1");
			g.addNode(n1);
			final Node n2 = new Node("node2");
			g.addNode(n2);
			final Edge theEdge = new Edge("n1", "node2");
			g.addEdge(theEdge);
			DOTMarshaller.exportGraph(g, baos);
			System.out.println(baos.toString());
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
