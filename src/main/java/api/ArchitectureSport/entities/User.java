package api.ArchitectureSport.entities;

import java.util.LinkedList;
import java.util.List;

public class User {
	private int id;
	private String nick;
	private String email;
	private List<Sport> sport;

	public User(String nick, String email) {
		this.nick = nick;
		this.email = email;
		this.sport = new LinkedList<Sport>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public void addSport(Sport sport) {
		this.sport.add(sport);
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean hasSport(String sportName) {
		for (Sport sport : sport) {
			if (sport.getDeporte().equals(sportName)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "User [nick=" + nick + ", email=" + email + ", sport=" + sport + "]";
	}

}
