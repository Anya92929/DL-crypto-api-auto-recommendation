package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.C1069dr;
import com.google.android.gms.internal.C1071ds;
import com.google.android.gms.internal.C1229gs;

public final class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";

    /* renamed from: lc */
    private C1071ds f30lc;

    /* renamed from: U */
    private void m17U() {
        if (this.f30lc != null) {
            try {
                this.f30lc.mo8306U();
            } catch (RemoteException e) {
                C1229gs.m4683d("Could not forward setContentViewSet to ad overlay:", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f30lc = C1069dr.m4274b(this);
        if (this.f30lc == null) {
            C1229gs.m4679W("Could not create ad overlay.");
            finish();
            return;
        }
        try {
            this.f30lc.onCreate(savedInstanceState);
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not forward onCreate to ad overlay:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            if (this.f30lc != null) {
                this.f30lc.onDestroy();
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        try {
            if (this.f30lc != null) {
                this.f30lc.onPause();
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        try {
            if (this.f30lc != null) {
                this.f30lc.onRestart();
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        try {
            if (this.f30lc != null) {
                this.f30lc.onResume();
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        try {
            if (this.f30lc != null) {
                this.f30lc.onSaveInstanceState(outState);
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(outState);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        try {
            if (this.f30lc != null) {
                this.f30lc.onStart();
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        try {
            if (this.f30lc != null) {
                this.f30lc.onStop();
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not forward onStop to ad overlay:", e);
            finish();
        }
        super.onStop();
    }

    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        m17U();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        m17U();
    }

    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        m17U();
    }
}
