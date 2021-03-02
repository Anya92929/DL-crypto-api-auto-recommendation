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
    private final zzf<T> zzavA = new zzf<T>() {
        public void zza(T t) {
            LifecycleDelegate unused = zza.this.zzavx = t;
            Iterator it = zza.this.zzavz.iterator();
            while (it.hasNext()) {
                ((C0437zza) it.next()).zzb(zza.this.zzavx);
            }
            zza.this.zzavz.clear();
            Bundle unused2 = zza.this.zzavy = null;
        }
    };
    /* access modifiers changed from: private */
    public T zzavx;
    /* access modifiers changed from: private */
    public Bundle zzavy;
    /* access modifiers changed from: private */
    public LinkedList<C0437zza> zzavz;

    /* renamed from: com.google.android.gms.dynamic.zza$zza  reason: collision with other inner class name */
    private interface C0437zza {
        int getState();

        void zzb(LifecycleDelegate lifecycleDelegate);
    }

    private void zza(Bundle bundle, C0437zza zza) {
        if (this.zzavx != null) {
            zza.zzb(this.zzavx);
            return;
        }
        if (this.zzavz == null) {
            this.zzavz = new LinkedList<>();
        }
        this.zzavz.add(zza);
        if (bundle != null) {
            if (this.zzavy == null) {
                this.zzavy = (Bundle) bundle.clone();
            } else {
                this.zzavy.putAll(bundle);
            }
        }
        zza(this.zzavA);
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
                public void onClick(View v) {
                    context.startActivity(GooglePlayServicesUtil.zzbv(isGooglePlayServicesAvailable));
                }
            });
        }
    }

    private void zzeJ(int i) {
        while (!this.zzavz.isEmpty() && this.zzavz.getLast().getState() >= i) {
            this.zzavz.removeLast();
        }
    }

    public void onCreate(final Bundle savedInstanceState) {
        zza(savedInstanceState, (C0437zza) new C0437zza() {
            public int getState() {
                return 1;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.zzavx.onCreate(savedInstanceState);
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        final LayoutInflater layoutInflater = inflater;
        final ViewGroup viewGroup = container;
        final Bundle bundle = savedInstanceState;
        zza(savedInstanceState, (C0437zza) new C0437zza() {
            public int getState() {
                return 2;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(zza.this.zzavx.onCreateView(layoutInflater, viewGroup, bundle));
            }
        });
        if (this.zzavx == null) {
            zza(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.zzavx != null) {
            this.zzavx.onDestroy();
        } else {
            zzeJ(1);
        }
    }

    public void onDestroyView() {
        if (this.zzavx != null) {
            this.zzavx.onDestroyView();
        } else {
            zzeJ(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle attrs, final Bundle savedInstanceState) {
        zza(savedInstanceState, (C0437zza) new C0437zza() {
            public int getState() {
                return 0;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.zzavx.onInflate(activity, attrs, savedInstanceState);
            }
        });
    }

    public void onLowMemory() {
        if (this.zzavx != null) {
            this.zzavx.onLowMemory();
        }
    }

    public void onPause() {
        if (this.zzavx != null) {
            this.zzavx.onPause();
        } else {
            zzeJ(5);
        }
    }

    public void onResume() {
        zza((Bundle) null, (C0437zza) new C0437zza() {
            public int getState() {
                return 5;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.zzavx.onResume();
            }
        });
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.zzavx != null) {
            this.zzavx.onSaveInstanceState(outState);
        } else if (this.zzavy != null) {
            outState.putAll(this.zzavy);
        }
    }

    public void onStart() {
        zza((Bundle) null, (C0437zza) new C0437zza() {
            public int getState() {
                return 4;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.zzavx.onStart();
            }
        });
    }

    public void onStop() {
        if (this.zzavx != null) {
            this.zzavx.onStop();
        } else {
            zzeJ(4);
        }
    }

    /* access modifiers changed from: protected */
    public void zza(FrameLayout frameLayout) {
        zzb(frameLayout);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzf<T> zzf);

    public T zztU() {
        return this.zzavx;
    }
}
