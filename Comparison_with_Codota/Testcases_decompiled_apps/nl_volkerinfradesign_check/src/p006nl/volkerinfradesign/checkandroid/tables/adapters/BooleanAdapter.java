package p006nl.volkerinfradesign.checkandroid.tables.adapters;

import android.content.ContentValues;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;

/* renamed from: nl.volkerinfradesign.checkandroid.tables.adapters.BooleanAdapter */
public class BooleanAdapter implements ColumnAdapter {
    public Column.DataType getAssociation() {
        return Column.DataType.INTEGER;
    }

    public void putValue(String str, Object obj, ContentValues contentValues) {
        contentValues.put(str, (Boolean) obj);
    }

    public Boolean getValue(ViTaCursor viTaCursor, int i) {
        return Boolean.valueOf(viTaCursor.getBoolean(i));
    }
}
