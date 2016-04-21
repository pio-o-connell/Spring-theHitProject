package com.theHit.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Song {

	private String name;
	private String lyrics;
	
/*	public Song(String name, String lyrics){
		this.name=name;
		this.lyrics=lyrics;
		
		System.out.println("SONG CONSTRUCTOR: The name of the song is: "+name);
		System.out.println("SONG CONSTRUCTOR: The lyrics of the song are:"+lyrics);    
	} */
	
	/*@Autowired
	public Song(@Value("Oh Danny Boy") String name, @Value("The pipes the pipes are calling")String lyrics){
		this.name=name;
		this.lyrics=lyrics;
	} */
	
	@Autowired
	public Song(@Value("${name}") String name, @Value("${lyrics}")String lyrics){
		this.name=name;
		this.lyrics=lyrics;
	} 
	
	
	
	public Song(){
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getLyrics() {
		return lyrics;
	}
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}	
	
}