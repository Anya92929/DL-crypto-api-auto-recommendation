package org.scribe.model;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OAuthRequest extends Request {
    private static final String OAUTH_PREFIX = "oauth_";
    private Map<String, String> oauthParameters = new HashMap();

    public /* bridge */ /* synthetic */ void addBodyParameter(String x0, String x1) {
        super.addBodyParameter(x0, x1);
    }

    public /* bridge */ /* synthetic */ void addHeader(String x0, String x1) {
        super.addHeader(x0, x1);
    }

    public /* bridge */ /* synthetic */ void addPayload(String x0) {
        super.addPayload(x0);
    }

    public /* bridge */ /* synthetic */ void addPayload(byte[] x0) {
        super.addPayload(x0);
    }

    public /* bridge */ /* synthetic */ void addQuerystringParameter(String x0, String x1) {
        super.addQuerystringParameter(x0, x1);
    }

    public /* bridge */ /* synthetic */ String getBodyContents() {
        return super.getBodyContents();
    }

    public /* bridge */ /* synthetic */ ParameterList getBodyParams() {
        return super.getBodyParams();
    }

    public /* bridge */ /* synthetic */ String getCharset() {
        return super.getCharset();
    }

    public /* bridge */ /* synthetic */ String getCompleteUrl() {
        return super.getCompleteUrl();
    }

    public /* bridge */ /* synthetic */ Map getHeaders() {
        return super.getHeaders();
    }

    public /* bridge */ /* synthetic */ ParameterList getQueryStringParams() {
        return super.getQueryStringParams();
    }

    public /* bridge */ /* synthetic */ String getSanitizedUrl() {
        return super.getSanitizedUrl();
    }

    public /* bridge */ /* synthetic */ String getUrl() {
        return super.getUrl();
    }

    public /* bridge */ /* synthetic */ Verb getVerb() {
        return super.getVerb();
    }

    public /* bridge */ /* synthetic */ Response send() {
        return super.send();
    }

    public /* bridge */ /* synthetic */ void setCharset(String x0) {
        super.setCharset(x0);
    }

    public /* bridge */ /* synthetic */ void setConnectTimeout(int x0, TimeUnit x1) {
        super.setConnectTimeout(x0, x1);
    }

    public /* bridge */ /* synthetic */ void setConnectionKeepAlive(boolean x0) {
        super.setConnectionKeepAlive(x0);
    }

    public /* bridge */ /* synthetic */ void setReadTimeout(int x0, TimeUnit x1) {
        super.setReadTimeout(x0, x1);
    }

    public OAuthRequest(Verb verb, String url) {
        super(verb, url);
    }

    public void addOAuthParameter(String key, String value) {
        this.oauthParameters.put(checkKey(key), value);
    }

    private String checkKey(String key) {
        if (key.startsWith("oauth_") || key.equals(OAuthConstants.SCOPE)) {
            return key;
        }
        throw new IllegalArgumentException(String.format("OAuth parameters must either be '%s' or start with '%s'", new Object[]{OAuthConstants.SCOPE, "oauth_"}));
    }

    public Map<String, String> getOauthParameters() {
        return this.oauthParameters;
    }

    public String toString() {
        return String.format("@OAuthRequest(%s, %s)", new Object[]{getVerb(), getUrl()});
    }
}
