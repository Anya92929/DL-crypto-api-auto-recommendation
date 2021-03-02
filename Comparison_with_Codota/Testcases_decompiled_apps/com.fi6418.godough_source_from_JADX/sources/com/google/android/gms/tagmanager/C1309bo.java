package com.google.android.gms.tagmanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import java.util.HashSet;

/* renamed from: com.google.android.gms.tagmanager.bo */
class C1309bo extends SQLiteOpenHelper {

    /* renamed from: a */
    final /* synthetic */ C1306bl f5392a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1309bo(C1306bl blVar, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f5392a = blVar;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private void m5405a(SQLiteDatabase sQLiteDatabase) {
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", (String[]) null);
        HashSet hashSet = new HashSet();
        try {
            String[] columnNames = rawQuery.getColumnNames();
            for (String add : columnNames) {
                hashSet.add(add);
            }
            rawQuery.close();
            if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
                throw new SQLiteException("Database column missing");
            } else if (!hashSet.isEmpty()) {
                throw new SQLiteException("Database has extra columns");
            }
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m5406a(java.lang.String r11, android.database.sqlite.SQLiteDatabase r12) {
        /*
            r10 = this;
            r8 = 0
            r9 = 0
            java.lang.String r1 = "SQLITE_MASTER"
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
            r0 = 0
            java.lang.String r3 = "name"
            r2[r0] = r3     // Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
            java.lang.String r3 = "name=?"
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
            r0 = 0
            r4[r0] = r11     // Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = r12
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0053, all -> 0x004c }
            if (r1 == 0) goto L_0x0025
            r1.close()
        L_0x0025:
            return r0
        L_0x0026:
            r0 = move-exception
            r0 = r9
        L_0x0028:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
            r1.<init>()     // Catch:{ all -> 0x004f }
            java.lang.String r2 = "Error querying for table "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x004f }
            java.lang.StringBuilder r1 = r1.append(r11)     // Catch:{ all -> 0x004f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x004f }
            com.google.android.gms.tagmanager.C1333x.m5442b(r1)     // Catch:{ all -> 0x004f }
            if (r0 == 0) goto L_0x0043
            r0.close()
        L_0x0043:
            r0 = r8
            goto L_0x0025
        L_0x0045:
            r0 = move-exception
        L_0x0046:
            if (r9 == 0) goto L_0x004b
            r9.close()
        L_0x004b:
            throw r0
        L_0x004c:
            r0 = move-exception
            r9 = r1
            goto L_0x0046
        L_0x004f:
            r1 = move-exception
            r9 = r0
            r0 = r1
            goto L_0x0046
        L_0x0053:
            r0 = move-exception
            r0 = r1
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C1309bo.m5406a(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
    }

    public SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = super.getWritableDatabase();
        } catch (SQLiteException e) {
            this.f5392a.f5383c.getDatabasePath("google_tagmanager.db").delete();
        }
        return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C1328s.m5435a(sQLiteDatabase.getPath());
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
        if (!m5406a("datalayer", sQLiteDatabase)) {
            sQLiteDatabase.execSQL(C1306bl.f5381a);
        } else {
            m5405a(sQLiteDatabase);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
