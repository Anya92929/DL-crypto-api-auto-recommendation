package org.scribe.extractors;

import org.scribe.exceptions.OAuthParametersMissingException;
import org.scribe.model.OAuthRequest;
import org.scribe.model.ParameterList;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

public class BaseStringExtractorImpl implements BaseStringExtractor {
    private static final String AMPERSAND_SEPARATED_STRING = "%s&%s&%s";

    public String extract(OAuthRequest request) {
        checkPreconditions(request);
        return String.format(AMPERSAND_SEPARATED_STRING, new Object[]{OAuthEncoder.encode(request.getVerb().name()), OAuthEncoder.encode(request.getSanitizedUrl()), getSortedAndEncodedParams(request)});
    }

    private String getSortedAndEncodedParams(OAuthRequest request) {
        ParameterList params = new ParameterList();
        params.addAll(request.getQueryStringParams());
        params.addAll(request.getBodyParams());
        params.addAll(new ParameterList(request.getOauthParameters()));
        return params.sort().asOauthBaseString();
    }

    private void checkPreconditions(OAuthRequest request) {
        Preconditions.checkNotNull(request, "Cannot extract base string from null object");
        if (request.getOauthParameters() == null || request.getOauthParameters().size() <= 0) {
            throw new OAuthParametersMissingException(request);
        }
    }
}
