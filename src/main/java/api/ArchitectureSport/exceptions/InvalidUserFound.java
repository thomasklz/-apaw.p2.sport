package api.ArchitectureSport.exceptions;

public class InvalidUserFound extends Exception {

	private static final long serialVersionUID = 3614346384869756275L;
	public static final String DESCRIPTION = "Usuario no encontrado";

	public InvalidUserFound(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public InvalidUserFound() {
		this("");
	}
}
