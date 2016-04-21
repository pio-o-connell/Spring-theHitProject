package com.theHit.interfaces.impl;

import com.theHit.interfaces.Currency;

public class Pounds implements Currency{
	private static final String GBP = "GBP";
	@Override
	public String getSymbol() {
		// TODO Auto-generated method stub
		return GBP;
	}

}
