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
    private final String mClassName;
    private final int mVersionCode;
    private final FieldMappingDictionary zzamT;
    private final Parcel zzana;
    private final int zzanb;
    private int zzanc;
    private int zzand;

    SafeParcelResponse(int versionCode, Parcel parcel, FieldMappingDictionary fieldMappingDictionary) {
        this.mVersionCode = versionCode;
        this.zzana = (Parcel) zzx.zzz(parcel);
        this.zzanb = 2;
        this.zzamT = fieldMappingDictionary;
        if (this.zzamT == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.zzamT.zzrB();
        }
        this.zzanc = 2;
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, FieldMappingDictionary dictionary, String className) {
        this.mVersionCode = 1;
        this.zzana = Parcel.obtain();
        safeParcelable.writeToParcel(this.zzana, 0);
        this.zzanb = 1;
        this.zzamT = (FieldMappingDictionary) zzx.zzz(dictionary);
        this.mClassName = (String) zzx.zzz(className);
        this.zzanc = 2;
    }

    private static HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> zzN(Map<String, FastJsonResponse.Field<?, ?>> map) {
        HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(Integer.valueOf(((FastJsonResponse.Field) next.getValue()).zzrs()), next);
        }
        return hashMap;
    }

    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse zza(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new SafeParcelResponse((SafeParcelable) t, zzb(t), canonicalName);
    }

    private static void zza(FieldMappingDictionary fieldMappingDictionary, FastJsonResponse fastJsonResponse) {
        Class<?> cls = fastJsonResponse.getClass();
        if (!fieldMappingDictionary.zzb(cls)) {
            Map<String, FastJsonResponse.Field<?, ?>> zzrl = fastJsonResponse.zzrl();
            fieldMappingDictionary.zza(cls, zzrl);
            for (String str : zzrl.keySet()) {
                FastJsonResponse.Field field = zzrl.get(str);
                Class<? extends FastJsonResponse> zzrt = field.zzrt();
                if (zzrt != null) {
                    try {
                        zza(fieldMappingDictionary, (FastJsonResponse) zzrt.newInstance());
                    } catch (InstantiationException e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + field.zzrt().getCanonicalName(), e);
                    } catch (IllegalAccessException e2) {
                        throw new IllegalStateException("Could not access object of type " + field.zzrt().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    private void zza(StringBuilder sb, int i, Object obj) {
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

    private void zza(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        switch (field.zzrk()) {
            case 0:
                zzb(sb, field, (Object) zza(field, Integer.valueOf(zza.zzg(parcel, i))));
                return;
            case 1:
                zzb(sb, field, (Object) zza(field, zza.zzk(parcel, i)));
                return;
            case 2:
                zzb(sb, field, (Object) zza(field, Long.valueOf(zza.zzi(parcel, i))));
                return;
            case 3:
                zzb(sb, field, (Object) zza(field, Float.valueOf(zza.zzl(parcel, i))));
                return;
            case 4:
                zzb(sb, field, (Object) zza(field, Double.valueOf(zza.zzn(parcel, i))));
                return;
            case 5:
                zzb(sb, field, (Object) zza(field, zza.zzo(parcel, i)));
                return;
            case 6:
                zzb(sb, field, (Object) zza(field, Boolean.valueOf(zza.zzc(parcel, i))));
                return;
            case 7:
                zzb(sb, field, (Object) zza(field, zza.zzp(parcel, i)));
                return;
            case 8:
            case 9:
                zzb(sb, field, (Object) zza(field, zza.zzs(parcel, i)));
                return;
            case 10:
                zzb(sb, field, (Object) zza(field, zzl(zza.zzr(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + field.zzrk());
        }
    }

    private void zza(StringBuilder sb, String str, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        sb.append("\"").append(str).append("\":");
        if (field.zzrv()) {
            zza(sb, field, parcel, i);
        } else {
            zzb(sb, field, parcel, i);
        }
    }

    private void zza(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        HashMap<Integer, Map.Entry<String, FastJsonResponse.Field<?, ?>>> zzN = zzN(map);
        sb.append('{');
        int zzau = zza.zzau(parcel);
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            Map.Entry entry = zzN.get(Integer.valueOf(zza.zzca(zzat)));
            if (entry != null) {
                if (z) {
                    sb.append(",");
                }
                zza(sb, (String) entry.getKey(), (FastJsonResponse.Field) entry.getValue(), parcel, zzat);
                z = true;
            }
        }
        if (parcel.dataPosition() != zzau) {
            throw new zza.C0429zza("Overread allowed size end=" + zzau, parcel);
        }
        sb.append('}');
    }

    private static FieldMappingDictionary zzb(FastJsonResponse fastJsonResponse) {
        FieldMappingDictionary fieldMappingDictionary = new FieldMappingDictionary(fastJsonResponse.getClass());
        zza(fieldMappingDictionary, fastJsonResponse);
        fieldMappingDictionary.zzrz();
        fieldMappingDictionary.zzry();
        return fieldMappingDictionary;
    }

    private void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
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
                        zza(sb, field.zzrx(), zzF[i2]);
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
                zza(sb, field.zzrx(), zzE);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.zzrp()) {
            zzb(sb, field, (ArrayList<?>) (ArrayList) obj);
        } else {
            zza(sb, field.zzrj(), obj);
        }
    }

    private void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, ArrayList<?> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            zza(sb, field.zzrj(), (Object) arrayList.get(i));
        }
        sb.append("]");
    }

    public static HashMap<String, String> zzl(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    public int describeContents() {
        zze zze = CREATOR;
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        zzx.zzb(this.zzamT, (Object) "Cannot convert to JSON on client side.");
        Parcel zzrD = zzrD();
        zzrD.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        zza(sb, this.zzamT.zzcR(this.mClassName), zzrD);
        return sb.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zze zze = CREATOR;
        zze.zza(this, out, flags);
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
        switch (this.zzanc) {
            case 0:
                this.zzand = zzb.zzav(this.zzana);
                zzb.zzI(this.zzana, this.zzand);
                this.zzanc = 2;
                break;
            case 1:
                zzb.zzI(this.zzana, this.zzand);
                this.zzanc = 2;
                break;
        }
        return this.zzana;
    }

    /* access modifiers changed from: package-private */
    public FieldMappingDictionary zzrE() {
        switch (this.zzanb) {
            case 0:
                return null;
            case 1:
                return this.zzamT;
            case 2:
                return this.zzamT;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.zzanb);
        }
    }

    public Map<String, FastJsonResponse.Field<?, ?>> zzrl() {
        if (this.zzamT == null) {
            return null;
        }
        return this.zzamT.zzcR(this.mClassName);
    }
}
