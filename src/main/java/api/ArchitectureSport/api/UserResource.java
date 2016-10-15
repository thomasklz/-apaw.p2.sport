package api.ArchitectureSport.api;

import api.ArchitectureSport.controllers.SportController;
import api.ArchitectureSport.controllers.UserController;
import api.ArchitectureSport.exceptions.InvalidNameEmailNull;
import api.ArchitectureSport.exceptions.InvalidNameNickNull;
import api.ArchitectureSport.exceptions.InvalidNameSportNull;
import api.ArchitectureSport.exceptions.InvalidSportAddUser;
import api.ArchitectureSport.exceptions.InvalidSportFound;
import api.ArchitectureSport.exceptions.InvalidUserFound;
import api.ArchitectureSport.exceptions.UserExistent;
import api.ArchitectureSport.wrappers.ListUserNickWrapper;
import api.ArchitectureSport.wrappers.UserListWrapper;

public class UserResource {

	// GET **/user
	public UserListWrapper userList() {
		return new UserController().userList();
	}

	// POST **/user/search?sport=*
	public ListUserNickWrapper searchUserSport(String sportName) throws InvalidNameSportNull, InvalidSportFound {
		this.validateSport(sportName);
		return new UserController().searchUserSport(sportName);
	}

	private void validateSport(String sportName) throws InvalidNameSportNull, InvalidSportFound {
		if (sportName == null || sportName.isEmpty()) {
			throw new InvalidNameSportNull(sportName);
		}
		if (!new SportController().existentSport(sportName)) {
			throw new InvalidSportFound(sportName);
		}
	}

	// POST **/users body="nick:email"
	public void crearUser(String nick, String email) throws InvalidNameNickNull, InvalidNameEmailNull, UserExistent {
		if (nick == null || nick.isEmpty()) {
			throw new InvalidNameNickNull(nick);
		}
		if (email == null || email.isEmpty()) {
			throw new InvalidNameEmailNull(email);
		}
		if (!new UserController().createUser(nick, email)) {
			throw new UserExistent(nick);
		}
	}

	// PUT **//users/{nick}/sport body="sportName"
	public void addSportUser(String nick, String sportName)
			throws InvalidNameNickNull, InvalidNameSportNull, InvalidSportFound, InvalidUserFound, InvalidSportAddUser {

		if (nick == null || nick.isEmpty()) {
			throw new InvalidNameNickNull(nick);
		}
		if (sportName == null || sportName.isEmpty()) {
			throw new InvalidNameSportNull(sportName);
		}
		if (new UserController().findUserNick(nick) == null) {
			throw new InvalidUserFound(nick);
		}
		if (!new SportController().existentSport(sportName)) {
			throw new InvalidSportFound(sportName);
		}
		if (!new UserController().addSportUser(nick, sportName)) {
			throw new InvalidSportAddUser(nick);
		}

	}

}
