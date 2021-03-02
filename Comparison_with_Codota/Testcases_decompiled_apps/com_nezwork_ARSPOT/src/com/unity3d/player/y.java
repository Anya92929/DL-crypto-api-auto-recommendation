package com.unity3d.player;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import java.util.HashSet;
import java.util.Set;

final class y {
    public static y a;
    private final FrameLayout b;
    private Set c = new HashSet();
    private View d;
    private View e;

    y(FrameLayout frameLayout) {
        this.b = frameLayout;
        a = this;
    }

    public final Context a() {
        return this.b.getContext();
    }

    public final void a(View view) {
        this.e = view;
        this.e.setVisibility(4);
        this.b.addView(this.e);
    }

    public final void b(View view) {
        this.c.add(view);
        if (this.d != null) {
            this.b.addView(view, this.b.getChildCount());
        }
    }

    public final void c(View view) {
        this.c.remove(view);
        if (this.d != null) {
            this.b.removeView(view);
            this.b.requestLayout();
        }
    }

    public final void d(View view) {
        if (this.d != view) {
            this.d = view;
            this.b.addView(view);
            for (View addView : this.c) {
                this.b.addView(addView, this.b.getChildCount());
            }
            if (this.e != null) {
                this.e.setVisibility(4);
            }
        }
    }

    public final void e(View view) {
        if (this.d == view) {
            for (View removeView : this.c) {
                this.b.removeView(removeView);
                this.b.requestLayout();
            }
            this.b.removeView(view);
            this.d = null;
            if (this.e != null) {
                this.e.setVisibility(0);
            }
        }
    }
}
