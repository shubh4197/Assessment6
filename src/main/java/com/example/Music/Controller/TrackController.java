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
public class TrackController {
	@Autowired
	ArtistsDAL arRepo;
	
	@Autowired
	AlbumDAL alRepo;
	
	@Autowired
	TrackDAL trRepo;
	
	@PostMapping("/tracks")
	public void track(@RequestBody Track art)
	{
		alRepo.save(art.getAlbum());
		
		for(Artists j:art.getArtists())
		{
			arRepo.save(j);
		}
		trRepo.save(art);
	}
	
	@PutMapping("/tracks/{id}")
	public void update(@PathVariable String id,@RequestBody Track art)
	{
		art.setId(id);
        alRepo.save(art.getAlbum());
		
		for(Artists j:art.getArtists())
		{
			arRepo.save(j);
		}
		trRepo.save(art);

	}
	
	@GetMapping("/tracks")
	public List<Track> fetch(){
		return trRepo.findAll();
	}
	
	@DeleteMapping("/tracks/{id}")
	public Track delete(@PathVariable String id)
	{
		Track art=trRepo.find(id).get(0);
        alRepo.save(art.getAlbum());
		
		for(Artists j:art.getArtists())
		{
			arRepo.save(j);
		}
		trRepo.save(art);

		return art;
	}
}
