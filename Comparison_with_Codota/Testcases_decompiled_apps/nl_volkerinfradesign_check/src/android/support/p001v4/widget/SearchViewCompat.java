package android.support.p001v4.widget;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.view.View;
import p000.C1128fs;

/* renamed from: android.support.v4.widget.SearchViewCompat */
public class SearchViewCompat {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final C0441c f1286a;

    /* renamed from: android.support.v4.widget.SearchViewCompat$c */
    interface C0441c {
        /* renamed from: a */
        View mo2921a(Context context);

        /* renamed from: a */
        CharSequence mo2922a(View view);

        /* renamed from: a */
        Object mo2923a(OnCloseListenerCompat onCloseListenerCompat);

        /* renamed from: a */
        Object mo2924a(OnQueryTextListenerCompat onQueryTextListenerCompat);

        /* renamed from: a */
        void mo2925a(View view, int i);

        /* renamed from: a */
        void mo2926a(View view, ComponentName componentName);

        /* renamed from: a */
        void mo2927a(View view, CharSequence charSequence);

        /* renamed from: a */
        void mo2928a(View view, CharSequence charSequence, boolean z);

        /* renamed from: a */
        void mo2929a(View view, boolean z);

        /* renamed from: a */
        void mo2930a(Object obj, Object obj2);

        /* renamed from: b */
        void mo2940b(View view, int i);

        /* renamed from: b */
        void mo2931b(View view, boolean z);

        /* renamed from: b */
        void mo2932b(Object obj, Object obj2);

        /* renamed from: b */
        boolean mo2933b(View view);

        /* renamed from: c */
        void mo2941c(View view, int i);

        /* renamed from: c */
        void mo2934c(View view, boolean z);

        /* renamed from: c */
        boolean mo2935c(View view);

        /* renamed from: d */
        boolean mo2936d(View view);
    }

    /* renamed from: android.support.v4.widget.SearchViewCompat$d */
    static class C0442d implements C0441c {
        C0442d() {
        }

        /* renamed from: a */
        public View mo2921a(Context context) {
            return null;
        }

        /* renamed from: a */
        public void mo2926a(View view, ComponentName componentName) {
        }

        /* renamed from: b */
        public void mo2940b(View view, int i) {
        }

        /* renamed from: c */
        public void mo2941c(View view, int i) {
        }

        /* renamed from: a */
        public Object mo2924a(OnQueryTextListenerCompat onQueryTextListenerCompat) {
            return null;
        }

        /* renamed from: a */
        public void mo2930a(Object obj, Object obj2) {
        }

        /* renamed from: a */
        public Object mo2923a(OnCloseListenerCompat onCloseListenerCompat) {
            return null;
        }

        /* renamed from: b */
        public void mo2932b(Object obj, Object obj2) {
        }

        /* renamed from: a */
        public CharSequence mo2922a(View view) {
            return null;
        }

        /* renamed from: a */
        public void mo2928a(View view, CharSequence charSequence, boolean z) {
        }

        /* renamed from: a */
        public void mo2927a(View view, CharSequence charSequence) {
        }

        /* renamed from: a */
        public void mo2929a(View view, boolean z) {
        }

        /* renamed from: b */
        public boolean mo2933b(View view) {
            return true;
        }

        /* renamed from: b */
        public void mo2931b(View view, boolean z) {
        }

        /* renamed from: c */
        public boolean mo2935c(View view) {
            return false;
        }

        /* renamed from: c */
        public void mo2934c(View view, boolean z) {
        }

        /* renamed from: d */
        public boolean mo2936d(View view) {
            return false;
        }

        /* renamed from: a */
        public void mo2925a(View view, int i) {
        }
    }

    /* renamed from: android.support.v4.widget.SearchViewCompat$a */
    static class C0437a extends C0442d {
        C0437a() {
        }

        /* renamed from: a */
        public View mo2921a(Context context) {
            return C1128fs.m5093a(context);
        }

        /* renamed from: a */
        public void mo2926a(View view, ComponentName componentName) {
            C1128fs.m5098a(view, componentName);
        }

        /* renamed from: a */
        public Object mo2924a(final OnQueryTextListenerCompat onQueryTextListenerCompat) {
            return C1128fs.m5096a((C1128fs.C1132b) new C1128fs.C1132b() {
                /* renamed from: a */
                public boolean mo2937a(String str) {
                    return onQueryTextListenerCompat.onQueryTextSubmit(str);
                }

                /* renamed from: b */
                public boolean mo2938b(String str) {
                    return onQueryTextListenerCompat.onQueryTextChange(str);
                }
            });
        }

        /* renamed from: a */
        public void mo2930a(Object obj, Object obj2) {
            C1128fs.m5102a(obj, obj2);
        }

        /* renamed from: a */
        public Object mo2923a(final OnCloseListenerCompat onCloseListenerCompat) {
            return C1128fs.m5095a((C1128fs.C1131a) new C1128fs.C1131a() {
                /* renamed from: a */
                public boolean mo2939a() {
                    return onCloseListenerCompat.onClose();
                }
            });
        }

