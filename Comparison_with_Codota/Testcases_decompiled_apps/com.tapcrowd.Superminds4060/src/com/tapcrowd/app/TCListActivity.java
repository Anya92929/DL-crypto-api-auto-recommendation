package com.tapcrowd.app;

import android.app.ProgressDialog;
import android.os.Bundle;
import com.actionbarsherlock.app.SherlockListActivity;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;

public class TCListActivity extends SherlockListActivity {
    protected ProgressDialog loading;

    /* renamed from: ph */
    int f2006ph = C0846R.drawable.icon;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.act = this;
        try {
            findViewById(C0846R.C0847id.title).setVisibility(8);
        } catch (Exception e) {
        }
        try {
            findViewById(C0846R.C0847id.main).setBackgroundColor(C1216LO.getLo(C1216LO.backgroundColor));
        } catch (Exception e2) {
        }
        Bundle b = getIntent().getExtras();
        if (b != null) {
            if (b.containsKey(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)) {
                try {
                    C1232UI.setTitle(b.getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (b.containsKey("ph")) {
                this.f2006ph = b.getInt("ph");
            }
        }
        if (b == null || !b.containsKey(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)) {
            C1232UI.setTitle("img");
        }
        this.loading = new ProgressDialog(App.act);
        this.loading.setMessage(getString(C0846R.string.loading));
    }

    public void onResume() {
        super.onResume();
        App.act = this;
    }
}
