package android.support.p021v7.p022a;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.p009v4.p019f.C0136a;
import android.support.p009v4.view.C0247by;
import android.support.p021v7.p023b.C0515k;
import android.support.p021v7.view.C0524e;
import android.support.p021v7.widget.C0584ai;
import android.support.p021v7.widget.C0586ak;
import android.support.p021v7.widget.C0587al;
import android.support.p021v7.widget.C0588am;
import android.support.p021v7.widget.C0597av;
import android.support.p021v7.widget.C0598aw;
import android.support.p021v7.widget.C0600ay;
import android.support.p021v7.widget.C0601az;
import android.support.p021v7.widget.C0606bd;
import android.support.p021v7.widget.C0607be;
import android.support.p021v7.widget.C0608bf;
import android.support.p021v7.widget.C0610bh;
import android.support.p021v7.widget.C0619bq;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.Map;

/* renamed from: android.support.v7.a.bj */
class C0463bj {

    /* renamed from: a */
    private static final Class[] f672a = {Context.class, AttributeSet.class};

    /* renamed from: b */
    private static final int[] f673b = {16843375};

    /* renamed from: c */
    private static final String[] f674c = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: d */
    private static final Map f675d = new C0136a();

    /* renamed from: e */
    private final Object[] f676e = new Object[2];

    C0463bj() {
    }

    /* renamed from: a */
    private static Context m1964a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0515k.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(C0515k.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(C0515k.View_theme, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        int i = resourceId;
        obtainStyledAttributes.recycle();
        return i != 0 ? (!(context instanceof C0524e) || ((C0524e) context).mo2199a() != i) ? new C0524e(context, i) : context : context;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private View m1965a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue((String) null, "class");
        }
        try {
            this.f676e[0] = context;
            this.f676e[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                for (String a : f674c) {
                    View a2 = m1966a(context, str, a);
                    if (a2 != null) {
                        this.f676e[0] = null;
                        this.f676e[1] = null;
                        return a2;
                    }
                }
                this.f676e[0] = null;
                this.f676e[1] = null;
                return null;
            }
            View a3 = m1966a(context, str, (String) null);
            this.f676e[0] = null;
            this.f676e[1] = null;
            return a3;
        } catch (Exception e) {
            this.f676e[0] = null;
            this.f676e[1] = null;
            return null;
        } catch (Throwable th) {
            this.f676e[0] = null;
            this.f676e[1] = null;
            throw th;
        }
    }

    /* renamed from: a */
    private View m1966a(Context context, String str, String str2) {
        Constructor<? extends U> constructor = (Constructor) f675d.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(f672a);
                f675d.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f676e);
    }

    /* renamed from: a */
    private void m1967a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (Build.VERSION.SDK_INT < 15 || C0247by.m926s(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f673b);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new C0464bk(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    public final View mo2064a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3) {
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = m1964a(context2, attributeSet, z2, z3);
        }
        View view2 = null;
        char c = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c = 11;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c = 8;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c = 10;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c = 0;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c = 12;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c = 4;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c = 7;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c = 1;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c = 9;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c = 6;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c = 3;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                view2 = new C0619bq(context2, attributeSet);
                break;
            case 1:
                view2 = new C0600ay(context2, attributeSet);
                break;
            case 2:
                view2 = new C0586ak(context2, attributeSet);
                break;
            case 3:
                view2 = new C0597av(context2, attributeSet);
                break;
            case 4:
                view2 = new C0610bh(context2, attributeSet);
                break;
            case 5:
                view2 = new C0598aw(context2, attributeSet);
                break;
            case 6:
                view2 = new C0587al(context2, attributeSet);
                break;
            case 7:
                view2 = new C0606bd(context2, attributeSet);
                break;
            case 8:
                view2 = new C0588am(context2, attributeSet);
                break;
            case 9:
                view2 = new C0584ai(context2, attributeSet);
                break;
            case 10:
                view2 = new C0601az(context2, attributeSet);
                break;
            case 11:
                view2 = new C0607be(context2, attributeSet);
                break;
            case 12:
                view2 = new C0608bf(context2, attributeSet);
                break;
        }
        View a = (view2 != null || context == context2) ? view2 : m1965a(context2, str, attributeSet);
        if (a != null) {
            m1967a(a, attributeSet);
        }
        return a;
    }
}
