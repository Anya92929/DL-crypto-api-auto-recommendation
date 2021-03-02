package p006nl.volkerinfradesign.checkandroid.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.support.p001v4.util.LongSparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorTreeAdapter;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.ColumnEditor;
import p006nl.volkerinfradesign.checkandroid.tables.DbUtil;
import p006nl.volkerinfradesign.checkandroid.tables.Table;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursorFactory;

/* renamed from: nl.volkerinfradesign.checkandroid.database.ThrowableTable */
public final class ThrowableTable extends Table {

    /* renamed from: a */
    private final StackTracesTable f4873a;

    /* renamed from: nl.volkerinfradesign.checkandroid.database.ThrowableTable$ThrowableCursor */
    public interface ThrowableCursor extends ViTaCursor {
        String getClassName();

        String getComment();

        Class<? extends Exception> getExceptionClass() throws ClassNotFoundException;

        Date getLogDate();

        String getMessage();

        StackTraceCursor getStackTrace();
    }

    ThrowableTable(StackTracesTable stackTracesTable) {
        super("throwable_table");
        this.f4873a = stackTracesTable;
        putColumn("message", Column.DataType.TEXT);
        putColumn("comment", Column.DataType.TEXT);
        putColumn("cls_name", Column.DataType.TEXT).notNull();
        putColumn("log_date", Column.DataType.INTEGER).notNull().defaultValue(ColumnEditor.LiteralValue.CURRENT_TIMESTAMP);
        putColumn("log_id", Column.DataType.INTEGER);
    }

    public ThrowableCursor getAll() {
        return (ThrowableCursor) query((String[]) null, (String) null, (String[]) null, (String) null, (String) null, "log_date DESC");
    }

    public long log(Throwable th, String str) {
        return mo9449a(th, str, (Long) null);
    }

    /* access modifiers changed from: protected */
    public ViTaCursorFactory onCreateDefaultFactory() {
        return new ViTaCursorFactory() {
            public ViTaCursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return new C1480a(sQLiteCursorDriver, str, sQLiteQuery);
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ThrowableCursor mo9450a(long j) {
        return (ThrowableCursor) query("log_id = ?", new String[]{Long.toString(j)}, new String[0]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo9449a(Throwable th, String str, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message", th.getMessage());
        contentValues.put("cls_name", th.getClass().getName());
        contentValues.put("log_date", Long.valueOf(System.currentTimeMillis()));
        if (l != null) {
            contentValues.put("log_id", l);
        }
        if (str != null && str.length() > 0) {
            contentValues.put("comment", str);
        }
        long insert = insert(contentValues);
        this.f4873a.log(insert, th);
        return insert;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo8477a() {
        delete("log_id not null and log_id not in (select _id from log_table)", (String[]) null);
        this.f4873a.mo8477a();
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.database.ThrowableTable$ExceptionsAdapter */
    public static class ExceptionsAdapter extends CursorTreeAdapter {

        /* renamed from: a */
        private final SimpleDateFormat f4875a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());

        /* renamed from: b */
        private final LayoutInflater f4876b;

        public ExceptionsAdapter(Context context) {
            super(Schema.getThrowables().getAll(), context);
            this.f4876b = LayoutInflater.from(context);
        }

        public StackTraceCursor getChild(int i, int i2) {
            return (StackTraceCursor) super.getChild(i, i2);
        }

        public long getChildId(int i, int i2) {
            return getChild(i, i2).getId();
        }

        public ThrowableCursor getGroup(int i) {
            return (ThrowableCursor) super.getGroup(i);
        }

        public long getGroupId(int i) {
            return getGroup(i).getId();
        }

        public boolean hasStableIds() {
            return true;
        }

        /* access modifiers changed from: protected */
        public void bindChildView(View view, Context context, Cursor cursor, boolean z) {
            StackTraceCursor stackTraceCursor = (StackTraceCursor) cursor;
            ((TextView) view.findViewById(16908308)).setText(stackTraceCursor.getFileName());
            ((TextView) view.findViewById(16908309)).setText(stackTraceCursor.getClassName() + "." + stackTraceCursor.getMethodName() + " (" + stackTraceCursor.getLineNumber() + ")");
        }

        /* access modifiers changed from: protected */
        public void bindGroupView(View view, Context context, Cursor cursor, boolean z) {
            ThrowableCursor throwableCursor = (ThrowableCursor) cursor;
            TextView textView = (TextView) view.findViewById(16908308);
            TextView textView2 = (TextView) view.findViewById(16908309);
            textView.setText(throwableCursor.getClassName());
            textView.setSingleLine();
            textView2.setText(throwableCursor.getComment() + " (" + this.f4875a.format(throwableCursor.getLogDate()) + ")");
            textView2.setSingleLine();
        }

        /* access modifiers changed from: protected */
        public StackTraceCursor getChildrenCursor(Cursor cursor) {
            return ((ThrowableCursor) cursor).getStackTrace();
        }

        /* access modifiers changed from: protected */
        public View newChildView(Context context, Cursor cursor, boolean z, ViewGroup viewGroup) {
            return this.f4876b.inflate(17367044, viewGroup, false);
        }

        /* access modifiers changed from: protected */
        public View newGroupView(Context context, Cursor cursor, boolean z, ViewGroup viewGroup) {
            return this.f4876b.inflate(17367047, viewGroup, false);
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.database.ThrowableTable$a */
    class C1480a extends ViTaCursor.Instance implements ThrowableCursor {

        /* renamed from: b */
        private final LongSparseArray<StackTraceCursor> f4878b = new LongSparseArray<>();

        public C1480a(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            super(sQLiteCursorDriver, str, sQLiteQuery);
        }

        public void close() {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f4878b.size()) {
                    DbUtil.closeQuietly(this.f4878b.valueAt(i2));
                    i = i2 + 1;
                } else {
                    super.close();
                    return;
                }
            }
        }

        public String getClassName() {
            return getString("cls_name");
        }

        public String getComment() {
            return getString("comment");
        }

        public Class<? extends Exception> getExceptionClass() throws ClassNotFoundException {
            return Class.forName(getString("cls_name"));
        }

        public Date getLogDate() {
            return new Date(getLong("log_date"));
        }

        public String getMessage() {
            return getString("message");
        }

        public StackTraceCursor getStackTrace() {
            long id = getId();
            StackTraceCursor stackTraceCursor = this.f4878b.get(id);
            if (stackTraceCursor != null && !stackTraceCursor.isClosed()) {
                return stackTraceCursor;
            }
            StackTraceCursor stackTraces = Schema.m5983c().getStackTraces(id);
            this.f4878b.put(id, stackTraces);
            return stackTraces;
        }
    }
}
