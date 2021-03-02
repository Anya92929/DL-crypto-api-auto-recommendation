package com.parse.signpost;

import com.parse.gdata.PercentEscaper;
import com.parse.signpost.http.HttpParameters;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class OAuth {
    public static final String ENCODING = "UTF-8";
    public static final String FORM_ENCODED = "application/x-www-form-urlencoded";
    public static final String HTTP_AUTHORIZATION_HEADER = "Authorization";
    public static final String OAUTH_CALLBACK = "oauth_callback";
    public static final String OAUTH_CALLBACK_CONFIRMED = "oauth_callback_confirmed";
    public static final String OAUTH_CONSUMER_KEY = "oauth_consumer_key";
    public static final String OAUTH_NONCE = "oauth_nonce";
    public static final String OAUTH_SIGNATURE = "oauth_signature";
    public static final String OAUTH_SIGNATURE_METHOD = "oauth_signature_method";
    public static final String OAUTH_TIMESTAMP = "oauth_timestamp";
    public static final String OAUTH_TOKEN = "oauth_token";
    public static final String OAUTH_TOKEN_SECRET = "oauth_token_secret";
    public static final String OAUTH_VERIFIER = "oauth_verifier";
    public static final String OAUTH_VERSION = "oauth_version";
    public static final String OUT_OF_BAND = "oob";
    public static final String VERSION_1_0 = "1.0";
    private static final PercentEscaper percentEncoder = new PercentEscaper("-._~", false);

    public static String percentEncode(String s) {
        if (s == null) {
            return "";
        }
        return percentEncoder.escape(s);
    }

    public static String percentDecode(String s) {
        if (s == null) {
            return "";
        }
        try {
            return URLDecoder.decode(s, "UTF-8");
        } catch (UnsupportedEncodingException wow) {
            throw new RuntimeException(wow.getMessage(), wow);
        }
    }

    public static <T extends Map.Entry<String, String>> void formEncode(Collection<T> parameters, OutputStream into) throws IOException {
        if (parameters != null) {
            boolean first = true;
            for (Map.Entry<String, String> entry : parameters) {
                if (first) {
                    first = false;
                } else {
                    into.write(38);
                }
                into.write(percentEncode(safeToString(entry.getKey())).getBytes());
                into.write(61);
                into.write(percentEncode(safeToString(entry.getValue())).getBytes());
            }
        }
    }

    public static <T extends Map.Entry<String, String>> String formEncode(Collection<T> parameters) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        formEncode(parameters, b);
        return new String(b.toByteArray());
    }

    public static HttpParameters decodeForm(String form) {
        String name;
        String value;
        HttpParameters params = new HttpParameters();
        if (!isEmpty(form)) {
            for (String nvp : form.split("\\&")) {
                int equals = nvp.indexOf(61);
                if (equals < 0) {
                    name = percentDecode(nvp);
                    value = null;
                } else {
                    name = percentDecode(nvp.substring(0, equals));
                    value = percentDecode(nvp.substring(equals + 1));
                }
                params.put(name, value);
            }
        }
        return params;
    }

    public static HttpParameters decodeForm(InputStream content) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(content), 8192);
        StringBuilder sb = new StringBuilder();
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            sb.append(line);
        }
        return decodeForm(sb.toString());
    }

    public static <T extends Map.Entry<String, String>> Map<String, String> toMap(Collection<T> from) {
        HashMap<String, String> map = new HashMap<>();
        if (from != null) {
            for (Map.Entry<String, String> entry : from) {
                String key = entry.getKey();
                if (!map.containsKey(key)) {
                    map.put(key, entry.getValue());
                }
            }
        }
        return map;
    }

    public static final String safeToString(Object from) {
        if (from == null) {
            return null;
        }
        return from.toString();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String addQueryParameters(String url, String... kvPairs) {
        StringBuilder sb = new StringBuilder(String.valueOf(url) + (url.contains("?") ? "&" : "?"));
        for (int i = 0; i < kvPairs.length; i += 2) {
            if (i > 0) {
                sb.append("&");
            }
            sb.append(String.valueOf(percentEncode(kvPairs[i])) + "=" + percentEncode(kvPairs[i + 1]));
        }
        return sb.toString();
    }

    public static String addQueryParameters(String url, Map<String, String> params) {
        String[] kvPairs = new String[(params.size() * 2)];
        int idx = 0;
        for (String key : params.keySet()) {
            kvPairs[idx] = key;
            kvPairs[idx + 1] = params.get(key);
            idx += 2;
        }
        return addQueryParameters(url, kvPairs);
    }

    public static String prepareOAuthHeader(String... kvPairs) {
        StringBuilder sb = new StringBuilder("OAuth ");
        for (int i = 0; i < kvPairs.length; i += 2) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(String.valueOf(percentEncode(kvPairs[i])) + "=\"" + (kvPairs[i].startsWith("oauth_") ? percentEncode(kvPairs[i + 1]) : kvPairs[i + 1]) + "\"");
        }
        return sb.toString();
    }

    public static HttpParameters oauthHeaderToParamsMap(String oauthHeader) {
        HttpParameters params = new HttpParameters();
        if (oauthHeader != null && oauthHeader.startsWith("OAuth ")) {
            for (String keyValuePair : oauthHeader.substring("OAuth ".length()).split(",")) {
                String[] keyValue = keyValuePair.split("=");
                params.put(keyValue[0].trim(), keyValue[1].replace("\"", "").trim());
            }
        }
        return params;
    }

    public static String toHeaderElement(String name, String value) {
        return String.valueOf(percentEncode(name)) + "=\"" + percentEncode(value) + "\"";
    }

    public static void debugOut(String key, String value) {
        if (System.getProperty("debug") != null) {
            System.out.println("[SIGNPOST] " + key + ": " + value);
        }
    }
}
