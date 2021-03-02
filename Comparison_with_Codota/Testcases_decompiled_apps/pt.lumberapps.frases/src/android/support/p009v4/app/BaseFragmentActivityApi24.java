package android.support.p009v4.app;

import android.support.p009v4.p018e.C0130c;

/* renamed from: android.support.v4.app.BaseFragmentActivityApi24 */
abstract class BaseFragmentActivityApi24 extends BaseFragmentActivityHoneycomb {
    BaseFragmentActivityApi24() {
    }

    /* access modifiers changed from: package-private */
    public abstract void dispatchFragmentsOnMultiWindowModeChanged(boolean z);

    /* access modifiers changed from: package-private */
    public abstract void dispatchFragmentsOnPictureInPictureModeChanged(boolean z);

    public void onMultiWindowModeChanged(boolean z) {
        if (C0130c.m319a()) {
            super.onMultiWindowModeChanged(z);
        }
        dispatchFragmentsOnMultiWindowModeChanged(z);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        if (C0130c.m319a()) {
            super.onPictureInPictureModeChanged(z);
        }
        dispatchFragmentsOnPictureInPictureModeChanged(z);
    }
}
