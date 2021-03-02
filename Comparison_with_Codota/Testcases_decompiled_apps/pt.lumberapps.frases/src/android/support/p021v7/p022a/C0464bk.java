package android.support.p021v7.p022a;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.a.bk */
class C0464bk implements View.OnClickListener {

    /* renamed from: a */
    private final View f677a;

    /* renamed from: b */
    private final String f678b;

    /* renamed from: c */
    private Method f679c;

    /* renamed from: d */
    private Context f680d;

    public C0464bk(View view, String str) {
        this.f677a = view;
        this.f678b = str;
    }

    /* renamed from: a */
    private void m1969a(Context context, String str) {
        Method method;
        for (Context context2 = context; context2 != null; context2 = context2 instanceof ContextWrapper ? ((ContextWrapper) context2).getBaseContext() : null) {
            try {
                if (!context2.isRestricted() && (method = context2.getClass().getMethod(this.f678b, new Class[]{View.class})) != null) {
                    this.f679c = method;
                    this.f680d = context2;
                    return;
                }
            } catch (NoSuchMethodException e) {
            }
        }
        int id = this.f677a.getId();
        throw new IllegalStateException("Could not find method " + this.f678b + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.f677a.getClass() + (id == -1 ? "" : " with id '" + this.f677a.getContext().getResources().getResourceEntryName(id) + "'"));
    }

    public void onClick(View view) {
        if (this.f679c == null) {
            m1969a(this.f677a.getContext(), this.f678b);
        }
        try {
            this.f679c.invoke(this.f680d, new Object[]{view});
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        } catch (InvocationTargetException e2) {
            throw new IllegalStateException("Could not execute method for android:onClick", e2);
        }
    }
}
