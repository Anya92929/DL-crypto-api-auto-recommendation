package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

@zzin
public class zzkk {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f6617a;

    /* renamed from: b */
    private String f6618b;

    /* renamed from: c */
    private final float f6619c;

    /* renamed from: d */
    private float f6620d;

    /* renamed from: e */
    private float f6621e;

    /* renamed from: f */
    private float f6622f;

    /* renamed from: g */
    private int f6623g;

    public zzkk(Context context) {
        this.f6623g = 0;
        this.f6617a = context;
        this.f6619c = context.getResources().getDisplayMetrics().density;
    }

    public zzkk(Context context, String str) {
        this(context);
        this.f6618b = str;
    }

    /* renamed from: a */
    static String m7322a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "No debug information";
        }
        Uri build = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
        StringBuilder sb = new StringBuilder();
        Map zzf = zzu.zzfq().zzf(build);
        for (String str2 : zzf.keySet()) {
            sb.append(str2).append(" = ").append((String) zzf.get(str2)).append("\n\n");
        }
        String trim = sb.toString().trim();
        return TextUtils.isEmpty(trim) ? "No debug information" : trim;
    }

    /* renamed from: a */
    private void m7323a() {
        if (!(this.f6617a instanceof Activity)) {
            zzkd.zzcw("Can not create dialog without Activity Context");
            return;
        }
        String a = m7322a(this.f6618b);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f6617a);
        builder.setMessage(a);
        builder.setTitle("Ad Information");
        builder.setPositiveButton("Share", new C1742mj(this, a));
        builder.setNegativeButton("Close", new C1743mk(this));
        builder.create().show();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8750a(int i, float f, float f2) {
        if (i == 0) {
            this.f6623g = 0;
            this.f6620d = f;
            this.f6621e = f2;
            this.f6622f = f2;
        } else if (this.f6623g == -1) {
        } else {
            if (i == 2) {
                if (f2 > this.f6621e) {
                    this.f6621e = f2;
                } else if (f2 < this.f6622f) {
                    this.f6622f = f2;
                }
                if (this.f6621e - this.f6622f > 30.0f * this.f6619c) {
                    this.f6623g = -1;
                    return;
                }
                if (this.f6623g == 0 || this.f6623g == 2) {
                    if (f - this.f6620d >= 50.0f * this.f6619c) {
                        this.f6620d = f;
                        this.f6623g++;
                    }
                } else if ((this.f6623g == 1 || this.f6623g == 3) && f - this.f6620d <= -50.0f * this.f6619c) {
                    this.f6620d = f;
                    this.f6623g++;
                }
                if (this.f6623g == 1 || this.f6623g == 3) {
                    if (f > this.f6620d) {
                        this.f6620d = f;
                    }
                } else if (this.f6623g == 2 && f < this.f6620d) {
                    this.f6620d = f;
                }
            } else if (i == 1 && this.f6623g == 4) {
                m7323a();
            }
        }
    }

    public void zzcs(String str) {
        this.f6618b = str;
    }

    public void zze(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            mo8750a(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        mo8750a(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }
}
