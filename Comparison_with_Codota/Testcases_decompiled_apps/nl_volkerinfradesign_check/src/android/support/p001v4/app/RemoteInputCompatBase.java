package android.support.p001v4.app;

import android.os.Bundle;

/* renamed from: android.support.v4.app.RemoteInputCompatBase */
public class RemoteInputCompatBase {

    /* renamed from: android.support.v4.app.RemoteInputCompatBase$RemoteInput */
    public static abstract class RemoteInput {

        /* renamed from: android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory */
        public interface Factory {
            RemoteInput build(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle);

            RemoteInput[] newArray(int i);
        }

        public abstract boolean getAllowFreeFormInput();

        public abstract CharSequence[] getChoices();

        public abstract Bundle getExtras();

        public abstract CharSequence getLabel();

        public abstract String getResultKey();
    }
}
