package p052pt.lumberapps.lumbliv;

import android.app.Activity;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;

/* renamed from: pt.lumberapps.lumbliv.b */
public class C2081b extends C2082c {
    public C2081b(Activity activity, String str) {
        super(activity, str);
        mo10274a(false);
    }

    /* renamed from: a */
    public void mo10233a() {
    }

    /* renamed from: b */
    public C2081b mo10268b() {
        SpannableString spannableString = new SpannableString(this.f7845i);
        TextView textView = this.f7842f;
        textView.setText(this.f7845i);
        textView.setAutoLinkMask(-1);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        Linkify.addLinks(spannableString, 15);
        return mo10271e();
    }

    /* renamed from: c */
    public C2081b mo10269c() {
        return mo10271e();
    }

    /* renamed from: d */
    public C2081b mo10271e() {
        super.mo10271e();
        return this;
    }
}
