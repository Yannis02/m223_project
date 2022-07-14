package ch.zli.m223.ksh19s.mw.CRM.controller.dto;

import java.util.Date;

import ch.zli.m223.ksh19s.mw.CRM.model.Injury;

/**
 * Data transfer object for "injury"
 * @author Yannis Lee
 *
 */
public class InjuryDto {
	
	public String nameOfInjury;
	
	public Date date;

	/**
	 * Constructor for InjuryDto
	 * @param injury
	 */
	public InjuryDto(Injury injury) {
		nameOfInjury = injury.getInjury();
		date = injury.getDate();
	}

}
