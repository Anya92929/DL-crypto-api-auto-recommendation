package android.support.p000v4.widget;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.support.p000v4.widget.SearchViewCompatHoneycomb;
import android.view.View;

/* renamed from: android.support.v4.widget.SearchViewCompat */
public class SearchViewCompat {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final SearchViewCompatImpl f1588a;

    /* renamed from: android.support.v4.widget.SearchViewCompat$OnCloseListenerCompat */
    public abstract class OnCloseListenerCompat {

        /* renamed from: a */
        final Object f1589a = SearchViewCompat.f1588a.newOnCloseListener(this);

        public boolean onClose() {
            return false;
        }
    }

    /* renamed from: android.support.v4.widget.SearchViewCompat$OnQueryTextListenerCompat */
    public abstract class OnQueryTextListenerCompat {

        /* renamed from: a */
        final Object f1590a = SearchViewCompat.f1588a.newOnQueryTextListener(this);

        public boolean onQueryTextChange(String str) {
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* renamed from: android.support.v4.widget.SearchViewCompat$SearchViewCompatHoneycombImpl */
    class SearchViewCompatHoneycombImpl extends SearchViewCompatStubImpl {
        SearchViewCompatHoneycombImpl() {
        }

        public CharSequence getQuery(View view) {
            return SearchViewCompatHoneycomb.getQuery(view);
        }

        public boolean isIconified(View view) {
            return SearchViewCompatHoneycomb.isIconified(view);
        }

        public boolean isQueryRefinementEnabled(View view) {
            return SearchViewCompatHoneycomb.isQueryRefinementEnabled(view);
        }

        public boolean isSubmitButtonEnabled(View view) {
            return SearchViewCompatHoneycomb.isSubmitButtonEnabled(view);
        }

        public Object newOnCloseListener(final OnCloseListenerCompat onCloseListenerCompat) {
            return SearchViewCompatHoneycomb.newOnCloseListener(new SearchViewCompatHoneycomb.OnCloseListenerCompatBridge() {
                public boolean onClose() {
                    return onCloseListenerCompat.onClose();
                }
            });
        }

        public Object newOnQueryTextListener(final OnQueryTextListenerCompat onQueryTextListenerCompat) {
            return SearchViewCompatHoneycomb.newOnQueryTextListener(new SearchViewCompatHoneycomb.OnQueryTextListenerCompatBridge() {
                public boolean onQueryTextChange(String str) {
                    return onQueryTextListenerCompat.onQueryTextChange(str);
                }

                public boolean onQueryTextSubmit(String str) {
                    return onQueryTextListenerCompat.onQueryTextSubmit(str);
                }
            });
        }

        public View newSearchView(Context context) {
            return SearchViewCompatHoneycomb.newSearchView(context);
        }

        public void setIconified(View view, boolean z) {
            SearchViewCompatHoneycomb.setIconified(view, z);
        }

        public void setMaxWidth(View view, int i) {
            SearchViewCompatHoneycomb.setMaxWidth(view, i);
        }

        public void setOnCloseListener(Object obj, Object obj2) {
            SearchViewCompatHoneycomb.setOnCloseListener(obj, obj2);
        }

        public void setOnQueryTextListener(Object obj, Object obj2) {
            SearchViewCompatHoneycomb.setOnQueryTextListener(obj, obj2);
        }

        public void setQuery(View view, CharSequence charSequence, boolean z) {
            SearchViewCompatHoneycomb.setQuery(view, charSequence, z);
        }

        public void setQueryHint(View view, CharSequence charSequence) {
            SearchViewCompatHoneycomb.setQueryHint(view, charSequence);
        }

        public void setQueryRefinementEnabled(View view, boolean z) {
            SearchViewCompatHoneycomb.setQueryRefinementEnabled(view, z);
        }

        public void setSearchableInfo(View view, ComponentName componentName) {
            SearchViewCompatHoneycomb.setSearchableInfo(view, componentName);
        }

        public void setSubmitButtonEnabled(View view, boolean z) {
            SearchViewCompatHoneycomb.setSubmitButtonEnabled(view, z);
        }
    }

    /* renamed from: android.support.v4.widget.SearchViewCompat$SearchViewCompatIcsImpl */
    class SearchViewCompatIcsImpl extends SearchViewCompatHoneycombImpl {
        SearchViewCompatIcsImpl() {
        }

        public View newSearchView(Context context) {
            return SearchViewCompatIcs.newSearchView(context);
        }

        public void setImeOptions(View view, int i) {
            SearchViewCompatIcs.setImeOptions(view, i);
        }

        public void setInputType(View view, int i) {
            SearchViewCompatIcs.setInputType(view, i);
        }
    }

    /* renamed from: android.support.v4.widget.SearchViewCompat$SearchViewCompatImpl */
    interface SearchViewCompatImpl {
        CharSequence getQuery(View view);

        boolean isIconified(View view);

        boolean isQueryRefinementEnabled(View view);

        boolean isSubmitButtonEnabled(View view);

        Object newOnCloseListener(OnCloseListenerCompat onCloseListenerCompat);

        Object newOnQueryTextListener(OnQueryTextListenerCompat onQueryTextListenerCompat);

        View newSearchView(Context context);

        void setIconified(View view, boolean z);

        void setImeOptions(View view, int i);

        void setInputType(View view, int i);

        void setMaxWidth(View view, int i);

        void setOnCloseListener(Object obj, Object obj2);

        void setOnQueryTextListener(Object obj, Object obj2);

        void setQuery(View view, CharSequence charSequence, boolean z);

        void setQueryHint(View view, CharSequence charSequence);

        void setQueryRefinementEnabled(View view, boolean z);

        void setSearchableInfo(View view, ComponentName componentName);

        void setSubmitButtonEnabled(View view, boolean z);
    }

    /* renamed from: android.support.v4.widget.SearchViewCompat$SearchViewCompatStubImpl */
    class SearchViewCompatStubImpl implements SearchViewCompatImpl {
        SearchViewCompatStubImpl() {
        }

        public CharSequence getQuery(View view) {
            return null;
        }

        public boolean isIconified(View view) {
            return true;
        }

        public boolean isQueryRefinementEnabled(View view) {
            return false;
        }

        public boolean isSubmitButtonEnabled(View view) {
            return false;
        }

        public Object newOnCloseListener(OnCloseListenerCompat onCloseListenerCompat) {
            return null;
        }

        public Object newOnQueryTextListener(OnQueryTextListenerCompat onQueryTextListenerCompat) {
            return null;
        }

        public View newSearchView(Context context) {
            return null;
        }

        public void setIconified(View view, boolean z) {
        }

        public void setImeOptions(View view, int i) {
        }

        public void setInputType(View view, int i) {
        }

        public void setMaxWidth(View view, int i) {
        }

        public void setOnCloseListener(Object obj, Object obj2) {
        }

        public void setOnQueryTextListener(Object obj, Object obj2) {
        }

        public void setQuery(View view, CharSequence charSequence, boolean z) {
        }

        public void setQueryHint(View view, CharSequence charSequence) {
        }

        public void setQueryRefinementEnabled(View view, boolean z) {
        }

        public void setSearchableInfo(View view, ComponentName componentName) {
        }

        public void setSubmitButtonEnabled(View view, boolean z) {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f1588a = new SearchViewCompatIcsImpl();
        } else if (Build.VERSION.SDK_INT >= 11) {
            f1588a = new SearchViewCompatHoneycombImpl();
        } else {
            f1588a = new SearchViewCompatStubImpl();
        }
    }

    public static CharSequence getQuery(View view) {
        return f1588a.getQuery(view);
    }

    public static boolean isIconified(View view) {
        return f1588a.isIconified(view);
    }

    public static boolean isQueryRefinementEnabled(View view) {
        return f1588a.isQueryRefinementEnabled(view);
    }

    public static boolean isSubmitButtonEnabled(View view) {
        return f1588a.isSubmitButtonEnabled(view);
    }

    public static View newSearchView(Context context) {
        return f1588a.newSearchView(context);
    }

    public static void setIconified(View view, boolean z) {
        f1588a.setIconified(view, z);
    }

    public static void setImeOptions(View view, int i) {
        f1588a.setImeOptions(view, i);
    }

    public static void setInputType(View view, int i) {
        f1588a.setInputType(view, i);
    }

    public static void setMaxWidth(View view, int i) {
        f1588a.setMaxWidth(view, i);
    }

    public static void setOnCloseListener(View view, OnCloseListenerCompat onCloseListenerCompat) {
        f1588a.setOnCloseListener(view, onCloseListenerCompat.f1589a);
    }

    public static void setOnQueryTextListener(View view, OnQueryTextListenerCompat onQueryTextListenerCompat) {
        f1588a.setOnQueryTextListener(view, onQueryTextListenerCompat.f1590a);
    }

    public static void setQuery(View view, CharSequence charSequence, boolean z) {
        f1588a.setQuery(view, charSequence, z);
    }

    public static void setQueryHint(View view, CharSequence charSequence) {
        f1588a.setQueryHint(view, charSequence);
    }

    public static void setQueryRefinementEnabled(View view, boolean z) {
        f1588a.setQueryRefinementEnabled(view, z);
    }

    public static void setSearchableInfo(View view, ComponentName componentName) {
        f1588a.setSearchableInfo(view, componentName);
    }

    public static void setSubmitButtonEnabled(View view, boolean z) {
        f1588a.setSubmitButtonEnabled(view, z);
    }
}
