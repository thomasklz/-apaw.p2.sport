package api.ArchitectureSport.daos;

import java.util.List;

import api.ArchitectureSport.entities.User;

public interface UserDao extends GenericDao<User, Integer> {

	List<User> findUserSport(String sportname);

	User findUserNick(String nick);
}
