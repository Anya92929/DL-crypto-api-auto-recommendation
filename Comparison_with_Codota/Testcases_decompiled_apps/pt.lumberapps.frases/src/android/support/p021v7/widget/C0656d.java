package android.support.p021v7.widget;

import android.graphics.Outline;

/* renamed from: android.support.v7.widget.d */
class C0656d extends C0629c {
    public C0656d(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public void getOutline(Outline outline) {
        if (this.f1501a.f1170d) {
            if (this.f1501a.f1169c != null) {
                this.f1501a.f1169c.getOutline(outline);
            }
        } else if (this.f1501a.f1167a != null) {
            this.f1501a.f1167a.getOutline(outline);
        }
    }
}
