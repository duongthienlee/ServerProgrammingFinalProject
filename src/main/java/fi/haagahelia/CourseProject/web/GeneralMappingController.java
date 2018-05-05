package fi.haagahelia.CourseProject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralMappingController {

	// ------------------------ Request Mapping -----------------------------------
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

}