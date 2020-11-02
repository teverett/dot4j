package com.khubla.dot4j.listener;

import com.khubla.dot.*;
import com.khubla.dot.DOTParser.*;
import com.khubla.dot4j.domain.*;

public class AttributeListListener extends AbstractListener {
	private final Attributes attributes;

	public AttributeListListener(Attributes attributes) {
		super();
		this.attributes = attributes;
	}

	@Override
	public void enterAttr_list(DOTParser.Attr_listContext ctx) {
		/*
		 * list
		 */
		if (null != ctx.a_list()) {
			for (final A_listContext a_listContext : ctx.a_list()) {
				final AListListener aListListener = new AListListener(attributes);
				aListListener.enterA_list(a_listContext);
			}
		}
	}
}
