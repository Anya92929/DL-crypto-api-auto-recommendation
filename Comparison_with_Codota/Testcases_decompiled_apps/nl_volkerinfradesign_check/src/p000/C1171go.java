package p000;

import android.graphics.Outline;
import android.support.annotation.NonNull;
import android.support.p004v7.widget.ActionBarContainer;

/* renamed from: go */
public class C1171go extends C1170gn {
    public C1171go(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public void getOutline(@NonNull Outline outline) {
        if (this.f4169a.f1842d) {
            if (this.f4169a.f1841c != null) {
                this.f4169a.f1841c.getOutline(outline);
            }
        } else if (this.f4169a.f1839a != null) {
            this.f4169a.f1839a.getOutline(outline);
        }
    }
}
