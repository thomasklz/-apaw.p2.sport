package api.ArchitectureSport.exceptions;

public class SportExistent extends Exception {

	private static final long serialVersionUID = -4510544438844378386L;
	public static final String DESCRIPTION = "El deporte ya existe";

	public SportExistent(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public SportExistent() {
		this("");
	}
}
