package org.scribe.extractors;

import org.scribe.model.Token;

public interface RequestTokenExtractor {
    Token extract(String str);
}
