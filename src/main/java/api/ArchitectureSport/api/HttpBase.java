package api.ArchitectureSport.api;

import java.util.HashMap;
import java.util.Map;

public class HttpBase {

    private Map<String, String> headerParams;

    private Map<String, String> cookies;

    private String body;

    public HttpBase() {
        cookies = new HashMap<>();
        headerParams = new HashMap<>();
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

    public void addCookies(String key, String value) {
        cookies.put(key, value);
    }

    public Map<String, String> getHeaderParams() {
        return headerParams;
    }

    public void addHeaderParam(String key, String value) {
        headerParams.put(key, value);
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "   headerParams=" + headerParams + ", cookies=" + cookies + ", body=" + body;
    }

}
