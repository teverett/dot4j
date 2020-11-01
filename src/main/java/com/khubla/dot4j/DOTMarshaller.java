package com.khubla.dot4j;

import java.io.*;

import org.antlr.v4.runtime.*;

import com.khubla.dot.*;
import com.khubla.dot4j.domain.*;
import com.khubla.dot4j.listener.*;

public class DOTMarshaller {
	// public static void exportGraph(GraphmlType graphmlType, OutputStream outputStream) throws
	// IOException, JAXBException {
	// if ((null != graphmlType) && (null != outputStream)) {
	// final JAXBContext jc = JAXBContext.newInstance(PACKAGE);
	// final Marshaller marshaller = jc.createMarshaller();
	// marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	// /*
	// * marshal
	// */
	// final ObjectFactory objectFactory = new ObjectFactory();
	// final JAXBElement<GraphmlType> je = objectFactory.createGraphml(graphmlType);
	// marshaller.marshal(je, outputStream);
	// }
	// }
	//
	public static Graph importGraph(InputStream inputStream) throws IOException {
		if (null != inputStream) {
			/*
			 * make Lexer
			 */
			final Lexer lexer = new DOTLexer(CharStreams.fromStream(inputStream));
			/*
			 * get a TokenStream on the Lexer
			 */
			final TokenStream tokenStream = new CommonTokenStream(lexer);
			/*
			 * make a Parser on the token stream
			 */
			DOTParser dotParser = new DOTParser(tokenStream);
			/*
			 * listener
			 */
			GraphListener graphListener = new GraphListener();
			/*
			 * parse
			 */
			graphListener.enterGraph(dotParser.graph());
			/*
			 * done
			 */
			return graphListener.graph;
		} else {
			return null;
		}
	}
}
