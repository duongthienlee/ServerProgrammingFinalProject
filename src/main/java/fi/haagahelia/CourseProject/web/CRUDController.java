package fi.haagahelia.CourseProject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fi.haagahelia.CourseProject.model.Artist;
import fi.haagahelia.CourseProject.model.Tab;
import fi.haagahelia.CourseProject.repository.ArtistRepository;
import fi.haagahelia.CourseProject.repository.TabRepository;

@Controller
public class CRUDController {

	@Autowired
	private ArtistRepository aRepository;

	@Autowired
	private TabRepository tRepository;

	// ------------------------ CRUD Operations -----------------------------------

	// ----------- Tab ----------------
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

	// ----------- Artist ----------------
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