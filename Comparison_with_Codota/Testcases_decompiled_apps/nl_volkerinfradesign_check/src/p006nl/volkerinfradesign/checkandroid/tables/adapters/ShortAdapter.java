package p006nl.volkerinfradesign.checkandroid.tables.adapters;

import android.content.ContentValues;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;

/* renamed from: nl.volkerinfradesign.checkandroid.tables.adapters.ShortAdapter */
public class ShortAdapter implements ColumnAdapter {
    public Column.DataType getAssociation() {
        return Column.DataType.INTEGER;
    }

    public void putValue(String str, Object obj, ContentValues contentValues) {
        contentValues.put(str, (Short) obj);
    }

    public Short getValue(ViTaCursor viTaCursor, int i) {
        return Short.valueOf(viTaCursor.getShort(i));
    }
}
