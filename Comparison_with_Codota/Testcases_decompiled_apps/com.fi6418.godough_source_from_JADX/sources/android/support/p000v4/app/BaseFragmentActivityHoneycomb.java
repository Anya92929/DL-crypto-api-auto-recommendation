package android.support.p000v4.app;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: android.support.v4.app.BaseFragmentActivityHoneycomb */
abstract class BaseFragmentActivityHoneycomb extends BaseFragmentActivityDonut {
    BaseFragmentActivityHoneycomb() {
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a = mo462a(view, str, context, attributeSet);
        return (a != null || Build.VERSION.SDK_INT < 11) ? a : super.onCreateView(view, str, context, attributeSet);
    }
}
