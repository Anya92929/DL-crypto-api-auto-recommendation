package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmo;
import com.google.android.gms.internal.zznb;
import com.google.android.gms.internal.zznc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SafeParcelResponse extends FastJsonResponse implements SafeParcelable {
    public static final zze CREATOR = new zze();

    /* renamed from: a */
    private final int f3061a;

    /* renamed from: b */
    private final Parcel f3062b;

    /* renamed from: c */
    private final int f3063c;

    /* renamed from: d */
    private final FieldMappingDictionary f3064d;

    /* renamed from: e */
    private final String f3065e;

    /* renamed from: f */
    private int f3066f;

    /* renamed from: g */
    private int f3067g;

    SafeParcelResponse(int i, Parcel parcel, FieldMappingDictionary fieldMappingDictionary) {
        this.f3061a = i;
        this.f3062b = (Parcel) zzx.zzz(parcel);
        this.f3063c = 2;
        this.f3064d = fieldMappingDictionary;
        if (this.f3064d == null) {
            this.f3065e = null;
        } else {
            this.f3065e = this.f3064d.zzrB();
        }
        this.f3066f = 2;
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, FieldMappingDictionary fieldMappingDictionary, String str) {
        this.f3061a = 1;
        this.f3062b = Parcel.obtain();
        safeParcelable.writeToParcel(this.f3062b, 0);
        this.f3063c = 1;
        this.f3064d = (FieldMappingDictionary) zzx.zzz(fieldMappingDictionary);
        this.f3065e = (String) zzx.zzz(str);
        this.f3066f = 2;
    }

    /* renamed from: a */
    private static FieldMappingDictionary m3974a(FastJsonResponse fastJsonResponse) {
        FieldMappingDictionary fieldMappingDictionary = new FieldMappingDictionary(fastJsonResponse.getClass());
        m3976a(fieldMappingDictionary, fastJsonResponse);
        fieldMappingDictionary.zzrz();
        fieldMappingDictionary.zzry();
        return fieldMappingDictionary;
    }

    /* renamed from: a */
    private static HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> m3975a(Map<String, FastJsonResponse.Field<?, ?>> map) {
        HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(Integer.valueOf(((FastJsonResponse.Field) next.getValue()).zzrs()), next);
        }
        return hashMap;
    }

    /* renamed from: a */
    private static void m3976a(FieldMappingDictionary fieldMappingDictionary, FastJsonResponse fastJsonResponse) {
        Class<?> cls = fastJsonResponse.getClass();
        if (!fieldMappingDictionary.zzb(cls)) {
            Map<String, FastJsonResponse.Field<?, ?>> zzrl = fastJsonResponse.zzrl();
            fieldMappingDictionary.zza(cls, zzrl);
            for (String str : zzrl.keySet()) {
                FastJsonResponse.Field field = zzrl.get(str);
                Class<? extends FastJsonResponse> zzrt = field.zzrt();
                if (zzrt != null) {
                    try {
                        m3976a(fieldMappingDictionary, (FastJsonResponse) zzrt.newInstance());
                    } catch (InstantiationException e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + field.zzrt().getCanonicalName(), e);
                    } catch (IllegalAccessException e2) {
                        throw new IllegalStateException("Could not access object of type " + field.zzrt().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m3977a(StringBuilder sb, int i, Object obj) {
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
                sb.append("\"").append(zznb.zzcU(obj.toString())).append("\"");
                return;
            case 8:
                sb.append("\"").append(zzmo.zzj((byte[]) obj)).append("\"");
                return;
            case 9:
                sb.append("\"").append(zzmo.zzk((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                zznc.zza(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    /* renamed from: a */
    private void m3978a(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        switch (field.zzrk()) {
            case 0:
                m3979a(sb, field, (Object) zza(field, Integer.valueOf(zza.zzg(parcel, i))));
                return;
            case 1:
                m3979a(sb, field, (Object) zza(field, zza.zzk(parcel, i)));
                return;
            case 2:
                m3979a(sb, field, (Object) zza(field, Long.valueOf(zza.zzi(parcel, i))));
                return;
            case 3:
                m3979a(sb, field, (Object) zza(field, Float.valueOf(zza.zzl(parcel, i))));
                return;
            case 4:
                m3979a(sb, field, (Object) zza(field, Double.valueOf(zza.zzn(parcel, i))));
                return;
            case 5:
                m3979a(sb, field, (Object) zza(field, zza.zzo(parcel, i)));
                return;
            case 6:
                m3979a(sb, field, (Object) zza(field, Boolean.valueOf(zza.zzc(parcel, i))));
                return;
            case 7:
                m3979a(sb, field, (Object) zza(field, zza.zzp(parcel, i)));
                return;
            case 8:
            case 9:
                m3979a(sb, field, (Object) zza(field, zza.zzs(parcel, i)));
                return;
            case 10:
                m3979a(sb, field, (Object) zza(field, zzl(zza.zzr(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + field.zzrk());
        }
    }

    /* renamed from: a */
    private void m3979a(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.zzrp()) {
            m3980a(sb, field, (ArrayList<?>) (ArrayList) obj);
        } else {
            m3977a(sb, field.zzrj(), obj);
        }
    }

    /* renamed from: a */
    private void m3980a(StringBuilder sb, FastJsonResponse.Field<?, ?> field, ArrayList<?> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            m3977a(sb, field.zzrj(), (Object) arrayList.get(i));
        }
        sb.append("]");
    }

    /* renamed from: a */
    private void m3981a(StringBuilder sb, String str, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        sb.append("\"").append(str).append("\":");
        if (field.zzrv()) {
            m3978a(sb, field, parcel, i);
        } else {
            m3983b(sb, field, parcel, i);
        }
    }

    /* renamed from: a */
    private void m3982a(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> a = m3975a(map);
        sb.append('{');
        int zzau = zza.zzau(parcel);
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            Map.Entry entry = a.get(Integer.valueOf(zza.zzca(zzat)));
            if (entry != null) {
                if (z) {
                    sb.append(",");
                }
                m3981a(sb, (String) entry.getKey(), (FastJsonResponse.Field) entry.getValue(), parcel, zzat);
                z = true;
            }
        }
        if (parcel.dataPosition() != zzau) {
            throw new zza.C2021zza("Overread allowed size end=" + zzau, parcel);
        }
        sb.append('}');
    }

    /* renamed from: b */
    private void m3983b(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        if (field.zzrq()) {
            sb.append("[");
            switch (field.zzrk()) {
                case 0:
                    zzmn.zza(sb, zza.zzv(parcel, i));
                    break;
                case 1:
                    zzmn.zza(sb, (T[]) zza.zzx(parcel, i));
                    break;
                case 2:
                    zzmn.zza(sb, zza.zzw(parcel, i));
                    break;
                case 3:
                    zzmn.zza(sb, zza.zzy(parcel, i));
                    break;
                case 4:
                    zzmn.zza(sb, zza.zzz(parcel, i));
                    break;
                case 5:
                    zzmn.zza(sb, (T[]) zza.zzA(parcel, i));
                    break;
                case 6:
                    zzmn.zza(sb, zza.zzu(parcel, i));
                    break;
                case 7:
                    zzmn.zza(sb, zza.zzB(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] zzF = zza.zzF(parcel, i);
                    int length = zzF.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            sb.append(",");
                        }
                        zzF[i2].setDataPosition(0);
                        m3982a(sb, field.zzrx(), zzF[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            sb.append("]");
            return;
        }
        switch (field.zzrk()) {
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
                sb.append(zza.zzo(parcel, i));
                return;
            case 6:
                sb.append(zza.zzc(parcel, i));
                return;
            case 7:
                sb.append("\"").append(zznb.zzcU(zza.zzp(parcel, i))).append("\"");
                return;
            case 8:
                sb.append("\"").append(zzmo.zzj(zza.zzs(parcel, i))).append("\"");
                return;
            case 9:
                sb.append("\"").append(zzmo.zzk(zza.zzs(parcel, i)));
                sb.append("\"");
                return;
            case 10:
                Bundle zzr = zza.zzr(parcel, i);
                Set<String> keySet = zzr.keySet();
                keySet.size();
                sb.append("{");
                boolean z = true;
                for (String str : keySet) {
                    if (!z) {
                        sb.append(",");
                    }
                    sb.append("\"").append(str).append("\"");
                    sb.append(":");
                    sb.append("\"").append(zznb.zzcU(zzr.getString(str))).append("\"");
                    z = false;
                }
                sb.append("}");
                return;
            case 11:
                Parcel zzE = zza.zzE(parcel, i);
                zzE.setDataPosition(0);
                m3982a(sb, field.zzrx(), zzE);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse zza(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new SafeParcelResponse((SafeParcelable) t, m3974a((FastJsonResponse) t), canonicalName);
    }

    public static HashMap<String, String> zzl(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public FieldMappingDictionary mo5687a() {
        switch (this.f3063c) {
            case 0:
                return null;
            case 1:
                return this.f3064d;
            case 2:
                return this.f3064d;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.f3063c);
        }
    }

    public int describeContents() {
        zze zze = CREATOR;
        return 0;
    }

    public int getVersionCode() {
        return this.f3061a;
    }

    public String toString() {
        zzx.zzb(this.f3064d, (Object) "Cannot convert to JSON on client side.");
        Parcel zzrD = zzrD();
        zzrD.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        m3982a(sb, this.f3064d.zzcR(this.f3065e), zzrD);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze zze = CREATOR;
        zze.m3989a(this, parcel, i);
    }

    /* access modifiers changed from: protected */
    public Object zzcN(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    /* access modifiers changed from: protected */
    public boolean zzcO(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public Parcel zzrD() {
        switch (this.f3066f) {
            case 0:
                this.f3067g = zzb.zzav(this.f3062b);
                zzb.zzI(this.f3062b, this.f3067g);
                this.f3066f = 2;
                break;
            case 1:
                zzb.zzI(this.f3062b, this.f3067g);
                this.f3066f = 2;
                break;
        }
        return this.f3062b;
    }

    public Map<String, FastJsonResponse.Field<?, ?>> zzrl() {
        if (this.f3064d == null) {
            return null;
        }
        return this.f3064d.zzcR(this.f3065e);
    }
}
