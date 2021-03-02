package p006nl.volkerinfradesign.checkandroid.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.Table;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursorFactory;

/* renamed from: nl.volkerinfradesign.checkandroid.database.StackTracesTable */
public class StackTracesTable extends Table {
    StackTracesTable() {
        super("stack_traces");
        putColumn("trace_order", Column.DataType.INTEGER).notNull();
        putColumn("exception_id", Column.DataType.INTEGER).notNull();
        putColumn("file_name", Column.DataType.TEXT);
        putColumn("cls_name", Column.DataType.TEXT);
        putColumn("method_name", Column.DataType.TEXT);
        putColumn("line_num", Column.DataType.INTEGER);
    }

    public StackTraceCursor getStackTraces(long j) {
        return (StackTraceCursor) query((String[]) null, "exception_id = ?", new String[]{Long.toString(j)}, (String) null, (String) null, "trace_order");
    }

    public long[] log(long j, Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        long[] jArr = new long[stackTrace.length];
        for (int i = 0; i < stackTrace.length; i++) {
            StackTraceElement stackTraceElement = stackTrace[i];
            ContentValues contentValues = new ContentValues(5);
            contentValues.put("trace_order", Integer.valueOf(i));
            contentValues.put("exception_id", Long.valueOf(j));
            contentValues.put("file_name", stackTraceElement.getFileName());
            contentValues.put("cls_name", stackTraceElement.getClassName());
            contentValues.put("method_name", stackTraceElement.getMethodName());
            contentValues.put("line_num", Integer.valueOf(stackTraceElement.getLineNumber()));
            jArr[i] = insert(contentValues);
        }
        return jArr;
    }

    /* access modifiers changed from: protected */
    public ViTaCursorFactory onCreateDefaultFactory() {
        return new ViTaCursorFactory() {
            public ViTaCursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return new C1478a(sQLiteCursorDriver, str, sQLiteQuery);
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo8477a() {
        delete("exception_id not null and exception_id not in (select _id from throwable_table)", (String[]) null);
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.database.StackTracesTable$a */
    class C1478a extends ViTaCursor.Instance implements StackTraceCursor {
        public C1478a(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            super(sQLiteCursorDriver, str, sQLiteQuery);
        }

        public String getClassName() {
            return getString("cls_name");
        }

        public String getFileName() {
            return getString("file_name");
        }

        public int getLineNumber() {
            return getInt("line_num");
        }

        public String getMethodName() {
            return getString("method_name");
        }
    }
}
