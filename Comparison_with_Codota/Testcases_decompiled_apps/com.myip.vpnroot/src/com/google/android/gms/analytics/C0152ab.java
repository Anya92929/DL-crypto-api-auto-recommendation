package com.google.android.gms.analytics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.internal.C1249hb;
import com.google.android.gms.internal.C1385ju;
import com.google.android.gms.internal.C1387jw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.apache.http.impl.client.DefaultHttpClient;

/* renamed from: com.google.android.gms.analytics.ab */
class C0152ab implements C0168d {
    /* access modifiers changed from: private */

    /* renamed from: AY */
    public static final String f137AY = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});

    /* renamed from: AZ */
    private final C0153a f138AZ;

    /* renamed from: Ba */
    private volatile C0179m f139Ba;
    /* access modifiers changed from: private */

    /* renamed from: Bb */
    public final String f140Bb;

    /* renamed from: Bc */
    private C0151aa f141Bc;

    /* renamed from: Bd */
    private long f142Bd;

    /* renamed from: Be */
    private final int f143Be;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */

    /* renamed from: yD */
    public C1385ju f144yD;

    /* renamed from: yl */
    private final C0169e f145yl;

    /* renamed from: com.google.android.gms.analytics.ab$a */
    class C0153a extends SQLiteOpenHelper {

        /* renamed from: Bf */
        private boolean f146Bf;

        /* renamed from: Bg */
        private long f147Bg = 0;

        C0153a(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        private void m101a(SQLiteDatabase sQLiteDatabase) {
            boolean z = false;
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM hits2 WHERE 0", (String[]) null);
            HashSet hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (String add : columnNames) {
                    hashSet.add(add);
                }
                rawQuery.close();
                if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_string") || !hashSet.remove("hit_time")) {
                    throw new SQLiteException("Database column missing");
                }
                if (!hashSet.remove("hit_app_id")) {
                    z = true;
                }
                if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                } else if (z) {
                    sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
                }
            } catch (Throwable th) {
                rawQuery.close();
                throw th;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean m102a(java.lang.String r11, android.database.sqlite.SQLiteDatabase r12) {
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
                com.google.android.gms.analytics.C0207z.m309W(r1)     // Catch:{ all -> 0x004f }
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.C0152ab.C0153a.m102a(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!this.f146Bf || this.f147Bg + 3600000 <= C0152ab.this.f144yD.currentTimeMillis()) {
                SQLiteDatabase sQLiteDatabase = null;
                this.f146Bf = true;
                this.f147Bg = C0152ab.this.f144yD.currentTimeMillis();
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    C0152ab.this.mContext.getDatabasePath(C0152ab.this.f140Bb).delete();
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = super.getWritableDatabase();
                }
                this.f146Bf = false;
                return sQLiteDatabase;
            }
            throw new SQLiteException("Database creation failed");
        }

        public void onCreate(SQLiteDatabase db) {
            C0181o.m210ag(db.getPath());
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
            if (!m102a("hits2", db)) {
                db.execSQL(C0152ab.f137AY);
            } else {
                m101a(db);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    C0152ab(C0169e eVar, Context context) {
        this(eVar, context, "google_analytics_v4.db", 2000);
    }

    C0152ab(C0169e eVar, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.f140Bb = str;
        this.f145yl = eVar;
        this.f144yD = C1387jw.m5217hA();
        this.f138AZ = new C0153a(this.mContext, this.f140Bb);
        this.f139Ba = new C0158ag(new DefaultHttpClient(), this.mContext);
        this.f142Bd = 0;
        this.f143Be = i;
    }

    /* renamed from: A */
    static String m83A(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(C0205x.encode((String) next.getKey()) + "=" + C0205x.encode((String) next.getValue()));
        }
        return TextUtils.join("&", arrayList);
    }

    /* renamed from: a */
    private void m85a(Map<String, String> map, long j, String str) {
        long j2;
        SQLiteDatabase al = m87al("Error opening database for putHit");
        if (al != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_string", m83A(map));
            contentValues.put("hit_time", Long.valueOf(j));
            if (map.containsKey("AppUID")) {
                try {
                    j2 = Long.parseLong(map.get("AppUID"));
                } catch (NumberFormatException e) {
                    j2 = 0;
                }
            } else {
                j2 = 0;
            }
            contentValues.put("hit_app_id", Long.valueOf(j2));
            if (str == null) {
                str = "http://www.google-analytics.com/collect";
            }
            if (str.length() == 0) {
                C0207z.m309W("Empty path: not sending hit");
                return;
            }
            contentValues.put("hit_url", str);
            try {
                al.insert("hits2", (String) null, contentValues);
                this.f145yl.mo3662z(false);
            } catch (SQLiteException e2) {
                C0207z.m309W("Error storing hit");
            }
        }
    }

    /* renamed from: a */
    private void m86a(Map<String, String> map, Collection<C1249hb> collection) {
        String substring = "&_v".substring(1);
        if (collection != null) {
            for (C1249hb next : collection) {
                if ("appendVersion".equals(next.getId())) {
                    map.put(substring, next.getValue());
                    return;
                }
            }
        }
    }

    /* renamed from: al */
    private SQLiteDatabase m87al(String str) {
        try {
            return this.f138AZ.getWritableDatabase();
        } catch (SQLiteException e) {
            C0207z.m309W(str);
            return null;
        }
    }

    /* renamed from: eN */
    private void m90eN() {
        int eP = (mo3608eP() - this.f143Be) + 1;
        if (eP > 0) {
            List<String> F = mo3600F(eP);
            C0207z.m308V("Store full, deleting " + F.size() + " hits to make room.");
            mo3604b((String[]) F.toArray(new String[0]));
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0082  */
    /* renamed from: F */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> mo3600F(int r14) {
        /*
            r13 = this;
            r10 = 0
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            if (r14 > 0) goto L_0x000f
            java.lang.String r0 = "Invalid maxHits specified. Skipping"
            com.google.android.gms.analytics.C0207z.m309W(r0)
            r0 = r9
        L_0x000e:
            return r0
        L_0x000f:
            java.lang.String r0 = "Error opening database for peekHitIds."
            android.database.sqlite.SQLiteDatabase r0 = r13.m87al(r0)
            if (r0 != 0) goto L_0x0019
            r0 = r9
            goto L_0x000e
        L_0x0019:
            java.lang.String r1 = "hits2"
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
            com.google.android.gms.analytics.C0207z.m309W(r0)     // Catch:{ all -> 0x0086 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.C0152ab.mo3600F(int):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f2, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00fa, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0173, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0174, code lost:
        r11 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0179, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x017a, code lost:
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
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0173 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* renamed from: G */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.analytics.C0204w> mo3601G(int r16) {
        /*
            r15 = this;
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.lang.String r1 = "Error opening database for peekHits"
            android.database.sqlite.SQLiteDatabase r1 = r15.m87al(r1)
            if (r1 != 0) goto L_0x000f
            r1 = r10
        L_0x000e:
            return r1
        L_0x000f:
            r11 = 0
            java.lang.String r2 = "hits2"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
            r4 = 0
            java.lang.String r5 = "hit_id"
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
            r4 = 1
            java.lang.String r5 = "hit_time"
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r8 = "%s ASC"
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
            r12 = 0
            java.lang.String r13 = "hit_id"
            r9[r12] = r13     // Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
            java.lang.String r8 = java.lang.String.format(r8, r9)     // Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
            java.lang.String r9 = java.lang.Integer.toString(r16)     // Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x00d2, all -> 0x00f7 }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0179, all -> 0x0173 }
            r11.<init>()     // Catch:{ SQLiteException -> 0x0179, all -> 0x0173 }
            boolean r2 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
            if (r2 == 0) goto L_0x005d
        L_0x0044:
            com.google.android.gms.analytics.w r2 = new com.google.android.gms.analytics.w     // Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
            r3 = 0
            r4 = 0
            long r4 = r12.getLong(r4)     // Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
            r6 = 1
            long r6 = r12.getLong(r6)     // Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
            r2.<init>(r3, r4, r6)     // Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
            r11.add(r2)     // Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
            boolean r2 = r12.moveToNext()     // Catch:{ SQLiteException -> 0x017f, all -> 0x0173 }
            if (r2 != 0) goto L_0x0044
        L_0x005d:
            if (r12 == 0) goto L_0x0062
            r12.close()
        L_0x0062:
            r10 = 0
            java.lang.String r2 = "hits2"
            r3 = 3
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0171 }
            r4 = 0
            java.lang.String r5 = "hit_id"
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x0171 }
            r4 = 1
            java.lang.String r5 = "hit_string"
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x0171 }
            r4 = 2
            java.lang.String r5 = "hit_url"
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x0171 }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r8 = "%s ASC"
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ SQLiteException -> 0x0171 }
            r13 = 0
            java.lang.String r14 = "hit_id"
            r9[r13] = r14     // Catch:{ SQLiteException -> 0x0171 }
            java.lang.String r8 = java.lang.String.format(r8, r9)     // Catch:{ SQLiteException -> 0x0171 }
            java.lang.String r9 = java.lang.Integer.toString(r16)     // Catch:{ SQLiteException -> 0x0171 }
            android.database.Cursor r2 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0171 }
            boolean r1 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            if (r1 == 0) goto L_0x00ca
            r3 = r10
        L_0x0098:
            r0 = r2
            android.database.sqlite.SQLiteCursor r0 = (android.database.sqlite.SQLiteCursor) r0     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            r1 = r0
            android.database.CursorWindow r1 = r1.getWindow()     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            int r1 = r1.getNumRows()     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            if (r1 <= 0) goto L_0x00fe
            java.lang.Object r1 = r11.get(r3)     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            com.google.android.gms.analytics.w r1 = (com.google.android.gms.analytics.C0204w) r1     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            r4 = 1
            java.lang.String r4 = r2.getString(r4)     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            r1.mo3745aj(r4)     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            java.lang.Object r1 = r11.get(r3)     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            com.google.android.gms.analytics.w r1 = (com.google.android.gms.analytics.C0204w) r1     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            r4 = 2
            java.lang.String r4 = r2.getString(r4)     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            r1.mo3746ak(r4)     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
        L_0x00c2:
            int r1 = r3 + 1
            boolean r3 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            if (r3 != 0) goto L_0x0185
        L_0x00ca:
            if (r2 == 0) goto L_0x00cf
            r2.close()
        L_0x00cf:
            r1 = r11
            goto L_0x000e
        L_0x00d2:
            r1 = move-exception
            r2 = r1
            r3 = r11
            r1 = r10
        L_0x00d6:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0176 }
            r4.<init>()     // Catch:{ all -> 0x0176 }
            java.lang.String r5 = "Error in peekHits fetching hitIds: "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x0176 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0176 }
            java.lang.StringBuilder r2 = r4.append(r2)     // Catch:{ all -> 0x0176 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.analytics.C0207z.m309W(r2)     // Catch:{ all -> 0x0176 }
            if (r3 == 0) goto L_0x000e
            r3.close()
            goto L_0x000e
        L_0x00f7:
            r1 = move-exception
        L_0x00f8:
            if (r11 == 0) goto L_0x00fd
            r11.close()
        L_0x00fd:
            throw r1
        L_0x00fe:
            java.lang.String r4 = "HitString for hitId %d too large.  Hit will be deleted."
            r1 = 1
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            r6 = 0
            java.lang.Object r1 = r11.get(r3)     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            com.google.android.gms.analytics.w r1 = (com.google.android.gms.analytics.C0204w) r1     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            long r7 = r1.mo3748eH()     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            java.lang.Long r1 = java.lang.Long.valueOf(r7)     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            r5[r6] = r1     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            java.lang.String r1 = java.lang.String.format(r4, r5)     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            com.google.android.gms.analytics.C0207z.m309W(r1)     // Catch:{ SQLiteException -> 0x011c, all -> 0x016e }
            goto L_0x00c2
        L_0x011c:
            r1 = move-exception
            r12 = r2
        L_0x011e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0167 }
            r2.<init>()     // Catch:{ all -> 0x0167 }
            java.lang.String r3 = "Error in peekHits fetching hitString: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0167 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0167 }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ all -> 0x0167 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0167 }
            com.google.android.gms.analytics.C0207z.m309W(r1)     // Catch:{ all -> 0x0167 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0167 }
            r2.<init>()     // Catch:{ all -> 0x0167 }
            r3 = 0
            java.util.Iterator r4 = r11.iterator()     // Catch:{ all -> 0x0167 }
        L_0x0142:
            boolean r1 = r4.hasNext()     // Catch:{ all -> 0x0167 }
            if (r1 == 0) goto L_0x015a
            java.lang.Object r1 = r4.next()     // Catch:{ all -> 0x0167 }
            com.google.android.gms.analytics.w r1 = (com.google.android.gms.analytics.C0204w) r1     // Catch:{ all -> 0x0167 }
            java.lang.String r5 = r1.mo3747eG()     // Catch:{ all -> 0x0167 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0167 }
            if (r5 == 0) goto L_0x0163
            if (r3 == 0) goto L_0x0162
        L_0x015a:
            if (r12 == 0) goto L_0x015f
            r12.close()
        L_0x015f:
            r1 = r2
            goto L_0x000e
        L_0x0162:
            r3 = 1
        L_0x0163:
            r2.add(r1)     // Catch:{ all -> 0x0167 }
            goto L_0x0142
        L_0x0167:
            r1 = move-exception
        L_0x0168:
            if (r12 == 0) goto L_0x016d
            r12.close()
        L_0x016d:
            throw r1
        L_0x016e:
            r1 = move-exception
            r12 = r2
            goto L_0x0168
        L_0x0171:
            r1 = move-exception
            goto L_0x011e
        L_0x0173:
            r1 = move-exception
            r11 = r12
            goto L_0x00f8
        L_0x0176:
            r1 = move-exception
            r11 = r3
            goto L_0x00f8
        L_0x0179:
            r1 = move-exception
            r2 = r1
            r3 = r12
            r1 = r10
            goto L_0x00d6
        L_0x017f:
            r1 = move-exception
            r2 = r1
            r3 = r12
            r1 = r11
            goto L_0x00d6
        L_0x0185:
            r3 = r1
            goto L_0x0098
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.C0152ab.mo3601G(int):java.util.List");
    }

    /* renamed from: a */
    public void mo3602a(Map<String, String> map, long j, String str, Collection<C1249hb> collection) {
        mo3607eO();
        m90eN();
        m86a(map, collection);
        m85a(map, j, str);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    /* renamed from: b */
    public void mo3603b(Collection<C0204w> collection) {
        if (collection == null || collection.isEmpty()) {
            C0207z.m309W("Empty/Null collection passed to deleteHits.");
            return;
        }
        String[] strArr = new String[collection.size()];
        int i = 0;
        for (C0204w eH : collection) {
            strArr[i] = String.valueOf(eH.mo3748eH());
            i++;
        }
        mo3604b(strArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3604b(String[] strArr) {
        boolean z = true;
        if (strArr == null || strArr.length == 0) {
            C0207z.m309W("Empty hitIds passed to deleteHits.");
            return;
        }
        SQLiteDatabase al = m87al("Error opening database for deleteHits.");
        if (al != null) {
            try {
                al.delete("hits2", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                C0169e eVar = this.f145yl;
                if (mo3608eP() != 0) {
                    z = false;
                }
                eVar.mo3662z(z);
            } catch (SQLiteException e) {
                C0207z.m309W("Error deleting hits " + TextUtils.join(",", strArr));
            }
        }
    }

    /* renamed from: dN */
    public C0179m mo3605dN() {
        return this.f139Ba;
    }

    public void dispatch() {
        boolean z = true;
        C0207z.m308V("Dispatch running...");
        if (this.f139Ba.mo3630dY()) {
            List<C0204w> G = mo3601G(40);
            if (G.isEmpty()) {
                C0207z.m308V("...nothing to dispatch");
                this.f145yl.mo3662z(true);
                return;
            }
            if (this.f141Bc == null) {
                this.f141Bc = new C0151aa("_t=dispatch&_v=ma4.0.3", true);
            }
            if (mo3608eP() > G.size()) {
                z = false;
            }
            int a = this.f139Ba.mo3626a(G, this.f141Bc, z);
            C0207z.m308V("sent " + a + " of " + G.size() + " hits");
            mo3603b((Collection<C0204w>) G.subList(0, Math.min(a, G.size())));
            if (a != G.size() || mo3608eP() <= 0) {
                this.f141Bc = null;
            } else {
                GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: eO */
    public int mo3607eO() {
        boolean z = true;
        long currentTimeMillis = this.f144yD.currentTimeMillis();
        if (currentTimeMillis <= this.f142Bd + 86400000) {
            return 0;
        }
        this.f142Bd = currentTimeMillis;
        SQLiteDatabase al = m87al("Error opening database for deleteStaleHits.");
        if (al == null) {
            return 0;
        }
        int delete = al.delete("hits2", "HIT_TIME < ?", new String[]{Long.toString(this.f144yD.currentTimeMillis() - 2592000000L)});
        C0169e eVar = this.f145yl;
        if (mo3608eP() != 0) {
            z = false;
        }
        eVar.mo3662z(z);
        return delete;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: eP */
    public int mo3608eP() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase al = m87al("Error opening database for getNumStoredHits.");
        if (al != null) {
            try {
                Cursor rawQuery = al.rawQuery("SELECT COUNT(*) from hits2", (String[]) null);
                if (rawQuery.moveToFirst()) {
                    i = (int) rawQuery.getLong(0);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e) {
                C0207z.m309W("Error getting numStoredHits");
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

    /* renamed from: l */
    public void mo3609l(long j) {
        boolean z = true;
        SQLiteDatabase al = m87al("Error opening database for clearHits");
        if (al != null) {
            if (j == 0) {
                al.delete("hits2", (String) null, (String[]) null);
            } else {
                al.delete("hits2", "hit_app_id = ?", new String[]{Long.valueOf(j).toString()});
            }
            C0169e eVar = this.f145yl;
            if (mo3608eP() != 0) {
                z = false;
            }
            eVar.mo3662z(z);
        }
    }
}
