package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class zzaeo {
    public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");

    /* renamed from: a */
    static HashMap f5550a;
    public static final Uri aLH = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern aLI = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern aLJ = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* renamed from: b */
    static HashSet f5551b = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static Object f5552c;

    /* renamed from: a */
    private static void m6629a(ContentResolver contentResolver) {
        if (f5550a == null) {
            f5550a = new HashMap();
            f5552c = new Object();
            new C1408a("Gservices", contentResolver).start();
        }
    }

    public static long getLong(ContentResolver contentResolver, String str, long j) {
        String string = getString(contentResolver, str);
        if (string == null) {
            return j;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException e) {
            return j;
        }
    }

    public static String getString(ContentResolver contentResolver, String str) {
        return zza(contentResolver, str, (String) null);
    }

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzaeo.class) {
            m6629a(contentResolver);
            Object obj = f5552c;
            if (f5550a.containsKey(str)) {
                String str3 = (String) f5550a.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            } else {
                Iterator it = f5551b.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (str.startsWith((String) it.next())) {
                            break;
                        }
                    } else {
                        Cursor query = contentResolver.query(CONTENT_URI, (String[]) null, (String) null, new String[]{str}, (String) null);
                        if (query != null) {
                            try {
                                if (query.moveToFirst()) {
                                    String string = query.getString(1);
                                    synchronized (zzaeo.class) {
                                        if (obj == f5552c) {
                                            f5550a.put(str, string);
                                        }
                                    }
                                    if (string != null) {
                                        str2 = string;
                                    }
                                    if (query != null) {
                                        query.close();
                                    }
                                }
                            } catch (Throwable th) {
                                if (query != null) {
                                    query.close();
                                }
                                throw th;
                            }
                        }
                        f5550a.put(str, (Object) null);
                        if (query != null) {
                            query.close();
                        }
                    }
                }
            }
        }
        return str2;
    }

    public static Map zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(aLH, (String[]) null, (String) null, strArr, (String) null);
        TreeMap treeMap = new TreeMap();
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    treeMap.put(query.getString(0), query.getString(1));
                } finally {
                    query.close();
                }
            }
        }
        return treeMap;
    }

    public static void zzb(ContentResolver contentResolver, String... strArr) {
        Map zza = zza(contentResolver, strArr);
        synchronized (zzaeo.class) {
            m6629a(contentResolver);
            f5551b.addAll(Arrays.asList(strArr));
            for (Map.Entry entry : zza.entrySet()) {
                f5550a.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }
}
