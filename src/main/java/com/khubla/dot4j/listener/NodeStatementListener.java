package com.khubla.dot4j.listener;

import com.khubla.dot.*;
import com.khubla.dot4j.domain.*;

public class NodeStatementListener extends AbstractListener {
	public Node node;

	@Override
	public void enterNode_stmt(DOTParser.Node_stmtContext ctx) {
		node = new Node();
		/*
		 * id
		 */
		if (null != ctx.node_id()) {
			final NodeIdListener nodeIdListener = new NodeIdListener();
			nodeIdListener.enterNode_id(ctx.node_id());
			node.setId(nodeIdListener.nodeId.toString());
		}
		/*
		 * ` attr
		 */
		if (null != ctx.attr_list()) {
			final AttributeListListener attributeListListener = new AttributeListListener(AttributeType.node);
			attributeListListener.enterAttr_list(ctx.attr_list());
			node.addAttributes(attributeListListener.attributes);
		}
	}
}
