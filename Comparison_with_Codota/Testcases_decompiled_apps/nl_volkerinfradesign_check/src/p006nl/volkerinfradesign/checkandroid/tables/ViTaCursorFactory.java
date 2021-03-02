package p006nl.volkerinfradesign.checkandroid.tables;

import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;

/* renamed from: nl.volkerinfradesign.checkandroid.tables.ViTaCursorFactory */
public interface ViTaCursorFactory extends SQLiteDatabase.CursorFactory {
    ViTaCursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery);
}
