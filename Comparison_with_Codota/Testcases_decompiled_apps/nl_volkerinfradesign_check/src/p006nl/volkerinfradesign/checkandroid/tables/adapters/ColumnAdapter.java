package p006nl.volkerinfradesign.checkandroid.tables.adapters;

import android.content.ContentValues;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;

/* renamed from: nl.volkerinfradesign.checkandroid.tables.adapters.ColumnAdapter */
public interface ColumnAdapter {
    Column.DataType getAssociation();

    Object getValue(ViTaCursor viTaCursor, int i);

    void putValue(String str, Object obj, ContentValues contentValues);
}
