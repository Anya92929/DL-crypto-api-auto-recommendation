package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.zza {
    public static final zzb CREATOR = new zzb();

    /* renamed from: a */
    private final int f4629a;

    /* renamed from: b */
    private final HashMap f4630b;

    /* renamed from: c */
    private final SparseArray f4631c;

    /* renamed from: d */
    private final ArrayList f4632d;

    public final class Entry extends AbstractSafeParcelable {
        public static final zzc CREATOR = new zzc();

        /* renamed from: a */
        final int f4633a;

        /* renamed from: b */
        final String f4634b;

        /* renamed from: c */
        final int f4635c;

        Entry(int i, String str, int i2) {
            this.f4633a = i;
            this.f4634b = str;
            this.f4635c = i2;
        }

        Entry(String str, int i) {
            this.f4633a = 1;
            this.f4634b = str;
            this.f4635c = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzc zzc = CREATOR;
            zzc.m6151a(this, parcel, i);
        }
    }

    public StringToIntConverter() {
        this.f4629a = 1;
        this.f4630b = new HashMap();
        this.f4631c = new SparseArray();
        this.f4632d = null;
    }

    StringToIntConverter(int i, ArrayList arrayList) {
        this.f4629a = i;
        this.f4630b = new HashMap();
        this.f4631c = new SparseArray();
        this.f4632d = null;
        m6146a(arrayList);
    }

    /* renamed from: a */
    private void m6146a(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzi(entry.f4634b, entry.f4635c);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6779a() {
        return this.f4629a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ArrayList mo6780b() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.f4630b.keySet()) {
            arrayList.add(new Entry(str, ((Integer) this.f4630b.get(str)).intValue()));
        }
        return arrayList;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb zzb = CREATOR;
        zzb.m6150a(this, parcel, i);
    }

    public int zzatt() {
        return 7;
    }

    public int zzatu() {
        return 0;
    }

    /* renamed from: zzd */
    public String convertBack(Integer num) {
        String str = (String) this.f4631c.get(num.intValue());
        return (str != null || !this.f4630b.containsKey("gms_unknown")) ? str : "gms_unknown";
    }

    public StringToIntConverter zzi(String str, int i) {
        this.f4630b.put(str, Integer.valueOf(i));
        this.f4631c.put(i, str);
        return this;
    }
}
