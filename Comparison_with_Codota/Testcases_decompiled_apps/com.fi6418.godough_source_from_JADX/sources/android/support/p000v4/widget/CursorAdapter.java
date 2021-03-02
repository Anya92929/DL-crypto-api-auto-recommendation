package android.support.p000v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.p000v4.widget.CursorFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

/* renamed from: android.support.v4.widget.CursorAdapter */
public abstract class CursorAdapter extends BaseAdapter implements CursorFilter.CursorFilterClient, Filterable {
    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;

    /* renamed from: a */
    protected boolean f1429a;

    /* renamed from: b */
    protected boolean f1430b;

    /* renamed from: c */
    protected Cursor f1431c;

    /* renamed from: d */
    protected Context f1432d;

    /* renamed from: e */
    protected int f1433e;

    /* renamed from: f */
    protected ChangeObserver f1434f;

    /* renamed from: g */
    protected DataSetObserver f1435g;

    /* renamed from: h */
    protected CursorFilter f1436h;

    /* renamed from: i */
    protected FilterQueryProvider f1437i;

    /* renamed from: android.support.v4.widget.CursorAdapter$ChangeObserver */
    class ChangeObserver extends ContentObserver {
        public ChangeObserver() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            CursorAdapter.this.mo3061a();
        }
    }

    /* renamed from: android.support.v4.widget.CursorAdapter$MyDataSetObserver */
    class MyDataSetObserver extends DataSetObserver {
        private MyDataSetObserver() {
        }

        public void onChanged() {
            CursorAdapter.this.f1429a = true;
            CursorAdapter.this.notifyDataSetChanged();
        }

        public void onInvalidated() {
            CursorAdapter.this.f1429a = false;
            CursorAdapter.this.notifyDataSetInvalidated();
        }
    }

    @Deprecated
    public CursorAdapter(Context context, Cursor cursor) {
        mo3062a(context, cursor, 1);
    }

    public CursorAdapter(Context context, Cursor cursor, int i) {
        mo3062a(context, cursor, i);
    }

    public CursorAdapter(Context context, Cursor cursor, boolean z) {
        mo3062a(context, cursor, z ? 1 : 2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3061a() {
        if (this.f1430b && this.f1431c != null && !this.f1431c.isClosed()) {
            this.f1429a = this.f1431c.requery();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3062a(Context context, Cursor cursor, int i) {
        boolean z = true;
        if ((i & 1) == 1) {
            i |= 2;
            this.f1430b = true;
        } else {
            this.f1430b = false;
        }
        if (cursor == null) {
            z = false;
        }
        this.f1431c = cursor;
        this.f1429a = z;
        this.f1432d = context;
        this.f1433e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f1434f = new ChangeObserver();
            this.f1435g = new MyDataSetObserver();
        } else {
            this.f1434f = null;
            this.f1435g = null;
        }
        if (z) {
            if (this.f1434f != null) {
                cursor.registerContentObserver(this.f1434f);
            }
            if (this.f1435g != null) {
                cursor.registerDataSetObserver(this.f1435g);
            }
        }
    }

    public abstract void bindView(View view, Context context, Cursor cursor);

    public void changeCursor(Cursor cursor) {
        Cursor swapCursor = swapCursor(cursor);
        if (swapCursor != null) {
            swapCursor.close();
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public int getCount() {
        if (!this.f1429a || this.f1431c == null) {
            return 0;
        }
        return this.f1431c.getCount();
    }

    public Cursor getCursor() {
        return this.f1431c;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1429a) {
            return null;
        }
        this.f1431c.moveToPosition(i);
        if (view == null) {
            view = newDropDownView(this.f1432d, this.f1431c, viewGroup);
        }
        bindView(view, this.f1432d, this.f1431c);
        return view;
    }

    public Filter getFilter() {
        if (this.f1436h == null) {
            this.f1436h = new CursorFilter(this);
        }
        return this.f1436h;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return this.f1437i;
    }

    public Object getItem(int i) {
        if (!this.f1429a || this.f1431c == null) {
            return null;
        }
        this.f1431c.moveToPosition(i);
        return this.f1431c;
    }

    public long getItemId(int i) {
        if (!this.f1429a || this.f1431c == null || !this.f1431c.moveToPosition(i)) {
            return 0;
        }
        return this.f1431c.getLong(this.f1433e);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1429a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (!this.f1431c.moveToPosition(i)) {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        } else {
            if (view == null) {
                view = newView(this.f1432d, this.f1431c, viewGroup);
            }
            bindView(view, this.f1432d, this.f1431c);
            return view;
        }
    }

    public boolean hasStableIds() {
        return true;
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return newView(context, cursor, viewGroup);
    }

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        return this.f1437i != null ? this.f1437i.runQuery(charSequence) : this.f1431c;
    }

    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        this.f1437i = filterQueryProvider;
    }

    public Cursor swapCursor(Cursor cursor) {
        if (cursor == this.f1431c) {
            return null;
        }
        Cursor cursor2 = this.f1431c;
        if (cursor2 != null) {
            if (this.f1434f != null) {
                cursor2.unregisterContentObserver(this.f1434f);
            }
            if (this.f1435g != null) {
                cursor2.unregisterDataSetObserver(this.f1435g);
            }
        }
        this.f1431c = cursor;
        if (cursor != null) {
            if (this.f1434f != null) {
                cursor.registerContentObserver(this.f1434f);
            }
            if (this.f1435g != null) {
                cursor.registerDataSetObserver(this.f1435g);
            }
            this.f1433e = cursor.getColumnIndexOrThrow("_id");
            this.f1429a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.f1433e = -1;
        this.f1429a = false;
        notifyDataSetInvalidated();
        return cursor2;
    }
}
