package com.example.Music.Model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Album {
  @Id
  String id;
  String albumName;
  
  @DBRef
  List<Track> tracks;
  
  @DBRef
  List<Artists> artists;
public Album() {
	super();
}
public Album(String id, String albumName, List<Track> tracks, List<Artists> artists) {
	super();
	this.id = id;
	this.albumName = albumName;
	this.tracks = tracks;
	this.artists = artists;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getAlbumName() {
	return albumName;
}
public void setAlbumName(String albumName) {
	this.albumName = albumName;
}
public List<Track> getTracks() {
	return tracks;
}
public void setTracks(List<Track> tracks) {
	this.tracks = tracks;
}
public List<Artists> getArtists() {
	return artists;
}
public void setArtists(List<Artists> artists) {
	this.artists = artists;
}
  
  
  
}
