package com.google.android.gms.internal;

import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@zzin
/* renamed from: com.google.android.gms.internal.hi */
class C1606hi {

    /* renamed from: a */
    final AdRequestParcel f5083a;

    /* renamed from: b */
    final String f5084b;

    /* renamed from: c */
    final int f5085c;

    C1606hi(AdRequestParcel adRequestParcel, String str, int i) {
        this.f5083a = adRequestParcel;
        this.f5084b = str;
        this.f5085c = i;
    }

    C1606hi(C1604hg hgVar) {
        this(hgVar.mo7294a(), hgVar.mo7299c(), hgVar.mo7298b());
    }

    C1606hi(String str) {
        String[] split = str.split("\u0000");
        if (split.length != 3) {
            throw new IOException("Incorrect field count for QueueSeed.");
        }
        Parcel obtain = Parcel.obtain();
        try {
            this.f5084b = new String(Base64.decode(split[0], 0), "UTF-8");
            this.f5085c = Integer.parseInt(split[1]);
            byte[] decode = Base64.decode(split[2], 0);
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            this.f5083a = (AdRequestParcel) AdRequestParcel.CREATOR.createFromParcel(obtain);
            obtain.recycle();
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo7306a() {
        Parcel obtain = Parcel.obtain();
        try {
            String encodeToString = Base64.encodeToString(this.f5084b.getBytes("UTF-8"), 0);
            String num = Integer.toString(this.f5085c);
            this.f5083a.writeToParcel(obtain, 0);
            String encodeToString2 = Base64.encodeToString(obtain.marshall(), 0);
            String sb = new StringBuilder(String.valueOf(encodeToString).length() + 2 + String.valueOf(num).length() + String.valueOf(encodeToString2).length()).append(encodeToString).append("\u0000").append(num).append("\u0000").append(encodeToString2).toString();
            obtain.recycle();
            return sb;
        } catch (UnsupportedEncodingException e) {
            zzkd.m5769e("QueueSeed encode failed because UTF-8 is not available.");
            obtain.recycle();
            return "";
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }
}
