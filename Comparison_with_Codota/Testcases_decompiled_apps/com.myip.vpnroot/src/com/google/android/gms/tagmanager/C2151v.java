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
import com.google.android.gms.tagmanager.DataLayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.gms.tagmanager.v */
class C2151v implements DataLayer.C1977c {
    /* access modifiers changed from: private */
    public static final String aoF = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
    private final Executor aoG;
    private C2155a aoH;
    private int aoI;
    /* access modifiers changed from: private */
    public final Context mContext;

    /* renamed from: yD */
    private C1385ju f4604yD;

    /* renamed from: com.google.android.gms.tagmanager.v$a */
    class C2155a extends SQLiteOpenHelper {
        C2155a(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        private void m7269a(SQLiteDatabase sQLiteDatabase) {
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
        private boolean m7270a(java.lang.String r11, android.database.sqlite.SQLiteDatabase r12) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C2151v.C2155a.m7270a(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
        }

        public SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                C2151v.this.mContext.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
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
            if (!m7270a("datalayer", db)) {
                db.execSQL(C2151v.aoF);
            } else {
                m7269a(db);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.v$b */
    private static class C2156b {

        /* renamed from: JH */
        final String f4605JH;
        final byte[] aoO;

        C2156b(String str, byte[] bArr) {
            this.f4605JH = str;
            this.aoO = bArr;
        }

        public String toString() {
            return "KeyAndSerialized: key = " + this.f4605JH + " serialized hash = " + Arrays.hashCode(this.aoO);
        }
    }

    public C2151v(Context context) {
        this(context, C1387jw.m5217hA(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    C2151v(Context context, C1385ju juVar, String str, int i, Executor executor) {
        this.mContext = context;
        this.f4604yD = juVar;
        this.aoI = i;
        this.aoG = executor;
        this.aoH = new C2155a(this.mContext, str);
    }

    /* renamed from: al */
    private SQLiteDatabase m7248al(String str) {
        try {
            return this.aoH.getWritableDatabase();
        } catch (SQLiteException e) {
            C2028bh.m6819W(str);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m7250b(List<C2156b> list, long j) {
        try {
            long currentTimeMillis = this.f4604yD.currentTimeMillis();
            m7265x(currentTimeMillis);
            m7253ff(list.size());
            m7251c(list, currentTimeMillis + j);
            m7263oj();
        } catch (Throwable th) {
            m7263oj();
            throw th;
        }
    }

    /* renamed from: c */
    private void m7251c(List<C2156b> list, long j) {
        SQLiteDatabase al = m7248al("Error opening database for writeEntryToDatabase.");
        if (al != null) {
            for (C2156b next : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", next.f4605JH);
                contentValues.put("value", next.aoO);
                al.insert("datalayer", (String) null, contentValues);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: cv */
    public void m7252cv(String str) {
        SQLiteDatabase al = m7248al("Error opening database for clearKeysWithPrefix.");
        if (al != null) {
            try {
                C2028bh.m6818V("Cleared " + al.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
            } catch (SQLiteException e) {
                C2028bh.m6819W("Error deleting entries with key prefix: " + str + " (" + e + ").");
            } finally {
                m7263oj();
            }
        }
    }

    /* renamed from: ff */
    private void m7253ff(int i) {
        int oi = (m7262oi() - this.aoI) + i;
        if (oi > 0) {
            List<String> fg = m7254fg(oi);
            C2028bh.m6817U("DataLayer store full, deleting " + fg.size() + " entries to make room.");
            m7257i((String[]) fg.toArray(new String[0]));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0082  */
    /* renamed from: fg */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.lang.String> m7254fg(int r14) {
        /*
            r13 = this;
            r10 = 0
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            if (r14 > 0) goto L_0x000f
            java.lang.String r0 = "Invalid maxEntries specified. Skipping."
            com.google.android.gms.tagmanager.C2028bh.m6819W(r0)
            r0 = r9
        L_0x000e:
            return r0
        L_0x000f:
            java.lang.String r0 = "Error opening database for peekEntryIds."
            android.database.sqlite.SQLiteDatabase r0 = r13.m7248al(r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C2151v.m7254fg(int):java.util.List");
    }

    /* renamed from: h */
    private List<DataLayer.C1975a> m7255h(List<C2156b> list) {
        ArrayList arrayList = new ArrayList();
        for (C2156b next : list) {
            arrayList.add(new DataLayer.C1975a(next.f4605JH, m7258j(next.aoO)));
        }
        return arrayList;
    }

    /* renamed from: i */
    private List<C2156b> m7256i(List<DataLayer.C1975a> list) {
        ArrayList arrayList = new ArrayList();
        for (DataLayer.C1975a next : list) {
            arrayList.add(new C2156b(next.f4521JH, m7259m(next.f4522wq)));
        }
        return arrayList;
    }

    /* renamed from: i */
    private void m7257i(String[] strArr) {
        SQLiteDatabase al;
        if (strArr != null && strArr.length != 0 && (al = m7248al("Error opening database for deleteEntries.")) != null) {
            try {
                al.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
            } catch (SQLiteException e) {
                C2028bh.m6819W("Error deleting entries " + Arrays.toString(strArr));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0029 A[SYNTHETIC, Splitter:B:20:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0038 A[SYNTHETIC, Splitter:B:27:0x0038] */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object m7258j(byte[] r6) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C2151v.m7258j(byte[]):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002e A[SYNTHETIC, Splitter:B:20:0x002e] */
    /* renamed from: m */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m7259m(java.lang.Object r6) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C2151v.m7259m(java.lang.Object):byte[]");
    }

    /* access modifiers changed from: private */
    /* renamed from: og */
    public List<DataLayer.C1975a> m7260og() {
        try {
            m7265x(this.f4604yD.currentTimeMillis());
            return m7255h(m7261oh());
        } finally {
            m7263oj();
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: oh */
    private List<C2156b> m7261oh() {
        SQLiteDatabase al = m7248al("Error opening database for loadSerialized.");
        ArrayList arrayList = new ArrayList();
        if (al == null) {
            return arrayList;
        }
        Cursor query = al.query("datalayer", new String[]{"key", "value"}, (String) null, (String[]) null, (String) null, (String) null, "ID", (String) null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new C2156b(query.getString(0), query.getBlob(1)));
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        query.close();
        return arrayList;
    }

    /* renamed from: oi */
    private int m7262oi() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase al = m7248al("Error opening database for getNumStoredEntries.");
        if (al != null) {
            try {
                Cursor rawQuery = al.rawQuery("SELECT COUNT(*) from datalayer", (String[]) null);
                if (rawQuery.moveToFirst()) {
                    i = (int) rawQuery.getLong(0);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e) {
                C2028bh.m6819W("Error getting numStoredEntries");
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

    /* renamed from: oj */
    private void m7263oj() {
        try {
            this.aoH.close();
        } catch (SQLiteException e) {
        }
    }

    /* renamed from: x */
    private void m7265x(long j) {
        SQLiteDatabase al = m7248al("Error opening database for deleteOlderThan.");
        if (al != null) {
            try {
                C2028bh.m6818V("Deleted " + al.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
            } catch (SQLiteException e) {
                C2028bh.m6819W("Error deleting old entries.");
            }
        }
    }

    /* renamed from: a */
    public void mo11503a(final DataLayer.C1977c.C1978a aVar) {
        this.aoG.execute(new Runnable() {
            public void run() {
                aVar.mo11506g(C2151v.this.m7260og());
            }
        });
    }

    /* renamed from: a */
    public void mo11504a(List<DataLayer.C1975a> list, final long j) {
        final List<C2156b> i = m7256i(list);
        this.aoG.execute(new Runnable() {
            public void run() {
                C2151v.this.m7250b(i, j);
            }
        });
    }

    /* renamed from: cu */
    public void mo11505cu(final String str) {
        this.aoG.execute(new Runnable() {
            public void run() {
                C2151v.this.m7252cv(str);
            }
        });
    }
}
