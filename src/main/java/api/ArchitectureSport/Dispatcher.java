package api.ArchitectureSport;

import api.ArchitectureSport.Http.HttpRequest;
import api.ArchitectureSport.Http.HttpResponse;
import api.ArchitectureSport.Http.HttpStatus;
import api.ArchitectureSport.api.SportResource;
import api.ArchitectureSport.api.UserResource;
import api.ArchitectureSport.exceptions.InvalidRequestException;

public class Dispatcher {

	private UserResource userResource = new UserResource();
	private SportResource sportResource = new SportResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		// **/users
		if ("users".equals(request.getPath())) {
			response.setBody(userResource.userList().toString());
			// **/users/search?sport=*
		} else if ("users".equals(request.paths()[0]) && "search".equals(request.paths()[1])) {
			try {
				response.setBody(userResource.searchUserSport(request.getParams().get("sport")).toString());
			} catch (Exception e) {
				responseError(response, e);
			}
		} else {
			responseError(response, new InvalidRequestException(request.getPath()));
		}
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		// POST **/user body="nick:email"
		case "users":
			// Injectar parámetros...
			String nick = request.getBody().split(":")[0];
			String email = request.getBody().split(":")[1];
			try {
				userResource.crearUser(nick, email);
				response.setStatus(HttpStatus.CREATED);
			} catch (Exception e) {
				this.responseError(response, e);
			}
			break;
		// POST **/sport body="name"
		case "sports":
			try {
				sportResource.createSport(request.getBody());
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
		if ("users".equals(request.paths()[0]) && "sport".equals(request.paths()[2])) {
			// PUT **/users/{nick}/ sport body="sportName"
			try {
				userResource.addSportUser(request.paths()[1], request.getBody());
			} catch (Exception e) {
				responseError(response, e);
			}
		} else {
			responseError(response, new InvalidRequestException(request.getPath()));
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
