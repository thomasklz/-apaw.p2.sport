package api.ArchitectureSport.exceptions;

public class UserExistent extends Exception {

	private static final long serialVersionUID = 1334004805456628832L;

	public static final String DESCRIPTION = "Usuario existente";

	public UserExistent(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public UserExistent() {
		this("");
	}
}
