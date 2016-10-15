package api.ArchitectureSport.Http;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest extends HttpBase {

	private String path;

	private HttpMethod method;

	private Map<String, String> queryParams;

	public HttpRequest(String path, HttpMethod method) {
		this.path = path;
		this.method = method;
		queryParams = new HashMap<>();
	}

	public HttpRequest() {
		this("", HttpMethod.GET);
	}

	public String getPath() {
		return path;
	}

	public String pathRoot(int level) {
		String[] paths = path.split("/");
		String result = "";
		for (int i = 0; i < level; i++) {
			result += paths[i];
		}
		return result;
	}

	public String[] paths() {
		return path.split("/");
	}

	public void setPath(String path) {
		this.path = path;
	}

	public HttpMethod getMethod() {
		return method;
	}

	public void setMethod(HttpMethod method) {
		this.method = method;
	}

	public Map<String, String> getParams() {
		return queryParams;
	}

	public void addQueryParam(String key, String value) {
		queryParams.put(key, value);
	}

	public void clearQueryParams() {
		queryParams.clear();
	}

	@Override
	public String toString() {
		return method.toString() + " /" + path + this.queryParams() + "   " + super.toString();
	}

	private String queryParams() {
		String query = "";
		String separator = "?";
		for (String key : queryParams.keySet()) {
			query += separator + key + "=" + queryParams.get(key);
			separator = "&";
		}
		return query;
	}

}
