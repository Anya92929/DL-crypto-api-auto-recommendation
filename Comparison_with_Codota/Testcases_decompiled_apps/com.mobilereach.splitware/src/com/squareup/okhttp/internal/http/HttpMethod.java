package com.squareup.okhttp.internal.http;

public final class HttpMethod {
    public static boolean invalidatesCache(String method) {
        return method.equals("POST") || method.equals("PATCH") || method.equals("PUT") || method.equals("DELETE");
    }

    public static boolean requiresRequestBody(String method) {
        return method.equals("POST") || method.equals("PUT") || method.equals("PATCH");
    }

    public static boolean permitsRequestBody(String method) {
        return requiresRequestBody(method) || method.equals("DELETE");
    }

    private HttpMethod() {
    }
}
