package com.khubla.dot4j.listener;

import com.khubla.dot.*;
import com.khubla.dot.DOTParser.*;

public class EdgeRHSListener extends AbstractListener {
	@Override
	public void enterEdgeRHS(DOTParser.EdgeRHSContext ctx) {
		if (null != ctx.node_id()) {
			for (final Node_idContext node_idContext : ctx.node_id()) {
				final NodeIdListener nodeIdListener = new NodeIdListener();
				nodeIdListener.enterNode_id(node_idContext);
			}
		} else if (null != ctx.subgraph()) {
			for (final SubgraphContext subgraphContext : ctx.subgraph()) {
				final SubgraphListener subgraphListener = new SubgraphListener();
				subgraphListener.enterSubgraph(subgraphContext);
			}
		}
	}
}
