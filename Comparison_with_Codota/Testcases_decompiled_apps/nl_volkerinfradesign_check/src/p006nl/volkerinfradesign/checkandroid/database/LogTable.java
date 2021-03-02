package p006nl.volkerinfradesign.checkandroid.database;

import android.content.ContentValues;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import org.apache.commons.p009io.IOUtils;
import p006nl.volkerinfradesign.checkandroid.database.ThrowableTable;
import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.ColumnEditor;
import p006nl.volkerinfradesign.checkandroid.tables.Table;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursorFactory;

/* renamed from: nl.volkerinfradesign.checkandroid.database.LogTable */
public final class LogTable extends Table {
    public static final int MAX_SIZE = 1000;

    /* renamed from: a */
    private final Handler f4829a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final DataSetObservable f4830c = new DataSetObservable();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final ThrowableTable f4831d;

    /* renamed from: nl.volkerinfradesign.checkandroid.database.LogTable$LogCursor */
    public interface LogCursor extends ViTaCursor {
        String getMessage();

        String getTag();

        ThrowableTable.ThrowableCursor getThrowable();

        C1467b getVerbosity();
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.database.LogTable$b */
    enum C1467b {
        DEBUG,
        ERROR,
        INFO,
        VERBOSE,
        WARN
    }

    LogTable(ThrowableTable throwableTable, Looper looper) {
        super("log_table");
        this.f4831d = throwableTable;
        this.f4829a = new Handler(looper) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.arg1) {
                    case 0:
                        LogTable.this.f4830c.notifyInvalidated();
                        return;
                    case 1:
                        LogTable.this.f4830c.notifyChanged();
                        return;
                    default:
                        return;
                }
            }
        };
        putColumn("verbosity", Column.DataType.TEXT).notNull();
        putColumn("tag", Column.DataType.TEXT);
        putColumn("message", Column.DataType.TEXT);
        putColumn("log_date", Column.DataType.INTEGER).notNull().defaultValue(ColumnEditor.LiteralValue.CURRENT_TIMESTAMP);
    }

    public void clear() {
        delete((String) null, (String[]) null);
        m5967b();
    }

    public LogCursor getAll() {
        return (LogCursor) query((String[]) null, (String) null, (String[]) null, (String) null, (String) null, "log_date");
    }

    public long logDebug(String str, String str2, Throwable th) {
        return m5963a(C1467b.DEBUG, str, str2, th);
    }

    public long logError(String str, String str2, Throwable th) {
        return m5963a(C1467b.ERROR, str, str2, th);
    }

    public long logInfo(String str, String str2, Throwable th) {
        return m5963a(C1467b.INFO, str, str2, th);
    }

    public long logVerbose(String str, String str2, Throwable th) {
        return m5963a(C1467b.VERBOSE, str, str2, th);
    }

    public long logWarn(String str, String str2, Throwable th) {
        return m5963a(C1467b.WARN, str, str2, th);
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.f4830c.registerObserver(dataSetObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.f4830c.unregisterObserver(dataSetObserver);
    }

    /* access modifiers changed from: protected */
    public ViTaCursorFactory onCreateDefaultFactory() {
        return new ViTaCursorFactory() {
            public ViTaCursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return new C1466a(sQLiteCursorDriver, str, sQLiteQuery);
            }
        };
    }

    /* renamed from: a */
    private long m5963a(C1467b bVar, String str, String str2, Throwable th) {
        ContentValues contentValues = new ContentValues(4);
        contentValues.put("verbosity", bVar.name());
        contentValues.put("tag", str);
        contentValues.put("message", str2);
        contentValues.put("log_date", Long.valueOf(System.currentTimeMillis()));
        long insert = insert(contentValues);
        if (th != null) {
            this.f4831d.mo9449a(th, (String) null, Long.valueOf(insert));
        }
        m5968d();
        m5965a();
        return insert;
    }

    /* renamed from: a */
    private void m5965a() {
        Message message = new Message();
        this.f4831d.mo8477a();
        message.arg1 = 1;
        this.f4829a.sendMessage(message);
    }

    /* renamed from: b */
    private void m5967b() {
        Message message = new Message();
        this.f4831d.mo8477a();
        message.arg1 = 0;
        this.f4829a.sendMessage(message);
    }

    /* renamed from: d */
    private boolean m5968d() {
        int size = size();
        if (size() <= 1000) {
            return false;
        }
        getHelper().getWritableDatabase().execSQL(((("DELETE FROM log_table\n" + "WHERE _id IN (\n\t") + "SELECT _id\n\tFROM log_table\n\t") + "ORDER BY log_date\n\tLIMIT " + (size - 1000) + IOUtils.LINE_SEPARATOR_UNIX) + ");");
        return true;
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.database.LogTable$a */
    class C1466a extends ViTaCursor.Instance implements LogCursor {
        public C1466a(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            super(sQLiteCursorDriver, str, sQLiteQuery);
        }

        public String getMessage() {
            return getString("message");
        }

        public String getTag() {
            return getString("tag");
        }

        public ThrowableTable.ThrowableCursor getThrowable() {
            return LogTable.this.f4831d.mo9450a(getId());
        }

        public C1467b getVerbosity() {
            return C1467b.valueOf(getString("verbosity"));
        }
    }
}
