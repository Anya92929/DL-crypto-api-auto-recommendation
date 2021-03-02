package android.support.p000v4.widget;

import android.content.Context;
import android.view.View;
import android.widget.SearchView;

/* renamed from: android.support.v4.widget.SearchViewCompatIcs */
class SearchViewCompatIcs {
    SearchViewCompatIcs() {
    }

    /* renamed from: android.support.v4.widget.SearchViewCompatIcs$MySearchView */
    public static class MySearchView extends SearchView {
        public MySearchView(Context context) {
            super(context);
        }

        public void onActionViewCollapsed() {
            setQuery("", false);
            super.onActionViewCollapsed();
        }
    }

    public static View newSearchView(Context context) {
        return new MySearchView(context);
    }

    public static void setImeOptions(View searchView, int imeOptions) {
        ((SearchView) searchView).setImeOptions(imeOptions);
    }

    public static void setInputType(View searchView, int inputType) {
        ((SearchView) searchView).setInputType(inputType);
    }
}
