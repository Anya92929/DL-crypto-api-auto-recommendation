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
public abstract class C0156a<T extends LifecycleDelegate> {
    /* access modifiers changed from: private */

    /* renamed from: lV */
    public T f424lV;
    /* access modifiers changed from: private */

    /* renamed from: lW */
    public Bundle f425lW;
    /* access modifiers changed from: private */

    /* renamed from: lX */
    public LinkedList<C0163a> f426lX;

    /* renamed from: lY */
    private final C0168d<T> f427lY = new C0168d<T>() {
        /* renamed from: a */
        public void mo3675a(T t) {
            LifecycleDelegate unused = C0156a.this.f424lV = t;
            Iterator it = C0156a.this.f426lX.iterator();
            while (it.hasNext()) {
                ((C0163a) it.next()).mo3676b(C0156a.this.f424lV);
            }
            C0156a.this.f426lX.clear();
            Bundle unused2 = C0156a.this.f425lW = null;
        }
    };

    /* renamed from: com.google.android.gms.dynamic.a$a */
    private interface C0163a {
        /* renamed from: b */
        void mo3676b(LifecycleDelegate lifecycleDelegate);

        int getState();
    }

    /* renamed from: J */
    private void m362J(int i) {
        while (!this.f426lX.isEmpty() && this.f426lX.getLast().getState() >= i) {
            this.f426lX.removeLast();
        }
    }

    /* renamed from: a */
    private void m366a(Bundle bundle, C0163a aVar) {
        if (this.f424lV != null) {
            aVar.mo3676b(this.f424lV);
            return;
        }
        if (this.f426lX == null) {
            this.f426lX = new LinkedList<>();
        }
        this.f426lX.add(aVar);
        if (bundle != null) {
            if (this.f425lW == null) {
                this.f425lW = (Bundle) bundle.clone();
            } else {
                this.f425lW.putAll(bundle);
            }
        }
        mo3664a(this.f427lY);
    }

    /* renamed from: a */
    public void mo3663a(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        String b = GooglePlayServicesUtil.m227b(context, isGooglePlayServicesAvailable, -1);
        String b2 = GooglePlayServicesUtil.m226b(context, isGooglePlayServicesAvailable);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(b);
        linearLayout.addView(textView);
        if (b2 != null) {
            Button button = new Button(context);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(b2);
            linearLayout.addView(button);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    context.startActivity(GooglePlayServicesUtil.m221a(context, isGooglePlayServicesAvailable, -1));
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo3664a(C0168d<T> dVar);

    /* renamed from: bP */
    public T mo3665bP() {
        return this.f424lV;
    }

    public void onCreate(final Bundle savedInstanceState) {
        m366a(savedInstanceState, (C0163a) new C0163a() {
            /* renamed from: b */
            public void mo3676b(LifecycleDelegate lifecycleDelegate) {
                C0156a.this.f424lV.onCreate(savedInstanceState);
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
        m366a(savedInstanceState, (C0163a) new C0163a() {
            /* renamed from: b */
            public void mo3676b(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(C0156a.this.f424lV.onCreateView(layoutInflater, viewGroup, bundle));
            }

            public int getState() {
                return 2;
            }
        });
        if (this.f424lV == null) {
            mo3663a(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.f424lV != null) {
            this.f424lV.onDestroy();
        } else {
            m362J(1);
        }
    }

    public void onDestroyView() {
        if (this.f424lV != null) {
            this.f424lV.onDestroyView();
        } else {
            m362J(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle attrs, final Bundle savedInstanceState) {
        m366a(savedInstanceState, (C0163a) new C0163a() {
            /* renamed from: b */
            public void mo3676b(LifecycleDelegate lifecycleDelegate) {
                C0156a.this.f424lV.onInflate(activity, attrs, savedInstanceState);
            }

            public int getState() {
                return 0;
            }
        });
    }

    public void onLowMemory() {
        if (this.f424lV != null) {
            this.f424lV.onLowMemory();
        }
    }

    public void onPause() {
        if (this.f424lV != null) {
            this.f424lV.onPause();
        } else {
            m362J(3);
        }
    }

    public void onResume() {
        m366a((Bundle) null, (C0163a) new C0163a() {
            /* renamed from: b */
            public void mo3676b(LifecycleDelegate lifecycleDelegate) {
                C0156a.this.f424lV.onResume();
            }

            public int getState() {
                return 3;
            }
        });
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.f424lV != null) {
            this.f424lV.onSaveInstanceState(outState);
        } else if (this.f425lW != null) {
            outState.putAll(this.f425lW);
        }
    }
}
