package org.scribe.extractors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.scribe.exceptions.OAuthException;
import org.scribe.model.Token;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

public class TokenExtractorImpl implements RequestTokenExtractor, AccessTokenExtractor {
    private static final Pattern SECRET_REGEX = Pattern.compile("oauth_token_secret=([^&]+)");
    private static final Pattern TOKEN_REGEX = Pattern.compile("oauth_token=([^&]+)");

    public Token extract(String response) {
        Preconditions.checkEmptyString(response, "Response body is incorrect. Can't extract a token from an empty string");
        return new Token(extract(response, TOKEN_REGEX), extract(response, SECRET_REGEX), response);
    }

    private String extract(String response, Pattern p) {
        Matcher matcher = p.matcher(response);
        if (matcher.find() && matcher.groupCount() >= 1) {
            return OAuthEncoder.decode(matcher.group(1));
        }
        throw new OAuthException("Response body is incorrect. Can't extract token and secret from this: '" + response + "'", (Exception) null);
    }
}