        /* renamed from: b */
        public void mo2932b(Object obj, Object obj2) {
            C1128fs.m5104b(obj, obj2);
        }

        /* renamed from: a */
        public CharSequence mo2922a(View view) {
            return C1128fs.m5094a(view);
        }

        /* renamed from: a */
        public void mo2928a(View view, CharSequence charSequence, boolean z) {
            C1128fs.m5100a(view, charSequence, z);
        }

        /* renamed from: a */
        public void mo2927a(View view, CharSequence charSequence) {
            C1128fs.m5099a(view, charSequence);
        }

        /* renamed from: a */
        public void mo2929a(View view, boolean z) {
            C1128fs.m5101a(view, z);
        }

        /* renamed from: b */
        public boolean mo2933b(View view) {
            return C1128fs.m5105b(view);
        }

        /* renamed from: b */
        public void mo2931b(View view, boolean z) {
            C1128fs.m5103b(view, z);
        }

        /* renamed from: c */
        public boolean mo2935c(View view) {
            return C1128fs.m5107c(view);
        }

        /* renamed from: c */
        public void mo2934c(View view, boolean z) {
            C1128fs.m5106c(view, z);
        }

        /* renamed from: d */
        public boolean mo2936d(View view) {
            return C1128fs.m5108d(view);
        }

        /* renamed from: a */
        public void mo2925a(View view, int i) {
            C1128fs.m5097a(view, i);
        }
    }

    /* renamed from: android.support.v4.widget.SearchViewCompat$b */
    static class C0440b extends C0437a {
        C0440b() {
        }

        /* renamed from: a */
        public View mo2921a(Context context) {
            return SearchViewCompatIcs.m2736a(context);
        }

        /* renamed from: b */
        public void mo2940b(View view, int i) {
            SearchViewCompatIcs.m2737a(view, i);
        }

        /* renamed from: c */
        public void mo2941c(View view, int i) {
            SearchViewCompatIcs.m2738b(view, i);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f1286a = new C0440b();
        } else if (Build.VERSION.SDK_INT >= 11) {
            f1286a = new C0437a();
        } else {
            f1286a = new C0442d();
        }
    }

    public static View newSearchView(Context context) {
        return f1286a.mo2921a(context);
    }

    public static void setSearchableInfo(View view, ComponentName componentName) {
        f1286a.mo2926a(view, componentName);
    }

    public static void setImeOptions(View view, int i) {
        f1286a.mo2940b(view, i);
    }

    public static void setInputType(View view, int i) {
        f1286a.mo2941c(view, i);
    }

    public static void setOnQueryTextListener(View view, OnQueryTextListenerCompat onQueryTextListenerCompat) {
        f1286a.mo2930a((Object) view, onQueryTextListenerCompat.f1288a);
    }

    /* renamed from: android.support.v4.widget.SearchViewCompat$OnQueryTextListenerCompat */
    public static abstract class OnQueryTextListenerCompat {

        /* renamed from: a */
        final Object f1288a = SearchViewCompat.f1286a.mo2924a(this);

        public boolean onQueryTextSubmit(String str) {
            return false;
        }

        public boolean onQueryTextChange(String str) {
            return false;
        }
    }

    public static void setOnCloseListener(View view, OnCloseListenerCompat onCloseListenerCompat) {
        f1286a.mo2932b((Object) view, onCloseListenerCompat.f1287a);
    }

    /* renamed from: android.support.v4.widget.SearchViewCompat$OnCloseListenerCompat */
    public static abstract class OnCloseListenerCompat {

        /* renamed from: a */
        final Object f1287a = SearchViewCompat.f1286a.mo2923a(this);

        public boolean onClose() {
            return false;
        }
    }

    public static CharSequence getQuery(View view) {
        return f1286a.mo2922a(view);
    }

    public static void setQuery(View view, CharSequence charSequence, boolean z) {
        f1286a.mo2928a(view, charSequence, z);
    }

    public static void setQueryHint(View view, CharSequence charSequence) {
        f1286a.mo2927a(view, charSequence);
    }

    public static void setIconified(View view, boolean z) {
        f1286a.mo2929a(view, z);
    }

    public static boolean isIconified(View view) {
        return f1286a.mo2933b(view);
    }

    public static void setSubmitButtonEnabled(View view, boolean z) {
        f1286a.mo2931b(view, z);
    }

    public static boolean isSubmitButtonEnabled(View view) {
        return f1286a.mo2935c(view);
    }

    public static void setQueryRefinementEnabled(View view, boolean z) {
        f1286a.mo2934c(view, z);
    }

    public static boolean isQueryRefinementEnabled(View view) {
        return f1286a.mo2936d(view);
    }

    public static void setMaxWidth(View view, int i) {
        f1286a.mo2925a(view, i);
    }
}
