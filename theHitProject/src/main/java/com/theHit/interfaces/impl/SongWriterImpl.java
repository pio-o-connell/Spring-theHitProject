package com.theHit.interfaces.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.theHit.domain.Person;
import com.theHit.domain.Song;
import com.theHit.interfaces.Songwriter;

//@Component("SongWriterImpl")
@Component
public class SongWriterImpl extends Person implements Songwriter {
	
	String firstname,lastname;
	int age;
	@Autowired
	Song song;
	
	public SongWriterImpl(){
		super();
		
	}
	
/*	public SongWriterImpl( String firstname, String lastname,int age,Song song){
	//	super(firstname,lastname,age); - because using bean inheritance
		this.firstname=firstname;
		this.lastname=lastname;
		this.age=age;
		this.song = song;
		
		System.out.println("fistname: "+ firstname +" lastname: "+ lastname +" age: " + age
				+" song name: "+ song.getName() + " song lyrics: "+ song.getLyrics());
	}*/
	
	/*@Autowired
	public SongWriterImpl(@Value("Mary") String firstname, @Value("O'Brien") String lastname, @Value("33") int age,  Song song) {
		super(firstname, lastname, age);
		this.song = song;		
	};*/
	
	@Autowired
	public SongWriterImpl(@Value("${firstname}") String firstname, @Value("${lastname}") String lastname, @Value("${age}") int age,  Song song) {
		super(firstname, lastname, age);
		this.song = song;		
	};
	
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}


	
	@Override
	public void compose(Song song) {
		// TODO Auto-generated method stub
		System.out.println("Composer " + firstname 
										+ lastname 
										 + " composed a song called " 
										  +song.getName() 
										  	+". This song has the following lyrics "
										  		+ song.getLyrics());
	}



}
