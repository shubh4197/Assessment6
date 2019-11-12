package com.example.Music.Repo;

import java.util.List;

import com.example.Music.Model.Track;



public interface TrackDAL {
	
	 List<Track> findAll();
     
     Track save(Track emp);
     
     List<Track> find(String id);

	void remove(Track emp);

	List<Track> findbyName(String name);

}
