package android.support.p021v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v7.widget.c */
class C0629c extends Drawable {

    /* renamed from: a */
    final ActionBarContainer f1501a;

    public C0629c(ActionBarContainer actionBarContainer) {
        this.f1501a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.f1501a.f1170d) {
            if (this.f1501a.f1167a != null) {
                this.f1501a.f1167a.draw(canvas);
            }
            if (this.f1501a.f1168b != null && this.f1501a.f1171e) {
                this.f1501a.f1168b.draw(canvas);
            }
        } else if (this.f1501a.f1169c != null) {
            this.f1501a.f1169c.draw(canvas);
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
