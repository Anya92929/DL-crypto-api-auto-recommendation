package org.scribe.builder;

import java.io.OutputStream;
import org.scribe.builder.api.Api;
import org.scribe.exceptions.OAuthException;
import org.scribe.model.OAuthConfig;
import org.scribe.model.OAuthConstants;
import org.scribe.model.SignatureType;
import org.scribe.oauth.OAuthService;
import org.scribe.utils.Preconditions;

public class ServiceBuilder {
    private Api api;
    private String apiKey;
    private String apiSecret;
    private String callback = OAuthConstants.OUT_OF_BAND;
    private OutputStream debugStream = null;
    private String scope;
    private SignatureType signatureType = SignatureType.Header;

    public ServiceBuilder provider(Class<? extends Api> apiClass) {
        this.api = createApi(apiClass);
        return this;
    }

    private Api createApi(Class<? extends Api> apiClass) {
        Preconditions.checkNotNull(apiClass, "Api class cannot be null");
        try {
            return (Api) apiClass.newInstance();
        } catch (Exception e) {
            throw new OAuthException("Error while creating the Api object", e);
        }
    }

    public ServiceBuilder provider(Api api2) {
        Preconditions.checkNotNull(api2, "Api cannot be null");
        this.api = api2;
        return this;
    }

    public ServiceBuilder callback(String callback2) {
        Preconditions.checkValidOAuthCallback(callback2, "Callback must be a valid URL or 'oob'");
        this.callback = callback2;
        return this;
    }

    public ServiceBuilder apiKey(String apiKey2) {
        Preconditions.checkEmptyString(apiKey2, "Invalid Api key");
        this.apiKey = apiKey2;
        return this;
    }

    public ServiceBuilder apiSecret(String apiSecret2) {
        Preconditions.checkEmptyString(apiSecret2, "Invalid Api secret");
        this.apiSecret = apiSecret2;
        return this;
    }

    public ServiceBuilder scope(String scope2) {
        Preconditions.checkEmptyString(scope2, "Invalid OAuth scope");
        this.scope = scope2;
        return this;
    }

    public ServiceBuilder signatureType(SignatureType type) {
        Preconditions.checkNotNull(type, "Signature type can't be null");
        this.signatureType = type;
        return this;
    }

    public ServiceBuilder debugStream(OutputStream stream) {
        Preconditions.checkNotNull(stream, "debug stream can't be null");
        this.debugStream = stream;
        return this;
    }

    public ServiceBuilder debug() {
        debugStream(System.out);
        return this;
    }

    public OAuthService build() {
        Preconditions.checkNotNull(this.api, "You must specify a valid api through the provider() method");
        Preconditions.checkEmptyString(this.apiKey, "You must provide an api key");
        Preconditions.checkEmptyString(this.apiSecret, "You must provide an api secret");
        return this.api.createService(new OAuthConfig(this.apiKey, this.apiSecret, this.callback, this.signatureType, this.scope, this.debugStream));
    }
}
