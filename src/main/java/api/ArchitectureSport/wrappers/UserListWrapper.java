package api.ArchitectureSport.wrappers;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.apiArchitectureTheme.wrappers.ThemeWrapper;

public class UserListWrapper {

	
List<ThemeWrapper> themeList;

	
	public ThemeListWrapper() {
		themeList = new ArrayList<>();
	}

	public List<ThemeWrapper> getThemeList() {
		return themeList;
	}

	public void addThemeWrapper(ThemeWrapper themeWrapper){
		themeList.add(themeWrapper);
	}
	

	@Override
	public String toString() {
		String result = "{\"themeList\":[ ";
		for (ThemeWrapper themeWrapper : themeList) {
			result += themeWrapper.toString() + ",";
		}
		return result.substring(0, result.length() - 1) + "]}";
	}
}
