package com.theHit.jdbctemplate.dao.interfaces;

import java.util.List;

import javax.sql.DataSource;

import com.theHit.interfaces.impl.SongWriterImpl;

public interface SongwriterDAO {
	/** 
	 * This is the method to be used to initialize
	 * database resources ie. connection.
	 */
	public void setDataSource(DataSource ds);
	/** 
	 * This is the method to be used to create
	 * a record in the Songwriter table.
	 */
	public void createSongwriter(String firstname, String lastname, Integer age);
	/** 
	 * This is the method to be used to delete
	 * a record from the songwriter table corresponding
	 * to a passed songwriter firstname and lastname.
	 */
	public void deleteSongwriter(String firstname, String lastname);
	/** 
	 * This is the method to be used to update
	 * a record into the songwriter table.
	 */
	public void updateSongwriter(String firstname, String lastname, Integer age);
	
	/** 
	 * This is the method to be used to delete
	 * a record from the songwriter table corresponding
	 * to a passed songwriter id.
	 */
	public void deleteSongwriter(Integer id);
	/** 
	 * This is the method to be used to update
	 * a record into the songwriter table.
	 */
	public void updateSongwriter(Integer id, Integer age);
	
	
	/** 
	 * This is the method to be used to list down
	 * a record from the Songwriter table corresponding
	 * to a passed songwriter id.
	 */
	public SongWriterImpl getSongwriter(Integer id);
	/** 
	 * This is the method to be used to list down
	 * all the records from the Songwriter table.
	 */
	public List<SongWriterImpl> listSongwriters();
	
	
	
	
	
}
