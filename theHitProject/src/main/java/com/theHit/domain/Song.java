package com.theHit.domain;

public class Song {

	private String name;
	private String lyrics;
	
	public Song(String name, String lyrics){
		this.name=name;
		this.lyrics=lyrics;
		
		System.out.println("SONG CONSTRUCTOR: The name of the song is: "+name);
		System.out.println("SONG CONSTRUCTOR: The lyrics of the song are:"+lyrics);    
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