package p000;

import android.app.RemoteInput;
import android.content.Intent;
import android.os.Bundle;
import android.support.p001v4.app.RemoteInputCompatBase;

/* renamed from: ad */
public class C0004ad {
    /* renamed from: a */
    public static RemoteInputCompatBase.RemoteInput[] m9a(RemoteInput[] remoteInputArr, RemoteInputCompatBase.RemoteInput.Factory factory) {
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

    /* renamed from: a */
    public static RemoteInput[] m8a(RemoteInputCompatBase.RemoteInput[] remoteInputArr) {
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
    public static Bundle m6a(Intent intent) {
        return RemoteInput.getResultsFromIntent(intent);
    }

    /* renamed from: a */
    public static void m7a(RemoteInputCompatBase.RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        RemoteInput.addResultsToIntent(m8a(remoteInputArr), intent, bundle);
    }
}
