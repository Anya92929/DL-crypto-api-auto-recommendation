package android.support.p000v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;

/* renamed from: android.support.v4.widget.CompoundButtonCompat */
public final class CompoundButtonCompat {

    /* renamed from: a */
    private static final CompoundButtonCompatImpl f1418a;

    /* renamed from: android.support.v4.widget.CompoundButtonCompat$Api23CompoundButtonImpl */
    class Api23CompoundButtonImpl extends LollipopCompoundButtonImpl {
        Api23CompoundButtonImpl() {
        }

        public Drawable getButtonDrawable(CompoundButton compoundButton) {
            return CompoundButtonCompatApi23.m1015a(compoundButton);
        }
    }

    /* renamed from: android.support.v4.widget.CompoundButtonCompat$BaseCompoundButtonCompat */
    class BaseCompoundButtonCompat implements CompoundButtonCompatImpl {
        BaseCompoundButtonCompat() {
        }

        public Drawable getButtonDrawable(CompoundButton compoundButton) {
            return CompoundButtonCompatDonut.m1020c(compoundButton);
        }

        public ColorStateList getButtonTintList(CompoundButton compoundButton) {
            return CompoundButtonCompatDonut.m1016a(compoundButton);
        }

        public PorterDuff.Mode getButtonTintMode(CompoundButton compoundButton) {
            return CompoundButtonCompatDonut.m1019b(compoundButton);
        }

        public void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList) {
            CompoundButtonCompatDonut.m1017a(compoundButton, colorStateList);
        }

        public void setButtonTintMode(CompoundButton compoundButton, PorterDuff.Mode mode) {
            CompoundButtonCompatDonut.m1018a(compoundButton, mode);
        }
    }

    /* renamed from: android.support.v4.widget.CompoundButtonCompat$CompoundButtonCompatImpl */
    interface CompoundButtonCompatImpl {
        Drawable getButtonDrawable(CompoundButton compoundButton);

        ColorStateList getButtonTintList(CompoundButton compoundButton);

        PorterDuff.Mode getButtonTintMode(CompoundButton compoundButton);

        void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList);

        void setButtonTintMode(CompoundButton compoundButton, PorterDuff.Mode mode);
    }

    /* renamed from: android.support.v4.widget.CompoundButtonCompat$LollipopCompoundButtonImpl */
    class LollipopCompoundButtonImpl extends BaseCompoundButtonCompat {
        LollipopCompoundButtonImpl() {
        }

        public ColorStateList getButtonTintList(CompoundButton compoundButton) {
            return CompoundButtonCompatLollipop.m1021a(compoundButton);
        }

        public PorterDuff.Mode getButtonTintMode(CompoundButton compoundButton) {
            return CompoundButtonCompatLollipop.m1024b(compoundButton);
        }

        public void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList) {
            CompoundButtonCompatLollipop.m1022a(compoundButton, colorStateList);
        }

        public void setButtonTintMode(CompoundButton compoundButton, PorterDuff.Mode mode) {
            CompoundButtonCompatLollipop.m1023a(compoundButton, mode);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            f1418a = new Api23CompoundButtonImpl();
        } else if (i >= 21) {
            f1418a = new LollipopCompoundButtonImpl();
        } else {
            f1418a = new BaseCompoundButtonCompat();
        }
    }

    private CompoundButtonCompat() {
    }

    public static Drawable getButtonDrawable(CompoundButton compoundButton) {
        return f1418a.getButtonDrawable(compoundButton);
    }

    public static ColorStateList getButtonTintList(CompoundButton compoundButton) {
        return f1418a.getButtonTintList(compoundButton);
    }

    public static PorterDuff.Mode getButtonTintMode(CompoundButton compoundButton) {
        return f1418a.getButtonTintMode(compoundButton);
    }

    public static void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList) {
        f1418a.setButtonTintList(compoundButton, colorStateList);
    }

    public static void setButtonTintMode(CompoundButton compoundButton, PorterDuff.Mode mode) {
        f1418a.setButtonTintMode(compoundButton, mode);
    }
}
