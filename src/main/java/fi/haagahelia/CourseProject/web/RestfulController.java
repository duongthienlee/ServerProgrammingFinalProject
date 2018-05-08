package fi.haagahelia.CourseProject.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.CourseProject.model.Artist;
import fi.haagahelia.CourseProject.model.Tab;

import fi.haagahelia.CourseProject.repository.ArtistRepository;
import fi.haagahelia.CourseProject.repository.TabRepository;

@RestController
public class RestfulController {

	@Autowired
	private ArtistRepository aRepository;

	@Autowired
	private TabRepository tRepository;

	// Restful service to return all tabs
	@RequestMapping(value = "/tabs")
	public List<Tab> tabListRest() {
		return (List<Tab>) tRepository.findAll();
	}

	// Restful service to find tab by id
	@RequestMapping(value = "/tab/{id}", method = RequestMethod.GET)
	public Optional<Tab> findTabRest(@PathVariable("id") Long ID) {
		return tRepository.findById(ID);
	}

	// Restful service to return all artist
	@RequestMapping(value = "/artists")
	public List<Artist> artistListRest() {
		return (List<Artist>) aRepository.findAll();
	}

	// Restful service to find artist by id
	@RequestMapping(value = "/artist/{id}", method = RequestMethod.GET)
	public Optional<Artist> findArtistRest(@PathVariable("id") Long ID) {
		return aRepository.findById(ID);
	}

}
