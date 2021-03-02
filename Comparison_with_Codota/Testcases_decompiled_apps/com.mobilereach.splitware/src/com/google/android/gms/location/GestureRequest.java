package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class GestureRequest implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    private static final List<Integer> zzaNP = Collections.unmodifiableList(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}));
    private static final List<Integer> zzaNQ = Collections.unmodifiableList(Arrays.asList(new Integer[]{1}));
    private static final List<Integer> zzaNR = Collections.unmodifiableList(Arrays.asList(new Integer[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 19}));
    private static final List<Integer> zzaNS = Collections.unmodifiableList(Arrays.asList(new Integer[]{3, 5, 7, 9, 11, 13, 15, 17}));
    private final int mVersionCode;
    private final List<Integer> zzaNT;

    GestureRequest(int versionCode, List<Integer> gestureTypes) {
        this.mVersionCode = versionCode;
        this.zzaNT = gestureTypes;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }

    public List<Integer> zzyJ() {
        return this.zzaNT;
    }
}
