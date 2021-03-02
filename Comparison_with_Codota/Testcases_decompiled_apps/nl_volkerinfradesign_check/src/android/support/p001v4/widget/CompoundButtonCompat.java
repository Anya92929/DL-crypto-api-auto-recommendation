package android.support.p001v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.CompoundButton;

/* renamed from: android.support.v4.widget.CompoundButtonCompat */
public final class CompoundButtonCompat {

    /* renamed from: a */
    private static final C0394c f1132a;

    /* renamed from: android.support.v4.widget.CompoundButtonCompat$c */
    interface C0394c {
        /* renamed from: a */
        Drawable mo2621a(CompoundButton compoundButton);

        /* renamed from: a */
        void mo2622a(CompoundButton compoundButton, ColorStateList colorStateList);

        /* renamed from: a */
        void mo2623a(CompoundButton compoundButton, PorterDuff.Mode mode);

        /* renamed from: b */
        ColorStateList mo2624b(CompoundButton compoundButton);

        /* renamed from: c */
        PorterDuff.Mode mo2625c(CompoundButton compoundButton);
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            f1132a = new C0392a();
        } else if (i >= 21) {
            f1132a = new C0395d();
        } else {
            f1132a = new C0393b();
        }
    }

    /* renamed from: android.support.v4.widget.CompoundButtonCompat$b */
    static class C0393b implements C0394c {
        C0393b() {
        }

        /* renamed from: a */
        public void mo2622a(CompoundButton compoundButton, ColorStateList colorStateList) {
            C1111fd.m5043a(compoundButton, colorStateList);
        }

        /* renamed from: b */
        public ColorStateList mo2624b(CompoundButton compoundButton) {
            return C1111fd.m5042a(compoundButton);
        }

        /* renamed from: a */
        public void mo2623a(CompoundButton compoundButton, PorterDuff.Mode mode) {
            C1111fd.m5044a(compoundButton, mode);
        }

        /* renamed from: c */
        public PorterDuff.Mode mo2625c(CompoundButton compoundButton) {
            return C1111fd.m5045b(compoundButton);
        }

        /* renamed from: a */
        public Drawable mo2621a(CompoundButton compoundButton) {
            return C1111fd.m5046c(compoundButton);
        }
    }

    /* renamed from: android.support.v4.widget.CompoundButtonCompat$d */
    static class C0395d extends C0393b {
        C0395d() {
        }

        /* renamed from: a */
        public void mo2622a(CompoundButton compoundButton, ColorStateList colorStateList) {
            C1112fe.m5048a(compoundButton, colorStateList);
        }

        /* renamed from: b */
        public ColorStateList mo2624b(CompoundButton compoundButton) {
            return C1112fe.m5047a(compoundButton);
        }

        /* renamed from: a */
        public void mo2623a(CompoundButton compoundButton, PorterDuff.Mode mode) {
            C1112fe.m5049a(compoundButton, mode);
        }

        /* renamed from: c */
        public PorterDuff.Mode mo2625c(CompoundButton compoundButton) {
            return C1112fe.m5050b(compoundButton);
        }
    }

    /* renamed from: android.support.v4.widget.CompoundButtonCompat$a */
    static class C0392a extends C0395d {
        C0392a() {
        }

        /* renamed from: a */
        public Drawable mo2621a(CompoundButton compoundButton) {
            return C1110fc.m5041a(compoundButton);
        }
    }

    private CompoundButtonCompat() {
    }

    public static void setButtonTintList(@NonNull CompoundButton compoundButton, @Nullable ColorStateList colorStateList) {
        f1132a.mo2622a(compoundButton, colorStateList);
    }

    @Nullable
    public static ColorStateList getButtonTintList(@NonNull CompoundButton compoundButton) {
        return f1132a.mo2624b(compoundButton);
    }

    public static void setButtonTintMode(@NonNull CompoundButton compoundButton, @Nullable PorterDuff.Mode mode) {
        f1132a.mo2623a(compoundButton, mode);
    }

    @Nullable
    public static PorterDuff.Mode getButtonTintMode(@NonNull CompoundButton compoundButton) {
        return f1132a.mo2625c(compoundButton);
    }

    @Nullable
    public static Drawable getButtonDrawable(@NonNull CompoundButton compoundButton) {
        return f1132a.mo2621a(compoundButton);
    }
}
