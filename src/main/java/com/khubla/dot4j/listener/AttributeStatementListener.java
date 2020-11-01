package com.khubla.dot4j.listener;

import com.khubla.dot.*;
import com.khubla.dot4j.domain.*;

public class AttributeStatementListener extends AbstractListener {
	public AttributeType attributeType;
	public AttributeList attributeList;

	@Override
	public void enterAttr_stmt(DOTParser.Attr_stmtContext ctx) {
		/*
		 * list
		 */
		if (null != ctx.attr_list()) {
			final AttributeListListener attributeListListener = new AttributeListListener();
			attributeListListener.enterAttr_list(ctx.attr_list());
			attributeList = attributeListListener.attributeList;
		}
		/*
		 * type
		 */
		if (null != ctx.NODE()) {
			attributeType = AttributeType.node;
		} else if (null != ctx.EDGE()) {
			attributeType = AttributeType.edge;
		} else {
			attributeType = AttributeType.graph;
		}
	}
}
