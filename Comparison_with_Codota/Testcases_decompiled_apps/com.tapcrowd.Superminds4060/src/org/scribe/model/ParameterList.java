package org.scribe.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

public class ParameterList {
    private static final String EMPTY_STRING = "";
    private static final String PAIR_SEPARATOR = "=";
    private static final String PARAM_SEPARATOR = "&";
    private static final char QUERY_STRING_SEPARATOR = '?';
    private final List<Parameter> params;

    public ParameterList() {
        this.params = new ArrayList();
    }

    ParameterList(List<Parameter> params2) {
        this.params = new ArrayList(params2);
    }

    public ParameterList(Map<String, String> map) {
        this();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.params.add(new Parameter(entry.getKey(), entry.getValue()));
        }
    }

    public void add(String key, String value) {
        this.params.add(new Parameter(key, value));
    }

    public String appendTo(String url) {
        Preconditions.checkNotNull(url, "Cannot append to null URL");
        String queryString = asFormUrlEncodedString();
        if (queryString.equals(EMPTY_STRING)) {
            return url;
        }
        return (url + (url.indexOf(63) != -1 ? PARAM_SEPARATOR : Character.valueOf(QUERY_STRING_SEPARATOR))) + queryString;
    }

    public String asOauthBaseString() {
        try {
            return URLEncoder.encode(asFormUrlEncodedString(), "UTF8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException();
        }
    }

    public String asFormUrlEncodedString() {
        if (this.params.size() == 0) {
            return EMPTY_STRING;
        }
        StringBuilder builder = new StringBuilder();
        for (Parameter p : this.params) {
            builder.append('&').append(p.asUrlEncodedPair());
        }
        return builder.toString().substring(1);
    }

    public void addAll(ParameterList other) {
        this.params.addAll(other.params);
    }

    public void addQuerystring(String queryString) {
        if (queryString != null && queryString.length() > 0) {
            for (String param : queryString.split(PARAM_SEPARATOR)) {
                String[] pair = param.split(PAIR_SEPARATOR);
                this.params.add(new Parameter(OAuthEncoder.decode(pair[0]), pair.length > 1 ? OAuthEncoder.decode(pair[1]) : EMPTY_STRING));
            }
        }
    }

    public boolean contains(Parameter param) {
        return this.params.contains(param);
    }

    public int size() {
        return this.params.size();
    }

    public ParameterList sort() {
        ParameterList sorted = new ParameterList(this.params);
        Collections.sort(sorted.params);
        return sorted;
    }
}
