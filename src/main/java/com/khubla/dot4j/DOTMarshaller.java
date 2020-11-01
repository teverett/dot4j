package com.khubla.dot4j;

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
	// public static GraphmlType importGraph(InputStream inputStream) throws IOException,
	// JAXBException {
	// if (null != inputStream) {
	// final JAXBContext jc = JAXBContext.newInstance(PACKAGE);
	// final Unmarshaller unmarshaller = jc.createUnmarshaller();
	// @SuppressWarnings("unchecked")
	// final JAXBElement<GraphmlType> je = (JAXBElement<GraphmlType>)
	// unmarshaller.unmarshal(inputStream);
	// return je.getValue();
	// } else {
	// return null;
	// }
	// }
}
