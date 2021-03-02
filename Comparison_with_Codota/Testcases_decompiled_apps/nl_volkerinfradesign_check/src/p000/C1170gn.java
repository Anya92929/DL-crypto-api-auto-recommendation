package p000;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.p004v7.widget.ActionBarContainer;

/* renamed from: gn */
public class C1170gn extends Drawable {

    /* renamed from: a */
    final ActionBarContainer f4169a;

    public C1170gn(ActionBarContainer actionBarContainer) {
        this.f4169a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.f4169a.f1842d) {
            if (this.f4169a.f1839a != null) {
                this.f4169a.f1839a.draw(canvas);
            }
            if (this.f4169a.f1840b != null && this.f4169a.f1843e) {
                this.f4169a.f1840b.draw(canvas);
            }
        } else if (this.f4169a.f1841c != null) {
            this.f4169a.f1841c.draw(canvas);
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
