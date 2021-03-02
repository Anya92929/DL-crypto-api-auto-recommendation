package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.C0292bm;
import com.google.android.gms.internal.C0294bn;
import com.google.android.gms.internal.C0344cn;

public final class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";

    /* renamed from: dH */
    private C0294bn f297dH;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f297dH = C0292bm.m602a(this);
        if (this.f297dH == null) {
            C0344cn.m737q("Could not create ad overlay.");
            finish();
            return;
        }
        try {
            this.f297dH.onCreate(savedInstanceState);
        } catch (RemoteException e) {
            C0344cn.m731b("Could not forward onCreate to ad overlay:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            if (this.f297dH != null) {
                this.f297dH.onDestroy();
            }
        } catch (RemoteException e) {
            C0344cn.m731b("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        try {
            if (this.f297dH != null) {
                this.f297dH.onPause();
            }
        } catch (RemoteException e) {
            C0344cn.m731b("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        try {
            if (this.f297dH != null) {
                this.f297dH.onRestart();
            }
        } catch (RemoteException e) {
            C0344cn.m731b("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        try {
            if (this.f297dH != null) {
                this.f297dH.onResume();
            }
        } catch (RemoteException e) {
            C0344cn.m731b("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        try {
            if (this.f297dH != null) {
                this.f297dH.onSaveInstanceState(outState);
            }
        } catch (RemoteException e) {
            C0344cn.m731b("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(outState);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        try {
            if (this.f297dH != null) {
                this.f297dH.onStart();
            }
        } catch (RemoteException e) {
            C0344cn.m731b("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        try {
            if (this.f297dH != null) {
                this.f297dH.onStop();
            }
        } catch (RemoteException e) {
            C0344cn.m731b("Could not forward onStop to ad overlay:", e);
            finish();
        }
        super.onStop();
    }
}
