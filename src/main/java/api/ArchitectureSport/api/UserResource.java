package api.ArchitectureSport.api;

import api.ArchitectureSport.controllers.UserController;
import api.ArchitectureSport.wrappers.UserListWrapper;

public class UserResource {

	// GET **/user
	public UserListWrapper themeList() {
		return new UserController().userList();
	}
}
