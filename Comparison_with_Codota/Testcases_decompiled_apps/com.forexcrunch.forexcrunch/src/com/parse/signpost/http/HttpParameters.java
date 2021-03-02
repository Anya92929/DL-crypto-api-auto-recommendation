package com.parse.signpost.http;

import com.parse.signpost.OAuth;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class HttpParameters implements Map<String, SortedSet<String>>, Serializable {
    private TreeMap<String, SortedSet<String>> wrappedMap = new TreeMap<>();

    public SortedSet<String> put(String key, SortedSet<String> value) {
        return this.wrappedMap.put(key, value);
    }

    public SortedSet<String> put(String key, SortedSet<String> values, boolean percentEncode) {
        if (!percentEncode) {
            return this.wrappedMap.put(key, values);
        }
        remove((Object) key);
        for (String v : values) {
            put(key, v, true);
        }
        return get((Object) key);
    }

    public String put(String key, String value) {
        return put(key, value, false);
    }

    public String put(String key, String value, boolean percentEncode) {
        SortedSet<String> values = this.wrappedMap.get(key);
        if (values == null) {
            values = new TreeSet<>();
            TreeMap<String, SortedSet<String>> treeMap = this.wrappedMap;
            if (percentEncode) {
                key = OAuth.percentEncode(key);
            }
            treeMap.put(key, values);
        }
        if (value != null) {
            if (percentEncode) {
                value = OAuth.percentEncode(value);
            }
            values.add(value);
        }
        return value;
    }

    public String putNull(String key, String nullString) {
        return put(key, nullString);
    }

    public void putAll(Map<? extends String, ? extends SortedSet<String>> m) {
        this.wrappedMap.putAll(m);
    }

    public void putAll(Map<? extends String, ? extends SortedSet<String>> m, boolean percentEncode) {
        if (percentEncode) {
            for (String key : m.keySet()) {
                put(key, (SortedSet<String>) (SortedSet) m.get(key), true);
            }
            return;
        }
        this.wrappedMap.putAll(m);
    }

    public void putAll(String[] keyValuePairs, boolean percentEncode) {
        for (int i = 0; i < keyValuePairs.length - 1; i += 2) {
            put(keyValuePairs[i], keyValuePairs[i + 1], percentEncode);
        }
    }

    public void putMap(Map<String, List<String>> m) {
        for (String key : m.keySet()) {
            SortedSet<String> vals = get((Object) key);
            if (vals == null) {
                vals = new TreeSet<>();
                put(key, vals);
            }
            vals.addAll(m.get(key));
        }
    }

    public SortedSet<String> get(Object key) {
        return this.wrappedMap.get(key);
    }

    public String getFirst(Object key) {
        return getFirst(key, false);
    }

    public String getFirst(Object key, boolean percentDecode) {
        SortedSet<String> values = this.wrappedMap.get(key);
        if (values == null || values.isEmpty()) {
            return null;
        }
        String value = values.first();
        return percentDecode ? OAuth.percentDecode(value) : value;
    }

    public String getAsQueryString(Object key) {
        StringBuilder sb = new StringBuilder();
        Object key2 = OAuth.percentEncode((String) key);
        Set<String> values = this.wrappedMap.get(key2);
        if (values == null) {
            return key2 + "=";
        }
        Iterator<String> iter = values.iterator();
        while (iter.hasNext()) {
            sb.append(key2 + "=" + iter.next());
            if (iter.hasNext()) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

    public String getAsHeaderElement(String key) {
        String value = getFirst(key);
        if (value == null) {
            return null;
        }
        return String.valueOf(key) + "=\"" + value + "\"";
    }

    public boolean containsKey(Object key) {
        return this.wrappedMap.containsKey(key);
    }

    public boolean containsValue(Object value) {
        for (Set<String> values : this.wrappedMap.values()) {
            if (values.contains(value)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        int count = 0;
        for (String key : this.wrappedMap.keySet()) {
            count += this.wrappedMap.get(key).size();
        }
        return count;
    }

    public boolean isEmpty() {
        return this.wrappedMap.isEmpty();
    }

    public void clear() {
        this.wrappedMap.clear();
    }

    public SortedSet<String> remove(Object key) {
        return this.wrappedMap.remove(key);
    }

    public Set<String> keySet() {
        return this.wrappedMap.keySet();
    }

    public Collection<SortedSet<String>> values() {
        return this.wrappedMap.values();
    }

    public Set<Map.Entry<String, SortedSet<String>>> entrySet() {
        return this.wrappedMap.entrySet();
    }
}
