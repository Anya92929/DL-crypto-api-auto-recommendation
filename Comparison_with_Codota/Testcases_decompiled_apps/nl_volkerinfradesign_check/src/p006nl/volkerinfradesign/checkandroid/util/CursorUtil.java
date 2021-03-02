package p006nl.volkerinfradesign.checkandroid.util;

import android.database.Cursor;

/* renamed from: nl.volkerinfradesign.checkandroid.util.CursorUtil */
public abstract class CursorUtil<T extends Cursor> {

    /* renamed from: a */
    private T f5673a;

    public abstract T query();

    public static <T extends Cursor> CursorUtil<T> newInstance(final T t) {
        return new CursorUtil<T>() {
            public T query() {
                return t;
            }
        };
    }

    public T getFirst() {
        return get(0);
    }

    public T get(int i) {
        if (this.f5673a == null || this.f5673a.isClosed()) {
            this.f5673a = query();
        }
        if (this.f5673a == null || this.f5673a.isClosed() || !this.f5673a.moveToPosition(i)) {
            return null;
        }
        return this.f5673a;
    }

    public void closeQuietly() {
        closeQuietly(this.f5673a);
    }

    public static void closeQuietly(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    public int getCount() {
        Cursor first = getFirst();
        if (isValid()) {
            return first.getCount();
        }
        return 0;
    }

    public boolean isValid() {
        return this.f5673a != null && !this.f5673a.isClosed() && !this.f5673a.isBeforeFirst() && !this.f5673a.isAfterLast();
    }

    public static boolean isValid(Cursor cursor) {
        return cursor != null && !cursor.isClosed() && !cursor.isBeforeFirst() && !cursor.isAfterLast();
    }
}
