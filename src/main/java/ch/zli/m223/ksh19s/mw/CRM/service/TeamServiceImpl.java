package ch.zli.m223.ksh19s.mw.CRM.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.ksh19s.mw.CRM.exception.InvalidArgumentException;
import ch.zli.m223.ksh19s.mw.CRM.exception.EntityAlreadyExistsException;
import ch.zli.m223.ksh19s.mw.CRM.exception.EntityNotFoundException;
import ch.zli.m223.ksh19s.mw.CRM.model.AppUser;
import ch.zli.m223.ksh19s.mw.CRM.model.Team;
import ch.zli.m223.ksh19s.mw.CRM.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepository;
	private AppUser user;

	@Override
	public List<Team> getAllTeams() {
		return new ArrayList<>(teamRepository.findAll());
	}

	@Override
	public Team getTeam(Long id) {
		return teamRepository.findById(id).orElseThrow(() -> {
			throw new EntityNotFoundException("Invalid team Id " + id);
		});
	}

	@Override
	public Team insertTeam(String team) {
		if (team == null)
			throw new InvalidArgumentException("Name must not be null");
		if (teamRepository.findTeamByTeam(team).isPresent()) {
			throw new EntityAlreadyExistsException("Team with name" + team + " already exists");
		}
		return teamRepository.insert(team, user);
	}

	@Override
	public void deleteTeamById(Long id) {
		if (id == null)
			throw new InvalidArgumentException("Id must not be null");
		if (teamRepository.findById(id).isEmpty()) {
			return;
		}
		teamRepository.deleteById(id);
	}

}