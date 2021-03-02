package p006nl.volkerinfradesign.checkandroid.tables.adapters;

import android.content.ContentValues;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;

/* renamed from: nl.volkerinfradesign.checkandroid.tables.adapters.StringAdapter */
public class StringAdapter implements ColumnAdapter {
    public Column.DataType getAssociation() {
        return Column.DataType.TEXT;
    }

    public void putValue(String str, Object obj, ContentValues contentValues) {
        contentValues.put(str, (String) obj);
    }

    public String getValue(ViTaCursor viTaCursor, int i) {
        return viTaCursor.getString(i);
    }
}
