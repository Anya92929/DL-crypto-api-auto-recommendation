package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.p018c.C0615ad;
import com.google.android.gms.p018c.C0616ae;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.gms.tagmanager.bl */
class C1306bl implements C1316g {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f5381a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});

    /* renamed from: b */
    private final Executor f5382b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Context f5383c;

    /* renamed from: d */
    private C1309bo f5384d;

    /* renamed from: e */
    private C0615ad f5385e;

    /* renamed from: f */
    private int f5386f;

    public C1306bl(Context context) {
        this(context, C0616ae.m3557c(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    C1306bl(Context context, C0615ad adVar, String str, int i, Executor executor) {
        this.f5383c = context;
        this.f5385e = adVar;
        this.f5386f = i;
        this.f5382b = executor;
        this.f5384d = new C1309bo(this, this.f5383c, str);
    }

    /* renamed from: a */
    private SQLiteDatabase m5384a(String str) {
        try {
            return this.f5384d.getWritableDatabase();
        } catch (SQLiteException e) {
            C1333x.m5442b(str);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0029 A[SYNTHETIC, Splitter:B:20:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0038 A[SYNTHETIC, Splitter:B:27:0x0038] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object m5385a(byte[] r6) {
        /*
            r5 = this;
            r0 = 0
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            r2.<init>(r6)
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x0018, ClassNotFoundException -> 0x0025, all -> 0x0032 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0018, ClassNotFoundException -> 0x0025, all -> 0x0032 }
            java.lang.Object r0 = r1.readObject()     // Catch:{ IOException -> 0x0045, ClassNotFoundException -> 0x0043, all -> 0x0041 }
            if (r1 == 0) goto L_0x0014
            r1.close()     // Catch:{ IOException -> 0x0047 }
        L_0x0014:
            r2.close()     // Catch:{ IOException -> 0x0047 }
        L_0x0017:
            return r0
        L_0x0018:
            r1 = move-exception
            r1 = r0
        L_0x001a:
            if (r1 == 0) goto L_0x001f
            r1.close()     // Catch:{ IOException -> 0x0023 }
        L_0x001f:
            r2.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0017
        L_0x0023:
            r1 = move-exception
            goto L_0x0017
        L_0x0025:
            r1 = move-exception
            r1 = r0
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            r1.close()     // Catch:{ IOException -> 0x0030 }
        L_0x002c:
            r2.close()     // Catch:{ IOException -> 0x0030 }
            goto L_0x0017
        L_0x0030:
            r1 = move-exception
            goto L_0x0017
        L_0x0032:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0036:
            if (r1 == 0) goto L_0x003b
            r1.close()     // Catch:{ IOException -> 0x003f }
        L_0x003b:
            r2.close()     // Catch:{ IOException -> 0x003f }
        L_0x003e:
            throw r0
        L_0x003f:
            r1 = move-exception
            goto L_0x003e
        L_0x0041:
            r0 = move-exception
            goto L_0x0036
        L_0x0043:
            r3 = move-exception
            goto L_0x0027
        L_0x0045:
            r3 = move-exception
            goto L_0x001a
        L_0x0047:
            r1 = move-exception
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C1306bl.m5385a(byte[]):java.lang.Object");
    }

    /* renamed from: a */
    private List<C1314e> m5388a(List<C1310bp> list) {
        ArrayList arrayList = new ArrayList();
        for (C1310bp next : list) {
            arrayList.add(new C1314e(next.f5393a, m5385a(next.f5394b)));
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m5389a(int i) {
        int d = (m5401d() - this.f5386f) + i;
        if (d > 0) {
            List<String> b = m5396b(d);
            C1333x.m5443c("DataLayer store full, deleting " + b.size() + " entries to make room.");
            m5392a((String[]) b.toArray(new String[0]));
        }
    }

    /* renamed from: a */
    private void m5390a(long j) {
        SQLiteDatabase a = m5384a("Error opening database for deleteOlderThan.");
        if (a != null) {
            try {
                C1333x.m5444d("Deleted " + a.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
            } catch (SQLiteException e) {
                C1333x.m5442b("Error deleting old entries.");
            }
        }
    }

    /* renamed from: a */
    private void m5392a(String[] strArr) {
        SQLiteDatabase a;
        if (strArr != null && strArr.length != 0 && (a = m5384a("Error opening database for deleteEntries.")) != null) {
            try {
                a.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
            } catch (SQLiteException e) {
                C1333x.m5442b("Error deleting entries " + Arrays.toString(strArr));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002e A[SYNTHETIC, Splitter:B:20:0x002e] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m5393a(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>()
            java.io.ObjectOutputStream r1 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x001b, all -> 0x0028 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x001b, all -> 0x0028 }
            r1.writeObject(r6)     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            byte[] r0 = r2.toByteArray()     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            if (r1 == 0) goto L_0x0017
            r1.close()     // Catch:{ IOException -> 0x003b }
        L_0x0017:
            r2.close()     // Catch:{ IOException -> 0x003b }
        L_0x001a:
            return r0
        L_0x001b:
            r1 = move-exception
            r1 = r0
        L_0x001d:
            if (r1 == 0) goto L_0x0022
            r1.close()     // Catch:{ IOException -> 0x0026 }
        L_0x0022:
            r2.close()     // Catch:{ IOException -> 0x0026 }
            goto L_0x001a
        L_0x0026:
            r1 = move-exception
            goto L_0x001a
        L_0x0028:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x002c:
            if (r1 == 0) goto L_0x0031
            r1.close()     // Catch:{ IOException -> 0x0035 }
        L_0x0031:
            r2.close()     // Catch:{ IOException -> 0x0035 }
        L_0x0034:
            throw r0
        L_0x0035:
            r1 = move-exception
            goto L_0x0034
        L_0x0037:
            r0 = move-exception
            goto L_0x002c
        L_0x0039:
            r3 = move-exception
            goto L_0x001d
        L_0x003b:
            r1 = move-exception
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C1306bl.m5393a(java.lang.Object):byte[]");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public List<C1314e> m5395b() {
        try {
            m5390a(this.f5385e.mo6990a());
            return m5388a(m5399c());
        } finally {
            m5402e();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0082  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.lang.String> m5396b(int r14) {
        /*
            r13 = this;
            r10 = 0
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            if (r14 > 0) goto L_0x000f
            java.lang.String r0 = "Invalid maxEntries specified. Skipping."
            com.google.android.gms.tagmanager.C1333x.m5442b(r0)
            r0 = r9
        L_0x000e:
            return r0
        L_0x000f:
            java.lang.String r0 = "Error opening database for peekEntryIds."
            android.database.sqlite.SQLiteDatabase r0 = r13.m5384a((java.lang.String) r0)
            if (r0 != 0) goto L_0x0019
            r0 = r9
            goto L_0x000e
        L_0x0019:
            java.lang.String r1 = "datalayer"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
            r3 = 0
            java.lang.String r4 = "ID"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "%s ASC"
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
            r11 = 0
            java.lang.String r12 = "ID"
            r8[r11] = r12     // Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
            java.lang.String r7 = java.lang.String.format(r7, r8)     // Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
            java.lang.String r8 = java.lang.Integer.toString(r14)     // Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0088 }
            if (r0 == 0) goto L_0x0055
        L_0x0043:
            r0 = 0
            long r2 = r1.getLong(r0)     // Catch:{ SQLiteException -> 0x0088 }
            java.lang.String r0 = java.lang.String.valueOf(r2)     // Catch:{ SQLiteException -> 0x0088 }
            r9.add(r0)     // Catch:{ SQLiteException -> 0x0088 }
            boolean r0 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0088 }
            if (r0 != 0) goto L_0x0043
        L_0x0055:
            if (r1 == 0) goto L_0x005a
            r1.close()
        L_0x005a:
            r0 = r9
            goto L_0x000e
        L_0x005c:
            r0 = move-exception
            r1 = r10
        L_0x005e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0086 }
            r2.<init>()     // Catch:{ all -> 0x0086 }
            java.lang.String r3 = "Error in peekEntries fetching entryIds: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0086 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0086 }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x0086 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0086 }
            com.google.android.gms.tagmanager.C1333x.m5442b(r0)     // Catch:{ all -> 0x0086 }
            if (r1 == 0) goto L_0x005a
            r1.close()
            goto L_0x005a
        L_0x007e:
            r0 = move-exception
            r1 = r10
        L_0x0080:
            if (r1 == 0) goto L_0x0085
            r1.close()
        L_0x0085:
            throw r0
        L_0x0086:
            r0 = move-exception
            goto L_0x0080
        L_0x0088:
            r0 = move-exception
            goto L_0x005e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C1306bl.m5396b(int):java.util.List");
    }

    /* renamed from: b */
    private List<C1310bp> m5397b(List<C1314e> list) {
        ArrayList arrayList = new ArrayList();
        for (C1314e next : list) {
            arrayList.add(new C1310bp(next.f5397a, m5393a(next.f5398b)));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m5398b(List<C1310bp> list, long j) {
        try {
            long a = this.f5385e.mo6990a();
            m5390a(a);
            m5389a(list.size());
            m5400c(list, a + j);
            m5402e();
        } catch (Throwable th) {
            m5402e();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: c */
    private List<C1310bp> m5399c() {
        SQLiteDatabase a = m5384a("Error opening database for loadSerialized.");
        ArrayList arrayList = new ArrayList();
        if (a == null) {
            return arrayList;
        }
        Cursor query = a.query("datalayer", new String[]{"key", "value"}, (String) null, (String[]) null, (String) null, (String) null, "ID", (String) null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new C1310bp(query.getString(0), query.getBlob(1)));
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        query.close();
        return arrayList;
    }

    /* renamed from: c */
    private void m5400c(List<C1310bp> list, long j) {
        SQLiteDatabase a = m5384a("Error opening database for writeEntryToDatabase.");
        if (a != null) {
            for (C1310bp next : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", next.f5393a);
                contentValues.put("value", next.f5394b);
                a.insert("datalayer", (String) null, contentValues);
            }
        }
    }

    /* renamed from: d */
    private int m5401d() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase a = m5384a("Error opening database for getNumStoredEntries.");
        if (a != null) {
            try {
                Cursor rawQuery = a.rawQuery("SELECT COUNT(*) from datalayer", (String[]) null);
                if (rawQuery.moveToFirst()) {
                    i = (int) rawQuery.getLong(0);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e) {
                C1333x.m5442b("Error getting numStoredEntries");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        return i;
    }

    /* renamed from: e */
    private void m5402e() {
        try {
            this.f5384d.close();
        } catch (SQLiteException e) {
        }
    }

    /* renamed from: a */
    public void mo9152a(C1317h hVar) {
        this.f5382b.execute(new C1308bn(this, hVar));
    }

    /* renamed from: a */
    public void mo9153a(List<C1314e> list, long j) {
        this.f5382b.execute(new C1307bm(this, m5397b(list), j));
    }
}
