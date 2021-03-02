package android.support.p001v4.widget;

import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;

/* renamed from: android.support.v4.widget.PopupWindowCompat */
public class PopupWindowCompat {

    /* renamed from: a */
    static final C0432f f1280a;

    /* renamed from: android.support.v4.widget.PopupWindowCompat$f */
    interface C0432f {
        /* renamed from: a */
        void mo2880a(PopupWindow popupWindow, int i);

        /* renamed from: a */
        void mo2882a(PopupWindow popupWindow, View view, int i, int i2, int i3);

        /* renamed from: a */
        void mo2878a(PopupWindow popupWindow, boolean z);

        /* renamed from: a */
        boolean mo2879a(PopupWindow popupWindow);

        /* renamed from: b */
        int mo2881b(PopupWindow popupWindow);
    }

    /* renamed from: android.support.v4.widget.PopupWindowCompat$c */
    static class C0429c implements C0432f {
        C0429c() {
        }

        /* renamed from: a */
        public void mo2882a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2);
        }

        /* renamed from: a */
        public void mo2878a(PopupWindow popupWindow, boolean z) {
        }

        /* renamed from: a */
        public boolean mo2879a(PopupWindow popupWindow) {
            return false;
        }

        /* renamed from: a */
        public void mo2880a(PopupWindow popupWindow, int i) {
        }

        /* renamed from: b */
        public int mo2881b(PopupWindow popupWindow) {
            return 0;
        }
    }

    /* renamed from: android.support.v4.widget.PopupWindowCompat$d */
    static class C0430d extends C0429c {
        C0430d() {
        }

        /* renamed from: a */
        public void mo2880a(PopupWindow popupWindow, int i) {
            C1124fo.m5074a(popupWindow, i);
        }

        /* renamed from: b */
        public int mo2881b(PopupWindow popupWindow) {
            return C1124fo.m5073a(popupWindow);
        }
    }

    /* renamed from: android.support.v4.widget.PopupWindowCompat$e */
    static class C0431e extends C0430d {
        C0431e() {
        }

        /* renamed from: a */
        public void mo2882a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            C1125fp.m5075a(popupWindow, view, i, i2, i3);
        }
    }

    /* renamed from: android.support.v4.widget.PopupWindowCompat$a */
    static class C0427a extends C0431e {
        C0427a() {
        }

        /* renamed from: a */
        public void mo2878a(PopupWindow popupWindow, boolean z) {
            C1122fm.m5067a(popupWindow, z);
        }

        /* renamed from: a */
        public boolean mo2879a(PopupWindow popupWindow) {
            return C1122fm.m5068a(popupWindow);
        }
    }

    /* renamed from: android.support.v4.widget.PopupWindowCompat$b */
    static class C0428b extends C0427a {
        C0428b() {
        }

        /* renamed from: a */
        public void mo2878a(PopupWindow popupWindow, boolean z) {
            C1123fn.m5070a(popupWindow, z);
        }

        /* renamed from: a */
        public boolean mo2879a(PopupWindow popupWindow) {
            return C1123fn.m5071a(popupWindow);
        }

        /* renamed from: a */
        public void mo2880a(PopupWindow popupWindow, int i) {
            C1123fn.m5069a(popupWindow, i);
        }

        /* renamed from: b */
        public int mo2881b(PopupWindow popupWindow) {
            return C1123fn.m5072b(popupWindow);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            f1280a = new C0428b();
        } else if (i >= 21) {
            f1280a = new C0427a();
        } else if (i >= 19) {
            f1280a = new C0431e();
        } else if (i >= 9) {
            f1280a = new C0430d();
        } else {
            f1280a = new C0429c();
        }
    }

    private PopupWindowCompat() {
    }

    public static void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f1280a.mo2882a(popupWindow, view, i, i2, i3);
    }

    public static void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
        f1280a.mo2878a(popupWindow, z);
    }

    public static boolean getOverlapAnchor(PopupWindow popupWindow) {
        return f1280a.mo2879a(popupWindow);
    }

    public static void setWindowLayoutType(PopupWindow popupWindow, int i) {
        f1280a.mo2880a(popupWindow, i);
    }

    public static int getWindowLayoutType(PopupWindow popupWindow) {
        return f1280a.mo2881b(popupWindow);
    }
}
