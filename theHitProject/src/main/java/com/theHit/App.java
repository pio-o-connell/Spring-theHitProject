package com.theHit;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.theHit.domain.Song;
import com.theHit.domain.Stage;
import com.theHit.domain.Ticket;
import com.theHit.domain.Venue;
import com.theHit.interfaces.Currency;
import com.theHit.interfaces.Songwriter;
import com.theHit.interfaces.impl.SongWriterImpl;
public class App {

	private static ApplicationContext context;	
	public static void main (String args[]){
		
	context=new ClassPathXmlApplicationContext("configuration.xml"); 
		
	/** Simple bean blank constructor **/
	Songwriter simpleBeanExample=(Songwriter)context.getBean("ourFirstBean"); 
	
	Song setterDISong =(Song)context.getBean("setterBeanSong");
	System.out.println("Song name is: "+ setterDISong.getName());
	System.out.println("Song lyrics are: "+setterDISong.getLyrics());
	
	SongWriterImpl setterDISongwriter =(SongWriterImpl)context.getBean("setterSongwriter");
	System.out.println("Songwriter firstname is: "+ setterDISongwriter.getFirstname());
	System.out.println("Songwriter second name is: "+setterDISongwriter.getLastname());
	System.out.println("Songwriter age is: "+setterDISongwriter.getAge());
	System.out.println("Songwriter song details are: Song name: "+setterDISongwriter.getSong().getName()+
	        		" Song lyrics are: "+setterDISongwriter.getSong().getLyrics());   
	
	Currency currency=(Currency)context.getBean("currency");
	System.out.println("Currency symbol: " + currency.getSymbol());
	
	Stage stage=(Stage)context.getBean("theStage");
	System.out.println("Stage instance value: "+ stage.toString());
	Stage stage1=(Stage)context.getBean("theStage1");
	System.out.println("Stage instance value: "+ stage1.toString());
	
	/**
	* Singleton Example
	* Even when we create 2 bean instances of the object Stage the same instance is returned.
	**/
	 Ticket ticketSingleton=(Ticket)context.getBean("ticket");
	 System.out.println("Instance:"+ ticketSingleton.toString());
	 Ticket ticketSingleton1=(Ticket)context.getBean("ticket");
	 System.out.println("Instance:"+ ticketSingleton1.toString());
	
	 Ticket ticketPrototype=(Ticket)context.getBean("ticketPrototype");
	 System.out.println("Instance:"+ ticketPrototype.toString());
	 Ticket ticketPrototypeAnother=(Ticket)context.getBean("ticketPrototype");
	 System.out.println("Instance:"+ ticketPrototypeAnother.toString());
	 
	 
	 Venue venue=(Venue)context.getBean("setterVenue");
		System.out.println("Venue instance value: "+ venue.toString());
		Venue venue1=(Venue)context.getBean("setterVenue");
		System.out.println("Venue instance value: "+ venue1.toString());
	
         }
  }         
