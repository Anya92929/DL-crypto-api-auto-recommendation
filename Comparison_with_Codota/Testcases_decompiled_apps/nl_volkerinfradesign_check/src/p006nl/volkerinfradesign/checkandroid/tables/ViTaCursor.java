package p006nl.volkerinfradesign.checkandroid.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteQuery;
import android.provider.BaseColumns;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.ViTa;

/* renamed from: nl.volkerinfradesign.checkandroid.tables.ViTaCursor */
public interface ViTaCursor extends Cursor, BaseColumns {
    byte[] getBlob(String str);

    boolean getBoolean(int i);

    boolean getBoolean(String str);

    double getDouble(String str);

    float getFloat(String str);

    long getId();

    int getInt(String str);

    long getLong(String str);

    ViTa.Helper.ReadableDatabase getReadableDatabase();

    short getShort(String str);

    String getString(String str);

    Table getTable();

    ViTa.Helper.WritableDatabase getWritableDatabase();

    boolean isEmpty();

    boolean isNull(String str);

    boolean moveToId(long j);

    ContentValues toContentValues();

    /* renamed from: nl.volkerinfradesign.checkandroid.tables.ViTaCursor$Instance */
    public static class Instance extends SQLiteCursor implements ViTaCursor {

        /* renamed from: a */
        private String[] f4977a;

        /* renamed from: b */
        private Table f4978b;

        public Instance(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            super(sQLiteCursorDriver, str, sQLiteQuery);
        }

        public long getId() {
            return getLong(getColumnIndex("_id"));
        }

        public boolean moveToId(long j) {
            int position = getPosition();
            for (int i = 0; moveToPosition(i); i++) {
                if (getId() == j) {
                    return true;
                }
            }
            moveToPosition(position);
            return false;
        }

        public byte[] getBlob(String str) {
            return getBlob(getColumnIndex(str));
        }

        public short getShort(String str) {
            return getShort(getColumnIndex(str));
        }

        public int getInt(String str) {
            return getInt(getColumnIndex(str));
        }

        public long getLong(String str) {
            return getLong(getColumnIndex(str));
        }

        public float getFloat(String str) {
            return getFloat(getColumnIndex(str));
        }

        public double getDouble(String str) {
            return getDouble(getColumnIndex(str));
        }

        public String getString(String str) {
            return getString(getColumnIndex(str));
        }

        public ContentValues toContentValues() {
            ContentValues contentValues = new ContentValues();
            for (String str : getColumnNames()) {
                int columnIndex = getColumnIndex(str);
                Column.DataType a = Column.DataType.m6033a(getType(columnIndex));
                if (a != null) {
                    switch (a) {
                        case BLOB:
                            contentValues.put(str, getBlob(columnIndex));
                            break;
                        case INTEGER:
                            contentValues.put(str, Long.valueOf(getLong(columnIndex)));
                            break;
                        case REAL:
                            contentValues.put(str, Double.valueOf(getDouble(columnIndex)));
                            break;
                        case TEXT:
                            contentValues.put(str, getString(columnIndex));
                            break;
                    }
                } else {
                    contentValues.putNull(str);
                }
            }
            return contentValues;
        }

        public boolean getBoolean(int i) {
            return getInt(i) > 0;
        }

        public boolean getBoolean(String str) {
            return getBoolean(getColumnIndex(str));
        }

        public boolean isNull(String str) {
            return isNull(getColumnIndex(str));
        }

        public ViTa.Helper.ReadableDatabase getReadableDatabase() {
            return ViTa.getReadableDatabase();
        }

        public ViTa.Helper.WritableDatabase getWritableDatabase() {
            return ViTa.getWritableDatabase();
        }

        public String[] getIdAsStringArray() {
            if (this.f4977a == null) {
                this.f4977a = new String[]{Long.toString(getId())};
            }
            return this.f4977a;
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public Table getTable() {
            return this.f4978b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Instance mo9800a(Table table) {
            this.f4978b = table;
            return this;
        }
    }
}
