package com.forexcrunch.forexcrunch.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpRequestUtility {
    public static String[] sendHttpRequest(String requestUrl, String method, Map<String, String> params) throws IOException {
        List<String> response = new ArrayList<>();
        StringBuffer requestParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (String key : params.keySet()) {
                requestParams.append(String.valueOf("data[Search]") + "[").append(URLEncoder.encode(key, "UTF-8")).append("]");
                requestParams.append("=").append(URLEncoder.encode(params.get(key), "UTF-8"));
                requestParams.append("&");
            }
        }
        URLConnection urlConn = new URL(requestUrl).openConnection();
        urlConn.setUseCaches(false);
        urlConn.setDoInput(true);
        if ("POST".equals(method)) {
            urlConn.setDoOutput(true);
        } else {
            urlConn.setDoOutput(false);
        }
        if ("POST".equals(method) && params != null && params.size() > 0) {
            OutputStreamWriter writer = new OutputStreamWriter(urlConn.getOutputStream());
            writer.write(requestParams.toString());
            writer.flush();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                reader.close();
                return (String[]) response.toArray(new String[0]);
            }
            response.add(line);
        }
    }
}
