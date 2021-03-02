package android.support.p021v7.p022a;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ListAdapter;

/* renamed from: android.support.v7.a.af */
public class C0432af {

    /* renamed from: a */
    private final C0501w f582a;

    /* renamed from: b */
    private int f583b;

    public C0432af(Context context) {
        this(context, C0431ae.m1786a(context, 0));
    }

    public C0432af(Context context, int i) {
        this.f582a = new C0501w(new ContextThemeWrapper(context, C0431ae.m1786a(context, i)));
        this.f583b = i;
    }

    /* renamed from: a */
    public Context mo1941a() {
        return this.f582a.f842a;
    }

    /* renamed from: a */
    public C0432af mo1942a(DialogInterface.OnKeyListener onKeyListener) {
        this.f582a.f859r = onKeyListener;
        return this;
    }

    /* renamed from: a */
    public C0432af mo1943a(Drawable drawable) {
        this.f582a.f845d = drawable;
        return this;
    }

    /* renamed from: a */
    public C0432af mo1944a(View view) {
        this.f582a.f848g = view;
        return this;
    }

    /* renamed from: a */
    public C0432af mo1945a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        this.f582a.f861t = listAdapter;
        this.f582a.f862u = onClickListener;
        return this;
    }

    /* renamed from: a */
    public C0432af mo1946a(CharSequence charSequence) {
        this.f582a.f847f = charSequence;
        return this;
    }

    /* renamed from: b */
    public C0431ae mo1947b() {
        C0431ae aeVar = new C0431ae(this.f582a.f842a, this.f583b, false);
        this.f582a.mo2134a(aeVar.f581a);
        aeVar.setCancelable(this.f582a.f856o);
        if (this.f582a.f856o) {
            aeVar.setCanceledOnTouchOutside(true);
        }
        aeVar.setOnCancelListener(this.f582a.f857p);
        aeVar.setOnDismissListener(this.f582a.f858q);
        if (this.f582a.f859r != null) {
            aeVar.setOnKeyListener(this.f582a.f859r);
        }
        return aeVar;
    }
}
