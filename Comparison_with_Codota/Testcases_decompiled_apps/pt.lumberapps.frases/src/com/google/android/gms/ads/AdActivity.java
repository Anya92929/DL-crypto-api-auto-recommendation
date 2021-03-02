package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzhi;

public class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";

    /* renamed from: a */
    private zzhi f3382a;

    /* renamed from: a */
    private void m5497a() {
        if (this.f3382a != null) {
            try {
                this.f3382a.zzdb();
            } catch (RemoteException e) {
                zzb.zzd("Could not forward setContentViewSet to ad overlay:", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.f3382a.onActivityResult(i, i2, intent);
        } catch (Exception e) {
            zzb.zzd("Could not forward onActivityResult to ad overlay:", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        boolean z = true;
        try {
            if (this.f3382a != null) {
                z = this.f3382a.zznw();
            }
        } catch (RemoteException e) {
            zzb.zzd("Could not forward onBackPressed to ad overlay:", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3382a = zzm.zzix().zzc(this);
        if (this.f3382a == null) {
            zzb.zzcx("Could not create ad overlay.");
            finish();
            return;
        }
        try {
            this.f3382a.onCreate(bundle);
        } catch (RemoteException e) {
            zzb.zzd("Could not forward onCreate to ad overlay:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            if (this.f3382a != null) {
                this.f3382a.onDestroy();
            }
        } catch (RemoteException e) {
            zzb.zzd("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        try {
            if (this.f3382a != null) {
                this.f3382a.onPause();
            }
        } catch (RemoteException e) {
            zzb.zzd("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        try {
            if (this.f3382a != null) {
                this.f3382a.onRestart();
            }
        } catch (RemoteException e) {
            zzb.zzd("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        try {
            if (this.f3382a != null) {
                this.f3382a.onResume();
            }
        } catch (RemoteException e) {
            zzb.zzd("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.f3382a != null) {
                this.f3382a.onSaveInstanceState(bundle);
            }
        } catch (RemoteException e) {
            zzb.zzd("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        try {
            if (this.f3382a != null) {
                this.f3382a.onStart();
            }
        } catch (RemoteException e) {
            zzb.zzd("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        try {
            if (this.f3382a != null) {
                this.f3382a.onStop();
            }
        } catch (RemoteException e) {
            zzb.zzd("Could not forward onStop to ad overlay:", e);
            finish();
        }
        super.onStop();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        m5497a();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        m5497a();
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        m5497a();
    }
}
