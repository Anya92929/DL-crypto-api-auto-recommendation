package p000;

import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

/* renamed from: de */
public class C1042de {
    /* renamed from: a */
    public static void m4640a(TextView textView) {
        textView.setTransformationMethod(new C1043a(textView.getContext()));
    }

    /* renamed from: de$a */
    static class C1043a extends SingleLineTransformationMethod {

        /* renamed from: a */
        private Locale f4055a;

        public C1043a(Context context) {
            this.f4055a = context.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f4055a);
            }
            return null;
        }
    }
}
