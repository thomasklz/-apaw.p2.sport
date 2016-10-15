package api.ArchitectureSport.exceptions;

public class InvalidSportAddUser extends Exception {

	private static final long serialVersionUID = -5840331998718726142L;
	public static final String DESCRIPTION = "Este Deporte ya había sido añadido a el usuario ";

	public InvalidSportAddUser(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public InvalidSportAddUser() {
		this("");
	}
}
