package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzapo;
import com.google.android.gms.internal.zzuf;
import com.google.android.gms.internal.zzuh;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class zzal extends C1922bm {
    zzal(zzx zzx) {
        super(zzx);
    }

    /* renamed from: a */
    static long m7791a(byte[] bArr) {
        int i = 0;
        zzab.zzy(bArr);
        zzab.zzbn(bArr.length > 0);
        long j = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
            length--;
        }
        return j;
    }

    /* renamed from: a */
    private Object m7792a(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return zza(String.valueOf(obj), i, z);
            }
            return null;
        }
    }

    /* renamed from: a */
    private static void m7793a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    /* renamed from: a */
    private static void m7794a(StringBuilder sb, int i, zzuf.zzc zzc) {
        if (zzc != null) {
            m7793a(sb, i);
            sb.append("filter {\n");
            m7799a(sb, i, "complement", (Object) zzc.amL);
            m7799a(sb, i, "param_name", (Object) zzc.amM);
            m7797a(sb, i + 1, "string_filter", zzc.amJ);
            m7796a(sb, i + 1, "number_filter", zzc.amK);
            m7793a(sb, i);
            sb.append("}\n");
        }
    }

    /* renamed from: a */
    private static void m7795a(StringBuilder sb, int i, zzuh.zze zze) {
        if (zze != null) {
            m7793a(sb, i);
            sb.append("bundle {\n");
            m7799a(sb, i, "protocol_version", (Object) zze.anu);
            m7799a(sb, i, "platform", (Object) zze.anC);
            m7799a(sb, i, "gmp_version", (Object) zze.anG);
            m7799a(sb, i, "uploading_gmp_version", (Object) zze.anH);
            m7799a(sb, i, "gmp_app_id", (Object) zze.aic);
            m7799a(sb, i, "app_id", (Object) zze.zzck);
            m7799a(sb, i, "app_version", (Object) zze.aav);
            m7799a(sb, i, "app_version_major", (Object) zze.anP);
            m7799a(sb, i, "firebase_instance_id", (Object) zze.aik);
            m7799a(sb, i, "dev_cert_hash", (Object) zze.anL);
            m7799a(sb, i, "app_store", (Object) zze.aid);
            m7799a(sb, i, "upload_timestamp_millis", (Object) zze.anx);
            m7799a(sb, i, "start_timestamp_millis", (Object) zze.any);
            m7799a(sb, i, "end_timestamp_millis", (Object) zze.anz);
            m7799a(sb, i, "previous_bundle_start_timestamp_millis", (Object) zze.anA);
            m7799a(sb, i, "previous_bundle_end_timestamp_millis", (Object) zze.anB);
            m7799a(sb, i, "app_instance_id", (Object) zze.anK);
            m7799a(sb, i, "resettable_device_id", (Object) zze.anI);
            m7799a(sb, i, "device_id", (Object) zze.anS);
            m7799a(sb, i, "limited_ad_tracking", (Object) zze.anJ);
            m7799a(sb, i, "os_version", (Object) zze.zzct);
            m7799a(sb, i, "device_model", (Object) zze.anD);
            m7799a(sb, i, "user_default_language", (Object) zze.anE);
            m7799a(sb, i, "time_zone_offset_minutes", (Object) zze.anF);
            m7799a(sb, i, "bundle_sequential_index", (Object) zze.anM);
            m7799a(sb, i, "service_upload", (Object) zze.anN);
            m7799a(sb, i, "health_monitor", (Object) zze.aig);
            m7803a(sb, i, zze.anw);
            m7800a(sb, i, zze.anO);
            m7801a(sb, i, zze.anv);
            m7793a(sb, i);
            sb.append("}\n");
        }
    }

    /* renamed from: a */
    private static void m7796a(StringBuilder sb, int i, String str, zzuf.zzd zzd) {
        if (zzd != null) {
            m7793a(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzd.amN != null) {
                String str2 = "UNKNOWN_COMPARISON_TYPE";
                switch (zzd.amN.intValue()) {
                    case 1:
                        str2 = "LESS_THAN";
                        break;
                    case 2:
                        str2 = "GREATER_THAN";
                        break;
                    case 3:
                        str2 = "EQUAL";
                        break;
                    case 4:
                        str2 = "BETWEEN";
                        break;
                }
                m7799a(sb, i, "comparison_type", (Object) str2);
            }
            m7799a(sb, i, "match_as_float", (Object) zzd.amO);
            m7799a(sb, i, "comparison_value", (Object) zzd.amP);
            m7799a(sb, i, "min_comparison_value", (Object) zzd.amQ);
            m7799a(sb, i, "max_comparison_value", (Object) zzd.amR);
            m7793a(sb, i);
            sb.append("}\n");
        }
    }

    /* renamed from: a */
    private static void m7797a(StringBuilder sb, int i, String str, zzuf.zzf zzf) {
        if (zzf != null) {
            m7793a(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzf.amV != null) {
                String str2 = "UNKNOWN_MATCH_TYPE";
                switch (zzf.amV.intValue()) {
                    case 1:
                        str2 = "REGEXP";
                        break;
                    case 2:
                        str2 = "BEGINS_WITH";
                        break;
                    case 3:
                        str2 = "ENDS_WITH";
                        break;
                    case 4:
                        str2 = "PARTIAL";
                        break;
                    case 5:
                        str2 = "EXACT";
                        break;
                    case 6:
                        str2 = "IN_LIST";
                        break;
                }
                m7799a(sb, i, "match_type", (Object) str2);
            }
            m7799a(sb, i, "expression", (Object) zzf.amW);
            m7799a(sb, i, "case_sensitive", (Object) zzf.amX);
            if (zzf.amY.length > 0) {
                m7793a(sb, i + 1);
                sb.append("expression_list {\n");
                for (String append : zzf.amY) {
                    m7793a(sb, i + 2);
                    sb.append(append);
                    sb.append("\n");
                }
                sb.append("}\n");
            }
            m7793a(sb, i);
            sb.append("}\n");
        }
    }

    /* renamed from: a */
    private static void m7798a(StringBuilder sb, int i, String str, zzuh.zzf zzf) {
        int i2 = 0;
        if (zzf != null) {
            int i3 = i + 1;
            m7793a(sb, i3);
            sb.append(str);
            sb.append(" {\n");
            if (zzf.anU != null) {
                m7793a(sb, i3 + 1);
                sb.append("results: ");
                long[] jArr = zzf.anU;
                int length = jArr.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length) {
                    Long valueOf = Long.valueOf(jArr[i4]);
                    int i6 = i5 + 1;
                    if (i5 != 0) {
                        sb.append(", ");
                    }
                    sb.append(valueOf);
                    i4++;
                    i5 = i6;
                }
                sb.append(10);
            }
            if (zzf.anT != null) {
                m7793a(sb, i3 + 1);
                sb.append("status: ");
                long[] jArr2 = zzf.anT;
                int length2 = jArr2.length;
                int i7 = 0;
                while (i2 < length2) {
                    Long valueOf2 = Long.valueOf(jArr2[i2]);
                    int i8 = i7 + 1;
                    if (i7 != 0) {
                        sb.append(", ");
                    }
                    sb.append(valueOf2);
                    i2++;
                    i7 = i8;
                }
                sb.append(10);
            }
            m7793a(sb, i3);
            sb.append("}\n");
        }
    }

    /* renamed from: a */
    private static void m7799a(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            m7793a(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    /* renamed from: a */
    private static void m7800a(StringBuilder sb, int i, zzuh.zza[] zzaArr) {
        if (zzaArr != null) {
            int i2 = i + 1;
            for (zzuh.zza zza : zzaArr) {
                if (zza != null) {
                    m7793a(sb, i2);
                    sb.append("audience_membership {\n");
                    m7799a(sb, i2, "audience_id", (Object) zza.amz);
                    m7799a(sb, i2, "new_audience", (Object) zza.anl);
                    m7798a(sb, i2, "current_data", zza.anj);
                    m7798a(sb, i2, "previous_data", zza.ank);
                    m7793a(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    /* renamed from: a */
    private static void m7801a(StringBuilder sb, int i, zzuh.zzb[] zzbArr) {
        if (zzbArr != null) {
            int i2 = i + 1;
            for (zzuh.zzb zzb : zzbArr) {
                if (zzb != null) {
                    m7793a(sb, i2);
                    sb.append("event {\n");
                    m7799a(sb, i2, "name", (Object) zzb.name);
                    m7799a(sb, i2, "timestamp_millis", (Object) zzb.ano);
                    m7799a(sb, i2, "previous_timestamp_millis", (Object) zzb.anp);
                    m7799a(sb, i2, "count", (Object) zzb.count);
                    m7802a(sb, i2, zzb.ann);
                    m7793a(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    /* renamed from: a */
    private static void m7802a(StringBuilder sb, int i, zzuh.zzc[] zzcArr) {
        if (zzcArr != null) {
            int i2 = i + 1;
            for (zzuh.zzc zzc : zzcArr) {
                if (zzc != null) {
                    m7793a(sb, i2);
                    sb.append("param {\n");
                    m7799a(sb, i2, "name", (Object) zzc.name);
                    m7799a(sb, i2, "string_value", (Object) zzc.f7019zD);
                    m7799a(sb, i2, "int_value", (Object) zzc.anr);
                    m7799a(sb, i2, "double_value", (Object) zzc.amw);
                    m7793a(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    /* renamed from: a */
    private static void m7803a(StringBuilder sb, int i, zzuh.zzg[] zzgArr) {
        if (zzgArr != null) {
            int i2 = i + 1;
            for (zzuh.zzg zzg : zzgArr) {
                if (zzg != null) {
                    m7793a(sb, i2);
                    sb.append("user_property {\n");
                    m7799a(sb, i2, "set_timestamp_millis", (Object) zzg.anW);
                    m7799a(sb, i2, "name", (Object) zzg.name);
                    m7799a(sb, i2, "string_value", (Object) zzg.f7022zD);
                    m7799a(sb, i2, "int_value", (Object) zzg.anr);
                    m7799a(sb, i2, "double_value", (Object) zzg.amw);
                    m7793a(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    /* renamed from: a */
    static boolean m7804a(String str) {
        zzab.zzhr(str);
        return str.charAt(0) != '_';
    }

    /* renamed from: c */
    static MessageDigest m7805c(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return null;
            }
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i = i2 + 1;
            } catch (NoSuchAlgorithmException e) {
            }
        }
    }

    /* renamed from: d */
    private int m7806d(String str) {
        return "_ldl".equals(str) ? zzbsf().zzbqt() : zzbsf().zzbqs();
    }

    public static String zza(zzuf.zzb zzb) {
        if (zzb == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        m7799a(sb, 0, "filter_id", (Object) zzb.amD);
        m7799a(sb, 0, "event_name", (Object) zzb.amE);
        m7796a(sb, 1, "event_count_filter", zzb.amH);
        sb.append("  filters {\n");
        for (zzuf.zzc a : zzb.amF) {
            m7794a(sb, 2, a);
        }
        m7793a(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    public static String zza(zzuf.zze zze) {
        if (zze == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        m7799a(sb, 0, "filter_id", (Object) zze.amD);
        m7799a(sb, 0, "property_name", (Object) zze.amT);
        m7794a(sb, 1, zze.amU);
        sb.append("}\n");
        return sb.toString();
    }

    public static boolean zza(long[] jArr, int i) {
        return i < jArr.length * 64 && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    public static long[] zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        int i = 0;
        while (i < length) {
            jArr[i] = 0;
            int i2 = 0;
            while (i2 < 64 && (i * 64) + i2 < bitSet.length()) {
                if (bitSet.get((i * 64) + i2)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
                i2++;
            }
            i++;
        }
        return jArr;
    }

    public static boolean zzam(Bundle bundle) {
        return bundle.getLong("_c") == 1;
    }

    public static String zzb(zzuh.zzd zzd) {
        if (zzd == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (zzd.ans != null) {
            for (zzuh.zze zze : zzd.ans) {
                if (zze != null) {
                    m7795a(sb, 1, zze);
                }
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    public static boolean zzb(Context context, String str, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, str), 2);
            return receiverInfo != null && receiverInfo.enabled && (!z || receiverInfo.exported);
        } catch (PackageManager.NameNotFoundException e) {
        }
    }

    public static boolean zzbb(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static boolean zzj(Context context, String str) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, str), 4);
            return serviceInfo != null && serviceInfo.enabled;
        } catch (PackageManager.NameNotFoundException e) {
        }
    }

    public static boolean zzmt(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo9430a(String str, int i, String str2) {
        if (str2 == null) {
            zzbsd().zzbsv().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() <= i) {
            return true;
        } else {
            zzbsd().zzbsv().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo9431a(String str, String str2) {
        if (str2 == null) {
            zzbsd().zzbsv().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzbsd().zzbsv().zzj("Name is required and can't be empty. Type", str);
            return false;
        } else if (!Character.isLetter(str2.charAt(0))) {
            zzbsd().zzbsv().zze("Name must start with a letter. Type, name", str, str2);
            return false;
        } else {
            int i = 1;
            while (i < str2.length()) {
                char charAt = str2.charAt(i);
                if (charAt == '_' || Character.isLetterOrDigit(charAt)) {
                    i++;
                } else {
                    zzbsd().zzbsv().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo9432a(String str, String str2, int i, Object obj) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            return false;
        }
        String valueOf = String.valueOf(obj);
        if (valueOf.length() <= i) {
            return true;
        }
        zzbsd().zzbsx().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo9433a(String str, Map map, String str2) {
        if (str2 == null) {
            zzbsd().zzbsv().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.startsWith("firebase_")) {
            zzbsd().zzbsv().zze("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        } else if (map == null || !map.containsKey(str2)) {
            return true;
        } else {
            zzbsd().zzbsv().zze("Name is reserved. Type, name", str, str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo9434b(String str) {
        zzab.zzy(str);
        return str.matches("^1:\\d+:android:[a-f0-9]+$");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo9435b(String str, String str2) {
        if (str2 == null) {
            zzbsd().zzbsv().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzbsd().zzbsv().zzj("Name is required and can't be empty. Type", str);
            return false;
        } else {
            char charAt = str2.charAt(0);
            if (Character.isLetter(charAt) || charAt == '_') {
                int i = 1;
                while (i < str2.length()) {
                    char charAt2 = str2.charAt(i);
                    if (charAt2 == '_' || Character.isLetterOrDigit(charAt2)) {
                        i++;
                    } else {
                        zzbsd().zzbsv().zze("Name must start with a letter or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzbsd().zzbsv().zze("Name must start with a letter or _ (underscores). Type, name", str, str2);
            return false;
        }
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public Bundle zza(String str, Bundle bundle, List list, boolean z) {
        int i;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int zzbqm = zzbsf().zzbqm();
        int i2 = 0;
        for (String str2 : bundle.keySet()) {
            if (list == null || !list.contains(str2)) {
                i = z ? zzmo(str2) : 0;
                if (i == 0) {
                    i = zzmp(str2);
                }
            } else {
                i = 0;
            }
            if (i != 0) {
                if (zzd(bundle2, i)) {
                    bundle2.putString("_ev", zza(str2, zzbsf().mo9466b(), true));
                }
                bundle2.remove(str2);
            } else if (!zzk(str2, bundle.get(str2)) && !"_ev".equals(str2)) {
                if (zzd(bundle2, 4)) {
                    bundle2.putString("_ev", zza(str2, zzbsf().mo9466b(), true));
                }
                bundle2.remove(str2);
            } else if (!m7804a(str2) || (i2 = i2 + 1) <= zzbqm) {
                i2 = i2;
            } else {
                zzbsd().zzbsv().zze(new StringBuilder(48).append("Event can't contain more then ").append(zzbqm).append(" params").toString(), str, bundle);
                zzd(bundle2, 5);
                bundle2.remove(str2);
            }
        }
        return bundle2;
    }

    public String zza(String str, int i, boolean z) {
        if (str.length() <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, i)).concat("...");
        }
        return null;
    }

    public void zza(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (str != null) {
                zzbsd().zzbsz().zze("Not putting event parameter. Invalid value type. name, type", str, obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public void zza(zzuh.zzc zzc, Object obj) {
        zzab.zzy(obj);
        zzc.f7019zD = null;
        zzc.anr = null;
        zzc.amw = null;
        if (obj instanceof String) {
            zzc.f7019zD = (String) obj;
        } else if (obj instanceof Long) {
            zzc.anr = (Long) obj;
        } else if (obj instanceof Double) {
            zzc.amw = (Double) obj;
        } else {
            zzbsd().zzbsv().zzj("Ignoring invalid (type) event param value", obj);
        }
    }

    public void zza(zzuh.zzg zzg, Object obj) {
        zzab.zzy(obj);
        zzg.f7022zD = null;
        zzg.anr = null;
        zzg.amw = null;
        if (obj instanceof String) {
            zzg.f7022zD = (String) obj;
        } else if (obj instanceof Long) {
            zzg.anr = (Long) obj;
        } else if (obj instanceof Double) {
            zzg.amw = (Double) obj;
        } else {
            zzbsd().zzbsv().zzj("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public byte[] zza(zzuh.zzd zzd) {
        try {
            byte[] bArr = new byte[zzd.mo8049aM()];
            zzapo zzbe = zzapo.zzbe(bArr);
            zzd.zza(zzbe);
            zzbe.mo7988az();
            return bArr;
        } catch (IOException e) {
            zzbsd().zzbsv().zzj("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public /* bridge */ /* synthetic */ void zzbrs() {
        super.zzbrs();
    }

    public /* bridge */ /* synthetic */ C1889ag zzbrt() {
        return super.zzbrt();
    }

    public /* bridge */ /* synthetic */ zzac zzbru() {
        return super.zzbru();
    }

    public /* bridge */ /* synthetic */ zzn zzbrv() {
        return super.zzbrv();
    }

    public /* bridge */ /* synthetic */ zzg zzbrw() {
        return super.zzbrw();
    }

    public /* bridge */ /* synthetic */ zzad zzbrx() {
        return super.zzbrx();
    }

    public /* bridge */ /* synthetic */ zze zzbry() {
        return super.zzbry();
    }

    public /* bridge */ /* synthetic */ zzal zzbrz() {
        return super.zzbrz();
    }

    public /* bridge */ /* synthetic */ zzv zzbsa() {
        return super.zzbsa();
    }

    public /* bridge */ /* synthetic */ zzaf zzbsb() {
        return super.zzbsb();
    }

    public /* bridge */ /* synthetic */ zzw zzbsc() {
        return super.zzbsc();
    }

    public /* bridge */ /* synthetic */ zzp zzbsd() {
        return super.zzbsd();
    }

    public /* bridge */ /* synthetic */ zzt zzbse() {
        return super.zzbse();
    }

    public /* bridge */ /* synthetic */ zzd zzbsf() {
        return super.zzbsf();
    }

    public boolean zzd(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    public void zze(int i, String str, String str2) {
        Bundle bundle = new Bundle();
        zzd(bundle, i);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(str, str2);
        }
        this.f7189n.zzbru().zze("auto", "_err", bundle);
    }

    public boolean zzeo(String str) {
        zzwu();
        if (getContext().checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzbsd().zzbtb().zzj("Permission not granted", str);
        return false;
    }

    public boolean zzg(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzyw().currentTimeMillis() - j) > j2;
    }

    public byte[] zzj(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzbsd().zzbsv().zzj("Failed to gzip content", e);
            throw e;
        }
    }

    public boolean zzk(String str, Object obj) {
        return zzmt(str) ? mo9432a("param", str, zzbsf().mo9469d(), obj) : mo9432a("param", str, zzbsf().mo9468c(), obj);
    }

    public Object zzl(String str, Object obj) {
        if ("_ev".equals(str)) {
            return m7792a(zzbsf().mo9469d(), obj, true);
        }
        return m7792a(zzmt(str) ? zzbsf().mo9469d() : zzbsf().mo9468c(), obj, false);
    }

    public int zzm(String str, Object obj) {
        return "_ldl".equals(str) ? mo9432a("user property referrer", str, m7806d(str), obj) : mo9432a("user property", str, m7806d(str), obj) ? 0 : 7;
    }

    public int zzmk(String str) {
        if (!mo9431a("event", str)) {
            return 2;
        }
        if (!mo9433a("event", AppMeasurement.zza.ahE, str)) {
            return 13;
        }
        return mo9430a("event", zzbsf().zzbqn(), str) ? 0 : 2;
    }

    public int zzml(String str) {
        if (!mo9435b("event", str)) {
            return 2;
        }
        if (!mo9433a("event", AppMeasurement.zza.ahE, str)) {
            return 13;
        }
        return mo9430a("event", zzbsf().zzbqn(), str) ? 0 : 2;
    }

    public int zzmm(String str) {
        if (!mo9431a("user property", str)) {
            return 6;
        }
        if (!mo9433a("user property", AppMeasurement.zze.ahG, str)) {
            return 15;
        }
        return mo9430a("user property", zzbsf().zzbqo(), str) ? 0 : 6;
    }

    public int zzmn(String str) {
        if (!mo9435b("user property", str)) {
            return 6;
        }
        if (!mo9433a("user property", AppMeasurement.zze.ahG, str)) {
            return 15;
        }
        return mo9430a("user property", zzbsf().zzbqo(), str) ? 0 : 6;
    }

    public int zzmo(String str) {
        if (!mo9431a("event param", str)) {
            return 3;
        }
        if (!mo9433a("event param", (Map) null, str)) {
            return 14;
        }
        return mo9430a("event param", zzbsf().mo9466b(), str) ? 0 : 3;
    }

    public int zzmp(String str) {
        if (!mo9435b("event param", str)) {
            return 3;
        }
        if (!mo9433a("event param", (Map) null, str)) {
            return 14;
        }
        return mo9430a("event param", zzbsf().mo9466b(), str) ? 0 : 3;
    }

    public boolean zzmq(String str) {
        if (TextUtils.isEmpty(str)) {
            zzbsd().zzbsv().log("Measurement Service called without google_app_id");
            return false;
        } else if (!str.startsWith("1:")) {
            zzbsd().zzbsx().zzj("Measurement Service called with unknown id version", str);
            return true;
        } else if (mo9434b(str)) {
            return true;
        } else {
            zzbsd().zzbsv().zzj("Invalid google_app_id. Firebase Analytics disabled. See", "https://goo.gl/FZRIUV");
            return false;
        }
    }

    public Object zzn(String str, Object obj) {
        return "_ldl".equals(str) ? m7792a(m7806d(str), obj, true) : m7792a(m7806d(str), obj, false);
    }

    public byte[] zzw(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e) {
            zzbsd().zzbsv().zzj("Failed to ungzip content", e);
            throw e;
        }
    }

    public /* bridge */ /* synthetic */ void zzwu() {
        super.zzwu();
    }

    public long zzy(byte[] bArr) {
        zzab.zzy(bArr);
        MessageDigest c = m7805c("MD5");
        if (c != null) {
            return m7791a(c.digest(bArr));
        }
        zzbsd().zzbsv().log("Failed to get MD5");
        return 0;
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
