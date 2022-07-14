package ch.zli.m223.ksh19s.mw.CRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.zli.m223.ksh19s.mw.CRM.controller.dto.UserDto;
import ch.zli.m223.ksh19s.mw.CRM.model.AppUser;
import ch.zli.m223.ksh19s.mw.CRM.service.UserService;

@Controller
public class UserWebController {

	@Autowired
	private UserService userService;

	@GetMapping("/web/users")
	String getUserList(Model model) {
		List<AppUser> userList = userService.getAllUsers();
		model.addAttribute("users", userList);
		return "userList";
	}
	
	@GetMapping("/admin")
	String gotoAdminPage() {
		return "admin_page";
	}

	@GetMapping("/user")
	String gotoUserPage() {
		return "user_page";
	}

	@GetMapping("/logedin")
	String gotoLogedInPage() {
		return "loged_in_page";
	}
	
	@GetMapping("/web/deleteUser/{id}")
	String deleteUser(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
		return "redirect:/web/users";
	}
	
	@RequestMapping("/web/saveUser")
	public String saveNewUser(Model model, 
		@RequestParam("username") String name,
		@RequestParam("password") String password
		//@RequestParam(value="rolenames", defaultValue="") String[] roles
		)
	{
		// create a new user
		AppUser user = userService.insertUser(name, password);
		if (user == null) {
			// Show the form again
			model.addAttribute("error", "userName already exists");
			model.addAttribute("username", name);
			model.addAttribute("password", password);
			return "showUserNewForm";
		}
		return "redirect:/web/showUsers";
	}
	
	@RequestMapping("/web/addNewUser")
	public String addNewUser(Model model) {
		return "showUserNewForm";
	}
	
	@RequestMapping("/web/showUsers")
		public String showUsers(Model model){
		model.addAttribute("users", userService.getAllUsers());
		return "userList";
	}

}
