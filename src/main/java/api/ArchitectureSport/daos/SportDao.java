package api.ArchitectureSport.daos;

import api.ArchitectureSport.entities.Sport;

public interface SportDao extends GenericDao<Sport, Integer> {

	Sport findSportName(String sportname);
}
