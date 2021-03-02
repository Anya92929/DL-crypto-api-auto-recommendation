package com.google.android.gms.fitness;

import com.google.android.gms.common.api.Scope;
import java.util.HashSet;
import java.util.List;

public final class FitnessScopes {
    public static final Scope SCOPE_ACTIVITY_READ = new Scope("https://www.googleapis.com/auth/fitness.activity.read");
    public static final Scope SCOPE_ACTIVITY_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.activity.write");
    public static final Scope SCOPE_BODY_READ = new Scope("https://www.googleapis.com/auth/fitness.body.read");
    public static final Scope SCOPE_BODY_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.body.write");
    public static final Scope SCOPE_LOCATION_READ = new Scope("https://www.googleapis.com/auth/fitness.location.read");
    public static final Scope SCOPE_LOCATION_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.location.write");

    private FitnessScopes() {
    }

    /* renamed from: bp */
    public static String m1758bp(String str) {
        return str.equals("https://www.googleapis.com/auth/fitness.activity.read") ? "https://www.googleapis.com/auth/fitness.activity.write" : str.equals("https://www.googleapis.com/auth/fitness.location.read") ? "https://www.googleapis.com/auth/fitness.location.write" : str.equals("https://www.googleapis.com/auth/fitness.body.read") ? "https://www.googleapis.com/auth/fitness.body.write" : str;
    }

    /* renamed from: d */
    public static String[] m1759d(List<String> list) {
        HashSet hashSet = new HashSet(list.size());
        for (String next : list) {
            String bp = m1758bp(next);
            if (bp.equals(next) || !list.contains(bp)) {
                hashSet.add(next);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }
}
