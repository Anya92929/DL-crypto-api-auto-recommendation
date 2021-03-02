package android.support.p009v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

/* renamed from: android.support.v4.widget.m */
public abstract class C0412m extends BaseAdapter implements C0417r, Filterable {

    /* renamed from: a */
    protected boolean f558a;

    /* renamed from: b */
    protected boolean f559b;

    /* renamed from: c */
    protected Cursor f560c;

    /* renamed from: d */
    protected Context f561d;

    /* renamed from: e */
    protected int f562e;

    /* renamed from: f */
    protected C0414o f563f;

    /* renamed from: g */
    protected DataSetObserver f564g;

    /* renamed from: h */
    protected C0416q f565h;

    /* renamed from: i */
    protected FilterQueryProvider f566i;

    public C0412m(Context context, Cursor cursor, boolean z) {
        mo1878a(context, cursor, z ? 1 : 2);
    }

    /* renamed from: a */
    public Cursor mo1876a() {
        return this.f560c;
    }

    /* renamed from: a */
    public Cursor mo1877a(CharSequence charSequence) {
        return this.f566i != null ? this.f566i.runQuery(charSequence) : this.f560c;
    }

    /* renamed from: a */
    public abstract View mo1805a(Context context, Cursor cursor, ViewGroup viewGroup);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1878a(Context context, Cursor cursor, int i) {
        boolean z = true;
        if ((i & 1) == 1) {
            i |= 2;
            this.f559b = true;
        } else {
            this.f559b = false;
        }
        if (cursor == null) {
            z = false;
        }
        this.f560c = cursor;
        this.f558a = z;
        this.f561d = context;
        this.f562e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f563f = new C0414o(this);
            this.f564g = new C0415p(this);
        } else {
            this.f563f = null;
            this.f564g = null;
        }
        if (z) {
            if (this.f563f != null) {
                cursor.registerContentObserver(this.f563f);
            }
            if (this.f564g != null) {
                cursor.registerDataSetObserver(this.f564g);
            }
        }
    }

    /* renamed from: a */
    public void mo1879a(Cursor cursor) {
        Cursor b = mo1881b(cursor);
        if (b != null) {
            b.close();
        }
    }

    /* renamed from: a */
    public abstract void mo1880a(View view, Context context, Cursor cursor);

    /* renamed from: b */
    public Cursor mo1881b(Cursor cursor) {
        if (cursor == this.f560c) {
            return null;
        }
        Cursor cursor2 = this.f560c;
        if (cursor2 != null) {
            if (this.f563f != null) {
                cursor2.unregisterContentObserver(this.f563f);
            }
            if (this.f564g != null) {
                cursor2.unregisterDataSetObserver(this.f564g);
            }
        }
        this.f560c = cursor;
        if (cursor != null) {
            if (this.f563f != null) {
                cursor.registerContentObserver(this.f563f);
            }
            if (this.f564g != null) {
                cursor.registerDataSetObserver(this.f564g);
            }
            this.f562e = cursor.getColumnIndexOrThrow("_id");
            this.f558a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.f562e = -1;
        this.f558a = false;
        notifyDataSetInvalidated();
        return cursor2;
    }

    /* renamed from: b */
    public View mo1806b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return mo1805a(context, cursor, viewGroup);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo1882b() {
        if (this.f559b && this.f560c != null && !this.f560c.isClosed()) {
            this.f558a = this.f560c.requery();
        }
    }

    /* renamed from: c */
    public CharSequence mo1883c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public int getCount() {
        if (!this.f558a || this.f560c == null) {
            return 0;
        }
        return this.f560c.getCount();
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f558a) {
            return null;
        }
        this.f560c.moveToPosition(i);
        if (view == null) {
            view = mo1806b(this.f561d, this.f560c, viewGroup);
        }
        mo1880a(view, this.f561d, this.f560c);
        return view;
    }

    public Filter getFilter() {
        if (this.f565h == null) {
            this.f565h = new C0416q(this);
        }
        return this.f565h;
    }

    public Object getItem(int i) {
        if (!this.f558a || this.f560c == null) {
            return null;
        }
        this.f560c.moveToPosition(i);
        return this.f560c;
    }

    public long getItemId(int i) {
        if (!this.f558a || this.f560c == null || !this.f560c.moveToPosition(i)) {
            return 0;
        }
        return this.f560c.getLong(this.f562e);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f558a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (!this.f560c.moveToPosition(i)) {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        } else {
            if (view == null) {
                view = mo1805a(this.f561d, this.f560c, viewGroup);
            }
            mo1880a(view, this.f561d, this.f560c);
            return view;
        }
    }

    public boolean hasStableIds() {
        return true;
    }
}
