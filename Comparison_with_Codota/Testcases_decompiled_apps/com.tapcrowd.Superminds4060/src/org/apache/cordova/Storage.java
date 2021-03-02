package org.apache.cordova;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import java.io.File;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Storage extends CordovaPlugin {
    private static final String ALTER = "alter";
    private static final String CREATE = "create";
    private static final String DROP = "drop";
    private static final String TRUNCATE = "truncate";
    String dbName = null;
    SQLiteDatabase myDb = null;
    String path = null;

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        String[] s;
        if (action.equals("openDatabase")) {
            openDatabase(args.getString(0), args.getString(1), args.getString(2), args.getLong(3));
        } else if (!action.equals("executeSql")) {
            return false;
        } else {
            if (args.isNull(1)) {
                s = new String[0];
            } else {
                JSONArray a = args.getJSONArray(1);
                int len = a.length();
                s = new String[len];
                for (int i = 0; i < len; i++) {
                    s[i] = a.getString(i);
                }
            }
            executeSql(args.getString(0), s, args.getString(2));
        }
        callbackContext.success();
        return true;
    }

    public void onDestroy() {
        if (this.myDb != null) {
            this.myDb.close();
            this.myDb = null;
        }
    }

    public void onReset() {
        onDestroy();
    }

    public void openDatabase(String db, String version, String display_name, long size) {
        if (this.myDb != null) {
            this.myDb.close();
        }
        if (this.path == null) {
            this.path = this.cordova.getActivity().getApplicationContext().getDir("database", 0).getPath();
        }
        this.dbName = this.path + File.separator + db + ".db";
        File oldDbFile = new File(this.path + File.pathSeparator + db + ".db");
        if (oldDbFile.exists()) {
            File dbPath = new File(this.path);
            File dbFile = new File(this.dbName);
            dbPath.mkdirs();
            oldDbFile.renameTo(dbFile);
        }
        this.myDb = SQLiteDatabase.openOrCreateDatabase(this.dbName, (SQLiteDatabase.CursorFactory) null);
    }

    public void executeSql(String query, String[] params, String tx_id) {
        try {
            if (isDDL(query)) {
                this.myDb.execSQL(query);
                this.webView.sendJavascript("cordova.require('cordova/plugin/android/storage').completeQuery('" + tx_id + "', '');");
                return;
            }
            Cursor myCursor = this.myDb.rawQuery(query, params);
            processResults(myCursor, tx_id);
            myCursor.close();
        } catch (SQLiteException ex) {
            ex.printStackTrace();
            System.out.println("Storage.executeSql(): Error=" + ex.getMessage());
            this.webView.sendJavascript("cordova.require('cordova/plugin/android/storage').failQuery('" + ex.getMessage() + "','" + tx_id + "');");
        }
    }

    private boolean isDDL(String query) {
        String cmd = query.toLowerCase();
        if (cmd.startsWith(DROP) || cmd.startsWith(CREATE) || cmd.startsWith(ALTER) || cmd.startsWith(TRUNCATE)) {
            return true;
        }
        return false;
    }

    public void processResults(Cursor cur, String tx_id) {
        String result = "[]";
        if (cur.moveToFirst()) {
            JSONArray fullresult = new JSONArray();
            int colCount = cur.getColumnCount();
            do {
                JSONObject row = new JSONObject();
                int i = 0;
                while (i < colCount) {
                    try {
                        row.put(cur.getColumnName(i), cur.getString(i));
                        i++;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                fullresult.put(row);
            } while (cur.moveToNext());
            result = fullresult.toString();
        }
        this.webView.sendJavascript("cordova.require('cordova/plugin/android/storage').completeQuery('" + tx_id + "', " + result + ");");
    }
}
