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
			NodeIdListener nodeIdListener = new NodeIdListener();
			nodeIdListener.enterNode_id(ctx.node_id());
			node.setNodeId(nodeIdListener.nodeId);
		}
		/*
		 * attr
		 */
		if (null != ctx.attr_list()) {
			AttributeListListener attributeListListener = new AttributeListListener();
			attributeListListener.enterAttr_list(ctx.attr_list());
			node.setAttributeList(attributeListListener.attributeList);
		}
	}
}
