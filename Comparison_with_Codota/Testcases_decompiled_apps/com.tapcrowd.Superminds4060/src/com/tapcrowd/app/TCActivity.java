package com.tapcrowd.app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockActivity;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.facebook.DialogError;
import com.tapcrowd.app.utils.facebook.Facebook;
import com.tapcrowd.app.utils.facebook.FacebookError;
import java.util.ArrayList;
import java.util.List;
import org.apache.cordova.Globalization;

public class TCActivity extends SherlockActivity {
    public Handler confhandler = new Handler() {
        public void handleMessage(Message msg) {
            Toast.makeText(App.act, "Conference bag synced!", 0).show();
            super.handleMessage(msg);
        }
    };

    /* renamed from: dl */
    public Facebook.DialogListener f2004dl = new Facebook.DialogListener() {
        public void onFacebookError(FacebookError e) {
        }

        public void onError(DialogError e) {
        }

        public void onComplete(Bundle values) {
        }

        public void onCancel() {
        }
    };
    protected ProgressDialog loading;
    protected List<CountDownTimer> timers;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.act = this;
        try {
            findViewById(C0846R.C0847id.title).setVisibility(8);
        } catch (Exception e) {
        }
        if (!App.f2123id.equals("")) {
            Bundle b = getIntent().getExtras();
            if (b != null && b.containsKey(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)) {
                try {
                    C1232UI.setTitle(b.getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (b == null || !b.containsKey(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)) {
                C1232UI.setTitle("img");
            }
            try {
                List<TCObject> s = C1199DB.getListFromDb("ad", "appid", App.f2123id, "order_value");
                if (s.size() > 0) {
                    this.timers = new ArrayList();
                    int count = 0;
                    for (TCObject o : s) {
                        if (o.has("image")) {
                            count++;
                        }
                    }
                    final int fincount = count;
                    for (int i = 0; i < s.size(); i++) {
                        final int temp = i;
                        TCObject o2 = s.get(i);
                        this.timers.add(new CountDownTimer(Long.parseLong(o2.get(Globalization.TIME)) * 1000, Long.parseLong(o2.get(Globalization.TIME)) * 1000) {
                            public void onTick(long millisUntilFinished) {
                            }

                            public void onFinish() {
                                try {
                                    if (temp + 1 == fincount) {
                                        TCActivity.this.timers.get(0).start();
                                    } else {
                                        TCActivity.this.timers.get(temp + 1).start();
                                    }
                                } catch (Exception e) {
                                }
                            }
                        });
                    }
                    this.timers.get(0).start();
                }
            } catch (Exception e3) {
            }
            this.loading = new ProgressDialog(App.act);
            this.loading.setProgressStyle(1);
            this.loading.setMessage(getString(C0846R.C0847id.loading));
        }
    }

    public void onResume() {
        super.onResume();
        C1232UI.hideNotification(false);
        App.act = this;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }
}
