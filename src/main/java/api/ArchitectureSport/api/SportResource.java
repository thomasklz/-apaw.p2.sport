package api.ArchitectureSport.api;

import api.ArchitectureSport.controllers.SportController;
import api.ArchitectureSport.controllers.UserController;
import api.ArchitectureSport.exceptions.InvalidNameSportNull;
import api.ArchitectureSport.exceptions.InvalidUserFieldException;
import api.ArchitectureSport.exceptions.NotFoundUserIdException;
import api.ArchitectureSport.exceptions.SportExistent;
import api.ArchitectureSport.wrappers.UserListWrapper;

public class SportResource {

	// GET **/user
	public UserListWrapper themeList() {
		return new UserController().userList();
	}

	// POST **/user body="userName"
	public void createSport(String sport) throws InvalidNameSportNull, SportExistent {
		if (sport == null || sport.isEmpty()) {
			throw new InvalidNameSportNull(sport);
		}
		if(! new SportController().){
			
		}

	}

	private void validateField(String field) throws InvalidUserFieldException {
		if (field == null || field.isEmpty()) {
			throw new InvalidUserFieldException(field);
		}
	}

	// GET **themes/{id}/overage
	public OverageWrapper themeOverage(int themeId) throws NotFoundUserIdException {
		OverageWrapper overageWrapper = new ThemeController().themeOverage(themeId);
		if (overageWrapper == null) {
			throw new NotFoundUserIdException("" + themeId);
		} else {
			return overageWrapper;
		}
	}
}
