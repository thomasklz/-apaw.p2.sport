package api.ArchitectureSport.exceptions;

public class InvalidNameNickNull extends Exception {

	private static final long serialVersionUID = -7168770708371666568L;

	public static final String DESCRIPTION = "El nick no puede ser nulo";

	public InvalidNameNickNull(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public InvalidNameNickNull() {
		this("");
	}

}
