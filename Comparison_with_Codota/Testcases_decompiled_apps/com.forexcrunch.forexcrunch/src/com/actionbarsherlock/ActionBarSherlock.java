package com.actionbarsherlock;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;

public abstract class ActionBarSherlock {
    private static final Class<?>[] CONSTRUCTOR_ARGS = {Activity.class, Integer.TYPE};
    public static final int FLAG_DELEGATE = 1;
    private static final HashMap<Implementation, Class<? extends ActionBarSherlock>> IMPLEMENTATIONS = new HashMap<>();
    protected static final String TAG = "ActionBarSherlock";
    protected final Activity mActivity;
    protected final boolean mIsDelegate;
    protected MenuInflater mMenuInflater;

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Implementation {
        public static final int DEFAULT_API = -1;
        public static final int DEFAULT_DPI = -1;

        int api() default -1;

        int dpi() default -1;
    }

    public interface OnActionModeFinishedListener {
        void onActionModeFinished(ActionMode actionMode);
    }

    public interface OnActionModeStartedListener {
        void onActionModeStarted(ActionMode actionMode);
    }

    public interface OnCreateOptionsMenuListener {
        boolean onCreateOptionsMenu(Menu menu);
    }

    public interface OnCreatePanelMenuListener {
        boolean onCreatePanelMenu(int i, Menu menu);
    }

    public interface OnMenuItemSelectedListener {
        boolean onMenuItemSelected(int i, MenuItem menuItem);
    }

    public interface OnOptionsItemSelectedListener {
        boolean onOptionsItemSelected(MenuItem menuItem);
    }

    public interface OnPrepareOptionsMenuListener {
        boolean onPrepareOptionsMenu(Menu menu);
    }

    public interface OnPreparePanelListener {
        boolean onPreparePanel(int i, View view, Menu menu);
    }

