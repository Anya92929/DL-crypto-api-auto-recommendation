package android.support.p021v7.p022a;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.p021v7.p023b.C0506b;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;

/* renamed from: android.support.v7.a.ae */
public class C0431ae extends C0462bi implements DialogInterface {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C0495q f581a = new C0495q(getContext(), this, getWindow());

    C0431ae(Context context, int i, boolean z) {
        super(context, m1786a(context, i));
    }

    /* renamed from: a */
    static int m1786a(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0506b.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f581a.mo2116a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f581a.mo2122a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f581a.mo2125b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void setCustomTitle(View view) {
        this.f581a.setCustomTitle(view);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f581a.mo2121a(charSequence);
    }

    public void setView(View view) {
        this.f581a.setView(view);
    }
}
