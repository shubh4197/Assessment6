package com.example.Music.Model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Artists {
  @Id
  String id;
  String artistName;
  
  @DBRef
  List<Album> albums;
  
  @DBRef
  List<Track> tracks;

public Artists() {
	super();
}

public Artists(String id, String artistName, List<Album> albums, List<Track> tracks) {
	super();
	this.id = id;
	this.artistName = artistName;
	this.albums = albums;
	this.tracks = tracks;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getArtistName() {
	return artistName;
}

public void setArtistName(String artistName) {
	this.artistName = artistName;
}

public List<Album> getAlbums() {
	return albums;
}

public void setAlbums(List<Album> albums) {
	this.albums = albums;
}

public List<Track> getTracks() {
	return tracks;
}

public void setTracks(List<Track> tracks) {
	this.tracks = tracks;
}
  
  
}
