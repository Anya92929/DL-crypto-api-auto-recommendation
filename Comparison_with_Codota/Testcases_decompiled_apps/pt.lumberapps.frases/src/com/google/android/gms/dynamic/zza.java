package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzh;
import java.util.LinkedList;

public abstract class zza {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public LifecycleDelegate f4777a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Bundle f4778b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public LinkedList f4779c;

    /* renamed from: d */
    private final zzf f4780d = new C1388a(this);

    /* renamed from: a */
    private void m6236a(int i) {
        while (!this.f4779c.isEmpty() && ((C1395h) this.f4779c.getLast()).mo6948a() >= i) {
            this.f4779c.removeLast();
        }
    }

    /* renamed from: a */
    private void m6237a(Bundle bundle, C1395h hVar) {
        if (this.f4777a != null) {
            hVar.mo6949a(this.f4777a);
            return;
        }
        if (this.f4779c == null) {
            this.f4779c = new LinkedList();
        }
        this.f4779c.add(hVar);
        if (bundle != null) {
            if (this.f4778b == null) {
                this.f4778b = (Bundle) bundle.clone();
            } else {
                this.f4778b.putAll(bundle);
            }
        }
        mo6980a(this.f4780d);
    }

    public static void zzb(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        String zzc = zzh.zzc(context, isGooglePlayServicesAvailable, GooglePlayServicesUtil.zzbv(context));
        String zzh = zzh.zzh(context, isGooglePlayServicesAvailable);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(zzc);
        linearLayout.addView(textView);
        if (zzh != null) {
            Button button = new Button(context);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(zzh);
            linearLayout.addView(button);
            button.setOnClickListener(new C1392e(context, isGooglePlayServicesAvailable));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6979a(FrameLayout frameLayout) {
        zzb(frameLayout);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6980a(zzf zzf);

    public void onCreate(Bundle bundle) {
        m6237a(bundle, (C1395h) new C1390c(this, bundle));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        m6237a(bundle, (C1395h) new C1391d(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.f4777a == null) {
            mo6979a(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.f4777a != null) {
            this.f4777a.onDestroy();
        } else {
            m6236a(1);
        }
    }

    public void onDestroyView() {
        if (this.f4777a != null) {
            this.f4777a.onDestroyView();
        } else {
            m6236a(2);
        }
    }

    public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
        m6237a(bundle2, (C1395h) new C1389b(this, activity, bundle, bundle2));
    }

    public void onLowMemory() {
        if (this.f4777a != null) {
            this.f4777a.onLowMemory();
        }
    }

    public void onPause() {
        if (this.f4777a != null) {
            this.f4777a.onPause();
        } else {
            m6236a(5);
        }
    }

    public void onResume() {
        m6237a((Bundle) null, (C1395h) new C1394g(this));
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.f4777a != null) {
            this.f4777a.onSaveInstanceState(bundle);
        } else if (this.f4778b != null) {
            bundle.putAll(this.f4778b);
        }
    }

    public void onStart() {
        m6237a((Bundle) null, (C1395h) new C1393f(this));
    }

    public void onStop() {
        if (this.f4777a != null) {
            this.f4777a.onStop();
        } else {
            m6236a(4);
        }
    }

    public LifecycleDelegate zzbbt() {
        return this.f4777a;
    }
}
