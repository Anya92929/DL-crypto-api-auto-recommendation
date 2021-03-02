package p000;

import android.database.Cursor;
import android.widget.Filter;

/* renamed from: ff */
public class C1113ff extends Filter {

    /* renamed from: a */
    C1114a f4084a;

    /* renamed from: ff$a */
    public interface C1114a {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    public C1113ff(C1114a aVar) {
        this.f4084a = aVar;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f4084a.convertToString((Cursor) obj);
    }

    /* access modifiers changed from: protected */
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor runQueryOnBackgroundThread = this.f4084a.runQueryOnBackgroundThread(charSequence);
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
        Cursor cursor = this.f4084a.getCursor();
        if (filterResults.values != null && filterResults.values != cursor) {
            this.f4084a.changeCursor((Cursor) filterResults.values);
        }
    }
}
