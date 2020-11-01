package com.khubla.dot4j.listener;

import com.khubla.dot.*;
import com.khubla.dot4j.domain.*;

public class NodeIdListener extends AbstractListener {
	public NodeId nodeId;

	@Override
	public void enterNode_id(DOTParser.Node_idContext ctx) {
		nodeId = new NodeId();
		if (null != ctx.id()) {
			IdListener idListener = new IdListener();
			idListener.enterId(ctx.id());
			nodeId.setId(idListener.id);
		}
		if (null != ctx.port()) {
			PortListener portListener = new PortListener();
			portListener.enterPort(ctx.port());
			nodeId.setPort(portListener.port);
		}
	}
}
