package com.khubla.dot4j;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.*;

import com.khubla.dot4j.domain.*;

public class Test1 {
	@Test
	public void test11() {
		try {
			final InputStream inputStream = Test1.class.getResourceAsStream("/example1.txt");
			assertNotNull(inputStream);
			final Graph graph = DOTMarshaller.importGraph(inputStream);
			/*
			 * graph
			 */
			assertNotNull(graph);
			assertTrue(graph.getId().compareTo("graphname") == 0);
			/*
			 * graph attribs
			 */
			assertTrue(graph.getGraphAttributes().getAttributes().size() == 0);
			/*
			 * edges
			 */
			assertTrue(graph.getEdges().size() == 3);
			/*
			 * nodes
			 */
			assertTrue(graph.getNodes().size() == 0);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
