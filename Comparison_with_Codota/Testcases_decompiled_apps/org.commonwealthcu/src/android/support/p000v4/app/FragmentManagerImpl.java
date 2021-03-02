package android.support.p000v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.p000v4.app.BackStackRecord;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentManager;
import android.support.p000v4.util.DebugUtils;
import android.support.p000v4.util.LogWriter;
import android.support.p000v4.view.LayoutInflaterFactory;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: android.support.v4.app.FragmentManagerImpl */
final class FragmentManagerImpl extends FragmentManager implements LayoutInflaterFactory {
    static final Interpolator ACCELERATE_CUBIC = new AccelerateInterpolator(1.5f);
    static final Interpolator ACCELERATE_QUINT = new AccelerateInterpolator(2.5f);
    static final int ANIM_DUR = 220;
    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    public static final int ANIM_STYLE_FADE_ENTER = 5;
    public static final int ANIM_STYLE_FADE_EXIT = 6;
    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    public static final int ANIM_STYLE_OPEN_EXIT = 2;
    static boolean DEBUG = false;
    static final Interpolator DECELERATE_CUBIC = new DecelerateInterpolator(1.5f);
    static final Interpolator DECELERATE_QUINT = new DecelerateInterpolator(2.5f);
    static final boolean HONEYCOMB;
    static final String TAG = "FragmentManager";
    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    static final String TARGET_STATE_TAG = "android:target_state";
    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    static final String VIEW_STATE_TAG = "android:view_state";
    ArrayList mActive;
    FragmentActivity mActivity;
    ArrayList mAdded;
    ArrayList mAvailBackStackIndices;
    ArrayList mAvailIndices;
    ArrayList mBackStack;
    ArrayList mBackStackChangeListeners;
    ArrayList mBackStackIndices;
    FragmentContainer mContainer;
    ArrayList mCreatedMenus;
    int mCurState = 0;
    boolean mDestroyed;
    Runnable mExecCommit = new Runnable() {
        public void run() {
            FragmentManagerImpl.this.execPendingActions();
        }
    };
    boolean mExecutingActions;
    boolean mHavePendingDeferredStart;
    boolean mNeedMenuInvalidate;
    String mNoTransactionsBecause;
    Fragment mParent;
    ArrayList mPendingActions;
    SparseArray mStateArray = null;
    Bundle mStateBundle = null;
    boolean mStateSaved;
    Runnable[] mTmpActions;

    /* renamed from: android.support.v4.app.FragmentManagerImpl$FragmentTag */
    class FragmentTag {
        public static final int[] Fragment = {16842755, 16842960, 16842961};
        public static final int Fragment_id = 1;
        public static final int Fragment_name = 0;
        public static final int Fragment_tag = 2;

        FragmentTag() {
        }
    }

