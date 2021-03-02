package android.support.p001v4.view;

import android.os.Build;
import android.view.ViewGroup;

/* renamed from: android.support.v4.view.MarginLayoutParamsCompat */
public class MarginLayoutParamsCompat {

    /* renamed from: a */
    static final C0280a f931a;

    /* renamed from: android.support.v4.view.MarginLayoutParamsCompat$a */
    interface C0280a {
        /* renamed from: a */
        int mo1770a(ViewGroup.MarginLayoutParams marginLayoutParams);

        /* renamed from: a */
        void mo1771a(ViewGroup.MarginLayoutParams marginLayoutParams, int i);

        /* renamed from: b */
        int mo1772b(ViewGroup.MarginLayoutParams marginLayoutParams);

        /* renamed from: b */
        void mo1773b(ViewGroup.MarginLayoutParams marginLayoutParams, int i);

        /* renamed from: c */
        void mo1774c(ViewGroup.MarginLayoutParams marginLayoutParams, int i);

        /* renamed from: c */
        boolean mo1775c(ViewGroup.MarginLayoutParams marginLayoutParams);

        /* renamed from: d */
        int mo1776d(ViewGroup.MarginLayoutParams marginLayoutParams);

        /* renamed from: d */
        void mo1777d(ViewGroup.MarginLayoutParams marginLayoutParams, int i);
    }

    /* renamed from: android.support.v4.view.MarginLayoutParamsCompat$b */
    static class C0281b implements C0280a {
        C0281b() {
        }

        /* renamed from: a */
        public int mo1770a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.leftMargin;
        }

        /* renamed from: b */
        public int mo1772b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.rightMargin;
        }

        /* renamed from: a */
        public void mo1771a(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            marginLayoutParams.leftMargin = i;
        }

        /* renamed from: b */
        public void mo1773b(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            marginLayoutParams.rightMargin = i;
        }

        /* renamed from: c */
        public boolean mo1775c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return false;
        }

        /* renamed from: d */
        public int mo1776d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return 0;
        }

        /* renamed from: c */
        public void mo1774c(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        }

        /* renamed from: d */
        public void mo1777d(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        }
    }

    /* renamed from: android.support.v4.view.MarginLayoutParamsCompat$c */
    static class C0282c implements C0280a {
        C0282c() {
        }

        /* renamed from: a */
        public int mo1770a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return C1033cy.m4609a(marginLayoutParams);
        }

        /* renamed from: b */
        public int mo1772b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return C1033cy.m4611b(marginLayoutParams);
        }

        /* renamed from: a */
        public void mo1771a(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            C1033cy.m4610a(marginLayoutParams, i);
        }

        /* renamed from: b */
        public void mo1773b(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            C1033cy.m4612b(marginLayoutParams, i);
        }

        /* renamed from: c */
        public boolean mo1775c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return C1033cy.m4614c(marginLayoutParams);
        }

        /* renamed from: d */
        public int mo1776d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return C1033cy.m4615d(marginLayoutParams);
        }

        /* renamed from: c */
        public void mo1774c(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            C1033cy.m4613c(marginLayoutParams, i);
        }

        /* renamed from: d */
        public void mo1777d(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            C1033cy.m4616d(marginLayoutParams, i);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            f931a = new C0282c();
        } else {
            f931a = new C0281b();
        }
    }

    public static int getMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return f931a.mo1770a(marginLayoutParams);
    }

    public static int getMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return f931a.mo1772b(marginLayoutParams);
    }

    public static void setMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        f931a.mo1771a(marginLayoutParams, i);
    }

    public static void setMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        f931a.mo1773b(marginLayoutParams, i);
    }

    public static boolean isMarginRelative(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return f931a.mo1775c(marginLayoutParams);
    }

    public static int getLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return f931a.mo1776d(marginLayoutParams);
    }

    public static void setLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        f931a.mo1774c(marginLayoutParams, i);
    }

    public static void resolveLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        f931a.mo1777d(marginLayoutParams, i);
    }
}
