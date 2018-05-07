package fi.haagahelia.CourseProject.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.CourseProject.model.UserDto;
import fi.haagahelia.CourseProject.model.User;
import fi.haagahelia.CourseProject.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository repository;

	@RequestMapping(value = "signup")
	public String addStudent(Model model) {
		model.addAttribute("userDto", new UserDto());
		return "signup";
	}

	/**
	 * Create new user Check if user already exists & form validation
	 * 
	 * @param userDto
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "saveuser", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) { // validation errors
			if (userDto.getPassword().equals(userDto.getPasswordCheck())) { // check password match
				String pwd = userDto.getPassword();
				String email = userDto.getEmail();
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String hashPwd = bc.encode(pwd);

				User newUser = new User();
				newUser.setPassword(hashPwd);
				newUser.setEmail(email);
				newUser.setUsername(userDto.getUsername());
				newUser.setRole("ROLE_USER");
				// Check if email exists
				User emailExists = repository.findByEmail(userDto.getEmail());
				User usernameExists = repository.findByUsername(userDto.getUsername());

				if (usernameExists == null && emailExists == null) { // Check if user and email exists
					repository.save(newUser);
				} else {
					if (usernameExists != null) {
						bindingResult.rejectValue("username", "err.username", "Username already exists");
					} else if (emailExists != null) {
						bindingResult.rejectValue("email", "err.email", "Email already exists ");
					}

					return "signup";
				}
			} else {
				bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");
				return "signup";
			}
		} else {
			return "signup";
		}
		return "redirect:/login";
	}

}
