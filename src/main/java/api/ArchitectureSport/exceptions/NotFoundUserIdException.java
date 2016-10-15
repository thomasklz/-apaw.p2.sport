package api.ArchitectureSport.exceptions;

public class NotFoundUserIdException extends Exception {
	private static final long serialVersionUID = -3893110892899234744L;
	
	public static final String DESCRIPTION = "El id del thema no existe";

	public NotFoundUserIdException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public NotFoundUserIdException() {
		this("");
	}
}
