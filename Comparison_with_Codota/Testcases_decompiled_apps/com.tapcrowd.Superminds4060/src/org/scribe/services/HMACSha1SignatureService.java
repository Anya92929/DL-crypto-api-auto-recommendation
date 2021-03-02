package org.scribe.services;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.scribe.exceptions.OAuthSignatureException;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

public class HMACSha1SignatureService implements SignatureService {
    private static final String CARRIAGE_RETURN = "\r\n";
    private static final String EMPTY_STRING = "";
    private static final String HMAC_SHA1 = "HmacSHA1";
    private static final String METHOD = "HMAC-SHA1";
    private static final String UTF8 = "UTF-8";

    public String getSignature(String baseString, String apiSecret, String tokenSecret) {
        try {
            Preconditions.checkEmptyString(baseString, "Base string cant be null or empty string");
            Preconditions.checkEmptyString(apiSecret, "Api secret cant be null or empty string");
            return doSign(baseString, OAuthEncoder.encode(apiSecret) + '&' + OAuthEncoder.encode(tokenSecret));
        } catch (Exception e) {
            throw new OAuthSignatureException(baseString, e);
        }
    }

    private String doSign(String toSign, String keyString) throws Exception {
        SecretKeySpec key = new SecretKeySpec(keyString.getBytes(UTF8), HMAC_SHA1);
        Mac mac = Mac.getInstance(HMAC_SHA1); // CRYPTOGRAPHIC API CALLSITE 15
        mac.init(key); // CRYPTOGRAPHIC API CALLSITE 14
        return new String(Base64.encodeBase64(mac.doFinal(toSign.getBytes(UTF8)))).replace(CARRIAGE_RETURN, EMPTY_STRING); // CRYPTOGRAPHIC API CALLSITE 6
    }

    public String getSignatureMethod() {
        return METHOD;
    }
}
