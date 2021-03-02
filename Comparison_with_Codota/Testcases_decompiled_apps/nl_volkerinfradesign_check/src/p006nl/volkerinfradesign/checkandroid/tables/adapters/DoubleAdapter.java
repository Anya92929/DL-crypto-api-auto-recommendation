package p006nl.volkerinfradesign.checkandroid.tables.adapters;

import android.content.ContentValues;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;

/* renamed from: nl.volkerinfradesign.checkandroid.tables.adapters.DoubleAdapter */
public class DoubleAdapter implements ColumnAdapter {
    public Column.DataType getAssociation() {
        return Column.DataType.REAL;
    }

    public void putValue(String str, Object obj, ContentValues contentValues) {
        contentValues.put(str, (Double) obj);
    }

    public Double getValue(ViTaCursor viTaCursor, int i) {
        return Double.valueOf(viTaCursor.getDouble(i));
    }
}
