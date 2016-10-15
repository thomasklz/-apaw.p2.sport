package api.ArchitectureSport.daos.memory;

import java.util.HashMap;
import java.util.List;

import api.ArchitectureSport.daos.SportDao;
import api.ArchitectureSport.entities.Sport;

public class SportDaoMemory extends GenericMemoryDao<Sport> implements SportDao {

	public SportDaoMemory() {
		this.setMap(new HashMap<Integer, Sport>());
	}

	@Override
	public Sport findSportName(String sportname) {
		List<Sport> allSport = this.findAll();
		for (Sport sport : allSport) {
			if (sport.getDeporte().equals(sportname)) {
				return sport;

			}
		}
		return null;

	}

	@Override
	protected Integer getId(Sport entity) {

		return null;
	}

	@Override
	protected void setId(Sport entity, Integer id) {
		// TODO Auto-generated method stub

	}

}
