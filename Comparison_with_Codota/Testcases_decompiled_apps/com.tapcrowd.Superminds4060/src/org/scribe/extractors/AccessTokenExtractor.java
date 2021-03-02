package org.scribe.extractors;

import org.scribe.model.Token;

public interface AccessTokenExtractor {
    Token extract(String str);
}
