package fi.haagahelia.CourseProject.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.CourseProject.domain.YouTubeVideo;
import fi.haagahelia.CourseProject.domain.YoutubeSearchCriteria;
import fi.haagahelia.CourseProject.service.YouTubeService;

@Controller
public class YouTubeController {

	@Autowired
	private YouTubeService youtubeService;
	
	// Display index
		@RequestMapping(value = "/index")
		public String HomePage() {
			return "index";
		}
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
		return "youtube";
	}

	// redirect to demo if user hits the root
	@RequestMapping("/")
	public String home(Model model) {
		return "redirect:index";
	}
}