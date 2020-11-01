package com.khubla.dot4j.listener;

import com.khubla.dot.*;
import com.khubla.dot.DOTParser.*;

public class EdgeRHSListener extends AbstractListener {
	@Override
	public void enterEdgeRHS(DOTParser.EdgeRHSContext ctx) {
		if (null != ctx.node_id()) {
			for (Node_idContext node_idContext : ctx.node_id()) {
				NodeIdListener nodeIdListener = new NodeIdListener();
				nodeIdListener.enterNode_id(node_idContext);
			}
		} else if (null != ctx.subgraph()) {
			for (SubgraphContext subgraphContext : ctx.subgraph()) {
				SubgraphListener subgraphListener = new SubgraphListener();
				subgraphListener.enterSubgraph(subgraphContext);
			}
		}
	}
}
