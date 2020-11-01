package com.khubla.dot4j;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.*;

import com.khubla.dot4j.domain.*;

public class Test4 {
	@Test
	public void test11() {
		try {
			final InputStream inputStream = Test4.class.getResourceAsStream("/example4.txt");
			assertNotNull(inputStream);
			final Graph graph = DOTMarshaller.importGraph(inputStream);
			/*
			 * graph
			 */
			assertNotNull(graph);
			assertTrue(graph.getId().compareTo("ethane") == 0);
			/*
			 * graph attribs
			 */
			assertTrue(graph.getGraphAttributes().getAttributes().size() == 0);
			/*
			 * edges
			 */
			assertTrue(graph.getEdges().size() == 7);
			for (int i = 0; i < 7; i++) {
				final Edge edge = graph.getEdges().get(i);
				assertTrue(edge.getRhsGraphs().size() == 0);
				assertTrue(edge.getRhsNodeIds().size() == 1);
				assertTrue(edge.getAttributeList().getAttributes().size() == 1);
			}
			/*
			 * nodes
			 */
			assertTrue(graph.getNodes().size() == 0);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
