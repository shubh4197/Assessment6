package com.example.Music.Repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.Music.Model.Album;



@Repository
public class AlbumDALImpl implements AlbumDAL{
	@Autowired
	private MongoTemplate mongo;
	
	@Override
	public List<Album> findAll(){
		return mongo.findAll(Album.class);
	}
	
	@Override
	public List<Album> find(String id) {
		Query q=new Query();
		q.addCriteria(Criteria.where("id").is(id));
		return mongo.find(q, Album.class);
	}
	
	@Override
	public List<Album> findbyName(String name){
		Query q=new Query();
		q.addCriteria(Criteria.where("albumName").is(name));
		return mongo.find(q, Album.class);
	}
	
	@Override
	public Album save(Album emp) {
		return mongo.save(emp);
	}
	
	@Override
	public void remove(Album emp) {
		mongo.remove(emp);
	}

}
