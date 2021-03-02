package p006nl.volkerinfradesign.checkandroid.tables.adapters;

import android.content.ContentValues;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;

/* renamed from: nl.volkerinfradesign.checkandroid.tables.adapters.FloatAdapter */
public class FloatAdapter implements ColumnAdapter {
    public Column.DataType getAssociation() {
        return Column.DataType.REAL;
    }

    public void putValue(String str, Object obj, ContentValues contentValues) {
        contentValues.put(str, (Float) obj);
    }

    public Float getValue(ViTaCursor viTaCursor, int i) {
        return Float.valueOf(viTaCursor.getFloat(i));
    }
}
