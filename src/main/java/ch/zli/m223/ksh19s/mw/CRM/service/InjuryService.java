package ch.zli.m223.ksh19s.mw.CRM.service;

import java.util.List;

import ch.zli.m223.ksh19s.mw.CRM.model.Injury;
import ch.zli.m223.ksh19s.mw.CRM.model.Team;

/**
 * Interface for the InjuryService
 * @author Yannis Lee
 *
 */
public interface InjuryService {
	
	List<Injury> getAllInjuries();

	Injury getInjury(Long id);

	Injury insertInjury(String injury);

	void deleteInjuryById(Long id);
}
