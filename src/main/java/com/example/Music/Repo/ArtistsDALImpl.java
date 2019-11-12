package com.example.Music.Repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.Music.Model.Artists;



@Repository
public class ArtistsDALImpl implements ArtistsDAL{
	
	@Autowired
	private MongoTemplate mongo;
	
	@Override
	public List<Artists> findAll(){
		return mongo.findAll(Artists.class);
	}
	
	@Override
	public List<Artists> find(String id) {
		Query q=new Query();
		q.addCriteria(Criteria.where("id").is(id));
		return mongo.find(q, Artists.class);
	}
	
	@Override
	public List<Artists> findbyName(String name){
		Query q=new Query();
		q.addCriteria(Criteria.where("artistName").is(name));
		return mongo.find(q, Artists.class);
	}
	
	public Artists save(Artists emp) {
		return mongo.save(emp);
	}
	
	public void remove(Artists emp) {
		mongo.remove(emp);
	}

}
