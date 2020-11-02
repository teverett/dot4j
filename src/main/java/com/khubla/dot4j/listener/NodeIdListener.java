package com.khubla.dot4j.listener;

import com.khubla.dot.*;
import com.khubla.dot4j.domain.*;

public class NodeIdListener extends AbstractListener {
	public NodeId nodeId;

	@Override
	public void enterNode_id(DOTParser.Node_idContext ctx) {
		/*
		 * id
		 */
		String id = null;
		if (null != ctx.id()) {
			final IdListener idListener = new IdListener();
			idListener.enterId(ctx.id());
			id = idListener.id;
		}
		/*
		 * port
		 */
		Port port = null;
		if (null != ctx.port()) {
			final PortListener portListener = new PortListener();
			portListener.enterPort(ctx.port());
			port = portListener.port;
		}
		nodeId = new NodeId(id, port);
	}
}
