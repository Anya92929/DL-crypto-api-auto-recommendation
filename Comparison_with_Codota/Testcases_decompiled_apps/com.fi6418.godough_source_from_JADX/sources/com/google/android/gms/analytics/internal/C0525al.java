package com.google.android.gms.analytics.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1009bf;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

/* renamed from: com.google.android.gms.analytics.internal.al */
class C0525al extends C0514aa implements Closeable {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f3739a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});

    /* renamed from: b */
    private static final String f3740b = String.format("SELECT MAX(%s) FROM %s WHERE 1;", new Object[]{"hit_time", "hits2"});

    /* renamed from: c */
    private final C0526am f3741c;

    /* renamed from: d */
    private final C0569q f3742d = new C0569q(mo6885n());
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final C0569q f3743e = new C0569q(mo6885n());

    C0525al(C0516ac acVar) {
        super(acVar);
        this.f3741c = new C0526am(this, acVar.mo6600b(), m3044G());
    }

    /* renamed from: F */
    private void m3043F() {
        int y = mo6888q().mo6755y();
        long e = mo6670e();
        if (e > ((long) (y - 1))) {
            List<Long> a = mo6657a((e - ((long) y)) + 1);
            mo6877d("Store full, deleting hits to make room, count", Integer.valueOf(a.size()));
            mo6662a(a);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: G */
    public String m3044G() {
        return !mo6888q().mo6731a() ? mo6888q().mo6724A() : mo6888q().mo6732b() ? mo6888q().mo6724A() : mo6888q().mo6725B();
    }

    /* renamed from: a */
    private long m3045a(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = mo6675i().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            mo6878d("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private long m3046a(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = mo6675i().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                j = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } else if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            mo6878d("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static String m3048a(Map<String, String> map) {
        C1009bf.m4528a(map);
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry next : map.entrySet()) {
            builder.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        String encodedQuery = builder.build().getEncodedQuery();
        return encodedQuery == null ? "" : encodedQuery;
    }

    /* renamed from: b */
    private String m3050b(C0556d dVar) {
        return dVar.mo6792f() ? mo6888q().mo6745o() : mo6888q().mo6746p();
    }

    /* renamed from: c */
    private static String m3051c(C0556d dVar) {
        C1009bf.m4528a(dVar);
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry next : dVar.mo6788b().entrySet()) {
            String str = (String) next.getKey();
            if (!"ht".equals(str) && !"qt".equals(str) && !"AppUID".equals(str)) {
                builder.appendQueryParameter(str, (String) next.getValue());
            }
        }
        String encodedQuery = builder.build().getEncodedQuery();
        return encodedQuery == null ? "" : encodedQuery;
    }

    /* renamed from: a */
    public long mo6656a(long j, String str, String str2) {
        C1009bf.m4530a(str);
        C1009bf.m4530a(str2);
        mo6596D();
        mo6884m();
        return m3046a("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j), str, str2}, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006e  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.Long> mo6657a(long r14) {
        /*
            r13 = this;
            r10 = 0
            r13.mo6884m()
            r13.mo6596D()
            r0 = 0
            int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0012
            java.util.List r0 = java.util.Collections.emptyList()
        L_0x0011:
            return r0
        L_0x0012:
            android.database.sqlite.SQLiteDatabase r0 = r13.mo6675i()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.lang.String r1 = "hits2"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x005e, all -> 0x006b }
            r3 = 0
            java.lang.String r4 = "hit_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x005e, all -> 0x006b }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "%s ASC"
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ SQLiteException -> 0x005e, all -> 0x006b }
            r11 = 0
            java.lang.String r12 = "hit_id"
            r8[r11] = r12     // Catch:{ SQLiteException -> 0x005e, all -> 0x006b }
            java.lang.String r7 = java.lang.String.format(r7, r8)     // Catch:{ SQLiteException -> 0x005e, all -> 0x006b }
            java.lang.String r8 = java.lang.Long.toString(r14)     // Catch:{ SQLiteException -> 0x005e, all -> 0x006b }
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x005e, all -> 0x006b }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0075 }
            if (r0 == 0) goto L_0x0057
        L_0x0045:
            r0 = 0
            long r2 = r1.getLong(r0)     // Catch:{ SQLiteException -> 0x0075 }
            java.lang.Long r0 = java.lang.Long.valueOf(r2)     // Catch:{ SQLiteException -> 0x0075 }
            r9.add(r0)     // Catch:{ SQLiteException -> 0x0075 }
            boolean r0 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0075 }
            if (r0 != 0) goto L_0x0045
        L_0x0057:
            if (r1 == 0) goto L_0x005c
            r1.close()
        L_0x005c:
            r0 = r9
            goto L_0x0011
        L_0x005e:
            r0 = move-exception
            r1 = r10
        L_0x0060:
            java.lang.String r2 = "Error selecting hit ids"
            r13.mo6877d(r2, r0)     // Catch:{ all -> 0x0072 }
            if (r1 == 0) goto L_0x005c
            r1.close()
            goto L_0x005c
        L_0x006b:
            r0 = move-exception
        L_0x006c:
            if (r10 == 0) goto L_0x0071
            r10.close()
        L_0x0071:
            throw r0
        L_0x0072:
            r0 = move-exception
            r10 = r1
            goto L_0x006c
        L_0x0075:
            r0 = move-exception
            goto L_0x0060
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.C0525al.mo6657a(long):java.util.List");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map<String, String> mo6658a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                str = "?" + str;
            }
            List<NameValuePair> parse = URLEncodedUtils.parse(new URI(str), "UTF-8");
            HashMap hashMap = new HashMap(parse.size());
            for (NameValuePair nameValuePair : parse) {
                hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
            return hashMap;
        } catch (URISyntaxException e) {
            mo6880e("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6598a() {
    }

    /* renamed from: a */
    public void mo6659a(long j, String str) {
        C1009bf.m4530a(str);
        mo6596D();
        mo6884m();
        int delete = mo6675i().delete("properties", "app_uid=? AND cid<>?", new String[]{String.valueOf(j), str});
        if (delete > 0) {
            mo6866a("Deleted property records", Integer.valueOf(delete));
        }
    }

    /* renamed from: a */
    public void mo6660a(C0519af afVar) {
        C1009bf.m4528a(afVar);
        mo6596D();
        mo6884m();
        SQLiteDatabase i = mo6675i();
        String a = m3048a(afVar.mo6645f());
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_uid", Long.valueOf(afVar.mo6639a()));
        contentValues.put("cid", afVar.mo6641b());
        contentValues.put("tid", afVar.mo6642c());
        contentValues.put("adid", Integer.valueOf(afVar.mo6643d() ? 1 : 0));
        contentValues.put("hits_count", Long.valueOf(afVar.mo6644e()));
        contentValues.put("params", a);
        try {
            if (i.insertWithOnConflict("properties", (String) null, contentValues, 5) == -1) {
                mo6881f("Failed to insert/update a property (got -1)");
            }
        } catch (SQLiteException e) {
            mo6880e("Error storing a property", e);
        }
    }

    /* renamed from: a */
    public void mo6661a(C0556d dVar) {
        C1009bf.m4528a(dVar);
        mo6884m();
        mo6596D();
        String c = m3051c(dVar);
        if (c.length() > 8192) {
            mo6887p().mo6804a(dVar, "Hit length exceeds the maximum allowed size");
            return;
        }
        m3043F();
        SQLiteDatabase i = mo6675i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", c);
        contentValues.put("hit_time", Long.valueOf(dVar.mo6790d()));
        contentValues.put("hit_app_id", Integer.valueOf(dVar.mo6787a()));
        contentValues.put("hit_url", m3050b(dVar));
        try {
            long insert = i.insert("hits2", (String) null, contentValues);
            if (insert == -1) {
                mo6881f("Failed to insert a hit (got -1)");
            } else {
                mo6871b("Hit saved to database. db-id, hit", Long.valueOf(insert), dVar);
            }
        } catch (SQLiteException e) {
            mo6880e("Error storing a hit", e);
        }
    }

    /* renamed from: a */
    public void mo6662a(List<Long> list) {
        C1009bf.m4528a(list);
        mo6884m();
        mo6596D();
        if (!list.isEmpty()) {
            StringBuilder sb = new StringBuilder("hit_id");
            sb.append(" in (");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    Long l = list.get(i2);
                    if (l != null && l.longValue() != 0) {
                        if (i2 > 0) {
                            sb.append(",");
                        }
                        sb.append(l);
                        i = i2 + 1;
                    }
                } else {
                    sb.append(")");
                    String sb2 = sb.toString();
                    try {
                        SQLiteDatabase i3 = mo6675i();
                        mo6866a("Deleting dispatched hits. count", Integer.valueOf(list.size()));
                        int delete = i3.delete("hits2", sb2, (String[]) null);
                        if (delete != list.size()) {
                            mo6872b("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(delete), sb2);
                            return;
                        }
                        return;
                    } catch (SQLiteException e) {
                        mo6880e("Error deleting hits", e);
                        throw e;
                    }
                }
            }
            throw new SQLiteException("Invalid hit id");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009e, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a2, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a5, code lost:
        r1 = r9;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a2 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x0019] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.analytics.internal.C0556d> mo6663b(long r14) {
        /*
            r13 = this;
            r0 = 1
            r1 = 0
            r9 = 0
            r2 = 0
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x008f
        L_0x0009:
            com.google.android.gms.common.internal.C1009bf.m4536b((boolean) r0)
            r13.mo6884m()
            r13.mo6596D()
            android.database.sqlite.SQLiteDatabase r0 = r13.mo6675i()
            java.lang.String r1 = "hits2"
            r2 = 5
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
            r3 = 0
            java.lang.String r4 = "hit_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
            r3 = 1
            java.lang.String r4 = "hit_time"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
            r3 = 2
            java.lang.String r4 = "hit_string"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
            r3 = 3
            java.lang.String r4 = "hit_url"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
            r3 = 4
            java.lang.String r4 = "hit_app_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "%s ASC"
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
            r10 = 0
            java.lang.String r11 = "hit_id"
            r8[r10] = r11     // Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
            java.lang.String r7 = java.lang.String.format(r7, r8)     // Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
            java.lang.String r8 = java.lang.Long.toString(r14)     // Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
            android.database.Cursor r9 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0092, all -> 0x00a2 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
            r10.<init>()     // Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
            boolean r0 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
            if (r0 == 0) goto L_0x0089
        L_0x0059:
            r0 = 0
            long r6 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
            r0 = 1
            long r3 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
            r0 = 2
            java.lang.String r0 = r9.getString(r0)     // Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
            r1 = 3
            java.lang.String r1 = r9.getString(r1)     // Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
            r2 = 4
            int r8 = r9.getInt(r2)     // Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
            java.util.Map r2 = r13.mo6658a((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
            boolean r5 = com.google.android.gms.analytics.internal.C0570r.m3339d(r1)     // Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
            com.google.android.gms.analytics.internal.d r0 = new com.google.android.gms.analytics.internal.d     // Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
            r1 = r13
            r0.<init>(r1, r2, r3, r5, r6, r8)     // Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
            r10.add(r0)     // Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
            boolean r0 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x00a4, all -> 0x00a2 }
            if (r0 != 0) goto L_0x0059
        L_0x0089:
            if (r9 == 0) goto L_0x008e
            r9.close()
        L_0x008e:
            return r10
        L_0x008f:
            r0 = r1
            goto L_0x0009
        L_0x0092:
            r0 = move-exception
            r1 = r9
        L_0x0094:
            java.lang.String r2 = "Error loading hits from the database"
            r13.mo6880e(r2, r0)     // Catch:{ all -> 0x009a }
            throw r0     // Catch:{ all -> 0x009a }
        L_0x009a:
            r0 = move-exception
            r9 = r1
        L_0x009c:
            if (r9 == 0) goto L_0x00a1
            r9.close()
        L_0x00a1:
            throw r0
        L_0x00a2:
            r0 = move-exception
            goto L_0x009c
        L_0x00a4:
            r0 = move-exception
            r1 = r9
            goto L_0x0094
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.C0525al.mo6663b(long):java.util.List");
    }

    /* renamed from: b */
    public void mo6664b() {
        mo6596D();
        mo6675i().beginTransaction();
    }

    /* renamed from: c */
    public void mo6665c() {
        mo6596D();
        mo6675i().setTransactionSuccessful();
    }

    /* renamed from: c */
    public void mo6666c(long j) {
        mo6884m();
        mo6596D();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        mo6866a("Deleting hit, id", Long.valueOf(j));
        mo6662a((List<Long>) arrayList);
    }

    public void close() {
        try {
            this.f3741c.close();
        } catch (SQLiteException e) {
            mo6880e("Sql error closing database", e);
        } catch (IllegalStateException e2) {
            mo6880e("Error closing database", e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b8, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ba, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00bb, code lost:
        r1 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b8 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x000c] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.analytics.internal.C0519af> mo6668d(long r14) {
        /*
            r13 = this;
            r13.mo6596D()
            r13.mo6884m()
            android.database.sqlite.SQLiteDatabase r0 = r13.mo6675i()
            r9 = 0
            r1 = 5
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
            r1 = 0
            java.lang.String r3 = "cid"
            r2[r1] = r3     // Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
            r1 = 1
            java.lang.String r3 = "tid"
            r2[r1] = r3     // Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
            r1 = 2
            java.lang.String r3 = "adid"
            r2[r1] = r3     // Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
            r1 = 3
            java.lang.String r3 = "hits_count"
            r2[r1] = r3     // Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
            r1 = 4
            java.lang.String r3 = "params"
            r2[r1] = r3     // Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
            com.google.android.gms.analytics.internal.bc r1 = r13.mo6888q()     // Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
            int r10 = r1.mo6756z()     // Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
            java.lang.String r8 = java.lang.String.valueOf(r10)     // Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
            java.lang.String r3 = "app_uid=?"
            r1 = 1
            java.lang.String[] r4 = new java.lang.String[r1]     // Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
            r1 = 0
            java.lang.String r5 = java.lang.String.valueOf(r14)     // Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
            r4[r1] = r5     // Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
            java.lang.String r1 = "properties"
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r9 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x00ba, all -> 0x00b8 }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
            r11.<init>()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
            boolean r0 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
            if (r0 == 0) goto L_0x008b
        L_0x0053:
            r0 = 0
            java.lang.String r3 = r9.getString(r0)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
            r0 = 1
            java.lang.String r4 = r9.getString(r0)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
            r0 = 2
            int r0 = r9.getInt(r0)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
            if (r0 == 0) goto L_0x009c
            r5 = 1
        L_0x0065:
            r0 = 3
            int r0 = r9.getInt(r0)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
            long r6 = (long) r0     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
            r0 = 4
            java.lang.String r0 = r9.getString(r0)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
            java.util.Map r8 = r13.mo6673g(r0)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
            if (r0 != 0) goto L_0x0080
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
            if (r0 == 0) goto L_0x009e
        L_0x0080:
            java.lang.String r0 = "Read property with empty client id or tracker id"
            r13.mo6875c(r0, r3, r4)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
        L_0x0085:
            boolean r0 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
            if (r0 != 0) goto L_0x0053
        L_0x008b:
            int r0 = r11.size()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
            if (r0 < r10) goto L_0x0096
            java.lang.String r0 = "Sending hits to too many properties. Campaign report might be incorrect"
            r13.mo6879e(r0)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
        L_0x0096:
            if (r9 == 0) goto L_0x009b
            r9.close()
        L_0x009b:
            return r11
        L_0x009c:
            r5 = 0
            goto L_0x0065
        L_0x009e:
            com.google.android.gms.analytics.internal.af r0 = new com.google.android.gms.analytics.internal.af     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
            r1 = r14
            r0.<init>(r1, r3, r4, r5, r6, r8)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
            r11.add(r0)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00b8 }
            goto L_0x0085
        L_0x00a8:
            r0 = move-exception
            r1 = r9
        L_0x00aa:
            java.lang.String r2 = "Error loading hits from the database"
            r13.mo6880e(r2, r0)     // Catch:{ all -> 0x00b0 }
            throw r0     // Catch:{ all -> 0x00b0 }
        L_0x00b0:
            r0 = move-exception
            r9 = r1
        L_0x00b2:
            if (r9 == 0) goto L_0x00b7
            r9.close()
        L_0x00b7:
            throw r0
        L_0x00b8:
            r0 = move-exception
            goto L_0x00b2
        L_0x00ba:
            r0 = move-exception
            r1 = r9
            goto L_0x00aa
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.C0525al.mo6668d(long):java.util.List");
    }

    /* renamed from: d */
    public void mo6669d() {
        mo6596D();
        mo6675i().endTransaction();
    }

    /* renamed from: e */
    public long mo6670e() {
        mo6884m();
        mo6596D();
        return m3045a("SELECT COUNT(*) FROM hits2", (String[]) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo6671f() {
        return mo6670e() == 0;
    }

    /* renamed from: g */
    public int mo6672g() {
        mo6884m();
        mo6596D();
        if (!this.f3742d.mo6834a(86400000)) {
            return 0;
        }
        this.f3742d.mo6833a();
        mo6869b("Deleting stale hits (if any)");
        int delete = mo6675i().delete("hits2", "hit_time < ?", new String[]{Long.toString(mo6885n().mo6990a() - 2592000000L)});
        mo6866a("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public Map<String, String> mo6673g(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            List<NameValuePair> parse = URLEncodedUtils.parse(new URI("?" + str), "UTF-8");
            HashMap hashMap = new HashMap(parse.size());
            for (NameValuePair nameValuePair : parse) {
                hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
            return hashMap;
        } catch (URISyntaxException e) {
            mo6880e("Error parsing property parameters", e);
            return new HashMap(0);
        }
    }

    /* renamed from: h */
    public long mo6674h() {
        mo6884m();
        mo6596D();
        return m3046a(f3740b, (String[]) null, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public SQLiteDatabase mo6675i() {
        try {
            return this.f3741c.getWritableDatabase();
        } catch (SQLiteException e) {
            mo6877d("Error opening database", e);
            throw e;
        }
    }
}
