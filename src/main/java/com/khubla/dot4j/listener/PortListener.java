package com.khubla.dot4j.listener;

import com.khubla.dot.*;
import com.khubla.dot4j.domain.*;

public class PortListener extends AbstractListener {
	public Port port;

	@Override
	public void enterPort(DOTParser.PortContext ctx) {
		port = new Port();
		if (null != ctx.id()) {
			final IdListener idListener = new IdListener();
			idListener.enterId(ctx.id().get(0));
			port.setId(idListener.id);
			if (ctx.id().size() > 1) {
				final IdListener idListener2 = new IdListener();
				idListener2.enterId(ctx.id().get(1));
				port.setCompassPoint(CompassPoint.valueOf(idListener2.id));
			}
		}
		throw new RuntimeException("Not Implemented");
	}
}
