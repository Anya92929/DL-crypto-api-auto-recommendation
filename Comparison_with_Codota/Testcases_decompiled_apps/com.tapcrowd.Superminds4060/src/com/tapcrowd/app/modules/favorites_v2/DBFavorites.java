package com.tapcrowd.app.modules.favorites_v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.TCObject;
import java.util.ArrayList;
import java.util.List;

public class DBFavorites extends SQLiteOpenHelper {
    private static final String CREATE_TABLE_EXHIBITORS = "CREATE TABLE exhibitors(_id INTEGER PRIMARY KEY,id TEXT NOT NULL, name TEXT NOT NULL,module TEXT NOT NULL);";
    private static final String CREATE_TABLE_SESSIONS = "CREATE TABLE sessions(_id INTEGER PRIMARY KEY,id TEXT NOT NULL, name TEXT NOT NULL,module TEXT NOT NULL,startdate TEXT NOT NULL);";
    public static final String DATABASE_NAME = ("db_favorites" + App.f2123id + ".sql");
    public static final int DATABASE_VERSION = 4;
    public static final String KEY_EVENT_ID = "id";
    public static final String KEY_ID = "_id";
    public static final String KEY_MODULE = "module";
    public static final String KEY_NAME = "name";
    public static final String KEY_SESSION_STARTDATE = "startdate";
    public static final String TABLE_EXHIBITORS = "exhibitors";
    public static final String TABLE_SESSIONS = "sessions";

    public DBFavorites(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 4);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_EXHIBITORS);
        db.execSQL(CREATE_TABLE_SESSIONS);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            db.execSQL("DROP TABLE IF EXISTS exhibitors");
            db.execSQL("DROP TABLE IF EXISTS sessions");
            onCreate(db);
        }
    }

    public long createExhibition(String id, String name, String module) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_EVENT_ID, id);
        values.put(KEY_NAME, name);
        values.put(KEY_MODULE, module);
        return db.insert(TABLE_EXHIBITORS, (String) null, values);
    }

    public long createSession(String id, String name, String module, String startDate) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_EVENT_ID, id);
        values.put(KEY_NAME, name);
        values.put(KEY_MODULE, module);
        values.put(KEY_SESSION_STARTDATE, startDate);
        return db.insert("sessions", (String) null, values);
    }

    public List<TCObject> getAllSessions() {
        List<TCObject> sessions = new ArrayList<>();
        Cursor c = getReadableDatabase().rawQuery("SELECT * FROM sessions ORDER BY startdate", (String[]) null);
        if (c.moveToFirst()) {
            do {
                TCObject tc = new TCObject();
                for (String key : c.getColumnNames()) {
                    tc.vars.put(key, c.getString(c.getColumnIndex(key)));
                }
                sessions.add(tc);
            } while (c.moveToNext());
        }
        return sessions;
    }

    public void deleteSessions() {
        getWritableDatabase().delete("sessions", (String) null, (String[]) null);
    }

    public void deleteSession(String id) {
        getWritableDatabase().delete("sessions", "_id=" + id, (String[]) null);
    }

    public void deleteExhibitors() {
        getWritableDatabase().delete(TABLE_EXHIBITORS, (String) null, (String[]) null);
    }

    public void deleteExhibitor(String id) {
        getWritableDatabase().delete(TABLE_EXHIBITORS, "_id=" + id, (String[]) null);
    }

    public void deleteSessionByEventId(String id) {
        getWritableDatabase().delete("sessions", "id=" + id, (String[]) null);
    }

    public void deleteExhibitorByEventId(String id) {
        getWritableDatabase().delete(TABLE_EXHIBITORS, "id=" + id, (String[]) null);
    }

    public TCObject getById(String id, String table) {
        if (table.equalsIgnoreCase("Exhibitor")) {
            table = TABLE_EXHIBITORS;
        } else if (table.equalsIgnoreCase("Session")) {
            table = "sessions";
        }
        Cursor c = getReadableDatabase().rawQuery("SELECT * FROM " + table + " WHERE " + KEY_ID + " = " + id, (String[]) null);
        TCObject tc = new TCObject();
        if (c == null || c.getCount() <= 0) {
            return null;
        }
        c.moveToFirst();
        for (String key : c.getColumnNames()) {
            tc.vars.put(key, c.getString(c.getColumnIndex(key)));
        }
        return tc;
    }

    public TCObject getByEventId(String id, String table) {
        if (table.equalsIgnoreCase("Exhibitor")) {
            table = TABLE_EXHIBITORS;
        } else if (table.equalsIgnoreCase("Session")) {
            table = "sessions";
        }
        Cursor c = getReadableDatabase().rawQuery("SELECT * FROM " + table + " WHERE " + KEY_EVENT_ID + " = " + id, (String[]) null);
        TCObject tc = new TCObject();
        if (c == null || c.getCount() <= 0) {
            return null;
        }
        c.moveToFirst();
        for (String key : c.getColumnNames()) {
            tc.vars.put(key, c.getString(c.getColumnIndex(key)));
        }
        return tc;
    }

    public List<TCObject> getSessionsBySearch(String searchString) {
        List<TCObject> sessions = new ArrayList<>();
        Cursor c = getReadableDatabase().rawQuery("SELECT * FROM sessions WHERE name LIKE '%" + searchString + "%'" + " ORDER BY " + KEY_SESSION_STARTDATE, (String[]) null);
        if (c.moveToFirst()) {
            do {
                TCObject tc = new TCObject();
                for (String key : c.getColumnNames()) {
                    tc.vars.put(key, c.getString(c.getColumnIndex(key)));
                }
                sessions.add(tc);
            } while (c.moveToNext());
        }
        return sessions;
    }

    public List<TCObject> getAllExhibitors() {
        List<TCObject> exhibitors = new ArrayList<>();
        Cursor c = getReadableDatabase().rawQuery("SELECT * FROM exhibitors ORDER BY name", (String[]) null);
        if (c.moveToFirst()) {
            do {
                TCObject tc = new TCObject();
                for (String key : c.getColumnNames()) {
                    tc.vars.put(key, c.getString(c.getColumnIndex(key)));
                }
                exhibitors.add(tc);
            } while (c.moveToNext());
        }
        return exhibitors;
    }

    public List<TCObject> getExhibitorsBySearch(String searchString) {
        List<TCObject> exhibitors = new ArrayList<>();
        Cursor c = getReadableDatabase().rawQuery("SELECT * FROM exhibitors WHERE name LIKE '%" + searchString + "%'" + " ORDER BY " + KEY_NAME, (String[]) null);
        if (c.moveToFirst()) {
            do {
                TCObject tc = new TCObject();
                for (String key : c.getColumnNames()) {
                    tc.vars.put(key, c.getString(c.getColumnIndex(key)));
                }
                exhibitors.add(tc);
            } while (c.moveToNext());
        }
        return exhibitors;
    }

    public void closeDB() {
        SQLiteDatabase db = getReadableDatabase();
        if (db != null && db.isOpen()) {
            db.close();
        }
    }
}
