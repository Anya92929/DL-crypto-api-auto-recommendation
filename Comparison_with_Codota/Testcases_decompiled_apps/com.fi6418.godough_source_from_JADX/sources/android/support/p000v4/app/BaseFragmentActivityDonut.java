package android.support.p000v4.app;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: android.support.v4.app.BaseFragmentActivityDonut */
abstract class BaseFragmentActivityDonut extends Activity {
    BaseFragmentActivityDonut() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract View mo462a(View view, String str, Context context, AttributeSet attributeSet);

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT < 11 && getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View a = mo462a((View) null, str, context, attributeSet);
        return a == null ? super.onCreateView(str, context, attributeSet) : a;
    }
}
