package android.support.p000v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* renamed from: android.support.v4.widget.ContentLoadingProgressBar */
public class ContentLoadingProgressBar extends ProgressBar {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public long f1421a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f1422b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f1423c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f1424d;

    /* renamed from: e */
    private final Runnable f1425e;

    /* renamed from: f */
    private final Runnable f1426f;

    public ContentLoadingProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f1421a = -1;
        this.f1422b = false;
        this.f1423c = false;
        this.f1424d = false;
        this.f1425e = new Runnable() {
            public void run() {
                boolean unused = ContentLoadingProgressBar.this.f1422b = false;
                long unused2 = ContentLoadingProgressBar.this.f1421a = -1;
                ContentLoadingProgressBar.this.setVisibility(8);
            }
        };
        this.f1426f = new Runnable() {
            public void run() {
                boolean unused = ContentLoadingProgressBar.this.f1423c = false;
                if (!ContentLoadingProgressBar.this.f1424d) {
                    long unused2 = ContentLoadingProgressBar.this.f1421a = System.currentTimeMillis();
                    ContentLoadingProgressBar.this.setVisibility(0);
                }
            }
        };
    }

    /* renamed from: a */
    private void m1026a() {
        removeCallbacks(this.f1425e);
        removeCallbacks(this.f1426f);
    }

    public void hide() {
        this.f1424d = true;
        removeCallbacks(this.f1426f);
        long currentTimeMillis = System.currentTimeMillis() - this.f1421a;
        if (currentTimeMillis >= 500 || this.f1421a == -1) {
            setVisibility(8);
        } else if (!this.f1422b) {
            postDelayed(this.f1425e, 500 - currentTimeMillis);
            this.f1422b = true;
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m1026a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1026a();
    }

    public void show() {
        this.f1421a = -1;
        this.f1424d = false;
        removeCallbacks(this.f1425e);
        if (!this.f1423c) {
            postDelayed(this.f1426f, 500);
            this.f1423c = true;
        }
    }
}
