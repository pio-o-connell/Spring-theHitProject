package com.theHit.jdbctemplate.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.theHit.interfaces.impl.SongWriterImpl;
import com.theHit.jdbctemplate.dao.interfaces.SongwriterDAO;

public class SongwriterJdbcTemplate implements SongwriterDAO{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void createSongwriter(String firstname, String lastname, Integer age) {
		String SQL = "insert into Songwriter (firstname, lastname, age) values (?, ?, ?)";
		jdbcTemplateObject.update(SQL, new Object[] { firstname, lastname, age});
		System.out.println("Created Record Name = " + firstname + " Age = " + age);
		return;	
	}

	@Override
	public void deleteSongwriter(Integer id) {
		String SQL = "delete from Songwriter where id = ?";
		jdbcTemplateObject.update(SQL, new Object[] {id});
		System.out.println("Deleted Record with ID = " + id );
		return;
		
	}

	@Override
	public void updateSongwriter(Integer id, Integer age) {
		String SQL = "update Songwriter set age = ? where id = ?";
		jdbcTemplateObject.update(SQL,  new Object[] {age, id});
		System.out.println("Updated Record with ID = " + id );
		return;		
	}

	@Override
	public void deleteSongwriter(String firstname, String lastname) {
		String SQL = "delete from Songwriter where firstname = ? and lastname = ?";
		jdbcTemplateObject.update(SQL, new Object[] {firstname, lastname});
		System.out.println("Deleted Record with ID = " + firstname );
		return;
		
	}

	@Override
	public void updateSongwriter(String firstname, String lastname, Integer age) {
		String SQL = "update Songwriter set age = ? where firstname = ? and lastname = ?";
		jdbcTemplateObject.update(SQL,  new Object[] {age, firstname, lastname});
		System.out.println("Updated Record with ID = " + firstname );
		return;			
	}	
	
	@Override
	public SongWriterImpl getSongwriter(Integer id) {
		String SQL = "select * from songwriter where id = ?";
		SongWriterImpl songwriter = (SongWriterImpl) jdbcTemplateObject.queryForObject(SQL, 
						new Object[]{id}, new SongwriterMapper());
		return songwriter;
	}

	@Override
	public List<SongWriterImpl> listSongwriters() {
		String SQL = "select * from songwriter";
		List<SongWriterImpl> songwriterList = jdbcTemplateObject.query(SQL, 
						new SongwriterMapper());
		return songwriterList;
	}	
          
	
	

}
