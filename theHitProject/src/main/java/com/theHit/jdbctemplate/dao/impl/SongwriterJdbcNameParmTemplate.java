package com.theHit.jdbctemplate.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.theHit.interfaces.impl.SongWriterImpl;
import com.theHit.jdbctemplate.dao.interfaces.SongwriterDAO;

public class SongwriterJdbcNameParmTemplate implements SongwriterDAO{
	private NamedParameterJdbcTemplate namedParameterjdbcTemplateObject;
	private SqlParameterSource namedParameters; 
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource ds) {
		this.namedParameterjdbcTemplateObject = new NamedParameterJdbcTemplate(dataSource);		
	}

	@Override
	public void createSongwriter(String firstname, String lastname, Integer age) {
		String SQL = "insert into songwriter (firstname, lastname, age) values (:firstname, :lastname, :age)";	
		
		//Create a Map		
		Map<String, Object> parameters = new HashMap <String, Object>();	
		
		//Add key values pairs to Map	
		parameters.put("firstname", firstname);
		parameters.put("lastname", firstname);
		parameters.put("age", age);
		
		//The NamedParameterJdbcTemplate accepts a Map as valid parameter see Java doc for more information
		namedParameterjdbcTemplateObject.update(SQL, parameters);
		System.out.println("Created Record Name = " + firstname + " Age = " + age);
		
	}
	@Override
	public SongWriterImpl getSongwriter(Integer id) {	
		String SQL = "select * from Singer where id = :id";	
		
		//MapSqlParameterSource class is intended for passing in a simple Map of parameter values to the methods of the
		//NamedParameterJdbcTemplate class. 		
		namedParameters = new MapSqlParameterSource("id", id);	
		SongWriterImpl songwriter = (SongWriterImpl) namedParameterjdbcTemplateObject.queryForObject(SQL, 
						namedParameters, new SongwriterMapper());
		return songwriter;
	}

	@Override
	public List<SongWriterImpl> listSongwriters() {	
		String SQL = "select * from songwriter";		
		List <SongWriterImpl>  songwriters =namedParameterjdbcTemplateObject.query 
						(SQL, namedParameters, new SongwriterMapper());
		return songwriters;		
	}



	@Override
	public void deleteSongwriter(String firstname, String lastname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSongwriter(String firstname, String lastname, Integer age) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSongwriter(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSongwriter(Integer id, Integer age) {
		// TODO Auto-generated method stub
		
	}


}