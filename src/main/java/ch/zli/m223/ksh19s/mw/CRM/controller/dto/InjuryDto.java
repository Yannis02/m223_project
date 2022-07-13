package ch.zli.m223.ksh19s.mw.CRM.controller.dto;

import ch.zli.m223.ksh19s.mw.CRM.model.Role;

public class InjuryDto {
	public String nameOfInjury;

	public InjuryDto(Injury injury) {
		nameOfInjury = injury.getInjury();
	}

}
