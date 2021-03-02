package p006nl.volkerinfradesign.checkandroid.tables;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;
import p006nl.volkerinfradesign.checkandroid.tables.Settings;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;

/* renamed from: nl.volkerinfradesign.checkandroid.tables.ViTa */
public final class ViTa {
    public static final String LOG_TAG = "VirtualTablesTag";

    /* renamed from: a */
    static ViTa f4965a;

    /* renamed from: b */
    final Helper f4966b;

    /* renamed from: c */
    final Settings f4967c;

    /* renamed from: nl.volkerinfradesign.checkandroid.tables.ViTa$ConflictAlogrithm */
    public enum ConflictAlogrithm {
        ABORT {
            public int getInt() {
                return 2;
            }
        },
        FAIL {
            public int getInt() {
                return 3;
            }
        },
        IGNORE {
            public int getInt() {
                return 4;
            }
        },
        NONE {
            public int getInt() {
                return 0;
            }
        },
        REPLACE {
            public int getInt() {
                return 5;
            }
        },
        ROLLBACK {
            public int getInt() {
                return 1;
            }
        };

        public abstract int getInt();
    }

    public static Helper getHelper() {
        return f4965a.f4966b;
    }

    public static Helper.ReadableDatabase getReadableDatabase() {
        return f4965a.f4966b.f4970a;
    }

    public static Helper.WritableDatabase getWritableDatabase() {
        return f4965a.f4966b.f4971b;
    }

    public static ViTa init(Context context) {
        return init(new Settings(context));
    }

    public static ViTa init(Settings settings) {
        if (f4965a == null) {
            if (settings == null) {
                throw new NullPointerException("The Initializer object is mandatory!");
            }
            f4965a = new ViTa(settings);
        }
        return f4965a;
    }

    public static boolean isInitialized() {
        return f4965a != null;
    }

