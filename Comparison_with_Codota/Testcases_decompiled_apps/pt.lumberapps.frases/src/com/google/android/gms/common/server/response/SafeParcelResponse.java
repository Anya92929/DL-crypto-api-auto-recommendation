package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.zzb;
import com.google.android.gms.common.util.zzc;
import com.google.android.gms.common.util.zzp;
import com.google.android.gms.common.util.zzq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final zze CREATOR = new zze();

    /* renamed from: a */
    private final int f4657a;

    /* renamed from: b */
    private final Parcel f4658b;

    /* renamed from: c */
    private final int f4659c = 2;

    /* renamed from: d */
    private final FieldMappingDictionary f4660d;

    /* renamed from: e */
    private final String f4661e;

    /* renamed from: f */
    private int f4662f;

    /* renamed from: g */
    private int f4663g;

    SafeParcelResponse(int i, Parcel parcel, FieldMappingDictionary fieldMappingDictionary) {
        this.f4657a = i;
        this.f4658b = (Parcel) zzab.zzy(parcel);
        this.f4660d = fieldMappingDictionary;
        if (this.f4660d == null) {
            this.f4661e = null;
        } else {
            this.f4661e = this.f4660d.zzauj();
        }
        this.f4662f = 2;
    }

    /* renamed from: a */
    private static SparseArray m6167a(Map map) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.put(((FastJsonResponse.Field) entry.getValue()).zzaub(), entry);
        }
        return sparseArray;
    }

    /* renamed from: a */
    private void m6168a(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"").append(zzp.zzia(obj.toString())).append("\"");
                return;
            case 8:
                sb.append("\"").append(zzc.zzp((byte[]) obj)).append("\"");
                return;
            case 9:
                sb.append("\"").append(zzc.zzq((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                zzq.zza(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException(new StringBuilder(26).append("Unknown type = ").append(i).toString());
        }
    }

    /* renamed from: a */
    private void m6169a(StringBuilder sb, FastJsonResponse.Field field, Parcel parcel, int i) {
        switch (field.zzatu()) {
            case 0:
                m6170a(sb, field, mo6800a(field, Integer.valueOf(zza.zzg(parcel, i))));
                return;
            case 1:
                m6170a(sb, field, mo6800a(field, zza.zzk(parcel, i)));
                return;
            case 2:
                m6170a(sb, field, mo6800a(field, Long.valueOf(zza.zzi(parcel, i))));
                return;
            case 3:
                m6170a(sb, field, mo6800a(field, Float.valueOf(zza.zzl(parcel, i))));
                return;
            case 4:
                m6170a(sb, field, mo6800a(field, Double.valueOf(zza.zzn(parcel, i))));
                return;
            case 5:
                m6170a(sb, field, mo6800a(field, zza.zzp(parcel, i)));
                return;
            case 6:
                m6170a(sb, field, mo6800a(field, Boolean.valueOf(zza.zzc(parcel, i))));
                return;
            case 7:
                m6170a(sb, field, mo6800a(field, zza.zzq(parcel, i)));
                return;
            case 8:
            case 9:
                m6170a(sb, field, mo6800a(field, zza.zzt(parcel, i)));
                return;
            case 10:
                m6170a(sb, field, mo6800a(field, zzp(zza.zzs(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException(new StringBuilder(36).append("Unknown field out type = ").append(field.zzatu()).toString());
        }
    }

    /* renamed from: a */
    private void m6170a(StringBuilder sb, FastJsonResponse.Field field, Object obj) {
        if (field.zzaty()) {
            m6171a(sb, field, (ArrayList) obj);
        } else {
            m6168a(sb, field.zzatt(), obj);
        }
    }

    /* renamed from: a */
    private void m6171a(StringBuilder sb, FastJsonResponse.Field field, ArrayList arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            m6168a(sb, field.zzatt(), arrayList.get(i));
        }
        sb.append("]");
    }

    /* renamed from: a */
    private void m6172a(StringBuilder sb, String str, FastJsonResponse.Field field, Parcel parcel, int i) {
        sb.append("\"").append(str).append("\":");
        if (field.zzaue()) {
            m6169a(sb, field, parcel, i);
        } else {
            m6174b(sb, field, parcel, i);
        }
    }

    /* renamed from: a */
    private void m6173a(StringBuilder sb, Map map, Parcel parcel) {
        SparseArray a = m6167a(map);
        sb.append('{');
        int zzcm = zza.zzcm(parcel);
        boolean z = false;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            Map.Entry entry = (Map.Entry) a.get(zza.zzgm(zzcl));
            if (entry != null) {
                if (z) {
                    sb.append(",");
                }
                m6172a(sb, (String) entry.getKey(), (FastJsonResponse.Field) entry.getValue(), parcel, zzcl);
                z = true;
            }
        }
        if (parcel.dataPosition() != zzcm) {
            throw new zza.C2110zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcm).toString(), parcel);
        }
        sb.append('}');
    }

    /* renamed from: b */
    private void m6174b(StringBuilder sb, FastJsonResponse.Field field, Parcel parcel, int i) {
        if (field.zzatz()) {
            sb.append("[");
            switch (field.zzatu()) {
                case 0:
                    zzb.zza(sb, zza.zzw(parcel, i));
                    break;
                case 1:
                    zzb.zza(sb, (Object[]) zza.zzy(parcel, i));
                    break;
                case 2:
                    zzb.zza(sb, zza.zzx(parcel, i));
                    break;
                case 3:
                    zzb.zza(sb, zza.zzz(parcel, i));
                    break;
                case 4:
                    zzb.zza(sb, zza.zzaa(parcel, i));
                    break;
                case 5:
                    zzb.zza(sb, (Object[]) zza.zzab(parcel, i));
                    break;
                case 6:
                    zzb.zza(sb, zza.zzv(parcel, i));
                    break;
                case 7:
                    zzb.zza(sb, zza.zzac(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] zzag = zza.zzag(parcel, i);
                    int length = zzag.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            sb.append(",");
                        }
                        zzag[i2].setDataPosition(0);
                        m6173a(sb, field.zzaug(), zzag[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            sb.append("]");
            return;
        }
        switch (field.zzatu()) {
            case 0:
                sb.append(zza.zzg(parcel, i));
                return;
            case 1:
                sb.append(zza.zzk(parcel, i));
                return;
            case 2:
                sb.append(zza.zzi(parcel, i));
                return;
            case 3:
                sb.append(zza.zzl(parcel, i));
                return;
            case 4:
                sb.append(zza.zzn(parcel, i));
                return;
            case 5:
                sb.append(zza.zzp(parcel, i));
                return;
            case 6:
                sb.append(zza.zzc(parcel, i));
                return;
            case 7:
                sb.append("\"").append(zzp.zzia(zza.zzq(parcel, i))).append("\"");
                return;
            case 8:
                sb.append("\"").append(zzc.zzp(zza.zzt(parcel, i))).append("\"");
                return;
            case 9:
                sb.append("\"").append(zzc.zzq(zza.zzt(parcel, i)));
                sb.append("\"");
                return;
            case 10:
                Bundle zzs = zza.zzs(parcel, i);
                Set<String> keySet = zzs.keySet();
                keySet.size();
                sb.append("{");
                boolean z = true;
                for (String str : keySet) {
                    if (!z) {
                        sb.append(",");
                    }
                    sb.append("\"").append(str).append("\"");
                    sb.append(":");
                    sb.append("\"").append(zzp.zzia(zzs.getString(str))).append("\"");
                    z = false;
                }
                sb.append("}");
                return;
            case 11:
                Parcel zzaf = zza.zzaf(parcel, i);
                zzaf.setDataPosition(0);
                m6173a(sb, field.zzaug(), zzaf);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    public static HashMap zzp(Bundle bundle) {
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public FieldMappingDictionary mo6838a() {
        switch (this.f4659c) {
            case 0:
                return null;
            case 1:
                return this.f4660d;
            case 2:
                return this.f4660d;
            default:
                throw new IllegalStateException(new StringBuilder(34).append("Invalid creation type: ").append(this.f4659c).toString());
        }
    }

    public int getVersionCode() {
        return this.f4657a;
    }

    public String toString() {
        zzab.zzb((Object) this.f4660d, (Object) "Cannot convert to JSON on client side.");
        Parcel zzaul = zzaul();
        zzaul.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        m6173a(sb, this.f4660d.zzhw(this.f4661e), zzaul);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze zze = CREATOR;
        zze.m6180a(this, parcel, i);
    }

    public Map zzatv() {
        if (this.f4660d == null) {
            return null;
        }
        return this.f4660d.zzhw(this.f4661e);
    }

    public Parcel zzaul() {
        switch (this.f4662f) {
            case 0:
                this.f4663g = com.google.android.gms.common.internal.safeparcel.zzb.zzcn(this.f4658b);
                com.google.android.gms.common.internal.safeparcel.zzb.zzaj(this.f4658b, this.f4663g);
                this.f4662f = 2;
                break;
            case 1:
                com.google.android.gms.common.internal.safeparcel.zzb.zzaj(this.f4658b, this.f4663g);
                this.f4662f = 2;
                break;
        }
        return this.f4658b;
    }

    public Object zzhs(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public boolean zzht(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }
}
