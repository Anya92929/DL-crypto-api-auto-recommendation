package okhttp3;

import java.io.UnsupportedEncodingException;
import okio.ByteString;
import org.apache.commons.lang3.CharEncoding;

public final class Credentials {
    private Credentials() {
    }

    public static String basic(String str, String str2) {
        try {
            return "Basic " + ByteString.m6892of((str + ":" + str2).getBytes(CharEncoding.ISO_8859_1)).base64();
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError();
        }
    }
}
