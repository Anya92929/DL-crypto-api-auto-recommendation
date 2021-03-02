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
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.dynamic.LifecycleDelegate;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public T f3119a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Bundle f3120b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public LinkedList<C0758a> f3121c;

    /* renamed from: d */
    private final zzf<T> f3122d = new zzf<T>() {
        public void zza(T t) {
            LifecycleDelegate unused = zza.this.f3119a = t;
            Iterator it = zza.this.f3121c.iterator();
            while (it.hasNext()) {
                ((C0758a) it.next()).mo5800a(zza.this.f3119a);
            }
            zza.this.f3121c.clear();
            Bundle unused2 = zza.this.f3120b = null;
        }
    };

    /* renamed from: com.google.android.gms.dynamic.zza$a */
    interface C0758a {
        /* renamed from: a */
        int mo5799a();

        /* renamed from: a */
        void mo5800a(LifecycleDelegate lifecycleDelegate);
    }

    /* renamed from: a */
    private void m4014a(int i) {
        while (!this.f3121c.isEmpty() && this.f3121c.getLast().mo5799a() >= i) {
            this.f3121c.removeLast();
        }
    }

    /* renamed from: a */
    private void m4015a(Bundle bundle, C0758a aVar) {
        if (this.f3119a != null) {
            aVar.mo5800a(this.f3119a);
            return;
        }
        if (this.f3121c == null) {
            this.f3121c = new LinkedList<>();
        }
        this.f3121c.add(aVar);
        if (bundle != null) {
            if (this.f3120b == null) {
                this.f3120b = (Bundle) bundle.clone();
            } else {
                this.f3120b.putAll(bundle);
            }
        }
        zza(this.f3122d);
    }

    public static void zzb(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        String zzc = zzg.zzc(context, isGooglePlayServicesAvailable, GooglePlayServicesUtil.zzao(context));
        String zzh = zzg.zzh(context, isGooglePlayServicesAvailable);
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
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    context.startActivity(GooglePlayServicesUtil.zzbv(isGooglePlayServicesAvailable));
                }
            });
        }
    }

    public void onCreate(final Bundle bundle) {
        m4015a(bundle, (C0758a) new C0758a() {
            /* renamed from: a */
            public int mo5799a() {
                return 1;
            }

            /* renamed from: a */
            public void mo5800a(LifecycleDelegate lifecycleDelegate) {
                zza.this.f3119a.onCreate(bundle);
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        final LayoutInflater layoutInflater2 = layoutInflater;
        final ViewGroup viewGroup2 = viewGroup;
        final Bundle bundle2 = bundle;
        m4015a(bundle, (C0758a) new C0758a() {
            /* renamed from: a */
            public int mo5799a() {
                return 2;
            }

            /* renamed from: a */
            public void mo5800a(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(zza.this.f3119a.onCreateView(layoutInflater2, viewGroup2, bundle2));
            }
        });
        if (this.f3119a == null) {
            zza(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.f3119a != null) {
            this.f3119a.onDestroy();
        } else {
            m4014a(1);
        }
    }

    public void onDestroyView() {
        if (this.f3119a != null) {
            this.f3119a.onDestroyView();
        } else {
            m4014a(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle bundle, final Bundle bundle2) {
        m4015a(bundle2, (C0758a) new C0758a() {
            /* renamed from: a */
            public int mo5799a() {
                return 0;
            }

            /* renamed from: a */
            public void mo5800a(LifecycleDelegate lifecycleDelegate) {
                zza.this.f3119a.onInflate(activity, bundle, bundle2);
            }
        });
    }

    public void onLowMemory() {
        if (this.f3119a != null) {
            this.f3119a.onLowMemory();
        }
    }

    public void onPause() {
        if (this.f3119a != null) {
            this.f3119a.onPause();
        } else {
            m4014a(5);
        }
    }

    public void onResume() {
        m4015a((Bundle) null, (C0758a) new C0758a() {
            /* renamed from: a */
            public int mo5799a() {
                return 5;
            }

            /* renamed from: a */
            public void mo5800a(LifecycleDelegate lifecycleDelegate) {
                zza.this.f3119a.onResume();
            }
        });
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.f3119a != null) {
            this.f3119a.onSaveInstanceState(bundle);
        } else if (this.f3120b != null) {
            bundle.putAll(this.f3120b);
        }
    }

    public void onStart() {
        m4015a((Bundle) null, (C0758a) new C0758a() {
            /* renamed from: a */
            public int mo5799a() {
                return 4;
            }

            /* renamed from: a */
            public void mo5800a(LifecycleDelegate lifecycleDelegate) {
                zza.this.f3119a.onStart();
            }
        });
    }

    public void onStop() {
        if (this.f3119a != null) {
            this.f3119a.onStop();
        } else {
            m4014a(4);
        }
    }

    /* access modifiers changed from: protected */
    public void zza(FrameLayout frameLayout) {
        zzb(frameLayout);
    }

    public abstract void zza(zzf<T> zzf);

    public T zztU() {
        return this.f3119a;
    }
}
