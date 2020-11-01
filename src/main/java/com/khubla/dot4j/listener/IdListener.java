package com.khubla.dot4j.listener;

import com.khubla.dot.*;

public class IdListener extends AbstractListener {
	public String id;

	@Override
	public void enterId(DOTParser.IdContext ctx) {
		id = ctx.getText();
	}
}
