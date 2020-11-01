package com.khubla.dot4j.listener;

import com.khubla.dot.*;
import com.khubla.dot4j.domain.*;

public class PortListener extends AbstractListener {
	public Port port;

	@Override
	public void enterPort(DOTParser.PortContext ctx) {
		this.port = new Port();
		if (null != ctx.id()) {
		}
		throw new RuntimeException("Not Implemented");
	}
}
