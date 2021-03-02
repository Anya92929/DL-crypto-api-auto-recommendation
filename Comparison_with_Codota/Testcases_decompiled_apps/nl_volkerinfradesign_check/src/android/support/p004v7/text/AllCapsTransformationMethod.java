package android.support.p004v7.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* renamed from: android.support.v7.text.AllCapsTransformationMethod */
public class AllCapsTransformationMethod implements TransformationMethod {

    /* renamed from: a */
    private Locale f1628a;

    public AllCapsTransformationMethod(Context context) {
        this.f1628a = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.f1628a);
        }
        return null;
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }
}
