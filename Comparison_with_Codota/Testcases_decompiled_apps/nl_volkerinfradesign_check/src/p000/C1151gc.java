package p000;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p001v4.util.ArrayMap;
import android.support.p001v4.view.ViewCompat;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.view.ContextThemeWrapper;
import android.support.p004v7.widget.AppCompatAutoCompleteTextView;
import android.support.p004v7.widget.AppCompatButton;
import android.support.p004v7.widget.AppCompatCheckBox;
import android.support.p004v7.widget.AppCompatCheckedTextView;
import android.support.p004v7.widget.AppCompatEditText;
import android.support.p004v7.widget.AppCompatImageButton;
import android.support.p004v7.widget.AppCompatImageView;
import android.support.p004v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.p004v7.widget.AppCompatRadioButton;
import android.support.p004v7.widget.AppCompatRatingBar;
import android.support.p004v7.widget.AppCompatSeekBar;
import android.support.p004v7.widget.AppCompatSpinner;
import android.support.p004v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* renamed from: gc */
public class C1151gc {

    /* renamed from: a */
    private static final Class<?>[] f4134a = {Context.class, AttributeSet.class};

    /* renamed from: b */
    private static final int[] f4135b = {16843375};

    /* renamed from: c */
    private static final Map<String, Constructor<? extends View>> f4136c = new ArrayMap();

    /* renamed from: d */
    private final Object[] f4137d = new Object[2];

    /* renamed from: a */
    public final View mo8123a(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet, boolean z, boolean z2, boolean z3) {
        Context context2;
        View view2;
        if (!z || view == null) {
            context2 = context;
        } else {
            context2 = view.getContext();
        }
        if (z2 || z3) {
            context2 = m5159a(context2, attributeSet, z2, z3);
        }
        View view3 = null;
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
                view3 = new AppCompatTextView(context2, attributeSet);
                break;
            case 1:
                view3 = new AppCompatImageView(context2, attributeSet);
                break;
            case 2:
                view3 = new AppCompatButton(context2, attributeSet);
                break;
            case 3:
                view3 = new AppCompatEditText(context2, attributeSet);
                break;
            case 4:
                view3 = new AppCompatSpinner(context2, attributeSet);
                break;
            case 5:
                view3 = new AppCompatImageButton(context2, attributeSet);
                break;
            case 6:
                view3 = new AppCompatCheckBox(context2, attributeSet);
                break;
            case 7:
                view3 = new AppCompatRadioButton(context2, attributeSet);
                break;
            case 8:
                view3 = new AppCompatCheckedTextView(context2, attributeSet);
                break;
            case 9:
                view3 = new AppCompatAutoCompleteTextView(context2, attributeSet);
                break;
            case 10:
                view3 = new AppCompatMultiAutoCompleteTextView(context2, attributeSet);
                break;
            case 11:
                view3 = new AppCompatRatingBar(context2, attributeSet);
                break;
            case 12:
                view3 = new AppCompatSeekBar(context2, attributeSet);
                break;
        }
        if (view3 != null || context == context2) {
            view2 = view3;
        } else {
            view2 = m5160a(context2, str, attributeSet);
        }
        if (view2 != null) {
            m5162a(view2, attributeSet);
        }
        return view2;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private View m5160a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue((String) null, "class");
        }
        try {
            this.f4137d[0] = context;
            this.f4137d[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                View a = m5161a(context, str, "android.widget.");
                this.f4137d[0] = null;
                this.f4137d[1] = null;
                return a;
            }
            View a2 = m5161a(context, str, (String) null);
            this.f4137d[0] = null;
            this.f4137d[1] = null;
            return a2;
        } catch (Exception e) {
            this.f4137d[0] = null;
            this.f4137d[1] = null;
            return null;
        } catch (Throwable th) {
            this.f4137d[0] = null;
            this.f4137d[1] = null;
            throw th;
        }
    }

    /* renamed from: a */
    private void m5162a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (ViewCompat.hasOnClickListeners(view) && (context instanceof ContextWrapper)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4135b);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new C1152a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    private View m5161a(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        Constructor<? extends U> constructor = f4136c.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(f4134a);
                f4136c.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f4137d);
    }

    /* renamed from: a */
    private static Context m5159a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        int i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0505R.styleable.View, 0, 0);
        if (z) {
            i = obtainStyledAttributes.getResourceId(C0505R.styleable.View_android_theme, 0);
        } else {
            i = 0;
        }
        if (z2 && i == 0 && (i = obtainStyledAttributes.getResourceId(C0505R.styleable.View_theme, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        int i2 = i;
        obtainStyledAttributes.recycle();
        if (i2 == 0) {
            return context;
        }
        if (!(context instanceof ContextThemeWrapper) || ((ContextThemeWrapper) context).getThemeResId() != i2) {
            return new ContextThemeWrapper(context, i2);
        }
        return context;
    }

    /* renamed from: gc$a */
    static class C1152a implements View.OnClickListener {

        /* renamed from: a */
        private final View f4138a;

        /* renamed from: b */
        private final String f4139b;

        /* renamed from: c */
        private Method f4140c;

        /* renamed from: d */
        private Context f4141d;

        public C1152a(@NonNull View view, @NonNull String str) {
            this.f4138a = view;
            this.f4139b = str;
        }

        public void onClick(@NonNull View view) {
            if (this.f4140c == null) {
                m5164a(this.f4138a.getContext(), this.f4139b);
            }
            try {
                this.f4140c.invoke(this.f4141d, new Object[]{view});
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }

        @NonNull
        /* renamed from: a */
        private void m5164a(@Nullable Context context, @NonNull String str) {
            Method method;
            Context context2 = context;
            while (context2 != null) {
                try {
                    if (!context2.isRestricted() && (method = context2.getClass().getMethod(this.f4139b, new Class[]{View.class})) != null) {
                        this.f4140c = method;
                        this.f4141d = context2;
                        return;
                    }
                } catch (NoSuchMethodException e) {
                }
                if (context2 instanceof ContextWrapper) {
                    context2 = ((ContextWrapper) context2).getBaseContext();
                } else {
                    context2 = null;
                }
            }
            int id = this.f4138a.getId();
            throw new IllegalStateException("Could not find method " + this.f4139b + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.f4138a.getClass() + (id == -1 ? "" : " with id '" + this.f4138a.getContext().getResources().getResourceEntryName(id) + "'"));
        }
    }
}
