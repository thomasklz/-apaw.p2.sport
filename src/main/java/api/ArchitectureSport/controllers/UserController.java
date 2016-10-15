package api.ArchitectureSport.controllers;

import java.util.List;

import api.ArchitectureSport.daos.DaoFactory;
import api.ArchitectureSport.entities.User;
import api.ArchitectureSport.wrappers.UserListWrapper;
import api.ArchitectureSport.wrappers.UserWrapper;
import es.upm.miw.apiArchitectureTheme.wrappers.OverageWrapper;

public class UserController {

	public UserListWrapper userList() {
		List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : userList) {
			UserListWrapper.addUserWrapper(new UserWrapper(user.getId(), user.getName()));
		}
		return userListWrapper;
	}

	public void createUser(String userName) {
		DaoFactory.getFactory().getUserDao().create(new User(userName));
	}

	public OverageWrapper themeOverage(int userId) {
		if (DaoFactory.getFactory().getUserDao().read(userId) == null) {
			return null;
		}
		List<Integer> voteValues = DaoFactory.getFactory().getSportDao().findValueByThemeId(themeId);
		double total = 0;
		for (Integer value : voteValues) {
			total += value;
		}
		return new OverageWrapper(total / voteValues.size());
	}

}
