package api.ArchitectureSport;

import api.ArchitectureSport.Http.HttpRequest;
import api.ArchitectureSport.Http.HttpResponse;
import api.ArchitectureSport.Http.HttpStatus;
import api.ArchitectureSport.api.SportResource;
import api.ArchitectureSport.api.UserResource;
import api.ArchitectureSport.exceptions.InvalidRequestException;
import api.ArchitectureSport.exceptions.InvalidUserFieldException;

public class Dispatcher {

	private UserResource userResource = new UserResource();
	private SportResource sportResource = new SportResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		// **/users
		if ("user".equals(request.getPath())) {
			response.setBody(userResource.userList().toString());
			// **/users/search?sport=*
		} else if ("user".equals(request.paths()[0]) && "search".equals(request.paths()[1])) {
			try {
				response.setBody(userResource.searchUserSport(request.getParams().get("sport")).toString());
			} catch (Exception e) {
				responseError(response, e);
			}
			// **/votes
		} else if ("votes".equals(request.getPath())) {
			response.setBody(sportResource.sportList().toString());
		} else {
			responseError(response, new InvalidRequestException(request.getPath()));
		}
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		// POST **/themes body="themeName"
		case "themes":
			// Injectar parámetros...
			try {
				themeResource.createTheme(request.getBody());
				response.setStatus(HttpStatus.CREATED);
			} catch (InvalidUserFieldException e) {
				this.responseError(response, e);
			}
			break;
		// POST votes body="themeId:vote"
		case "votes":
			String themeId = request.getBody().split(":")[0];
			String vote = request.getBody().split(":")[1];
			try {
				sportResource.createVote(Integer.valueOf(themeId), Integer.valueOf(vote));
				response.setStatus(HttpStatus.CREATED);
			} catch (Exception e) {
				responseError(response, e);
			}
			break;
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

	public void doPut(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

	public void doDelete(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

}
