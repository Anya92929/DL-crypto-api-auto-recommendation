package p000;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.view.View;
import android.widget.SearchView;

/* renamed from: fs */
public class C1128fs {

    /* renamed from: fs$a */
    public interface C1131a {
        /* renamed from: a */
        boolean mo2939a();
    }

    /* renamed from: fs$b */
    public interface C1132b {
        /* renamed from: a */
        boolean mo2937a(String str);

        /* renamed from: b */
        boolean mo2938b(String str);
    }

    /* renamed from: a */
    public static View m5093a(Context context) {
        return new SearchView(context);
    }

    /* renamed from: a */
    public static void m5098a(View view, ComponentName componentName) {
        SearchView searchView = (SearchView) view;
        searchView.setSearchableInfo(((SearchManager) searchView.getContext().getSystemService("search")).getSearchableInfo(componentName));
    }

    /* renamed from: a */
    public static Object m5096a(final C1132b bVar) {
        return new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String str) {
                return bVar.mo2937a(str);
            }

            public boolean onQueryTextChange(String str) {
                return bVar.mo2938b(str);
            }
        };
    }

    /* renamed from: a */
    public static void m5102a(Object obj, Object obj2) {
        ((SearchView) obj).setOnQueryTextListener((SearchView.OnQueryTextListener) obj2);
    }

    /* renamed from: a */
    public static Object m5095a(final C1131a aVar) {
        return new SearchView.OnCloseListener() {
            public boolean onClose() {
                return aVar.mo2939a();
            }
        };
    }

    /* renamed from: b */
    public static void m5104b(Object obj, Object obj2) {
        ((SearchView) obj).setOnCloseListener((SearchView.OnCloseListener) obj2);
    }

    /* renamed from: a */
    public static CharSequence m5094a(View view) {
        return ((SearchView) view).getQuery();
    }

    /* renamed from: a */
    public static void m5100a(View view, CharSequence charSequence, boolean z) {
        ((SearchView) view).setQuery(charSequence, z);
    }

    /* renamed from: a */
    public static void m5099a(View view, CharSequence charSequence) {
        ((SearchView) view).setQueryHint(charSequence);
    }

    /* renamed from: a */
    public static void m5101a(View view, boolean z) {
        ((SearchView) view).setIconified(z);
    }

    /* renamed from: b */
    public static boolean m5105b(View view) {
        return ((SearchView) view).isIconified();
    }

    /* renamed from: b */
    public static void m5103b(View view, boolean z) {
        ((SearchView) view).setSubmitButtonEnabled(z);
    }

    /* renamed from: c */
    public static boolean m5107c(View view) {
        return ((SearchView) view).isSubmitButtonEnabled();
    }

    /* renamed from: c */
    public static void m5106c(View view, boolean z) {
        ((SearchView) view).setQueryRefinementEnabled(z);
    }

    /* renamed from: d */
    public static boolean m5108d(View view) {
        return ((SearchView) view).isQueryRefinementEnabled();
    }

    /* renamed from: a */
    public static void m5097a(View view, int i) {
        ((SearchView) view).setMaxWidth(i);
    }
}
