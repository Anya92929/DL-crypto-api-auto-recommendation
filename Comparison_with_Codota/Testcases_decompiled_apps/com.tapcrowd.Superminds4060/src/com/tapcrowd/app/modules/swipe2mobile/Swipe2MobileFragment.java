package com.tapcrowd.app.modules.swipe2mobile;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.gms.plus.PlusShare;
import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.Intents;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.business.CatalogDropDownDetail;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.LinkedObjects;
import org.apache.cordova.Globalization;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Swipe2MobileFragment extends TCFragment {
    private static final String PREF = "swipe2mobile";
    private final int REQUEST_CODE = 5324;
    private final String URL = "http://taptarget.tapcrowd.com/0.1/swipetomobileservice/getUserSessionData?appbundle=%1$s&pin=%2$s&securitytoken=%3$s";
    View.OnClickListener doCall = new View.OnClickListener() {
        public void onClick(View v) {
            if (Swipe2MobileFragment.this.pincode.getText().toString().length() == 0) {
                new AlertDialog.Builder(Swipe2MobileFragment.this.getActivity()).setMessage(C0846R.string.swipetomobile_empty).setPositiveButton(17039370, (DialogInterface.OnClickListener) null).show();
            } else if (Swipe2MobileFragment.this.task == null || Swipe2MobileFragment.this.task.getStatus() == AsyncTask.Status.FINISHED) {
                Swipe2MobileFragment.this.task = new Swipe2MobileTask(Swipe2MobileFragment.this, (Swipe2MobileTask) null);
                Swipe2MobileFragment.this.task.execute(new Void[0]);
            }
        }
    };
    /* access modifiers changed from: private */
    public EditText pincode;
    View.OnClickListener startScan = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intentScan = new Intent(Swipe2MobileFragment.this.getActivity(), CaptureActivity.class);
            intentScan.addCategory("android.intent.category.DEFAULT");
            intentScan.setAction(Intents.Scan.ACTION);
            intentScan.addFlags(67108864);
            intentScan.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
            Swipe2MobileFragment.this.startActivityForResult(intentScan, 5324);
        }
    };
    /* access modifiers changed from: private */
    public Swipe2MobileTask task;

    public static Swipe2MobileFragment newInstance() {
        return new Swipe2MobileFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2005v == null) {
            this.f2005v = inflater.inflate(C0846R.layout.layout_swipe_2_mobile, container, false);
        } else {
            ((ViewGroup) this.f2005v.getParent()).removeView(this.f2005v);
            this.retained = true;
        }
        return this.f2005v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (C1199DB.getSize(LinkedObjects.TABLE_CAT, DBFavorites.KEY_EVENT_ID, PREF) > 0) {
            Fragments.add((Fragment) null, CatalogDropDownDetail.newInstance(PREF, true), this.title);
        } else if (!this.retained) {
            this.f2005v.findViewById(C0846R.C0847id.f1992qr).setOnClickListener(this.startScan);
            this.f2005v.findViewById(C0846R.C0847id.docall).setOnClickListener(this.doCall);
            this.pincode = (EditText) this.f2005v.findViewById(C0846R.C0847id.pincode);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == 5324) {
            this.pincode.setText(Uri.parse(data.getStringExtra(Intents.Scan.RESULT)).getQueryParameter("s2m_pin"));
        }
    }

    private class Swipe2MobileTask extends AsyncTask<Void, Void, Void> {
        ProgressDialog dialog;
        String response;

        private Swipe2MobileTask() {
        }

        /* synthetic */ Swipe2MobileTask(Swipe2MobileFragment swipe2MobileFragment, Swipe2MobileTask swipe2MobileTask) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.dialog = new ProgressDialog(Swipe2MobileFragment.this.getActivity());
            this.dialog.setMessage(Swipe2MobileFragment.this.getString(C0846R.string.loading));
            this.dialog.setCancelable(false);
            this.dialog.show();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            try {
                this.response = EntityUtils.toString(new DefaultHttpClient().execute(new HttpGet(String.format("http://taptarget.tapcrowd.com/0.1/swipetomobileservice/getUserSessionData?appbundle=%1$s&pin=%2$s&securitytoken=%3$s", new Object[]{"com.tapcrowd.KiaBE3775", Swipe2MobileFragment.this.pincode.getText(), "52948543712"}))).getEntity());
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            if (this.dialog != null || this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            if (this.response != null) {
                Swipe2MobileFragment.this.save(this.response);
                if (Swipe2MobileFragment.swipeToDB(Swipe2MobileFragment.this.getActivity())) {
                    Fragments.add(Swipe2MobileFragment.this, CatalogDropDownDetail.newInstance(Swipe2MobileFragment.PREF, true), Swipe2MobileFragment.this.title);
                }
            } else {
                new AlertDialog.Builder(Swipe2MobileFragment.this.getActivity()).setMessage(C0846R.string.noti_error).setPositiveButton(17039370, (DialogInterface.OnClickListener) null).show();
            }
            super.onPostExecute(result);
        }
    }

    public void save(String response) {
        SharedPreferences.Editor edit = getActivity().getSharedPreferences(PREF, 0).edit();
        edit.putString(PREF, response);
        edit.commit();
    }

    public static void remove() {
        C1199DB.remove(LinkedObjects.TABLE_CAT, DBFavorites.KEY_EVENT_ID, "'swipe2mobile'");
        C1199DB.remove("metavalues", "parentId", "'swipe2mobile'");
    }

    public static boolean swipeToDB(Context context) {
        String swipe = context.getSharedPreferences(PREF, 0).getString(PREF, (String) null);
        if (swipe == null) {
            return false;
        }
        remove();
        try {
            JSONObjectDefault json = new JSONObjectDefault(swipe);
            ContentValues cv = new ContentValues();
            cv.put(DBFavorites.KEY_EVENT_ID, PREF);
            cv.put("eventid", json.getString("eventid", ""));
            cv.put("venueid", json.getString("venueid", ""));
            cv.put(DBFavorites.KEY_NAME, json.getString(DBFavorites.KEY_NAME, ""));
            cv.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, json.getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, ""));
            cv.put("imageurl", json.getString("imageurl", ""));
            cv.put("order_value", json.getString("order", ""));
            cv.put(PlusShare.KEY_CALL_TO_ACTION_URL, json.getString(PlusShare.KEY_CALL_TO_ACTION_URL, ""));
            cv.put("urltitle", json.getString("urltitle", ""));
            cv.put(Globalization.DATE, json.getString(Globalization.DATE, ""));
            cv.put("loggingpath", json.getString("loggingpath", ""));
            cv.put("price", json.getString("price", ""));
            cv.put("imagethumb", json.getString("imagethumb", ""));
            C1199DB.write(LinkedObjects.TABLE_CAT, cv);
            JSONArray meta = json.getJSONArray("metavalues");
            int len = meta.length();
            for (int i = 0; i < len; i++) {
                JSONObjectDefault val = new JSONObjectDefault(meta.getJSONObject(i).toString());
                ContentValues cv2 = new ContentValues();
                cv2.put("appId", val.getString("appId", ""));
                cv2.put("sortorder", val.getString("sortorder", ""));
                cv2.put(Globalization.TYPE, val.getString(Globalization.TYPE, ""));
                cv2.put(DBFavorites.KEY_NAME, val.getString(DBFavorites.KEY_NAME, ""));
                cv2.put("parentType", val.getString("parentType", ""));
                cv2.put("parentId", PREF);
                cv2.put("value", val.getString("value", ""));
                C1199DB.write("metavalues", cv2);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static class JSONObjectDefault extends JSONObject {
        public JSONObjectDefault(String json) throws JSONException {
            super(json);
        }

        public String getString(String name, String defaultValue) throws JSONException {
            if (has(name)) {
                return getString(name);
            }
            return defaultValue;
        }
    }
}
