package com.theHit;

import java.util.List;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.theHit.domain.CollectionsExample;
import com.theHit.domain.Song;
import com.theHit.domain.Stage;
import com.theHit.domain.Ticket;
import com.theHit.domain.Venue;
import com.theHit.interfaces.Currency;
import com.theHit.interfaces.Songwriter;
import com.theHit.interfaces.impl.SingerImpl;
import com.theHit.interfaces.impl.SongWriterImpl;
import com.theHit.jdbctemplate.dao.impl.SongwriterJdbcDaoSupport;
import com.theHit.jdbctemplate.dao.impl.SongwriterJdbcNameParmTemplate;
import com.theHit.jdbctemplate.dao.impl.SongwriterJdbcTemplate;

public class App {

	private static ApplicationContext autoWireContext;

	public static void main(String[] args) {
		autoWireContext = new ClassPathXmlApplicationContext("db-configuration.xml");

	/*	SongwriterJdbcTemplate songwriterJdbcTemplate = (SongwriterJdbcTemplate) autoWireContext
				.getBean("songwriterJdbcTemplate");
		songwriterJdbcTemplate.createSongwriter("Mary", "O'Brien", 33);*/
		
	/*	SongwriterJdbcDaoSupport songwriterDaoJdbcSupport= (SongwriterJdbcDaoSupport) autoWireContext
				.getBean("songwriterJdbcDaoSupport");
//		SongwriterDaoJdbcSupport.createSongwriter("Mary", "O'Brien", 33);
		
		/*List<SongWriterImpl> songwriters = songwriterJdbcTemplate.listSongwriters();
		for (SongWriterImpl record : songwriters) {
			System.out.print("Firstname : " + record.getFirstname() );
			System.out.print(", Lastname : " + record.getLastname() );
			System.out.print(", Lastname : " + record.getId() );
			System.out.println(", Age : " + record.getAge());
		} */
	/*	List<SongWriterImpl> songwriters = songwriterDaoJdbcSupport.listSongwriters();
		for (SongWriterImpl record : songwriters) {
			System.out.print("Firstname : " + record.getFirstname() );
			System.out.print(", Lastname : " + record.getLastname() );
			System.out.print(", Lastname : " + record.getId() );
			System.out.println(", Age : " + record.getAge());
		} */
		
		SongwriterJdbcNameParmTemplate namedParmTemplate=(SongwriterJdbcNameParmTemplate)autoWireContext.getBean("songwriterJdbcNameParmTemplate");
		namedParmTemplate.createSongwriter("Mary", "Daly", 33);

	}
}

/*
 * public class App { private static ApplicationContext autoWireContext;
 * 
 * public static void main(String[] args) { autoWireContext = new
 * ClassPathXmlApplicationContext("autoWireConfiguration1.xml"); SongWriterImpl
 * songWriterImpl = (SongWriterImpl) autoWireContext.getBean("songWriterImpl");
 * System.out.println(songWriterImpl.toString());
 * 
 * System.out.println("Firstname:" + songWriterImpl.getFirstname() +
 * ", Lastname: " + songWriterImpl.getLastname() + ", age:" +
 * songWriterImpl.getAge() + ", song name:" + songWriterImpl.getSong().getName()
 * + ", song lyrics:" + songWriterImpl.getSong().getLyrics()); } }
 */

