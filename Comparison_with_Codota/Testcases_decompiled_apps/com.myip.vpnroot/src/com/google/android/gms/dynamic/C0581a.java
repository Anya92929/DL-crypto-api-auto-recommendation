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
import com.google.android.gms.dynamic.LifecycleDelegate;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.google.android.gms.dynamic.a */
public abstract class C0581a<T extends LifecycleDelegate> {
    /* access modifiers changed from: private */

    /* renamed from: RP */
    public T f1245RP;
    /* access modifiers changed from: private */

    /* renamed from: RQ */
    public Bundle f1246RQ;
    /* access modifiers changed from: private */

    /* renamed from: RR */
    public LinkedList<C0589a> f1247RR;

    /* renamed from: RS */
    private final C0598f<T> f1248RS = new C0598f<T>() {
        /* renamed from: a */
        public void mo5511a(T t) {
            LifecycleDelegate unused = C0581a.this.f1245RP = t;
            Iterator it = C0581a.this.f1247RR.iterator();
            while (it.hasNext()) {
                ((C0589a) it.next()).mo5512b(C0581a.this.f1245RP);
            }
            C0581a.this.f1247RR.clear();
            Bundle unused2 = C0581a.this.f1246RQ = null;
        }
    };

    /* renamed from: com.google.android.gms.dynamic.a$a */
    private interface C0589a {
        /* renamed from: b */
        void mo5512b(LifecycleDelegate lifecycleDelegate);

        int getState();
    }

    /* renamed from: a */
    private void m1707a(Bundle bundle, C0589a aVar) {
        if (this.f1245RP != null) {
            aVar.mo5512b(this.f1245RP);
            return;
        }
        if (this.f1247RR == null) {
            this.f1247RR = new LinkedList<>();
        }
        this.f1247RR.add(aVar);
        if (bundle != null) {
            if (this.f1246RQ == null) {
                this.f1246RQ = (Bundle) bundle.clone();
            } else {
                this.f1246RQ.putAll(bundle);
            }
        }
        mo5498a(this.f1248RS);
    }

    /* renamed from: b */
    public static void m1709b(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        String d = GooglePlayServicesUtil.m474d(context, isGooglePlayServicesAvailable);
        String e = GooglePlayServicesUtil.m475e(context, isGooglePlayServicesAvailable);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(d);
        linearLayout.addView(textView);
        if (e != null) {
            Button button = new Button(context);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(e);
            linearLayout.addView(button);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    context.startActivity(GooglePlayServicesUtil.m472c(context, isGooglePlayServicesAvailable));
                }
            });
        }
    }

    /* renamed from: cv */
    private void m1710cv(int i) {
        while (!this.f1247RR.isEmpty() && this.f1247RR.getLast().getState() >= i) {
            this.f1247RR.removeLast();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5497a(FrameLayout frameLayout) {
        m1709b(frameLayout);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo5498a(C0598f<T> fVar);

    /* renamed from: it */
    public T mo5499it() {
        return this.f1245RP;
    }

    public void onCreate(final Bundle savedInstanceState) {
        m1707a(savedInstanceState, (C0589a) new C0589a() {
            /* renamed from: b */
            public void mo5512b(LifecycleDelegate lifecycleDelegate) {
                C0581a.this.f1245RP.onCreate(savedInstanceState);
            }

            public int getState() {
                return 1;
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        final LayoutInflater layoutInflater = inflater;
        final ViewGroup viewGroup = container;
        final Bundle bundle = savedInstanceState;
        m1707a(savedInstanceState, (C0589a) new C0589a() {
            /* renamed from: b */
            public void mo5512b(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(C0581a.this.f1245RP.onCreateView(layoutInflater, viewGroup, bundle));
            }

            public int getState() {
                return 2;
            }
        });
        if (this.f1245RP == null) {
            mo5497a(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.f1245RP != null) {
            this.f1245RP.onDestroy();
        } else {
            m1710cv(1);
        }
    }

    public void onDestroyView() {
        if (this.f1245RP != null) {
            this.f1245RP.onDestroyView();
        } else {
            m1710cv(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle attrs, final Bundle savedInstanceState) {
        m1707a(savedInstanceState, (C0589a) new C0589a() {
            /* renamed from: b */
            public void mo5512b(LifecycleDelegate lifecycleDelegate) {
                C0581a.this.f1245RP.onInflate(activity, attrs, savedInstanceState);
            }

            public int getState() {
                return 0;
            }
        });
    }

    public void onLowMemory() {
        if (this.f1245RP != null) {
            this.f1245RP.onLowMemory();
        }
    }

    public void onPause() {
        if (this.f1245RP != null) {
            this.f1245RP.onPause();
        } else {
            m1710cv(5);
        }
    }

    public void onResume() {
        m1707a((Bundle) null, (C0589a) new C0589a() {
            /* renamed from: b */
            public void mo5512b(LifecycleDelegate lifecycleDelegate) {
                C0581a.this.f1245RP.onResume();
            }

            public int getState() {
                return 5;
            }
        });
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.f1245RP != null) {
            this.f1245RP.onSaveInstanceState(outState);
        } else if (this.f1246RQ != null) {
            outState.putAll(this.f1246RQ);
        }
    }

    public void onStart() {
        m1707a((Bundle) null, (C0589a) new C0589a() {
            /* renamed from: b */
            public void mo5512b(LifecycleDelegate lifecycleDelegate) {
                C0581a.this.f1245RP.onStart();
            }

            public int getState() {
                return 4;
            }
        });
    }

    public void onStop() {
        if (this.f1245RP != null) {
            this.f1245RP.onStop();
        } else {
            m1710cv(4);
        }
    }
}
