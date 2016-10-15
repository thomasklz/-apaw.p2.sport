package api.ArchitectureSport.exceptions;

public class InvalidNameEmailNull extends Exception {

	private static final long serialVersionUID = -8296627542707482823L;

	public static final String DESCRIPTION = "El E-mail no puede ser nulo";

	public InvalidNameEmailNull(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public InvalidNameEmailNull() {
		this("");
	}

}