    private ViTa(Settings settings) {
        this.f4967c = settings;
        this.f4966b = new Helper(settings);
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.tables.ViTa$Helper */
    public final class Helper extends SQLiteOpenHelper {

        /* renamed from: a */
        final ReadableDatabase f4970a;

        /* renamed from: b */
        final WritableDatabase f4971b;

        private Helper(Settings settings) {
            super(settings.f4951a, settings.f4952b, new ViTaCursorFactory() {
                public ViTaCursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                    return new ViTaCursor.Instance(sQLiteCursorDriver, str, sQLiteQuery);
                }
            }, settings.f4953c);
            this.f4970a = new ReadableDatabase();
            this.f4971b = new WritableDatabase();
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Settings.Action onDowngrade;
            if (ViTa.this.f4967c.f4955e == null || (onDowngrade = ViTa.this.f4967c.f4955e.onDowngrade(i, i2)) == null) {
                super.onDowngrade(sQLiteDatabase, i, i2);
                return;
            }
            switch (onDowngrade) {
                case WIPE:
                    m6042a(sQLiteDatabase);
                    return;
                default:
                    return;
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Settings.Action onUpgrade;
            if (ViTa.this.f4967c.f4955e != null && (onUpgrade = ViTa.this.f4967c.f4955e.onUpgrade(i, i2)) != null) {
                switch (onUpgrade) {
                    case WIPE:
                        m6042a(sQLiteDatabase);
                        return;
                    default:
                        return;
                }
            }
        }

        /* renamed from: a */
        private void m6042a(SQLiteDatabase sQLiteDatabase) {
            int i = 0;
            Cursor rawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table'", (String[]) null);
            try {
                DatabaseUtils.dumpCursor(rawQuery);
                while (true) {
                    int i2 = i;
                    if (rawQuery.moveToPosition(i2)) {
                        sQLiteDatabase.execSQL("drop table " + rawQuery.getString(0));
                        i = i2 + 1;
                    } else {
                        rawQuery.close();
                        return;
                    }
                }
            } catch (SQLiteException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                rawQuery.close();
                throw th;
            }
        }

        /* renamed from: nl.volkerinfradesign.checkandroid.tables.ViTa$Helper$ReadableDatabase */
        public class ReadableDatabase {
            private ReadableDatabase() {
            }

            public ViTaCursor query(Table table, boolean z, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
                String[] strArr3;
                table.synchronize();
                SQLiteDatabase readableDatabase = Helper.this.getReadableDatabase();
                String name = table.getName();
                if (strArr == null) {
                    strArr3 = table.getColumnNames();
                } else {
                    strArr3 = strArr;
                }
                return ((ViTaCursor.Instance) readableDatabase.query(z, name, strArr3, str, strArr2, str2, str3, str4, str5)).mo9800a(table);
            }

            public ViTaCursor query(Table table, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
                String[] strArr3;
                table.synchronize();
                SQLiteDatabase readableDatabase = Helper.this.getReadableDatabase();
                String str5 = table.f4958b;
                if (strArr == null) {
                    strArr3 = table.getColumnNames();
                } else {
                    strArr3 = strArr;
                }
                return ((ViTaCursor.Instance) readableDatabase.query(str5, strArr3, str, strArr2, str2, str3, str4)).mo9800a(table);
            }

            public ViTaCursor query(Table table, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
                String[] strArr3;
                table.synchronize();
                SQLiteDatabase readableDatabase = Helper.this.getReadableDatabase();
                String name = table.getName();
                if (strArr == null) {
                    strArr3 = table.getColumnNames();
                } else {
                    strArr3 = strArr;
                }
                return ((ViTaCursor.Instance) readableDatabase.query(name, strArr3, str, strArr2, str2, str3, str4, str5)).mo9800a(table);
            }

            public ViTaCursor queryWithFactory(ViTaCursorFactory viTaCursorFactory, boolean z, Table table, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
                String[] strArr3;
                table.synchronize();
                SQLiteDatabase readableDatabase = Helper.this.getReadableDatabase();
                String str6 = table.f4958b;
                if (strArr == null) {
                    strArr3 = table.getColumnNames();
                } else {
                    strArr3 = strArr;
                }
                return ((ViTaCursor.Instance) readableDatabase.queryWithFactory(viTaCursorFactory, z, str6, strArr3, str, strArr2, str2, str3, str4, str5)).mo9800a(table);
            }

            public Cursor rawQuery(String str, String[] strArr, Table... tableArr) {
                int i = 0;
                while (tableArr != null && i < tableArr.length) {
                    tableArr[i].synchronize();
                    i++;
                }
                return Helper.this.getReadableDatabase().rawQuery(str, strArr);
            }

            public Cursor rawQueryWithFactory(SQLiteDatabase.CursorFactory cursorFactory, String str, String[] strArr, String str2, Table... tableArr) {
                int i = 0;
                while (tableArr != null && i < tableArr.length) {
                    tableArr[i].synchronize();
                    i++;
                }
                return rawQueryWithFactory(cursorFactory, str, strArr, str2, tableArr);
            }
        }

        /* renamed from: nl.volkerinfradesign.checkandroid.tables.ViTa$Helper$WritableDatabase */
        public class WritableDatabase extends ReadableDatabase {
            private WritableDatabase() {
                super();
            }

            public int delete(Table table, String str, String[] strArr) {
                table.synchronize();
                return Helper.this.getWritableDatabase().delete(table.f4958b, str, strArr);
            }

            public long insert(Table table, String str, ContentValues contentValues) {
                table.synchronize();
                return Helper.this.getWritableDatabase().insert(table.f4958b, str, contentValues);
            }

            public long insertOrThrow(Table table, String str, ContentValues contentValues) {
                table.synchronize();
                return Helper.this.getWritableDatabase().insertOrThrow(table.f4958b, str, contentValues);
            }

            public long insertWithOnConflict(Table table, String str, ContentValues contentValues, ConflictAlogrithm conflictAlogrithm) {
                table.synchronize();
                return Helper.this.getWritableDatabase().insertWithOnConflict(table.getName(), str, contentValues, conflictAlogrithm.getInt());
            }

            public int update(Table table, ContentValues contentValues, String str, String[] strArr) {
                table.synchronize();
                return Helper.this.getWritableDatabase().update(table.f4958b, contentValues, str, strArr);
            }

            public int updateWithOnConflict(Table table, ContentValues contentValues, String str, String[] strArr, ConflictAlogrithm conflictAlogrithm) {
                table.synchronize();
                return Helper.this.getWritableDatabase().updateWithOnConflict(table.f4958b, contentValues, str, strArr, conflictAlogrithm.getInt());
            }
        }
    }
}
