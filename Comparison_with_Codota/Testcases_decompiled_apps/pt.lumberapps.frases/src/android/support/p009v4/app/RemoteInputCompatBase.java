package android.support.p009v4.app;

import android.os.Bundle;

/* renamed from: android.support.v4.app.RemoteInputCompatBase */
class RemoteInputCompatBase {

    /* renamed from: android.support.v4.app.RemoteInputCompatBase$RemoteInput */
    public abstract class RemoteInput {

        /* renamed from: android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory */
        public interface Factory {
            RemoteInput build(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle);

            RemoteInput[] newArray(int i);
        }

        /* access modifiers changed from: protected */
        public abstract boolean getAllowFreeFormInput();

        /* access modifiers changed from: protected */
        public abstract CharSequence[] getChoices();

        /* access modifiers changed from: protected */
        public abstract Bundle getExtras();

        /* access modifiers changed from: protected */
        public abstract CharSequence getLabel();

        /* access modifiers changed from: protected */
        public abstract String getResultKey();
    }

    RemoteInputCompatBase() {
    }
}
