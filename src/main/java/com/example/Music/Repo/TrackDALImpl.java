package com.example.Music.Repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.Music.Model.Track;



@Repository
public class TrackDALImpl implements TrackDAL{
	@Autowired
	private MongoTemplate mongo;
	
	@Override
	public List<Track> findAll(){
		return mongo.findAll(Track.class);
	}
	
	@Override
	public List<Track> find(String id) {
		Query q=new Query();
		q.addCriteria(Criteria.where("id").is(id));
		return mongo.find(q, Track.class);
	}
	
	@Override
	public List<Track> findbyName(String name){
		Query q=new Query();
		q.addCriteria(Criteria.where("trackName").is(name));
		return mongo.find(q, Track.class);
	}
	
	@Override
	public Track save(Track emp) {
		return mongo.save(emp);
	}
	
	@Override
	public void remove(Track emp) {
		mongo.remove(emp);
	}

}
