package android.support.p001v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p001v4.app.ActivityCompat;
import android.support.p001v4.app.ActivityCompatApi23;
import android.support.p001v4.media.session.MediaControllerCompat;
import android.support.p001v4.util.SimpleArrayMap;
import android.support.p001v4.view.InputDeviceCompat;
import android.support.p001v4.view.ViewCompat;
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
public class FragmentActivity extends C1997r implements ActivityCompat.OnRequestPermissionsResultCallback, ActivityCompatApi23.RequestPermissionsRequestCodeValidator {

    /* renamed from: a */
    final Handler f177a = new Handler() {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (FragmentActivity.this.f181e) {
                        FragmentActivity.this.mo312a(false);
                        return;
                    }
                    return;
                case 2:
                    FragmentActivity.this.onResumeFragments();
                    FragmentActivity.this.f178b.execPendingActions();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    };

    /* renamed from: b */
    final FragmentController f178b = FragmentController.createController(new C0051a());

    /* renamed from: c */
    boolean f179c;

    /* renamed from: d */
    boolean f180d;

    /* renamed from: e */
    boolean f181e;

    /* renamed from: f */
    boolean f182f;

    /* renamed from: g */
    boolean f183g;

    /* renamed from: h */
    boolean f184h;

    /* renamed from: i */
    boolean f185i;

    /* renamed from: j */
    MediaControllerCompat f186j;

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    /* renamed from: android.support.v4.app.FragmentActivity$b */
    static final class C0052b {

        /* renamed from: a */
        Object f189a;

        /* renamed from: b */
        List<Fragment> f190b;

        /* renamed from: c */
        SimpleArrayMap<String, LoaderManager> f191c;

        C0052b() {
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.f178b.noteStateNotSaved();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            int activeFragmentsCount = this.f178b.getActiveFragmentsCount();
            if (activeFragmentsCount == 0 || i4 < 0 || i4 >= activeFragmentsCount) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = this.f178b.getActiveFragments(new ArrayList(activeFragmentsCount)).get(i4);
            if (fragment == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
            } else {
                fragment.onActivityResult(65535 & i, i2, intent);
            }
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        if (!this.f178b.getSupportFragmentManager().popBackStackImmediate()) {
            supportFinishAfterTransition();
        }
    }

    public final void setSupportMediaController(MediaControllerCompat mediaControllerCompat) {
        this.f186j = mediaControllerCompat;
        if (Build.VERSION.SDK_INT >= 21) {
            ActivityCompat21.m99a((Activity) this, mediaControllerCompat.getMediaController());
        }
    }

    public final MediaControllerCompat getSupportMediaController() {
        return this.f186j;
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.finishAfterTransition(this);
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.setEnterSharedElementCallback(this, sharedElementCallback);
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.setExitSharedElementCallback(this, sharedElementCallback);
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition(this);
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f178b.dispatchConfigurationChanged(configuration);
    }

    public void onCreate(@Nullable Bundle bundle) {
        List<Fragment> list;
        this.f178b.attachHost((Fragment) null);
        super.onCreate(bundle);
        C0052b bVar = (C0052b) getLastNonConfigurationInstance();
        if (bVar != null) {
            this.f178b.restoreLoaderNonConfig(bVar.f191c);
        }
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            FragmentController fragmentController = this.f178b;
            if (bVar != null) {
                list = bVar.f190b;
            } else {
                list = null;
            }
            fragmentController.restoreAllState(parcelable, list);
        }
        this.f178b.dispatchCreate();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.f178b.dispatchCreateOptionsMenu(menu, getMenuInflater());
        if (Build.VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final View mo310a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f178b.onCreateView(view, str, context, attributeSet);
    }

