package api.ArchitectureSport.daos.memory;

import java.util.HashMap;

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
}
