package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class GestureRequest implements SafeParcelable {
    public static final C1146l CREATOR = new C1146l();

    /* renamed from: a */
    private static final List<Integer> f4884a = Collections.unmodifiableList(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}));

    /* renamed from: b */
    private static final List<Integer> f4885b = Collections.unmodifiableList(Arrays.asList(new Integer[]{1}));

    /* renamed from: c */
    private static final List<Integer> f4886c = Collections.unmodifiableList(Arrays.asList(new Integer[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 19}));

    /* renamed from: d */
    private static final List<Integer> f4887d = Collections.unmodifiableList(Arrays.asList(new Integer[]{3, 5, 7, 9, 11, 13, 15, 17}));

    /* renamed from: e */
    private final int f4888e;

    /* renamed from: f */
    private final List<Integer> f4889f;

    GestureRequest(int i, List<Integer> list) {
        this.f4888e = i;
        this.f4889f = list;
    }

    /* renamed from: a */
    public int mo7732a() {
        return this.f4888e;
    }

    /* renamed from: b */
    public List<Integer> mo7733b() {
        return this.f4889f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1146l.m4972a(this, parcel, i);
    }
}
