package com.theHit.jdbctemplate.dao.interfaces;

import java.util.List;

import org.springframework.jdbc.datasource.DataSourceUtils;

import com.theHit.domain.Song;

public interface SongDAO {
	public void setDataSource(DataSourceUtils ds);

	public void createSong(String name, String lyrics);	
	
	public void deleteSong(Integer id);
	
	public void updateSong(Integer id, String lyrics);	

	public Song getSong(Integer id);
	
	public List<Song> listSongs(); 	
	
	public int countRows(); 
}
