package fi.haagahelia.CourseProject.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.CourseProject.model.Artist;

@RestController
public class RestControllerForTesting {

	@RequestMapping(value = "/artistTest", method = RequestMethod.GET)
	public Artist getArtist() {
		Artist artist = new Artist("Thien", "Ly", "Vietnam", "https://www.youtube.com/channel/UCAbWFEsAAstYlXFQo6ngsLA",
				"1996-09-24");
		return artist;
	}
}