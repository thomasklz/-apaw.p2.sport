package api.ArchitectureSport.exceptions;

public class InvalidSportFound extends Exception {

	private static final long serialVersionUID = -7493676724660656323L;
	public static final String DESCRIPTION = "Deporte no encontrado";

	public InvalidSportFound(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public InvalidSportFound() {
		this("");
	}

}
