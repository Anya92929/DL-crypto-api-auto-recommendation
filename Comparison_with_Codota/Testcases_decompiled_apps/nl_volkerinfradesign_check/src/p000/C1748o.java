package p000;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

/* renamed from: o */
public class C1748o {

    /* renamed from: a */
    private final ActivityOptions f5680a;

    /* renamed from: a */
    public static C1748o m6478a(Activity activity, View view, String str) {
        return new C1748o(ActivityOptions.makeSceneTransitionAnimation(activity, view, str));
    }

    /* renamed from: a */
    public static C1748o m6479a(Activity activity, View[] viewArr, String[] strArr) {
        Pair[] pairArr = null;
        if (viewArr != null) {
            Pair[] pairArr2 = new Pair[viewArr.length];
            for (int i = 0; i < pairArr2.length; i++) {
                pairArr2[i] = Pair.create(viewArr[i], strArr[i]);
            }
            pairArr = pairArr2;
        }
        return new C1748o(ActivityOptions.makeSceneTransitionAnimation(activity, pairArr));
    }

    private C1748o(ActivityOptions activityOptions) {
        this.f5680a = activityOptions;
    }

    /* renamed from: a */
    public Bundle mo10511a() {
        return this.f5680a.toBundle();
    }

    /* renamed from: a */
    public void mo10512a(C1748o oVar) {
        this.f5680a.update(oVar.f5680a);
    }
}
