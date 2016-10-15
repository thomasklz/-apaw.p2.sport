package api.ArchitectureSport.entities;

public class User {

	private int id;
	private String user;
	private String nick;

	public User() {

	}

	public User(int id, String user, String nick) {
		this.id = id;
		this.user = user;
		this.nick = nick;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

}
