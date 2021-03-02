package android.support.p003v7.internal.widget;

import android.graphics.Outline;

/* renamed from: android.support.v7.internal.widget.ActionBarBackgroundDrawableV21 */
class ActionBarBackgroundDrawableV21 extends ActionBarBackgroundDrawable {
    public ActionBarBackgroundDrawableV21(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public void getOutline(Outline outline) {
        if (this.f2202a.f2206d) {
            if (this.f2202a.f2205c != null) {
                this.f2202a.f2205c.getOutline(outline);
            }
        } else if (this.f2202a.f2203a != null) {
            this.f2202a.f2203a.getOutline(outline);
        }
    }
}
