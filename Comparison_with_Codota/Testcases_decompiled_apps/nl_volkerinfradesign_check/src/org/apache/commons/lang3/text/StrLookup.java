package org.apache.commons.lang3.text;

import java.util.Map;

public abstract class StrLookup<V> {

    /* renamed from: a */
    private static final StrLookup<String> f7162a = new C1968a((Map) null);

    /* renamed from: b */
    private static final StrLookup<String> f7163b;

    public abstract String lookup(String str);

    static {
        StrLookup<String> strLookup;
        try {
            strLookup = new C1968a<>(System.getProperties());
        } catch (SecurityException e) {
            strLookup = f7162a;
        }
        f7163b = strLookup;
    }

    public static StrLookup<?> noneLookup() {
        return f7162a;
    }

    public static StrLookup<String> systemPropertiesLookup() {
        return f7163b;
    }

    public static <V> StrLookup<V> mapLookup(Map<String, V> map) {
        return new C1968a(map);
    }

    protected StrLookup() {
    }

    /* renamed from: org.apache.commons.lang3.text.StrLookup$a */
    static class C1968a<V> extends StrLookup<V> {

        /* renamed from: a */
        private final Map<String, V> f7164a;

        C1968a(Map<String, V> map) {
            this.f7164a = map;
        }

        public String lookup(String str) {
            V v;
            if (this.f7164a == null || (v = this.f7164a.get(str)) == null) {
                return null;
            }
            return v.toString();
        }
    }
}
