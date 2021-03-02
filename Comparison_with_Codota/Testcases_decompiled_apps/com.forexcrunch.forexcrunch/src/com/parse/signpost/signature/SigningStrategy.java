package com.parse.signpost.signature;

import com.parse.signpost.http.HttpParameters;
import com.parse.signpost.http.HttpRequest;
import java.io.Serializable;

public interface SigningStrategy extends Serializable {
    String writeSignature(String str, HttpRequest httpRequest, HttpParameters httpParameters);
}
