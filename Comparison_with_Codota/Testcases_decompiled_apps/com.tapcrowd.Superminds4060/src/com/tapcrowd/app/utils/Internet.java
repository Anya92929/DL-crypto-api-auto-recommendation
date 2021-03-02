package com.tapcrowd.app.utils;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.apache.cordova.Globalization;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Internet {
    static boolean sync = false;

    public static void required() {
        if (!Check.isConnectedToInternet()) {
            Toast.makeText(App.act, C0846R.string.internetrequired, 1).show();
            App.act.onBackPressed();
            App.act.finish();
        }
    }

    public static void syncFavorites() {
        final DBFavorites db = new DBFavorites(App.act);
        if (Check.isConnectedToInternet()) {
            new Thread(new Runnable() {
                public void run() {
                    String email = App.act.getSharedPreferences("TapCrowd", 0).getString("email", "");
                    if (!email.equals("")) {
                        for (TCObject tco : DBFavorites.this.getAllExhibitors()) {
                            TCObject tcoFull = C1199DB.getObject(DBFavorites.TABLE_EXHIBITORS, DBFavorites.KEY_EVENT_ID, tco.get(DBFavorites.KEY_EVENT_ID));
                            List<NameValuePair> pars = new ArrayList<>();
                            pars.add(new BasicNameValuePair("key", Converter.md5("tcadm" + tcoFull.get(DBFavorites.KEY_ID, "") + DBFavorites.TABLE_EXHIBITORS)));
                            pars.add(new BasicNameValuePair(DBFavorites.KEY_EVENT_ID, tco.get(DBFavorites.KEY_ID)));
                            pars.add(new BasicNameValuePair("appid", App.f2123id));
                            pars.add(new BasicNameValuePair("eventid", tcoFull.get("eventid", "")));
                            pars.add(new BasicNameValuePair("email", email));
                            pars.add(new BasicNameValuePair("table", DBFavorites.TABLE_EXHIBITORS));
                            pars.add(new BasicNameValuePair("tableid", tcoFull.get(DBFavorites.KEY_EVENT_ID)));
                            pars.add(new BasicNameValuePair("extra", tcoFull.get("extra", "")));
                            pars.add(new BasicNameValuePair(Globalization.TYPE, "confbag"));
                            if (tco.get("deleted", "0").equals("0")) {
                                Internet.request("addToPersonalProgramme", pars);
                            } else {
                                Internet.request("deleteFromPersonalProgramme", pars);
                            }
                        }
                    }
                }
            }).start();
        }
    }

    public static void synchConferencebag(final Handler h) {
        try {
            if (C1199DB.getSize("personal WHERE synced <> 1") > 0) {
                sync = true;
            }
            if (!sync) {
                return;
            }
            if (Check.isConnectedToInternet()) {
                new Thread(new Runnable() {
                    public void run() {
                        String email = App.act.getSharedPreferences("TapCrowd", 0).getString("email", "");
                        for (TCObject tco : C1199DB.getQueryFromDb("SELECT * FROM personal WHERE synced <> 1")) {
                            List<NameValuePair> pars = new ArrayList<>();
                            pars.add(new BasicNameValuePair("key", Converter.md5("tcadm" + tco.get(DBFavorites.KEY_EVENT_ID, ""))));
                            pars.add(new BasicNameValuePair(DBFavorites.KEY_EVENT_ID, tco.get(DBFavorites.KEY_EVENT_ID, "")));
                            pars.add(new BasicNameValuePair("appid", App.f2123id));
                            pars.add(new BasicNameValuePair("eventid", tco.get("eventid", "")));
                            pars.add(new BasicNameValuePair("email", email));
                            pars.add(new BasicNameValuePair("table", tco.get("table_value", "")));
                            pars.add(new BasicNameValuePair("tableid", tco.get("tableid", "")));
                            pars.add(new BasicNameValuePair("extra", tco.get("extra", "")));
                            pars.add(new BasicNameValuePair(Globalization.TYPE, tco.get(Globalization.TYPE, "")));
                            if (tco.get("deleted", "0").equals("0")) {
                                Internet.request("addToPersonalProgramme", pars);
                            } else {
                                Internet.request("deleteFromPersonalProgramme", pars);
                            }
                            ContentValues cv = new ContentValues();
                            cv.put("synced", "1");
                            C1199DB.update("personal", cv, "id == '" + tco.get(DBFavorites.KEY_EVENT_ID, "") + "'");
                        }
                        if (Internet.sync && h != null) {
                            h.sendEmptyMessage(0);
                        }
                    }
                }).start();
            } else if (sync) {
                Toast.makeText(App.act, "Connect to the internet to sync your conference bag...", 0).show();
            }
        } catch (Exception e) {
        }
    }

    public static String request(String url, List<NameValuePair> parameters) {
        return request(url, parameters, (Context) null);
    }

    public static String request(String url, List<NameValuePair> parameters, Context context) {
        if (context == null) {
            context = App.act;
        }
        if (parameters == null) {
            parameters = new ArrayList<>();
        }
        if (!url.contains("http://")) {
            url = String.valueOf(context.getString(C0846R.string.basecallurl)) + url;
        }
        try {
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(url);
            if (parameters != null) {
                post.setEntity(new UrlEncodedFormEntity(parameters, "UTF-8"));
            }
            return EntityUtils.toString(client.execute(post).getEntity());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static InputStream getApp(List<NameValuePair> parameters) {
        if (parameters == null) {
            parameters = new ArrayList<>();
        }
        String url = String.valueOf(App.act.getString(C0846R.string.basecallurl)) + "getApp";
        try {
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(url);
            post.addHeader("Accept-Encoding", "gzip");
            if (parameters != null) {
                post.setEntity(new UrlEncodedFormEntity(parameters, "UTF-8"));
            }
            HttpResponse response = client.execute(post);
            InputStream instream = response.getEntity().getContent();
            Header contentEncoding = response.getFirstHeader("Content-Encoding");
            if (contentEncoding == null || !contentEncoding.getValue().equalsIgnoreCase("gzip")) {
                return instream;
            }
            return new GZIPInputStream(instream);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getUpdate(String method, String id) {
        List<NameValuePair> postparams = new ArrayList<>();
        postparams.add(new BasicNameValuePair(Globalization.TYPE, "event"));
        postparams.add(new BasicNameValuePair(DBFavorites.KEY_EVENT_ID, id));
        String json = request(String.valueOf(App.act.getString(C0846R.string.basecallurl)) + method + "/", postparams);
        if (json.length() <= 0) {
            return 0;
        }
        C1199DB.openDataBase();
        C1199DB.jsonToDB(json, "eventid == " + id);
        return 1;
    }
}
