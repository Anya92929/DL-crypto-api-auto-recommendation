package android.support.p009v4.p018e;

import android.os.Build;
import android.os.Parcelable;

/* renamed from: android.support.v4.e.d */
public final class C0131d {
    /* renamed from: a */
    public static Parcelable.Creator m320a(C0133f fVar) {
        return Build.VERSION.SDK_INT >= 13 ? C0135h.m323a(fVar) : new C0132e(fVar);
    }
}
