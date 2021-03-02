package android.support.p000v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.p000v4.app.ActivityCompat;
import android.support.p000v4.app.ActivityCompatApi23;
import android.support.p000v4.util.SimpleArrayMap;
import android.support.p000v4.view.InputDeviceCompat;
import android.support.p000v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.app.FragmentActivity */
public class FragmentActivity extends BaseFragmentActivityHoneycomb implements ActivityCompat.OnRequestPermissionsResultCallback, ActivityCompatApi23.RequestPermissionsRequestCodeValidator {

    /* renamed from: a */
    final Handler f412a = new Handler() {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (FragmentActivity.this.f416e) {
                        FragmentActivity.this.mo607a(false);
                        return;
                    }
                    return;
                case 2:
                    FragmentActivity.this.mo606a();
                    FragmentActivity.this.f413b.execPendingActions();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    };

    /* renamed from: b */
    final FragmentController f413b = FragmentController.createController(new HostCallbacks());

    /* renamed from: c */
    boolean f414c;

    /* renamed from: d */
    boolean f415d;

    /* renamed from: e */
    boolean f416e;

    /* renamed from: f */
    boolean f417f;

    /* renamed from: g */
    boolean f418g;

    /* renamed from: h */
    boolean f419h;

    /* renamed from: i */
    boolean f420i;

    /* renamed from: android.support.v4.app.FragmentActivity$HostCallbacks */
    class HostCallbacks extends FragmentHostCallback<FragmentActivity> {
        public HostCallbacks() {
            super(FragmentActivity.this);
        }

