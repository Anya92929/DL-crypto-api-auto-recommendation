package android.support.p021v7.widget;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.p009v4.p019f.C0142g;

/* renamed from: android.support.v7.widget.as */
class C0594as extends C0142g {
    public C0594as(int i) {
        super(i);
    }

    /* renamed from: b */
    private static int m2758b(int i, PorterDuff.Mode mode) {
        return ((i + 31) * 31) + mode.hashCode();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PorterDuffColorFilter mo2986a(int i, PorterDuff.Mode mode) {
        return (PorterDuffColorFilter) get(Integer.valueOf(m2758b(i, mode)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PorterDuffColorFilter mo2987a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
        return (PorterDuffColorFilter) put(Integer.valueOf(m2758b(i, mode)), porterDuffColorFilter);
    }
}
