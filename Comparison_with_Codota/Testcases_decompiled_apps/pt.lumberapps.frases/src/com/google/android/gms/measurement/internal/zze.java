package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.support.p009v4.p019f.C0136a;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzapo;
import com.google.android.gms.internal.zzuf;
import com.google.android.gms.internal.zzuh;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class zze extends C1923c {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Map f7270a = new C0136a(16);

    /* renamed from: b */
    private final C1891ai f7271b = new C1891ai(this, getContext(), mo9551i());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1887ae f7272c = new C1887ae(zzyw());

    public class zza {

        /* renamed from: a */
        long f7273a;

        /* renamed from: b */
        long f7274b;

        /* renamed from: c */
        long f7275c;

        /* renamed from: d */
        long f7276d;
    }

    static {
        f7270a.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        f7270a.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        f7270a.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        f7270a.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        f7270a.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
        f7270a.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
        f7270a.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
        f7270a.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
        f7270a.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
        f7270a.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
        f7270a.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
        f7270a.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
        f7270a.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
        f7270a.put("app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;");
        f7270a.put("firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;");
        f7270a.put("daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;");
    }

    zze(zzx zzx) {
        super(zzx);
    }

    @TargetApi(11)
    /* renamed from: a */
    static int m7828a(Cursor cursor, int i) {
        if (Build.VERSION.SDK_INT >= 11) {
            return cursor.getType(i);
        }
        CursorWindow window = ((SQLiteCursor) cursor).getWindow();
        int position = cursor.getPosition();
        if (window.isNull(position, i)) {
            return 0;
        }
        if (window.isLong(position, i)) {
            return 1;
        }
        if (window.isFloat(position, i)) {
            return 2;
        }
        if (window.isString(position, i)) {
            return 3;
        }
        return window.isBlob(position, i) ? 4 : -1;
    }

    /* renamed from: a */
    private long m7829a(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = mo9548h().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzbsd().zzbsv().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private long m7830a(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = mo9548h().rawQuery(str, strArr);
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
            zzbsd().zzbsv().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7832a(java.lang.String r8, com.google.android.gms.internal.zzuf.zza r9) {
        /*
            r7 = this;
            r0 = 0
            r7.mo9339c()
            r7.zzwu()
            com.google.android.gms.common.internal.zzab.zzhr(r8)
            com.google.android.gms.common.internal.zzab.zzy(r9)
            com.google.android.gms.internal.zzuf$zzb[] r1 = r9.amB
            com.google.android.gms.common.internal.zzab.zzy(r1)
            com.google.android.gms.internal.zzuf$zze[] r1 = r9.amA
            com.google.android.gms.common.internal.zzab.zzy(r1)
            java.lang.Integer r1 = r9.amz
            if (r1 != 0) goto L_0x0029
            com.google.android.gms.measurement.internal.zzp r0 = r7.zzbsd()
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzbsx()
            java.lang.String r1 = "Audience with no ID"
            r0.log(r1)
        L_0x0028:
            return
        L_0x0029:
            java.lang.Integer r1 = r9.amz
            int r3 = r1.intValue()
            com.google.android.gms.internal.zzuf$zzb[] r2 = r9.amB
            int r4 = r2.length
            r1 = r0
        L_0x0033:
            if (r1 >= r4) goto L_0x004e
            r5 = r2[r1]
            java.lang.Integer r5 = r5.amD
            if (r5 != 0) goto L_0x004b
            com.google.android.gms.measurement.internal.zzp r0 = r7.zzbsd()
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzbsx()
            java.lang.String r1 = "Event filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Integer r2 = r9.amz
            r0.zze(r1, r8, r2)
            goto L_0x0028
        L_0x004b:
            int r1 = r1 + 1
            goto L_0x0033
        L_0x004e:
            com.google.android.gms.internal.zzuf$zze[] r2 = r9.amA
            int r4 = r2.length
            r1 = r0
        L_0x0052:
            if (r1 >= r4) goto L_0x006d
            r5 = r2[r1]
            java.lang.Integer r5 = r5.amD
            if (r5 != 0) goto L_0x006a
            com.google.android.gms.measurement.internal.zzp r0 = r7.zzbsd()
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzbsx()
            java.lang.String r1 = "Property filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Integer r2 = r9.amz
            r0.zze(r1, r8, r2)
            goto L_0x0028
        L_0x006a:
            int r1 = r1 + 1
            goto L_0x0052
        L_0x006d:
            r1 = 1
            com.google.android.gms.internal.zzuf$zzb[] r4 = r9.amB
            int r5 = r4.length
            r2 = r0
        L_0x0072:
            if (r2 >= r5) goto L_0x007d
            r6 = r4[r2]
            boolean r6 = r7.m7833a((java.lang.String) r8, (int) r3, (com.google.android.gms.internal.zzuf.zzb) r6)
            if (r6 != 0) goto L_0x0093
            r1 = r0
        L_0x007d:
            if (r1 == 0) goto L_0x0099
            com.google.android.gms.internal.zzuf$zze[] r4 = r9.amA
            int r5 = r4.length
            r2 = r0
        L_0x0083:
            if (r2 >= r5) goto L_0x0099
            r6 = r4[r2]
            boolean r6 = r7.m7834a((java.lang.String) r8, (int) r3, (com.google.android.gms.internal.zzuf.zze) r6)
            if (r6 != 0) goto L_0x0096
        L_0x008d:
            if (r0 != 0) goto L_0x0028
            r7.mo9535b((java.lang.String) r8, (int) r3)
            goto L_0x0028
        L_0x0093:
            int r2 = r2 + 1
            goto L_0x0072
        L_0x0096:
            int r2 = r2 + 1
            goto L_0x0083
        L_0x0099:
            r0 = r1
            goto L_0x008d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.m7832a(java.lang.String, com.google.android.gms.internal.zzuf$zza):void");
    }

    /* renamed from: a */
    private boolean m7833a(String str, int i, zzuf.zzb zzb) {
        mo9339c();
        zzwu();
        zzab.zzhr(str);
        zzab.zzy(zzb);
        if (TextUtils.isEmpty(zzb.amE)) {
            zzbsd().zzbsx().zze("Event filter had no event name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(zzb.amD));
            return false;
        }
        try {
            byte[] bArr = new byte[zzb.mo8049aM()];
            zzapo zzbe = zzapo.zzbe(bArr);
            zzb.zza(zzbe);
            zzbe.mo7988az();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzb.amD);
            contentValues.put("event_name", zzb.amE);
            contentValues.put("data", bArr);
            try {
                if (mo9548h().insertWithOnConflict("event_filters", (String) null, contentValues, 5) == -1) {
                    zzbsd().zzbsv().log("Failed to insert event filter (got -1)");
                }
                return true;
            } catch (SQLiteException e) {
                zzbsd().zzbsv().zzj("Error storing event filter", e);
                return false;
            }
        } catch (IOException e2) {
            zzbsd().zzbsv().zzj("Configuration loss. Failed to serialize event filter", e2);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m7834a(String str, int i, zzuf.zze zze) {
        mo9339c();
        zzwu();
        zzab.zzhr(str);
        zzab.zzy(zze);
        if (TextUtils.isEmpty(zze.amT)) {
            zzbsd().zzbsx().zze("Property filter had no property name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(zze.amD));
            return false;
        }
        try {
            byte[] bArr = new byte[zze.mo8049aM()];
            zzapo zzbe = zzapo.zzbe(bArr);
            zze.zza(zzbe);
            zzbe.mo7988az();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zze.amD);
            contentValues.put("property_name", zze.amT);
            contentValues.put("data", bArr);
            try {
                if (mo9548h().insertWithOnConflict("property_filters", (String) null, contentValues, 5) != -1) {
                    return true;
                }
                zzbsd().zzbsv().log("Failed to insert property filter (got -1)");
                return false;
            } catch (SQLiteException e) {
                zzbsd().zzbsv().zzj("Error storing property filter", e);
                return false;
            }
        } catch (IOException e2) {
            zzbsd().zzbsv().zzj("Configuration loss. Failed to serialize property filter", e2);
            return false;
        }
    }

    /* renamed from: q */
    private boolean m7836q() {
        return getContext().getDatabasePath(mo9551i()).exists();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x008c  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.measurement.internal.C1894al mo9514a(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r10 = 0
            com.google.android.gms.common.internal.zzab.zzhr(r13)
            com.google.android.gms.common.internal.zzab.zzhr(r14)
            r12.zzwu()
            r12.mo9339c()
            android.database.sqlite.SQLiteDatabase r0 = r12.mo9548h()     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            java.lang.String r1 = "events"
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            r3 = 0
            java.lang.String r4 = "lifetime_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            r3 = 1
            java.lang.String r4 = "current_bundle_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            r3 = 2
            java.lang.String r4 = "last_fire_timestamp"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            java.lang.String r3 = "app_id=? and name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            r5 = 0
            r4[r5] = r13     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            r5 = 1
            r4[r5] = r14     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            if (r0 != 0) goto L_0x0044
            if (r11 == 0) goto L_0x0042
            r11.close()
        L_0x0042:
            r1 = r10
        L_0x0043:
            return r1
        L_0x0044:
            r0 = 0
            long r4 = r11.getLong(r0)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            r0 = 1
            long r6 = r11.getLong(r0)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            r0 = 2
            long r8 = r11.getLong(r0)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            com.google.android.gms.measurement.internal.al r1 = new com.google.android.gms.measurement.internal.al     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            r2 = r13
            r3 = r14
            r1.<init>(r2, r3, r4, r6, r8)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            if (r0 == 0) goto L_0x006d
            com.google.android.gms.measurement.internal.zzp r0 = r12.zzbsd()     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzbsv()     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            java.lang.String r2 = "Got multiple records for event aggregates, expected one"
            r0.log(r2)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
        L_0x006d:
            if (r11 == 0) goto L_0x0043
            r11.close()
            goto L_0x0043
        L_0x0073:
            r0 = move-exception
            r1 = r10
        L_0x0075:
            com.google.android.gms.measurement.internal.zzp r2 = r12.zzbsd()     // Catch:{ all -> 0x0093 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbsv()     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = "Error querying events"
            r2.zzd(r3, r13, r14, r0)     // Catch:{ all -> 0x0093 }
            if (r1 == 0) goto L_0x0087
            r1.close()
        L_0x0087:
            r1 = r10
            goto L_0x0043
        L_0x0089:
            r0 = move-exception
        L_0x008a:
            if (r10 == 0) goto L_0x008f
            r10.close()
        L_0x008f:
            throw r0
        L_0x0090:
            r0 = move-exception
            r10 = r11
            goto L_0x008a
        L_0x0093:
            r0 = move-exception
            r10 = r1
            goto L_0x008a
        L_0x0096:
            r0 = move-exception
            r1 = r11
            goto L_0x0075
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.mo9514a(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.al");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x010b  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.measurement.internal.zze.zza mo9515a(long r12, java.lang.String r14, boolean r15, boolean r16, boolean r17) {
        /*
            r11 = this;
            com.google.android.gms.common.internal.zzab.zzhr(r14)
            r11.zzwu()
            r11.mo9339c()
            r0 = 1
            java.lang.String[] r10 = new java.lang.String[r0]
            r0 = 0
            r10[r0] = r14
            com.google.android.gms.measurement.internal.zze$zza r8 = new com.google.android.gms.measurement.internal.zze$zza
            r8.<init>()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r0 = r11.mo9548h()     // Catch:{ SQLiteException -> 0x00f0, all -> 0x0107 }
            java.lang.String r1 = "apps"
            r2 = 5
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00f0, all -> 0x0107 }
            r3 = 0
            java.lang.String r4 = "day"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00f0, all -> 0x0107 }
            r3 = 1
            java.lang.String r4 = "daily_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00f0, all -> 0x0107 }
            r3 = 2
            java.lang.String r4 = "daily_public_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00f0, all -> 0x0107 }
            r3 = 3
            java.lang.String r4 = "daily_conversions_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00f0, all -> 0x0107 }
            r3 = 4
            java.lang.String r4 = "daily_error_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00f0, all -> 0x0107 }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00f0, all -> 0x0107 }
            r5 = 0
            r4[r5] = r14     // Catch:{ SQLiteException -> 0x00f0, all -> 0x0107 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x00f0, all -> 0x0107 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0111 }
            if (r2 != 0) goto L_0x0060
            com.google.android.gms.measurement.internal.zzp r0 = r11.zzbsd()     // Catch:{ SQLiteException -> 0x0111 }
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzbsx()     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.String r2 = "Not updating daily counts, app is not known"
            r0.zzj(r2, r14)     // Catch:{ SQLiteException -> 0x0111 }
            if (r1 == 0) goto L_0x005e
            r1.close()
        L_0x005e:
            r0 = r8
        L_0x005f:
            return r0
        L_0x0060:
            r2 = 0
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x0111 }
            int r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x0085
            r2 = 1
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x0111 }
            r8.f7274b = r2     // Catch:{ SQLiteException -> 0x0111 }
            r2 = 2
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x0111 }
            r8.f7273a = r2     // Catch:{ SQLiteException -> 0x0111 }
            r2 = 3
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x0111 }
            r8.f7275c = r2     // Catch:{ SQLiteException -> 0x0111 }
            r2 = 4
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x0111 }
            r8.f7276d = r2     // Catch:{ SQLiteException -> 0x0111 }
        L_0x0085:
            long r2 = r8.f7274b     // Catch:{ SQLiteException -> 0x0111 }
            r4 = 1
            long r2 = r2 + r4
            r8.f7274b = r2     // Catch:{ SQLiteException -> 0x0111 }
            if (r15 == 0) goto L_0x0095
            long r2 = r8.f7273a     // Catch:{ SQLiteException -> 0x0111 }
            r4 = 1
            long r2 = r2 + r4
            r8.f7273a = r2     // Catch:{ SQLiteException -> 0x0111 }
        L_0x0095:
            if (r16 == 0) goto L_0x009e
            long r2 = r8.f7275c     // Catch:{ SQLiteException -> 0x0111 }
            r4 = 1
            long r2 = r2 + r4
            r8.f7275c = r2     // Catch:{ SQLiteException -> 0x0111 }
        L_0x009e:
            if (r17 == 0) goto L_0x00a7
            long r2 = r8.f7276d     // Catch:{ SQLiteException -> 0x0111 }
            r4 = 1
            long r2 = r2 + r4
            r8.f7276d = r2     // Catch:{ SQLiteException -> 0x0111 }
        L_0x00a7:
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x0111 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.String r3 = "day"
            java.lang.Long r4 = java.lang.Long.valueOf(r12)     // Catch:{ SQLiteException -> 0x0111 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.String r3 = "daily_public_events_count"
            long r4 = r8.f7273a     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0111 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.String r3 = "daily_events_count"
            long r4 = r8.f7274b     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0111 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.String r3 = "daily_conversions_count"
            long r4 = r8.f7275c     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0111 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.String r3 = "daily_error_events_count"
            long r4 = r8.f7276d     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0111 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x0111 }
            java.lang.String r3 = "apps"
            java.lang.String r4 = "app_id=?"
            r0.update(r3, r2, r4, r10)     // Catch:{ SQLiteException -> 0x0111 }
            if (r1 == 0) goto L_0x00ed
            r1.close()
        L_0x00ed:
            r0 = r8
            goto L_0x005f
        L_0x00f0:
            r0 = move-exception
            r1 = r9
        L_0x00f2:
            com.google.android.gms.measurement.internal.zzp r2 = r11.zzbsd()     // Catch:{ all -> 0x010f }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbsv()     // Catch:{ all -> 0x010f }
            java.lang.String r3 = "Error updating daily counts"
            r2.zzj(r3, r0)     // Catch:{ all -> 0x010f }
            if (r1 == 0) goto L_0x0104
            r1.close()
        L_0x0104:
            r0 = r8
            goto L_0x005f
        L_0x0107:
            r0 = move-exception
            r1 = r9
        L_0x0109:
            if (r1 == 0) goto L_0x010e
            r1.close()
        L_0x010e:
            throw r0
        L_0x010f:
            r0 = move-exception
            goto L_0x0109
        L_0x0111:
            r0 = move-exception
            goto L_0x00f2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.mo9515a(long, java.lang.String, boolean, boolean, boolean):com.google.android.gms.measurement.internal.zze$zza");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x009e  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List mo9516a(java.lang.String r12) {
        /*
            r11 = this;
            r10 = 0
            com.google.android.gms.common.internal.zzab.zzhr(r12)
            r11.zzwu()
            r11.mo9339c()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r11.mo9548h()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            java.lang.String r1 = "user_attributes"
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            r3 = 0
            java.lang.String r4 = "name"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            r3 = 1
            java.lang.String r4 = "set_timestamp"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            r3 = 2
            java.lang.String r4 = "value"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            r5 = 0
            r4[r5] = r12     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            r5 = 0
            r6 = 0
            java.lang.String r7 = "rowid"
            com.google.android.gms.measurement.internal.zzd r8 = r11.zzbsf()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            int r8 = r8.mo9472g()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            boolean r0 = r7.moveToFirst()     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            if (r0 != 0) goto L_0x0050
            if (r7 == 0) goto L_0x004e
            r7.close()
        L_0x004e:
            r0 = r9
        L_0x004f:
            return r0
        L_0x0050:
            r0 = 0
            java.lang.String r3 = r7.getString(r0)     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            r0 = 1
            long r4 = r7.getLong(r0)     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            r0 = 2
            java.lang.Object r6 = r11.mo9533b((android.database.Cursor) r7, (int) r0)     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            if (r6 != 0) goto L_0x007b
            com.google.android.gms.measurement.internal.zzp r0 = r11.zzbsd()     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzbsv()     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            java.lang.String r1 = "Read invalid user property value, ignoring it"
            r0.log(r1)     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
        L_0x006e:
            boolean r0 = r7.moveToNext()     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            if (r0 != 0) goto L_0x0050
            if (r7 == 0) goto L_0x0079
            r7.close()
        L_0x0079:
            r0 = r9
            goto L_0x004f
        L_0x007b:
            com.google.android.gms.measurement.internal.af r1 = new com.google.android.gms.measurement.internal.af     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            r2 = r12
            r1.<init>(r2, r3, r4, r6)     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            r9.add(r1)     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            goto L_0x006e
        L_0x0085:
            r0 = move-exception
            r1 = r7
        L_0x0087:
            com.google.android.gms.measurement.internal.zzp r2 = r11.zzbsd()     // Catch:{ all -> 0x00a5 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbsv()     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = "Error querying user properties"
            r2.zze(r3, r12, r0)     // Catch:{ all -> 0x00a5 }
            if (r1 == 0) goto L_0x0099
            r1.close()
        L_0x0099:
            r0 = r10
            goto L_0x004f
        L_0x009b:
            r0 = move-exception
        L_0x009c:
            if (r10 == 0) goto L_0x00a1
            r10.close()
        L_0x00a1:
            throw r0
        L_0x00a2:
            r0 = move-exception
            r10 = r7
            goto L_0x009c
        L_0x00a5:
            r0 = move-exception
            r10 = r1
            goto L_0x009c
        L_0x00a8:
            r0 = move-exception
            r1 = r10
            goto L_0x0087
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.mo9516a(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00de  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List mo9517a(java.lang.String r12, int r13, int r14) {
        /*
            r11 = this;
            r10 = 0
            r1 = 1
            r9 = 0
            r11.zzwu()
            r11.mo9339c()
            if (r13 <= 0) goto L_0x004e
            r0 = r1
        L_0x000c:
            com.google.android.gms.common.internal.zzab.zzbo(r0)
            if (r14 <= 0) goto L_0x0050
        L_0x0011:
            com.google.android.gms.common.internal.zzab.zzbo(r1)
            com.google.android.gms.common.internal.zzab.zzhr(r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.mo9548h()     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            java.lang.String r1 = "queue"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            r3 = 0
            java.lang.String r4 = "rowid"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            r3 = 1
            java.lang.String r4 = "data"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            r5 = 0
            r4[r5] = r12     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            r5 = 0
            r6 = 0
            java.lang.String r7 = "rowid"
            java.lang.String r8 = java.lang.String.valueOf(r13)     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            if (r0 != 0) goto L_0x0052
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            if (r2 == 0) goto L_0x004d
            r2.close()
        L_0x004d:
            return r0
        L_0x004e:
            r0 = r9
            goto L_0x000c
        L_0x0050:
            r1 = r9
            goto L_0x0011
        L_0x0052:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            r1.<init>()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            r3 = r9
        L_0x0058:
            r0 = 0
            long r4 = r2.getLong(r0)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            r0 = 1
            byte[] r0 = r2.getBlob(r0)     // Catch:{ IOException -> 0x007b }
            com.google.android.gms.measurement.internal.zzal r6 = r11.zzbrz()     // Catch:{ IOException -> 0x007b }
            byte[] r6 = r6.zzw(r0)     // Catch:{ IOException -> 0x007b }
            boolean r0 = r1.isEmpty()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            if (r0 != 0) goto L_0x0094
            int r0 = r6.length     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            int r0 = r0 + r3
            if (r0 <= r14) goto L_0x0094
        L_0x0074:
            if (r2 == 0) goto L_0x0079
            r2.close()
        L_0x0079:
            r0 = r1
            goto L_0x004d
        L_0x007b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzp r4 = r11.zzbsd()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            com.google.android.gms.measurement.internal.zzp$zza r4 = r4.zzbsv()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            java.lang.String r5 = "Failed to unzip queued bundle"
            r4.zze(r5, r12, r0)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            r0 = r3
        L_0x008a:
            boolean r3 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            if (r3 == 0) goto L_0x0074
            if (r0 > r14) goto L_0x0074
            r3 = r0
            goto L_0x0058
        L_0x0094:
            com.google.android.gms.internal.zzapn r0 = com.google.android.gms.internal.zzapn.zzbd(r6)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            com.google.android.gms.internal.zzuh$zze r7 = new com.google.android.gms.internal.zzuh$zze     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            r7.<init>()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            com.google.android.gms.internal.zzapv r0 = r7.zzb(r0)     // Catch:{ IOException -> 0x00ca }
            com.google.android.gms.internal.zzuh$zze r0 = (com.google.android.gms.internal.zzuh.zze) r0     // Catch:{ IOException -> 0x00ca }
            int r0 = r6.length     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            int r0 = r0 + r3
            java.lang.Long r3 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            android.util.Pair r3 = android.util.Pair.create(r7, r3)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            r1.add(r3)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            goto L_0x008a
        L_0x00b1:
            r0 = move-exception
            r1 = r2
        L_0x00b3:
            com.google.android.gms.measurement.internal.zzp r2 = r11.zzbsd()     // Catch:{ all -> 0x00e4 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbsv()     // Catch:{ all -> 0x00e4 }
            java.lang.String r3 = "Error querying bundles"
            r2.zze(r3, r12, r0)     // Catch:{ all -> 0x00e4 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x00e4 }
            if (r1 == 0) goto L_0x004d
            r1.close()
            goto L_0x004d
        L_0x00ca:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzp r4 = r11.zzbsd()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            com.google.android.gms.measurement.internal.zzp$zza r4 = r4.zzbsv()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            java.lang.String r5 = "Failed to merge queued bundle"
            r4.zze(r5, r12, r0)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            r0 = r3
            goto L_0x008a
        L_0x00da:
            r0 = move-exception
            r2 = r10
        L_0x00dc:
            if (r2 == 0) goto L_0x00e1
            r2.close()
        L_0x00e1:
            throw r0
        L_0x00e2:
            r0 = move-exception
            goto L_0x00dc
        L_0x00e4:
            r0 = move-exception
            r2 = r1
            goto L_0x00dc
        L_0x00e7:
            r0 = move-exception
            r1 = r10
            goto L_0x00b3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.mo9517a(java.lang.String, int, int):java.util.List");
    }

    /* renamed from: a */
    public void mo9518a(long j) {
        zzwu();
        mo9339c();
        if (mo9548h().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) != 1) {
            zzbsd().zzbsv().log("Deleted fewer rows from queue than expected");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9519a(ContentValues contentValues, String str, Object obj) {
        zzab.zzhr(str);
        zzab.zzy(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    /* renamed from: a */
    public void mo9520a(zzuh.zze zze) {
        zzwu();
        mo9339c();
        zzab.zzy(zze);
        zzab.zzhr(zze.zzck);
        zzab.zzy(zze.anz);
        mo9553k();
        long currentTimeMillis = zzyw().currentTimeMillis();
        if (zze.anz.longValue() < currentTimeMillis - zzbsf().zzbrf() || zze.anz.longValue() > zzbsf().zzbrf() + currentTimeMillis) {
            zzbsd().zzbsx().zze("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(currentTimeMillis), zze.anz);
        }
        try {
            byte[] bArr = new byte[zze.mo8049aM()];
            zzapo zzbe = zzapo.zzbe(bArr);
            zze.zza(zzbe);
            zzbe.mo7988az();
            byte[] zzj = zzbrz().zzj(bArr);
            zzbsd().zzbtc().zzj("Saving bundle, size", Integer.valueOf(zzj.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zze.zzck);
            contentValues.put("bundle_end_timestamp", zze.anz);
            contentValues.put("data", zzj);
            try {
                if (mo9548h().insert("queue", (String) null, contentValues) == -1) {
                    zzbsd().zzbsv().log("Failed to insert bundle (got -1)");
                }
            } catch (SQLiteException e) {
                zzbsd().zzbsv().zzj("Error storing bundle", e);
            }
        } catch (IOException e2) {
            zzbsd().zzbsv().zzj("Data loss. Failed to serialize bundle", e2);
        }
    }

    /* renamed from: a */
    public void mo9521a(C1894al alVar) {
        zzab.zzy(alVar);
        zzwu();
        mo9339c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", alVar.f7092a);
        contentValues.put("name", alVar.f7093b);
        contentValues.put("lifetime_count", Long.valueOf(alVar.f7094c));
        contentValues.put("current_bundle_count", Long.valueOf(alVar.f7095d));
        contentValues.put("last_fire_timestamp", Long.valueOf(alVar.f7096e));
        try {
            if (mo9548h().insertWithOnConflict("events", (String) null, contentValues, 5) == -1) {
                zzbsd().zzbsv().log("Failed to insert/update event aggregates (got -1)");
            }
        } catch (SQLiteException e) {
            zzbsd().zzbsv().zzj("Error storing event aggregates", e);
        }
    }

    /* renamed from: a */
    public void mo9522a(C1909b bVar) {
        zzab.zzy(bVar);
        zzwu();
        mo9339c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", bVar.mo9268b());
        contentValues.put("app_instance_id", bVar.mo9271c());
        contentValues.put("gmp_app_id", bVar.mo9274d());
        contentValues.put("resettable_device_id_hash", bVar.mo9277e());
        contentValues.put("last_bundle_index", Long.valueOf(bVar.mo9298o()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(bVar.mo9283g()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(bVar.mo9285h()));
        contentValues.put("app_version", bVar.mo9287i());
        contentValues.put("app_store", bVar.mo9291k());
        contentValues.put("gmp_version", Long.valueOf(bVar.mo9293l()));
        contentValues.put("dev_cert_hash", Long.valueOf(bVar.mo9295m()));
        contentValues.put("measurement_enabled", Boolean.valueOf(bVar.mo9297n()));
        contentValues.put("day", Long.valueOf(bVar.mo9302s()));
        contentValues.put("daily_public_events_count", Long.valueOf(bVar.mo9303t()));
        contentValues.put("daily_events_count", Long.valueOf(bVar.mo9304u()));
        contentValues.put("daily_conversions_count", Long.valueOf(bVar.mo9305v()));
        contentValues.put("config_fetched_time", Long.valueOf(bVar.mo9299p()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(bVar.mo9300q()));
        contentValues.put("app_version_int", Long.valueOf(bVar.mo9289j()));
        contentValues.put("firebase_instance_id", bVar.mo9280f());
        contentValues.put("daily_error_events_count", Long.valueOf(bVar.mo9306w()));
        try {
            if (mo9548h().insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                zzbsd().zzbsv().log("Failed to insert/update app (got -1)");
            }
        } catch (SQLiteException e) {
            zzbsd().zzbsv().zzj("Error storing app", e);
        }
    }

    /* renamed from: a */
    public void mo9523a(zzh zzh, long j) {
        zzwu();
        mo9339c();
        zzab.zzy(zzh);
        zzab.zzhr(zzh.f7280a);
        zzuh.zzb zzb = new zzuh.zzb();
        zzb.anp = Long.valueOf(zzh.f7284e);
        zzb.ann = new zzuh.zzc[zzh.f7285f.size()];
        Iterator it = zzh.f7285f.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            zzuh.zzc zzc = new zzuh.zzc();
            zzb.ann[i] = zzc;
            zzc.name = str;
            zzbrz().zza(zzc, zzh.f7285f.mo9201a(str));
            i++;
        }
        try {
            byte[] bArr = new byte[zzb.mo8049aM()];
            zzapo zzbe = zzapo.zzbe(bArr);
            zzb.zza(zzbe);
            zzbe.mo7988az();
            zzbsd().zzbtc().zze("Saving event, name, data size", zzh.f7281b, Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzh.f7280a);
            contentValues.put("name", zzh.f7281b);
            contentValues.put("timestamp", Long.valueOf(zzh.f7283d));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            try {
                if (mo9548h().insert("raw_events", (String) null, contentValues) == -1) {
                    zzbsd().zzbsv().log("Failed to insert raw event (got -1)");
                }
            } catch (SQLiteException e) {
                zzbsd().zzbsv().zzj("Error storing raw event", e);
            }
        } catch (IOException e2) {
            zzbsd().zzbsv().zzj("Data loss. Failed to serialize event params/data", e2);
        }
    }

    /* renamed from: a */
    public void mo9524a(String str, int i) {
        zzab.zzhr(str);
        zzwu();
        mo9339c();
        try {
            mo9548h().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(i)});
        } catch (SQLiteException e) {
            zzbsd().zzbsv().zze("Error pruning currencies", str, e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9525a(String str, int i, zzuh.zzf zzf) {
        mo9339c();
        zzwu();
        zzab.zzhr(str);
        zzab.zzy(zzf);
        try {
            byte[] bArr = new byte[zzf.mo8049aM()];
            zzapo zzbe = zzapo.zzbe(bArr);
            zzf.zza(zzbe);
            zzbe.mo7988az();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("current_results", bArr);
            try {
                if (mo9548h().insertWithOnConflict("audience_filter_values", (String) null, contentValues, 5) == -1) {
                    zzbsd().zzbsv().log("Failed to insert filter results (got -1)");
                }
            } catch (SQLiteException e) {
                zzbsd().zzbsv().zzj("Error storing filter results", e);
            }
        } catch (IOException e2) {
            zzbsd().zzbsv().zzj("Configuration loss. Failed to serialize filter results", e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:72:0x017a, code lost:
        r2 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x017a A[ExcHandler: SQLiteException (e android.database.sqlite.SQLiteException), Splitter:B:1:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0193  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo9526a(java.lang.String r15, long r16, com.google.android.gms.measurement.internal.C1890ah r18) {
        /*
            r14 = this;
            r3 = 0
            com.google.android.gms.common.internal.zzab.zzy(r18)
            r14.zzwu()
            r14.mo9339c()
            android.database.sqlite.SQLiteDatabase r2 = r14.mo9548h()     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            boolean r4 = android.text.TextUtils.isEmpty(r15)     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            if (r4 == 0) goto L_0x0077
            java.lang.String r4 = "select app_id, metadata_fingerprint from raw_events where app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            r6 = 0
            java.lang.String r7 = java.lang.String.valueOf(r16)     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            r5[r6] = r7     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            android.database.Cursor r3 = r2.rawQuery(r4, r5)     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x017a }
            if (r4 != 0) goto L_0x0030
            if (r3 == 0) goto L_0x002f
            r3.close()
        L_0x002f:
            return
        L_0x0030:
            r4 = 0
            java.lang.String r15 = r3.getString(r4)     // Catch:{ SQLiteException -> 0x017a }
            r4 = 1
            java.lang.String r4 = r3.getString(r4)     // Catch:{ SQLiteException -> 0x017a }
            r3.close()     // Catch:{ SQLiteException -> 0x017a }
            r12 = r4
            r11 = r3
        L_0x003f:
            java.lang.String r3 = "raw_events_metadata"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r5 = 0
            java.lang.String r6 = "metadata"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            java.lang.String r5 = "app_id=? and metadata_fingerprint=?"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r7 = 0
            r6[r7] = r15     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r7 = 1
            r6[r7] = r12     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "2"
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            boolean r3 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            if (r3 != 0) goto L_0x009a
            com.google.android.gms.measurement.internal.zzp r2 = r14.zzbsd()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbsv()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            java.lang.String r3 = "Raw event metadata record is missing"
            r2.log(r3)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            if (r11 == 0) goto L_0x002f
            r11.close()
            goto L_0x002f
        L_0x0077:
            java.lang.String r4 = "select metadata_fingerprint from raw_events where app_id = ? order by rowid limit 1;"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            r6 = 0
            r5[r6] = r15     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            android.database.Cursor r3 = r2.rawQuery(r4, r5)     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x017a }
            if (r4 != 0) goto L_0x008f
            if (r3 == 0) goto L_0x002f
            r3.close()
            goto L_0x002f
        L_0x008f:
            r4 = 0
            java.lang.String r4 = r3.getString(r4)     // Catch:{ SQLiteException -> 0x017a }
            r3.close()     // Catch:{ SQLiteException -> 0x017a }
            r12 = r4
            r11 = r3
            goto L_0x003f
        L_0x009a:
            r3 = 0
            byte[] r3 = r11.getBlob(r3)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            com.google.android.gms.internal.zzapn r3 = com.google.android.gms.internal.zzapn.zzbd(r3)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            com.google.android.gms.internal.zzuh$zze r4 = new com.google.android.gms.internal.zzuh$zze     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r4.<init>()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            com.google.android.gms.internal.zzapv r3 = r4.zzb(r3)     // Catch:{ IOException -> 0x0110 }
            com.google.android.gms.internal.zzuh$zze r3 = (com.google.android.gms.internal.zzuh.zze) r3     // Catch:{ IOException -> 0x0110 }
            boolean r3 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            if (r3 == 0) goto L_0x00c1
            com.google.android.gms.measurement.internal.zzp r3 = r14.zzbsd()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzbsx()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            java.lang.String r5 = "Get multiple raw event metadata records, expected one"
            r3.log(r5)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
        L_0x00c1:
            r11.close()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r0 = r18
            r0.mo9227a(r4)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            java.lang.String r3 = "raw_events"
            r4 = 4
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r5 = 0
            java.lang.String r6 = "rowid"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r5 = 1
            java.lang.String r6 = "name"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r5 = 2
            java.lang.String r6 = "timestamp"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r5 = 3
            java.lang.String r6 = "data"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            java.lang.String r5 = "app_id=? and metadata_fingerprint=?"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r7 = 0
            r6[r7] = r15     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r7 = 1
            r6[r7] = r12     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            r10 = 0
            android.database.Cursor r3 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            boolean r2 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x017a }
            if (r2 != 0) goto L_0x0125
            com.google.android.gms.measurement.internal.zzp r2 = r14.zzbsd()     // Catch:{ SQLiteException -> 0x017a }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbsx()     // Catch:{ SQLiteException -> 0x017a }
            java.lang.String r4 = "Raw event data disappeared while in transaction"
            r2.log(r4)     // Catch:{ SQLiteException -> 0x017a }
            if (r3 == 0) goto L_0x002f
            r3.close()
            goto L_0x002f
        L_0x0110:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzp r3 = r14.zzbsd()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzbsv()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            java.lang.String r4 = "Data loss. Failed to merge raw event metadata"
            r3.zze(r4, r15, r2)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            if (r11 == 0) goto L_0x002f
            r11.close()
            goto L_0x002f
        L_0x0125:
            r2 = 0
            long r4 = r3.getLong(r2)     // Catch:{ SQLiteException -> 0x017a }
            r2 = 3
            byte[] r2 = r3.getBlob(r2)     // Catch:{ SQLiteException -> 0x017a }
            com.google.android.gms.internal.zzapn r2 = com.google.android.gms.internal.zzapn.zzbd(r2)     // Catch:{ SQLiteException -> 0x017a }
            com.google.android.gms.internal.zzuh$zzb r6 = new com.google.android.gms.internal.zzuh$zzb     // Catch:{ SQLiteException -> 0x017a }
            r6.<init>()     // Catch:{ SQLiteException -> 0x017a }
            com.google.android.gms.internal.zzapv r2 = r6.zzb(r2)     // Catch:{ IOException -> 0x015f }
            com.google.android.gms.internal.zzuh$zzb r2 = (com.google.android.gms.internal.zzuh.zzb) r2     // Catch:{ IOException -> 0x015f }
            r2 = 1
            java.lang.String r2 = r3.getString(r2)     // Catch:{ SQLiteException -> 0x017a }
            r6.name = r2     // Catch:{ SQLiteException -> 0x017a }
            r2 = 2
            long r8 = r3.getLong(r2)     // Catch:{ SQLiteException -> 0x017a }
            java.lang.Long r2 = java.lang.Long.valueOf(r8)     // Catch:{ SQLiteException -> 0x017a }
            r6.ano = r2     // Catch:{ SQLiteException -> 0x017a }
            r0 = r18
            boolean r2 = r0.mo9228a(r4, r6)     // Catch:{ SQLiteException -> 0x017a }
            if (r2 != 0) goto L_0x016d
            if (r3 == 0) goto L_0x002f
            r3.close()
            goto L_0x002f
        L_0x015f:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzp r4 = r14.zzbsd()     // Catch:{ SQLiteException -> 0x017a }
            com.google.android.gms.measurement.internal.zzp$zza r4 = r4.zzbsv()     // Catch:{ SQLiteException -> 0x017a }
            java.lang.String r5 = "Data loss. Failed to merge raw event"
            r4.zze(r5, r15, r2)     // Catch:{ SQLiteException -> 0x017a }
        L_0x016d:
            boolean r2 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x017a }
            if (r2 != 0) goto L_0x0125
            if (r3 == 0) goto L_0x002f
            r3.close()
            goto L_0x002f
        L_0x017a:
            r2 = move-exception
        L_0x017b:
            com.google.android.gms.measurement.internal.zzp r4 = r14.zzbsd()     // Catch:{ all -> 0x0197 }
            com.google.android.gms.measurement.internal.zzp$zza r4 = r4.zzbsv()     // Catch:{ all -> 0x0197 }
            java.lang.String r5 = "Data loss. Error selecting raw event"
            r4.zzj(r5, r2)     // Catch:{ all -> 0x0197 }
            if (r3 == 0) goto L_0x002f
            r3.close()
            goto L_0x002f
        L_0x018f:
            r2 = move-exception
            r11 = r3
        L_0x0191:
            if (r11 == 0) goto L_0x0196
            r11.close()
        L_0x0196:
            throw r2
        L_0x0197:
            r2 = move-exception
            r11 = r3
            goto L_0x0191
        L_0x019a:
            r2 = move-exception
            goto L_0x0191
        L_0x019c:
            r2 = move-exception
            r3 = r11
            goto L_0x017b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.mo9526a(java.lang.String, long, com.google.android.gms.measurement.internal.ah):void");
    }

    /* renamed from: a */
    public void mo9527a(String str, byte[] bArr) {
        zzab.zzhr(str);
        zzwu();
        mo9339c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) mo9548h().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                zzbsd().zzbsv().log("Failed to update remote config (got 0)");
            }
        } catch (SQLiteException e) {
            zzbsd().zzbsv().zzj("Error storing remote config", e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9528a(String str, zzuf.zza[] zzaArr) {
        mo9339c();
        zzwu();
        zzab.zzhr(str);
        zzab.zzy(zzaArr);
        SQLiteDatabase h = mo9548h();
        h.beginTransaction();
        try {
            mo9543e(str);
            for (zzuf.zza a : zzaArr) {
                m7832a(str, a);
            }
            h.setTransactionSuccessful();
        } finally {
            h.endTransaction();
        }
    }

    /* renamed from: a */
    public void mo9529a(List list) {
        zzab.zzy(list);
        zzwu();
        mo9339c();
        StringBuilder sb = new StringBuilder("rowid in (");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(((Long) list.get(i2)).longValue());
            i = i2 + 1;
        }
        sb.append(")");
        int delete = mo9548h().delete("raw_events", sb.toString(), (String[]) null);
        if (delete != list.size()) {
            zzbsd().zzbsv().zze("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    /* renamed from: a */
    public boolean mo9530a(C1888af afVar) {
        zzab.zzy(afVar);
        zzwu();
        mo9339c();
        if (mo9538c(afVar.f7081a, afVar.f7082b) == null) {
            if (zzal.m7804a(afVar.f7082b)) {
                if (m7829a("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{afVar.f7081a}) >= ((long) zzbsf().mo9471f())) {
                    return false;
                }
            } else {
                if (m7829a("select count(1) from user_attributes where app_id=?", new String[]{afVar.f7081a}) >= ((long) zzbsf().mo9472g())) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", afVar.f7081a);
        contentValues.put("name", afVar.f7082b);
        contentValues.put("set_timestamp", Long.valueOf(afVar.f7083c));
        mo9519a(contentValues, "value", afVar.f7084d);
        try {
            if (mo9548h().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) == -1) {
                zzbsd().zzbsv().log("Failed to insert/update user property (got -1)");
            }
        } catch (SQLiteException e) {
            zzbsd().zzbsv().zzj("Error storing user property", e);
        }
        return true;
    }

    /* renamed from: b */
    public long mo9531b(zzuh.zze zze) {
        zzwu();
        mo9339c();
        zzab.zzy(zze);
        zzab.zzhr(zze.zzck);
        try {
            byte[] bArr = new byte[zze.mo8049aM()];
            zzapo zzbe = zzapo.zzbe(bArr);
            zze.zza(zzbe);
            zzbe.mo7988az();
            long zzy = zzbrz().zzy(bArr);
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zze.zzck);
            contentValues.put("metadata_fingerprint", Long.valueOf(zzy));
            contentValues.put("metadata", bArr);
            try {
                mo9548h().insertWithOnConflict("raw_events_metadata", (String) null, contentValues, 4);
                return zzy;
            } catch (SQLiteException e) {
                zzbsd().zzbsv().zzj("Error storing raw event metadata", e);
                throw e;
            }
        } catch (IOException e2) {
            zzbsd().zzbsv().zzj("Data loss. Failed to serialize event metadata", e2);
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x01a9  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.measurement.internal.C1909b mo9532b(java.lang.String r12) {
        /*
            r11 = this;
            r10 = 0
            r9 = 1
            r8 = 0
            com.google.android.gms.common.internal.zzab.zzhr(r12)
            r11.zzwu()
            r11.mo9339c()
            android.database.sqlite.SQLiteDatabase r0 = r11.mo9548h()     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            java.lang.String r1 = "apps"
            r2 = 20
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 0
            java.lang.String r4 = "app_instance_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 1
            java.lang.String r4 = "gmp_app_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 2
            java.lang.String r4 = "resettable_device_id_hash"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 3
            java.lang.String r4 = "last_bundle_index"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 4
            java.lang.String r4 = "last_bundle_start_timestamp"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 5
            java.lang.String r4 = "last_bundle_end_timestamp"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 6
            java.lang.String r4 = "app_version"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 7
            java.lang.String r4 = "app_store"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 8
            java.lang.String r4 = "gmp_version"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 9
            java.lang.String r4 = "dev_cert_hash"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 10
            java.lang.String r4 = "measurement_enabled"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 11
            java.lang.String r4 = "day"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 12
            java.lang.String r4 = "daily_public_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 13
            java.lang.String r4 = "daily_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 14
            java.lang.String r4 = "daily_conversions_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 15
            java.lang.String r4 = "config_fetched_time"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 16
            java.lang.String r4 = "failed_config_fetch_time"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 17
            java.lang.String r4 = "app_version_int"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 18
            java.lang.String r4 = "firebase_instance_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r3 = 19
            java.lang.String r4 = "daily_error_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r5 = 0
            r4[r5] = r12     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x018e, all -> 0x01a5 }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x01af }
            if (r0 != 0) goto L_0x00a2
            if (r1 == 0) goto L_0x00a0
            r1.close()
        L_0x00a0:
            r0 = r8
        L_0x00a1:
            return r0
        L_0x00a2:
            com.google.android.gms.measurement.internal.b r0 = new com.google.android.gms.measurement.internal.b     // Catch:{ SQLiteException -> 0x01af }
            com.google.android.gms.measurement.internal.zzx r2 = r11.f7189n     // Catch:{ SQLiteException -> 0x01af }
            r0.<init>(r2, r12)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 0
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.mo9266a((java.lang.String) r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 1
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.mo9270b((java.lang.String) r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 2
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.mo9273c((java.lang.String) r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 3
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.mo9281f((long) r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 4
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.mo9265a((long) r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 5
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.mo9269b((long) r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 6
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.mo9279e((java.lang.String) r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 7
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.mo9282f((java.lang.String) r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 8
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.mo9275d((long) r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 9
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.mo9278e((long) r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 10
            boolean r2 = r1.isNull(r2)     // Catch:{ SQLiteException -> 0x01af }
            if (r2 == 0) goto L_0x017d
            r2 = r9
        L_0x0104:
            if (r2 == 0) goto L_0x0184
            r2 = r9
        L_0x0107:
            r0.mo9267a((boolean) r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 11
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.mo9288i(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 12
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.mo9290j(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 13
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.mo9292k(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 14
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.mo9294l(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 15
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.mo9284g(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 16
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.mo9286h(r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 17
            boolean r2 = r1.isNull(r2)     // Catch:{ SQLiteException -> 0x01af }
            if (r2 == 0) goto L_0x0186
            r2 = -2147483648(0xffffffff80000000, double:NaN)
        L_0x014b:
            r0.mo9272c((long) r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 18
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.mo9276d((java.lang.String) r2)     // Catch:{ SQLiteException -> 0x01af }
            r2 = 19
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.mo9296m(r2)     // Catch:{ SQLiteException -> 0x01af }
            r0.mo9264a()     // Catch:{ SQLiteException -> 0x01af }
            boolean r2 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x01af }
            if (r2 == 0) goto L_0x0176
            com.google.android.gms.measurement.internal.zzp r2 = r11.zzbsd()     // Catch:{ SQLiteException -> 0x01af }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbsv()     // Catch:{ SQLiteException -> 0x01af }
            java.lang.String r3 = "Got multiple records for app, expected one"
            r2.log(r3)     // Catch:{ SQLiteException -> 0x01af }
        L_0x0176:
            if (r1 == 0) goto L_0x00a1
            r1.close()
            goto L_0x00a1
        L_0x017d:
            r2 = 10
            int r2 = r1.getInt(r2)     // Catch:{ SQLiteException -> 0x01af }
            goto L_0x0104
        L_0x0184:
            r2 = r10
            goto L_0x0107
        L_0x0186:
            r2 = 17
            int r2 = r1.getInt(r2)     // Catch:{ SQLiteException -> 0x01af }
            long r2 = (long) r2
            goto L_0x014b
        L_0x018e:
            r0 = move-exception
            r1 = r8
        L_0x0190:
            com.google.android.gms.measurement.internal.zzp r2 = r11.zzbsd()     // Catch:{ all -> 0x01ad }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbsv()     // Catch:{ all -> 0x01ad }
            java.lang.String r3 = "Error querying app"
            r2.zze(r3, r12, r0)     // Catch:{ all -> 0x01ad }
            if (r1 == 0) goto L_0x01a2
            r1.close()
        L_0x01a2:
            r0 = r8
            goto L_0x00a1
        L_0x01a5:
            r0 = move-exception
            r1 = r8
        L_0x01a7:
            if (r1 == 0) goto L_0x01ac
            r1.close()
        L_0x01ac:
            throw r0
        L_0x01ad:
            r0 = move-exception
            goto L_0x01a7
        L_0x01af:
            r0 = move-exception
            goto L_0x0190
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.mo9532b(java.lang.String):com.google.android.gms.measurement.internal.b");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Object mo9533b(Cursor cursor, int i) {
        int a = m7828a(cursor, i);
        switch (a) {
            case 0:
                zzbsd().zzbsv().log("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                zzbsd().zzbsv().log("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                zzbsd().zzbsv().zzj("Loaded invalid unknown value type, ignoring it", Integer.valueOf(a));
                return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo9534b(long r8) {
        /*
            r7 = this;
            r0 = 0
            r7.zzwu()
            r7.mo9339c()
            android.database.sqlite.SQLiteDatabase r1 = r7.mo9548h()     // Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
            r4 = 0
            java.lang.String r5 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
            android.database.Cursor r2 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
            boolean r1 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x005f }
            if (r1 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzp r1 = r7.zzbsd()     // Catch:{ SQLiteException -> 0x005f }
            com.google.android.gms.measurement.internal.zzp$zza r1 = r1.zzbtc()     // Catch:{ SQLiteException -> 0x005f }
            java.lang.String r3 = "No expired configs for apps with pending events"
            r1.log(r3)     // Catch:{ SQLiteException -> 0x005f }
            if (r2 == 0) goto L_0x0033
            r2.close()
        L_0x0033:
            return r0
        L_0x0034:
            r1 = 0
            java.lang.String r0 = r2.getString(r1)     // Catch:{ SQLiteException -> 0x005f }
            if (r2 == 0) goto L_0x0033
            r2.close()
            goto L_0x0033
        L_0x003f:
            r1 = move-exception
            r2 = r0
        L_0x0041:
            com.google.android.gms.measurement.internal.zzp r3 = r7.zzbsd()     // Catch:{ all -> 0x005d }
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzbsv()     // Catch:{ all -> 0x005d }
            java.lang.String r4 = "Error selecting expired configs"
            r3.zzj(r4, r1)     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x0033
            r2.close()
            goto L_0x0033
        L_0x0054:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x0057:
            if (r2 == 0) goto L_0x005c
            r2.close()
        L_0x005c:
            throw r0
        L_0x005d:
            r0 = move-exception
            goto L_0x0057
        L_0x005f:
            r1 = move-exception
            goto L_0x0041
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.mo9534b(long):java.lang.String");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo9535b(String str, int i) {
        mo9339c();
        zzwu();
        zzab.zzhr(str);
        SQLiteDatabase h = mo9548h();
        h.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
        h.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
    }

    /* renamed from: b */
    public void mo9536b(String str, String str2) {
        zzab.zzhr(str);
        zzab.zzhr(str2);
        zzwu();
        mo9339c();
        try {
            zzbsd().zzbtc().zzj("Deleted user attribute rows:", Integer.valueOf(mo9548h().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzbsd().zzbsv().zzd("Error deleting user attribute", str, str2, e);
        }
    }

    /* renamed from: c */
    public long mo9537c(String str) {
        zzab.zzhr(str);
        zzwu();
        mo9339c();
        try {
            return (long) mo9548h().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(zzbsf().zzll(str))});
        } catch (SQLiteException e) {
            zzbsd().zzbsv().zzj("Error deleting over the limit events", e);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0082  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.measurement.internal.C1888af mo9538c(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            r8 = 0
            com.google.android.gms.common.internal.zzab.zzhr(r10)
            com.google.android.gms.common.internal.zzab.zzhr(r11)
            r9.zzwu()
            r9.mo9339c()
            android.database.sqlite.SQLiteDatabase r0 = r9.mo9548h()     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            java.lang.String r1 = "user_attributes"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            r3 = 0
            java.lang.String r4 = "set_timestamp"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            r3 = 1
            java.lang.String r4 = "value"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            java.lang.String r3 = "app_id=? and name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            r5 = 0
            r4[r5] = r10     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            r5 = 1
            r4[r5] = r11     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            boolean r0 = r7.moveToFirst()     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            if (r0 != 0) goto L_0x003f
            if (r7 == 0) goto L_0x003d
            r7.close()
        L_0x003d:
            r1 = r8
        L_0x003e:
            return r1
        L_0x003f:
            r0 = 0
            long r4 = r7.getLong(r0)     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            r0 = 1
            java.lang.Object r6 = r9.mo9533b((android.database.Cursor) r7, (int) r0)     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            com.google.android.gms.measurement.internal.af r1 = new com.google.android.gms.measurement.internal.af     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            r2 = r10
            r3 = r11
            r1.<init>(r2, r3, r4, r6)     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            boolean r0 = r7.moveToNext()     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            if (r0 == 0) goto L_0x0063
            com.google.android.gms.measurement.internal.zzp r0 = r9.zzbsd()     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzbsv()     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            java.lang.String r2 = "Got multiple records for user property, expected one"
            r0.log(r2)     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
        L_0x0063:
            if (r7 == 0) goto L_0x003e
            r7.close()
            goto L_0x003e
        L_0x0069:
            r0 = move-exception
            r1 = r8
        L_0x006b:
            com.google.android.gms.measurement.internal.zzp r2 = r9.zzbsd()     // Catch:{ all -> 0x0089 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbsv()     // Catch:{ all -> 0x0089 }
            java.lang.String r3 = "Error querying user property"
            r2.zzd(r3, r10, r11, r0)     // Catch:{ all -> 0x0089 }
            if (r1 == 0) goto L_0x007d
            r1.close()
        L_0x007d:
            r1 = r8
            goto L_0x003e
        L_0x007f:
            r0 = move-exception
        L_0x0080:
            if (r8 == 0) goto L_0x0085
            r8.close()
        L_0x0085:
            throw r0
        L_0x0086:
            r0 = move-exception
            r8 = r7
            goto L_0x0080
        L_0x0089:
            r0 = move-exception
            r8 = r1
            goto L_0x0080
        L_0x008c:
            r0 = move-exception
            r1 = r7
            goto L_0x006b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.mo9538c(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.af");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b0  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map mo9539d(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            r9 = 0
            r10.mo9339c()
            r10.zzwu()
            com.google.android.gms.common.internal.zzab.zzhr(r11)
            com.google.android.gms.common.internal.zzab.zzhr(r12)
            android.support.v4.f.a r8 = new android.support.v4.f.a
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r10.mo9548h()
            java.lang.String r1 = "event_filters"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r3 = 0
            java.lang.String r4 = "audience_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r3 = 1
            java.lang.String r4 = "data"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            java.lang.String r3 = "app_id=? AND event_name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r5 = 0
            r4[r5] = r11     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r5 = 1
            r4[r5] = r12     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0097 }
            if (r0 != 0) goto L_0x0047
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0097 }
            if (r1 == 0) goto L_0x0046
            r1.close()
        L_0x0046:
            return r0
        L_0x0047:
            r0 = 1
            byte[] r0 = r1.getBlob(r0)     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.internal.zzapn r0 = com.google.android.gms.internal.zzapn.zzbd(r0)     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.internal.zzuf$zzb r2 = new com.google.android.gms.internal.zzuf$zzb     // Catch:{ SQLiteException -> 0x0097 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.internal.zzapv r0 = r2.zzb(r0)     // Catch:{ IOException -> 0x0088 }
            com.google.android.gms.internal.zzuf$zzb r0 = (com.google.android.gms.internal.zzuf.zzb) r0     // Catch:{ IOException -> 0x0088 }
            r0 = 0
            int r3 = r1.getInt(r0)     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.Object r0 = r8.get(r0)     // Catch:{ SQLiteException -> 0x0097 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ SQLiteException -> 0x0097 }
            if (r0 != 0) goto L_0x0078
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0097 }
            r0.<init>()     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0097 }
            r8.put(r3, r0)     // Catch:{ SQLiteException -> 0x0097 }
        L_0x0078:
            r0.add(r2)     // Catch:{ SQLiteException -> 0x0097 }
        L_0x007b:
            boolean r0 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0097 }
            if (r0 != 0) goto L_0x0047
            if (r1 == 0) goto L_0x0086
            r1.close()
        L_0x0086:
            r0 = r8
            goto L_0x0046
        L_0x0088:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzp r2 = r10.zzbsd()     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbsv()     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.String r3 = "Failed to merge filter"
            r2.zze(r3, r11, r0)     // Catch:{ SQLiteException -> 0x0097 }
            goto L_0x007b
        L_0x0097:
            r0 = move-exception
        L_0x0098:
            com.google.android.gms.measurement.internal.zzp r2 = r10.zzbsd()     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbsv()     // Catch:{ all -> 0x00b4 }
            java.lang.String r3 = "Database error querying filters"
            r2.zzj(r3, r0)     // Catch:{ all -> 0x00b4 }
            if (r1 == 0) goto L_0x00aa
            r1.close()
        L_0x00aa:
            r0 = r9
            goto L_0x0046
        L_0x00ac:
            r0 = move-exception
            r1 = r9
        L_0x00ae:
            if (r1 == 0) goto L_0x00b3
            r1.close()
        L_0x00b3:
            throw r0
        L_0x00b4:
            r0 = move-exception
            goto L_0x00ae
        L_0x00b6:
            r0 = move-exception
            r1 = r9
            goto L_0x0098
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.mo9539d(java.lang.String, java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo9226d() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] mo9540d(java.lang.String r10) {
        /*
            r9 = this;
            r8 = 0
            com.google.android.gms.common.internal.zzab.zzhr(r10)
            r9.zzwu()
            r9.mo9339c()
            android.database.sqlite.SQLiteDatabase r0 = r9.mo9548h()     // Catch:{ SQLiteException -> 0x0052, all -> 0x0068 }
            java.lang.String r1 = "apps"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0052, all -> 0x0068 }
            r3 = 0
            java.lang.String r4 = "remote_config"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0052, all -> 0x0068 }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0052, all -> 0x0068 }
            r5 = 0
            r4[r5] = r10     // Catch:{ SQLiteException -> 0x0052, all -> 0x0068 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0052, all -> 0x0068 }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0072 }
            if (r0 != 0) goto L_0x0034
            if (r1 == 0) goto L_0x0032
            r1.close()
        L_0x0032:
            r0 = r8
        L_0x0033:
            return r0
        L_0x0034:
            r0 = 0
            byte[] r0 = r1.getBlob(r0)     // Catch:{ SQLiteException -> 0x0072 }
            boolean r2 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0072 }
            if (r2 == 0) goto L_0x004c
            com.google.android.gms.measurement.internal.zzp r2 = r9.zzbsd()     // Catch:{ SQLiteException -> 0x0072 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbsv()     // Catch:{ SQLiteException -> 0x0072 }
            java.lang.String r3 = "Got multiple records for app config, expected one"
            r2.log(r3)     // Catch:{ SQLiteException -> 0x0072 }
        L_0x004c:
            if (r1 == 0) goto L_0x0033
            r1.close()
            goto L_0x0033
        L_0x0052:
            r0 = move-exception
            r1 = r8
        L_0x0054:
            com.google.android.gms.measurement.internal.zzp r2 = r9.zzbsd()     // Catch:{ all -> 0x0070 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbsv()     // Catch:{ all -> 0x0070 }
            java.lang.String r3 = "Error querying remote config"
            r2.zze(r3, r10, r0)     // Catch:{ all -> 0x0070 }
            if (r1 == 0) goto L_0x0066
            r1.close()
        L_0x0066:
            r0 = r8
            goto L_0x0033
        L_0x0068:
            r0 = move-exception
            r1 = r8
        L_0x006a:
            if (r1 == 0) goto L_0x006f
            r1.close()
        L_0x006f:
            throw r0
        L_0x0070:
            r0 = move-exception
            goto L_0x006a
        L_0x0072:
            r0 = move-exception
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.mo9540d(java.lang.String):byte[]");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b0  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map mo9541e(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            r9 = 0
            r10.mo9339c()
            r10.zzwu()
            com.google.android.gms.common.internal.zzab.zzhr(r11)
            com.google.android.gms.common.internal.zzab.zzhr(r12)
            android.support.v4.f.a r8 = new android.support.v4.f.a
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r10.mo9548h()
            java.lang.String r1 = "property_filters"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r3 = 0
            java.lang.String r4 = "audience_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r3 = 1
            java.lang.String r4 = "data"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            java.lang.String r3 = "app_id=? AND property_name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r5 = 0
            r4[r5] = r11     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r5 = 1
            r4[r5] = r12     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0097 }
            if (r0 != 0) goto L_0x0047
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0097 }
            if (r1 == 0) goto L_0x0046
            r1.close()
        L_0x0046:
            return r0
        L_0x0047:
            r0 = 1
            byte[] r0 = r1.getBlob(r0)     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.internal.zzapn r0 = com.google.android.gms.internal.zzapn.zzbd(r0)     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.internal.zzuf$zze r2 = new com.google.android.gms.internal.zzuf$zze     // Catch:{ SQLiteException -> 0x0097 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.internal.zzapv r0 = r2.zzb(r0)     // Catch:{ IOException -> 0x0088 }
            com.google.android.gms.internal.zzuf$zze r0 = (com.google.android.gms.internal.zzuf.zze) r0     // Catch:{ IOException -> 0x0088 }
            r0 = 0
            int r3 = r1.getInt(r0)     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.Object r0 = r8.get(r0)     // Catch:{ SQLiteException -> 0x0097 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ SQLiteException -> 0x0097 }
            if (r0 != 0) goto L_0x0078
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0097 }
            r0.<init>()     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0097 }
            r8.put(r3, r0)     // Catch:{ SQLiteException -> 0x0097 }
        L_0x0078:
            r0.add(r2)     // Catch:{ SQLiteException -> 0x0097 }
        L_0x007b:
            boolean r0 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0097 }
            if (r0 != 0) goto L_0x0047
            if (r1 == 0) goto L_0x0086
            r1.close()
        L_0x0086:
            r0 = r8
            goto L_0x0046
        L_0x0088:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzp r2 = r10.zzbsd()     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbsv()     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.String r3 = "Failed to merge filter"
            r2.zze(r3, r11, r0)     // Catch:{ SQLiteException -> 0x0097 }
            goto L_0x007b
        L_0x0097:
            r0 = move-exception
        L_0x0098:
            com.google.android.gms.measurement.internal.zzp r2 = r10.zzbsd()     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbsv()     // Catch:{ all -> 0x00b4 }
            java.lang.String r3 = "Database error querying filters"
            r2.zzj(r3, r0)     // Catch:{ all -> 0x00b4 }
            if (r1 == 0) goto L_0x00aa
            r1.close()
        L_0x00aa:
            r0 = r9
            goto L_0x0046
        L_0x00ac:
            r0 = move-exception
            r1 = r9
        L_0x00ae:
            if (r1 == 0) goto L_0x00b3
            r1.close()
        L_0x00b3:
            throw r0
        L_0x00b4:
            r0 = move-exception
            goto L_0x00ae
        L_0x00b6:
            r0 = move-exception
            r1 = r9
            goto L_0x0098
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.mo9541e(java.lang.String, java.lang.String):java.util.Map");
    }

    /* renamed from: e */
    public void mo9542e() {
        mo9339c();
        mo9548h().beginTransaction();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo9543e(String str) {
        mo9339c();
        zzwu();
        zzab.zzhr(str);
        SQLiteDatabase h = mo9548h();
        h.delete("property_filters", "app_id=?", new String[]{str});
        h.delete("event_filters", "app_id=?", new String[]{str});
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0098  */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map mo9544f(java.lang.String r10) {
        /*
            r9 = this;
            r8 = 0
            r9.mo9339c()
            r9.zzwu()
            com.google.android.gms.common.internal.zzab.zzhr(r10)
            android.database.sqlite.SQLiteDatabase r0 = r9.mo9548h()
            java.lang.String r1 = "audience_filter_values"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00a1, all -> 0x0094 }
            r3 = 0
            java.lang.String r4 = "audience_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a1, all -> 0x0094 }
            r3 = 1
            java.lang.String r4 = "current_results"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a1, all -> 0x0094 }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00a1, all -> 0x0094 }
            r5 = 0
            r4[r5] = r10     // Catch:{ SQLiteException -> 0x00a1, all -> 0x0094 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x00a1, all -> 0x0094 }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            if (r0 != 0) goto L_0x0039
            if (r2 == 0) goto L_0x0037
            r2.close()
        L_0x0037:
            r0 = r8
        L_0x0038:
            return r0
        L_0x0039:
            android.support.v4.f.a r1 = new android.support.v4.f.a     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            r1.<init>()     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
        L_0x003e:
            r0 = 0
            int r3 = r2.getInt(r0)     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            r0 = 1
            byte[] r0 = r2.getBlob(r0)     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            com.google.android.gms.internal.zzapn r0 = com.google.android.gms.internal.zzapn.zzbd(r0)     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            com.google.android.gms.internal.zzuh$zzf r4 = new com.google.android.gms.internal.zzuh$zzf     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            r4.<init>()     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            com.google.android.gms.internal.zzapv r0 = r4.zzb(r0)     // Catch:{ IOException -> 0x006b }
            com.google.android.gms.internal.zzuh$zzf r0 = (com.google.android.gms.internal.zzuh.zzf) r0     // Catch:{ IOException -> 0x006b }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            r1.put(r0, r4)     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
        L_0x005e:
            boolean r0 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            if (r0 != 0) goto L_0x003e
            if (r2 == 0) goto L_0x0069
            r2.close()
        L_0x0069:
            r0 = r1
            goto L_0x0038
        L_0x006b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzp r4 = r9.zzbsd()     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            com.google.android.gms.measurement.internal.zzp$zza r4 = r4.zzbsv()     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            r4.zzd(r5, r10, r3, r0)     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            goto L_0x005e
        L_0x007e:
            r0 = move-exception
            r1 = r2
        L_0x0080:
            com.google.android.gms.measurement.internal.zzp r2 = r9.zzbsd()     // Catch:{ all -> 0x009e }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbsv()     // Catch:{ all -> 0x009e }
            java.lang.String r3 = "Database error querying filter results"
            r2.zzj(r3, r0)     // Catch:{ all -> 0x009e }
            if (r1 == 0) goto L_0x0092
            r1.close()
        L_0x0092:
            r0 = r8
            goto L_0x0038
        L_0x0094:
            r0 = move-exception
            r2 = r8
        L_0x0096:
            if (r2 == 0) goto L_0x009b
            r2.close()
        L_0x009b:
            throw r0
        L_0x009c:
            r0 = move-exception
            goto L_0x0096
        L_0x009e:
            r0 = move-exception
            r2 = r1
            goto L_0x0096
        L_0x00a1:
            r0 = move-exception
            r1 = r8
            goto L_0x0080
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.mo9544f(java.lang.String):java.util.Map");
    }

    /* renamed from: f */
    public void mo9545f() {
        mo9339c();
        mo9548h().setTransactionSuccessful();
    }

    /* renamed from: g */
    public void mo9546g() {
        mo9339c();
        mo9548h().endTransaction();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo9547g(String str) {
        mo9339c();
        zzwu();
        zzab.zzhr(str);
        try {
            SQLiteDatabase h = mo9548h();
            String[] strArr = {str};
            int delete = h.delete("audience_filter_values", "app_id=?", strArr) + h.delete("events", "app_id=?", strArr) + 0 + h.delete("user_attributes", "app_id=?", strArr) + h.delete("apps", "app_id=?", strArr) + h.delete("raw_events", "app_id=?", strArr) + h.delete("raw_events_metadata", "app_id=?", strArr) + h.delete("event_filters", "app_id=?", strArr) + h.delete("property_filters", "app_id=?", strArr);
            if (delete > 0) {
                zzbsd().zzbtc().zze("Deleted application data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzbsd().zzbsv().zze("Error deleting application data. appId, error", str, e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public SQLiteDatabase mo9548h() {
        zzwu();
        try {
            return this.f7271b.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbsd().zzbsx().zzj("Error opening database", e);
            throw e;
        }
    }

    /* renamed from: h */
    public void mo9549h(String str) {
        try {
            mo9548h().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str, str});
        } catch (SQLiteException e) {
            zzbsd().zzbsv().zzj("Failed to remove unused event metadata", e);
        }
    }

    /* renamed from: i */
    public long mo9550i(String str) {
        zzab.zzhr(str);
        return m7830a("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public String mo9551i() {
        if (!zzbsf().zzabc()) {
            return zzbsf().zzacc();
        }
        if (zzbsf().zzabd()) {
            return zzbsf().zzacc();
        }
        zzbsd().zzbsy().log("Using secondary database");
        return zzbsf().zzacd();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d  */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo9552j() {
        /*
            r5 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.mo9548h()
            java.lang.String r2 = "select app_id from queue where app_id not in (select app_id from apps where measurement_enabled=0) order by rowid limit 1;"
            r3 = 0
            android.database.Cursor r2 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0023, all -> 0x0038 }
            boolean r1 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0043 }
            if (r1 == 0) goto L_0x001d
            r1 = 0
            java.lang.String r0 = r2.getString(r1)     // Catch:{ SQLiteException -> 0x0043 }
            if (r2 == 0) goto L_0x001c
            r2.close()
        L_0x001c:
            return r0
        L_0x001d:
            if (r2 == 0) goto L_0x001c
            r2.close()
            goto L_0x001c
        L_0x0023:
            r1 = move-exception
            r2 = r0
        L_0x0025:
            com.google.android.gms.measurement.internal.zzp r3 = r5.zzbsd()     // Catch:{ all -> 0x0041 }
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzbsv()     // Catch:{ all -> 0x0041 }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zzj(r4, r1)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x001c
            r2.close()
            goto L_0x001c
        L_0x0038:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x003b:
            if (r2 == 0) goto L_0x0040
            r2.close()
        L_0x0040:
            throw r0
        L_0x0041:
            r0 = move-exception
            goto L_0x003b
        L_0x0043:
            r1 = move-exception
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.mo9552j():java.lang.String");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo9553k() {
        zzwu();
        mo9339c();
        if (m7836q()) {
            long j = zzbse().f7318f.get();
            long elapsedRealtime = zzyw().elapsedRealtime();
            if (Math.abs(elapsedRealtime - j) > zzbsf().zzbrg()) {
                zzbse().f7318f.set(elapsedRealtime);
                mo9554l();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo9554l() {
        int delete;
        zzwu();
        mo9339c();
        if (m7836q() && (delete = mo9548h().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzyw().currentTimeMillis()), String.valueOf(zzbsf().zzbrf())})) > 0) {
            zzbsd().zzbtc().zzj("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
        }
    }

    /* renamed from: m */
    public long mo9555m() {
        return m7830a("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    /* renamed from: n */
    public long mo9556n() {
        return m7830a("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    /* renamed from: o */
    public boolean mo9557o() {
        return m7829a("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }
}
