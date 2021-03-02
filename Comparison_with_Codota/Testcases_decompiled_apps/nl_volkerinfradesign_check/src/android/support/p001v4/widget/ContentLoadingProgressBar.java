package android.support.p001v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* renamed from: android.support.v4.widget.ContentLoadingProgressBar */
public class ContentLoadingProgressBar extends ProgressBar {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public long f1133a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f1134b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f1135c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f1136d;

    /* renamed from: e */
    private final Runnable f1137e;

    /* renamed from: f */
    private final Runnable f1138f;

    public ContentLoadingProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f1133a = -1;
        this.f1134b = false;
        this.f1135c = false;
        this.f1136d = false;
        this.f1137e = new Runnable() {
            public void run() {
                boolean unused = ContentLoadingProgressBar.this.f1134b = false;
                long unused2 = ContentLoadingProgressBar.this.f1133a = -1;
                ContentLoadingProgressBar.this.setVisibility(8);
            }
        };
        this.f1138f = new Runnable() {
            public void run() {
                boolean unused = ContentLoadingProgressBar.this.f1135c = false;
                if (!ContentLoadingProgressBar.this.f1136d) {
                    long unused2 = ContentLoadingProgressBar.this.f1133a = System.currentTimeMillis();
                    ContentLoadingProgressBar.this.setVisibility(0);
                }
            }
        };
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m2422a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m2422a();
    }

    /* renamed from: a */
    private void m2422a() {
        removeCallbacks(this.f1137e);
        removeCallbacks(this.f1138f);
    }

    public void hide() {
        this.f1136d = true;
        removeCallbacks(this.f1138f);
        long currentTimeMillis = System.currentTimeMillis() - this.f1133a;
        if (currentTimeMillis >= 500 || this.f1133a == -1) {
            setVisibility(8);
        } else if (!this.f1134b) {
            postDelayed(this.f1137e, 500 - currentTimeMillis);
            this.f1134b = true;
        }
    }

    public void show() {
        this.f1133a = -1;
        this.f1136d = false;
        removeCallbacks(this.f1137e);
        if (!this.f1135c) {
            postDelayed(this.f1138f, 500);
            this.f1135c = true;
        }
    }
}