        public void onAttachFragment(Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        public void onDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        public View onFindViewById(int i) {
            return FragmentActivity.this.findViewById(i);
        }

        public FragmentActivity onGetHost() {
            return FragmentActivity.this;
        }

        public LayoutInflater onGetLayoutInflater() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        public int onGetWindowAnimations() {
            Window window = FragmentActivity.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        public boolean onHasView() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        public boolean onHasWindowAnimations() {
            return FragmentActivity.this.getWindow() != null;
        }

        public void onRequestPermissionsFromFragment(Fragment fragment, String[] strArr, int i) {
            FragmentActivity.this.m459a(fragment, strArr, i);
        }

        public boolean onShouldSaveFragmentState(Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        public boolean onShouldShowRequestPermissionRationale(String str) {
            return ActivityCompat.shouldShowRequestPermissionRationale(FragmentActivity.this, str);
        }

        public void onStartActivityFromFragment(Fragment fragment, Intent intent, int i) {
            FragmentActivity.this.startActivityFromFragment(fragment, intent, i);
        }

        public void onSupportInvalidateOptionsMenu() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }
    }

    /* renamed from: android.support.v4.app.FragmentActivity$NonConfigurationInstances */
    final class NonConfigurationInstances {

        /* renamed from: a */
        Object f423a;

        /* renamed from: b */
        List<Fragment> f424b;

        /* renamed from: c */
        SimpleArrayMap<String, LoaderManager> f425c;

        NonConfigurationInstances() {
        }
    }

    /* renamed from: a */
    private static String m458a(View view) {
        String str;
        char c = 'F';
        char c2 = '.';
        StringBuilder sb = new StringBuilder(128);
        sb.append(view.getClass().getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(view)));
        sb.append(' ');
        switch (view.getVisibility()) {
            case 0:
                sb.append('V');
                break;
            case 4:
                sb.append('I');
                break;
            case 8:
                sb.append('G');
                break;
            default:
                sb.append('.');
                break;
        }
        sb.append(view.isFocusable() ? 'F' : '.');
        sb.append(view.isEnabled() ? 'E' : '.');
        sb.append(view.willNotDraw() ? '.' : 'D');
        sb.append(view.isHorizontalScrollBarEnabled() ? 'H' : '.');
        sb.append(view.isVerticalScrollBarEnabled() ? 'V' : '.');
        sb.append(view.isClickable() ? 'C' : '.');
        sb.append(view.isLongClickable() ? 'L' : '.');
        sb.append(' ');
        if (!view.isFocused()) {
            c = '.';
        }
        sb.append(c);
        sb.append(view.isSelected() ? 'S' : '.');
        if (view.isPressed()) {
            c2 = 'P';
        }
        sb.append(c2);
        sb.append(' ');
        sb.append(view.getLeft());
        sb.append(',');
        sb.append(view.getTop());
        sb.append('-');
        sb.append(view.getRight());
        sb.append(',');
        sb.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            sb.append(" #");
            sb.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                switch (-16777216 & id) {
                    case ViewCompat.MEASURED_STATE_TOO_SMALL /*16777216*/:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (Resources.NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                sb.append(" ");
                sb.append(str);
                sb.append(":");
                sb.append(resourceTypeName);
                sb.append("/");
                sb.append(resourceEntryName);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m459a(Fragment fragment, String[] strArr, int i) {
        if (i == -1) {
            ActivityCompat.requestPermissions(this, strArr, i);
        } else if ((i & InputDeviceCompat.SOURCE_ANY) != 0) {
            throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
        } else {
            this.f420i = true;
            ActivityCompat.requestPermissions(this, strArr, ((fragment.f399p + 1) << 8) + (i & 255));
        }
    }

    /* renamed from: a */
    private void m461a(String str, PrintWriter printWriter, View view) {
        ViewGroup viewGroup;
        int childCount;
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(m458a(view));
        if ((view instanceof ViewGroup) && (childCount = viewGroup.getChildCount()) > 0) {
            String str2 = str + "  ";
            for (int i = 0; i < childCount; i++) {
                m461a(str2, printWriter, (viewGroup = (ViewGroup) view).getChildAt(i));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final View mo462a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f413b.onCreateView(view, str, context, attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo606a() {
        this.f413b.dispatchResume();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo607a(boolean z) {
        if (!this.f417f) {
            this.f417f = true;
            this.f418g = z;
            this.f412a.removeMessages(1);
            mo609b();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo608a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo609b() {
        this.f413b.doLoaderStop(this.f418g);
        this.f413b.dispatchReallyStop();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 11) {
        }
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f414c);
        printWriter.print("mResumed=");
        printWriter.print(this.f415d);
        printWriter.print(" mStopped=");
        printWriter.print(this.f416e);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.f417f);
        this.f413b.dumpLoaders(str2, fileDescriptor, printWriter, strArr);
        this.f413b.getSupportFragmentManager().dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        m461a(str + "  ", printWriter, getWindow().getDecorView());
    }

    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            return nonConfigurationInstances.f423a;
        }
        return null;
    }

    public FragmentManager getSupportFragmentManager() {
        return this.f413b.getSupportFragmentManager();
    }

    public LoaderManager getSupportLoaderManager() {
        return this.f413b.getSupportLoaderManager();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        this.f413b.noteStateNotSaved();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            int activeFragmentsCount = this.f413b.getActiveFragmentsCount();
            if (activeFragmentsCount == 0 || i4 < 0 || i4 >= activeFragmentsCount) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = this.f413b.getActiveFragments(new ArrayList(activeFragmentsCount)).get(i4);
            if (fragment == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
            } else {
                fragment.onActivityResult(65535 & i, i2, intent);
            }
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public void onBackPressed() {
        if (!this.f413b.getSupportFragmentManager().popBackStackImmediate()) {
            supportFinishAfterTransition();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f413b.dispatchConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.f413b.attachHost((Fragment) null);
        super.onCreate(bundle);
        NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            this.f413b.restoreLoaderNonConfig(nonConfigurationInstances.f425c);
        }
        if (bundle != null) {
            this.f413b.restoreAllState(bundle.getParcelable("android:support:fragments"), nonConfigurationInstances != null ? nonConfigurationInstances.f424b : null);
        }
        this.f413b.dispatchCreate();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.f413b.dispatchCreateOptionsMenu(menu, getMenuInflater());
        if (Build.VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        mo607a(false);
        this.f413b.dispatchDestroy();
        this.f413b.doLoaderDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f413b.dispatchLowMemory();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.f413b.dispatchOptionsItemSelected(menuItem);
            case 6:
                return this.f413b.dispatchContextItemSelected(menuItem);
            default:
                return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f413b.noteStateNotSaved();
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.f413b.dispatchOptionsMenuClosed(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f415d = false;
        if (this.f412a.hasMessages(2)) {
            this.f412a.removeMessages(2);
            mo606a();
        }
        this.f413b.dispatchPause();
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        this.f412a.removeMessages(2);
        mo606a();
        this.f413b.execPendingActions();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.f419h) {
            this.f419h = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return mo608a(view, menu) | this.f413b.dispatchPrepareOptionsMenu(menu);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 8) & 255;
        if (i2 != 0) {
            int i3 = i2 - 1;
            int activeFragmentsCount = this.f413b.getActiveFragmentsCount();
            if (activeFragmentsCount == 0 || i3 < 0 || i3 >= activeFragmentsCount) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = this.f413b.getActiveFragments(new ArrayList(activeFragmentsCount)).get(i3);
            if (fragment == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
            } else {
                fragment.onRequestPermissionsResult(i & 255, strArr, iArr);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f412a.sendEmptyMessage(2);
        this.f415d = true;
        this.f413b.execPendingActions();
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.f416e) {
            mo607a(true);
        }
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        List<Fragment> retainNonConfig = this.f413b.retainNonConfig();
        SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig = this.f413b.retainLoaderNonConfig();
        if (retainNonConfig == null && retainLoaderNonConfig == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        NonConfigurationInstances nonConfigurationInstances = new NonConfigurationInstances();
        nonConfigurationInstances.f423a = onRetainCustomNonConfigurationInstance;
        nonConfigurationInstances.f424b = retainNonConfig;
        nonConfigurationInstances.f425c = retainLoaderNonConfig;
        return nonConfigurationInstances;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable saveAllState = this.f413b.saveAllState();
        if (saveAllState != null) {
            bundle.putParcelable("android:support:fragments", saveAllState);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f416e = false;
        this.f417f = false;
        this.f412a.removeMessages(1);
        if (!this.f414c) {
            this.f414c = true;
            this.f413b.dispatchActivityCreated();
        }
        this.f413b.noteStateNotSaved();
        this.f413b.execPendingActions();
        this.f413b.doLoaderStart();
        this.f413b.dispatchStart();
        this.f413b.reportLoaderStart();
    }

    public void onStateNotSaved() {
        this.f413b.noteStateNotSaved();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.f416e = true;
        this.f412a.sendEmptyMessage(1);
        this.f413b.dispatchStop();
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.setEnterSharedElementCallback(this, sharedElementCallback);
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.setExitSharedElementCallback(this, sharedElementCallback);
    }

    public void startActivityForResult(Intent intent, int i) {
        if (i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        if (i == -1) {
            super.startActivityForResult(intent, -1);
        } else if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            super.startActivityForResult(intent, ((fragment.f399p + 1) << 16) + (65535 & i));
        }
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.finishAfterTransition(this);
    }

    public void supportInvalidateOptionsMenu() {
        if (Build.VERSION.SDK_INT >= 11) {
            ActivityCompatHoneycomb.m400a(this);
        } else {
            this.f419h = true;
        }
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition(this);
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition(this);
    }

    public final void validateRequestPermissionsRequestCode(int i) {
        if (this.f420i) {
            this.f420i = false;
        } else if ((i & InputDeviceCompat.SOURCE_ANY) != 0) {
            throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
        }
    }
}
