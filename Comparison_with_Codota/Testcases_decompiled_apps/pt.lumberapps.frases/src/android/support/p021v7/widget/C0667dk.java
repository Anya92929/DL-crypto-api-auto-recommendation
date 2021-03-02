package android.support.p021v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: android.support.v7.widget.dk */
class C0667dk extends ContextWrapper {

    /* renamed from: a */
    private static final ArrayList f1643a = new ArrayList();

    /* renamed from: b */
    private Resources f1644b;

    private C0667dk(Context context) {
        super(context);
    }

    /* renamed from: a */
    public static Context m3010a(Context context) {
        if (context instanceof C0667dk) {
            return context;
        }
        int size = f1643a.size();
        for (int i = 0; i < size; i++) {
            WeakReference weakReference = (WeakReference) f1643a.get(i);
            C0667dk dkVar = weakReference != null ? (C0667dk) weakReference.get() : null;
            if (dkVar != null && dkVar.getBaseContext() == context) {
                return dkVar;
            }
        }
        C0667dk dkVar2 = new C0667dk(context);
        f1643a.add(new WeakReference(dkVar2));
        return dkVar2;
    }

    public Resources getResources() {
        if (this.f1644b == null) {
            this.f1644b = new C0669dm(this, super.getResources());
        }
        return this.f1644b;
    }
}
