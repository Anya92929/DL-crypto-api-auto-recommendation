package android.support.p000v4.app;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.RemoteInputCompatBase;

/* renamed from: android.support.v4.app.RemoteInputCompatJellybean */
class RemoteInputCompatJellybean {
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";

    RemoteInputCompatJellybean() {
    }

    /* renamed from: a */
    static Bundle m593a(Intent intent) {
        ClipData clipData = intent.getClipData();
        if (clipData == null) {
            return null;
        }
        ClipDescription description = clipData.getDescription();
        if (!description.hasMimeType("text/vnd.android.intent") || !description.getLabel().equals("android.remoteinput.results")) {
            return null;
        }
        return (Bundle) clipData.getItemAt(0).getIntent().getExtras().getParcelable("android.remoteinput.resultsData");
    }

    /* renamed from: a */
    static Bundle m594a(RemoteInputCompatBase.RemoteInput remoteInput) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", remoteInput.getResultKey());
        bundle.putCharSequence("label", remoteInput.getLabel());
        bundle.putCharSequenceArray("choices", remoteInput.getChoices());
        bundle.putBoolean("allowFreeFormInput", remoteInput.getAllowFreeFormInput());
        bundle.putBundle("extras", remoteInput.getExtras());
        return bundle;
    }

    /* renamed from: a */
    static RemoteInputCompatBase.RemoteInput m595a(Bundle bundle, RemoteInputCompatBase.RemoteInput.Factory factory) {
        return factory.build(bundle.getString("resultKey"), bundle.getCharSequence("label"), bundle.getCharSequenceArray("choices"), bundle.getBoolean("allowFreeFormInput"), bundle.getBundle("extras"));
    }

    /* renamed from: a */
    static void m596a(RemoteInputCompatBase.RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        for (RemoteInputCompatBase.RemoteInput remoteInput : remoteInputArr) {
            Object obj = bundle.get(remoteInput.getResultKey());
            if (obj instanceof CharSequence) {
                bundle2.putCharSequence(remoteInput.getResultKey(), (CharSequence) obj);
            }
        }
        Intent intent2 = new Intent();
        intent2.putExtra("android.remoteinput.resultsData", bundle2);
        intent.setClipData(ClipData.newIntent("android.remoteinput.results", intent2));
    }

    /* renamed from: a */
    static Bundle[] m597a(RemoteInputCompatBase.RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            bundleArr[i] = m594a(remoteInputArr[i]);
        }
        return bundleArr;
    }

    /* renamed from: a */
    static RemoteInputCompatBase.RemoteInput[] m598a(Bundle[] bundleArr, RemoteInputCompatBase.RemoteInput.Factory factory) {
        if (bundleArr == null) {
            return null;
        }
        RemoteInputCompatBase.RemoteInput[] newArray = factory.newArray(bundleArr.length);
        for (int i = 0; i < bundleArr.length; i++) {
            newArray[i] = m595a(bundleArr[i], factory);
        }
        return newArray;
    }
}
