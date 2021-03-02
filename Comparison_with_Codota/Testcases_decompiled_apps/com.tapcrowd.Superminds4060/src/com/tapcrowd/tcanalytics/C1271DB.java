package com.tapcrowd.tcanalytics;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tapcrowd.tcanalytics.DB */
public class C1271DB {
    private static String DB_NAME = "TCAnalytics.sql";
    private static SQLiteDatabase myDataBase;
    private static Map<String, String[]> tables = new HashMap();

    public static void createTables() {
        tables.put("request", new String[]{"function", "parameters", "synced", "sessionid"});
        tables.put("geofences", new String[]{"geofencetypeid", "ibeacon_uuid", "ibeacon_major", "ibeacon_radius", "ibeacon_minor", "lat", "lon", "radius", "timestamp", "state"});
        startTrans();
        for (String table : tables.keySet()) {
            myDataBase.execSQL(m2213cq(table, tables.get(table)));
        }
        closeTrans();
        for (String table2 : tables.keySet()) {
            updateTable(table2, tables.get(table2));
        }
    }

    private static void updateTable(String table, String[] fields) {
        List<String> names = new ArrayList<>();
        Cursor c = myDataBase.rawQuery(String.format("PRAGMA table_info(%1$s)", new Object[]{table}), (String[]) null);
        if (c.moveToFirst()) {
            int index = c.getColumnIndex(DBFavorites.KEY_NAME);
            do {
                names.add(c.getString(index));
            } while (c.moveToNext());
        }
        for (String field : fields) {
            boolean hasField = false;
            for (String name : names) {
                if (name.equals(field)) {
                    hasField = true;
                }
            }
            if (!hasField) {
                startTrans();
                myDataBase.execSQL(String.format("ALTER TABLE %1$s ADD %2$s TEXT", new Object[]{table, field}));
                closeTrans();
            }
        }
    }

    /* renamed from: cq */
    private static String m2213cq(String table, String[] fields) {
        String qry = "CREATE TABLE if not exists " + table + " (id VARCHAR PRIMARY KEY";
        for (int i = 0; i < fields.length; i++) {
            qry = String.valueOf(qry) + ", " + fields[i] + " VARCHAR";
        }
        return String.valueOf(qry) + ");";
    }

    public static void openDataBase(Context a) throws SQLException {
        if (myDataBase == null) {
            myDataBase = SQLiteDatabase.openOrCreateDatabase(String.valueOf(a.getFilesDir().getPath()) + "/" + DB_NAME, (SQLiteDatabase.CursorFactory) null);
        }
        if (!myDataBase.isOpen()) {
            boolean locked = true;
            for (int i = 0; i < 20 && locked; i++) {
                if (myDataBase.isDbLockedByCurrentThread() || myDataBase.isDbLockedByOtherThreads()) {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    locked = false;
                }
                if (i < 20) {
                    String myPath = String.valueOf(a.getFilesDir().getPath()) + "/" + DB_NAME;
                    if (!myDataBase.isOpen()) {
                        myDataBase = SQLiteDatabase.openOrCreateDatabase(myPath, (SQLiteDatabase.CursorFactory) null);
                    }
                }
            }
        }
        if (myDataBase.isOpen()) {
            createTables();
        }
    }

    public static void startTrans() {
        try {
            if (myDataBase.inTransaction()) {
                myDataBase.setTransactionSuccessful();
                myDataBase.endTransaction();
            }
            myDataBase.beginTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeTrans() {
        try {
            if (myDataBase.inTransaction()) {
                myDataBase.setTransactionSuccessful();
                myDataBase.endTransaction();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Cursor getQuery(String qry) {
        return myDataBase.rawQuery(qry, (String[]) null);
    }

    public static void write(String table, ContentValues cv) {
        myDataBase.replace(table, (String) null, cv);
    }

    public static void write(String function, String parameters, String sessionid) {
        ContentValues cv = new ContentValues();
        cv.put("function", function);
        cv.put("parameters", parameters);
        cv.put("sessionid", sessionid);
        myDataBase.replace("request", (String) null, cv);
    }

    public static int update(String table, ContentValues cv, String where) {
        return myDataBase.update(table, cv, where, (String[]) null);
    }

    public static void remove(String table, String col, String value) {
        myDataBase.delete(table, String.valueOf(col) + " == " + value, (String[]) null);
    }

    public static int remove(String table, String where, String[] args) {
        return myDataBase.delete(table, where, args);
    }

    public static String getValue(String query, String key) {
        Cursor cursor = getQuery(query);
        if (cursor.moveToFirst()) {
            return cursor.getString(cursor.getColumnIndex(key));
        }
        return null;
    }

    public static int getSizeForQuery(String query) {
        try {
            return Integer.parseInt(DatabaseUtils.stringForQuery(myDataBase, query, (String[]) null));
        } catch (Exception e) {
            return 0;
        }
    }

    public static void setTaptargetBundleId(Context context, String taptargetbundleid) {
        SharedPreferences.Editor edit = context.getSharedPreferences("TAPTARGET", 0).edit();
        edit.putString("BUNDLE_ID", taptargetbundleid);
        edit.commit();
    }

    public static String getTapTargetBundleid(Context context) {
        return context.getSharedPreferences("TAPTARGET", 0).getString("BUNDLE_ID", context.getPackageName());
    }
}
