package com.google.android.gms.internal;

import com.google.android.gms.internal.zzct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@zzin
public class zzcq {

    /* renamed from: a */
    private final int f6077a;

    /* renamed from: b */
    private final int f6078b;

    /* renamed from: c */
    private final int f6079c;

    /* renamed from: d */
    private final zzcp f6080d = new zzcs();

    public zzcq(int i) {
        this.f6078b = i;
        this.f6077a = 6;
        this.f6079c = 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1525ei mo8236a() {
        return new C1525ei();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo8237a(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        C1525ei a = mo8236a();
        PriorityQueue priorityQueue = new PriorityQueue(this.f6078b, new C1524eh(this));
        for (String zzad : split) {
            String[] zzad2 = zzcr.zzad(zzad);
            if (zzad2.length != 0) {
                zzct.zza(zzad2, this.f6078b, this.f6077a, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                a.mo7228a(this.f6080d.zzaa(((zzct.zza) it.next()).f6083b));
            } catch (IOException e) {
                zzkd.zzb("Error while writing hash to byteStream", e);
            }
        }
        return a.toString();
    }

    public String zza(ArrayList arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((String) it.next()).toLowerCase(Locale.US));
            stringBuffer.append(10);
        }
        return mo8237a(stringBuffer.toString());
    }
}
