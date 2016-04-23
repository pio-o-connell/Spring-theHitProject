package com.theHit.jdbctemplate.dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class SongJdbcDaoSupport extends JdbcDaoSupport {
	@Autowired
	SongJdbcDaoSupport(DataSourceUtils dataSource) {
		   setDataSource((DataSource) dataSource);
	}    
	                            
	public void createSong(String name, String lyrics) {
		String SQL = "insert into Song (songname, lyrics) values (?, ?)";
			
		Object[] params=new Object[]{ name, lyrics};
		PreparedStatementCreatorFactory psc=new PreparedStatementCreatorFactory(SQL);
		psc.addParameter(new SqlParameter("name", Types.VARCHAR));
		psc.addParameter(new SqlParameter("lyrics", Types.VARCHAR));
			
		KeyHolder holder = new GeneratedKeyHolder();
		this.getJdbcTemplate().update(psc.newPreparedStatementCreator(params), holder);		
		System.out.println("Created Record Name = " + name + " Lyrics = " + lyrics);
		return;		
	}

	public void deleteSong(Integer id) {
		String SQL = "delete from Song where id = ?";
		getJdbcTemplate().update(SQL, new Object[] {id});
		System.out.println("Deleted Record with ID = " + id );
		return;		
	}   
}