    public abstract void addContentView(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean dispatchCreateOptionsMenu(android.view.Menu menu);

    public abstract void dispatchInvalidateOptionsMenu();

    public abstract boolean dispatchOptionsItemSelected(android.view.MenuItem menuItem);

    public abstract boolean dispatchPrepareOptionsMenu(android.view.Menu menu);

    public abstract ActionBar getActionBar();

    /* access modifiers changed from: protected */
    public abstract Context getThemedContext();

    public abstract boolean hasFeature(int i);

    public abstract boolean requestFeature(int i);

    public abstract void setContentView(int i);

    public abstract void setContentView(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void setProgress(int i);

    public abstract void setProgressBarIndeterminate(boolean z);

    public abstract void setProgressBarIndeterminateVisibility(boolean z);

    public abstract void setProgressBarVisibility(boolean z);

    public abstract void setSecondaryProgress(int i);

    public abstract void setTitle(CharSequence charSequence);

    public abstract void setUiOptions(int i);

    public abstract void setUiOptions(int i, int i2);

    public abstract ActionMode startActionMode(ActionMode.Callback callback);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 2
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<android.app.Activity> r2 = android.app.Activity.class
            r0[r1] = r2
            r1 = 1
            java.lang.Class r2 = java.lang.Integer.TYPE
            r0[r1] = r2
            CONSTRUCTOR_ARGS = r0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            IMPLEMENTATIONS = r0
            java.lang.Class<com.actionbarsherlock.internal.ActionBarSherlockCompat> r0 = com.actionbarsherlock.internal.ActionBarSherlockCompat.class
            registerImplementation(r0)
            java.lang.Class<com.actionbarsherlock.internal.ActionBarSherlockNative> r0 = com.actionbarsherlock.internal.ActionBarSherlockNative.class
            registerImplementation(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.actionbarsherlock.ActionBarSherlock.<clinit>():void");
    }

    public static void registerImplementation(Class<? extends ActionBarSherlock> implementationClass) {
        if (!implementationClass.isAnnotationPresent(Implementation.class)) {
            throw new IllegalArgumentException("Class " + implementationClass.getSimpleName() + " is not annotated with @Implementation");
        } else if (IMPLEMENTATIONS.containsValue(implementationClass)) {
            Log.w(TAG, "Class " + implementationClass.getSimpleName() + " already registered");
        } else {
            Implementation impl = (Implementation) implementationClass.getAnnotation(Implementation.class);
            Log.i(TAG, "Registering " + implementationClass.getSimpleName() + " with qualifier " + impl);
            IMPLEMENTATIONS.put(impl, implementationClass);
        }
    }

    public static boolean unregisterImplementation(Class<? extends ActionBarSherlock> implementationClass) {
        return IMPLEMENTATIONS.values().remove(implementationClass);
    }

    public static ActionBarSherlock wrap(Activity activity) {
        return wrap(activity, 0);
    }

    public static ActionBarSherlock wrap(Activity activity, int flags) {
        HashMap<Implementation, Class<? extends ActionBarSherlock>> impls = new HashMap<>(IMPLEMENTATIONS);
        boolean hasQualfier = false;
        Iterator<Implementation> it = impls.keySet().iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().dpi() == 213) {
                    hasQualfier = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (hasQualfier) {
            boolean isTvDpi = activity.getResources().getDisplayMetrics().densityDpi == 213;
            Iterator<Implementation> keys = impls.keySet().iterator();
            while (keys.hasNext()) {
                int keyDpi = keys.next().dpi();
                if ((isTvDpi && keyDpi != 213) || (!isTvDpi && keyDpi == 213)) {
                    keys.remove();
                }
            }
        }
        boolean hasQualfier2 = false;
        Iterator<Implementation> it2 = impls.keySet().iterator();
        while (true) {
            if (it2.hasNext()) {
                if (it2.next().api() != -1) {
                    hasQualfier2 = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (hasQualfier2) {
            int runtimeApi = Build.VERSION.SDK_INT;
            int bestApi = 0;
            Iterator<Implementation> keys2 = impls.keySet().iterator();
            while (keys2.hasNext()) {
                int keyApi = keys2.next().api();
                if (keyApi > runtimeApi) {
                    keys2.remove();
                } else if (keyApi > bestApi) {
                    bestApi = keyApi;
                }
            }
            Iterator<Implementation> keys3 = impls.keySet().iterator();
            while (keys3.hasNext()) {
                if (keys3.next().api() != bestApi) {
                    keys3.remove();
                }
            }
        }
        if (impls.size() > 1) {
            throw new IllegalStateException("More than one implementation matches configuration.");
        } else if (impls.isEmpty()) {
            throw new IllegalStateException("No implementations match configuration.");
        } else {
            Class<? extends ActionBarSherlock> impl = impls.values().iterator().next();
            Log.i(TAG, "Using implementation: " + impl.getSimpleName());
            try {
                return (ActionBarSherlock) impl.getConstructor(CONSTRUCTOR_ARGS).newInstance(new Object[]{activity, Integer.valueOf(flags)});
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (IllegalArgumentException e2) {
                throw new RuntimeException(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException(e3);
            } catch (IllegalAccessException e4) {
                throw new RuntimeException(e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException(e5);
            }
        }
    }

    protected ActionBarSherlock(Activity activity, int flags) {
        Log.d(TAG, "[<ctor>] activity: " + activity + ", flags: " + flags);
        this.mActivity = activity;
        this.mIsDelegate = (flags & 1) != 0;
    }

    public void dispatchConfigurationChanged(Configuration newConfig) {
    }

    public void dispatchPostResume() {
    }

    public void dispatchPause() {
    }

    public void dispatchStop() {
    }

    public boolean dispatchOpenOptionsMenu() {
        return false;
    }

    public boolean dispatchCloseOptionsMenu() {
        return false;
    }

    public void dispatchPostCreate(Bundle savedInstanceState) {
    }

    public void dispatchTitleChanged(CharSequence title, int color) {
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        return false;
    }

    public boolean dispatchMenuOpened(int featureId, android.view.Menu menu) {
        return false;
    }

    public void dispatchPanelClosed(int featureId, android.view.Menu menu) {
    }

    public void dispatchDestroy() {
    }

    public void dispatchSaveInstanceState(Bundle outState) {
    }

    public void dispatchRestoreInstanceState(Bundle savedInstanceState) {
    }

    /* access modifiers changed from: protected */
    public final boolean callbackCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "[callbackCreateOptionsMenu] menu: " + menu);
        boolean result = true;
        if (this.mActivity instanceof OnCreatePanelMenuListener) {
            result = ((OnCreatePanelMenuListener) this.mActivity).onCreatePanelMenu(0, menu);
        } else if (this.mActivity instanceof OnCreateOptionsMenuListener) {
            result = ((OnCreateOptionsMenuListener) this.mActivity).onCreateOptionsMenu(menu);
        }
        Log.d(TAG, "[callbackCreateOptionsMenu] returning " + result);
        return result;
    }

    /* access modifiers changed from: protected */
    public final boolean callbackPrepareOptionsMenu(Menu menu) {
        Log.d(TAG, "[callbackPrepareOptionsMenu] menu: " + menu);
        boolean result = true;
        if (this.mActivity instanceof OnPreparePanelListener) {
            result = ((OnPreparePanelListener) this.mActivity).onPreparePanel(0, (View) null, menu);
        } else if (this.mActivity instanceof OnPrepareOptionsMenuListener) {
            result = ((OnPrepareOptionsMenuListener) this.mActivity).onPrepareOptionsMenu(menu);
        }
        Log.d(TAG, "[callbackPrepareOptionsMenu] returning " + result);
        return result;
    }

    /* access modifiers changed from: protected */
    public final boolean callbackOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "[callbackOptionsItemSelected] item: " + item.getTitleCondensed());
        boolean result = false;
        if (this.mActivity instanceof OnMenuItemSelectedListener) {
            result = ((OnMenuItemSelectedListener) this.mActivity).onMenuItemSelected(0, item);
        } else if (this.mActivity instanceof OnOptionsItemSelectedListener) {
            result = ((OnOptionsItemSelectedListener) this.mActivity).onOptionsItemSelected(item);
        }
        Log.d(TAG, "[callbackOptionsItemSelected] returning " + result);
        return result;
    }

    public void setContentView(View view) {
        Log.d(TAG, "[setContentView] view: " + view);
        setContentView(view, new ViewGroup.LayoutParams(-1, -1));
    }

    public void setTitle(int resId) {
        Log.d(TAG, "[setTitle] resId: " + resId);
        setTitle((CharSequence) this.mActivity.getString(resId));
    }

    public MenuInflater getMenuInflater() {
        Log.d(TAG, "[getMenuInflater]");
        if (this.mMenuInflater == null) {
            if (getActionBar() != null) {
                this.mMenuInflater = new MenuInflater(getThemedContext(), this.mActivity);
            } else {
                this.mMenuInflater = new MenuInflater(this.mActivity);
            }
        }
        return this.mMenuInflater;
    }

    public void ensureActionBar() {
    }
}
