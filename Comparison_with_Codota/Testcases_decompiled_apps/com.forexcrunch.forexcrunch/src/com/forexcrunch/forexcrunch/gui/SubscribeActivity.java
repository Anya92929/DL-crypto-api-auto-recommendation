package com.forexcrunch.forexcrunch.gui;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.gui.utils.Utils;
import com.forexcrunch.forexcrunch.model.News;
import com.forexcrunch.forexcrunch.p004ws.WSController;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.C0165Ad;
import com.google.ads.doubleclick.DfpAdView;
import com.google.analytics.tracking.android.EasyTracker;

public class SubscribeActivity extends Activity implements View.OnClickListener, AdListener {
    private DfpAdView adView;
    private EditText emailEditText;
    private ImageButton imbSend;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0089R.layout.subscribe_activity);
        this.imbSend = (ImageButton) findViewById(C0089R.idSubscribe.imb_send);
        this.imbSend.setOnClickListener(this);
        this.emailEditText = (EditText) findViewById(C0089R.idSubscribe.email);
        createAd();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0089R.idSubscribe.imb_send:
                String email = this.emailEditText.getText().toString();
                if (Utils.isValidEmail(email)) {
                    new SubscribeTask(email).execute(new String[0]);
                    return;
                } else {
                    Toast.makeText(this, getString(C0089R.string.invalid_email), 0).show();
                    return;
                }
            default:
                return;
        }
    }

    class SubscribeTask extends AsyncTask<String, Void, Void> {
        ProgressDialog dialog;
        String email;
        Dialog errDialog;
        String response;
        boolean result;
        News searchResults;

        public SubscribeTask(String email2) {
            this.email = email2;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.dialog = ProgressDialog.show(SubscribeActivity.this, (CharSequence) null, SubscribeActivity.this.getString(C0089R.string.loading));
            this.dialog.show();
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(String... params) {
            try {
                this.result = WSController.requestSubscription(SubscribeActivity.this, this.email);
                return null;
            } catch (Exception e) {
                if (this.dialog != null && this.dialog.isShowing()) {
                    this.dialog.dismiss();
                }
                cancel(true);
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            super.onCancelled();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result2) {
            super.onPostExecute(result2);
            if (this.dialog != null && this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            if (!isCancelled()) {
                Toast.makeText(SubscribeActivity.this, "Email sent", 0).show();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        EasyTracker.getInstance().activityStart(this);
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        EasyTracker.getInstance().activityStop(this);
        super.onStop();
    }

    private void createAd() {
        this.adView = new DfpAdView((Activity) this, new AdSize(320, 50), "/16866187/mobapp_320x50");
        ((LinearLayout) findViewById(C0089R.idSubscribe.f56ad)).addView(this.adView);
        this.adView.loadAd(new AdRequest());
        this.adView.setAdListener(this);
    }

    public void onDismissScreen(C0165Ad arg0) {
    }

    public void onFailedToReceiveAd(C0165Ad arg0, AdRequest.ErrorCode arg1) {
    }

    public void onLeaveApplication(C0165Ad arg0) {
    }

    public void onPresentScreen(C0165Ad arg0) {
    }

    public void onReceiveAd(C0165Ad arg0) {
    }
}
