package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C1447kv;

public final class Device implements SafeParcelable {
    public static final Parcelable.Creator<Device> CREATOR = new C0616i();
    public static final int TYPE_CHEST_STRAP = 4;
    public static final int TYPE_PHONE = 1;
    public static final int TYPE_SCALE = 5;
    public static final int TYPE_TABLET = 2;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WATCH = 3;

    /* renamed from: BR */
    private final int f1332BR;

    /* renamed from: FD */
    private final int f1333FD;

    /* renamed from: SQ */
    private final String f1334SQ;

    /* renamed from: SR */
    private final String f1335SR;

    /* renamed from: SS */
    private final String f1336SS;

    /* renamed from: Sq */
    private final String f1337Sq;

    Device(int versionCode, String manufacturer, String model, String version, String uid, int type) {
        this.f1332BR = versionCode;
        this.f1334SQ = (String) C0348n.m861i(manufacturer);
        this.f1335SR = (String) C0348n.m861i(model);
        this.f1337Sq = "";
        this.f1336SS = (String) C0348n.m861i(uid);
        this.f1333FD = type;
    }

    public Device(String manufacturer, String model, String uid, int type) {
        this(1, manufacturer, model, "", uid, type);
    }

    public Device(String manufacturer, String model, String version, String uid, int type) {
        this(manufacturer, model, uid, type);
    }

    /* renamed from: M */
    private static int m1796M(Context context) {
        switch (m1798O(context)) {
            case 8:
            case 9:
                return 0;
            case 10:
                return m1797N(context) ? 3 : 0;
            default:
                return m1800Q(context) ? 1 : 2;
        }
    }

    /* renamed from: N */
    public static boolean m1797N(Context context) {
        return (context.getResources().getConfiguration().uiMode & 15) == 6;
    }

    /* renamed from: O */
    private static int m1798O(Context context) {
        return ((m1799P(context) % 1000) / 100) + 5;
    }

    /* renamed from: P */
    private static int m1799P(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("Fitness", "Could not find package info for Google Play Services");
            return -1;
        }
    }

    /* renamed from: Q */
    private static boolean m1800Q(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0;
    }

    /* renamed from: a */
    private boolean m1801a(Device device) {
        return C0345m.equal(this.f1334SQ, device.f1334SQ) && C0345m.equal(this.f1335SR, device.f1335SR) && C0345m.equal(this.f1337Sq, device.f1337Sq) && C0345m.equal(this.f1336SS, device.f1336SS) && this.f1333FD == device.f1333FD;
    }

    public static Device getLocalDevice(Context context) {
        return new Device(Build.MANUFACTURER, Build.MODEL, Build.VERSION.RELEASE, Build.SERIAL, m1796M(context));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Device) && m1801a((Device) that));
    }

    public String getManufacturer() {
        return this.f1334SQ;
    }

    public String getModel() {
        return this.f1335SR;
    }

    /* access modifiers changed from: package-private */
    public String getStreamIdentifier() {
        return String.format("%s:%s:%s", new Object[]{this.f1334SQ, this.f1335SR, this.f1336SS});
    }

    public int getType() {
        return this.f1333FD;
    }

    public String getUid() {
        return this.f1336SS;
    }

    public String getVersion() {
        return this.f1337Sq;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1332BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f1334SQ, this.f1335SR, this.f1337Sq, this.f1336SS, Integer.valueOf(this.f1333FD));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: iM */
    public Device mo5699iM() {
        return new Device(C1447kv.m5334bq(this.f1334SQ), C1447kv.m5334bq(this.f1335SR), C1447kv.m5334bq(this.f1337Sq), this.f1336SS, this.f1333FD);
    }

    /* renamed from: iN */
    public String mo5700iN() {
        return C1447kv.m5336iU() ? this.f1336SS : C1447kv.m5334bq(this.f1336SS);
    }

    public String toString() {
        return String.format("Device{%s:%s:%s}", new Object[]{getStreamIdentifier(), this.f1337Sq, Integer.valueOf(this.f1333FD)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0616i.m1852a(this, parcel, flags);
    }
}
