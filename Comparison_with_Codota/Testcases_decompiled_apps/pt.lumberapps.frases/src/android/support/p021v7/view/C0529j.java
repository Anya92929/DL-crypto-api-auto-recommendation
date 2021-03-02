package android.support.p021v7.view;

import android.view.InflateException;
import android.view.MenuItem;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.view.j */
class C0529j implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    private static final Class[] f918a = {MenuItem.class};

    /* renamed from: b */
    private Object f919b;

    /* renamed from: c */
    private Method f920c;

    public C0529j(Object obj, String str) {
        this.f919b = obj;
        Class<?> cls = obj.getClass();
        try {
            this.f920c = cls.getMethod(str, f918a);
        } catch (Exception e) {
            InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
            inflateException.initCause(e);
            throw inflateException;
        }
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        try {
            if (this.f920c.getReturnType() == Boolean.TYPE) {
                return ((Boolean) this.f920c.invoke(this.f919b, new Object[]{menuItem})).booleanValue();
            }
            this.f920c.invoke(this.f919b, new Object[]{menuItem});
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
