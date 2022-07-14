package ch.zli.m223.ksh19s.mw.CRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.zli.m223.ksh19s.mw.CRM.model.Role;
import ch.zli.m223.ksh19s.mw.CRM.service.RoleService;

@Controller
@RequestMapping("/web")
public class RoleWebController {
	@Autowired
	private RoleService roleService;

	
	@GetMapping("/roles")
	String getRoleList(Model model) {
		List<Role> roleList = roleService.getAllRoles();
		model.addAttribute("roles", roleList);
		return "roleList";
	}
	
}
