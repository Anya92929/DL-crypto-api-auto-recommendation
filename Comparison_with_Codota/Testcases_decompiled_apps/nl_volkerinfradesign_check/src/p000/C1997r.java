package p000;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: r */
public abstract class C1997r extends C1996q {
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a = mo310a(view, str, context, attributeSet);
        if (a != null || Build.VERSION.SDK_INT < 11) {
            return a;
        }
        return super.onCreateView(view, str, context, attributeSet);
    }
}
