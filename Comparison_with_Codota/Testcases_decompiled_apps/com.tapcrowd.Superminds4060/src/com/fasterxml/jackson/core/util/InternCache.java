package com.fasterxml.jackson.core.util;

import java.util.LinkedHashMap;
import java.util.Map;

public final class InternCache extends LinkedHashMap<String, String> {
    private static final int MAX_ENTRIES = 100;
    public static final InternCache instance = new InternCache();

    private InternCache() {
        super(100, 0.8f, true);
    }

    /* access modifiers changed from: protected */
    public boolean removeEldestEntry(Map.Entry<String, String> entry) {
        return size() > 100;
    }

    public synchronized String intern(String input) {
        String result;
        result = (String) get(input);
        if (result == null) {
            result = input.intern();
            put(result, result);
        }
        return result;
    }
}
