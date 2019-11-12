package com.example.Music.Repo;

import java.util.List;

import com.example.Music.Model.Artists;

public interface ArtistsDAL {
	List<Artists> findAll();
	Artists save(Artists emp);
	void remove(Artists emp);
	List<Artists> find(String id);
	List<Artists> findbyName(String name);
	
}
