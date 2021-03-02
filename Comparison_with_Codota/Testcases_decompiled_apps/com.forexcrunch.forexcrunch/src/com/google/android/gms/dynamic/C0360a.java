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
public abstract class C0360a<T extends LifecycleDelegate> {
    /* access modifiers changed from: private */

    /* renamed from: cP */
    public T f850cP;
    /* access modifiers changed from: private */

    /* renamed from: cQ */
    public Bundle f851cQ;
    /* access modifiers changed from: private */

    /* renamed from: cR */
    public LinkedList<C0367a> f852cR;

    /* renamed from: cS */
    private final C0372d<T> f853cS = new C0372d<T>() {
        /* renamed from: a */
        public void mo4125a(T t) {
            LifecycleDelegate unused = C0360a.this.f850cP = t;
            Iterator it = C0360a.this.f852cR.iterator();
            while (it.hasNext()) {
                ((C0367a) it.next()).mo4126b(C0360a.this.f850cP);
            }
            C0360a.this.f852cR.clear();
            Bundle unused2 = C0360a.this.f851cQ = null;
        }
    };

    /* renamed from: com.google.android.gms.dynamic.a$a */
    private interface C0367a {
        /* renamed from: b */
        void mo4126b(LifecycleDelegate lifecycleDelegate);

        int getState();
    }

    /* renamed from: a */
    private void m688a(Bundle bundle, C0367a aVar) {
        if (this.f850cP != null) {
            aVar.mo4126b(this.f850cP);
            return;
        }
        if (this.f852cR == null) {
            this.f852cR = new LinkedList<>();
        }
        this.f852cR.add(aVar);
        if (bundle != null) {
            if (this.f851cQ == null) {
                this.f851cQ = (Bundle) bundle.clone();
            } else {
                this.f851cQ.putAll(bundle);
            }
        }
        mo4114a(this.f853cS);
    }

    /* renamed from: y */
    private void m690y(int i) {
        while (!this.f852cR.isEmpty() && this.f852cR.getLast().getState() >= i) {
            this.f852cR.removeLast();
        }
    }

    /* renamed from: a */
    public void mo4113a(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        String b = GooglePlayServicesUtil.m550b(context, isGooglePlayServicesAvailable, -1);
        String a = GooglePlayServicesUtil.m546a(context, isGooglePlayServicesAvailable);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(b);
        linearLayout.addView(textView);
        if (a != null) {
            Button button = new Button(context);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(a);
            linearLayout.addView(button);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    context.startActivity(GooglePlayServicesUtil.m545a(context, isGooglePlayServicesAvailable, -1));
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo4114a(C0372d<T> dVar);

    /* renamed from: at */
    public T mo4115at() {
        return this.f850cP;
    }

    public void onCreate(final Bundle savedInstanceState) {
        m688a(savedInstanceState, (C0367a) new C0367a() {
            /* renamed from: b */
            public void mo4126b(LifecycleDelegate lifecycleDelegate) {
                C0360a.this.f850cP.onCreate(savedInstanceState);
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
        m688a(savedInstanceState, (C0367a) new C0367a() {
            /* renamed from: b */
            public void mo4126b(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(C0360a.this.f850cP.onCreateView(layoutInflater, viewGroup, bundle));
            }

            public int getState() {
                return 2;
            }
        });
        if (this.f850cP == null) {
            mo4113a(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.f850cP != null) {
            this.f850cP.onDestroy();
        } else {
            m690y(1);
        }
    }

    public void onDestroyView() {
        if (this.f850cP != null) {
            this.f850cP.onDestroyView();
        } else {
            m690y(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle attrs, final Bundle savedInstanceState) {
        m688a(savedInstanceState, (C0367a) new C0367a() {
            /* renamed from: b */
            public void mo4126b(LifecycleDelegate lifecycleDelegate) {
                C0360a.this.f850cP.onInflate(activity, attrs, savedInstanceState);
            }

            public int getState() {
                return 0;
            }
        });
    }

    public void onLowMemory() {
        if (this.f850cP != null) {
            this.f850cP.onLowMemory();
        }
    }

    public void onPause() {
        if (this.f850cP != null) {
            this.f850cP.onPause();
        } else {
            m690y(3);
        }
    }

    public void onResume() {
        m688a((Bundle) null, (C0367a) new C0367a() {
            /* renamed from: b */
            public void mo4126b(LifecycleDelegate lifecycleDelegate) {
                C0360a.this.f850cP.onResume();
            }

            public int getState() {
                return 3;
            }
        });
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.f850cP != null) {
            this.f850cP.onSaveInstanceState(outState);
        } else if (this.f851cQ != null) {
            outState.putAll(this.f851cQ);
        }
    }
}
