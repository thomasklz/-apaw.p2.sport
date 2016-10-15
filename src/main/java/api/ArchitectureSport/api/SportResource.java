package api.ArchitectureSport.api;

import api.ArchitectureSport.controllers.SportController;
import api.ArchitectureSport.exceptions.InvalidNameSportNull;
import api.ArchitectureSport.exceptions.SportExistent;

public class SportResource {

	// POST **/sport body="Name"
	public void createSport(String sport) throws InvalidNameSportNull, SportExistent {
		if (sport == null || sport.isEmpty()) {
			throw new InvalidNameSportNull(sport);
		}
		if (!new SportController().createSport(sport)) {
			throw new SportExistent(sport);
		}

	}
}