    static {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 11) {
            z = true;
        }
        HONEYCOMB = z;
    }

    FragmentManagerImpl() {
    }

    private void checkStateLoss() {
        if (this.mStateSaved) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.mNoTransactionsBecause != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.mNoTransactionsBecause);
        }
    }

    static Animation makeFadeAnimation(Context context, float f, float f2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(DECELERATE_CUBIC);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    static Animation makeOpenCloseAnimation(Context context, float f, float f2, float f3, float f4) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(DECELERATE_QUINT);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(DECELERATE_CUBIC);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    public static int reverseTransit(int i) {
        switch (i) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN:
                return 8194;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE:
                return FragmentTransaction.TRANSIT_FRAGMENT_FADE;
            case 8194:
                return FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
            default:
                return 0;
        }
    }

    private void throwException(RuntimeException runtimeException) {
        Log.e(TAG, runtimeException.getMessage());
        Log.e(TAG, "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter(TAG));
        if (this.mActivity != null) {
            try {
                this.mActivity.dump("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e) {
                Log.e(TAG, "Failed dumping state", e);
            }
        } else {
            try {
                dump("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e(TAG, "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public static int transitToStyleIndex(int i, boolean z) {
        switch (i) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN:
                return z ? 1 : 2;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    /* access modifiers changed from: package-private */
    public final void addBackStackState(BackStackRecord backStackRecord) {
        if (this.mBackStack == null) {
            this.mBackStack = new ArrayList();
        }
        this.mBackStack.add(backStackRecord);
        reportBackStackChanged();
    }

    public final void addFragment(Fragment fragment, boolean z) {
        if (this.mAdded == null) {
            this.mAdded = new ArrayList();
        }
        if (DEBUG) {
            Log.v(TAG, "add: " + fragment);
        }
        makeActive(fragment);
        if (fragment.mDetached) {
            return;
        }
        if (this.mAdded.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        this.mAdded.add(fragment);
        fragment.mAdded = true;
        fragment.mRemoving = false;
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
        }
        if (z) {
            moveToState(fragment);
        }
    }

    public final void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener onBackStackChangedListener) {
        if (this.mBackStackChangeListeners == null) {
            this.mBackStackChangeListeners = new ArrayList();
        }
        this.mBackStackChangeListeners.add(onBackStackChangedListener);
    }

    public final int allocBackStackIndex(BackStackRecord backStackRecord) {
        int i;
        synchronized (this) {
            if (this.mAvailBackStackIndices == null || this.mAvailBackStackIndices.size() <= 0) {
                if (this.mBackStackIndices == null) {
                    this.mBackStackIndices = new ArrayList();
                }
                i = this.mBackStackIndices.size();
                if (DEBUG) {
                    Log.v(TAG, "Setting back stack index " + i + " to " + backStackRecord);
                }
                this.mBackStackIndices.add(backStackRecord);
            } else {
                i = ((Integer) this.mAvailBackStackIndices.remove(this.mAvailBackStackIndices.size() - 1)).intValue();
                if (DEBUG) {
                    Log.v(TAG, "Adding back stack index " + i + " with " + backStackRecord);
                }
                this.mBackStackIndices.set(i, backStackRecord);
            }
        }
        return i;
    }

    public final void attachActivity(FragmentActivity fragmentActivity, FragmentContainer fragmentContainer, Fragment fragment) {
        if (this.mActivity != null) {
            throw new IllegalStateException("Already attached");
        }
        this.mActivity = fragmentActivity;
        this.mContainer = fragmentContainer;
        this.mParent = fragment;
    }

    public final void attachFragment(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            Log.v(TAG, "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                if (this.mAdded == null) {
                    this.mAdded = new ArrayList();
                }
                if (this.mAdded.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (DEBUG) {
                    Log.v(TAG, "add from attach: " + fragment);
                }
                this.mAdded.add(fragment);
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.mNeedMenuInvalidate = true;
                }
                moveToState(fragment, this.mCurState, i, i2, false);
            }
        }
    }

    public final FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    public final void detachFragment(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            Log.v(TAG, "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (this.mAdded != null) {
                    if (DEBUG) {
                        Log.v(TAG, "remove from detach: " + fragment);
                    }
                    this.mAdded.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.mNeedMenuInvalidate = true;
                }
                fragment.mAdded = false;
                moveToState(fragment, 1, i, i2, false);
            }
        }
    }

    public final void dispatchActivityCreated() {
        this.mStateSaved = false;
        moveToState(2, false);
    }

    public final void dispatchConfigurationChanged(Configuration configuration) {
        if (this.mAdded != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mAdded.size()) {
                    Fragment fragment = (Fragment) this.mAdded.get(i2);
                    if (fragment != null) {
                        fragment.performConfigurationChanged(configuration);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.mAdded == null) {
            return false;
        }
        for (int i = 0; i < this.mAdded.size(); i++) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void dispatchCreate() {
        this.mStateSaved = false;
        moveToState(1, false);
    }

    public final boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z;
        ArrayList arrayList = null;
        if (this.mAdded != null) {
            int i = 0;
            z = false;
            while (i < this.mAdded.size()) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                }
                i++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.mCreatedMenus != null) {
            for (int i2 = 0; i2 < this.mCreatedMenus.size(); i2++) {
                Fragment fragment2 = (Fragment) this.mCreatedMenus.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.mCreatedMenus = arrayList;
        return z;
    }

    public final void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions();
        moveToState(0, false);
        this.mActivity = null;
        this.mContainer = null;
        this.mParent = null;
    }

    public final void dispatchDestroyView() {
        moveToState(1, false);
    }

    public final void dispatchLowMemory() {
        if (this.mAdded != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mAdded.size()) {
                    Fragment fragment = (Fragment) this.mAdded.get(i2);
                    if (fragment != null) {
                        fragment.performLowMemory();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.mAdded == null) {
            return false;
        }
        for (int i = 0; i < this.mAdded.size(); i++) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void dispatchOptionsMenuClosed(Menu menu) {
        if (this.mAdded != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mAdded.size()) {
                    Fragment fragment = (Fragment) this.mAdded.get(i2);
                    if (fragment != null) {
                        fragment.performOptionsMenuClosed(menu);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void dispatchPause() {
        moveToState(4, false);
    }

    public final boolean dispatchPrepareOptionsMenu(Menu menu) {
        if (this.mAdded == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.mAdded.size(); i++) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public final void dispatchReallyStop() {
        moveToState(2, false);
    }

    public final void dispatchResume() {
        this.mStateSaved = false;
        moveToState(5, false);
    }

    public final void dispatchStart() {
        this.mStateSaved = false;
        moveToState(4, false);
    }

    public final void dispatchStop() {
        this.mStateSaved = true;
        moveToState(3, false);
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        int size6;
        String str2 = str + "    ";
        if (this.mActive != null && (size6 = this.mActive.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size6; i++) {
                Fragment fragment = (Fragment) this.mActive.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        if (this.mAdded != null && (size5 = this.mAdded.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size5; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(((Fragment) this.mAdded.get(i2)).toString());
            }
        }
        if (this.mCreatedMenus != null && (size4 = this.mCreatedMenus.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(((Fragment) this.mCreatedMenus.get(i3)).toString());
            }
        }
        if (this.mBackStack != null && (size3 = this.mBackStack.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                BackStackRecord backStackRecord = (BackStackRecord) this.mBackStack.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.mBackStackIndices != null && (size2 = this.mBackStackIndices.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println((BackStackRecord) this.mBackStackIndices.get(i5));
                }
            }
            if (this.mAvailBackStackIndices != null && this.mAvailBackStackIndices.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.mAvailBackStackIndices.toArray()));
            }
        }
        if (this.mPendingActions != null && (size = this.mPendingActions.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println((Runnable) this.mPendingActions.get(i6));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mActivity=");
        printWriter.println(this.mActivity);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
        if (this.mNoTransactionsBecause != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.mNoTransactionsBecause);
        }
        if (this.mAvailIndices != null && this.mAvailIndices.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.mAvailIndices.toArray()));
        }
    }

    public final void enqueueAction(Runnable runnable, boolean z) {
        if (!z) {
            checkStateLoss();
        }
        synchronized (this) {
            if (this.mDestroyed || this.mActivity == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.mPendingActions == null) {
                this.mPendingActions = new ArrayList();
            }
            this.mPendingActions.add(runnable);
            if (this.mPendingActions.size() == 1) {
                this.mActivity.mHandler.removeCallbacks(this.mExecCommit);
                this.mActivity.mHandler.post(this.mExecCommit);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0083, code lost:
        r6.mExecutingActions = true;
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0086, code lost:
        if (r1 >= r3) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0088, code lost:
        r6.mTmpActions[r1].run();
        r6.mTmpActions[r1] = null;
        r1 = r1 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean execPendingActions() {
        /*
            r6 = this;
            r0 = 1
            r2 = 0
            boolean r1 = r6.mExecutingActions
            if (r1 == 0) goto L_0x000e
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Recursive entry to executePendingTransactions"
            r0.<init>(r1)
            throw r0
        L_0x000e:
            android.os.Looper r1 = android.os.Looper.myLooper()
            android.support.v4.app.FragmentActivity r3 = r6.mActivity
            android.os.Handler r3 = r3.mHandler
            android.os.Looper r3 = r3.getLooper()
            if (r1 == r3) goto L_0x0024
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Must be called from main thread of process"
            r0.<init>(r1)
            throw r0
        L_0x0024:
            r1 = r2
        L_0x0025:
            monitor-enter(r6)
            java.util.ArrayList r3 = r6.mPendingActions     // Catch:{ all -> 0x0097 }
            if (r3 == 0) goto L_0x0032
            java.util.ArrayList r3 = r6.mPendingActions     // Catch:{ all -> 0x0097 }
            int r3 = r3.size()     // Catch:{ all -> 0x0097 }
            if (r3 != 0) goto L_0x005a
        L_0x0032:
            monitor-exit(r6)     // Catch:{ all -> 0x0097 }
            boolean r0 = r6.mHavePendingDeferredStart
            if (r0 == 0) goto L_0x00a5
            r3 = r2
            r4 = r2
        L_0x0039:
            java.util.ArrayList r0 = r6.mActive
            int r0 = r0.size()
            if (r3 >= r0) goto L_0x009e
            java.util.ArrayList r0 = r6.mActive
            java.lang.Object r0 = r0.get(r3)
            android.support.v4.app.Fragment r0 = (android.support.p000v4.app.Fragment) r0
            if (r0 == 0) goto L_0x0056
            android.support.v4.app.LoaderManagerImpl r5 = r0.mLoaderManager
            if (r5 == 0) goto L_0x0056
            android.support.v4.app.LoaderManagerImpl r0 = r0.mLoaderManager
            boolean r0 = r0.hasRunningLoaders()
            r4 = r4 | r0
        L_0x0056:
            int r0 = r3 + 1
            r3 = r0
            goto L_0x0039
        L_0x005a:
            java.util.ArrayList r1 = r6.mPendingActions     // Catch:{ all -> 0x0097 }
            int r3 = r1.size()     // Catch:{ all -> 0x0097 }
            java.lang.Runnable[] r1 = r6.mTmpActions     // Catch:{ all -> 0x0097 }
            if (r1 == 0) goto L_0x0069
            java.lang.Runnable[] r1 = r6.mTmpActions     // Catch:{ all -> 0x0097 }
            int r1 = r1.length     // Catch:{ all -> 0x0097 }
            if (r1 >= r3) goto L_0x006d
        L_0x0069:
            java.lang.Runnable[] r1 = new java.lang.Runnable[r3]     // Catch:{ all -> 0x0097 }
            r6.mTmpActions = r1     // Catch:{ all -> 0x0097 }
        L_0x006d:
            java.util.ArrayList r1 = r6.mPendingActions     // Catch:{ all -> 0x0097 }
            java.lang.Runnable[] r4 = r6.mTmpActions     // Catch:{ all -> 0x0097 }
            r1.toArray(r4)     // Catch:{ all -> 0x0097 }
            java.util.ArrayList r1 = r6.mPendingActions     // Catch:{ all -> 0x0097 }
            r1.clear()     // Catch:{ all -> 0x0097 }
            android.support.v4.app.FragmentActivity r1 = r6.mActivity     // Catch:{ all -> 0x0097 }
            android.os.Handler r1 = r1.mHandler     // Catch:{ all -> 0x0097 }
            java.lang.Runnable r4 = r6.mExecCommit     // Catch:{ all -> 0x0097 }
            r1.removeCallbacks(r4)     // Catch:{ all -> 0x0097 }
            monitor-exit(r6)     // Catch:{ all -> 0x0097 }
            r6.mExecutingActions = r0
            r1 = r2
        L_0x0086:
            if (r1 >= r3) goto L_0x009a
            java.lang.Runnable[] r4 = r6.mTmpActions
            r4 = r4[r1]
            r4.run()
            java.lang.Runnable[] r4 = r6.mTmpActions
            r5 = 0
            r4[r1] = r5
            int r1 = r1 + 1
            goto L_0x0086
        L_0x0097:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0097 }
            throw r0
        L_0x009a:
            r6.mExecutingActions = r2
            r1 = r0
            goto L_0x0025
        L_0x009e:
            if (r4 != 0) goto L_0x00a5
            r6.mHavePendingDeferredStart = r2
            r6.startPendingDeferredFragments()
        L_0x00a5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.app.FragmentManagerImpl.execPendingActions():boolean");
    }

    public final boolean executePendingTransactions() {
        return execPendingActions();
    }

    public final Fragment findFragmentById(int i) {
        if (this.mAdded != null) {
            for (int size = this.mAdded.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.mAdded.get(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
        }
        if (this.mActive != null) {
            for (int size2 = this.mActive.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = (Fragment) this.mActive.get(size2);
                if (fragment2 != null && fragment2.mFragmentId == i) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public final Fragment findFragmentByTag(String str) {
        if (!(this.mAdded == null || str == null)) {
            for (int size = this.mAdded.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.mAdded.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (!(this.mActive == null || str == null)) {
            for (int size2 = this.mActive.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = (Fragment) this.mActive.get(size2);
                if (fragment2 != null && str.equals(fragment2.mTag)) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public final Fragment findFragmentByWho(String str) {
        Fragment findFragmentByWho;
        if (!(this.mActive == null || str == null)) {
            for (int size = this.mActive.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.mActive.get(size);
                if (fragment != null && (findFragmentByWho = fragment.findFragmentByWho(str)) != null) {
                    return findFragmentByWho;
                }
            }
        }
        return null;
    }

    public final void freeBackStackIndex(int i) {
        synchronized (this) {
            this.mBackStackIndices.set(i, (Object) null);
            if (this.mAvailBackStackIndices == null) {
                this.mAvailBackStackIndices = new ArrayList();
            }
            if (DEBUG) {
                Log.v(TAG, "Freeing back stack index " + i);
            }
            this.mAvailBackStackIndices.add(Integer.valueOf(i));
        }
    }

    public final FragmentManager.BackStackEntry getBackStackEntryAt(int i) {
        return (FragmentManager.BackStackEntry) this.mBackStack.get(i);
    }

    public final int getBackStackEntryCount() {
        if (this.mBackStack != null) {
            return this.mBackStack.size();
        }
        return 0;
    }

    public final Fragment getFragment(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.mActive.size()) {
            throwException(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = (Fragment) this.mActive.get(i);
        if (fragment != null) {
            return fragment;
        }
        throwException(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public final List getFragments() {
        return this.mActive;
    }

    /* access modifiers changed from: package-private */
    public final LayoutInflaterFactory getLayoutInflaterFactory() {
        return this;
    }

    public final void hideFragment(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            Log.v(TAG, "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            if (fragment.mView != null) {
                Animation loadAnimation = loadAnimation(fragment, i, false, i2);
                if (loadAnimation != null) {
                    fragment.mView.startAnimation(loadAnimation);
                }
                fragment.mView.setVisibility(8);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.onHiddenChanged(true);
        }
    }

    public final boolean isDestroyed() {
        return this.mDestroyed;
    }

    /* access modifiers changed from: package-private */
    public final Animation loadAnimation(Fragment fragment, int i, boolean z, int i2) {
        Animation loadAnimation;
        Animation onCreateAnimation = fragment.onCreateAnimation(i, z, fragment.mNextAnim);
        if (onCreateAnimation != null) {
            return onCreateAnimation;
        }
        if (fragment.mNextAnim != 0 && (loadAnimation = AnimationUtils.loadAnimation(this.mActivity, fragment.mNextAnim)) != null) {
            return loadAnimation;
        }
        if (i == 0) {
            return null;
        }
        int transitToStyleIndex = transitToStyleIndex(i, z);
        if (transitToStyleIndex < 0) {
            return null;
        }
        switch (transitToStyleIndex) {
            case 1:
                return makeOpenCloseAnimation(this.mActivity, 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return makeOpenCloseAnimation(this.mActivity, 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return makeOpenCloseAnimation(this.mActivity, 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return makeOpenCloseAnimation(this.mActivity, 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return makeFadeAnimation(this.mActivity, 0.0f, 1.0f);
            case 6:
                return makeFadeAnimation(this.mActivity, 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.mActivity.getWindow() != null) {
                    i2 = this.mActivity.getWindow().getAttributes().windowAnimations;
                }
                return i2 == 0 ? null : null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void makeActive(Fragment fragment) {
        if (fragment.mIndex < 0) {
            if (this.mAvailIndices == null || this.mAvailIndices.size() <= 0) {
                if (this.mActive == null) {
                    this.mActive = new ArrayList();
                }
                fragment.setIndex(this.mActive.size(), this.mParent);
                this.mActive.add(fragment);
            } else {
                fragment.setIndex(((Integer) this.mAvailIndices.remove(this.mAvailIndices.size() - 1)).intValue(), this.mParent);
                this.mActive.set(fragment.mIndex, fragment);
            }
            if (DEBUG) {
                Log.v(TAG, "Allocated fragment index " + fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void makeInactive(Fragment fragment) {
        if (fragment.mIndex >= 0) {
            if (DEBUG) {
                Log.v(TAG, "Freeing fragment index " + fragment);
            }
            this.mActive.set(fragment.mIndex, (Object) null);
            if (this.mAvailIndices == null) {
                this.mAvailIndices = new ArrayList();
            }
            this.mAvailIndices.add(Integer.valueOf(fragment.mIndex));
            this.mActivity.invalidateSupportFragment(fragment.mWho);
            fragment.initState();
        }
    }

    /* access modifiers changed from: package-private */
    public final void moveToState(int i, int i2, int i3, boolean z) {
        if (this.mActivity == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || this.mCurState != i) {
            this.mCurState = i;
            if (this.mActive != null) {
                int i4 = 0;
                boolean z2 = false;
                while (i4 < this.mActive.size()) {
                    Fragment fragment = (Fragment) this.mActive.get(i4);
                    if (fragment != null) {
                        moveToState(fragment, i, i2, i3, false);
                        if (fragment.mLoaderManager != null) {
                            z2 |= fragment.mLoaderManager.hasRunningLoaders();
                        }
                    }
                    i4++;
                    z2 = z2;
                }
                if (!z2) {
                    startPendingDeferredFragments();
                }
                if (this.mNeedMenuInvalidate && this.mActivity != null && this.mCurState == 5) {
                    this.mActivity.supportInvalidateOptionsMenu();
                    this.mNeedMenuInvalidate = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void moveToState(int i, boolean z) {
        moveToState(i, 0, 0, z);
    }

    /* access modifiers changed from: package-private */
    public final void moveToState(Fragment fragment) {
        moveToState(fragment, this.mCurState, 0, 0, false);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01f4, code lost:
        if (DEBUG == false) goto L_0x020a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01f6, code lost:
        android.util.Log.v(TAG, "moveto STARTED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x020a, code lost:
        r11.performStart();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x020d, code lost:
        if (r12 <= 4) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0211, code lost:
        if (DEBUG == false) goto L_0x0227;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0213, code lost:
        android.util.Log.v(TAG, "moveto RESUMED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0227, code lost:
        r11.mResumed = true;
        r11.performResume();
        r11.mSavedFragmentState = null;
        r11.mSavedViewState = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0240, code lost:
        r11.mView = android.support.p000v4.app.NoSaveStateFrameLayout.wrap(r11.mView);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x024a, code lost:
        r11.mInnerView = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0258, code lost:
        if (r12 > 0) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x025c, code lost:
        if (r10.mDestroyed == false) goto L_0x0269;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0260, code lost:
        if (r11.mAnimatingAway == null) goto L_0x0269;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0262, code lost:
        r0 = r11.mAnimatingAway;
        r11.mAnimatingAway = null;
        r0.clearAnimation();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x026b, code lost:
        if (r11.mAnimatingAway == null) goto L_0x0335;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x026d, code lost:
        r11.mStateAfterAnimating = r12;
        r12 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0292, code lost:
        if (r12 >= 4) goto L_0x02af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0296, code lost:
        if (DEBUG == false) goto L_0x02ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0298, code lost:
        android.util.Log.v(TAG, "movefrom STARTED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02ac, code lost:
        r11.performStop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02af, code lost:
        if (r12 >= 3) goto L_0x02cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02b3, code lost:
        if (DEBUG == false) goto L_0x02c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02b5, code lost:
        android.util.Log.v(TAG, "movefrom STOPPED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02c9, code lost:
        r11.performReallyStop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x02cd, code lost:
        if (r12 >= 2) goto L_0x0258;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02d1, code lost:
        if (DEBUG == false) goto L_0x02e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x02d3, code lost:
        android.util.Log.v(TAG, "movefrom ACTIVITY_CREATED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x02e9, code lost:
        if (r11.mView == null) goto L_0x02fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x02f1, code lost:
        if (r10.mActivity.isFinishing() != false) goto L_0x02fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02f5, code lost:
        if (r11.mSavedViewState != null) goto L_0x02fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x02f7, code lost:
        saveFragmentViewState(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x02fa, code lost:
        r11.performDestroyView();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x02ff, code lost:
        if (r11.mView == null) goto L_0x032d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0303, code lost:
        if (r11.mContainer == null) goto L_0x032d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0307, code lost:
        if (r10.mCurState <= 0) goto L_0x038d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x030b, code lost:
        if (r10.mDestroyed != false) goto L_0x038d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x030d, code lost:
        r0 = loadAnimation(r11, r13, false, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0311, code lost:
        if (r0 == null) goto L_0x0326;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0313, code lost:
        r11.mAnimatingAway = r11.mView;
        r11.mStateAfterAnimating = r12;
        r0.setAnimationListener(new android.support.p000v4.app.FragmentManagerImpl.C00165(r10));
        r11.mView.startAnimation(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0326, code lost:
        r11.mContainer.removeView(r11.mView);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x032d, code lost:
        r11.mContainer = null;
        r11.mView = null;
        r11.mInnerView = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0337, code lost:
        if (DEBUG == false) goto L_0x034d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0339, code lost:
        android.util.Log.v(TAG, "movefrom CREATED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x034f, code lost:
        if (r11.mRetaining != false) goto L_0x0354;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0351, code lost:
        r11.performDestroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0354, code lost:
        r11.mCalled = false;
        r11.onDetach();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x035b, code lost:
        if (r11.mCalled != false) goto L_0x0378;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0377, code lost:
        throw new android.support.p000v4.app.SuperNotCalledException("Fragment " + r11 + " did not call through to super.onDetach()");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0378, code lost:
        if (r15 != false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x037c, code lost:
        if (r11.mRetaining != false) goto L_0x0383;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x037e, code lost:
        makeInactive(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0383, code lost:
        r11.mActivity = null;
        r11.mParentFragment = null;
        r11.mFragmentManager = null;
        r11.mChildFragmentManager = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x038d, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x038f, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x012c, code lost:
        if (r12 <= 1) goto L_0x01f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0130, code lost:
        if (DEBUG == false) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0132, code lost:
        android.util.Log.v(TAG, "moveto ACTIVITY_CREATED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0148, code lost:
        if (r11.mFromLayout != false) goto L_0x01e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x014c, code lost:
        if (r11.mContainerId == 0) goto L_0x038f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x014e, code lost:
        r0 = (android.view.ViewGroup) r10.mContainer.findViewById(r11.mContainerId);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0158, code lost:
        if (r0 != null) goto L_0x0199;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x015c, code lost:
        if (r11.mRestored != false) goto L_0x0199;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x015e, code lost:
        throwException(new java.lang.IllegalArgumentException("No view found for id 0x" + java.lang.Integer.toHexString(r11.mContainerId) + " (" + r11.getResources().getResourceName(r11.mContainerId) + ") for fragment " + r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0199, code lost:
        r11.mContainer = r0;
        r11.mView = r11.performCreateView(r11.getLayoutInflater(r11.mSavedFragmentState), r0, r11.mSavedFragmentState);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01ab, code lost:
        if (r11.mView == null) goto L_0x024a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01ad, code lost:
        r11.mInnerView = r11.mView;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01b5, code lost:
        if (android.os.Build.VERSION.SDK_INT < 11) goto L_0x0240;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01b7, code lost:
        android.support.p000v4.view.ViewCompat.setSaveFromParentEnabled(r11.mView, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01bc, code lost:
        if (r0 == null) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01be, code lost:
        r1 = loadAnimation(r11, r13, true, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01c2, code lost:
        if (r1 == null) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01c4, code lost:
        r11.mView.startAnimation(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01c9, code lost:
        r0.addView(r11.mView);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01d0, code lost:
        if (r11.mHidden == false) goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01d2, code lost:
        r11.mView.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01d9, code lost:
        r11.onViewCreated(r11.mView, r11.mSavedFragmentState);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01e0, code lost:
        r11.performActivityCreated(r11.mSavedFragmentState);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01e7, code lost:
        if (r11.mView == null) goto L_0x01ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01e9, code lost:
        r11.restoreViewState(r11.mSavedFragmentState);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01ee, code lost:
        r11.mSavedFragmentState = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01f0, code lost:
        if (r12 <= 3) goto L_0x020d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void moveToState(final android.support.p000v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
            r10 = this;
            r9 = 4
            r6 = 3
            r5 = 1
            r3 = 0
            r7 = 0
            boolean r0 = r11.mAdded
            if (r0 == 0) goto L_0x000d
            boolean r0 = r11.mDetached
            if (r0 == 0) goto L_0x0010
        L_0x000d:
            if (r12 <= r5) goto L_0x0010
            r12 = r5
        L_0x0010:
            boolean r0 = r11.mRemoving
            if (r0 == 0) goto L_0x001a
            int r0 = r11.mState
            if (r12 <= r0) goto L_0x001a
            int r12 = r11.mState
        L_0x001a:
            boolean r0 = r11.mDeferStart
            if (r0 == 0) goto L_0x0025
            int r0 = r11.mState
            if (r0 >= r9) goto L_0x0025
            if (r12 <= r6) goto L_0x0025
            r12 = r6
        L_0x0025:
            int r0 = r11.mState
            if (r0 >= r12) goto L_0x024d
            boolean r0 = r11.mFromLayout
            if (r0 == 0) goto L_0x0032
            boolean r0 = r11.mInLayout
            if (r0 != 0) goto L_0x0032
        L_0x0031:
            return
        L_0x0032:
            android.view.View r0 = r11.mAnimatingAway
            if (r0 == 0) goto L_0x0040
            r11.mAnimatingAway = r7
            int r2 = r11.mStateAfterAnimating
            r0 = r10
            r1 = r11
            r4 = r3
            r0.moveToState(r1, r2, r3, r4, r5)
        L_0x0040:
            int r0 = r11.mState
            switch(r0) {
                case 0: goto L_0x0048;
                case 1: goto L_0x012c;
                case 2: goto L_0x01f0;
                case 3: goto L_0x01f0;
                case 4: goto L_0x020d;
                default: goto L_0x0045;
            }
        L_0x0045:
            r11.mState = r12
            goto L_0x0031
        L_0x0048:
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x0060
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "moveto CREATED: "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x0060:
            android.os.Bundle r0 = r11.mSavedFragmentState
            if (r0 == 0) goto L_0x00a4
            android.os.Bundle r0 = r11.mSavedFragmentState
            android.support.v4.app.FragmentActivity r1 = r10.mActivity
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r0.setClassLoader(r1)
            android.os.Bundle r0 = r11.mSavedFragmentState
            java.lang.String r1 = "android:view_state"
            android.util.SparseArray r0 = r0.getSparseParcelableArray(r1)
            r11.mSavedViewState = r0
            android.os.Bundle r0 = r11.mSavedFragmentState
            java.lang.String r1 = "android:target_state"
            android.support.v4.app.Fragment r0 = r10.getFragment(r0, r1)
            r11.mTarget = r0
            android.support.v4.app.Fragment r0 = r11.mTarget
            if (r0 == 0) goto L_0x0091
            android.os.Bundle r0 = r11.mSavedFragmentState
            java.lang.String r1 = "android:target_req_state"
            int r0 = r0.getInt(r1, r3)
            r11.mTargetRequestCode = r0
        L_0x0091:
            android.os.Bundle r0 = r11.mSavedFragmentState
            java.lang.String r1 = "android:user_visible_hint"
            boolean r0 = r0.getBoolean(r1, r5)
            r11.mUserVisibleHint = r0
            boolean r0 = r11.mUserVisibleHint
            if (r0 != 0) goto L_0x00a4
            r11.mDeferStart = r5
            if (r12 <= r6) goto L_0x00a4
            r12 = r6
        L_0x00a4:
            android.support.v4.app.FragmentActivity r0 = r10.mActivity
            r11.mActivity = r0
            android.support.v4.app.Fragment r0 = r10.mParent
            r11.mParentFragment = r0
            android.support.v4.app.Fragment r0 = r10.mParent
            if (r0 == 0) goto L_0x00dc
            android.support.v4.app.Fragment r0 = r10.mParent
            android.support.v4.app.FragmentManagerImpl r0 = r0.mChildFragmentManager
        L_0x00b4:
            r11.mFragmentManager = r0
            r11.mCalled = r3
            android.support.v4.app.FragmentActivity r0 = r10.mActivity
            r11.onAttach(r0)
            boolean r0 = r11.mCalled
            if (r0 != 0) goto L_0x00e1
            android.support.v4.app.SuperNotCalledException r0 = new android.support.v4.app.SuperNotCalledException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Fragment "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r2 = " did not call through to super.onAttach()"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00dc:
            android.support.v4.app.FragmentActivity r0 = r10.mActivity
            android.support.v4.app.FragmentManagerImpl r0 = r0.mFragments
            goto L_0x00b4
        L_0x00e1:
            android.support.v4.app.Fragment r0 = r11.mParentFragment
            if (r0 != 0) goto L_0x00ea
            android.support.v4.app.FragmentActivity r0 = r10.mActivity
            r0.onAttachFragment(r11)
        L_0x00ea:
            boolean r0 = r11.mRetaining
            if (r0 != 0) goto L_0x00f3
            android.os.Bundle r0 = r11.mSavedFragmentState
            r11.performCreate(r0)
        L_0x00f3:
            r11.mRetaining = r3
            boolean r0 = r11.mFromLayout
            if (r0 == 0) goto L_0x012c
            android.os.Bundle r0 = r11.mSavedFragmentState
            android.view.LayoutInflater r0 = r11.getLayoutInflater(r0)
            android.os.Bundle r1 = r11.mSavedFragmentState
            android.view.View r0 = r11.performCreateView(r0, r7, r1)
            r11.mView = r0
            android.view.View r0 = r11.mView
            if (r0 == 0) goto L_0x023c
            android.view.View r0 = r11.mView
            r11.mInnerView = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 11
            if (r0 < r1) goto L_0x0232
            android.view.View r0 = r11.mView
            android.support.p000v4.view.ViewCompat.setSaveFromParentEnabled(r0, r3)
        L_0x011a:
            boolean r0 = r11.mHidden
            if (r0 == 0) goto L_0x0125
            android.view.View r0 = r11.mView
            r1 = 8
            r0.setVisibility(r1)
        L_0x0125:
            android.view.View r0 = r11.mView
            android.os.Bundle r1 = r11.mSavedFragmentState
            r11.onViewCreated(r0, r1)
        L_0x012c:
            if (r12 <= r5) goto L_0x01f0
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x0146
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "moveto ACTIVITY_CREATED: "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x0146:
            boolean r0 = r11.mFromLayout
            if (r0 != 0) goto L_0x01e0
            int r0 = r11.mContainerId
            if (r0 == 0) goto L_0x038f
            android.support.v4.app.FragmentContainer r0 = r10.mContainer
            int r1 = r11.mContainerId
            android.view.View r0 = r0.findViewById(r1)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            if (r0 != 0) goto L_0x0199
            boolean r1 = r11.mRestored
            if (r1 != 0) goto L_0x0199
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "No view found for id 0x"
            r2.<init>(r4)
            int r4 = r11.mContainerId
            java.lang.String r4 = java.lang.Integer.toHexString(r4)
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r4 = " ("
            java.lang.StringBuilder r2 = r2.append(r4)
            android.content.res.Resources r4 = r11.getResources()
            int r8 = r11.mContainerId
            java.lang.String r4 = r4.getResourceName(r8)
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r4 = ") for fragment "
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.StringBuilder r2 = r2.append(r11)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r10.throwException(r1)
        L_0x0199:
            r11.mContainer = r0
            android.os.Bundle r1 = r11.mSavedFragmentState
            android.view.LayoutInflater r1 = r11.getLayoutInflater(r1)
            android.os.Bundle r2 = r11.mSavedFragmentState
            android.view.View r1 = r11.performCreateView(r1, r0, r2)
            r11.mView = r1
            android.view.View r1 = r11.mView
            if (r1 == 0) goto L_0x024a
            android.view.View r1 = r11.mView
            r11.mInnerView = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 11
            if (r1 < r2) goto L_0x0240
            android.view.View r1 = r11.mView
            android.support.p000v4.view.ViewCompat.setSaveFromParentEnabled(r1, r3)
        L_0x01bc:
            if (r0 == 0) goto L_0x01ce
            android.view.animation.Animation r1 = r10.loadAnimation(r11, r13, r5, r14)
            if (r1 == 0) goto L_0x01c9
            android.view.View r2 = r11.mView
            r2.startAnimation(r1)
        L_0x01c9:
            android.view.View r1 = r11.mView
            r0.addView(r1)
        L_0x01ce:
            boolean r0 = r11.mHidden
            if (r0 == 0) goto L_0x01d9
            android.view.View r0 = r11.mView
            r1 = 8
            r0.setVisibility(r1)
        L_0x01d9:
            android.view.View r0 = r11.mView
            android.os.Bundle r1 = r11.mSavedFragmentState
            r11.onViewCreated(r0, r1)
        L_0x01e0:
            android.os.Bundle r0 = r11.mSavedFragmentState
            r11.performActivityCreated(r0)
            android.view.View r0 = r11.mView
            if (r0 == 0) goto L_0x01ee
            android.os.Bundle r0 = r11.mSavedFragmentState
            r11.restoreViewState(r0)
        L_0x01ee:
            r11.mSavedFragmentState = r7
        L_0x01f0:
            if (r12 <= r6) goto L_0x020d
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x020a
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "moveto STARTED: "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x020a:
            r11.performStart()
        L_0x020d:
            if (r12 <= r9) goto L_0x0045
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x0227
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "moveto RESUMED: "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x0227:
            r11.mResumed = r5
            r11.performResume()
            r11.mSavedFragmentState = r7
            r11.mSavedViewState = r7
            goto L_0x0045
        L_0x0232:
            android.view.View r0 = r11.mView
            android.view.ViewGroup r0 = android.support.p000v4.app.NoSaveStateFrameLayout.wrap(r0)
            r11.mView = r0
            goto L_0x011a
        L_0x023c:
            r11.mInnerView = r7
            goto L_0x012c
        L_0x0240:
            android.view.View r1 = r11.mView
            android.view.ViewGroup r1 = android.support.p000v4.app.NoSaveStateFrameLayout.wrap(r1)
            r11.mView = r1
            goto L_0x01bc
        L_0x024a:
            r11.mInnerView = r7
            goto L_0x01e0
        L_0x024d:
            int r0 = r11.mState
            if (r0 <= r12) goto L_0x0045
            int r0 = r11.mState
            switch(r0) {
                case 1: goto L_0x0258;
                case 2: goto L_0x02cc;
                case 3: goto L_0x02af;
                case 4: goto L_0x0292;
                case 5: goto L_0x0272;
                default: goto L_0x0256;
            }
        L_0x0256:
            goto L_0x0045
        L_0x0258:
            if (r12 > 0) goto L_0x0045
            boolean r0 = r10.mDestroyed
            if (r0 == 0) goto L_0x0269
            android.view.View r0 = r11.mAnimatingAway
            if (r0 == 0) goto L_0x0269
            android.view.View r0 = r11.mAnimatingAway
            r11.mAnimatingAway = r7
            r0.clearAnimation()
        L_0x0269:
            android.view.View r0 = r11.mAnimatingAway
            if (r0 == 0) goto L_0x0335
            r11.mStateAfterAnimating = r12
            r12 = r5
            goto L_0x0045
        L_0x0272:
            r0 = 5
            if (r12 >= r0) goto L_0x0292
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x028d
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "movefrom RESUMED: "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x028d:
            r11.performPause()
            r11.mResumed = r3
        L_0x0292:
            if (r12 >= r9) goto L_0x02af
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x02ac
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "movefrom STARTED: "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x02ac:
            r11.performStop()
        L_0x02af:
            if (r12 >= r6) goto L_0x02cc
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x02c9
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "movefrom STOPPED: "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x02c9:
            r11.performReallyStop()
        L_0x02cc:
            r0 = 2
            if (r12 >= r0) goto L_0x0258
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x02e7
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "movefrom ACTIVITY_CREATED: "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x02e7:
            android.view.View r0 = r11.mView
            if (r0 == 0) goto L_0x02fa
            android.support.v4.app.FragmentActivity r0 = r10.mActivity
            boolean r0 = r0.isFinishing()
            if (r0 != 0) goto L_0x02fa
            android.util.SparseArray r0 = r11.mSavedViewState
            if (r0 != 0) goto L_0x02fa
            r10.saveFragmentViewState(r11)
        L_0x02fa:
            r11.performDestroyView()
            android.view.View r0 = r11.mView
            if (r0 == 0) goto L_0x032d
            android.view.ViewGroup r0 = r11.mContainer
            if (r0 == 0) goto L_0x032d
            int r0 = r10.mCurState
            if (r0 <= 0) goto L_0x038d
            boolean r0 = r10.mDestroyed
            if (r0 != 0) goto L_0x038d
            android.view.animation.Animation r0 = r10.loadAnimation(r11, r13, r3, r14)
        L_0x0311:
            if (r0 == 0) goto L_0x0326
            android.view.View r1 = r11.mView
            r11.mAnimatingAway = r1
            r11.mStateAfterAnimating = r12
            android.support.v4.app.FragmentManagerImpl$5 r1 = new android.support.v4.app.FragmentManagerImpl$5
            r1.<init>(r11)
            r0.setAnimationListener(r1)
            android.view.View r1 = r11.mView
            r1.startAnimation(r0)
        L_0x0326:
            android.view.ViewGroup r0 = r11.mContainer
            android.view.View r1 = r11.mView
            r0.removeView(r1)
        L_0x032d:
            r11.mContainer = r7
            r11.mView = r7
            r11.mInnerView = r7
            goto L_0x0258
        L_0x0335:
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x034d
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "movefrom CREATED: "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x034d:
            boolean r0 = r11.mRetaining
            if (r0 != 0) goto L_0x0354
            r11.performDestroy()
        L_0x0354:
            r11.mCalled = r3
            r11.onDetach()
            boolean r0 = r11.mCalled
            if (r0 != 0) goto L_0x0378
            android.support.v4.app.SuperNotCalledException r0 = new android.support.v4.app.SuperNotCalledException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Fragment "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r2 = " did not call through to super.onDetach()"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0378:
            if (r15 != 0) goto L_0x0045
            boolean r0 = r11.mRetaining
            if (r0 != 0) goto L_0x0383
            r10.makeInactive(r11)
            goto L_0x0045
        L_0x0383:
            r11.mActivity = r7
            r11.mParentFragment = r7
            r11.mFragmentManager = r7
            r11.mChildFragmentManager = r7
            goto L_0x0045
        L_0x038d:
            r0 = r7
            goto L_0x0311
        L_0x038f:
            r0 = r7
            goto L_0x0199
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.app.FragmentManagerImpl.moveToState(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    public final void noteStateNotSaved() {
        this.mStateSaved = false;
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue((String) null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FragmentTag.Fragment);
        String string = attributeValue == null ? obtainStyledAttributes.getString(0) : attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.isSupportFragmentClass(this.mActivity, string)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment findFragmentById = resourceId != -1 ? findFragmentById(resourceId) : null;
        if (findFragmentById == null && string2 != null) {
            findFragmentById = findFragmentByTag(string2);
        }
        if (findFragmentById == null && id != -1) {
            findFragmentById = findFragmentById(id);
        }
        if (DEBUG) {
            Log.v(TAG, "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + findFragmentById);
        }
        if (findFragmentById == null) {
            Fragment instantiate = Fragment.instantiate(context, string);
            instantiate.mFromLayout = true;
            instantiate.mFragmentId = resourceId != 0 ? resourceId : id;
            instantiate.mContainerId = id;
            instantiate.mTag = string2;
            instantiate.mInLayout = true;
            instantiate.mFragmentManager = this;
            instantiate.onInflate(this.mActivity, attributeSet, instantiate.mSavedFragmentState);
            addFragment(instantiate, true);
            fragment = instantiate;
        } else if (findFragmentById.mInLayout) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            findFragmentById.mInLayout = true;
            if (!findFragmentById.mRetaining) {
                findFragmentById.onInflate(this.mActivity, attributeSet, findFragmentById.mSavedFragmentState);
            }
            fragment = findFragmentById;
        }
        if (this.mCurState > 0 || !fragment.mFromLayout) {
            moveToState(fragment);
        } else {
            moveToState(fragment, 1, 0, 0, false);
        }
        if (fragment.mView == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.mView.setId(resourceId);
        }
        if (fragment.mView.getTag() == null) {
            fragment.mView.setTag(string2);
        }
        return fragment.mView;
    }

    public final void performPendingDeferredStart(Fragment fragment) {
        if (!fragment.mDeferStart) {
            return;
        }
        if (this.mExecutingActions) {
            this.mHavePendingDeferredStart = true;
            return;
        }
        fragment.mDeferStart = false;
        moveToState(fragment, this.mCurState, 0, 0, false);
    }

    public final void popBackStack() {
        enqueueAction(new Runnable() {
            public void run() {
                FragmentManagerImpl.this.popBackStackState(FragmentManagerImpl.this.mActivity.mHandler, (String) null, -1, 0);
            }
        }, false);
    }

    public final void popBackStack(final int i, final int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        enqueueAction(new Runnable() {
            public void run() {
                FragmentManagerImpl.this.popBackStackState(FragmentManagerImpl.this.mActivity.mHandler, (String) null, i, i2);
            }
        }, false);
    }

    public final void popBackStack(final String str, final int i) {
        enqueueAction(new Runnable() {
            public void run() {
                FragmentManagerImpl.this.popBackStackState(FragmentManagerImpl.this.mActivity.mHandler, str, -1, i);
            }
        }, false);
    }

    public final boolean popBackStackImmediate() {
        checkStateLoss();
        executePendingTransactions();
        return popBackStackState(this.mActivity.mHandler, (String) null, -1, 0);
    }

    public final boolean popBackStackImmediate(int i, int i2) {
        checkStateLoss();
        executePendingTransactions();
        if (i >= 0) {
            return popBackStackState(this.mActivity.mHandler, (String) null, i, i2);
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    public final boolean popBackStackImmediate(String str, int i) {
        checkStateLoss();
        executePendingTransactions();
        return popBackStackState(this.mActivity.mHandler, str, -1, i);
    }

    /* access modifiers changed from: package-private */
    public final boolean popBackStackState(Handler handler, String str, int i, int i2) {
        int i3;
        if (this.mBackStack == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = this.mBackStack.size() - 1;
            if (size < 0) {
                return false;
            }
            BackStackRecord backStackRecord = (BackStackRecord) this.mBackStack.remove(size);
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            backStackRecord.calculateBackFragments(sparseArray, sparseArray2);
            backStackRecord.popFromBackStack(true, (BackStackRecord.TransitionState) null, sparseArray, sparseArray2);
        } else {
            int i4 = -1;
            if (str != null || i >= 0) {
                int size2 = this.mBackStack.size() - 1;
                while (i3 >= 0) {
                    BackStackRecord backStackRecord2 = (BackStackRecord) this.mBackStack.get(i3);
                    if ((str != null && str.equals(backStackRecord2.getName())) || (i >= 0 && i == backStackRecord2.mIndex)) {
                        break;
                    }
                    size2 = i3 - 1;
                }
                if (i3 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    i3--;
                    while (i3 >= 0) {
                        BackStackRecord backStackRecord3 = (BackStackRecord) this.mBackStack.get(i3);
                        if ((str == null || !str.equals(backStackRecord3.getName())) && (i < 0 || i != backStackRecord3.mIndex)) {
                            break;
                        }
                        i3--;
                    }
                }
                i4 = i3;
            }
            if (i4 == this.mBackStack.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int size3 = this.mBackStack.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.mBackStack.remove(size3));
            }
            int size4 = arrayList.size() - 1;
            SparseArray sparseArray3 = new SparseArray();
            SparseArray sparseArray4 = new SparseArray();
            for (int i5 = 0; i5 <= size4; i5++) {
                ((BackStackRecord) arrayList.get(i5)).calculateBackFragments(sparseArray3, sparseArray4);
            }
            BackStackRecord.TransitionState transitionState = null;
            int i6 = 0;
            while (i6 <= size4) {
                if (DEBUG) {
                    Log.v(TAG, "Popping back stack state: " + arrayList.get(i6));
                }
                i6++;
                transitionState = ((BackStackRecord) arrayList.get(i6)).popFromBackStack(i6 == size4, transitionState, sparseArray3, sparseArray4);
            }
        }
        reportBackStackChanged();
        return true;
    }

    public final void putFragment(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mIndex < 0) {
            throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.mIndex);
    }

    public final void removeFragment(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            Log.v(TAG, "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            if (this.mAdded != null) {
                this.mAdded.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
            moveToState(fragment, z ? 0 : 1, i, i2, false);
        }
    }

    public final void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener onBackStackChangedListener) {
        if (this.mBackStackChangeListeners != null) {
            this.mBackStackChangeListeners.remove(onBackStackChangedListener);
        }
    }

    /* access modifiers changed from: package-private */
    public final void reportBackStackChanged() {
        if (this.mBackStackChangeListeners != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mBackStackChangeListeners.size()) {
                    ((FragmentManager.OnBackStackChangedListener) this.mBackStackChangeListeners.get(i2)).onBackStackChanged();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void restoreAllState(Parcelable parcelable, ArrayList arrayList) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.mActive != null) {
                if (arrayList != null) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        Fragment fragment = (Fragment) arrayList.get(i);
                        if (DEBUG) {
                            Log.v(TAG, "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.mActive[fragment.mIndex];
                        fragmentState.mInstance = fragment;
                        fragment.mSavedViewState = null;
                        fragment.mBackStackNesting = 0;
                        fragment.mInLayout = false;
                        fragment.mAdded = false;
                        fragment.mTarget = null;
                        if (fragmentState.mSavedFragmentState != null) {
                            fragmentState.mSavedFragmentState.setClassLoader(this.mActivity.getClassLoader());
                            fragment.mSavedViewState = fragmentState.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
                            fragment.mSavedFragmentState = fragmentState.mSavedFragmentState;
                        }
                    }
                }
                this.mActive = new ArrayList(fragmentManagerState.mActive.length);
                if (this.mAvailIndices != null) {
                    this.mAvailIndices.clear();
                }
                for (int i2 = 0; i2 < fragmentManagerState.mActive.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.mActive[i2];
                    if (fragmentState2 != null) {
                        Fragment instantiate = fragmentState2.instantiate(this.mActivity, this.mParent);
                        if (DEBUG) {
                            Log.v(TAG, "restoreAllState: active #" + i2 + ": " + instantiate);
                        }
                        this.mActive.add(instantiate);
                        fragmentState2.mInstance = null;
                    } else {
                        this.mActive.add((Object) null);
                        if (this.mAvailIndices == null) {
                            this.mAvailIndices = new ArrayList();
                        }
                        if (DEBUG) {
                            Log.v(TAG, "restoreAllState: avail #" + i2);
                        }
                        this.mAvailIndices.add(Integer.valueOf(i2));
                    }
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        Fragment fragment2 = (Fragment) arrayList.get(i3);
                        if (fragment2.mTargetIndex >= 0) {
                            if (fragment2.mTargetIndex < this.mActive.size()) {
                                fragment2.mTarget = (Fragment) this.mActive.get(fragment2.mTargetIndex);
                            } else {
                                Log.w(TAG, "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.mTargetIndex);
                                fragment2.mTarget = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.mAdded != null) {
                    this.mAdded = new ArrayList(fragmentManagerState.mAdded.length);
                    for (int i4 = 0; i4 < fragmentManagerState.mAdded.length; i4++) {
                        Fragment fragment3 = (Fragment) this.mActive.get(fragmentManagerState.mAdded[i4]);
                        if (fragment3 == null) {
                            throwException(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.mAdded[i4]));
                        }
                        fragment3.mAdded = true;
                        if (DEBUG) {
                            Log.v(TAG, "restoreAllState: added #" + i4 + ": " + fragment3);
                        }
                        if (this.mAdded.contains(fragment3)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.mAdded.add(fragment3);
                    }
                } else {
                    this.mAdded = null;
                }
                if (fragmentManagerState.mBackStack != null) {
                    this.mBackStack = new ArrayList(fragmentManagerState.mBackStack.length);
                    for (int i5 = 0; i5 < fragmentManagerState.mBackStack.length; i5++) {
                        BackStackRecord instantiate2 = fragmentManagerState.mBackStack[i5].instantiate(this);
                        if (DEBUG) {
                            Log.v(TAG, "restoreAllState: back stack #" + i5 + " (index " + instantiate2.mIndex + "): " + instantiate2);
                            instantiate2.dump("  ", new PrintWriter(new LogWriter(TAG)), false);
                        }
                        this.mBackStack.add(instantiate2);
                        if (instantiate2.mIndex >= 0) {
                            setBackStackIndex(instantiate2.mIndex, instantiate2);
                        }
                    }
                    return;
                }
                this.mBackStack = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final ArrayList retainNonConfig() {
        ArrayList arrayList = null;
        if (this.mActive != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mActive.size()) {
                    break;
                }
                Fragment fragment = (Fragment) this.mActive.get(i2);
                if (fragment != null && fragment.mRetainInstance) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                    fragment.mRetaining = true;
                    fragment.mTargetIndex = fragment.mTarget != null ? fragment.mTarget.mIndex : -1;
                    if (DEBUG) {
                        Log.v(TAG, "retainNonConfig: keeping retained " + fragment);
                    }
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final Parcelable saveAllState() {
        int[] iArr;
        int size;
        int size2;
        boolean z;
        BackStackState[] backStackStateArr = null;
        execPendingActions();
        if (HONEYCOMB) {
            this.mStateSaved = true;
        }
        if (this.mActive == null || this.mActive.size() <= 0) {
            return null;
        }
        int size3 = this.mActive.size();
        FragmentState[] fragmentStateArr = new FragmentState[size3];
        int i = 0;
        boolean z2 = false;
        while (i < size3) {
            Fragment fragment = (Fragment) this.mActive.get(i);
            if (fragment != null) {
                if (fragment.mIndex < 0) {
                    throwException(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.mIndex));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.mState <= 0 || fragmentState.mSavedFragmentState != null) {
                    fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
                } else {
                    fragmentState.mSavedFragmentState = saveFragmentBasicState(fragment);
                    if (fragment.mTarget != null) {
                        if (fragment.mTarget.mIndex < 0) {
                            throwException(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.mTarget));
                        }
                        if (fragmentState.mSavedFragmentState == null) {
                            fragmentState.mSavedFragmentState = new Bundle();
                        }
                        putFragment(fragmentState.mSavedFragmentState, TARGET_STATE_TAG, fragment.mTarget);
                        if (fragment.mTargetRequestCode != 0) {
                            fragmentState.mSavedFragmentState.putInt(TARGET_REQUEST_CODE_STATE_TAG, fragment.mTargetRequestCode);
                        }
                    }
                }
                if (DEBUG) {
                    Log.v(TAG, "Saved state of " + fragment + ": " + fragmentState.mSavedFragmentState);
                }
                z = true;
            } else {
                z = z2;
            }
            i++;
            z2 = z;
        }
        if (z2) {
            if (this.mAdded == null || (size2 = this.mAdded.size()) <= 0) {
                iArr = null;
            } else {
                iArr = new int[size2];
                for (int i2 = 0; i2 < size2; i2++) {
                    iArr[i2] = ((Fragment) this.mAdded.get(i2)).mIndex;
                    if (iArr[i2] < 0) {
                        throwException(new IllegalStateException("Failure saving state: active " + this.mAdded.get(i2) + " has cleared index: " + iArr[i2]));
                    }
                    if (DEBUG) {
                        Log.v(TAG, "saveAllState: adding fragment #" + i2 + ": " + this.mAdded.get(i2));
                    }
                }
            }
            if (this.mBackStack != null && (size = this.mBackStack.size()) > 0) {
                backStackStateArr = new BackStackState[size];
                for (int i3 = 0; i3 < size; i3++) {
                    backStackStateArr[i3] = new BackStackState(this, (BackStackRecord) this.mBackStack.get(i3));
                    if (DEBUG) {
                        Log.v(TAG, "saveAllState: adding back stack #" + i3 + ": " + this.mBackStack.get(i3));
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.mActive = fragmentStateArr;
            fragmentManagerState.mAdded = iArr;
            fragmentManagerState.mBackStack = backStackStateArr;
            return fragmentManagerState;
        } else if (!DEBUG) {
            return null;
        } else {
            Log.v(TAG, "saveAllState: no fragments!");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final Bundle saveFragmentBasicState(Fragment fragment) {
        Bundle bundle;
        if (this.mStateBundle == null) {
            this.mStateBundle = new Bundle();
        }
        fragment.performSaveInstanceState(this.mStateBundle);
        if (!this.mStateBundle.isEmpty()) {
            bundle = this.mStateBundle;
            this.mStateBundle = null;
        } else {
            bundle = null;
        }
        if (fragment.mView != null) {
            saveFragmentViewState(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(VIEW_STATE_TAG, fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(USER_VISIBLE_HINT_TAG, fragment.mUserVisibleHint);
        }
        return bundle;
    }

    public final Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        Bundle saveFragmentBasicState;
        if (fragment.mIndex < 0) {
            throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.mState <= 0 || (saveFragmentBasicState = saveFragmentBasicState(fragment)) == null) {
            return null;
        }
        return new Fragment.SavedState(saveFragmentBasicState);
    }

    /* access modifiers changed from: package-private */
    public final void saveFragmentViewState(Fragment fragment) {
        if (fragment.mInnerView != null) {
            if (this.mStateArray == null) {
                this.mStateArray = new SparseArray();
            } else {
                this.mStateArray.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.mStateArray);
            if (this.mStateArray.size() > 0) {
                fragment.mSavedViewState = this.mStateArray;
                this.mStateArray = null;
            }
        }
    }

    public final void setBackStackIndex(int i, BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.mBackStackIndices == null) {
                this.mBackStackIndices = new ArrayList();
            }
            int size = this.mBackStackIndices.size();
            if (i < size) {
                if (DEBUG) {
                    Log.v(TAG, "Setting back stack index " + i + " to " + backStackRecord);
                }
                this.mBackStackIndices.set(i, backStackRecord);
            } else {
                while (size < i) {
                    this.mBackStackIndices.add((Object) null);
                    if (this.mAvailBackStackIndices == null) {
                        this.mAvailBackStackIndices = new ArrayList();
                    }
                    if (DEBUG) {
                        Log.v(TAG, "Adding available back stack index " + size);
                    }
                    this.mAvailBackStackIndices.add(Integer.valueOf(size));
                    size++;
                }
                if (DEBUG) {
                    Log.v(TAG, "Adding back stack index " + i + " with " + backStackRecord);
                }
                this.mBackStackIndices.add(backStackRecord);
            }
        }
    }

    public final void showFragment(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            Log.v(TAG, "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            if (fragment.mView != null) {
                Animation loadAnimation = loadAnimation(fragment, i, true, i2);
                if (loadAnimation != null) {
                    fragment.mView.startAnimation(loadAnimation);
                }
                fragment.mView.setVisibility(0);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.onHiddenChanged(false);
        }
    }

    /* access modifiers changed from: package-private */
    public final void startPendingDeferredFragments() {
        if (this.mActive != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mActive.size()) {
                    Fragment fragment = (Fragment) this.mActive.get(i2);
                    if (fragment != null) {
                        performPendingDeferredStart(fragment);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (this.mParent != null) {
            DebugUtils.buildShortClassTag(this.mParent, sb);
        } else {
            DebugUtils.buildShortClassTag(this.mActivity, sb);
        }
        sb.append("}}");
        return sb.toString();
    }
}
