package android.support.p000v4.widget;

import android.database.Cursor;
import android.widget.Filter;

/* renamed from: android.support.v4.widget.CursorFilter */
class CursorFilter extends Filter {

    /* renamed from: a */
    CursorFilterClient f1440a;

    /* renamed from: android.support.v4.widget.CursorFilter$CursorFilterClient */
    interface CursorFilterClient {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    CursorFilter(CursorFilterClient cursorFilterClient) {
        this.f1440a = cursorFilterClient;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f1440a.convertToString((Cursor) obj);
    }

    /* access modifiers changed from: protected */
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor runQueryOnBackgroundThread = this.f1440a.runQueryOnBackgroundThread(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (runQueryOnBackgroundThread != null) {
            filterResults.count = runQueryOnBackgroundThread.getCount();
            filterResults.values = runQueryOnBackgroundThread;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    /* access modifiers changed from: protected */
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursor = this.f1440a.getCursor();
        if (filterResults.values != null && filterResults.values != cursor) {
            this.f1440a.changeCursor((Cursor) filterResults.values);
        }
    }
}
