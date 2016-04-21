package com.theHit.interfaces.impl;

import com.theHit.interfaces.Currency;

public class EURO implements Currency{

	private static final String EUR = "EUR";
	@Override
	public String getSymbol() {
		// TODO Auto-generated method stub
		return EUR;
	}

}
