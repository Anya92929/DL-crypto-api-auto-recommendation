package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.Map;

@C1130ez
/* renamed from: com.google.android.gms.internal.gm */
public final class C1218gm {
    /* access modifiers changed from: private */
    public final Context mContext;
    private int mState;

    /* renamed from: ri */
    private final float f3761ri;

    /* renamed from: ws */
    private String f3762ws;

    /* renamed from: wt */
    private float f3763wt;

    /* renamed from: wu */
    private float f3764wu;

    /* renamed from: wv */
    private float f3765wv;

    public C1218gm(Context context) {
        this.mState = 0;
        this.mContext = context;
        this.f3761ri = context.getResources().getDisplayMetrics().density;
    }

    public C1218gm(Context context, String str) {
        this(context);
        this.f3762ws = str;
    }

    /* renamed from: a */
    private void m4648a(int i, float f, float f2) {
        if (i == 0) {
            this.mState = 0;
            this.f3763wt = f;
            this.f3764wu = f2;
            this.f3765wv = f2;
        } else if (this.mState == -1) {
        } else {
            if (i == 2) {
                if (f2 > this.f3764wu) {
                    this.f3764wu = f2;
                } else if (f2 < this.f3765wv) {
                    this.f3765wv = f2;
                }
                if (this.f3764wu - this.f3765wv > 30.0f * this.f3761ri) {
                    this.mState = -1;
                    return;
                }
                if (this.mState == 0 || this.mState == 2) {
                    if (f - this.f3763wt >= 50.0f * this.f3761ri) {
                        this.f3763wt = f;
                        this.mState++;
                    }
                } else if ((this.mState == 1 || this.mState == 3) && f - this.f3763wt <= -50.0f * this.f3761ri) {
                    this.f3763wt = f;
                    this.mState++;
                }
                if (this.mState == 1 || this.mState == 3) {
                    if (f > this.f3763wt) {
                        this.f3763wt = f;
                    }
                } else if (this.mState == 2 && f < this.f3763wt) {
                    this.f3763wt = f;
                }
            } else if (i == 1 && this.mState == 4) {
                showDialog();
            }
        }
    }

    private void showDialog() {
        final String str;
        if (!TextUtils.isEmpty(this.f3762ws)) {
            Uri build = new Uri.Builder().encodedQuery(this.f3762ws).build();
            StringBuilder sb = new StringBuilder();
            Map<String, String> c = C1213gj.m4629c(build);
            for (String next : c.keySet()) {
                sb.append(next).append(" = ").append(c.get(next)).append("\n\n");
            }
            str = sb.toString().trim();
            if (TextUtils.isEmpty(str)) {
                str = "No debug information";
            }
        } else {
            str = "No debug information";
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setMessage(str);
        builder.setTitle("Ad Information");
        builder.setPositiveButton("Share", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                C1218gm.this.mContext.startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.create().show();
    }

    /* renamed from: Q */
    public void mo8603Q(String str) {
        this.f3762ws = str;
    }

    /* renamed from: c */
    public void mo8604c(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            m4648a(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        m4648a(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }
}
