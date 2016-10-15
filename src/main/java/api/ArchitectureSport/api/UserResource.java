package api.ArchitectureSport.api;

import api.ArchitectureSport.controllers.UserController;
import api.ArchitectureSport.exceptions.InvalidUserFieldException;
import api.ArchitectureSport.wrappers.ListUserNickWrapper;
import api.ArchitectureSport.wrappers.UserListWrapper;

public class UserResource {

	// GET **/user
	public UserListWrapper userList() {
		return new UserController().userList();
	}

	// POST **/user/search?sport=*
	public ListUserNickWrapper searchUsersInSport(String sportName) throws InvalidSportFieldException {
		this.validateSport(sportName);
		new UserController().searchUsersInSport(sportName);
	}

	private void validateField(String field) throws InvalidUserFieldException {
		if (field == null || field.isEmpty()) {
			throw new InvalidUserFieldException(field);
		}
	}

}
