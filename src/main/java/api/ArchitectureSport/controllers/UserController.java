package api.ArchitectureSport.controllers;

import java.util.List;

import api.ArchitectureSport.daos.DaoFactory;
import api.ArchitectureSport.entities.Sport;
import api.ArchitectureSport.entities.User;
import api.ArchitectureSport.wrappers.ListUserNickWrapper;
import api.ArchitectureSport.wrappers.UserListWrapper;
import api.ArchitectureSport.wrappers.UserWrapper;

public class UserController {

	public UserListWrapper userList() {
		List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : userList) {
			userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
		}
		return userListWrapper;
	}

	public void createUser(String nick, String email) {
		DaoFactory.getFactory().getUserDao().create(new User(nick, email));
	}

	public ListUserNickWrapper searchUserSport(String sportName) {
		ListUserNickWrapper listUserNickWrapper = new ListUserNickWrapper();
		List<User> ListUserNick = DaoFactory.getFactory().getUserDao().findUserSport(sportName);
		for (User userNick : ListUserNick) {
			listUserNickWrapper.addNick(userNick.getNick());
		}
		return listUserNickWrapper;
	}

	public User findUserNick(String nick) {
		return DaoFactory.getFactory().getUserDao().findUserNick(nick);
	}

	public boolean addSportUser(String nick, String sportName) {
		User user = findUserNick(nick);
		if (!user.hasSport(sportName)) {
			Sport sport = DaoFactory.getFactory().getSportDao().findSportName(sportName);
			user.addSport(sport);
			return true;
		} else {
			return false;
		}
	}

}
