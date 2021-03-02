package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.p009v4.p019f.C0136a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

@TargetApi(11)
public final class zzql extends Fragment implements zzqk {

    /* renamed from: a */
    private static WeakHashMap f6909a = new WeakHashMap();

    /* renamed from: b */
    private Map f6910b = new C0136a();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f6911c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Bundle f6912d;

    /* renamed from: a */
    private void m7516a(String str, zzqj zzqj) {
        if (this.f6911c > 0) {
            new Handler(Looper.getMainLooper()).post(new C1826pm(this, zzqj, str));
        }
    }

    public static zzql zzt(Activity activity) {
        zzql zzql;
        WeakReference weakReference = (WeakReference) f6909a.get(activity);
        if (weakReference == null || (zzql = (zzql) weakReference.get()) == null) {
            try {
                zzql = (zzql) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                if (zzql == null || zzql.isRemoving()) {
                    zzql = new zzql();
                    activity.getFragmentManager().beginTransaction().add(zzql, "LifecycleFragmentImpl").commitAllowingStateLoss();
                }
                f6909a.put(activity, new WeakReference(zzql));
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
            }
        }
        return zzql;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (zzqj dump : this.f6910b.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (zzqj onActivityResult : this.f6910b.values()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6911c = 1;
        this.f6912d = bundle;
        for (Map.Entry entry : this.f6910b.entrySet()) {
            ((zzqj) entry.getValue()).onCreate(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry entry : this.f6910b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((zzqj) entry.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public void onStart() {
        super.onStop();
        this.f6911c = 2;
        for (zzqj onStart : this.f6910b.values()) {
            onStart.onStart();
        }
    }

    public void onStop() {
        super.onStop();
        this.f6911c = 3;
        for (zzqj onStop : this.f6910b.values()) {
            onStop.onStop();
        }
    }

    public zzqj zza(String str, Class cls) {
        return (zzqj) cls.cast(this.f6910b.get(str));
    }

    public void zza(String str, zzqj zzqj) {
        if (!this.f6910b.containsKey(str)) {
            this.f6910b.put(str, zzqj);
            m7516a(str, zzqj);
            return;
        }
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
    }

    public Activity zzaqt() {
        return getActivity();
    }
}
