package ch.zli.m223.ksh19s.mw.CRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.zli.m223.ksh19s.mw.CRM.model.AppUser;
import ch.zli.m223.ksh19s.mw.CRM.service.UserService;

/**
 * Class to control the entity "user" via the web
 * @author Yannis Lee
 *
 */
@Controller
public class UserWebController {

	@Autowired
	private UserService userService;

	/**
	 * Gets a list of all the users
	 * @param model
	 * @return "userList"
	 */
	@GetMapping("/web/users")
	String getUserList(Model model) {
		List<AppUser> userList = userService.getAllUsers();
		model.addAttribute("users", userList);
		return "userList";
	}
	
	/**
	 * Goes to the admin page
	 * @return "admin_page"
	 */
	@GetMapping("/admin")
	String gotoAdminPage() {
		return "admin_page";
	}

	/**
	 * Goes to the user page
	 * @return "user_page"
	 */
	@GetMapping("/user")
	String gotoUserPage() {
		return "user_page";
	}

	/**
	 * Goes to the loggedin page
	 * @return "loged_in_page"
	 */
	@GetMapping("/logedin")
	String gotoLogedInPage() {
		return "loged_in_page";
	}
	
	/**
	 * Deletes a user
	 * @param id
	 * @return "redirect:/web/users"
	 */
	@GetMapping("/web/deleteUser/{id}")
	String deleteUser(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
		return "redirect:/web/users";
	}
	
	/**
	 * Saves a new user
	 * @param model
	 * @param name
	 * @param password
	 * @param roles
	 * @param teams
	 * @param injuries
	 * @return "redirect:/web/users"
	 */
	@RequestMapping("/web/saveUser")
	public String saveNewUser(Model model, 
		@RequestParam("username") String name,
		@RequestParam("password") String password,
		@RequestParam(value="rolenames", defaultValue="") String[] roles,
		@RequestParam(value="teamnames", defaultValue="") String[] teams,
		@RequestParam(value="injurynames", defaultValue="") String[] injuries)
	{
		// create a new user
		AppUser user = userService.insertNewUser(name, password, roles, teams, injuries);
		if (user == null) {
			// Show the form again
			model.addAttribute("error", "userName already exists");
			model.addAttribute("username", name);
			model.addAttribute("password", password);
			return "showUserNewForm";
		}
		return "redirect:/web/users";
	}
	
	/**
	 * Adds a new user
	 * @param model
	 * @return "showUserNewForm"
	 */
	@RequestMapping("/web/addNewUser")
	public String addNewUser(Model model) {
		return "showUserNewForm";
	}
	
	/**
	 * Shows users
	 * @param model
	 * @return "userList"
	 */
	@RequestMapping("/web/showUsers")
		public String showUsers(Model model){
		model.addAttribute("users", userService.getAllUsers());
		return "userList";
	}

}
