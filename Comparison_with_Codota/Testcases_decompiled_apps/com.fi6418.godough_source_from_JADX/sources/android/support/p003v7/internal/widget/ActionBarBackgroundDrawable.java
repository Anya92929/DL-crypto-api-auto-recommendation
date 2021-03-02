package android.support.p003v7.internal.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v7.internal.widget.ActionBarBackgroundDrawable */
class ActionBarBackgroundDrawable extends Drawable {

    /* renamed from: a */
    final ActionBarContainer f2202a;

    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer) {
        this.f2202a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.f2202a.f2206d) {
            if (this.f2202a.f2203a != null) {
                this.f2202a.f2203a.draw(canvas);
            }
            if (this.f2202a.f2204b != null && this.f2202a.f2207e) {
                this.f2202a.f2204b.draw(canvas);
            }
        } else if (this.f2202a.f2205c != null) {
            this.f2202a.f2205c.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
