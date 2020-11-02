package com.khubla.dot4j.listener;

import com.khubla.dot.*;
import com.khubla.dot4j.domain.*;

public class AttributeStatementListener extends AbstractListener {
	public Attributes attributes;

	@Override
	public void enterAttr_stmt(DOTParser.Attr_stmtContext ctx) {
		/*
		 * type
		 */
		AttributeType attributeType;
		if (null != ctx.NODE()) {
			attributeType = AttributeType.node;
		} else if (null != ctx.EDGE()) {
			attributeType = AttributeType.edge;
		} else if (null != ctx.GRAPH()) {
			attributeType = AttributeType.graph;
		} else {
			attributeType = AttributeType.anonymous;
		}
		attributes = new Attributes(attributeType);
		/*
		 * list
		 */
		if (null != ctx.attr_list()) {
			final AttributeListListener attributeListListener = new AttributeListListener(attributes);
			attributeListListener.enterAttr_list(ctx.attr_list());
		}
	}
}
