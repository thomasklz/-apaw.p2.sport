package api.ArchitectureSport.wrappers;

import java.util.ArrayList;
import java.util.List;

public class ListUserNickWrapper {

	private List<String> userNickList;

	public ListUserNickWrapper() {
		userNickList = new ArrayList<>();
	}

	public void addNick(String nick) {
		userNickList.add(nick);
	}

	@Override
	public String toString() {
		String result = "{\"userList\":[";
		for (String nick : userNickList) {
			result += nick + ",";
		}
		return result.substring(0, result.length() - 1) + "]}";
	}
}
