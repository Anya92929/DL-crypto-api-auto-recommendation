package com.tapcrowd.app.modules.notifications;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.menuitems.MenuFragment;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.Internet;
import com.tapcrowd.app.utils.UserModule;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class SendMessageFragment extends TCFragment implements MenuFragment.MenuItemListener {
    private final int SEND = 3425;
    /* access modifiers changed from: private */
    public String attendeeid;
    EditText message;
    private String messagetitle;
    EditText title;

    /* renamed from: v */
    private View f2100v;

    public static SendMessageFragment newInstance(String attendeeid2) {
        return newInstance(attendeeid2, (String) null);
    }

    public static SendMessageFragment newInstance(String attendeeid2, String messagetitle2) {
        SendMessageFragment fr = new SendMessageFragment();
        fr.attendeeid = attendeeid2;
        fr.messagetitle = messagetitle2;
        return fr;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("messagetitle", this.messagetitle);
        outState.putString("attendeeid", this.attendeeid);
        if (this.title != null) {
            this.title.setText("");
        }
        if (this.message != null) {
            this.message.setText("");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f2100v = inflater.inflate(C0846R.layout.layout_send_message, container, false);
        return this.f2100v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null && this.attendeeid == null) {
            this.attendeeid = savedInstanceState.getString("attendeeid");
            this.messagetitle = savedInstanceState.getString("messagetitle");
        }
        ArrayList<MenuFragment.MenuItemContainer> menuitems = new ArrayList<>();
        menuitems.add(new MenuFragment.MenuItemContainer(C1232UI.getColorOverlay((int) C0846R.drawable.icon_vinkje, C1216LO.getLo(C1216LO.navigationColor)), 3425));
        Fragments.addMenu(this, MenuFragment.newInstance(menuitems, this));
        setupLayout();
    }

    public void setupLayout() {
        this.title = (EditText) findViewById(C0846R.C0847id.titlemes);
        this.message = (EditText) findViewById(C0846R.C0847id.message);
        findViewById(C0846R.C0847id.subjcont).setBackgroundColor(C1216LO.getLo(C1216LO.bordercolorButtons));
        findViewById(C0846R.C0847id.sendcont).setBackgroundColor(C1216LO.getLo(C1216LO.bordercolorButtons));
        TextView send = (TextView) findViewById(C0846R.C0847id.sendbtn);
        send.setBackgroundColor(C1216LO.getLo(C1216LO.buttonBackgroundColor));
        send.setTextColor(C1216LO.getLo(C1216LO.textcolorButtons));
        send.setVisibility(8);
        if (this.messagetitle != null) {
            if (!this.messagetitle.startsWith("RE: ")) {
                this.messagetitle = "RE: " + this.messagetitle;
            }
            this.title.setText(this.messagetitle);
        }
    }

    public View findViewById(int id) {
        return this.f2100v.findViewById(id);
    }

    private class SendMessageTask extends AsyncTask<Void, Void, Boolean> {
        ProgressDialog dialog;
        String messageStr;
        String titleStr;

        private SendMessageTask() {
        }

        /* synthetic */ SendMessageTask(SendMessageFragment sendMessageFragment, SendMessageTask sendMessageTask) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.titleStr = SendMessageFragment.this.title.getText().toString();
            this.messageStr = SendMessageFragment.this.message.getText().toString();
            this.dialog = new ProgressDialog(SendMessageFragment.this.getActivity());
            this.dialog.setMessage(SendMessageFragment.this.getString(C0846R.string.loading));
            this.dialog.show();
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(Void... params) {
            List<NameValuePair> postparams = new ArrayList<>();
            postparams.add(new BasicNameValuePair("appid", App.f2123id));
            postparams.add(new BasicNameValuePair("senderuserid", UserModule.getUserId(SendMessageFragment.this.getActivity())));
            postparams.add(new BasicNameValuePair("attendeeid", SendMessageFragment.this.attendeeid));
            postparams.add(new BasicNameValuePair(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.titleStr));
            postparams.add(new BasicNameValuePair(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.messageStr.equals("") ? MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR : this.messageStr));
            return Boolean.valueOf(Internet.request("sendMeetMeMessage", postparams).equalsIgnoreCase("succes"));
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(final Boolean result) {
            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            AlertDialog.Builder alertbox = new AlertDialog.Builder(SendMessageFragment.this.getActivity());
            alertbox.setMessage(result.booleanValue() ? SendMessageFragment.this.getString(C0846R.string.message_sent) : SendMessageFragment.this.getString(C0846R.string.message_failed));
            alertbox.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    if (result.booleanValue()) {
                        SendMessageFragment.this.getActivity().onBackPressed();
                    }
                }
            });
            alertbox.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialog) {
                    if (result.booleanValue()) {
                        SendMessageFragment.this.getActivity().onBackPressed();
                    }
                }
            });
            alertbox.show();
            super.onPostExecute(result);
        }
    }

    public void click(MenuItem item) {
        switch (item.getItemId()) {
            case 3425:
                new SendMessageTask(this, (SendMessageTask) null).execute(new Void[0]);
                ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f2100v.getWindowToken(), 0);
                return;
            default:
                return;
        }
    }
}
