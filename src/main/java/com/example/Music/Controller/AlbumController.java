package com.example.Music.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Music.Model.Album;
import com.example.Music.Model.Artists;
import com.example.Music.Model.Track;
import com.example.Music.Repo.AlbumDAL;
import com.example.Music.Repo.ArtistsDAL;
import com.example.Music.Repo.TrackDAL;

@RestController
public class AlbumController {

	@Autowired
	ArtistsDAL arRepo;
	
	@Autowired
	AlbumDAL alRepo;
	
	@Autowired
	TrackDAL trRepo;
	
	@PostMapping("/album")
	public void track(@RequestBody Album art)
	{
		
		for(Track i:art.getTracks())
		{   
			trRepo.save(i);
		}
		for(Artists j:art.getArtists())
		{
			arRepo.save(j);
		}
		alRepo.save(art);
	}
	
	@PutMapping("/album/{id}")
	public void update(@PathVariable String id,@RequestBody Album art)
	{
		art.setId(id);
		for(Track i:art.getTracks())
		{   
			trRepo.save(i);
		}
		for(Artists j:art.getArtists())
		{
			arRepo.save(j);
		}
		alRepo.save(art);
	}
	
	@GetMapping("/album")
	public List<Album> fetch(){
		return alRepo.findAll();
	}
	
	@DeleteMapping("/album/{id}")
	public Album delete(@PathVariable String id)
	{
		Album art=alRepo.find(id).get(0);
		for(Track i:art.getTracks())
		{   
			trRepo.save(i);
		}
		for(Artists j:art.getArtists())
		{
			arRepo.save(j);
		}
		alRepo.save(art);
		return art;
	}
}
