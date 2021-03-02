package com.tapcrowd.app.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.Splash;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.cordova.Globalization;

public class ImageDB {
    public static String DB_NAME = ("images" + App.f2123id + ".sql");
    private static SQLiteDatabase myDataBase;
    private static Map<String, String[]> tables = new HashMap();

    public static boolean isNull() {
        if (myDataBase != null && myDataBase.isOpen()) {
            return false;
        }
        return true;
    }

    public static SQLiteDatabase getDatabase() {
        return myDataBase;
    }

    public static void dropDb() {
        startTrans();
        for (String key : tables.keySet()) {
            try {
                if (!key.equals("personal")) {
                    myDataBase.delete(key, (String) null, (String[]) null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        closeTrans();
    }

    public static void createTables() {
        tables.put("images", new String[]{PlusShare.KEY_CALL_TO_ACTION_URL});
        tables.put("lkimages", new String[]{Globalization.TYPE, "typeid"});
        if (isNull()) {
            openDataBase();
        }
        startTrans();
        myDataBase = getDatabase();
        for (String table : tables.keySet()) {
            myDataBase.execSQL(m2212cq(table, tables.get(table)));
        }
        closeTrans();
    }

    /* renamed from: cq */
    private static String m2212cq(String table, String[] fields) {
        String qry = "CREATE TABLE if not exists " + table + " (id VARCHAR PRIMARY KEY";
        for (int i = 0; i < fields.length; i++) {
            qry = String.valueOf(qry) + ", " + fields[i] + " VARCHAR";
        }
        return String.valueOf(qry) + ");";
    }

    public static void openDataBase() {
        openDataBase((Context) null);
    }

    public static void openDataBase(Context ctx) throws SQLException {
        final Context context;
        if (ctx == null) {
            context = App.act;
        } else {
            context = ctx;
        }
        if (myDataBase == null) {
            myDataBase = SQLiteDatabase.openOrCreateDatabase("/data/data/" + context.getPackageName() + "/" + DB_NAME, (SQLiteDatabase.CursorFactory) null);
            return;
        }
        boolean locked = true;
        for (int i = 0; i < 20 && locked; i++) {
            if (myDataBase.isDbLockedByCurrentThread()) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                locked = false;
            }
            if (i < 20) {
                String myPath = "/data/data/" + context.getPackageName() + "/" + DB_NAME;
                if (!myDataBase.isOpen()) {
                    myDataBase = SQLiteDatabase.openOrCreateDatabase(myPath, (SQLiteDatabase.CursorFactory) null);
                }
            } else {
                AlertDialog.Builder alertbox = new AlertDialog.Builder(App.act);
                alertbox.setMessage(context.getString(C0846R.string.somethingwrong));
                alertbox.setPositiveButton(context.getString(C0846R.string.tryagain), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        if (context instanceof Activity) {
                            ((Activity) context).finish();
                        }
                        context.startActivity(new Intent(context, Splash.class));
                    }
                });
                alertbox.setNegativeButton(context.getString(C0846R.string.close), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        if (context instanceof Activity) {
                            ((Activity) context).finish();
                        }
                    }
                });
                alertbox.show();
            }
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

    public static void write(String table, String col, String value) {
        ContentValues cv = new ContentValues();
        cv.put(col, value);
        myDataBase.replace(table, (String) null, cv);
    }

    public static void write(String table, ContentValues cv) {
        myDataBase.replace(table, (String) null, cv);
    }

    public static void add(String table, ContentValues cv) {
        myDataBase.insert(table, (String) null, cv);
    }

    public static void update(String table, ContentValues cv, String where) {
        myDataBase.update(table, cv, where, (String[]) null);
    }

    public static void remove(String table, String col, String value) {
        if (col == null && value == null) {
            myDataBase.delete(table, (String) null, (String[]) null);
        } else {
            myDataBase.delete(table, String.valueOf(col) + " == '" + value + "'", (String[]) null);
        }
    }

    public static TCObject getFirstObject(String table) {
        TCObject tco = new TCObject();
        try {
            Cursor c = myDataBase.rawQuery("SELECT * FROM " + table + " LIMIT 1;", (String[]) null);
            if (c != null && c.moveToFirst()) {
                for (String key : c.getColumnNames()) {
                    tco.vars.put(key, c.getString(c.getColumnIndex(key)));
                }
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tco;
    }

    public static TCObject getFirstObject(String table, String orderby) {
        TCObject tco = new TCObject();
        try {
            Cursor c = myDataBase.rawQuery("SELECT * FROM " + table + " ORDER BY " + orderby + " LIMIT 1;", (String[]) null);
            if (c != null && c.moveToFirst()) {
                for (String key : c.getColumnNames()) {
                    tco.vars.put(key, c.getString(c.getColumnIndex(key)));
                }
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tco;
    }

    public static TCObject getFirstObject(String table, String where, String value) {
        if (myDataBase == null) {
            openDataBase();
        }
        TCObject tco = new TCObject();
        try {
            Cursor c = myDataBase.rawQuery("SELECT * FROM " + table + " WHERE " + where + "='" + value + "' LIMIT 1;", (String[]) null);
            if (c != null && c.moveToFirst()) {
                for (String key : c.getColumnNames()) {
                    tco.vars.put(key, c.getString(c.getColumnIndex(key)));
                }
            }
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tco;
    }

    public static String newImageName() {
        return Converter.md5(Long.valueOf(System.currentTimeMillis() / 1000).toString()).substring(0, 12);
    }

    public static void updateImage(String imagename, String type, String typeid) {
        ContentValues cv = new ContentValues();
        String imageid = null;
        Cursor c = myDataBase.rawQuery("SELECT * FROM lkimages WHERE " + ("type = '" + type + "' and typeid") + " ='" + typeid + "' LIMIT 1;", (String[]) null);
        if (c != null && c.moveToFirst()) {
            imageid = c.getString(c.getColumnIndex(DBFavorites.KEY_EVENT_ID));
        }
        c.close();
        cv.put(DBFavorites.KEY_EVENT_ID, imageid);
        cv.put(PlusShare.KEY_CALL_TO_ACTION_URL, String.valueOf(getPath().toString()) + "/" + imagename);
        update("images", cv, "id='" + imageid + "'");
        ContentValues cv2 = new ContentValues();
        cv2.put(Globalization.TYPE, type);
        cv2.put("typeid", typeid);
        cv2.put(DBFavorites.KEY_EVENT_ID, imageid);
        update("lkimages", cv2, "id='" + imageid + "'");
    }

    public static void addImage(String imagename, String type, String typeid) {
        String imageid;
        ContentValues cv = new ContentValues();
        try {
            imageid = String.valueOf(Integer.valueOf(getFirstObject("images", "id +0 DESC").get(DBFavorites.KEY_EVENT_ID)).intValue() + 1);
        } catch (Exception e) {
            imageid = "1";
        }
        cv.put(DBFavorites.KEY_EVENT_ID, imageid);
        cv.put(PlusShare.KEY_CALL_TO_ACTION_URL, String.valueOf(getPath().toString()) + "/" + imagename);
        write("images", cv);
        ContentValues cv2 = new ContentValues();
        cv2.put(Globalization.TYPE, type);
        cv2.put("typeid", typeid);
        cv2.put(DBFavorites.KEY_EVENT_ID, imageid);
        write("lkimages", cv2);
    }

    public static File getPath() {
        return new File(Environment.getExternalStorageDirectory() + "/TapCrowd/", "Images");
    }

    public static void removeImage(String imagename) {
        if (myDataBase == null) {
            openDataBase();
        }
        myDataBase = getDatabase();
        try {
            Cursor cImage = myDataBase.rawQuery("SELECT * FROM images WHERE url ='" + getPath().toString() + "/" + imagename + "';", (String[]) null);
            if (cImage != null && cImage.moveToFirst()) {
                remove("lkimages", DBFavorites.KEY_EVENT_ID, cImage.getString(cImage.getColumnIndex(DBFavorites.KEY_EVENT_ID)));
                remove("images", PlusShare.KEY_CALL_TO_ACTION_URL, String.valueOf(getPath().toString()) + "/" + imagename);
            }
            cImage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeImage(String type, String typeid) {
        String where = "type = '" + type + "' and typeid";
        if (myDataBase == null) {
            openDataBase();
        }
        myDataBase = getDatabase();
        try {
            Cursor cLink = myDataBase.rawQuery("SELECT * FROM lkimages WHERE " + where + " ='" + typeid + "';", (String[]) null);
            if (cLink == null || !cLink.moveToFirst()) {
                cLink.close();
            }
            do {
                Cursor cImage = myDataBase.rawQuery("SELECT * FROM images WHERE id ='" + cLink.getString(cLink.getColumnIndex(DBFavorites.KEY_EVENT_ID)) + "';", (String[]) null);
                if (cImage != null && cImage.moveToFirst()) {
                    remove("lkimages", DBFavorites.KEY_EVENT_ID, cImage.getString(cImage.getColumnIndex(DBFavorites.KEY_EVENT_ID)));
                    remove("images", PlusShare.KEY_CALL_TO_ACTION_URL, cImage.getString(cImage.getColumnIndex(PlusShare.KEY_CALL_TO_ACTION_URL)));
                }
                cImage.close();
            } while (cLink.moveToNext());
            cLink.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<File> getImage(String type, String typeid) {
        List<File> imageList = new ArrayList<>();
        String where = "type = '" + type + "' and typeid";
        if (myDataBase == null) {
            openDataBase();
        }
        myDataBase = getDatabase();
        try {
            Cursor cLink = myDataBase.rawQuery("SELECT * FROM lkimages WHERE " + where + " ='" + typeid + "';", (String[]) null);
            if (cLink == null || !cLink.moveToFirst()) {
                cLink.close();
                return imageList;
            }
            do {
                Cursor cImage = myDataBase.rawQuery("SELECT * FROM images WHERE id ='" + cLink.getString(cLink.getColumnIndex(DBFavorites.KEY_EVENT_ID)) + "';", (String[]) null);
                if (cImage != null && cImage.moveToFirst()) {
                    imageList.add(new File(cImage.getString(cImage.getColumnIndex(PlusShare.KEY_CALL_TO_ACTION_URL))));
                }
                cImage.close();
            } while (cLink.moveToNext());
            cLink.close();
            return imageList;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> getImageUrls(String type, String typeid) {
        List<String> imageList = new ArrayList<>();
        String where = "type = '" + type + "' and typeid";
        if (myDataBase == null) {
            openDataBase();
        }
        myDataBase = getDatabase();
        try {
            Cursor cLink = myDataBase.rawQuery("SELECT * FROM lkimages WHERE " + where + " ='" + typeid + "';", (String[]) null);
            if (cLink == null || !cLink.moveToFirst()) {
                cLink.close();
                return imageList;
            }
            do {
                Cursor cImage = myDataBase.rawQuery("SELECT * FROM images WHERE id ='" + cLink.getString(cLink.getColumnIndex(DBFavorites.KEY_EVENT_ID)) + "';", (String[]) null);
                if (cImage != null && cImage.moveToFirst()) {
                    imageList.add(cImage.getString(cImage.getColumnIndex(PlusShare.KEY_CALL_TO_ACTION_URL)));
                }
                cImage.close();
            } while (cLink.moveToNext());
            cLink.close();
            return imageList;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
