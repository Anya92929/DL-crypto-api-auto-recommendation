package p006nl.volkerinfradesign.checkandroid.tables.adapters;

import android.content.ContentValues;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;

/* renamed from: nl.volkerinfradesign.checkandroid.tables.adapters.ByteAdapter */
public class ByteAdapter implements ColumnAdapter {
    public Column.DataType getAssociation() {
        return Column.DataType.INTEGER;
    }

    public void putValue(String str, Object obj, ContentValues contentValues) {
        contentValues.put(str, (Byte) obj);
    }

    public Byte getValue(ViTaCursor viTaCursor, int i) {
        return Byte.valueOf(Integer.valueOf(viTaCursor.getInt(i)).byteValue());
    }
}
