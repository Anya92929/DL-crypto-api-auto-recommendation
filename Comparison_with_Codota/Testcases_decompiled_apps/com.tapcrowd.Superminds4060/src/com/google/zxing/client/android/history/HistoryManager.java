package com.google.zxing.client.android.history;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;
import android.util.Log;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.Intents;
import com.google.zxing.client.android.PreferencesActivity;
import com.google.zxing.client.android.result.ResultHandler;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class HistoryManager {
    private static final String[] COLUMNS = {"text", "display", "format", "timestamp", "details"};
    private static final String[] COUNT_COLUMN = {"COUNT(1)"};
    private static final DateFormat EXPORT_DATE_TIME_FORMAT = DateFormat.getDateTimeInstance(2, 2);
    private static final String[] ID_COL_PROJECTION = {DBFavorites.KEY_EVENT_ID};
    private static final String[] ID_DETAIL_COL_PROJECTION = {DBFavorites.KEY_EVENT_ID, "details"};
    private static final int MAX_ITEMS = 2000;
    private static final String TAG = HistoryManager.class.getSimpleName();
    private final Activity activity;

    public HistoryManager(Activity activity2) {
        this.activity = activity2;
    }

    public boolean hasHistoryItems() {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = new DBHelper(this.activity).getReadableDatabase();
            cursor = db.query("history", COUNT_COLUMN, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            cursor.moveToFirst();
            return cursor.getInt(0) > 0;
        } finally {
            close(cursor, db);
        }
    }

    public List<HistoryItem> buildHistoryItems() {
        SQLiteOpenHelper helper = new DBHelper(this.activity);
        List<HistoryItem> items = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = helper.getReadableDatabase();
            cursor = db.query("history", COLUMNS, (String) null, (String[]) null, (String) null, (String) null, "timestamp DESC");
            while (cursor.moveToNext()) {
                String text = cursor.getString(0);
                String display = cursor.getString(1);
                String format = cursor.getString(2);
                long timestamp = cursor.getLong(3);
                items.add(new HistoryItem(new Result(text, (byte[]) null, (ResultPoint[]) null, BarcodeFormat.valueOf(format), timestamp), display, cursor.getString(4)));
            }
            return items;
        } finally {
            close(cursor, db);
        }
    }

    public HistoryItem buildHistoryItem(int number) {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = new DBHelper(this.activity).getReadableDatabase();
            cursor = db.query("history", COLUMNS, (String) null, (String[]) null, (String) null, (String) null, "timestamp DESC");
            cursor.move(number + 1);
            String text = cursor.getString(0);
            String display = cursor.getString(1);
            String format = cursor.getString(2);
            long timestamp = cursor.getLong(3);
            return new HistoryItem(new Result(text, (byte[]) null, (ResultPoint[]) null, BarcodeFormat.valueOf(format), timestamp), display, cursor.getString(4));
        } finally {
            close(cursor, db);
        }
    }

    public void deleteHistoryItem(int number) {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = new DBHelper(this.activity).getWritableDatabase();
            cursor = db.query("history", ID_COL_PROJECTION, (String) null, (String[]) null, (String) null, (String) null, "timestamp DESC");
            cursor.move(number + 1);
            db.delete("history", "id=" + cursor.getString(0), (String[]) null);
        } finally {
            close(cursor, db);
        }
    }

    public void addHistoryItem(Result result, ResultHandler handler) {
        if (this.activity.getIntent().getBooleanExtra(Intents.Scan.SAVE_HISTORY, true) && !handler.areContentsSecure()) {
            if (!PreferenceManager.getDefaultSharedPreferences(this.activity).getBoolean(PreferencesActivity.KEY_REMEMBER_DUPLICATES, false)) {
                deletePrevious(result.getText());
            }
            ContentValues values = new ContentValues();
            values.put("text", result.getText());
            values.put("format", result.getBarcodeFormat().toString());
            values.put("display", handler.getDisplayContents().toString());
            values.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            SQLiteDatabase db = null;
            try {
                db = new DBHelper(this.activity).getWritableDatabase();
                db.insert("history", "timestamp", values);
            } finally {
                close((Cursor) null, db);
            }
        }
    }

    public void addHistoryItemDetails(String itemID, String itemDetails) {
        String newDetails;
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = new DBHelper(this.activity).getWritableDatabase();
            cursor = db.query("history", ID_DETAIL_COL_PROJECTION, "text=?", new String[]{itemID}, (String) null, (String) null, "timestamp DESC", "1");
            String oldID = null;
            String oldDetails = null;
            if (cursor.moveToNext()) {
                oldID = cursor.getString(0);
                oldDetails = cursor.getString(1);
            }
            if (oldID != null) {
                if (oldDetails == null) {
                    newDetails = itemDetails;
                } else if (oldDetails.contains(itemDetails)) {
                    newDetails = null;
                } else {
                    newDetails = String.valueOf(oldDetails) + " : " + itemDetails;
                }
                if (newDetails != null) {
                    ContentValues values = new ContentValues();
                    values.put("details", newDetails);
                    db.update("history", values, "id=?", new String[]{oldID});
                }
            }
        } finally {
            close(cursor, db);
        }
    }

    private void deletePrevious(String text) {
        SQLiteDatabase db = null;
        try {
            db = new DBHelper(this.activity).getWritableDatabase();
            db.delete("history", "text=?", new String[]{text});
        } finally {
            close((Cursor) null, db);
        }
    }

    public void trimHistory() {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = new DBHelper(this.activity).getWritableDatabase();
            cursor = db.query("history", ID_COL_PROJECTION, (String) null, (String[]) null, (String) null, (String) null, "timestamp DESC");
            cursor.move(2000);
            while (cursor.moveToNext()) {
                String id = cursor.getString(0);
                Log.i(TAG, "Deleting scan history ID " + id);
                db.delete("history", "id=" + id, (String[]) null);
            }
        } catch (SQLiteException sqle) {
            Log.w(TAG, sqle);
        } finally {
            close(cursor, db);
        }
    }

    /* access modifiers changed from: package-private */
    public CharSequence buildHistory() {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = new DBHelper(this.activity).getWritableDatabase();
            cursor = db.query("history", COLUMNS, (String) null, (String[]) null, (String) null, (String) null, "timestamp DESC");
            StringBuilder historyText = new StringBuilder(LocationStatusCodes.GEOFENCE_NOT_AVAILABLE);
            while (cursor.moveToNext()) {
                historyText.append('\"').append(massageHistoryField(cursor.getString(0))).append("\",");
                historyText.append('\"').append(massageHistoryField(cursor.getString(1))).append("\",");
                historyText.append('\"').append(massageHistoryField(cursor.getString(2))).append("\",");
                historyText.append('\"').append(massageHistoryField(cursor.getString(3))).append("\",");
                historyText.append('\"').append(massageHistoryField(EXPORT_DATE_TIME_FORMAT.format(new Date(cursor.getLong(3))))).append("\",");
                historyText.append('\"').append(massageHistoryField(cursor.getString(4))).append("\"\r\n");
            }
            return historyText;
        } finally {
            close(cursor, db);
        }
    }

    /* access modifiers changed from: package-private */
    public void clearHistory() {
        SQLiteDatabase db = null;
        try {
            db = new DBHelper(this.activity).getWritableDatabase();
            db.delete("history", (String) null, (String[]) null);
        } finally {
            close((Cursor) null, db);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00af A[SYNTHETIC, Splitter:B:24:0x00af] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.net.Uri saveHistory(java.lang.String r10) {
        /*
            r6 = 0
            java.io.File r0 = new java.io.File
            java.io.File r7 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r8 = "BarcodeScanner"
            r0.<init>(r7, r8)
            java.io.File r2 = new java.io.File
            java.lang.String r7 = "History"
            r2.<init>(r0, r7)
            boolean r7 = r2.exists()
            if (r7 != 0) goto L_0x0034
            boolean r7 = r2.mkdirs()
            if (r7 != 0) goto L_0x0034
            java.lang.String r7 = TAG
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Couldn't make dir "
            r8.<init>(r9)
            java.lang.StringBuilder r8 = r8.append(r2)
            java.lang.String r8 = r8.toString()
            android.util.Log.w(r7, r8)
        L_0x0033:
            return r6
        L_0x0034:
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "history-"
            r7.<init>(r8)
            long r8 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r8 = ".csv"
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            r1.<init>(r2, r7)
            r4 = 0
            java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x0085 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0085 }
            r7.<init>(r1)     // Catch:{ IOException -> 0x0085 }
            java.lang.String r8 = "UTF-8"
            java.nio.charset.Charset r8 = java.nio.charset.Charset.forName(r8)     // Catch:{ IOException -> 0x0085 }
            r5.<init>(r7, r8)     // Catch:{ IOException -> 0x0085 }
            r5.write(r10)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            java.lang.String r8 = "file://"
            r7.<init>(r8)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            java.lang.String r8 = r1.getAbsolutePath()     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            android.net.Uri r6 = android.net.Uri.parse(r7)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            if (r5 == 0) goto L_0x0033
            r5.close()     // Catch:{ IOException -> 0x0083 }
            goto L_0x0033
        L_0x0083:
            r7 = move-exception
            goto L_0x0033
        L_0x0085:
            r3 = move-exception
        L_0x0086:
            java.lang.String r7 = TAG     // Catch:{ all -> 0x00ac }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ac }
            java.lang.String r9 = "Couldn't access file "
            r8.<init>(r9)     // Catch:{ all -> 0x00ac }
            java.lang.StringBuilder r8 = r8.append(r1)     // Catch:{ all -> 0x00ac }
            java.lang.String r9 = " due to "
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x00ac }
            java.lang.StringBuilder r8 = r8.append(r3)     // Catch:{ all -> 0x00ac }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00ac }
            android.util.Log.w(r7, r8)     // Catch:{ all -> 0x00ac }
            if (r4 == 0) goto L_0x0033
            r4.close()     // Catch:{ IOException -> 0x00aa }
            goto L_0x0033
        L_0x00aa:
            r7 = move-exception
            goto L_0x0033
        L_0x00ac:
            r6 = move-exception
        L_0x00ad:
            if (r4 == 0) goto L_0x00b2
            r4.close()     // Catch:{ IOException -> 0x00b3 }
        L_0x00b2:
            throw r6
        L_0x00b3:
            r7 = move-exception
            goto L_0x00b2
        L_0x00b5:
            r6 = move-exception
            r4 = r5
            goto L_0x00ad
        L_0x00b8:
            r3 = move-exception
            r4 = r5
            goto L_0x0086
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.android.history.HistoryManager.saveHistory(java.lang.String):android.net.Uri");
    }

    private static String massageHistoryField(String value) {
        return value == null ? "" : value.replace("\"", "\"\"");
    }

    private static void close(Cursor cursor, SQLiteDatabase database) {
        if (cursor != null) {
            cursor.close();
        }
        if (database != null) {
            database.close();
        }
    }
}
