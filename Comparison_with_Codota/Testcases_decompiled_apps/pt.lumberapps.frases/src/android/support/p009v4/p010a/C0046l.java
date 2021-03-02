package android.support.p009v4.p010a;

import android.content.ComponentName;
import android.content.Intent;

/* renamed from: android.support.v4.a.l */
class C0046l implements C0045k {
    C0046l() {
    }

    /* renamed from: a */
    public Intent mo131a(ComponentName componentName) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setComponent(componentName);
        intent.addCategory("android.intent.category.LAUNCHER");
        return intent;
    }
}
