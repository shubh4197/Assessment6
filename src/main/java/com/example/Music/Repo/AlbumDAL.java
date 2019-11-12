package com.example.Music.Repo;

import java.util.List;

import com.example.Music.Model.Album;


public interface AlbumDAL {

	List<Album> findAll();

	List<Album> find(String id);

	List<Album> findbyName(String name);

	

	void remove(Album emp);

	Album save(Album emp);

}
