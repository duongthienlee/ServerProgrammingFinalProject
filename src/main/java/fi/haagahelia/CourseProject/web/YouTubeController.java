package fi.haagahelia.CourseProject.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.CourseProject.domain.Artist;
import fi.haagahelia.CourseProject.domain.ArtistRepository;
import fi.haagahelia.CourseProject.domain.YouTubeVideo;
import fi.haagahelia.CourseProject.domain.YoutubeSearchCriteria;
import fi.haagahelia.CourseProject.service.YouTubeService;

@Controller
public class YouTubeController {

	@Autowired
	private YouTubeService youtubeService;

	@Autowired
	private ArtistRepository aRepository;

	// starting page for YouTube api demo
	@RequestMapping(value = "/youtube", method = RequestMethod.GET)
	public String youtubeDemo(Model model) {
		// instantiate an empty address object
		YoutubeSearchCriteria youtubeSearchCriteria = new YoutubeSearchCriteria();

		// put the object in the model
		model.addAttribute("youtubeSearchCriteria", youtubeSearchCriteria);

		// get out
		return "youtube";
	}

	@RequestMapping(value = "/youtube", method = RequestMethod.POST)
	public String formSubmit(@Valid YoutubeSearchCriteria youtubeSearchCriteria, BindingResult bindingResult,
			Model model) {
		// check for errors
		if (bindingResult.hasErrors()) {
			return "youtube";
		}

		// get the list of YouTube videos that match the search term
		List<YouTubeVideo> videos = youtubeService.fetchVideosByQuery(youtubeSearchCriteria.getQueryTerm());

		if (videos != null && videos.size() > 0) {
			model.addAttribute("numberOfVideos", videos.size());
		} else {
			model.addAttribute("numberOfVideos", 0);
		}

		// put it in the model
		model.addAttribute("videos", videos);

		// add the criteria to the model as well
		model.addAttribute("youtubeSearchCriteria", youtubeSearchCriteria);

		// get out
		return "youtubeResults";
	}

	// redirect to index if user hits the root
	@RequestMapping("/")
	public String home(Model model) {
		return "redirect:index";
	}

	// redirect to specific section on navbar
	@RequestMapping("/home")
	public String homeSection(Model model) {
		return "redirect:index#home";
	}

	@RequestMapping("/service")
	public String serviceSection(Model model) {
		return "redirect:index#service";
	}

	@RequestMapping("/lessons")
	public String lessonsSection(Model model) {
		return "redirect:index#lessons";
	}

	@RequestMapping("/portfolio")
	public String portfolioSection(Model model) {
		return "redirect:index#portfolio";
	}

	@RequestMapping("/blog")
	public String blogSection(Model model) {
		return "redirect:index#blog";
	}

	@RequestMapping("/contact")
	public String contactSection(Model model) {
		return "redirect:index#contact";
	}

	// Display index
	@RequestMapping(value = "/index")
	public String HomePage() {
		return "index";
	}

	// Controller for CRUD service Section

	@RequestMapping(value = "/artist")
	public String artistList(Model model) {
		model.addAttribute("artists", aRepository.findAll());
		return "artist";
	}

	// Add artist
	@RequestMapping(value = "/addArtist")
	public String addArtist(Model model) {
		model.addAttribute("artist", new Artist());
		return "addArtist";
	}

	// add book then save book.
	@RequestMapping("/save")
	public String saveArtist(Artist artist) {
		aRepository.save(artist);
		return "redirect:artist";
	}

	// Delete book
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteArtist(@PathVariable("id") Long artistId, Model model) {
		aRepository.deleteById(artistId);
		return "redirect:../artist";

	}

	// Edit book
	@RequestMapping(value = "/edit{id}")
	public String findBook(@PathVariable("id") Long artistid, Model model) {
		model.addAttribute("artist", aRepository.findById(artistid));
		return "editArtist";

	}

}