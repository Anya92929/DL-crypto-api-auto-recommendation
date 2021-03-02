package android.support.p001v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

/* renamed from: android.support.v4.widget.TextViewCompat */
public class TextViewCompat {

    /* renamed from: a */
    static final C0464e f1380a;

    /* renamed from: android.support.v4.widget.TextViewCompat$e */
    interface C0464e {
        /* renamed from: a */
        int mo3046a(TextView textView);

        /* renamed from: a */
        void mo3047a(@NonNull TextView textView, int i, int i2, int i3, int i4);

        /* renamed from: a */
        void mo3048a(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4);

        /* renamed from: b */
        int mo3049b(TextView textView);

        /* renamed from: b */
        void mo3050b(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4);
    }

    private TextViewCompat() {
    }

    /* renamed from: android.support.v4.widget.TextViewCompat$a */
    static class C0460a implements C0464e {
        C0460a() {
        }

        /* renamed from: a */
        public void mo3048a(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }

        /* renamed from: b */
        public void mo3050b(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        /* renamed from: a */
        public void mo3047a(@NonNull TextView textView, int i, int i2, int i3, int i4) {
            textView.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        }

        /* renamed from: a */
        public int mo3046a(TextView textView) {
            return C1133ft.m5112a(textView);
        }

        /* renamed from: b */
        public int mo3049b(TextView textView) {
            return C1133ft.m5115b(textView);
        }
    }

    /* renamed from: android.support.v4.widget.TextViewCompat$d */
    static class C0463d extends C0460a {
        C0463d() {
        }

        /* renamed from: a */
        public int mo3046a(TextView textView) {
            return C1134fu.m5116a(textView);
        }

        /* renamed from: b */
        public int mo3049b(TextView textView) {
            return C1134fu.m5117b(textView);
        }
    }

    /* renamed from: android.support.v4.widget.TextViewCompat$b */
    static class C0461b extends C0463d {
        C0461b() {
        }

        /* renamed from: a */
        public void mo3048a(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
            C1135fv.m5119a(textView, drawable, drawable2, drawable3, drawable4);
        }

        /* renamed from: b */
        public void mo3050b(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
            C1135fv.m5120b(textView, drawable, drawable2, drawable3, drawable4);
        }

        /* renamed from: a */
        public void mo3047a(@NonNull TextView textView, int i, int i2, int i3, int i4) {
            C1135fv.m5118a(textView, i, i2, i3, i4);
        }
    }

    /* renamed from: android.support.v4.widget.TextViewCompat$c */
    static class C0462c extends C0461b {
        C0462c() {
        }

        /* renamed from: a */
        public void mo3048a(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
            C1136fw.m5122a(textView, drawable, drawable2, drawable3, drawable4);
        }

        /* renamed from: b */
        public void mo3050b(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
            C1136fw.m5123b(textView, drawable, drawable2, drawable3, drawable4);
        }

        /* renamed from: a */
        public void mo3047a(@NonNull TextView textView, int i, int i2, int i3, int i4) {
            C1136fw.m5121a(textView, i, i2, i3, i4);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            f1380a = new C0462c();
        } else if (i >= 17) {
            f1380a = new C0461b();
        } else if (i >= 16) {
            f1380a = new C0463d();
        } else {
            f1380a = new C0460a();
        }
    }

    public static void setCompoundDrawablesRelative(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        f1380a.mo3048a(textView, drawable, drawable2, drawable3, drawable4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        f1380a.mo3050b(textView, drawable, drawable2, drawable3, drawable4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, int i, int i2, int i3, int i4) {
        f1380a.mo3047a(textView, i, i2, i3, i4);
    }

    public static int getMaxLines(@NonNull TextView textView) {
        return f1380a.mo3046a(textView);
    }

    public static int getMinLines(@NonNull TextView textView) {
        return f1380a.mo3049b(textView);
    }
}