    public void onDestroy() {
        super.onDestroy();
        mo312a(false);
        this.f178b.dispatchDestroy();
        this.f178b.doLoaderDestroy();
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
        this.f178b.dispatchLowMemory();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.f178b.dispatchOptionsItemSelected(menuItem);
            case 6:
                return this.f178b.dispatchContextItemSelected(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.f178b.dispatchOptionsMenuClosed(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f180d = false;
        if (this.f177a.hasMessages(2)) {
            this.f177a.removeMessages(2);
            onResumeFragments();
        }
        this.f178b.dispatchPause();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f178b.noteStateNotSaved();
    }

    public void onStateNotSaved() {
        this.f178b.noteStateNotSaved();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f177a.sendEmptyMessage(2);
        this.f180d = true;
        this.f178b.execPendingActions();
    }

    public void onPostResume() {
        super.onPostResume();
        this.f177a.removeMessages(2);
        onResumeFragments();
        this.f178b.execPendingActions();
    }

    /* access modifiers changed from: protected */
    public void onResumeFragments() {
        this.f178b.dispatchResume();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.f184h) {
            this.f184h = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return onPrepareOptionsPanel(view, menu) | this.f178b.dispatchPrepareOptionsMenu(menu);
    }

    /* access modifiers changed from: protected */
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.f181e) {
            mo312a(true);
        }
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        List<Fragment> retainNonConfig = this.f178b.retainNonConfig();
        SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig = this.f178b.retainLoaderNonConfig();
        if (retainNonConfig == null && retainLoaderNonConfig == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        C0052b bVar = new C0052b();
        bVar.f189a = onRetainCustomNonConfigurationInstance;
        bVar.f190b = retainNonConfig;
        bVar.f191c = retainLoaderNonConfig;
        return bVar;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable saveAllState = this.f178b.saveAllState();
        if (saveAllState != null) {
            bundle.putParcelable("android:support:fragments", saveAllState);
        }
    }

    public void onStart() {
        super.onStart();
        this.f181e = false;
        this.f182f = false;
        this.f177a.removeMessages(1);
        if (!this.f179c) {
            this.f179c = true;
            this.f178b.dispatchActivityCreated();
        }
        this.f178b.noteStateNotSaved();
        this.f178b.execPendingActions();
        this.f178b.doLoaderStart();
        this.f178b.dispatchStart();
        this.f178b.reportLoaderStart();
    }

    public void onStop() {
        super.onStop();
        this.f181e = true;
        this.f177a.sendEmptyMessage(1);
        this.f178b.dispatchStop();
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public Object getLastCustomNonConfigurationInstance() {
        C0052b bVar = (C0052b) getLastNonConfigurationInstance();
        if (bVar != null) {
            return bVar.f189a;
        }
        return null;
    }

    public void supportInvalidateOptionsMenu() {
        if (Build.VERSION.SDK_INT >= 11) {
            C1338l.m5759a(this);
        } else {
            this.f184h = true;
        }
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
        printWriter.print(this.f179c);
        printWriter.print("mResumed=");
        printWriter.print(this.f180d);
        printWriter.print(" mStopped=");
        printWriter.print(this.f181e);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.f182f);
        this.f178b.dumpLoaders(str2, fileDescriptor, printWriter, strArr);
        this.f178b.getSupportFragmentManager().dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        m178a(str + "  ", printWriter, getWindow().getDecorView());
    }

    /* renamed from: a */
    private static String m175a(View view) {
        char c;
        char c2;
        char c3;
        char c4;
        char c5;
        char c6;
        char c7;
        String str;
        char c8 = 'F';
        char c9 = '.';
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
        if (view.isFocusable()) {
            c = 'F';
        } else {
            c = '.';
        }
        sb.append(c);
        if (view.isEnabled()) {
            c2 = 'E';
        } else {
            c2 = '.';
        }
        sb.append(c2);
        sb.append(view.willNotDraw() ? '.' : 'D');
        if (view.isHorizontalScrollBarEnabled()) {
            c3 = 'H';
        } else {
            c3 = '.';
        }
        sb.append(c3);
        if (view.isVerticalScrollBarEnabled()) {
            c4 = 'V';
        } else {
            c4 = '.';
        }
        sb.append(c4);
        if (view.isClickable()) {
            c5 = 'C';
        } else {
            c5 = '.';
        }
        sb.append(c5);
        if (view.isLongClickable()) {
            c6 = 'L';
        } else {
            c6 = '.';
        }
        sb.append(c6);
        sb.append(' ');
        if (!view.isFocused()) {
            c8 = '.';
        }
        sb.append(c8);
        if (view.isSelected()) {
            c7 = 'S';
        } else {
            c7 = '.';
        }
        sb.append(c7);
        if (view.isPressed()) {
            c9 = 'P';
        }
        sb.append(c9);
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

    /* renamed from: a */
    private void m178a(String str, PrintWriter printWriter, View view) {
        ViewGroup viewGroup;
        int childCount;
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(m175a(view));
        if ((view instanceof ViewGroup) && (childCount = viewGroup.getChildCount()) > 0) {
            String str2 = str + "  ";
            for (int i = 0; i < childCount; i++) {
                m178a(str2, printWriter, (viewGroup = (ViewGroup) view).getChildAt(i));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo312a(boolean z) {
        if (!this.f182f) {
            this.f182f = true;
            this.f183g = z;
            this.f177a.removeMessages(1);
            mo311a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo311a() {
        this.f178b.doLoaderStop(this.f183g);
        this.f178b.dispatchReallyStop();
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public FragmentManager getSupportFragmentManager() {
        return this.f178b.getSupportFragmentManager();
    }

    public LoaderManager getSupportLoaderManager() {
        return this.f178b.getSupportLoaderManager();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }

    public final void validateRequestPermissionsRequestCode(int i) {
        if (this.f185i) {
            this.f185i = false;
        } else if ((i & InputDeviceCompat.SOURCE_ANY) != 0) {
            throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
        }
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        int i2 = (i >> 8) & 255;
        if (i2 != 0) {
            int i3 = i2 - 1;
            int activeFragmentsCount = this.f178b.getActiveFragmentsCount();
            if (activeFragmentsCount == 0 || i3 < 0 || i3 >= activeFragmentsCount) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = this.f178b.getActiveFragments(new ArrayList(activeFragmentsCount)).get(i3);
            if (fragment == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
            } else {
                fragment.onRequestPermissionsResult(i & 255, strArr, iArr);
            }
        }
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        if (i == -1) {
            super.startActivityForResult(intent, -1);
        } else if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            super.startActivityForResult(intent, ((fragment.f164p + 1) << 16) + (65535 & i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m176a(Fragment fragment, String[] strArr, int i) {
        if (i == -1) {
            ActivityCompat.requestPermissions(this, strArr, i);
        } else if ((i & InputDeviceCompat.SOURCE_ANY) != 0) {
            throw new IllegalArgumentException("Can only use lower 8 bits for requestCode");
        } else {
            this.f185i = true;
            ActivityCompat.requestPermissions(this, strArr, ((fragment.f164p + 1) << 8) + (i & 255));
        }
    }

    /* renamed from: android.support.v4.app.FragmentActivity$a */
    class C0051a extends FragmentHostCallback<FragmentActivity> {
        public C0051a() {
            super(FragmentActivity.this);
        }

        public void onDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        public boolean onShouldSaveFragmentState(Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        public LayoutInflater onGetLayoutInflater() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        /* renamed from: a */
        public FragmentActivity onGetHost() {
            return FragmentActivity.this;
        }

        public void onSupportInvalidateOptionsMenu() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }

        public void onStartActivityFromFragment(Fragment fragment, Intent intent, int i) {
            FragmentActivity.this.startActivityFromFragment(fragment, intent, i);
        }

        public void onRequestPermissionsFromFragment(@NonNull Fragment fragment, @NonNull String[] strArr, int i) {
            FragmentActivity.this.m176a(fragment, strArr, i);
        }

        public boolean onShouldShowRequestPermissionRationale(@NonNull String str) {
            return ActivityCompat.shouldShowRequestPermissionRationale(FragmentActivity.this, str);
        }

        public boolean onHasWindowAnimations() {
            return FragmentActivity.this.getWindow() != null;
        }

        public int onGetWindowAnimations() {
            Window window = FragmentActivity.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        /* renamed from: a */
        public void mo355a(Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        @Nullable
        public View onFindViewById(int i) {
            return FragmentActivity.this.findViewById(i);
        }

        public boolean onHasView() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }
}
