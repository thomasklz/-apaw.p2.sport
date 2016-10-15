package api.ArchitectureSport;

import api.ArchitectureSport.Http.HttpRequest;
import api.ArchitectureSport.Http.HttpResponse;

public class Server {
	private Dispatcher dispatcher = new Dispatcher();

	public HttpResponse request(HttpRequest request) {
		HttpResponse response = new HttpResponse();
		switch (request.getMethod()) {
		case POST:
			dispatcher.doPost(request, response);
			break;
		case GET:
			dispatcher.doGet(request, response);
			break;
		case PUT:
			dispatcher.doPut(request, response);
			break;
		case DELETE:
			dispatcher.doDelete(request, response);
			break;
		default:
		}
		return response;
	}

}