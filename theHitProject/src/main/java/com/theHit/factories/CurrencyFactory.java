package com.theHit.factories;

import com.theHit.interfaces.Currency;
import com.theHit.interfaces.impl.EURO;
import com.theHit.interfaces.impl.Pounds;

public class CurrencyFactory {
	public static Currency createCurrency (String country) {
	       if (country.equalsIgnoreCase ("Ireland")){
	              return new EURO();
	       }else if(country.equalsIgnoreCase ("England")){
	              return new Pounds();
	       }
	       else return null;
	  }	
}
