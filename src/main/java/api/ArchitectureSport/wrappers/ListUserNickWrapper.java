package api.ArchitectureSport.wrappers;

import java.util.ArrayList;
import java.util.List;

public class ListUserNickWrapper {

	private List<String> UserNickList;

	public ListUserNickWrapper() {
		UserNickList = new ArrayList<>();
	}

	public void addNick(String nick) {
		UserNickList.add(nick);
	}

	@Override
	public String toString() {
		String result = "{\"userList\":[";
		for (String nick : UserNickList) {
			result += nick + ",";
		}
		return result.substring(0, result.length() - 1) + "]}";
	}
}
