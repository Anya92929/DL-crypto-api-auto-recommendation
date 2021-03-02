package com.tapcrowd.app.modules.gamification;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.Internet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class GamificationPrizeFragment extends TCFragment {
    private Button btnSend;
    /* access modifiers changed from: private */
    public EditText etMail;
    /* access modifiers changed from: private */
    public EditText etName;
    private boolean retained;
    private TextView tvComplete;

    /* renamed from: v */
    private View f2043v;

    public static GamificationPrizeFragment newInstance() {
        return new GamificationPrizeFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2043v == null) {
            this.f2043v = inflater.inflate(C0846R.layout.gamificationprize, container, false);
        } else {
            ((ViewGroup) this.f2043v.getParent()).removeView(this.f2043v);
            this.retained = true;
        }
        return this.f2043v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!this.retained) {
            this.tvComplete = (TextView) this.f2043v.findViewById(C0846R.C0847id.tvComplete);
            this.tvComplete.setBackgroundColor(C1216LO.getLo(C1216LO.backgroundColor));
            this.etName = (EditText) this.f2043v.findViewById(C0846R.C0847id.etName);
            this.etMail = (EditText) this.f2043v.findViewById(C0846R.C0847id.etMail);
            this.btnSend = (Button) this.f2043v.findViewById(C0846R.C0847id.btnSend);
            this.btnSend.setTextColor(C1216LO.getLo(C1216LO.textcolorButtons));
            this.btnSend.setBackgroundColor(C1216LO.getLo(C1216LO.buttonBackgroundColor));
            this.btnSend.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    GamificationPrizeFragment.this.doClick();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void doClick() {
        if (this.etName.getText().toString().equals("") || this.etMail.getText().toString().equals("")) {
            AlertDialog.Builder alertbox = new AlertDialog.Builder(getActivity());
            alertbox.setMessage(C0846R.string.gamification_fillin);
            alertbox.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
            alertbox.show();
            return;
        }
        new SendParams(this, (SendParams) null).execute(new Void[0]);
    }

    private class SendParams extends AsyncTask<Void, Void, Boolean> {
        ProgressDialog dialog;

        private SendParams() {
        }

        /* synthetic */ SendParams(GamificationPrizeFragment gamificationPrizeFragment, SendParams sendParams) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.dialog = new ProgressDialog(GamificationPrizeFragment.this.getActivity());
            this.dialog.setMessage(GamificationPrizeFragment.this.getString(C0846R.string.loading));
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(Void... params) {
            List<NameValuePair> postparams = new ArrayList<>();
            postparams.add(new BasicNameValuePair("username", GamificationPrizeFragment.this.etName.getText().toString()));
            postparams.add(new BasicNameValuePair("email", GamificationPrizeFragment.this.etMail.getText().toString()));
            String codes = "";
            Iterator<String> it = new ArrayList<>(Arrays.asList(GamificationPrizeFragment.this.getActivity().getSharedPreferences("gamification", 0).getString("qrCodes", "").split(","))).iterator();
            while (it.hasNext()) {
                codes = String.valueOf(codes) + it.next() + ",";
            }
            String codes2 = codes.substring(0, codes.length() - 1);
            postparams.add(new BasicNameValuePair("appid", App.f2123id));
            postparams.add(new BasicNameValuePair("codes", codes2));
            return Boolean.valueOf(Internet.request("gamification", postparams).equalsIgnoreCase("success"));
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            SharedPreferences.Editor e = GamificationPrizeFragment.this.getActivity().getSharedPreferences("gamification", 0).edit();
            e.putBoolean("done", true);
            e.commit();
            Fragments.back();
            if (this.dialog != null && this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
        }
    }
}
