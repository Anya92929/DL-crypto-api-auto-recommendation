package org.scribe.extractors;

import org.scribe.model.OAuthRequest;

public interface HeaderExtractor {
    String extract(OAuthRequest oAuthRequest);
}
