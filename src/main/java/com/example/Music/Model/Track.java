package com.example.Music.Model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Track {
    @Id
    String id;
    String trackName;
    
    @DBRef
    List<Artists> artists;
    
    @DBRef
    Album album;
	public Track() {
		super();
	}
	public Track(String id, String trackName, List<Artists> artists, Album album) {
		super();
		this.id = id;
		this.trackName = trackName;
		this.artists = artists;
		this.album = album;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTrackName() {
		return trackName;
	}
	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}
	public List<Artists> getArtists() {
		return artists;
	}
	public void setArtists(List<Artists> artists) {
		this.artists = artists;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
    
    
}
