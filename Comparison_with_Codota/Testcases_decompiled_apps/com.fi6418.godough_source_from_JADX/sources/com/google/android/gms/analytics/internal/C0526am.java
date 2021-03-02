package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.analytics.internal.am */
class C0526am extends SQLiteOpenHelper {

    /* renamed from: a */
    final /* synthetic */ C0525al f3744a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0526am(C0525al alVar, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f3744a = alVar;
    }

    /* renamed from: a */
    private void m3073a(SQLiteDatabase sQLiteDatabase) {
        boolean z = true;
        Set<String> b = m3075b(sQLiteDatabase, "hits2");
        for (String str : new String[]{"hit_id", "hit_string", "hit_time", "hit_url"}) {
            if (!b.remove(str)) {
                throw new SQLiteException("Database hits2 is missing required column: " + str);
            }
        }
        if (b.remove("hit_app_id")) {
            z = false;
        }
        if (!b.isEmpty()) {
            throw new SQLiteException("Database hits2 has extra columns");
        } else if (z) {
            sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m3074a(android.database.sqlite.SQLiteDatabase r11, java.lang.String r12) {
        /*
            r10 = this;
            r8 = 0
            r9 = 0
            java.lang.String r1 = "SQLITE_MASTER"
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0026, all -> 0x0036 }
            r0 = 0
            java.lang.String r3 = "name"
            r2[r0] = r3     // Catch:{ SQLiteException -> 0x0026, all -> 0x0036 }
            java.lang.String r3 = "name=?"
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0026, all -> 0x0036 }
            r0 = 0
            r4[r0] = r12     // Catch:{ SQLiteException -> 0x0026, all -> 0x0036 }
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = r11
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0026, all -> 0x0036 }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0040 }
            if (r1 == 0) goto L_0x0025
            r1.close()
        L_0x0025:
            return r0
        L_0x0026:
            r0 = move-exception
            r1 = r9
        L_0x0028:
            com.google.android.gms.analytics.internal.al r2 = r10.f3744a     // Catch:{ all -> 0x003d }
            java.lang.String r3 = "Error querying for table"
            r2.mo6875c(r3, r12, r0)     // Catch:{ all -> 0x003d }
            if (r1 == 0) goto L_0x0034
            r1.close()
        L_0x0034:
            r0 = r8
            goto L_0x0025
        L_0x0036:
            r0 = move-exception
        L_0x0037:
            if (r9 == 0) goto L_0x003c
            r9.close()
        L_0x003c:
            throw r0
        L_0x003d:
            r0 = move-exception
            r9 = r1
            goto L_0x0037
        L_0x0040:
            r0 = move-exception
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.C0526am.m3074a(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    /* renamed from: b */
    private Set<String> m3075b(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", (String[]) null);
        try {
            String[] columnNames = rawQuery.getColumnNames();
            for (String add : columnNames) {
                hashSet.add(add);
            }
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    /* renamed from: b */
    private void m3076b(SQLiteDatabase sQLiteDatabase) {
        Set<String> b = m3075b(sQLiteDatabase, "properties");
        for (String str : new String[]{"app_uid", "cid", "tid", "params", "adid", "hits_count"}) {
            if (!b.remove(str)) {
                throw new SQLiteException("Database properties is missing required column: " + str);
            }
        }
        if (!b.isEmpty()) {
            throw new SQLiteException("Database properties table has extra columns");
        }
    }

    public SQLiteDatabase getWritableDatabase() {
        if (!this.f3744a.f3743e.mo6834a(3600000)) {
            throw new SQLiteException("Database open failed");
        }
        try {
            return super.getWritableDatabase();
        } catch (SQLiteException e) {
            this.f3744a.f3743e.mo6833a();
            this.f3744a.mo6881f("Opening the database failed, dropping the table and recreating it");
            this.f3744a.mo6886o().getDatabasePath(this.f3744a.m3044G()).delete();
            try {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                this.f3744a.f3743e.mo6835b();
                return writableDatabase;
            } catch (SQLiteException e2) {
                this.f3744a.mo6880e("Failed to open freshly created database", e2);
                throw e2;
            }
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C0550bj.m3207a(sQLiteDatabase.getPath());
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (Build.VERSION.SDK_INT < 15) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", (String[]) null);
            try {
                rawQuery.moveToFirst();
            } finally {
                rawQuery.close();
            }
        }
        if (!m3074a(sQLiteDatabase, "hits2")) {
            sQLiteDatabase.execSQL(C0525al.f3739a);
        } else {
            m3073a(sQLiteDatabase);
        }
        if (!m3074a(sQLiteDatabase, "properties")) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
        } else {
            m3076b(sQLiteDatabase);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
