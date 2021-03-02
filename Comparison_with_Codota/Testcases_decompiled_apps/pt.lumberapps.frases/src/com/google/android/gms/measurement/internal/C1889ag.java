package com.google.android.gms.measurement.internal;

import android.support.p009v4.p019f.C0136a;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzuf;
import com.google.android.gms.internal.zzuh;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.measurement.internal.ag */
class C1889ag extends C1923c {
    C1889ag(zzx zzx) {
        super(zzx);
    }

    /* renamed from: a */
    private Boolean m7622a(zzuf.zzb zzb, zzuh.zzb zzb2, long j) {
        if (zzb.amH != null) {
            Boolean a = new C1903au(zzb.amH).mo9257a(j);
            if (a == null) {
                return null;
            }
            if (!a.booleanValue()) {
                return false;
            }
        }
        HashSet hashSet = new HashSet();
        for (zzuf.zzc zzc : zzb.amF) {
            if (TextUtils.isEmpty(zzc.amM)) {
                zzbsd().zzbsx().zzj("null or empty param name in filter. event", zzb2.name);
                return null;
            }
            hashSet.add(zzc.amM);
        }
        C0136a aVar = new C0136a();
        for (zzuh.zzc zzc2 : zzb2.ann) {
            if (hashSet.contains(zzc2.name)) {
                if (zzc2.anr != null) {
                    aVar.put(zzc2.name, zzc2.anr);
                } else if (zzc2.amw != null) {
                    aVar.put(zzc2.name, zzc2.amw);
                } else if (zzc2.f7019zD != null) {
                    aVar.put(zzc2.name, zzc2.f7019zD);
                } else {
                    zzbsd().zzbsx().zze("Unknown value for param. event, param", zzb2.name, zzc2.name);
                    return null;
                }
            }
        }
        for (zzuf.zzc zzc3 : zzb.amF) {
            boolean equals = Boolean.TRUE.equals(zzc3.amL);
            String str = zzc3.amM;
            if (TextUtils.isEmpty(str)) {
                zzbsd().zzbsx().zzj("Event has empty param name. event", zzb2.name);
                return null;
            }
            Object obj = aVar.get(str);
            if (obj instanceof Long) {
                if (zzc3.amK == null) {
                    zzbsd().zzbsx().zze("No number filter for long param. event, param", zzb2.name, str);
                    return null;
                }
                Boolean a2 = new C1903au(zzc3.amK).mo9257a(((Long) obj).longValue());
                if (a2 == null) {
                    return null;
                }
                if ((!a2.booleanValue()) ^ equals) {
                    return false;
                }
            } else if (obj instanceof Double) {
                if (zzc3.amK == null) {
                    zzbsd().zzbsx().zze("No number filter for double param. event, param", zzb2.name, str);
                    return null;
                }
                Boolean a3 = new C1903au(zzc3.amK).mo9256a(((Double) obj).doubleValue());
                if (a3 == null) {
                    return null;
                }
                if ((!a3.booleanValue()) ^ equals) {
                    return false;
                }
            } else if (obj instanceof String) {
                if (zzc3.amJ == null) {
                    zzbsd().zzbsx().zze("No string filter for String param. event, param", zzb2.name, str);
                    return null;
                }
                Boolean a4 = new C1886ad(zzc3.amJ).mo9218a((String) obj);
                if (a4 == null) {
                    return null;
                }
                if ((!a4.booleanValue()) ^ equals) {
                    return false;
                }
            } else if (obj == null) {
                zzbsd().zzbtc().zze("Missing param for filter. event, param", zzb2.name, str);
                return false;
            } else {
                zzbsd().zzbsx().zze("Unknown param type. event, param", zzb2.name, str);
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    private Boolean m7623a(zzuf.zze zze, zzuh.zzg zzg) {
        zzuf.zzc zzc = zze.amU;
        if (zzc == null) {
            zzbsd().zzbsx().zzj("Missing property filter. property", zzg.name);
            return null;
        }
        boolean equals = Boolean.TRUE.equals(zzc.amL);
        if (zzg.anr != null) {
            if (zzc.amK != null) {
                return m7624a(new C1903au(zzc.amK).mo9257a(zzg.anr.longValue()), equals);
            }
            zzbsd().zzbsx().zzj("No number filter for long property. property", zzg.name);
            return null;
        } else if (zzg.amw != null) {
            if (zzc.amK != null) {
                return m7624a(new C1903au(zzc.amK).mo9256a(zzg.amw.doubleValue()), equals);
            }
            zzbsd().zzbsx().zzj("No number filter for double property. property", zzg.name);
            return null;
        } else if (zzg.f7022zD == null) {
            zzbsd().zzbsx().zzj("User property has no value, property", zzg.name);
            return null;
        } else if (zzc.amJ != null) {
            return m7624a(new C1886ad(zzc.amJ).mo9218a(zzg.f7022zD), equals);
        } else {
            if (zzc.amK == null) {
                zzbsd().zzbsx().zzj("No string or number filter defined. property", zzg.name);
                return null;
            }
            C1903au auVar = new C1903au(zzc.amK);
            if (zzc.amK.amO == null || !zzc.amK.amO.booleanValue()) {
                if (mo9223a(zzg.f7022zD)) {
                    try {
                        return m7624a(auVar.mo9257a(Long.parseLong(zzg.f7022zD)), equals);
                    } catch (NumberFormatException e) {
                        zzbsd().zzbsx().zze("User property value exceeded Long value range. property, value", zzg.name, zzg.f7022zD);
                        return null;
                    }
                } else {
                    zzbsd().zzbsx().zze("Invalid user property value for Long number filter. property, value", zzg.name, zzg.f7022zD);
                    return null;
                }
            } else if (mo9225b(zzg.f7022zD)) {
                try {
                    double parseDouble = Double.parseDouble(zzg.f7022zD);
                    if (!Double.isInfinite(parseDouble)) {
                        return m7624a(auVar.mo9256a(parseDouble), equals);
                    }
                    zzbsd().zzbsx().zze("User property value exceeded Double value range. property, value", zzg.name, zzg.f7022zD);
                    return null;
                } catch (NumberFormatException e2) {
                    zzbsd().zzbsx().zze("User property value exceeded Double value range. property, value", zzg.name, zzg.f7022zD);
                    return null;
                }
            } else {
                zzbsd().zzbsx().zze("Invalid user property value for Double number filter. property, value", zzg.name, zzg.f7022zD);
                return null;
            }
        }
    }

    /* renamed from: a */
    static Boolean m7624a(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() ^ z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9222a(String str, zzuf.zza[] zzaArr) {
        zzab.zzy(zzaArr);
        for (zzuf.zza zza : zzaArr) {
            for (zzuf.zzb zzb : zza.amB) {
                String str2 = (String) AppMeasurement.zza.ahE.get(zzb.amE);
                if (str2 != null) {
                    zzb.amE = str2;
                }
                for (zzuf.zzc zzc : zzb.amF) {
                    String str3 = (String) AppMeasurement.zzd.ahF.get(zzc.amM);
                    if (str3 != null) {
                        zzc.amM = str3;
                    }
                }
            }
            for (zzuf.zze zze : zza.amA) {
                String str4 = (String) AppMeasurement.zze.ahG.get(zze.amT);
                if (str4 != null) {
                    zze.amT = str4;
                }
            }
        }
        zzbry().mo9528a(str, zzaArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo9223a(String str) {
        return Pattern.matches("[+-]?[0-9]+", str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public zzuh.zza[] mo9224a(String str, zzuh.zzb[] zzbArr, zzuh.zzg[] zzgArr) {
        Map map;
        zzuf.zze zze;
        C1894al a;
        Map map2;
        zzab.zzhr(str);
        HashSet hashSet = new HashSet();
        C0136a aVar = new C0136a();
        C0136a aVar2 = new C0136a();
        C0136a aVar3 = new C0136a();
        Map f = zzbry().mo9544f(str);
        if (f != null) {
            for (Integer intValue : f.keySet()) {
                int intValue2 = intValue.intValue();
                zzuh.zzf zzf = (zzuh.zzf) f.get(Integer.valueOf(intValue2));
                BitSet bitSet = (BitSet) aVar2.get(Integer.valueOf(intValue2));
                BitSet bitSet2 = (BitSet) aVar3.get(Integer.valueOf(intValue2));
                if (bitSet == null) {
                    bitSet = new BitSet();
                    aVar2.put(Integer.valueOf(intValue2), bitSet);
                    bitSet2 = new BitSet();
                    aVar3.put(Integer.valueOf(intValue2), bitSet2);
                }
                for (int i = 0; i < zzf.anT.length * 64; i++) {
                    if (zzal.zza(zzf.anT, i)) {
                        zzbsd().zzbtc().zze("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue2), Integer.valueOf(i));
                        bitSet2.set(i);
                        if (zzal.zza(zzf.anU, i)) {
                            bitSet.set(i);
                        }
                    }
                }
                zzuh.zza zza = new zzuh.zza();
                aVar.put(Integer.valueOf(intValue2), zza);
                zza.anl = false;
                zza.ank = zzf;
                zza.anj = new zzuh.zzf();
                zza.anj.anU = zzal.zza(bitSet);
                zza.anj.anT = zzal.zza(bitSet2);
            }
        }
        if (zzbArr != null) {
            C0136a aVar4 = new C0136a();
            int length = zzbArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                zzuh.zzb zzb = zzbArr[i3];
                C1894al a2 = zzbry().mo9514a(str, zzb.name);
                if (a2 == null) {
                    zzbsd().zzbsx().zzj("Event aggregate wasn't created during raw event logging. event", zzb.name);
                    a = new C1894al(str, zzb.name, 1, 1, zzb.ano.longValue());
                } else {
                    a = a2.mo9237a();
                }
                zzbry().mo9521a(a);
                long j = a.f7094c;
                Map map3 = (Map) aVar4.get(zzb.name);
                if (map3 == null) {
                    Map d = zzbry().mo9539d(str, zzb.name);
                    if (d == null) {
                        d = new C0136a();
                    }
                    aVar4.put(zzb.name, d);
                    map2 = d;
                } else {
                    map2 = map3;
                }
                zzbsd().zzbtc().zze("event, affected audience count", zzb.name, Integer.valueOf(map2.size()));
                for (Integer intValue3 : map2.keySet()) {
                    int intValue4 = intValue3.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue4))) {
                        zzbsd().zzbtc().zzj("Skipping failed audience ID", Integer.valueOf(intValue4));
                    } else {
                        zzuh.zza zza2 = (zzuh.zza) aVar.get(Integer.valueOf(intValue4));
                        BitSet bitSet3 = (BitSet) aVar2.get(Integer.valueOf(intValue4));
                        BitSet bitSet4 = (BitSet) aVar3.get(Integer.valueOf(intValue4));
                        if (zza2 == null) {
                            zzuh.zza zza3 = new zzuh.zza();
                            aVar.put(Integer.valueOf(intValue4), zza3);
                            zza3.anl = true;
                            bitSet3 = new BitSet();
                            aVar2.put(Integer.valueOf(intValue4), bitSet3);
                            bitSet4 = new BitSet();
                            aVar3.put(Integer.valueOf(intValue4), bitSet4);
                        }
                        for (zzuf.zzb zzb2 : (List) map2.get(Integer.valueOf(intValue4))) {
                            if (zzbsd().mo9592a(2)) {
                                zzbsd().zzbtc().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(intValue4), zzb2.amD, zzb2.amE);
                                zzbsd().zzbtc().zzj("Filter definition", zzal.zza(zzb2));
                            }
                            if (zzb2.amD == null || zzb2.amD.intValue() > 256) {
                                zzbsd().zzbsx().zzj("Invalid event filter ID. id", String.valueOf(zzb2.amD));
                            } else if (bitSet3.get(zzb2.amD.intValue())) {
                                zzbsd().zzbtc().zze("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue4), zzb2.amD);
                            } else {
                                Boolean a3 = m7622a(zzb2, zzb, j);
                                zzbsd().zzbtc().zzj("Event filter result", a3 == null ? "null" : a3);
                                if (a3 == null) {
                                    hashSet.add(Integer.valueOf(intValue4));
                                } else {
                                    bitSet4.set(zzb2.amD.intValue());
                                    if (a3.booleanValue()) {
                                        bitSet3.set(zzb2.amD.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
                i2 = i3 + 1;
            }
        }
        if (zzgArr != null) {
            C0136a aVar5 = new C0136a();
            for (zzuh.zzg zzg : zzgArr) {
                Map map4 = (Map) aVar5.get(zzg.name);
                if (map4 == null) {
                    Map e = zzbry().mo9541e(str, zzg.name);
                    if (e == null) {
                        e = new C0136a();
                    }
                    aVar5.put(zzg.name, e);
                    map = e;
                } else {
                    map = map4;
                }
                zzbsd().zzbtc().zze("property, affected audience count", zzg.name, Integer.valueOf(map.size()));
                for (Integer intValue5 : map.keySet()) {
                    int intValue6 = intValue5.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue6))) {
                        zzbsd().zzbtc().zzj("Skipping failed audience ID", Integer.valueOf(intValue6));
                    } else {
                        zzuh.zza zza4 = (zzuh.zza) aVar.get(Integer.valueOf(intValue6));
                        BitSet bitSet5 = (BitSet) aVar2.get(Integer.valueOf(intValue6));
                        BitSet bitSet6 = (BitSet) aVar3.get(Integer.valueOf(intValue6));
                        if (zza4 == null) {
                            zzuh.zza zza5 = new zzuh.zza();
                            aVar.put(Integer.valueOf(intValue6), zza5);
                            zza5.anl = true;
                            bitSet5 = new BitSet();
                            aVar2.put(Integer.valueOf(intValue6), bitSet5);
                            bitSet6 = new BitSet();
                            aVar3.put(Integer.valueOf(intValue6), bitSet6);
                        }
                        Iterator it = ((List) map.get(Integer.valueOf(intValue6))).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            zze = (zzuf.zze) it.next();
                            if (zzbsd().mo9592a(2)) {
                                zzbsd().zzbtc().zzd("Evaluating filter. audience, filter, property", Integer.valueOf(intValue6), zze.amD, zze.amT);
                                zzbsd().zzbtc().zzj("Filter definition", zzal.zza(zze));
                            }
                            if (zze.amD == null || zze.amD.intValue() > 256) {
                                zzbsd().zzbsx().zzj("Invalid property filter ID. id", String.valueOf(zze.amD));
                                hashSet.add(Integer.valueOf(intValue6));
                            } else if (bitSet5.get(zze.amD.intValue())) {
                                zzbsd().zzbtc().zze("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue6), zze.amD);
                            } else {
                                Boolean a4 = m7623a(zze, zzg);
                                zzbsd().zzbtc().zzj("Property filter result", a4 == null ? "null" : a4);
                                if (a4 == null) {
                                    hashSet.add(Integer.valueOf(intValue6));
                                } else {
                                    bitSet6.set(zze.amD.intValue());
                                    if (a4.booleanValue()) {
                                        bitSet5.set(zze.amD.intValue());
                                    }
                                }
                            }
                        }
                        zzbsd().zzbsx().zzj("Invalid property filter ID. id", String.valueOf(zze.amD));
                        hashSet.add(Integer.valueOf(intValue6));
                    }
                }
            }
        }
        zzuh.zza[] zzaArr = new zzuh.zza[aVar2.size()];
        int i4 = 0;
        for (Integer intValue7 : aVar2.keySet()) {
            int intValue8 = intValue7.intValue();
            if (!hashSet.contains(Integer.valueOf(intValue8))) {
                zzuh.zza zza6 = (zzuh.zza) aVar.get(Integer.valueOf(intValue8));
                if (zza6 == null) {
                    zza6 = new zzuh.zza();
                }
                zzuh.zza zza7 = zza6;
                zzaArr[i4] = zza7;
                zza7.amz = Integer.valueOf(intValue8);
                zza7.anj = new zzuh.zzf();
                zza7.anj.anU = zzal.zza((BitSet) aVar2.get(Integer.valueOf(intValue8)));
                zza7.anj.anT = zzal.zza((BitSet) aVar3.get(Integer.valueOf(intValue8)));
                zzbry().mo9525a(str, intValue8, zza7.anj);
                i4++;
            }
        }
        return (zzuh.zza[]) Arrays.copyOf(zzaArr, i4);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo9225b(String str) {
        return Pattern.matches("[+-]?(([0-9]+\\.?)|([0-9]*\\.[0-9]+))", str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo9226d() {
    }
}
