package android.support.p021v7.widget;

import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.widget.db */
class C0658db {

    /* renamed from: a */
    private Method f1609a;

    /* renamed from: b */
    private Method f1610b;

    /* renamed from: c */
    private Method f1611c;

    /* renamed from: d */
    private Method f1612d;

    C0658db() {
        try {
            this.f1609a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
            this.f1609a.setAccessible(true);
        } catch (NoSuchMethodException e) {
        }
        try {
            this.f1610b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
            this.f1610b.setAccessible(true);
        } catch (NoSuchMethodException e2) {
        }
        Class<AutoCompleteTextView> cls = AutoCompleteTextView.class;
        try {
            this.f1611c = cls.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
            this.f1611c.setAccessible(true);
        } catch (NoSuchMethodException e3) {
        }
        Class<InputMethodManager> cls2 = InputMethodManager.class;
        try {
            this.f1612d = cls2.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
            this.f1612d.setAccessible(true);
        } catch (NoSuchMethodException e4) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3297a(AutoCompleteTextView autoCompleteTextView) {
        if (this.f1609a != null) {
            try {
                this.f1609a.invoke(autoCompleteTextView, new Object[0]);
            } catch (Exception e) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3298a(AutoCompleteTextView autoCompleteTextView, boolean z) {
        if (this.f1611c != null) {
            try {
                this.f1611c.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3299b(AutoCompleteTextView autoCompleteTextView) {
        if (this.f1610b != null) {
            try {
                this.f1610b.invoke(autoCompleteTextView, new Object[0]);
            } catch (Exception e) {
            }
        }
    }
}
