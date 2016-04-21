package com.theHit.interfaces.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.theHit.domain.Person;
import com.theHit.domain.Song;
import com.theHit.interfaces.Singer;

public class SingerImpl extends Person implements Singer{
	Song song;
	
	public SingerImpl(){
		
	}
	
	public SingerImpl(String firstname,String lastname,int age,Song song){
		super(firstname,lastname,age);
		this.song = song;
	}
	
	
	
	@Override
	public void perform(Song song) {
		// TODO Auto-generated method stub
		
	}

		
	public Song getSong() {
		return song;
	}
	
	@Autowired
	@Qualifier("Song")
	public void setSong(Song song) {
		this.song = song;
	}



}
