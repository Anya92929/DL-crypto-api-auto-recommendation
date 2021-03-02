package android.support.p003v7.internal.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* renamed from: android.support.v7.internal.text.AllCapsTransformationMethod */
public class AllCapsTransformationMethod implements TransformationMethod {

    /* renamed from: a */
    private Locale f1971a;

    public AllCapsTransformationMethod(Context context) {
        this.f1971a = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f1971a);
        }
        return null;
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }
}
