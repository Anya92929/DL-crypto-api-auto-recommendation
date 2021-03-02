package p006nl.volkerinfradesign.checkandroid.tables;

import android.database.Cursor;
import java.util.Collection;

/* renamed from: nl.volkerinfradesign.checkandroid.tables.DbUtil */
public final class DbUtil {
    public static final String getColNamesAsString(Collection<Column> collection) {
        StringBuilder sb = new StringBuilder();
        for (Column name : collection) {
            sb.append(name.getName());
            sb.append(", ");
        }
        String sb2 = sb.toString();
        if (sb2.length() > 2) {
            return sb2.substring(0, sb2.length() - 2);
        }
        return null;
    }

    public static final Argumenter getArgumenter(Collection<Long> collection) {
        return new Argumenter((Long[]) collection.toArray(new Long[collection.size()]));
    }

    public static final Argumenter getArgumenter(long[] jArr) {
        return new Argumenter(toObject(jArr));
    }

    public static void closeQuietly(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    public static Long[] toObject(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        if (jArr.length == 0) {
            return new Long[0];
        }
        Long[] lArr = new Long[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.tables.DbUtil$Argumenter */
    public static class Argumenter {

        /* renamed from: a */
        private final Long[] f4945a;

        /* renamed from: b */
        private String[] f4946b;

        private Argumenter(Long[] lArr) {
            if (lArr == null) {
                throw new NullPointerException("The ids may not be null");
            } else if (lArr.length > 999) {
                throw new IndexOutOfBoundsException("The maximum is 999 items!");
            } else {
                this.f4945a = lArr;
            }
        }

        public String getSelection(boolean z) {
            if (this.f4945a.length != 0) {
                String str = new String();
                for (int i = 0; i < this.f4945a.length; i++) {
                    str = str + "?, ";
                }
                if (z) {
                    return "(" + str.substring(0, str.length() - 2) + ")";
                }
                return str.substring(0, str.length() - 2);
            } else if (z) {
                return "()";
            } else {
                return "";
            }
        }

        public String[] getSelectionArgs() {
            if (this.f4946b == null) {
                this.f4946b = new String[this.f4945a.length];
                for (int i = 0; i < this.f4946b.length; i++) {
                    this.f4946b[i] = Long.toString(this.f4945a[i].longValue());
                }
            }
            return this.f4946b;
        }
    }
}
