package com.p028a.p031c;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.ProgressBar;
import com.p028a.C0765a;

/* renamed from: com.a.c.e */
public class C0780e implements Runnable {

    /* renamed from: a */
    private ProgressBar f2029a;

    /* renamed from: b */
    private ProgressDialog f2030b;

    /* renamed from: c */
    private Activity f2031c;

    /* renamed from: d */
    private View f2032d;

    /* renamed from: e */
    private boolean f2033e;

    /* renamed from: f */
    private int f2034f;

    /* renamed from: g */
    private int f2035g;

    /* renamed from: h */
    private String f2036h;

    public C0780e(Object obj) {
        if (obj instanceof ProgressBar) {
            this.f2029a = (ProgressBar) obj;
        } else if (obj instanceof ProgressDialog) {
            this.f2030b = (ProgressDialog) obj;
        } else if (obj instanceof Activity) {
            this.f2031c = (Activity) obj;
        } else if (obj instanceof View) {
            this.f2032d = (View) obj;
        }
    }

    /* renamed from: a */
    private void m3553a(String str) {
        if (this.f2030b != null) {
            new C0765a(this.f2030b.getContext()).mo3476b(this.f2030b);
        }
        if (this.f2031c != null) {
            this.f2031c.setProgressBarIndeterminateVisibility(false);
            this.f2031c.setProgressBarVisibility(false);
        }
        if (this.f2029a != null) {
            this.f2029a.setTag(1090453505, str);
            this.f2029a.setVisibility(0);
        }
        View view = this.f2029a;
        if (view == null) {
            view = this.f2032d;
        }
        if (view != null) {
            Object tag = view.getTag(1090453505);
            if (tag == null || tag.equals(str)) {
                view.setTag(1090453505, (Object) null);
                if (this.f2029a != null && this.f2029a.isIndeterminate()) {
                    view.setVisibility(8);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo3575a() {
        if (this.f2029a != null) {
            this.f2029a.setProgress(0);
            this.f2029a.setMax(10000);
        }
        if (this.f2030b != null) {
            this.f2030b.setProgress(0);
            this.f2030b.setMax(10000);
        }
        if (this.f2031c != null) {
            this.f2031c.setProgress(0);
        }
        this.f2033e = false;
        this.f2035g = 0;
        this.f2034f = 10000;
    }

    /* renamed from: a */
    public void mo3576a(int i) {
        if (i <= 0) {
            this.f2033e = true;
            i = 10000;
        }
        this.f2034f = i;
        if (this.f2029a != null) {
            this.f2029a.setProgress(0);
            this.f2029a.setMax(i);
        }
        if (this.f2030b != null) {
            this.f2030b.setProgress(0);
            this.f2030b.setMax(i);
        }
    }

    /* renamed from: b */
    public void mo3577b() {
        if (this.f2029a != null) {
            this.f2029a.setProgress(this.f2029a.getMax());
        }
        if (this.f2030b != null) {
            this.f2030b.setProgress(this.f2030b.getMax());
        }
        if (this.f2031c != null) {
            this.f2031c.setProgress(9999);
        }
    }

    /* renamed from: b */
    public void mo3578b(int i) {
        int i2;
        int i3 = 1;
        if (this.f2029a != null) {
            this.f2029a.incrementProgressBy(this.f2033e ? 1 : i);
        }
        if (this.f2030b != null) {
            ProgressDialog progressDialog = this.f2030b;
            if (!this.f2033e) {
                i3 = i;
            }
            progressDialog.incrementProgressBy(i3);
        }
        if (this.f2031c != null) {
            if (this.f2033e) {
                i2 = this.f2035g;
                this.f2035g = i2 + 1;
            } else {
                this.f2035g += i;
                i2 = (this.f2035g * 10000) / this.f2034f;
            }
            if (i2 > 9999) {
                i2 = 9999;
            }
            this.f2031c.setProgress(i2);
        }
    }

    public void run() {
        m3553a(this.f2036h);
    }
}
