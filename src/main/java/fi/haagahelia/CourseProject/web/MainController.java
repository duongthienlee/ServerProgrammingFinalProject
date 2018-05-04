package fi.haagahelia.CourseProject.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.CourseProject.model.Artist;
import fi.haagahelia.CourseProject.model.Tab;
import fi.haagahelia.CourseProject.model.YouTubeVideo;
import fi.haagahelia.CourseProject.model.YoutubeSearchCriteria;
import fi.haagahelia.CourseProject.repository.ArtistRepository;
import fi.haagahelia.CourseProject.repository.TabRepository;
import fi.haagahelia.CourseProject.service.YouTubeService;

@Controller
public class MainController {

	@Autowired
	private YouTubeService youtubeService;

	@Autowired
	private ArtistRepository aRepository;

	@Autowired
	private TabRepository tRepository;

	// ------ Youtube API Controllers------
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

	// ------ RequestMapping ------
	// redirect to index if user hits the root
	@RequestMapping("/")
	public String home() {
		return "redirect:index";
	}

	// Display index
	@RequestMapping(value = "/index")
	public String HomePage() {
		return "index";
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

	// Login
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// -------CRUD service Section-----------
	// Display tabs
	@RequestMapping(value = "/tab")
	public String tabList(Model model) {
		model.addAttribute("tabs", tRepository.findAll());
		return "tab";
	}

	// Add tab
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "/addTab")
	public String addTab(Model model) {
		model.addAttribute("tab", new Tab());
		model.addAttribute("artists", aRepository.findAll());
		return "addTab";
	}

	// Save tab
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping("/saveTab")
	public String saveTab(Tab tab) {
		tRepository.save(tab);
		return "redirect:tab";
	}

	// Delete tab
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "/deleteTab/{id}", method = RequestMethod.GET)
	public String deleteTab(@PathVariable("id") Long tabId, Model model) {
		tRepository.deleteById(tabId);
		return "redirect:../tab";

	}

	// Edit tab
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "/editTab{id}")
	public String editTab(@PathVariable("id") Long tabId, Model model) {
		model.addAttribute("tab", tRepository.findById(tabId));
		model.addAttribute("artists", aRepository.findAll());
		return "editTab";

	}

	// Display artists
	@RequestMapping(value = "/artist")
	public String artistList(Model model) {
		model.addAttribute("artists", aRepository.findAll());
		return "artist";
	}

	// Add artist
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "/addArtist")
	public String addArtist(Model model) {
		model.addAttribute("artist", new Artist());
		return "addArtist";
	}

	// add artist then save artist.
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping("/saveArtist")
	public String saveArtist(Artist artist) {
		aRepository.save(artist);
		return "redirect:artist";
	}

	// Delete artist
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "/deleteArtist/{id}", method = RequestMethod.GET)
	public String deleteArtist(@PathVariable("id") Long artistId, Model model) {
		aRepository.deleteById(artistId);
		return "redirect:../artist";

	}

	// Edit artist
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "/editArtist{id}")
	public String editArtist(@PathVariable("id") Long artistId, Model model) {
		model.addAttribute("artist", aRepository.findById(artistId));
		return "editArtist";

	}

}