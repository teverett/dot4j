package com.khubla.dot4j;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.*;

import com.khubla.dot4j.domain.*;

public class Test1 {
	@Test
	public void test11() {
		try {
			InputStream inputStream = Test1.class.getResourceAsStream("/example1.txt");
			assertNotNull(inputStream);
			Graph graph = DOTMarshaller.importGraph(inputStream);
			assertNotNull(graph);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
