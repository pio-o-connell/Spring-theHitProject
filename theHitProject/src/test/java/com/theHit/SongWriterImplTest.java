package com.theHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.theHit.interfaces.impl.SongWriterImpl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:configuration.xml"}) 
@ContextConfiguration({"classpath:configuration.xml"})
public class SongWriterImplTest {
	@Autowired
	ApplicationContext context;
	
	@Test
	public void testCompose() {
		SongWriterImpl songWriterTest=(SongWriterImpl)context.getBean("MarySongWriter");
			
		final String expectedSongName="Oh Danny Boy";
		String actualSongName= songWriterTest.getSong().getName();
		assertEquals(expectedSongName, actualSongName);
	} 
	

}
