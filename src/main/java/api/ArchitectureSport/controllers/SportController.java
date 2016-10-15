package api.ArchitectureSport.controllers;

import api.ArchitectureSport.daos.DaoFactory;
import api.ArchitectureSport.entities.Sport;

public class SportController {

	public boolean existentSport(String sportName) {
		Sport sport = DaoFactory.getFactory().getSportDao().findSportName(sportName);
		return sport != null;
	}

	public boolean createSport(String sportName) {
		boolean existentSport = this.existentSport(sportName);
		if (!existentSport) {
			DaoFactory.getFactory().getSportDao().create(new Sport(sportName));
			return true;
		} else {
			return false;
		}
	}
}
