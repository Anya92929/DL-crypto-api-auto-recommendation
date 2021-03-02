package com.tapcrowd.app.utils;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.gcm.GCMConstants;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.Splash;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.swipe2mobile.Swipe2MobileFragment;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.cordova.Globalization;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.scribe.model.OAuthConstants;
import twitter4j.conf.PropertyConfiguration;

/* renamed from: com.tapcrowd.app.utils.DB */
public class C1199DB {
    public static String DB_NAME = ("db" + App.f2123id + ".sql");
    private static SQLiteDatabase myDataBase;
    static long start;
    private static Map<String, String[]> tables = new HashMap();

    /* renamed from: com.tapcrowd.app.utils.DB$Response */
    public enum Response {
        Ok,
        Login,
        Pincode
    }

    public static SQLiteDatabase getDatabase() {
        return myDataBase;
    }

    public static boolean isNull() {
        if (myDataBase != null && myDataBase.isOpen()) {
            return false;
        }
        return true;
    }

    public static void createTables() {
        tables.put("ad", new String[]{DBFavorites.KEY_NAME, "image", "order_value", Globalization.TIME, "website", "paths"});
        tables.put(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, new String[]{"apptypeid", "info", "timestamp", DBFavorites.KEY_NAME, "apptype", "lat", "lon", "visibleintapcrowd", "website", "category", "address", "email", "defaultlanguage", "telephone", "subdomain", "channel", "aboutbuttonkey", "aboutbuttonurl", "launcherview", "bundle", "token"});
        tables.put("apps", new String[]{"apptypeid", "info", "timestamp", DBFavorites.KEY_NAME, "apptype", "lat", "lon", "visibleintapcrowd", "website", "category", "address", "email", "defaultlanguage", "telephone", "subdomain"});
        tables.put("appearance", new String[]{"value", "controlid", "controlname", "image_name", Globalization.TYPE});
        tables.put("artists", new String[]{DBFavorites.KEY_NAME, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, "imageurl", "order_value", Globalization.NUMBER, "imagethumb"});
        tables.put(LinkedObjects.TABLE_ATT, new String[]{DBFavorites.KEY_NAME, "firstname", "company", "function", "email", "linkedin", "phonenr", PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, "order_value", "imageurl", "country", "allowmessaging", "facebook", "twitter"});
        tables.put("basket", new String[]{"externalvenueid", "send_order_to_api"});
        tables.put(LinkedObjects.TABLE_CAT, new String[]{"cataloggroupid", "pdf", "order_value", "price", "externalid", PlusShare.KEY_CALL_TO_ACTION_URL, "urltitle", PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, DBFavorites.KEY_NAME, "sourceid", "image320", "imageurl", Globalization.TYPE, Globalization.DATE, "imagethumb"});
        tables.put("cataloggroups", new String[]{"image", "order_value", DBFavorites.KEY_NAME});
        tables.put("confbag", new String[]{"itemtable", "tableid", "documentlink"});
        tables.put("coupons", new String[]{PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "content", "image", "order_value"});
        tables.put("events", new String[]{"phonenr", "parentid", "eventlogobig", "website", "eventtypename", "ticketlink", "eventlogo", "eventtypeid", "timestamp", "datefrom", "order_value", "email", PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, DBFavorites.KEY_NAME, "imageurl", "dateto", "thumblogo"});
        tables.put("exhibitorcategories", new String[]{DBFavorites.KEY_NAME});
        tables.put(DBFavorites.TABLE_EXHIBITORS, new String[]{"image_large", "mapid", "tel", "y1", "y2", "web", OAuthConstants.CODE, "x2", PropertyConfiguration.PASSWORD, "booth", "exhibitorcategoryid", "x1", "username", "address", "email", PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, DBFavorites.KEY_NAME, "shortname", "imageurl", "order_value"});
        tables.put("exhicats", new String[]{"categoryid", "exhibitorid"});
        tables.put("favorites", new String[]{"imageid", "sessionid", "exhibitorid", "attendeeid"});
        tables.put("geofences", new String[]{"lat", "lon", "radius", "inside"});
        tables.put("groups", new String[]{DBFavorites.KEY_NAME, "parentid", "imageurl", "displaytype", "tree", "order_value"});
        tables.put("groupitems", new String[]{"groupid", "itemtable", "itemid", "displaytype"});
        tables.put("image", new String[]{PlusShare.KEY_CALL_TO_ACTION_URL, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, "tableName", "tableId"});
        tables.put("launchers", new String[]{C1216LO.icon, DBFavorites.KEY_MODULE, "tag", "moduletypeid", PlusShare.KEY_CALL_TO_ACTION_URL, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "order_value", "active", "displaytype", "groupid", "extragetparams", "mobileurl"});
        tables.put("launcher", new String[]{C1216LO.icon, DBFavorites.KEY_MODULE});
        tables.put("languages", new String[]{"language"});
        tables.put("linkedobject", new String[]{"originaltable", "originitemid", "destinationtable", "destinationitemid"});
        tables.put("map", new String[]{"timestamp", "image2", "image1", "imageurl", "image4", "image3", "width", "height", "parentId", "x", "y", PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE});
        tables.put("maps", new String[]{"parentType", "parentId", PlusShare.KEY_CALL_TO_ACTION_URL});
        tables.put("mapv2", new String[]{"timestamp", "width", "height", "maptype", "imageurl", "zoomlevel", "mapid"});
        tables.put("indoor_routing_points", new String[]{"mapid", "x", "y"});
        tables.put("indoor_routing_paths", new String[]{"mapid", "map_routingpointid_start", "map_routingpointid_end"});
        tables.put("messages", new String[]{"senderuserid", "timestampcreated", "userid", "recipientuserid", PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, "senderattendeeid", "payload", "meetingpoiid", "meetingpoiname", "meetingconfirmed", "meetingdatetime", "read", "deleted"});
        tables.put("metadata", new String[]{"value", "table_value", "identifier", "key"});
        tables.put("metavalues", new String[]{"parentType", "parentId", Globalization.TYPE, DBFavorites.KEY_NAME, "value", "sortorder"});
        tables.put("news", new String[]{PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, DBFavorites.KEY_NAME, "sourceid", "image", "imageurl", "datum", "txt", "htmltext", PlusShare.KEY_CALL_TO_ACTION_URL, "image_thumbped"});
        tables.put("note", new String[]{Globalization.TYPE, "typeid", "text", PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "moduletypeid"});
        tables.put("notes", new String[]{"launcherid"});
        tables.put("personal", new String[]{"email", "table_value", "tableid", "extra", Globalization.TYPE, "deleted", "synced"});
        tables.put("persprog", new String[]{"origin", "imageid", "sessionid", "exhibitorsid", "attendeeid", "speakerid", "catalogid"});
        tables.put("places", new String[]{"parentType", "parentId", "sortorder", "status", "lat", "lng", "addr", PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "info", "imageurl"});
        tables.put("poi", new String[]{DBFavorites.KEY_NAME, "addres", PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, "order_value"});
        tables.put("premium", new String[]{"tablename", "tableId", "extraline", "ispremium", "sortorder", PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE});
        tables.put("push", new String[]{"message", "read"});
        tables.put("sessiongroups", new String[]{DBFavorites.KEY_NAME, "order_value"});
        tables.put("securedmodules", new String[0]);
        tables.put("sessions", new String[]{DBFavorites.KEY_NAME, "order_value", PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, "starttime", "endtime", "speaker", "location", "sessiongroupid", "mapid", "xpos", "ypos", "imageurl", "allowAddToAgenda", PlusShare.KEY_CALL_TO_ACTION_URL, "twitter", Globalization.DATE, "conferencebag", "imagethumb", DBFavorites.KEY_SESSION_STARTDATE, "enddate", "parentid"});
        tables.put("schedules", new String[]{"caption", Globalization.DATE, "key", "sortorder"});
        tables.put("schedule", new String[]{Globalization.DATE, "key", "caption"});
        tables.put("social", new String[]{"twitter", "twithash", "attribute", "facebookappid", "RSS", "facebookid", "postorwall", "twitfrom", "photostreamurl", "twittersearchurl"});
        tables.put("socialshare", new String[]{"launcherid"});
        tables.put("speakers", new String[]{"sessionid", DBFavorites.KEY_NAME, "imagethumb", "imageurl", "company", "function", PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, "order_value"});
        tables.put("speaker_session", new String[]{"speakerid", "sessionid"});
        tables.put("sponsors", new String[]{"sponsorgroupid", DBFavorites.KEY_NAME, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, "image", "website", "order_value", "x", "y", "imagethumb", "mapid", "imageurl"});
        tables.put("sponsorgroups", new String[]{DBFavorites.KEY_NAME, "order_value"});
        tables.put("spotlightapps", new String[]{"apptypeid", DBFavorites.KEY_NAME, "info", "category", "app_icon", "homescreen", "subdomain"});
        tables.put("tags", new String[]{"tag", "color", "image", "sessionid", "sessiongroupid", "catalogitemid", "newsitemid", "exhibitorid", "sponsorid", "cataloggroupid", "artistid", "citycontentid", "active"});
        tables.put("tagsv2", new String[]{"itemtype", "itemid", "tag"});
        tables.put("venues", new String[]{"info", "timestamp", "order_value", "address", DBFavorites.KEY_NAME, "facebookurl", "travelinfo", "openinghours", "toururl", "lat", "telephone", "lon", "email", "fax", "website", "twitterurl", "image1", "image_thumb1", "image2", "image3", "image4", "image5", "active", "deleted", "vimeourl", "imageurl"});
        startTrans();
        for (String table : tables.keySet()) {
            myDataBase.execSQL(m2211cq(table, tables.get(table)));
        }
        closeTrans();
        for (String table2 : tables.keySet()) {
            updateTable(table2, tables.get(table2));
        }
        ImageDB.createTables();
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

    public static boolean jsonToDB(String json) {
        return jsonToDB(json, (String) null);
    }

    public static boolean jsonToDB(String json, String deleteWhere) {
        try {
            JSONObject jSONObject = new JSONObject(json);
            TCObject app = getFirstObject(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT);
            if (jSONObject.has("message") && jSONObject.getString("message").contains("NOT OK")) {
                return false;
            }
            if (jSONObject.has(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT) && app.has("timestamp")) {
                if (new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss").parse(jSONObject.getJSONArray(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT).getJSONObject(0).getString("dropdb")).getTime() / 1000 > Long.valueOf(app.get("timestamp")).longValue()) {
                    dropDb();
                    C1216LO.removeImages();
                }
            }
            if (jSONObject.has("timestamp") && jSONObject.getString("timestamp").equals(app.get("timestamp", ""))) {
                return true;
            }
            startTrans();
            for (String key : tables.keySet()) {
                try {
                    try {
                        if (key.equals(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT) && deleteWhere != null && deleteWhere.contains("appid")) {
                            myDataBase.delete(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, deleteWhere.replace("appid", DBFavorites.KEY_EVENT_ID), (String[]) null);
                        }
                        if (key.equals("events") && deleteWhere != null && deleteWhere.contains("eventid")) {
                            myDataBase.delete("events", deleteWhere.replace("eventid", DBFavorites.KEY_EVENT_ID), (String[]) null);
                        }
                        if (key.equals("venues") && deleteWhere != null && deleteWhere.contains("venueid")) {
                            myDataBase.delete("venues", deleteWhere.replace("venueid", DBFavorites.KEY_EVENT_ID), (String[]) null);
                        }
                        if (!key.equals("personal") && !key.equals("tags") && !key.equals("note") && !key.equals("favorites")) {
                            myDataBase.delete(key, deleteWhere, (String[]) null);
                        }
                    } catch (Exception delerr) {
                        delerr.printStackTrace();
                    }
                    if (jSONObject.has(key)) {
                        try {
                            JSONArray ja = jSONObject.getJSONArray(key);
                            int size = ja.length();
                            for (int i = 0; i < size; i++) {
                                try {
                                    JSONObject j = ja.getJSONObject(i);
                                    ContentValues iv = new ContentValues();
                                    if (j.has(DBFavorites.KEY_EVENT_ID)) {
                                        iv.put(DBFavorites.KEY_EVENT_ID, j.getString(DBFavorites.KEY_EVENT_ID));
                                    } else {
                                        iv.putNull(DBFavorites.KEY_EVENT_ID);
                                    }
                                    if (j.has("appid")) {
                                        iv.put("appid", j.getString("appid"));
                                    }
                                    if (j.has("eventid")) {
                                        iv.put("eventid", j.getString("eventid"));
                                    }
                                    if (j.has("venueid")) {
                                        iv.put("venueid", j.getString("venueid"));
                                    }
                                    String[] strArr = tables.get(key);
                                    int length = strArr.length;
                                    for (int i2 = 0; i2 < length; i2++) {
                                        String k = strArr[i2];
                                        if (!k.equals("table_value")) {
                                            if (k.equals("order_value")) {
                                                if (j.has("order")) {
                                                    iv.put("order_value", j.getString("order"));
                                                } else {
                                                    iv.put("order_value", "");
                                                }
                                            } else if (j.has(k)) {
                                                iv.put(k, j.getString(k));
                                            } else if (!iv.containsKey(k)) {
                                                iv.put(k, "");
                                            }
                                            if (j.has(k) && (k.equals("image_thumb1") || k.equals("imagethumb") || k.equals("thumblogo"))) {
                                                iv.put("imageurl", j.getString(k));
                                            }
                                        } else if (j.has("table")) {
                                            iv.put("table_value", j.getString("table"));
                                        } else {
                                            iv.put("table_value", "");
                                        }
                                    }
                                    if (key.equals("launcher")) {
                                        myDataBase.replaceOrThrow("launchers", (String) null, iv);
                                    } else {
                                        myDataBase.replaceOrThrow(key, (String) null, iv);
                                    }
                                } catch (Exception e) {
                                }
                            }
                        } catch (Exception e2) {
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            closeTrans();
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static Response jsonToDB(InputStream json, String deleteWhere) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(json);
            try {
                JsonParser parser = new JsonFactory().createJsonParser((InputStream) bufferedInputStream);
                startTrans();
                boolean clear = true;
                while (parser.nextToken() != JsonToken.END_OBJECT) {
                    String fieldname = parser.getCurrentName();
                    if (fieldname != null && fieldname.equals("launchers")) {
                        fieldname = new StringBuilder(String.valueOf(fieldname)).toString();
                    }
                    if (fieldname != null && fieldname.equals("timestamp")) {
                        closeTrans();
                        return Response.Ok;
                    } else if (fieldname != null && fieldname.equals("message")) {
                        parser.nextToken();
                        if (parser.getText().contains("NOT OK")) {
                            closeTrans();
                            while (parser.nextToken() != JsonToken.END_OBJECT) {
                                if (parser.getCurrentName().equals("pincodes")) {
                                    parser.nextTextValue();
                                    if (parser.getText().equals("1")) {
                                        return Response.Pincode;
                                    }
                                    return Response.Login;
                                }
                            }
                            return Response.Login;
                        }
                    } else if (fieldname != null && tables.containsKey(fieldname)) {
                        if (clear) {
                            for (String key : tables.keySet()) {
                                try {
                                    if (key.equals(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT) && deleteWhere != null && deleteWhere.contains("appid")) {
                                        myDataBase.delete(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, deleteWhere.replace("appid", DBFavorites.KEY_EVENT_ID), (String[]) null);
                                    }
                                    if (key.equals("events") && deleteWhere != null && deleteWhere.contains("eventid")) {
                                        myDataBase.delete("events", deleteWhere.replace("eventid", DBFavorites.KEY_EVENT_ID), (String[]) null);
                                    }
                                    if (key.equals("venues") && deleteWhere != null && deleteWhere.contains("venueid")) {
                                        myDataBase.delete("venues", deleteWhere.replace("venueid", DBFavorites.KEY_EVENT_ID), (String[]) null);
                                    }
                                    if (!key.equals("personal") && !key.equals("note")) {
                                        if (((key.equals("tags") && deleteWhere == null) || !key.equals("tag")) && !key.equals("favorites") && !key.equals("push") && !key.equals("messages") && !key.equals("persprog")) {
                                            myDataBase.delete(key, deleteWhere, (String[]) null);
                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            clear = false;
                        }
                        DatabaseUtils.InsertHelper ih = new DatabaseUtils.InsertHelper(myDataBase, fieldname);
                        List<String> columns = Arrays.asList(tables.get(fieldname));
                        boolean cont = true;
                        while (cont) {
                            try {
                                if (parser.nextToken() != JsonToken.END_ARRAY) {
                                    boolean imgadd = false;
                                    ih.prepareForInsert();
                                    while (cont && parser.nextToken() != JsonToken.END_OBJECT) {
                                        if (parser.getCurrentToken() == JsonToken.END_ARRAY) {
                                            cont = false;
                                        } else {
                                            String columnname = parser.getCurrentName();
                                            if (columnname != null) {
                                                if (columnname.equals("table") || columnname.equals("order")) {
                                                    columnname = String.valueOf(columnname) + "_value";
                                                }
                                                if (columns.contains(columnname) || columnname.equals(DBFavorites.KEY_EVENT_ID) || columnname.equals("loggingpath") || columnname.equals("appid") || columnname.equals("eventid") || columnname.equals("venueid")) {
                                                    parser.nextToken();
                                                    String value = parser.getText();
                                                    ih.bind(ih.getColumnIndex(columnname), value);
                                                    if (columnname.equals("imageurl")) {
                                                        imgadd = true;
                                                    }
                                                    if (columnname.equals(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE) && columns.contains(DBFavorites.KEY_NAME)) {
                                                        ih.bind(ih.getColumnIndex(DBFavorites.KEY_NAME), value);
                                                    }
                                                    if (columns.contains("imageurl") && ((columnname.equals("image") || columnname.equals("image_thumb1") || columnname.equals("imagethumb") || columnname.equals("thumblogo")) && !imgadd)) {
                                                        ih.bind(ih.getColumnIndex("imageurl"), value);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (cont) {
                                        ih.execute();
                                    }
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                ih.close();
                            } catch (Throwable th) {
                                ih.close();
                                throw th;
                            }
                        }
                        ih.close();
                    } else if (fieldname != null && !tables.containsKey(fieldname)) {
                        JsonToken token = parser.nextToken();
                        if (!token.equals(JsonToken.VALUE_STRING)) {
                            String curname = parser.getCurrentName();
                            while (token != JsonToken.END_ARRAY && (token != JsonToken.END_OBJECT || !fieldname.equals(curname))) {
                                token = parser.nextToken();
                                curname = parser.getCurrentName();
                            }
                        }
                    }
                }
                parser.close();
                BufferedInputStream bufferedInputStream2 = bufferedInputStream;
            } catch (Exception e3) {
                e = e3;
                BufferedInputStream bufferedInputStream3 = bufferedInputStream;
            }
        } catch (Exception e4) {
            e = e4;
            e.printStackTrace();
            closeTrans();
            Swipe2MobileFragment.swipeToDB(App.act);
            return Response.Ok;
        }
        closeTrans();
        Swipe2MobileFragment.swipeToDB(App.act);
        return Response.Ok;
    }

    private static void updateTable(String table, String[] fields) {
        List<TCObject> db = getQueryFromDb(String.format("PRAGMA table_info(%1$s)", new Object[]{table}));
        for (String field : fields) {
            boolean hasField = false;
            for (TCObject column : db) {
                if (column.toString().equals(field)) {
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
    private static String m2211cq(String table, String[] fields) {
        String qry = "CREATE TABLE if not exists " + table + " (id VARCHAR PRIMARY KEY, appid VARCHAR, eventid VARCHAR, venueid VARCHAR, loggingpath VARCHAR";
        for (int i = 0; i < fields.length; i++) {
            qry = String.valueOf(qry) + ", " + fields[i] + " VARCHAR";
        }
        return String.valueOf(qry) + ");";
    }

    public static void openDataBase() throws SQLException {
        openDataBase(App.act);
    }

    public static void openDataBase(Context context) throws SQLException {
        if (myDataBase == null) {
            myDataBase = SQLiteDatabase.openOrCreateDatabase("/data/data/" + context.getPackageName() + "/" + DB_NAME, (SQLiteDatabase.CursorFactory) null);
            return;
        }
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
                String myPath = "/data/data/" + context.getPackageName() + "/" + DB_NAME;
                if (!myDataBase.isOpen()) {
                    myDataBase = SQLiteDatabase.openOrCreateDatabase(myPath, (SQLiteDatabase.CursorFactory) null);
                }
            } else {
                AlertDialog.Builder alertbox = new AlertDialog.Builder(App.act);
                alertbox.setMessage(App.act.getString(C0846R.string.somethingwrong));
                alertbox.setPositiveButton(App.act.getString(C0846R.string.tryagain), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        App.act.finish();
                        App.act.startActivity(new Intent(App.act, Splash.class));
                    }
                });
                alertbox.setNegativeButton(App.act.getString(C0846R.string.close), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        App.act.finish();
                    }
                });
                alertbox.show();
            }
        }
    }

    public static int getSize(String table, String where, String value) {
        try {
            return Integer.parseInt(DatabaseUtils.stringForQuery(myDataBase, "SELECT COUNT(*) FROM " + table + " WHERE " + where + " == '" + value + "';", (String[]) null));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getSize(String table) {
        try {
            return Integer.parseInt(new StringBuilder().append(DatabaseUtils.queryNumEntries(myDataBase, table)).toString());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
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

    public static TCObject getFirstObject(String table, String where, String value, String orderby) {
        TCObject tco = new TCObject();
        try {
            Cursor c = myDataBase.rawQuery("SELECT * FROM " + table + " WHERE " + where + "=" + value + " ORDER BY " + orderby + " LIMIT 1;", (String[]) null);
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

    public static List<TCObject> getQueryFromDb(String qry) {
        List<TCObject> list = new ArrayList<>();
        try {
            Cursor c = myDataBase.rawQuery(qry, (String[]) null);
            if (c == null || !c.moveToFirst()) {
                c.close();
                return list;
            }
            do {
                TCObject uo = new TCObject();
                for (String key : c.getColumnNames()) {
                    uo.vars.put(key, c.getString(c.getColumnIndex(key)));
                }
                list.add(uo);
            } while (c.moveToNext());
            c.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<TCObject> getListFromDb(String table, String where, String value) {
        return getListFromDb(table, where, value, "");
    }

    public static void add(String table, ContentValues cv) {
        myDataBase.insert(table, (String) null, cv);
    }

    public static List<TCObject> getListFromDb(String table, String orderby) {
        List<TCObject> list = new ArrayList<>();
        try {
            Cursor c = myDataBase.rawQuery("SELECT * FROM " + table + " ORDER BY " + orderby + ";", (String[]) null);
            if (c == null || !c.moveToFirst()) {
                c.close();
                return list;
            }
            do {
                TCObject uo = new TCObject();
                for (String key : c.getColumnNames()) {
                    uo.vars.put(key, c.getString(c.getColumnIndex(key)));
                }
                list.add(uo);
            } while (c.moveToNext());
            c.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<TCObject> getListFromDb(String table, String where, String value, String orderby) {
        Cursor c;
        List<TCObject> list = new ArrayList<>();
        try {
            if (isNull()) {
                openDataBase();
            }
            if (orderby.equals("")) {
                c = myDataBase.rawQuery("SELECT * FROM " + table + " WHERE " + where + " == '" + value + "';", (String[]) null);
            } else {
                c = myDataBase.rawQuery("SELECT * FROM " + table + " WHERE " + where + " == '" + value + "' ORDER BY " + orderby + ";", (String[]) null);
            }
            if (c == null || !c.moveToFirst()) {
                c.close();
                return list;
            }
            do {
                TCObject uo = new TCObject();
                for (String key : c.getColumnNames()) {
                    uo.vars.put(key, c.getString(c.getColumnIndex(key)));
                }
                list.add(uo);
            } while (c.moveToNext());
            c.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<TCObject> getListFromDb(String table) {
        List<TCObject> list = new ArrayList<>();
        try {
            Cursor c = myDataBase.rawQuery("SELECT * FROM " + table + " ORDER BY id;", (String[]) null);
            if (c == null || !c.moveToFirst()) {
                c.close();
                return list;
            }
            do {
                TCObject uo = new TCObject();
                for (String key : c.getColumnNames()) {
                    uo.vars.put(key, c.getString(c.getColumnIndex(key)));
                }
                list.add(uo);
            } while (c.moveToNext());
            c.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
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

    public static int update(String table, ContentValues cv, String where) {
        return myDataBase.update(table, cv, where, (String[]) null);
    }

    public static void remove(String table, String col, String value) {
        myDataBase.delete(table, String.valueOf(col) + " == " + value, (String[]) null);
    }

    public static void addConfBag(String col, String value) {
        List<NameValuePair> postparams = new ArrayList<>();
        SharedPreferences pref = App.act.getSharedPreferences("TapCrowd", 0);
        postparams.add(new BasicNameValuePair("key", Converter.md5("tcadm" + App.curEventId)));
        postparams.add(new BasicNameValuePair("email", pref.getString("email", "")));
        postparams.add(new BasicNameValuePair(col, value));
        postparams.add(new BasicNameValuePair("eventid", App.curEventId));
        Internet.request(String.valueOf(App.act.getString(C0846R.string.basecallurl)) + "pushFavourite", postparams);
        myDataBase.execSQL("CREATE TABLE IF NOT EXISTS confbag (id INTEGER PRIMARY KEY AUTOINCREMENT, sessionid VARCHAR, exhibitorid VARCHAR, eventid VARCHAR, venueid VARCHAR, text VARCHAR, sub VARCHAR)");
        ContentValues cv = new ContentValues();
        cv.put(col, value);
        cv.put("eventid", App.curEventId);
        myDataBase.insertOrThrow("confbag", (String) null, cv);
    }

    public static void addConfBag(String col, String value, String extra) {
        List<NameValuePair> postparams = new ArrayList<>();
        SharedPreferences pref = App.act.getSharedPreferences("TapCrowd", 0);
        postparams.add(new BasicNameValuePair("key", Converter.md5("tcadm" + App.curEventId)));
        postparams.add(new BasicNameValuePair("email", pref.getString("email", "")));
        postparams.add(new BasicNameValuePair("extra", extra));
        postparams.add(new BasicNameValuePair("eventid", App.curEventId));
        postparams.add(new BasicNameValuePair(col, value));
        Internet.request(String.valueOf(App.act.getString(C0846R.string.basecallurl)) + "pushFavourite", postparams);
        myDataBase.execSQL("CREATE TABLE IF NOT EXISTS confbag (id INTEGER PRIMARY KEY AUTOINCREMENT, sessionid VARCHAR, exhibitorid VARCHAR, eventid VARCHAR, venueid VARCHAR, text VARCHAR, sub VARCHAR)");
        ContentValues cv = new ContentValues();
        cv.put(col, value);
        cv.put("eventid", App.curEventId);
        if (extra.startsWith("BEGIN:VCARD")) {
            String name = "";
            String company = "";
            String tel = "";
            for (String s : extra.split("\n")) {
                if (s.startsWith("FN:")) {
                    name = s.substring(3);
                }
                if (s.startsWith("ORG:")) {
                    company = s.substring(4);
                }
                if (s.startsWith("TEL;CELL;VOICE:")) {
                    tel = s.substring(15);
                }
            }
            cv.put("text", name);
            cv.put("sub", String.valueOf(company) + " - " + tel);
        } else if (extra.contains("http://")) {
            if (extra.contains("\n")) {
                String[] temp = extra.split("\n");
                try {
                    cv.put("text", temp[0]);
                    cv.put("sub", temp[1]);
                } catch (Exception e) {
                }
            } else {
                cv.put("text", extra);
            }
        }
        myDataBase.insertOrThrow("confbag", (String) null, cv);
    }

    public static TCObject getObject(String table, String where, String value) {
        TCObject tco = new TCObject();
        try {
            Cursor c = myDataBase.rawQuery("SELECT * FROM " + table + " WHERE " + where + " == '" + value + "' LIMIT 1;", (String[]) null);
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

    public static void removeFav(String col, String id) {
        if (id != null && !id.equals("")) {
            myDataBase.delete("favorites", String.valueOf(col) + " == " + id, (String[]) null);
        }
    }

    public static void removeConf(String id) {
        if (id != null && !id.equals("")) {
            try {
                myDataBase.delete("confbag", "sessionid == " + id, (String[]) null);
            } catch (Exception e) {
            }
            try {
                myDataBase.delete("confbag", "text == " + id, (String[]) null);
            } catch (Exception e2) {
            }
        }
    }

    public static int getSizeForQuery(String query) {
        try {
            return getQueryFromDb(query).size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void clearDB() {
        startTrans();
        for (String table : tables.keySet()) {
            if (!table.equals("appearance")) {
                myDataBase.delete(table, (String) null, (String[]) null);
            }
        }
        closeTrans();
    }

    public static List<TCObject> getSearchResultFromDb(String table, String column, String searchstring, String limit) {
        List<TCObject> res = new ArrayList<>();
        Cursor c = myDataBase.rawQuery("SELECT id, " + column + " FROM " + table + " WHERE " + column + " LIKE '%" + searchstring + "%' LIMIT " + limit, (String[]) null);
        if (c == null || !c.moveToFirst()) {
            c.close();
            return res;
        }
        do {
            TCObject uo = new TCObject();
            for (String key : c.getColumnNames()) {
                uo.vars.put(key, c.getString(c.getColumnIndex(key)));
            }
            res.add(uo);
        } while (c.moveToNext());
        c.close();
        return res;
    }

    public static List<String> getIdsFromTables(String constraint, String[] tables2) {
        List<String> ids = new ArrayList<>();
        String constraint2 = "%" + constraint + "%";
        String query = "";
        for (String table : tables2) {
            String query2 = String.valueOf(String.valueOf(query) + (query.length() > 0 ? " UNION " : "")) + getQueryForTable(table, constraint2);
            query = String.valueOf(String.valueOf(query2) + (query2.length() > 0 ? " UNION " : "")) + getMetaValueQueryForTable(table, constraint2);
        }
        Cursor c = myDataBase.rawQuery(query, (String[]) null);
        if (c == null || !c.moveToFirst()) {
            c.close();
            return ids;
        }
        do {
            ids.add(c.getString(c.getColumnIndex(DBFavorites.KEY_EVENT_ID)));
        } while (c.moveToNext());
        c.close();
        return ids;
    }

    private static String getQueryForTable(String table, String constraint) {
        if (table.equals(LinkedObjects.TABLE_ATT)) {
            return String.valueOf("") + String.format("SELECT '%1$s:' || %1$s.id as id FROM %1$s WHERE %1$s.name LIKE '%2$s' OR %1$s.firstname LIKE '%2$s' OR %1$s.company LIKE '%2$s' OR %1$s.function LIKE '%2$s' OR %1$s.email LIKE '%2$s'", new Object[]{table, constraint});
        } else if (table.equals(LinkedObjects.TABLE_CAT)) {
            return String.valueOf("") + String.format("SELECT '%1$s:' || %1$s.id as id FROM %1$s WHERE %1$s.name LIKE '%2$s' OR %1$s.pdf LIKE '%2$s' OR %1$s.urltitle LIKE '%2$s' OR %1$s.url LIKE '%2$s'", new Object[]{table, constraint});
        } else if (table.equals("events")) {
            return String.valueOf("") + String.format("SELECT '%1$s:' || %1$s.id as id FROM %1$s WHERE %1$s.name LIKE '%2$s' OR %1$s.phonenr LIKE '%2$s' OR %1$s.email LIKE '%2$s' OR %1$s.datefrom LIKE '%2$s' OR %1$s.dateto LIKE '%2$s' OR %1$s.website LIKE '%2$s'", new Object[]{table, constraint});
        } else if (table.equals(DBFavorites.TABLE_EXHIBITORS)) {
            return String.valueOf("") + String.format("SELECT '%1$s:' || %1$s.id as id FROM %1$s WHERE %1$s.name LIKE '%2$s' OR %1$s.tel LIKE '%2$s' OR %1$s.web LIKE '%2$s' OR %1$s.booth LIKE '%2$s' OR %1$s.address LIKE '%2$s' OR %1$s.email LIKE '%2$s'", new Object[]{table, constraint});
        } else if (table.equals("sessions")) {
            return String.valueOf("") + String.format("SELECT '%1$s:' || %1$s.id as id FROM %1$s WHERE %1$s.name LIKE '%2$s' OR %1$s.starttime LIKE '%2$s' OR %1$s.endtime LIKE '%2$s' OR %1$s.location LIKE '%2$s' OR %1$s.date LIKE '%2$s' OR %1$s.url LIKE '%2$s' OR %1$s.twitter LIKE '%2$s'", new Object[]{table, constraint});
        } else if (table.equals("speakers")) {
            return String.valueOf("") + String.format("SELECT '%1$s:' || %1$s.id as id FROM %1$s WHERE %1$s.name LIKE '%2$s' OR %1$s.company LIKE '%2$s' OR %1$s.function LIKE '%2$s'", new Object[]{table, constraint});
        } else if (table.equals("sponsors")) {
            return String.valueOf("") + String.format("SELECT '%1$s:' || %1$s.id as id FROM %1$s WHERE %1$s.name LIKE '%2$s' OR %1$s.website LIKE '%2$s'", new Object[]{table, constraint});
        } else if (!table.equals("venues")) {
            return "";
        } else {
            return String.valueOf("") + String.format("SELECT '%1$s:' || %1$s.id as id FROM %1$s WHERE %1$s.name LIKE '%2$s' OR %1$s.address LIKE '%2$s' OR %1$s.facebookurl LIKE '%2$s' OR %1$s.telephone LIKE '%2$s' OR %1$s.email LIKE '%2$s' OR %1$s.fax LIKE '%2$s' OR %1$s.website LIKE '%2$s' OR %1$s.twitterurl LIKE '%2$s'", new Object[]{table, constraint});
        }
    }

    private static String getMetaValueQueryForTable(String table, String constraint) {
        return String.valueOf("") + String.format("SELECT DISTINCT '%1$s:' || metavalues.parentId as id FROM metavalues WHERE metavalues.parentType = '%2$s' AND metavalues.value LIKE '%3$s'", new Object[]{table, getParentType(table), constraint});
    }

    private static String getParentType(String table) {
        if (table.equals(LinkedObjects.TABLE_ATT)) {
            return LinkedObjects.TABLE_ATT;
        }
        if (table.equals(LinkedObjects.TABLE_CAT)) {
            return LinkedObjects.TABLE_CAT;
        }
        if (table.equals("events")) {
            return "event";
        }
        if (table.equals(DBFavorites.TABLE_EXHIBITORS)) {
            return LinkedObjects.TABLE_EXHI;
        }
        if (table.equals("sessions")) {
            return "session";
        }
        if (table.equals("speakers")) {
            return "speaker";
        }
        if (table.equals("sponsors")) {
            return "sponsor";
        }
        if (table.equals("venues")) {
            return "venue";
        }
        return "";
    }
}