/*
 * public class App {
 * 
 * private static ApplicationContext context, autoWirecontext,
 * annotationContext;
 * 
 * public static void main(String args[]) {
 * 
 * context = new ClassPathXmlApplicationContext("configuration.xml");
 * 
 * Simple bean blank constructor Songwriter simpleBeanExample = (Songwriter)
 * context.getBean("ourFirstBean");
 * 
 * Song setterDISong = (Song) context.getBean("setterBeanSong");
 * System.out.println("Song name is: " + setterDISong.getName());
 * System.out.println("Song lyrics are: " + setterDISong.getLyrics());
 * 
 * SongWriterImpl setterDISongwriter = (SongWriterImpl)
 * context.getBean("setterSongwriter"); System.out.println(
 * "Songwriter firstname is: " + setterDISongwriter.getFirstname());
 * System.out.println("Songwriter second name is: " +
 * setterDISongwriter.getLastname()); System.out.println("Songwriter age is: " +
 * setterDISongwriter.getAge()); System.out.println(
 * "Songwriter song details are: Song name: " +
 * setterDISongwriter.getSong().getName() + " Song lyrics are: " +
 * setterDISongwriter.getSong().getLyrics());
 * 
 * Currency currency = (Currency) context.getBean("currency");
 * System.out.println("Currency symbol: " + currency.getSymbol());
 * 
 * Stage stage = (Stage) context.getBean("theStage"); System.out.println(
 * "Stage instance value: " + stage.toString()); Stage stage1 = (Stage)
 * context.getBean("theStage1"); System.out.println("Stage instance value: " +
 * stage1.toString());
 * 
 * 
 * Singleton Example Even when we create 2 bean instances of the object Stage
 * the same instance is returned.
 * 
 * Ticket ticketSingleton = (Ticket) context.getBean("ticket");
 * System.out.println("Instance:" + ticketSingleton.toString()); Ticket
 * ticketSingleton1 = (Ticket) context.getBean("ticket");
 * System.out.println("Instance:" + ticketSingleton1.toString());
 * 
 * Ticket ticketPrototype = (Ticket) context.getBean("ticketPrototype");
 * System.out.println("Instance:" + ticketPrototype.toString()); Ticket
 * ticketPrototypeAnother = (Ticket) context.getBean("ticketPrototype");
 * System.out.println("Instance:" + ticketPrototypeAnother.toString());
 * 
 * Venue venue = (Venue) context.getBean("setterVenue"); System.out.println(
 * "Venue instance value: " + venue.toString()); Venue venue1 = (Venue)
 * context.getBean("setterVenue"); System.out.println("Venue instance value: " +
 * venue1.toString());
 * 
 * CollectionsExample javaCollectionExample = (CollectionsExample)
 * context.getBean("javaCollectionExample");
 * javaCollectionExample.getInstrumentList();
 * javaCollectionExample.getInstrumentSet();
 * javaCollectionExample.getInstrumentMap();
 * javaCollectionExample.getInstrumentProp();
 * 
 * autoWirecontext = new
 * ClassPathXmlApplicationContext("autoWireConfiguration.xml");
 * 
 * SongWriterImpl songWriterAutoWire = (SongWriterImpl)
 * autoWirecontext.getBean("autoWireExampleBean"); System.out.println(
 * "Song writer firstname is: " + songWriterAutoWire.getFirstname());
 * System.out.println("Song writer lastname is: " +
 * songWriterAutoWire.getLastname()); System.out.println("Song writer age is: "
 * + songWriterAutoWire.getAge()); System.out.println(
 * "Song writer song name is: " + songWriterAutoWire.getSong().getName() +
 * " lyrics: " + songWriterAutoWire.getSong().getLyrics());
 * 
 * SingerImpl singerAutoWireByType=(SingerImpl)autoWirecontext.getBean(
 * "autoWireExampleByTypeBean"); System.out.println("Singer firstname is: "+
 * singerAutoWireByType.getFirstname()); System.out.println(
 * "Singer lastname is: "+ singerAutoWireByType.getLastname());
 * System.out.println("Singer age is: "+ singerAutoWireByType.getAge());
 * System.out.println("Singer song name is: "+
 * singerAutoWireByType.getSong().getName()+ " lyrics: "
 * +singerAutoWireByType.getSong().getLyrics());
 * 
 * SongWriterImpl autoWirebyConstructor=(SongWriterImpl)autoWirecontext.getBean(
 * "autoWirebyConstructor"); System.out.println("Song writer firstname is: "+
 * autoWirebyConstructor.getFirstname()); System.out.println(
 * "Song writer lastname is: "+ autoWirebyConstructor.getLastname());
 * System.out.println("Song writer age is: "+ autoWirebyConstructor.getAge());
 * System.out.println("Song writer song name is: "+
 * autoWirebyConstructor.getSong().getName()+ " lyrics: "
 * +autoWirebyConstructor.getSong().getLyrics());
 * 
 * annotationContext = new
 * ClassPathXmlApplicationContext("configuration-wiring.xml"); Venue venueauto =
 * (Venue) annotationContext.getBean("annotationRequiredExample");
 * System.out.println("Venue instance value: " + venueauto.toString());
 * System.out.println("Venue capacity: "+ venueauto.getCapacity());
 * 
 * 
 * } }
 */