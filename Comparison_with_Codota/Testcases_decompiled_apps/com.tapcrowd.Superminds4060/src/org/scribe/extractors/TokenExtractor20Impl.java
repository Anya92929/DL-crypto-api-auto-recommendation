package org.scribe.extractors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.scribe.exceptions.OAuthException;
import org.scribe.model.Token;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

public class TokenExtractor20Impl implements AccessTokenExtractor {
    private static final String EMPTY_SECRET = "";
    private static final String TOKEN_REGEX = "access_token=([^&]+)";

    public Token extract(String response) {
        Preconditions.checkEmptyString(response, "Response body is incorrect. Can't extract a token from an empty string");
        Matcher matcher = Pattern.compile(TOKEN_REGEX).matcher(response);
        if (matcher.find()) {
            return new Token(OAuthEncoder.decode(matcher.group(1)), EMPTY_SECRET, response);
        }
        throw new OAuthException("Response body is incorrect. Can't extract a token from this: '" + response + "'", (Exception) null);
    }
}
