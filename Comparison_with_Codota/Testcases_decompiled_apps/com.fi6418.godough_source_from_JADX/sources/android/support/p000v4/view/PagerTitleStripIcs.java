package android.support.p000v4.view;

import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

/* renamed from: android.support.v4.view.PagerTitleStripIcs */
class PagerTitleStripIcs {

    /* renamed from: android.support.v4.view.PagerTitleStripIcs$SingleLineAllCapsTransform */
    class SingleLineAllCapsTransform extends SingleLineTransformationMethod {

        /* renamed from: a */
        private Locale f1239a;

        public SingleLineAllCapsTransform(Context context) {
            this.f1239a = context.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f1239a);
            }
            return null;
        }
    }

    PagerTitleStripIcs() {
    }

    public static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new SingleLineAllCapsTransform(textView.getContext()));
    }
}
