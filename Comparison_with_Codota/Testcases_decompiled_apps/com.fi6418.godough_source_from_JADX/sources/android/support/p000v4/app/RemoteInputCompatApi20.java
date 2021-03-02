package android.support.p000v4.app;

import android.app.RemoteInput;
import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.RemoteInputCompatBase;

/* renamed from: android.support.v4.app.RemoteInputCompatApi20 */
class RemoteInputCompatApi20 {
    RemoteInputCompatApi20() {
    }

    /* renamed from: a */
    static Bundle m589a(Intent intent) {
        return RemoteInput.getResultsFromIntent(intent);
    }

    /* renamed from: a */
    static void m590a(RemoteInputCompatBase.RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        RemoteInput.addResultsToIntent(m591a(remoteInputArr), intent, bundle);
    }

    /* renamed from: a */
    static RemoteInput[] m591a(RemoteInputCompatBase.RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr2 = new RemoteInput[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            RemoteInputCompatBase.RemoteInput remoteInput = remoteInputArr[i];
            remoteInputArr2[i] = new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build();
        }
        return remoteInputArr2;
    }

    /* renamed from: a */
    static RemoteInputCompatBase.RemoteInput[] m592a(RemoteInput[] remoteInputArr, RemoteInputCompatBase.RemoteInput.Factory factory) {
        if (remoteInputArr == null) {
            return null;
        }
        RemoteInputCompatBase.RemoteInput[] newArray = factory.newArray(remoteInputArr.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= remoteInputArr.length) {
                return newArray;
            }
            RemoteInput remoteInput = remoteInputArr[i2];
            newArray[i2] = factory.build(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), remoteInput.getExtras());
            i = i2 + 1;
        }
    }
}
