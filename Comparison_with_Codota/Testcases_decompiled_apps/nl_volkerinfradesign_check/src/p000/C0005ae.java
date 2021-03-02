package p000;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Bundle;
import android.support.p001v4.app.RemoteInput;
import android.support.p001v4.app.RemoteInputCompatBase;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;

/* renamed from: ae */
public class C0005ae {
    /* renamed from: a */
    static RemoteInputCompatBase.RemoteInput m12a(Bundle bundle, RemoteInputCompatBase.RemoteInput.Factory factory) {
        return factory.build(bundle.getString("resultKey"), bundle.getCharSequence("label"), bundle.getCharSequenceArray(InspectionItemConstants.CHOICES), bundle.getBoolean("allowFreeFormInput"), bundle.getBundle("extras"));
    }

    /* renamed from: a */
    static Bundle m11a(RemoteInputCompatBase.RemoteInput remoteInput) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", remoteInput.getResultKey());
        bundle.putCharSequence("label", remoteInput.getLabel());
        bundle.putCharSequenceArray(InspectionItemConstants.CHOICES, remoteInput.getChoices());
        bundle.putBoolean("allowFreeFormInput", remoteInput.getAllowFreeFormInput());
        bundle.putBundle("extras", remoteInput.getExtras());
        return bundle;
    }

    /* renamed from: a */
    public static RemoteInputCompatBase.RemoteInput[] m15a(Bundle[] bundleArr, RemoteInputCompatBase.RemoteInput.Factory factory) {
        if (bundleArr == null) {
            return null;
        }
        RemoteInputCompatBase.RemoteInput[] newArray = factory.newArray(bundleArr.length);
        for (int i = 0; i < bundleArr.length; i++) {
            newArray[i] = m12a(bundleArr[i], factory);
        }
        return newArray;
    }

    /* renamed from: a */
    public static Bundle[] m14a(RemoteInputCompatBase.RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            bundleArr[i] = m11a(remoteInputArr[i]);
        }
        return bundleArr;
    }

    /* renamed from: a */
    public static Bundle m10a(Intent intent) {
        ClipData clipData = intent.getClipData();
        if (clipData == null) {
            return null;
        }
        ClipDescription description = clipData.getDescription();
        if (!description.hasMimeType("text/vnd.android.intent") || !description.getLabel().equals(RemoteInput.RESULTS_CLIP_LABEL)) {
            return null;
        }
        return (Bundle) clipData.getItemAt(0).getIntent().getExtras().getParcelable(RemoteInput.EXTRA_RESULTS_DATA);
    }

    /* renamed from: a */
    public static void m13a(RemoteInputCompatBase.RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        for (RemoteInputCompatBase.RemoteInput remoteInput : remoteInputArr) {
            Object obj = bundle.get(remoteInput.getResultKey());
            if (obj instanceof CharSequence) {
                bundle2.putCharSequence(remoteInput.getResultKey(), (CharSequence) obj);
            }
        }
        Intent intent2 = new Intent();
        intent2.putExtra(RemoteInput.EXTRA_RESULTS_DATA, bundle2);
        intent.setClipData(ClipData.newIntent(RemoteInput.RESULTS_CLIP_LABEL, intent2));
    }
}
