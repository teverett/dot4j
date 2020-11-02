package com.khubla.dot4j.listener;

import java.util.*;

import org.antlr.v4.runtime.tree.*;

import com.khubla.dot.*;
import com.khubla.dot.DOTParser.*;
import com.khubla.dot4j.domain.*;

public class EdgeRHSListener extends AbstractListener {
	public List<EdgeConnectionPoint> connectionPoints = new ArrayList<EdgeConnectionPoint>();

	@Override
	public void enterEdgeRHS(DOTParser.EdgeRHSContext ctx) {
		for (int i = 0; i < ctx.children.size(); i++) {
			final ParseTree parseTree = ctx.children.get(i);
			if (parseTree instanceof Node_idContext) {
				final NodeIdListener nodeIdListener = new NodeIdListener();
				nodeIdListener.enterNode_id((Node_idContext) parseTree);
				final EdgeConnectionPoint edgeConnectionPoint = new EdgeConnectionPoint(nodeIdListener.nodeId);
				connectionPoints.add(edgeConnectionPoint);
			} else if (parseTree instanceof SubgraphContext) {
				final SubgraphListener subgraphListener = new SubgraphListener();
				subgraphListener.enterSubgraph((SubgraphContext) parseTree);
				final EdgeConnectionPoint edgeConnectionPoint = new EdgeConnectionPoint(subgraphListener.graph);
				connectionPoints.add(edgeConnectionPoint);
			}
		}
	}
}
