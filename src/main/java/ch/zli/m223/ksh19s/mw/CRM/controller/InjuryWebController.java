package ch.zli.m223.ksh19s.mw.CRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.zli.m223.ksh19s.mw.CRM.model.Injury;
import ch.zli.m223.ksh19s.mw.CRM.service.InjuryService;

@Controller
@RequestMapping("/web")
public class InjuryWebController {
	@Autowired
	private InjuryService injuryService;

	
	@GetMapping("/injuries")
	String getInjuryList(Model model) {
		List<Injury> injuryList = injuryService.getAllInjuries();
		model.addAttribute("injuries", injuryList);
		return "injuryList";
	}
	
}
