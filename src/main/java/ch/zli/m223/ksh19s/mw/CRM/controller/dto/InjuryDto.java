package ch.zli.m223.ksh19s.mw.CRM.controller.dto;

import java.util.Date;

import ch.zli.m223.ksh19s.mw.CRM.model.Injury;

public class InjuryDto {
	public String nameOfInjury;
	
	public Date date;

	public InjuryDto(Injury injury) {
		nameOfInjury = injury.getInjury();
		date = injury.getDate();
	}

}
