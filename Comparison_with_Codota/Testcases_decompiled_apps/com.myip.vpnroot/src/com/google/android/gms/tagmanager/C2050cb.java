package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.internal.C1385ju;
import com.google.android.gms.internal.C1387jw;
import com.google.android.gms.tagmanager.C2105db;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.apache.http.impl.client.DefaultHttpClient;

/* renamed from: com.google.android.gms.tagmanager.cb */
class C2050cb implements C2009at {
    /* access modifiers changed from: private */

    /* renamed from: AY */
    public static final String f4559AY = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[]{"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"});
    /* access modifiers changed from: private */

    /* renamed from: Bb */
    public final String f4560Bb;

    /* renamed from: Bd */
    private long f4561Bd;

    /* renamed from: Be */
    private final int f4562Be;
    private final C2052b apL;
    private volatile C1990ab apM;
    private final C2010au apN;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */

    /* renamed from: yD */
    public C1385ju f4563yD;

    /* renamed from: com.google.android.gms.tagmanager.cb$a */
    class C2051a implements C2105db.C2106a {
        C2051a() {
        }

        /* renamed from: a */
        public void mo11620a(C2004ap apVar) {
            C2050cb.this.m6886y(apVar.mo11553eH());
        }

        /* renamed from: b */
        public void mo11621b(C2004ap apVar) {
            C2050cb.this.m6886y(apVar.mo11553eH());
            C2028bh.m6818V("Permanent failure dispatching hitId: " + apVar.mo11553eH());
        }

        /* renamed from: c */
        public void mo11622c(C2004ap apVar) {
            long or = apVar.mo11554or();
            if (or == 0) {
                C2050cb.this.m6882c(apVar.mo11553eH(), C2050cb.this.f4563yD.currentTimeMillis());
            } else if (or + 14400000 < C2050cb.this.f4563yD.currentTimeMillis()) {
                C2050cb.this.m6886y(apVar.mo11553eH());
                C2028bh.m6818V("Giving up on failed hitId: " + apVar.mo11553eH());
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cb$b */
    class C2052b extends SQLiteOpenHelper {

        /* renamed from: Bf */
        private boolean f4564Bf;

        /* renamed from: Bg */
        private long f4565Bg = 0;

        C2052b(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        private void m6897a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", (String[]) null);
            HashSet hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (String add : columnNames) {
                    hashSet.add(add);
                }
                rawQuery.close();
                if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_time") || !hashSet.remove("hit_first_send_time")) {
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
        private boolean m6898a(java.lang.String r11, android.database.sqlite.SQLiteDatabase r12) {
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
                com.google.android.gms.tagmanager.C2028bh.m6819W(r1)     // Catch:{ all -> 0x004f }
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C2050cb.C2052b.m6898a(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!this.f4564Bf || this.f4565Bg + 3600000 <= C2050cb.this.f4563yD.currentTimeMillis()) {
                SQLiteDatabase sQLiteDatabase = null;
                this.f4564Bf = true;
                this.f4565Bg = C2050cb.this.f4563yD.currentTimeMillis();
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    C2050cb.this.mContext.getDatabasePath(C2050cb.this.f4560Bb).delete();
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = super.getWritableDatabase();
                }
                this.f4564Bf = false;
                return sQLiteDatabase;
            }
            throw new SQLiteException("Database creation failed");
        }

        public void onCreate(SQLiteDatabase db) {
            C1999ak.m6755ag(db.getPath());
        }

        public void onOpen(SQLiteDatabase db) {
            if (Build.VERSION.SDK_INT < 15) {
                Cursor rawQuery = db.rawQuery("PRAGMA journal_mode=memory", (String[]) null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (!m6898a("gtm_hits", db)) {
                db.execSQL(C2050cb.f4559AY);
            } else {
                m6897a(db);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    C2050cb(C2010au auVar, Context context) {
        this(auVar, context, "gtm_urls.db", 2000);
    }

    C2050cb(C2010au auVar, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.f4560Bb = str;
        this.apN = auVar;
        this.f4563yD = C1387jw.m5217hA();
        this.apL = new C2052b(this.mContext, this.f4560Bb);
        this.apM = new C2105db(new DefaultHttpClient(), this.mContext, new C2051a());
        this.f4561Bd = 0;
        this.f4562Be = i;
    }

    /* renamed from: al */
    private SQLiteDatabase m6879al(String str) {
        try {
            return this.apL.getWritableDatabase();
        } catch (SQLiteException e) {
            C2028bh.m6819W(str);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6882c(long j, long j2) {
        SQLiteDatabase al = m6879al("Error opening database for getNumStoredHits.");
        if (al != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_first_send_time", Long.valueOf(j2));
            try {
                al.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
            } catch (SQLiteException e) {
                C2028bh.m6819W("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + j);
                m6886y(j);
            }
        }
    }

    /* renamed from: eN */
    private void m6883eN() {
        int eP = (mo11618eP() - this.f4562Be) + 1;
        if (eP > 0) {
            List<String> F = mo11614F(eP);
            C2028bh.m6818V("Store full, deleting " + F.size() + " hits to make room.");
            mo11616b((String[]) F.toArray(new String[0]));
        }
    }

    /* renamed from: g */
    private void m6884g(long j, String str) {
        SQLiteDatabase al = m6879al("Error opening database for putHit");
        if (al != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_time", Long.valueOf(j));
            contentValues.put("hit_url", str);
            contentValues.put("hit_first_send_time", 0);
            try {
                al.insert("gtm_hits", (String) null, contentValues);
                this.apN.mo11564z(false);
            } catch (SQLiteException e) {
                C2028bh.m6819W("Error storing hit");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m6886y(long j) {
        mo11616b(new String[]{String.valueOf(j)});
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0082  */
    /* renamed from: F */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> mo11614F(int r14) {
        /*
            r13 = this;
            r10 = 0
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            if (r14 > 0) goto L_0x000f
            java.lang.String r0 = "Invalid maxHits specified. Skipping"
            com.google.android.gms.tagmanager.C2028bh.m6819W(r0)
            r0 = r9
        L_0x000e:
            return r0
        L_0x000f:
            java.lang.String r0 = "Error opening database for peekHitIds."
            android.database.sqlite.SQLiteDatabase r0 = r13.m6879al(r0)
            if (r0 != 0) goto L_0x0019
            r0 = r9
            goto L_0x000e
        L_0x0019:
            java.lang.String r1 = "gtm_hits"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
            r3 = 0
            java.lang.String r4 = "hit_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "%s ASC"
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ SQLiteException -> 0x005c, all -> 0x007e }
            r11 = 0
            java.lang.String r12 = "hit_id"
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
            java.lang.String r3 = "Error in peekHits fetching hitIds: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0086 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0086 }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x0086 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0086 }
            com.google.android.gms.tagmanager.C2028bh.m6819W(r0)     // Catch:{ all -> 0x0086 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C2050cb.mo11614F(int):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e8, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f0, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0169, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x016a, code lost:
        r11 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x016f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0170, code lost:
        r2 = r1;
        r3 = r12;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        return r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0169 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* renamed from: G */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.tagmanager.C2004ap> mo11615G(int r16) {
        /*
            r15 = this;
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.lang.String r1 = "Error opening database for peekHits"
            android.database.sqlite.SQLiteDatabase r1 = r15.m6879al(r1)
            if (r1 != 0) goto L_0x000f
            r1 = r10
        L_0x000e:
            return r1
        L_0x000f:
            r11 = 0
            java.lang.String r2 = "gtm_hits"
            r3 = 3
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
            r4 = 0
            java.lang.String r5 = "hit_id"
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
            r4 = 1
            java.lang.String r5 = "hit_time"
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
            r4 = 2
            java.lang.String r5 = "hit_first_send_time"
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r8 = "%s ASC"
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
            r12 = 0
            java.lang.String r13 = "hit_id"
            r9[r12] = r13     // Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
            java.lang.String r8 = java.lang.String.format(r8, r9)     // Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
            java.lang.String r9 = java.lang.Integer.toString(r16)     // Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x00c8, all -> 0x00ed }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            r11.<init>()     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            boolean r2 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
            if (r2 == 0) goto L_0x0066
        L_0x0049:
            com.google.android.gms.tagmanager.ap r2 = new com.google.android.gms.tagmanager.ap     // Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
            r3 = 0
            long r3 = r12.getLong(r3)     // Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
            r5 = 1
            long r5 = r12.getLong(r5)     // Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
            r7 = 2
            long r7 = r12.getLong(r7)     // Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
            r2.<init>(r3, r5, r7)     // Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
            r11.add(r2)     // Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
            boolean r2 = r12.moveToNext()     // Catch:{ SQLiteException -> 0x0175, all -> 0x0169 }
            if (r2 != 0) goto L_0x0049
        L_0x0066:
            if (r12 == 0) goto L_0x006b
            r12.close()
        L_0x006b:
            r10 = 0
            java.lang.String r2 = "gtm_hits"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0167 }
            r4 = 0
            java.lang.String r5 = "hit_id"
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x0167 }
            r4 = 1
            java.lang.String r5 = "hit_url"
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x0167 }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r8 = "%s ASC"
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ SQLiteException -> 0x0167 }
            r13 = 0
            java.lang.String r14 = "hit_id"
            r9[r13] = r14     // Catch:{ SQLiteException -> 0x0167 }
            java.lang.String r8 = java.lang.String.format(r8, r9)     // Catch:{ SQLiteException -> 0x0167 }
            java.lang.String r9 = java.lang.Integer.toString(r16)     // Catch:{ SQLiteException -> 0x0167 }
            android.database.Cursor r2 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0167 }
            boolean r1 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            if (r1 == 0) goto L_0x00c0
            r3 = r10
        L_0x009c:
            r0 = r2
            android.database.sqlite.SQLiteCursor r0 = (android.database.sqlite.SQLiteCursor) r0     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            r1 = r0
            android.database.CursorWindow r1 = r1.getWindow()     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            int r1 = r1.getNumRows()     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            if (r1 <= 0) goto L_0x00f4
            java.lang.Object r1 = r11.get(r3)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            com.google.android.gms.tagmanager.ap r1 = (com.google.android.gms.tagmanager.C2004ap) r1     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            r4 = 1
            java.lang.String r4 = r2.getString(r4)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            r1.mo11552ak(r4)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
        L_0x00b8:
            int r1 = r3 + 1
            boolean r3 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            if (r3 != 0) goto L_0x017b
        L_0x00c0:
            if (r2 == 0) goto L_0x00c5
            r2.close()
        L_0x00c5:
            r1 = r11
            goto L_0x000e
        L_0x00c8:
            r1 = move-exception
            r2 = r1
            r3 = r11
            r1 = r10
        L_0x00cc:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x016c }
            r4.<init>()     // Catch:{ all -> 0x016c }
            java.lang.String r5 = "Error in peekHits fetching hitIds: "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x016c }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x016c }
            java.lang.StringBuilder r2 = r4.append(r2)     // Catch:{ all -> 0x016c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x016c }
            com.google.android.gms.tagmanager.C2028bh.m6819W(r2)     // Catch:{ all -> 0x016c }
            if (r3 == 0) goto L_0x000e
            r3.close()
            goto L_0x000e
        L_0x00ed:
            r1 = move-exception
        L_0x00ee:
            if (r11 == 0) goto L_0x00f3
            r11.close()
        L_0x00f3:
            throw r1
        L_0x00f4:
            java.lang.String r4 = "HitString for hitId %d too large.  Hit will be deleted."
            r1 = 1
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            r6 = 0
            java.lang.Object r1 = r11.get(r3)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            com.google.android.gms.tagmanager.ap r1 = (com.google.android.gms.tagmanager.C2004ap) r1     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            long r7 = r1.mo11553eH()     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            java.lang.Long r1 = java.lang.Long.valueOf(r7)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            r5[r6] = r1     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            java.lang.String r1 = java.lang.String.format(r4, r5)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            com.google.android.gms.tagmanager.C2028bh.m6819W(r1)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0164 }
            goto L_0x00b8
        L_0x0112:
            r1 = move-exception
            r12 = r2
        L_0x0114:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x015d }
            r2.<init>()     // Catch:{ all -> 0x015d }
            java.lang.String r3 = "Error in peekHits fetching hit url: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x015d }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x015d }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ all -> 0x015d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x015d }
            com.google.android.gms.tagmanager.C2028bh.m6819W(r1)     // Catch:{ all -> 0x015d }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x015d }
            r2.<init>()     // Catch:{ all -> 0x015d }
            r3 = 0
            java.util.Iterator r4 = r11.iterator()     // Catch:{ all -> 0x015d }
        L_0x0138:
            boolean r1 = r4.hasNext()     // Catch:{ all -> 0x015d }
            if (r1 == 0) goto L_0x0150
            java.lang.Object r1 = r4.next()     // Catch:{ all -> 0x015d }
            com.google.android.gms.tagmanager.ap r1 = (com.google.android.gms.tagmanager.C2004ap) r1     // Catch:{ all -> 0x015d }
            java.lang.String r5 = r1.mo11555os()     // Catch:{ all -> 0x015d }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x015d }
            if (r5 == 0) goto L_0x0159
            if (r3 == 0) goto L_0x0158
        L_0x0150:
            if (r12 == 0) goto L_0x0155
            r12.close()
        L_0x0155:
            r1 = r2
            goto L_0x000e
        L_0x0158:
            r3 = 1
        L_0x0159:
            r2.add(r1)     // Catch:{ all -> 0x015d }
            goto L_0x0138
        L_0x015d:
            r1 = move-exception
        L_0x015e:
            if (r12 == 0) goto L_0x0163
            r12.close()
        L_0x0163:
            throw r1
        L_0x0164:
            r1 = move-exception
            r12 = r2
            goto L_0x015e
        L_0x0167:
            r1 = move-exception
            goto L_0x0114
        L_0x0169:
            r1 = move-exception
            r11 = r12
            goto L_0x00ee
        L_0x016c:
            r1 = move-exception
            r11 = r3
            goto L_0x00ee
        L_0x016f:
            r1 = move-exception
            r2 = r1
            r3 = r12
            r1 = r10
            goto L_0x00cc
        L_0x0175:
            r1 = move-exception
            r2 = r1
            r3 = r12
            r1 = r11
            goto L_0x00cc
        L_0x017b:
            r3 = r1
            goto L_0x009c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C2050cb.mo11615G(int):java.util.List");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo11616b(String[] strArr) {
        SQLiteDatabase al;
        boolean z = true;
        if (strArr != null && strArr.length != 0 && (al = m6879al("Error opening database for deleteHits.")) != null) {
            try {
                al.delete("gtm_hits", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                C2010au auVar = this.apN;
                if (mo11618eP() != 0) {
                    z = false;
                }
                auVar.mo11564z(z);
            } catch (SQLiteException e) {
                C2028bh.m6819W("Error deleting hits");
            }
        }
    }

    public void dispatch() {
        C2028bh.m6818V("GTM Dispatch running...");
        if (this.apM.mo11539dY()) {
            List<C2004ap> G = mo11615G(40);
            if (G.isEmpty()) {
                C2028bh.m6818V("...nothing to dispatch");
                this.apN.mo11564z(true);
                return;
            }
            this.apM.mo11540j(G);
            if (mo11619oF() > 0) {
                C2097cy.m7060pu().dispatch();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: eO */
    public int mo11617eO() {
        boolean z = true;
        long currentTimeMillis = this.f4563yD.currentTimeMillis();
        if (currentTimeMillis <= this.f4561Bd + 86400000) {
            return 0;
        }
        this.f4561Bd = currentTimeMillis;
        SQLiteDatabase al = m6879al("Error opening database for deleteStaleHits.");
        if (al == null) {
            return 0;
        }
        int delete = al.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.f4563yD.currentTimeMillis() - 2592000000L)});
        C2010au auVar = this.apN;
        if (mo11618eP() != 0) {
            z = false;
        }
        auVar.mo11564z(z);
        return delete;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: eP */
    public int mo11618eP() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase al = m6879al("Error opening database for getNumStoredHits.");
        if (al != null) {
            try {
                Cursor rawQuery = al.rawQuery("SELECT COUNT(*) from gtm_hits", (String[]) null);
                if (rawQuery.moveToFirst()) {
                    i = (int) rawQuery.getLong(0);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e) {
                C2028bh.m6819W("Error getting numStoredHits");
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

    /* renamed from: f */
    public void mo11563f(long j, String str) {
        mo11617eO();
        m6883eN();
        m6884g(j, str);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040  */
    /* renamed from: oF */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo11619oF() {
        /*
            r10 = this;
            r8 = 0
            r9 = 0
            java.lang.String r0 = "Error opening database for getNumStoredHits."
            android.database.sqlite.SQLiteDatabase r0 = r10.m6879al(r0)
            if (r0 != 0) goto L_0x000b
        L_0x000a:
            return r8
        L_0x000b:
            java.lang.String r1 = "gtm_hits"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x002f, all -> 0x003d }
            r3 = 0
            java.lang.String r4 = "hit_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x002f, all -> 0x003d }
            r3 = 1
            java.lang.String r4 = "hit_first_send_time"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x002f, all -> 0x003d }
            java.lang.String r3 = "hit_first_send_time=0"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x002f, all -> 0x003d }
            int r0 = r1.getCount()     // Catch:{ SQLiteException -> 0x004b, all -> 0x0044 }
            if (r1 == 0) goto L_0x002d
            r1.close()
        L_0x002d:
            r8 = r0
            goto L_0x000a
        L_0x002f:
            r0 = move-exception
            r0 = r9
        L_0x0031:
            java.lang.String r1 = "Error getting num untried hits"
            com.google.android.gms.tagmanager.C2028bh.m6819W(r1)     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x004e
            r0.close()
            r0 = r8
            goto L_0x002d
        L_0x003d:
            r0 = move-exception
        L_0x003e:
            if (r9 == 0) goto L_0x0043
            r9.close()
        L_0x0043:
            throw r0
        L_0x0044:
            r0 = move-exception
            r9 = r1
            goto L_0x003e
        L_0x0047:
            r1 = move-exception
            r9 = r0
            r0 = r1
            goto L_0x003e
        L_0x004b:
            r0 = move-exception
            r0 = r1
            goto L_0x0031
        L_0x004e:
            r0 = r8
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C2050cb.mo11619oF():int");
    }
}
