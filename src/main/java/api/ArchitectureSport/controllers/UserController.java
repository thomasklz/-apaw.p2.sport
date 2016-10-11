package api.ArchitectureSport.controllers;

import java.util.List;

import api.ArchitectureSport.daos.DaoFactory;
import api.ArchitectureSport.entities.User;
import api.ArchitectureSport.wrappers.UserListWrapper;
import api.ArchitectureSport.wrappers.UserWrapper;

public class UserController {

	public UserListWrapper userList() {
		List<User> themeList = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper themeListWrapper = new UserListWrapper();
		for (User user : userList) {
			UserListWrapper.addUserWrapper(new UserWrapper(theme.getId(), user.getName()));
		}
		return themeListWrapper;
	}

}
