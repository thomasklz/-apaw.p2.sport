package api.ArchitectureSport.daos;

public abstract class DaoFactory {

	public static DaoFactory factory = null;

	public static void setFactory(DaoFactory factory) {
		DaoFactory.factory = factory;
	}

	public static DaoFactory getFactory() {
		assert factory != null;
		return factory;
	}

	public abstract UserDao getUserDao();

	public abstract SportDao getSportDao();

}
