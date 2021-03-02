package p006nl.volkerinfradesign.checkandroid.tables.adapters;

import android.content.ContentValues;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;

/* renamed from: nl.volkerinfradesign.checkandroid.tables.adapters.LongAdapter */
public class LongAdapter implements ColumnAdapter {
    public Column.DataType getAssociation() {
        return Column.DataType.INTEGER;
    }

    public void putValue(String str, Object obj, ContentValues contentValues) {
        contentValues.put(str, (Long) obj);
    }

    public Long getValue(ViTaCursor viTaCursor, int i) {
        return Long.valueOf(viTaCursor.getLong(i));
    }
}
