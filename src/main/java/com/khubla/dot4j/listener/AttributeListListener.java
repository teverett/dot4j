package com.khubla.dot4j.listener;

import com.khubla.dot.*;
import com.khubla.dot.DOTParser.*;
import com.khubla.dot4j.domain.*;

public class AttributeListListener extends AbstractListener {
	public Attributes attributes;

	@Override
	public void enterAttr_list(DOTParser.Attr_listContext ctx) {
		attributes = new Attributes();
		/*
		 * list
		 */
		if (null != ctx.a_list()) {
			for (final A_listContext a_listContext : ctx.a_list()) {
				final AListListener aListListener = new AListListener();
				aListListener.enterA_list(a_listContext);
				attributes.addAttribute(aListListener.attribute);
			}
		}
	}
}
