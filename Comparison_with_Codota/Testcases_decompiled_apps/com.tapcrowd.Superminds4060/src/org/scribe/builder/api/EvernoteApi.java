package org.scribe.builder.api;

import org.scribe.model.Token;
import org.scribe.model.Verb;

public class EvernoteApi extends DefaultApi10a {
    private static final String AUTHORIZATION_URL = "https://www.evernote.com/OAuth.action?oauth_token=%s";

    public Verb getRequestTokenVerb() {
        return Verb.GET;
    }

    public String getRequestTokenEndpoint() {
        return "https://www.evernote.com/oauth";
    }

    public Verb getAccessTokenVerb() {
        return Verb.GET;
    }

    public String getAccessTokenEndpoint() {
        return "https://www.evernote.com/oauth";
    }

    public String getAuthorizationUrl(Token requestToken) {
        return String.format(AUTHORIZATION_URL, new Object[]{requestToken.getToken()});
    }

    public static class Sandbox extends EvernoteApi {
        private static final String SANDBOX_URL = "https://sandbox.evernote.com/oauth";

        public String getRequestTokenEndpoint() {
            return SANDBOX_URL;
        }

        public String getAccessTokenEndpoint() {
            return SANDBOX_URL;
        }

        public String getAuthorizationUrl(Token requestToken) {
            return String.format("https://sandbox.evernote.com/oauth?oauth_token=%s", new Object[]{requestToken.getToken()});
        }
    }
}
