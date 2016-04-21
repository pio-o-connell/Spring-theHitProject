package com.theHit.jdbctemplate.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.theHit.interfaces.impl.SongWriterImpl;

public class SongwriterMapper implements RowMapper{

	@Override
	public SongWriterImpl mapRow(ResultSet rs, int rowNum) throws SQLException {
	      SongWriterImpl songwriter = new SongWriterImpl();
	      songwriter.setId(rs.getInt("idSongwriter"));
	      songwriter.setFirstname(rs.getString("firstname"));
	      songwriter.setLastname(rs.getString("lastname"));
	      songwriter.setAge(rs.getInt("age"));
	      return songwriter;
	   }
	

}
