package com.tapcrowd.app.modules.notifications;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.TCListFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.modules.webview.WebViewFragment;
import com.tapcrowd.app.utils.AdHelper;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.Internet;
import com.tapcrowd.app.utils.LinkedObjects;
import com.tapcrowd.app.utils.PathHelper;
import com.tapcrowd.app.utils.TCObject;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class MessageDetailFragment extends TCFragment implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: id */
    public String f2096id;
    private TCObject message;
    private String messagetitle;
    private boolean retained;
    private String text;

    /* renamed from: v */
    private View f2097v;

    public static MessageDetailFragment newInstance(String id, String text2) {
        MessageDetailFragment fr = new MessageDetailFragment();
        fr.f2096id = id;
        fr.text = text2;
        return fr;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DBFavorites.KEY_EVENT_ID, this.f2096id);
        outState.putString("text", this.text);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2097v == null) {
            this.f2097v = inflater.inflate(C0846R.layout.layout_message_detail, container, false);
        } else {
            ((ViewGroup) this.f2097v.getParent()).removeView(this.f2097v);
            this.retained = true;
        }
        return this.f2097v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AdHelper.showAds(this, (String) null);
        if (!this.retained) {
            setupLayout();
        }
    }

    public void setupLayout() {
        if (this.f2096id != null) {
            this.message = C1199DB.getFirstObject("messages", DBFavorites.KEY_EVENT_ID, this.f2096id);
            this.messagetitle = this.message.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
            MeetingStatus status = new MeetingStatus(getActivity(), this.message.get("meetingconfirmed"));
            if (status.hasStatus()) {
                this.messagetitle = String.valueOf(this.messagetitle) + String.format(" (%1$s)", new Object[]{status.getStatus()});
            }
            C1232UI.setText((int) C0846R.C0847id.name, this.messagetitle, this.f2097v);
            C1232UI.setTextColor(C0846R.C0847id.name, C1216LO.getLo(C1216LO.titleFontColor), this.f2097v);
            findViewById(C0846R.C0847id.name).setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor));
            String description = "";
            if (this.message.has("meetingpoiname") || (this.message.has("meetingpoiid") && !this.message.get("meetingpoiid").equals("0"))) {
                String description2 = String.valueOf(description) + String.format("%1$s\n", new Object[]{this.title});
                if (this.message.has("meetingdatetime")) {
                    description2 = String.valueOf(description2) + String.format("%1$s\n", new Object[]{this.message.get("meetingdatetime")});
                }
                if (this.message.has("meetingpoiname")) {
                    description2 = String.valueOf(description2) + String.format("%1$s\n", new Object[]{this.message.get("meetingpoiname")});
                } else if (this.message.has("meetingpoiid")) {
                    TCObject poi = C1199DB.getFirstObject("poi", DBFavorites.KEY_EVENT_ID, this.message.get("meetingpoiid"));
                    description2 = String.valueOf(description2) + String.format("%1$s\n", new Object[]{poi.get((String) DBFavorites.KEY_NAME, "")});
                }
                description = String.valueOf(description2) + "\n";
                if (status.isPending()) {
                    findViewById(C0846R.C0847id.acceptbtn).setVisibility(0);
                    findViewById(C0846R.C0847id.cancelbtn).setVisibility(0);
                    findViewById(C0846R.C0847id.acceptbtn).setOnClickListener(this);
                    findViewById(C0846R.C0847id.cancelbtn).setOnClickListener(this);
                }
            } else if (this.message.has("senderattendeeid")) {
                findViewById(C0846R.C0847id.replybtn).setVisibility(0);
                findViewById(C0846R.C0847id.replybtn).setOnClickListener(this);
            }
            if (this.message.has("payload")) {
                try {
                    JSONObject payload = new JSONObject(this.message.get("payload"));
                    if (payload.optString("action").equals("linktomodule") || payload.optString("action").equals("webview")) {
                        findViewById(C0846R.C0847id.morebtn).setVisibility(0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            C1232UI.setText((int) C0846R.C0847id.text, String.valueOf(description) + this.message.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION), this.f2097v);
            TextView replybtn = (TextView) findViewById(C0846R.C0847id.replybtn);
            replybtn.setBackgroundColor(C1216LO.getLo(C1216LO.buttonBackgroundColor));
            replybtn.setTextColor(C1216LO.getLo(C1216LO.textcolorButtons));
            TextView acceptbtn = (TextView) findViewById(C0846R.C0847id.acceptbtn);
            acceptbtn.setBackgroundColor(C1216LO.getLo(C1216LO.buttonBackgroundColor));
            acceptbtn.setTextColor(C1216LO.getLo(C1216LO.textcolorButtons));
            TextView cancelbtn = (TextView) findViewById(C0846R.C0847id.cancelbtn);
            cancelbtn.setBackgroundColor(C1216LO.getLo(C1216LO.buttonBackgroundColor));
            cancelbtn.setTextColor(C1216LO.getLo(C1216LO.textcolorButtons));
            TextView morebtn = (TextView) findViewById(C0846R.C0847id.morebtn);
            morebtn.setBackgroundColor(C1216LO.getLo(C1216LO.buttonBackgroundColor));
            morebtn.setTextColor(C1216LO.getLo(C1216LO.textcolorButtons));
            morebtn.setOnClickListener(this);
        } else if (this.text != null) {
            C1232UI.hide(C0846R.C0847id.name, this.f2097v);
            C1232UI.setText((int) C0846R.C0847id.text, this.text, this.f2097v);
            C1232UI.hide(C0846R.C0847id.replybtn, this.f2097v);
        }
    }

    public View findViewById(int id) {
        return this.f2097v.findViewById(id);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0846R.C0847id.replybtn:
                TCObject tco = C1199DB.getObject(LinkedObjects.TABLE_ATT, DBFavorites.KEY_EVENT_ID, this.message.get("senderattendeeid"));
                Fragments.add(this, SendMessageFragment.newInstance(tco.get(DBFavorites.KEY_EVENT_ID), this.messagetitle), String.valueOf(tco.get("firstname", "")) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + tco.get(DBFavorites.KEY_NAME, ""));
                return;
            case C0846R.C0847id.morebtn:
                showMore();
                return;
            case C0846R.C0847id.acceptbtn:
                new RequestMeetingTask(true).execute(new Void[0]);
                return;
            case C0846R.C0847id.cancelbtn:
                new RequestMeetingTask(false).execute(new Void[0]);
                return;
            default:
                return;
        }
    }

    private void showMore() {
        try {
            JSONObject payload = new JSONObject(this.message.get("payload"));
            String path = payload.getString("path");
            if (payload.optString("action").equals("linktomodule")) {
                Fragment fr = PathHelper.getFragment(getActivity(), path);
                if (fr instanceof TCFragment) {
                    Fragments.add(this, fr, ((TCFragment) fr).getTitle());
                }
                if (fr instanceof TCListFragment) {
                    Fragments.add(this, fr, ((TCListFragment) fr).getTitle());
                }
            } else if (payload.optString("action").equals("webview")) {
                Fragments.add(this, WebViewFragment.newInstance(path, true), (String) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class MeetingStatus {
        private Context context;
        private String status;

        public MeetingStatus(Context context2, String status2) {
            this.status = status2 == null ? "" : status2;
            this.context = context2;
        }

        public boolean isPending() {
            return this.status.equals("unapproved");
        }

        public boolean isDeletable() {
            if (this.status.equals("approved")) {
                return false;
            }
            return true;
        }

        public boolean hasStatus() {
            if (!this.status.equals("approved") && !this.status.equals("unapproved") && !this.status.equals("canceled")) {
                return false;
            }
            return true;
        }

        public String getStatus() {
            String response = "";
            if (this.context == null) {
                return response;
            }
            if (this.status.equals("approved")) {
                response = this.context.getString(C0846R.string.approved);
            } else if (this.status.equals("unapproved")) {
                response = this.context.getString(C0846R.string.unapproved);
            } else if (this.status.equals("canceled")) {
                response = this.context.getString(C0846R.string.canceled);
            }
            return response;
        }
    }

    private class RequestMeetingTask extends AsyncTask<Void, Void, Void> {
        private boolean approved;
        private ProgressDialog dialog;
        private String response;

        public RequestMeetingTask(boolean approved2) {
            this.approved = approved2;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.dialog = new ProgressDialog(MessageDetailFragment.this.getActivity());
            this.dialog.setMessage(MessageDetailFragment.this.getString(C0846R.string.loading));
            this.dialog.setCancelable(false);
            this.dialog.show();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            List<NameValuePair> parameters = new ArrayList<>();
            parameters.add(new BasicNameValuePair("messageid", MessageDetailFragment.this.f2096id));
            parameters.add(new BasicNameValuePair("meetingconfirmed", this.approved ? "approved" : "canceled"));
            this.response = Internet.request("updateMeetMeMessage", parameters);
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            if (this.response.contains("SUCCES")) {
                MessageDetailFragment.this.getActivity().onBackPressed();
            } else {
                new AlertDialog.Builder(MessageDetailFragment.this.getActivity()).setMessage(C0846R.string.noti_error).setPositiveButton(17039370, (DialogInterface.OnClickListener) null).show();
            }
        }
    }
}
