package com.parse.signpost;

import com.parse.signpost.http.HttpRequest;
import com.parse.signpost.http.HttpResponse;

public interface OAuthProviderListener {
    boolean onResponseReceived(HttpRequest httpRequest, HttpResponse httpResponse) throws Exception;

    void prepareRequest(HttpRequest httpRequest) throws Exception;

    void prepareSubmission(HttpRequest httpRequest) throws Exception;
}
