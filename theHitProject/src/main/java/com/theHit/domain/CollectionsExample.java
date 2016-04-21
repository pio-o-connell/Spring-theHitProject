package com.theHit.domain;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionsExample {
	private List<String> instrumentList;
	private Set<String> instrumentSet;
	private Map<Integer, String> instrumentMap;
	private Properties instrumentProp;

	public List<String> getInstrumentList() {
		System.out.println("List Elements :" + instrumentList);
		return instrumentList;
	}

	public void setInstrumentList(List<String> instrumentList) {
		this.instrumentList = instrumentList;
	}

	public Set<String> getInstrumentSet() {
		System.out.println("Set Elements :" + instrumentSet);
		return instrumentSet;
	}

	public void setInstrumentSet(Set<String> instrumentSet) {
		this.instrumentSet = instrumentSet;
	}

	public Map<Integer, String> getInstrumentMap() {
		System.out.println("Map Elements :" + instrumentMap);
		return instrumentMap;
	}

	public void setInstrumentMap(Map<Integer, String> instrumentMap) {
		this.instrumentMap = instrumentMap;
	}

	public Properties getInstrumentProp() {
		System.out.println("Prop Elements :" + instrumentProp);
		return instrumentProp;
	}

	public void setInstrumentProp(Properties instrumentProp) {
		this.instrumentProp = instrumentProp;
	}
}
