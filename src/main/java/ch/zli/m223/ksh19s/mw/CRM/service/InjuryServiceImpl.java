package ch.zli.m223.ksh19s.mw.CRM.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.ksh19s.mw.CRM.exception.EntityNotFoundException;
import ch.zli.m223.ksh19s.mw.CRM.exception.InvalidArgumentException;
import ch.zli.m223.ksh19s.mw.CRM.model.AppUser;
import ch.zli.m223.ksh19s.mw.CRM.model.Injury;
import ch.zli.m223.ksh19s.mw.CRM.repository.InjuryRepository;

/**
 * Implementation of the InjuryService
 * @author Yannis Lee
 *
 */
@Service
public class InjuryServiceImpl implements InjuryService{
	
	@Autowired
	private InjuryRepository injuryRepository;
	private AppUser user;

	/**
	 * Gets all the injuries
	 * @return List<Injury>
	 */
	@Override
	public List<Injury> getAllInjuries() {
		return new ArrayList<>(injuryRepository.findAll());
	}

	/**
	 * Gets an injury
	 * @param id
	 * @return Injury
	 */
	@Override
	public Injury getInjury(Long id) {
		return injuryRepository.findById(id).orElseThrow(() -> {
			throw new EntityNotFoundException("Invalid injury Id " + id);
		});
	}

	/**
	 * Inserts an injury
	 * @param injury
	 * @return Injury
	 */
	@Override
	public Injury insertInjury(String injury) {
		if (injury == null)
			throw new InvalidArgumentException("Name must not be null");
		
		return injuryRepository.insert(injury, user);
	}

	/**
	 * Deletes an injury by its id
	 * @param id
	 */
	@Override
	public void deleteInjuryById(Long id) {
		if (id == null)
			throw new InvalidArgumentException("Id must not be null");
		if (injuryRepository.findById(id).isEmpty()) {
			return;
		}
		injuryRepository.deleteById(id);
	}
}
