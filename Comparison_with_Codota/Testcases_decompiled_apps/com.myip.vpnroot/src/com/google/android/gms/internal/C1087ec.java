package com.google.android.gms.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

@C1130ez
/* renamed from: com.google.android.gms.internal.ec */
public class C1087ec {

    /* renamed from: mw */
    private static final Object f3241mw = new Object();
    /* access modifiers changed from: private */

    /* renamed from: sG */
    public static final String f3242sG = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[]{"InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time"});

    /* renamed from: sI */
    private static C1087ec f3243sI;

    /* renamed from: sH */
    private final C1088a f3244sH;

    /* renamed from: com.google.android.gms.internal.ec$a */
    public class C1088a extends SQLiteOpenHelper {
        public C1088a(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 4);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(C1087ec.f3242sG);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            C1229gs.m4677U("Database updated from version " + oldVersion + " to version " + newVersion);
            db.execSQL("DROP TABLE IF EXISTS InAppPurchase");
            onCreate(db);
        }
    }

    private C1087ec(Context context) {
        this.f3244sH = new C1088a(context, "google_inapp_purchase.db");
    }

    /* renamed from: j */
    public static C1087ec m4314j(Context context) {
        C1087ec ecVar;
        synchronized (f3241mw) {
            if (f3243sI == null) {
                f3243sI = new C1087ec(context);
            }
            ecVar = f3243sI;
        }
        return ecVar;
    }

    /* renamed from: a */
    public C1085ea mo8408a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        return new C1085ea(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
    }

    /* renamed from: a */
    public void mo8409a(C1085ea eaVar) {
        if (eaVar != null) {
            synchronized (f3241mw) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase != null) {
                    writableDatabase.delete("InAppPurchase", String.format("%s = %d", new Object[]{"purchase_id", Long.valueOf(eaVar.f3232sA)}), (String[]) null);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8410b(com.google.android.gms.internal.C1085ea r7) {
        /*
            r6 = this;
            if (r7 != 0) goto L_0x0003
        L_0x0002:
            return
        L_0x0003:
            java.lang.Object r1 = f3241mw
            monitor-enter(r1)
            android.database.sqlite.SQLiteDatabase r0 = r6.getWritableDatabase()     // Catch:{ all -> 0x000e }
            if (r0 != 0) goto L_0x0011
            monitor-exit(r1)     // Catch:{ all -> 0x000e }
            goto L_0x0002
        L_0x000e:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x000e }
            throw r0
        L_0x0011:
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ all -> 0x000e }
            r2.<init>()     // Catch:{ all -> 0x000e }
            java.lang.String r3 = "product_id"
            java.lang.String r4 = r7.f3234sC     // Catch:{ all -> 0x000e }
            r2.put(r3, r4)     // Catch:{ all -> 0x000e }
            java.lang.String r3 = "developer_payload"
            java.lang.String r4 = r7.f3233sB     // Catch:{ all -> 0x000e }
            r2.put(r3, r4)     // Catch:{ all -> 0x000e }
            java.lang.String r3 = "record_time"
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x000e }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x000e }
            r2.put(r3, r4)     // Catch:{ all -> 0x000e }
            java.lang.String r3 = "InAppPurchase"
            r4 = 0
            long r2 = r0.insert(r3, r4, r2)     // Catch:{ all -> 0x000e }
            r7.f3232sA = r2     // Catch:{ all -> 0x000e }
            int r0 = r6.getRecordCount()     // Catch:{ all -> 0x000e }
            long r2 = (long) r0     // Catch:{ all -> 0x000e }
            r4 = 20000(0x4e20, double:9.8813E-320)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0048
            r6.mo8411cs()     // Catch:{ all -> 0x000e }
        L_0x0048:
            monitor-exit(r1)     // Catch:{ all -> 0x000e }
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1087ec.mo8410b(com.google.android.gms.internal.ea):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x005a A[Catch:{ SQLiteException -> 0x0034, all -> 0x0056 }] */
    /* renamed from: cs */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8411cs() {
        /*
            r11 = this;
            r9 = 0
            java.lang.Object r10 = f3241mw
            monitor-enter(r10)
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x000c
            monitor-exit(r10)     // Catch:{ all -> 0x0031 }
        L_0x000b:
            return
        L_0x000c:
            java.lang.String r7 = "record_time ASC"
            java.lang.String r1 = "InAppPurchase"
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r8 = "1"
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0034, all -> 0x0056 }
            if (r1 == 0) goto L_0x002a
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0060 }
            if (r0 == 0) goto L_0x002a
            com.google.android.gms.internal.ea r0 = r11.mo8408a((android.database.Cursor) r1)     // Catch:{ SQLiteException -> 0x0060 }
            r11.mo8409a((com.google.android.gms.internal.C1085ea) r0)     // Catch:{ SQLiteException -> 0x0060 }
        L_0x002a:
            if (r1 == 0) goto L_0x002f
            r1.close()     // Catch:{ all -> 0x0031 }
        L_0x002f:
            monitor-exit(r10)     // Catch:{ all -> 0x0031 }
            goto L_0x000b
        L_0x0031:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0031 }
            throw r0
        L_0x0034:
            r0 = move-exception
            r1 = r9
        L_0x0036:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005e }
            r2.<init>()     // Catch:{ all -> 0x005e }
            java.lang.String r3 = "Error remove oldest record"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x005e }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x005e }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x005e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.C1229gs.m4679W(r0)     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x002f
            r1.close()     // Catch:{ all -> 0x0031 }
            goto L_0x002f
        L_0x0056:
            r0 = move-exception
            r1 = r9
        L_0x0058:
            if (r1 == 0) goto L_0x005d
            r1.close()     // Catch:{ all -> 0x0031 }
        L_0x005d:
            throw r0     // Catch:{ all -> 0x0031 }
        L_0x005e:
            r0 = move-exception
            goto L_0x0058
        L_0x0060:
            r0 = move-exception
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1087ec.mo8411cs():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0070 A[SYNTHETIC, Splitter:B:37:0x0070] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.internal.C1085ea> mo8412d(long r13) {
        /*
            r12 = this;
            r10 = 0
            java.lang.Object r11 = f3241mw
            monitor-enter(r11)
            java.util.LinkedList r9 = new java.util.LinkedList     // Catch:{ all -> 0x0069 }
            r9.<init>()     // Catch:{ all -> 0x0069 }
            r0 = 0
            int r0 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0012
            monitor-exit(r11)     // Catch:{ all -> 0x0069 }
            r0 = r9
        L_0x0011:
            return r0
        L_0x0012:
            android.database.sqlite.SQLiteDatabase r0 = r12.getWritableDatabase()     // Catch:{ all -> 0x0069 }
            if (r0 != 0) goto L_0x001b
            monitor-exit(r11)     // Catch:{ all -> 0x0069 }
            r0 = r9
            goto L_0x0011
        L_0x001b:
            java.lang.String r7 = "record_time ASC"
            java.lang.String r1 = "InAppPurchase"
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r8 = java.lang.String.valueOf(r13)     // Catch:{ SQLiteException -> 0x0047, all -> 0x006c }
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0047, all -> 0x006c }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0076 }
            if (r0 == 0) goto L_0x003f
        L_0x0032:
            com.google.android.gms.internal.ea r0 = r12.mo8408a((android.database.Cursor) r1)     // Catch:{ SQLiteException -> 0x0076 }
            r9.add(r0)     // Catch:{ SQLiteException -> 0x0076 }
            boolean r0 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0076 }
            if (r0 != 0) goto L_0x0032
        L_0x003f:
            if (r1 == 0) goto L_0x0044
            r1.close()     // Catch:{ all -> 0x0069 }
        L_0x0044:
            monitor-exit(r11)     // Catch:{ all -> 0x0069 }
            r0 = r9
            goto L_0x0011
        L_0x0047:
            r0 = move-exception
            r1 = r10
        L_0x0049:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
            r2.<init>()     // Catch:{ all -> 0x0074 }
            java.lang.String r3 = "Error extracing purchase info: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0074 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0074 }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x0074 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0074 }
            com.google.android.gms.internal.C1229gs.m4679W(r0)     // Catch:{ all -> 0x0074 }
            if (r1 == 0) goto L_0x0044
            r1.close()     // Catch:{ all -> 0x0069 }
            goto L_0x0044
        L_0x0069:
            r0 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x0069 }
            throw r0
        L_0x006c:
            r0 = move-exception
            r1 = r10
        L_0x006e:
            if (r1 == 0) goto L_0x0073
            r1.close()     // Catch:{ all -> 0x0069 }
        L_0x0073:
            throw r0     // Catch:{ all -> 0x0069 }
        L_0x0074:
            r0 = move-exception
            goto L_0x006e
        L_0x0076:
            r0 = move-exception
            goto L_0x0049
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1087ec.mo8412d(long):java.util.List");
    }

    public int getRecordCount() {
        Cursor cursor = null;
        int i = 0;
        synchronized (f3241mw) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    Cursor rawQuery = writableDatabase.rawQuery("select count(*) from InAppPurchase", (String[]) null);
                    if (rawQuery.moveToFirst()) {
                        i = rawQuery.getInt(0);
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    } else if (rawQuery != null) {
                        rawQuery.close();
                    }
                } catch (SQLiteException e) {
                    C1229gs.m4679W("Error getting record count" + e.getMessage());
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
        }
        return i;
    }

    public SQLiteDatabase getWritableDatabase() {
        try {
            return this.f3244sH.getWritableDatabase();
        } catch (SQLiteException e) {
            C1229gs.m4679W("Error opening writable conversion tracking database");
            return null;
        }
    }
}
