	package ch.zli.m223.ksh19s.mw.CRM.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.ksh19s.mw.CRM.controller.dto.InjuryDto;
import ch.zli.m223.ksh19s.mw.CRM.controller.dto.InjuryInputDto;
import ch.zli.m223.ksh19s.mw.CRM.service.InjuryService;

/**
 * Class to control the entity "injury"
 * @author Yannis Lee
 *
 */
@RestController
@RequestMapping("/api/v1")
public class InjuryRestController {

	@Autowired
	private InjuryService injuryService;

	/**
	 * Gets all injuries
	 * @return List<InjuryDto>
	 */
	@GetMapping("/injuries")
	List<InjuryDto> getAllInjuries() {
		return injuryService.getAllInjuries().stream().map(injury -> new InjuryDto(injury)).collect(Collectors.toList());
	}

	/**
	 * Returns an injury
	 * @param id
	 * @return InjuryDto
	 */
	@GetMapping("/injuries/{id}")
	InjuryDto getInjury(@PathVariable("id") Long id) {
		return new InjuryDto(injuryService.getInjury(id));
	}

	/**
	 * Inserts an injury
	 * @param injuryData
	 * @return InjuryDto
	 */
	@PostMapping("/injuries")
	InjuryDto insertInjury(@RequestBody InjuryInputDto injuryData) {
		return new InjuryDto(injuryService.insertInjury(injuryData.name));
	}

	/**
	 * Deletes an injury
	 * @param id
	 */
	@DeleteMapping("/injuries/{id}")
	void deleteInjury(@PathVariable("id") Long id) {
		injuryService.deleteInjuryById(id);
	}

}
