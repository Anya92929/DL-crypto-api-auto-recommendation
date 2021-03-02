package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.measurement.internal.ai */
class C1891ai extends SQLiteOpenHelper {

    /* renamed from: a */
    final /* synthetic */ zze f7085a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1891ai(zze zze, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f7085a = zze;
    }

    /* renamed from: a */
    private void m7632a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, Map map) {
        if (!m7634a(sQLiteDatabase, str)) {
            sQLiteDatabase.execSQL(str2);
        }
        try {
            m7633a(sQLiteDatabase, str, str3, map);
        } catch (SQLiteException e) {
            this.f7085a.zzbsd().zzbsv().zzj("Failed to verify columns on table that was just created", str);
            throw e;
        }
    }

    /* renamed from: a */
    private void m7633a(SQLiteDatabase sQLiteDatabase, String str, String str2, Map map) {
        Set b = m7635b(sQLiteDatabase, str);
        for (String str3 : str2.split(",")) {
            if (!b.remove(str3)) {
                throw new SQLiteException(new StringBuilder(String.valueOf(str).length() + 35 + String.valueOf(str3).length()).append("Table ").append(str).append(" is missing required column: ").append(str3).toString());
            }
        }
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                if (!b.remove(entry.getKey())) {
                    sQLiteDatabase.execSQL((String) entry.getValue());
                }
            }
        }
        if (!b.isEmpty()) {
            throw new SQLiteException(new StringBuilder(String.valueOf(str).length() + 30).append("Table ").append(str).append(" table has extra columns").toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m7634a(android.database.sqlite.SQLiteDatabase r11, java.lang.String r12) {
        /*
            r10 = this;
            r8 = 0
            r9 = 0
            java.lang.String r1 = "SQLITE_MASTER"
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0026, all -> 0x003e }
            r0 = 0
            java.lang.String r3 = "name"
            r2[r0] = r3     // Catch:{ SQLiteException -> 0x0026, all -> 0x003e }
            java.lang.String r3 = "name=?"
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0026, all -> 0x003e }
            r0 = 0
            r4[r0] = r12     // Catch:{ SQLiteException -> 0x0026, all -> 0x003e }
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = r11
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0026, all -> 0x003e }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0048 }
            if (r1 == 0) goto L_0x0025
            r1.close()
        L_0x0025:
            return r0
        L_0x0026:
            r0 = move-exception
            r1 = r9
        L_0x0028:
            com.google.android.gms.measurement.internal.zze r2 = r10.f7085a     // Catch:{ all -> 0x0045 }
            com.google.android.gms.measurement.internal.zzp r2 = r2.zzbsd()     // Catch:{ all -> 0x0045 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbsx()     // Catch:{ all -> 0x0045 }
            java.lang.String r3 = "Error querying for table"
            r2.zze(r3, r12, r0)     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x003c
            r1.close()
        L_0x003c:
            r0 = r8
            goto L_0x0025
        L_0x003e:
            r0 = move-exception
        L_0x003f:
            if (r9 == 0) goto L_0x0044
            r9.close()
        L_0x0044:
            throw r0
        L_0x0045:
            r0 = move-exception
            r9 = r1
            goto L_0x003f
        L_0x0048:
            r0 = move-exception
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C1891ai.m7634a(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    /* renamed from: b */
    private Set m7635b(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor rawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" LIMIT 0").toString(), (String[]) null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    public SQLiteDatabase getWritableDatabase() {
        if (!this.f7085a.f7272c.mo9220a(this.f7085a.zzbsf().mo9473h())) {
            throw new SQLiteException("Database open failed");
        }
        try {
            return super.getWritableDatabase();
        } catch (SQLiteException e) {
            this.f7085a.f7272c.mo9219a();
            this.f7085a.zzbsd().zzbsv().log("Opening the database failed, dropping and recreating it");
            this.f7085a.getContext().getDatabasePath(this.f7085a.mo9551i()).delete();
            try {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                this.f7085a.f7272c.mo9221b();
                return writableDatabase;
            } catch (SQLiteException e2) {
                this.f7085a.zzbsd().zzbsv().zzj("Failed to open freshly created database", e2);
                throw e2;
            }
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (Build.VERSION.SDK_INT >= 9) {
            File file = new File(sQLiteDatabase.getPath());
            file.setReadable(false, false);
            file.setWritable(false, false);
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
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
        m7632a(sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", (Map) null);
        m7632a(sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", (Map) null);
        m7632a(sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zze.f7270a);
        m7632a(sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", (Map) null);
        m7632a(sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", (Map) null);
        m7632a(sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", (Map) null);
        m7632a(sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", (Map) null);
        m7632a(sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", (Map) null);
        m7632a(sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", (Map) null);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
