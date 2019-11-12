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
public class ArtistsController {
      
	@Autowired
	ArtistsDAL arRepo;
	
	@Autowired
	AlbumDAL alRepo;
	
	@Autowired
	TrackDAL trRepo;
	
	@PostMapping("/artists")
	public void track(@RequestBody Artists art)
	{
		
		for(Album i:art.getAlbums())
		{   
			alRepo.save(i);
		}
		for(Track j:art.getTracks())
		{
			trRepo.save(j);
		}
		arRepo.save(art);
	}
	
	@PutMapping("/artists/{id}")
	public void update(@PathVariable String id,@RequestBody Artists art)
	{
		art.setId(id);
		for(Album i:art.getAlbums())
		{   i.setId(i.getId());
			alRepo.save(i);
		}
		for(Track j:art.getTracks())
		{   j.setId(j.getId());
			trRepo.save(j);
		}
		arRepo.save(art);
	}
	
	@GetMapping("/artists")
	public List<Artists> fetch(){
		return arRepo.findAll();
	}
	
	@DeleteMapping("/artists/{id}")
	public Artists delete(@PathVariable String id)
	{
		Artists art=arRepo.find(id).get(0);
		for(Album i:art.getAlbums())
		{   
			alRepo.remove(i);
		}
		for(Track j:art.getTracks())
		{
			trRepo.remove(j);
		}
		arRepo.remove(art);
		return art;
	}
	
}
