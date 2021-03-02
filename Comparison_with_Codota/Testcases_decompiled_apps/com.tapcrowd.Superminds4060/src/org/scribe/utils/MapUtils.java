package org.scribe.utils;

import java.util.Map;

public class MapUtils {
    public static <K, V> String toString(Map<K, V> map) {
        if (map == null) {
            return "";
        }
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            result.append(String.format(", %s -> %s ", new Object[]{entry.getKey().toString(), entry.getValue().toString()}));
        }
        return "{" + result.substring(1) + "}";
    }
}
