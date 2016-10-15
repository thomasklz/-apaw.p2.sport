package api.ArchitectureSport.daos.memory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import api.ArchitectureSport.daos.UserDao;
import api.ArchitectureSport.entities.User;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao {

	public UserDaoMemory() {
		this.setMap(new HashMap<Integer, User>());
	}

	@Override
	protected Integer getId(User entity) {
		return entity.getId();
	}

	@Override
	protected void setId(User entity, Integer id) {
		entity.setId(id);

	}

	@Override
	public List<User> findUserSport(String sportName) {
		List<User> users = this.findAll();
		List<User> userSport = new LinkedList<>();
		for (User user : users) {
			if (user.hasSport(sportName)) {
				userSport.add(user);
			}
		}
		return userSport;
	}

	@Override
	public User findUserNick(String nick) {
		List<User> users = this.findAll();
		for (User user : users) {
			if (user.getNick().equals(nick)) {
				return user;
			}
		}
		return null;

	}

}
