package com.theHit.jdbctemplate.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.theHit.interfaces.impl.SongWriterImpl;
import com.theHit.jdbctemplate.dao.interfaces.SongwriterDAO;


public class SongwriterJdbcDaoSupport extends JdbcDaoSupport implements SongwriterDAO {
//	JdbcTemplate	jdbcTemplateObject;
	private JdbcTemplate  jdbcTemplateObject;
	private DataSource dataSource;
	
	@Override
	public void createSongwriter(String firstname, String lastname, Integer age) {
		String SQL = "insert into Songwriter (firstname, lastname, age) values (?, ?, ?)";
		getJdbcTemplate().update(SQL, new Object[] { firstname, lastname, age});
		System.out.println("Created Record Name = " + firstname + " Age = " + age);
		return;	
	}

	@Override
	public void deleteSongwriter(Integer id) {
		String SQL = "delete from Songwriter where id = ?";
		getJdbcTemplate().update(SQL, new Object[] {id});
		System.out.println("Deleted Record with ID = " + id );
		return;
		
	}

	@Override
	public void updateSongwriter(Integer id, Integer age) {
		String SQL = "update Songwriter set age = ? where id = ?";
		getJdbcTemplate().update(SQL,  new Object[] {age, id});
		System.out.println("Updated Record with ID = " + id );
		return;		
	}

	@Override
	public void deleteSongwriter(String firstname, String lastname) {
		String SQL = "delete from Songwriter where firstname = ? and lastname = ?";
		getJdbcTemplate().update(SQL, new Object[] {firstname, lastname});
		System.out.println("Deleted Record with firstname = " + firstname );
		return;
		
	}

	@Override
	public void updateSongwriter(String firstname, String lastname, Integer age) {
		String SQL = "update Songwriter set age = ? where firstname = ? and lastname = ?";
		getJdbcTemplate().update(SQL,  new Object[] {age, firstname, lastname});
		System.out.println("Updated Record with firstname = " + firstname );
		return;			
	}

	@Override
	public SongWriterImpl getSongwriter(Integer id) {
		String SQL = "select * from songwriter where id = ?";
		SongWriterImpl songwriter = (SongWriterImpl) getJdbcTemplate().queryForObject(SQL, 
						new Object[]{id}, new SongwriterMapper());
		return songwriter;
	}

	@Override
	public List<SongWriterImpl> listSongwriters() {
		String SQL = "select * from songwriter";
		List<SongWriterImpl> songwriterList = getJdbcTemplate().query(SQL, 
						new SongwriterMapper());
		return songwriterList;
	}

	@Override
	public void batchUpdate(final List<SongWriterImpl> songwriters) {
		
		
	}

}
