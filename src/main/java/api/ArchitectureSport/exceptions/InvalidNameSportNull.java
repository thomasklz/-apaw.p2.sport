package api.ArchitectureSport.exceptions;

public class InvalidNameSportNull extends Exception {

	private static final long serialVersionUID = -6008434625216569998L;
	public static final String DESCRIPTION = "El deporte no puedo ser nulo";

	public InvalidNameSportNull(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public InvalidNameSportNull() {
		this("");
	}

}
