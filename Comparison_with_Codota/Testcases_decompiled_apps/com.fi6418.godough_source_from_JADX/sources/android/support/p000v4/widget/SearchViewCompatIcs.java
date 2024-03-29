package android.support.p000v4.widget;

import android.content.Context;
import android.view.View;
import android.widget.SearchView;

/* renamed from: android.support.v4.widget.SearchViewCompatIcs */
class SearchViewCompatIcs {

    /* renamed from: android.support.v4.widget.SearchViewCompatIcs$MySearchView */
    public class MySearchView extends SearchView {
        public MySearchView(Context context) {
            super(context);
        }

        public void onActionViewCollapsed() {
            setQuery("", false);
            super.onActionViewCollapsed();
        }
    }

    SearchViewCompatIcs() {
    }

    public static View newSearchView(Context context) {
        return new MySearchView(context);
    }

    public static void setImeOptions(View view, int i) {
        ((SearchView) view).setImeOptions(i);
    }

    public static void setInputType(View view, int i) {
        ((SearchView) view).setInputType(i);
    }
}
