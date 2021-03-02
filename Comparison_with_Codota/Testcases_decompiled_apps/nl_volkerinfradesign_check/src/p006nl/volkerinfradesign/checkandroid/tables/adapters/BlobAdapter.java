package p006nl.volkerinfradesign.checkandroid.tables.adapters;

import android.content.ContentValues;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;

/* renamed from: nl.volkerinfradesign.checkandroid.tables.adapters.BlobAdapter */
public class BlobAdapter implements ColumnAdapter {
    public Column.DataType getAssociation() {
        return Column.DataType.REAL;
    }

    public void putValue(String str, Object obj, ContentValues contentValues) {
        contentValues.put(str, obj instanceof Byte[] ? toPrimitive((Byte[]) obj) : (byte[]) obj);
    }

    public static byte[] toPrimitive(Byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[i].byteValue();
        }
        return bArr2;
    }

    public byte[] getValue(ViTaCursor viTaCursor, int i) {
        return viTaCursor.getBlob(i);
    }
}
