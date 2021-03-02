package android.support.p009v4.widget;

import android.view.View;
import android.widget.ListView;

/* renamed from: android.support.v4.widget.ao */
class C0372ao {
    /* renamed from: a */
    static void m1535a(ListView listView, int i) {
        View childAt;
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition != -1 && (childAt = listView.getChildAt(0)) != null) {
            listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
        }
    }
}
