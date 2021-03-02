package android.support.p003v7.internal.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p000v4.util.ArrayMap;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.view.ContextThemeWrapper;
import android.support.p003v7.widget.AppCompatAutoCompleteTextView;
import android.support.p003v7.widget.AppCompatButton;
import android.support.p003v7.widget.AppCompatCheckBox;
import android.support.p003v7.widget.AppCompatCheckedTextView;
import android.support.p003v7.widget.AppCompatEditText;
import android.support.p003v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.p003v7.widget.AppCompatRadioButton;
import android.support.p003v7.widget.AppCompatRatingBar;
import android.support.p003v7.widget.AppCompatSpinner;
import android.support.p003v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.Map;

/* renamed from: android.support.v7.internal.app.AppCompatViewInflater */
public class AppCompatViewInflater {

    /* renamed from: a */
    static final Class<?>[] f1898a = {Context.class, AttributeSet.class};

    /* renamed from: b */
    private static final Map<String, Constructor<? extends View>> f1899b = new ArrayMap();

    /* renamed from: c */
    private final Object[] f1900c = new Object[2];

    /* renamed from: a */
    private static Context m1330a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0235R.styleable.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(C0235R.styleable.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(C0235R.styleable.View_theme, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        int i = resourceId;
        obtainStyledAttributes.recycle();
        return i != 0 ? (!(context instanceof ContextThemeWrapper) || ((ContextThemeWrapper) context).getThemeResId() != i) ? new ContextThemeWrapper(context, i) : context : context;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private View m1331a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue((String) null, "class");
        }
        try {
            this.f1900c[0] = context;
            this.f1900c[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                View a = m1332a(context, str, "android.widget.");
                this.f1900c[0] = null;
                this.f1900c[1] = null;
                return a;
            }
            View a2 = m1332a(context, str, (String) null);
            this.f1900c[0] = null;
            this.f1900c[1] = null;
            return a2;
        } catch (Exception e) {
            this.f1900c[0] = null;
            this.f1900c[1] = null;
            return null;
        } catch (Throwable th) {
            this.f1900c[0] = null;
            this.f1900c[1] = null;
            throw th;
        }
    }

    /* renamed from: a */
    private View m1332a(Context context, String str, String str2) {
        Constructor<? extends U> constructor = f1899b.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(f1898a);
                f1899b.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f1900c);
    }

    public final View createView(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3) {
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = m1330a(context2, attributeSet, z2, z3);
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c = 7;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c = 4;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c = 6;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c = 9;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c = 1;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c = 3;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c = 5;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c = 2;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c = 0;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c = 8;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new AppCompatEditText(context2, attributeSet);
            case 1:
                return new AppCompatSpinner(context2, attributeSet);
            case 2:
                return new AppCompatCheckBox(context2, attributeSet);
            case 3:
                return new AppCompatRadioButton(context2, attributeSet);
            case 4:
                return new AppCompatCheckedTextView(context2, attributeSet);
            case 5:
                return new AppCompatAutoCompleteTextView(context2, attributeSet);
            case 6:
                return new AppCompatMultiAutoCompleteTextView(context2, attributeSet);
            case 7:
                return new AppCompatRatingBar(context2, attributeSet);
            case 8:
                return new AppCompatButton(context2, attributeSet);
            case 9:
                return new AppCompatTextView(context2, attributeSet);
            default:
                if (context != context2) {
                    return m1331a(context2, str, attributeSet);
                }
                return null;
        }
    }
}
