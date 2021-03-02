package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.p009v4.app.Fragment;
import android.support.p009v4.app.FragmentActivity;
import android.support.p009v4.p019f.C0136a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzqv extends Fragment implements zzqk {

    /* renamed from: a */
    private static WeakHashMap f6920a = new WeakHashMap();

    /* renamed from: b */
    private Map f6921b = new C0136a();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f6922c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Bundle f6923d;

    /* renamed from: a */
    private void m7524a(String str, zzqj zzqj) {
        if (this.f6922c > 0) {
            new Handler(Looper.getMainLooper()).post(new C1828po(this, zzqj, str));
        }
    }

    public static zzqv zza(FragmentActivity fragmentActivity) {
        zzqv zzqv;
        WeakReference weakReference = (WeakReference) f6920a.get(fragmentActivity);
        if (weakReference == null || (zzqv = (zzqv) weakReference.get()) == null) {
            try {
                zzqv = (zzqv) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
                if (zzqv == null || zzqv.isRemoving()) {
                    zzqv = new zzqv();
                    fragmentActivity.getSupportFragmentManager().beginTransaction().add((Fragment) zzqv, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
                }
                f6920a.put(fragmentActivity, new WeakReference(zzqv));
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
            }
        }
        return zzqv;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (zzqj dump : this.f6921b.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (zzqj onActivityResult : this.f6921b.values()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6922c = 1;
        this.f6923d = bundle;
        for (Map.Entry entry : this.f6921b.entrySet()) {
            ((zzqj) entry.getValue()).onCreate(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry entry : this.f6921b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((zzqj) entry.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public void onStart() {
        super.onStop();
        this.f6922c = 2;
        for (zzqj onStart : this.f6921b.values()) {
            onStart.onStart();
        }
    }

    public void onStop() {
        super.onStop();
        this.f6922c = 3;
        for (zzqj onStop : this.f6921b.values()) {
            onStop.onStop();
        }
    }

    public zzqj zza(String str, Class cls) {
        return (zzqj) cls.cast(this.f6921b.get(str));
    }

    public void zza(String str, zzqj zzqj) {
        if (!this.f6921b.containsKey(str)) {
            this.f6921b.put(str, zzqj);
            m7524a(str, zzqj);
            return;
        }
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
    }

    /* renamed from: zzaqv */
    public FragmentActivity zzaqt() {
        return getActivity();
    }
}
