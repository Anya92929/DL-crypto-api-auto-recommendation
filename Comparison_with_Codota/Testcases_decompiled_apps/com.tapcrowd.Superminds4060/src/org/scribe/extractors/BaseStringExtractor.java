package org.scribe.extractors;

import org.scribe.model.OAuthRequest;

public interface BaseStringExtractor {
    String extract(OAuthRequest oAuthRequest);
}
