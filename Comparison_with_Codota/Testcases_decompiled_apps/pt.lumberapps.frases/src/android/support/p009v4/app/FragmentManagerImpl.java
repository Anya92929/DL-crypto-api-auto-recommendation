package android.support.p009v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.p009v4.app.BackStackRecord;
import android.support.p009v4.app.Fragment;
import android.support.p009v4.app.FragmentManager;
import android.support.p009v4.p019f.C0139d;
import android.support.p009v4.p019f.C0140e;
import android.support.p009v4.view.C0208am;
import android.support.p009v4.view.C0247by;
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
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: android.support.v4.app.FragmentManagerImpl */
final class FragmentManagerImpl extends FragmentManager implements C0208am {
    static final Interpolator ACCELERATE_CUBIC = new AccelerateInterpolator(1.5f);
    static final Interpolator ACCELERATE_QUINT = new AccelerateInterpolator(2.5f);
    static final int ANIM_DUR = 220;
    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    public static final int ANIM_STYLE_FADE_ENTER = 5;
    public static final int ANIM_STYLE_FADE_EXIT = 6;
    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    public static final int ANIM_STYLE_OPEN_EXIT = 2;
    static boolean DEBUG = HONEYCOMB;
    static final Interpolator DECELERATE_CUBIC = new DecelerateInterpolator(1.5f);
    static final Interpolator DECELERATE_QUINT = new DecelerateInterpolator(2.5f);
    static final boolean HONEYCOMB;
    static final String TAG = "FragmentManager";
    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    static final String TARGET_STATE_TAG = "android:target_state";
    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    static final String VIEW_STATE_TAG = "android:view_state";
    static Field sAnimationListenerField = null;
    ArrayList mActive;
    ArrayList mAdded;
    ArrayList mAvailBackStackIndices;
    ArrayList mAvailIndices;
    ArrayList mBackStack;
    ArrayList mBackStackChangeListeners;
    ArrayList mBackStackIndices;
    FragmentContainer mContainer;
    FragmentController mController;
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
    FragmentHostCallback mHost;
    boolean mNeedMenuInvalidate;
    String mNoTransactionsBecause;
    Fragment mParent;
    ArrayList mPendingActions;
    SparseArray mStateArray = null;
    Bundle mStateBundle = null;
    boolean mStateSaved;
    Runnable[] mTmpActions;

    /* renamed from: android.support.v4.app.FragmentManagerImpl$AnimateOnHWLayerIfNeededListener */
    class AnimateOnHWLayerIfNeededListener implements Animation.AnimationListener {
        private Animation.AnimationListener mOrignalListener = null;
        private boolean mShouldRunOnHWLayer = FragmentManagerImpl.HONEYCOMB;
        /* access modifiers changed from: private */
        public View mView = null;

        public AnimateOnHWLayerIfNeededListener(View view, Animation animation) {
            if (view != null && animation != null) {
                this.mView = view;
            }
        }

        public AnimateOnHWLayerIfNeededListener(View view, Animation animation, Animation.AnimationListener animationListener) {
            if (view != null && animation != null) {
                this.mOrignalListener = animationListener;
                this.mView = view;
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.mView != null && this.mShouldRunOnHWLayer) {
                this.mView.post(new Runnable() {
                    public void run() {
                        C0247by.m892a(AnimateOnHWLayerIfNeededListener.this.mView, 0, (Paint) null);
                    }
                });
            }
            if (this.mOrignalListener != null) {
                this.mOrignalListener.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.mOrignalListener != null) {
                this.mOrignalListener.onAnimationRepeat(animation);
            }
        }

        public void onAnimationStart(Animation animation) {
            if (this.mView != null) {
                this.mShouldRunOnHWLayer = FragmentManagerImpl.shouldRunOnHWLayer(this.mView, animation);
                if (this.mShouldRunOnHWLayer) {
                    this.mView.post(new Runnable() {
                        public void run() {
                            C0247by.m892a(AnimateOnHWLayerIfNeededListener.this.mView, 2, (Paint) null);
                        }
                    });
                }
            }
            if (this.mOrignalListener != null) {
                this.mOrignalListener.onAnimationStart(animation);
            }
        }
    }

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
        boolean z = HONEYCOMB;
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
        AnimationSet animationSet = new AnimationSet(HONEYCOMB);
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

    static boolean modifiesAlpha(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return HONEYCOMB;
        }
        List<Animation> animations = ((AnimationSet) animation).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return HONEYCOMB;
    }

    public static int reverseTransit(int i) {
        switch (i) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /*4097*/:
                return FragmentTransaction.TRANSIT_FRAGMENT_CLOSE;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /*4099*/:
                return FragmentTransaction.TRANSIT_FRAGMENT_FADE;
            case FragmentTransaction.TRANSIT_FRAGMENT_CLOSE /*8194*/:
                return FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
            default:
                return 0;
        }
    }

    private void setHWLayerAnimListenerIfAlpha(View view, Animation animation) {
        Animation.AnimationListener animationListener;
        if (view != null && animation != null && shouldRunOnHWLayer(view, animation)) {
            try {
                if (sAnimationListenerField == null) {
                    sAnimationListenerField = Animation.class.getDeclaredField("mListener");
                    sAnimationListenerField.setAccessible(true);
                }
                animationListener = (Animation.AnimationListener) sAnimationListenerField.get(animation);
            } catch (NoSuchFieldException e) {
                Log.e(TAG, "No field with the name mListener is found in Animation class", e);
                animationListener = null;
            } catch (IllegalAccessException e2) {
                Log.e(TAG, "Cannot access Animation's mListener field", e2);
                animationListener = null;
            }
            animation.setAnimationListener(new AnimateOnHWLayerIfNeededListener(view, animation, animationListener));
        }
    }

    static boolean shouldRunOnHWLayer(View view, Animation animation) {
        if (Build.VERSION.SDK_INT < 19 || C0247by.m906c(view) != 0 || !C0247by.m921n(view) || !modifiesAlpha(animation)) {
            return HONEYCOMB;
        }
        return true;
    }

    private void throwException(RuntimeException runtimeException) {
        Log.e(TAG, runtimeException.getMessage());
        Log.e(TAG, "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0140e(TAG));
        if (this.mHost != null) {
            try {
                this.mHost.onDump("  ", (FileDescriptor) null, printWriter, new String[0]);
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
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /*4097*/:
                return z ? 1 : 2;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /*4099*/:
                return z ? 5 : 6;
            case FragmentTransaction.TRANSIT_FRAGMENT_CLOSE /*8194*/:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    /* access modifiers changed from: package-private */
    public void addBackStackState(BackStackRecord backStackRecord) {
        if (this.mBackStack == null) {
            this.mBackStack = new ArrayList();
        }
        this.mBackStack.add(backStackRecord);
        reportBackStackChanged();
    }

    public void addFragment(Fragment fragment, boolean z) {
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
        fragment.mRemoving = HONEYCOMB;
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
        }
        if (z) {
            moveToState(fragment);
        }
    }

    public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener onBackStackChangedListener) {
        if (this.mBackStackChangeListeners == null) {
            this.mBackStackChangeListeners = new ArrayList();
        }
        this.mBackStackChangeListeners.add(onBackStackChangedListener);
    }

    public int allocBackStackIndex(BackStackRecord backStackRecord) {
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

    public void attachController(FragmentHostCallback fragmentHostCallback, FragmentContainer fragmentContainer, Fragment fragment) {
        if (this.mHost != null) {
            throw new IllegalStateException("Already attached");
        }
        this.mHost = fragmentHostCallback;
        this.mContainer = fragmentContainer;
        this.mParent = fragment;
    }

    public void attachFragment(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            Log.v(TAG, "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = HONEYCOMB;
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
                moveToState(fragment, this.mCurState, i, i2, HONEYCOMB);
            }
        }
    }

    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    public void detachFragment(Fragment fragment, int i, int i2) {
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
                fragment.mAdded = HONEYCOMB;
                moveToState(fragment, 1, i, i2, HONEYCOMB);
            }
        }
    }

    public void dispatchActivityCreated() {
        this.mStateSaved = HONEYCOMB;
        moveToState(2, HONEYCOMB);
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
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

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.mAdded == null) {
            return HONEYCOMB;
        }
        for (int i = 0; i < this.mAdded.size(); i++) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return HONEYCOMB;
    }

    public void dispatchCreate() {
        this.mStateSaved = HONEYCOMB;
        moveToState(1, HONEYCOMB);
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
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

    public void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions();
        moveToState(0, HONEYCOMB);
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
    }

    public void dispatchDestroyView() {
        moveToState(1, HONEYCOMB);
    }

    public void dispatchLowMemory() {
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

    public void dispatchMultiWindowModeChanged(boolean z) {
        if (this.mAdded != null) {
            for (int size = this.mAdded.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.mAdded.get(size);
                if (fragment != null) {
                    fragment.performMultiWindowModeChanged(z);
                }
            }
        }
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.mAdded == null) {
            return HONEYCOMB;
        }
        for (int i = 0; i < this.mAdded.size(); i++) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return HONEYCOMB;
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
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

    public void dispatchPause() {
        moveToState(4, HONEYCOMB);
    }

    public void dispatchPictureInPictureModeChanged(boolean z) {
        if (this.mAdded != null) {
            for (int size = this.mAdded.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.mAdded.get(size);
                if (fragment != null) {
                    fragment.performPictureInPictureModeChanged(z);
                }
            }
        }
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        if (this.mAdded == null) {
            return HONEYCOMB;
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

    public void dispatchReallyStop() {
        moveToState(2, HONEYCOMB);
    }

    public void dispatchResume() {
        this.mStateSaved = HONEYCOMB;
        moveToState(5, HONEYCOMB);
    }

    public void dispatchStart() {
        this.mStateSaved = HONEYCOMB;
        moveToState(4, HONEYCOMB);
    }

    public void dispatchStop() {
        this.mStateSaved = true;
        moveToState(3, HONEYCOMB);
    }

    /* access modifiers changed from: package-private */
    public void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart) {
            boolean z = false;
            for (int i = 0; i < this.mActive.size(); i++) {
                Fragment fragment = (Fragment) this.mActive.get(i);
                if (!(fragment == null || fragment.mLoaderManager == null)) {
                    z |= fragment.mLoaderManager.hasRunningLoaders();
                }
            }
            if (!z) {
                this.mHavePendingDeferredStart = HONEYCOMB;
                startPendingDeferredFragments();
            }
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
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
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
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

    public void enqueueAction(Runnable runnable, boolean z) {
        if (!z) {
            checkStateLoss();
        }
        synchronized (this) {
            if (this.mDestroyed || this.mHost == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.mPendingActions == null) {
                this.mPendingActions = new ArrayList();
            }
            this.mPendingActions.add(runnable);
            if (this.mPendingActions.size() == 1) {
                this.mHost.getHandler().removeCallbacks(this.mExecCommit);
                this.mHost.getHandler().post(this.mExecCommit);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0064, code lost:
        r6.mExecutingActions = true;
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0067, code lost:
        if (r0 >= r3) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0069, code lost:
        r6.mTmpActions[r0].run();
        r6.mTmpActions[r0] = null;
        r0 = r0 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean execPendingActions() {
        /*
            r6 = this;
            r2 = 1
            r1 = 0
            boolean r0 = r6.mExecutingActions
            if (r0 == 0) goto L_0x000e
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "FragmentManager is already executing transactions"
            r0.<init>(r1)
            throw r0
        L_0x000e:
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.support.v4.app.FragmentHostCallback r3 = r6.mHost
            android.os.Handler r3 = r3.getHandler()
            android.os.Looper r3 = r3.getLooper()
            if (r0 == r3) goto L_0x0026
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Must be called from main thread of fragment host"
            r0.<init>(r1)
            throw r0
        L_0x0026:
            r0 = r1
        L_0x0027:
            monitor-enter(r6)
            java.util.ArrayList r3 = r6.mPendingActions     // Catch:{ all -> 0x0078 }
            if (r3 == 0) goto L_0x0034
            java.util.ArrayList r3 = r6.mPendingActions     // Catch:{ all -> 0x0078 }
            int r3 = r3.size()     // Catch:{ all -> 0x0078 }
            if (r3 != 0) goto L_0x0039
        L_0x0034:
            monitor-exit(r6)     // Catch:{ all -> 0x0078 }
            r6.doPendingDeferredStart()
            return r0
        L_0x0039:
            java.util.ArrayList r0 = r6.mPendingActions     // Catch:{ all -> 0x0078 }
            int r3 = r0.size()     // Catch:{ all -> 0x0078 }
            java.lang.Runnable[] r0 = r6.mTmpActions     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x0048
            java.lang.Runnable[] r0 = r6.mTmpActions     // Catch:{ all -> 0x0078 }
            int r0 = r0.length     // Catch:{ all -> 0x0078 }
            if (r0 >= r3) goto L_0x004c
        L_0x0048:
            java.lang.Runnable[] r0 = new java.lang.Runnable[r3]     // Catch:{ all -> 0x0078 }
            r6.mTmpActions = r0     // Catch:{ all -> 0x0078 }
        L_0x004c:
            java.util.ArrayList r0 = r6.mPendingActions     // Catch:{ all -> 0x0078 }
            java.lang.Runnable[] r4 = r6.mTmpActions     // Catch:{ all -> 0x0078 }
            r0.toArray(r4)     // Catch:{ all -> 0x0078 }
            java.util.ArrayList r0 = r6.mPendingActions     // Catch:{ all -> 0x0078 }
            r0.clear()     // Catch:{ all -> 0x0078 }
            android.support.v4.app.FragmentHostCallback r0 = r6.mHost     // Catch:{ all -> 0x0078 }
            android.os.Handler r0 = r0.getHandler()     // Catch:{ all -> 0x0078 }
            java.lang.Runnable r4 = r6.mExecCommit     // Catch:{ all -> 0x0078 }
            r0.removeCallbacks(r4)     // Catch:{ all -> 0x0078 }
            monitor-exit(r6)     // Catch:{ all -> 0x0078 }
            r6.mExecutingActions = r2
            r0 = r1
        L_0x0067:
            if (r0 >= r3) goto L_0x007b
            java.lang.Runnable[] r4 = r6.mTmpActions
            r4 = r4[r0]
            r4.run()
            java.lang.Runnable[] r4 = r6.mTmpActions
            r5 = 0
            r4[r0] = r5
            int r0 = r0 + 1
            goto L_0x0067
        L_0x0078:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0078 }
            throw r0
        L_0x007b:
            r6.mExecutingActions = r1
            r0 = r2
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p009v4.app.FragmentManagerImpl.execPendingActions():boolean");
    }

    public void execSingleAction(Runnable runnable, boolean z) {
        if (this.mExecutingActions) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (Looper.myLooper() != this.mHost.getHandler().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!z) {
                checkStateLoss();
            }
            this.mExecutingActions = true;
            runnable.run();
            this.mExecutingActions = HONEYCOMB;
            doPendingDeferredStart();
        }
    }

    public boolean executePendingTransactions() {
        return execPendingActions();
    }

    public Fragment findFragmentById(int i) {
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

    public Fragment findFragmentByTag(String str) {
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

    public Fragment findFragmentByWho(String str) {
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

    public void freeBackStackIndex(int i) {
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

    public FragmentManager.BackStackEntry getBackStackEntryAt(int i) {
        return (FragmentManager.BackStackEntry) this.mBackStack.get(i);
    }

    public int getBackStackEntryCount() {
        if (this.mBackStack != null) {
            return this.mBackStack.size();
        }
        return 0;
    }

    public Fragment getFragment(Bundle bundle, String str) {
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

    public List getFragments() {
        return this.mActive;
    }

    /* access modifiers changed from: package-private */
    public C0208am getLayoutInflaterFactory() {
        return this;
    }

    public void hideFragment(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            Log.v(TAG, "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            if (fragment.mView != null) {
                Animation loadAnimation = loadAnimation(fragment, i, HONEYCOMB, i2);
                if (loadAnimation != null) {
                    setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
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

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    /* access modifiers changed from: package-private */
    public Animation loadAnimation(Fragment fragment, int i, boolean z, int i2) {
        Animation loadAnimation;
        Animation onCreateAnimation = fragment.onCreateAnimation(i, z, fragment.mNextAnim);
        if (onCreateAnimation != null) {
            return onCreateAnimation;
        }
        if (fragment.mNextAnim != 0 && (loadAnimation = AnimationUtils.loadAnimation(this.mHost.getContext(), fragment.mNextAnim)) != null) {
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
                return makeOpenCloseAnimation(this.mHost.getContext(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return makeOpenCloseAnimation(this.mHost.getContext(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return makeOpenCloseAnimation(this.mHost.getContext(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return makeOpenCloseAnimation(this.mHost.getContext(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return makeFadeAnimation(this.mHost.getContext(), 0.0f, 1.0f);
            case 6:
                return makeFadeAnimation(this.mHost.getContext(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.mHost.onHasWindowAnimations()) {
                    i2 = this.mHost.onGetWindowAnimations();
                }
                return i2 == 0 ? null : null;
        }
    }

    /* access modifiers changed from: package-private */
    public void makeActive(Fragment fragment) {
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
    public void makeInactive(Fragment fragment) {
        if (fragment.mIndex >= 0) {
            if (DEBUG) {
                Log.v(TAG, "Freeing fragment index " + fragment);
            }
            this.mActive.set(fragment.mIndex, (Object) null);
            if (this.mAvailIndices == null) {
                this.mAvailIndices = new ArrayList();
            }
            this.mAvailIndices.add(Integer.valueOf(fragment.mIndex));
            this.mHost.inactivateFragment(fragment.mWho);
            fragment.initState();
        }
    }

    /* access modifiers changed from: package-private */
    public void moveToState(int i, int i2, int i3, boolean z) {
        if (this.mHost == null && i != 0) {
            throw new IllegalStateException("No host");
        } else if (z || this.mCurState != i) {
            this.mCurState = i;
            if (this.mActive != null) {
                int i4 = 0;
                boolean z2 = false;
                while (i4 < this.mActive.size()) {
                    Fragment fragment = (Fragment) this.mActive.get(i4);
                    if (fragment != null) {
                        moveToState(fragment, i, i2, i3, HONEYCOMB);
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
                if (this.mNeedMenuInvalidate && this.mHost != null && this.mCurState == 5) {
                    this.mHost.onSupportInvalidateOptionsMenu();
                    this.mNeedMenuInvalidate = HONEYCOMB;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void moveToState(int i, boolean z) {
        moveToState(i, 0, 0, z);
    }

    /* access modifiers changed from: package-private */
    public void moveToState(Fragment fragment) {
        moveToState(fragment, this.mCurState, 0, 0, HONEYCOMB);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02d2, code lost:
        r1 = "unknown";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02ef, code lost:
        if (r12 >= 1) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02f3, code lost:
        if (r10.mDestroyed == false) goto L_0x0300;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02f7, code lost:
        if (r11.mAnimatingAway == null) goto L_0x0300;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02f9, code lost:
        r0 = r11.mAnimatingAway;
        r11.mAnimatingAway = null;
        r0.clearAnimation();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0302, code lost:
        if (r11.mAnimatingAway == null) goto L_0x03dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0304, code lost:
        r11.mStateAfterAnimating = r12;
        r12 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x032b, code lost:
        if (r12 >= 4) goto L_0x034c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x032f, code lost:
        if (DEBUG == false) goto L_0x0349;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0331, code lost:
        android.util.Log.v(TAG, "movefrom STARTED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0349, code lost:
        r11.performStop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x034c, code lost:
        if (r12 >= 3) goto L_0x036d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0350, code lost:
        if (DEBUG == false) goto L_0x036a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0352, code lost:
        android.util.Log.v(TAG, "movefrom STOPPED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x036a, code lost:
        r11.performReallyStop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x036e, code lost:
        if (r12 >= 2) goto L_0x02ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0372, code lost:
        if (DEBUG == false) goto L_0x038c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0374, code lost:
        android.util.Log.v(TAG, "movefrom ACTIVITY_CREATED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x038e, code lost:
        if (r11.mView == null) goto L_0x039f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0396, code lost:
        if (r10.mHost.onShouldSaveFragmentState(r11) == false) goto L_0x039f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x039a, code lost:
        if (r11.mSavedViewState != null) goto L_0x039f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x039c, code lost:
        saveFragmentViewState(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x039f, code lost:
        r11.performDestroyView();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03a4, code lost:
        if (r11.mView == null) goto L_0x03d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03a8, code lost:
        if (r11.mContainer == null) goto L_0x03d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03ac, code lost:
        if (r10.mCurState <= 0) goto L_0x043d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03b0, code lost:
        if (r10.mDestroyed != false) goto L_0x043d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03b2, code lost:
        r0 = loadAnimation(r11, r13, HONEYCOMB, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03b6, code lost:
        if (r0 == null) goto L_0x03cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03b8, code lost:
        r11.mAnimatingAway = r11.mView;
        r11.mStateAfterAnimating = r12;
        r0.setAnimationListener(new android.support.p009v4.app.FragmentManagerImpl.C00765(r10, r11.mView, r0));
        r11.mView.startAnimation(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x03cd, code lost:
        r11.mContainer.removeView(r11.mView);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03d4, code lost:
        r11.mContainer = null;
        r11.mView = null;
        r11.mInnerView = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03de, code lost:
        if (DEBUG == false) goto L_0x03f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x03e0, code lost:
        android.util.Log.v(TAG, "movefrom CREATED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x03fa, code lost:
        if (r11.mRetaining != false) goto L_0x0427;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x03fc, code lost:
        r11.performDestroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x03ff, code lost:
        r11.mCalled = HONEYCOMB;
        r11.onDetach();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0406, code lost:
        if (r11.mCalled != false) goto L_0x042a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0426, code lost:
        throw new android.support.p009v4.app.SuperNotCalledException("Fragment " + r11 + " did not call through to super.onDetach()");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0427, code lost:
        r11.mState = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x042a, code lost:
        if (r15 != false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x042e, code lost:
        if (r11.mRetaining != false) goto L_0x0435;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0430, code lost:
        makeInactive(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0435, code lost:
        r11.mHost = null;
        r11.mParentFragment = null;
        r11.mFragmentManager = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x043d, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0440, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0176, code lost:
        if (r12 <= 1) goto L_0x026d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x017a, code lost:
        if (DEBUG == false) goto L_0x0194;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x017c, code lost:
        android.util.Log.v(TAG, "moveto ACTIVITY_CREATED: " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0196, code lost:
        if (r11.mFromLayout != false) goto L_0x025d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x019a, code lost:
        if (r11.mContainerId == 0) goto L_0x0440;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x019f, code lost:
        if (r11.mContainerId != -1) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01a1, code lost:
        throwException(new java.lang.IllegalArgumentException("Cannot create fragment " + r11 + " for a container view with no id"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01c2, code lost:
        r0 = (android.view.ViewGroup) r10.mContainer.onFindViewById(r11.mContainerId);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01cc, code lost:
        if (r0 != null) goto L_0x0211;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01d0, code lost:
        if (r11.mRestored != false) goto L_0x0211;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        r1 = r11.getResources().getResourceName(r11.mContainerId);
     */
    /* JADX WARNING: Removed duplicated region for block: B:198:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void moveToState(final android.support.p009v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
            r10 = this;
            r9 = 4
            r6 = 3
            r3 = 0
            r5 = 1
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
            if (r0 >= r12) goto L_0x02e4
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
                case 0: goto L_0x0080;
                case 1: goto L_0x0176;
                case 2: goto L_0x026d;
                case 3: goto L_0x0272;
                case 4: goto L_0x0293;
                default: goto L_0x0045;
            }
        L_0x0045:
            int r0 = r11.mState
            if (r0 == r12) goto L_0x0031
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveToState: Fragment state for "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r2 = " not updated inline; "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "expected state "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r12)
            java.lang.String r2 = " found "
            java.lang.StringBuilder r1 = r1.append(r2)
            int r2 = r11.mState
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r0, r1)
            r11.mState = r12
            goto L_0x0031
        L_0x0080:
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x009c
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto CREATED: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x009c:
            android.os.Bundle r0 = r11.mSavedFragmentState
            if (r0 == 0) goto L_0x00e4
            android.os.Bundle r0 = r11.mSavedFragmentState
            android.support.v4.app.FragmentHostCallback r1 = r10.mHost
            android.content.Context r1 = r1.getContext()
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
            if (r0 == 0) goto L_0x00d1
            android.os.Bundle r0 = r11.mSavedFragmentState
            java.lang.String r1 = "android:target_req_state"
            int r0 = r0.getInt(r1, r3)
            r11.mTargetRequestCode = r0
        L_0x00d1:
            android.os.Bundle r0 = r11.mSavedFragmentState
            java.lang.String r1 = "android:user_visible_hint"
            boolean r0 = r0.getBoolean(r1, r5)
            r11.mUserVisibleHint = r0
            boolean r0 = r11.mUserVisibleHint
            if (r0 != 0) goto L_0x00e4
            r11.mDeferStart = r5
            if (r12 <= r6) goto L_0x00e4
            r12 = r6
        L_0x00e4:
            android.support.v4.app.FragmentHostCallback r0 = r10.mHost
            r11.mHost = r0
            android.support.v4.app.Fragment r0 = r10.mParent
            r11.mParentFragment = r0
            android.support.v4.app.Fragment r0 = r10.mParent
            if (r0 == 0) goto L_0x0124
            android.support.v4.app.Fragment r0 = r10.mParent
            android.support.v4.app.FragmentManagerImpl r0 = r0.mChildFragmentManager
        L_0x00f4:
            r11.mFragmentManager = r0
            r11.mCalled = r3
            android.support.v4.app.FragmentHostCallback r0 = r10.mHost
            android.content.Context r0 = r0.getContext()
            r11.onAttach((android.content.Context) r0)
            boolean r0 = r11.mCalled
            if (r0 != 0) goto L_0x012b
            android.support.v4.app.SuperNotCalledException r0 = new android.support.v4.app.SuperNotCalledException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Fragment "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r2 = " did not call through to super.onAttach()"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0124:
            android.support.v4.app.FragmentHostCallback r0 = r10.mHost
            android.support.v4.app.FragmentManagerImpl r0 = r0.getFragmentManagerImpl()
            goto L_0x00f4
        L_0x012b:
            android.support.v4.app.Fragment r0 = r11.mParentFragment
            if (r0 != 0) goto L_0x0134
            android.support.v4.app.FragmentHostCallback r0 = r10.mHost
            r0.onAttachFragment(r11)
        L_0x0134:
            boolean r0 = r11.mRetaining
            if (r0 != 0) goto L_0x02ba
            android.os.Bundle r0 = r11.mSavedFragmentState
            r11.performCreate(r0)
        L_0x013d:
            r11.mRetaining = r3
            boolean r0 = r11.mFromLayout
            if (r0 == 0) goto L_0x0176
            android.os.Bundle r0 = r11.mSavedFragmentState
            android.view.LayoutInflater r0 = r11.getLayoutInflater(r0)
            android.os.Bundle r1 = r11.mSavedFragmentState
            android.view.View r0 = r11.performCreateView(r0, r7, r1)
            r11.mView = r0
            android.view.View r0 = r11.mView
            if (r0 == 0) goto L_0x02cd
            android.view.View r0 = r11.mView
            r11.mInnerView = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 11
            if (r0 < r1) goto L_0x02c3
            android.view.View r0 = r11.mView
            android.support.p009v4.view.C0247by.m899a((android.view.View) r0, (boolean) r3)
        L_0x0164:
            boolean r0 = r11.mHidden
            if (r0 == 0) goto L_0x016f
            android.view.View r0 = r11.mView
            r1 = 8
            r0.setVisibility(r1)
        L_0x016f:
            android.view.View r0 = r11.mView
            android.os.Bundle r1 = r11.mSavedFragmentState
            r11.onViewCreated(r0, r1)
        L_0x0176:
            if (r12 <= r5) goto L_0x026d
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x0194
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto ACTIVITY_CREATED: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x0194:
            boolean r0 = r11.mFromLayout
            if (r0 != 0) goto L_0x025d
            int r0 = r11.mContainerId
            if (r0 == 0) goto L_0x0440
            int r0 = r11.mContainerId
            r1 = -1
            if (r0 != r1) goto L_0x01c2
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot create fragment "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r2 = " for a container view with no id"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            r10.throwException(r0)
        L_0x01c2:
            android.support.v4.app.FragmentContainer r0 = r10.mContainer
            int r1 = r11.mContainerId
            android.view.View r0 = r0.onFindViewById(r1)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            if (r0 != 0) goto L_0x0211
            boolean r1 = r11.mRestored
            if (r1 != 0) goto L_0x0211
            android.content.res.Resources r1 = r11.getResources()     // Catch:{ NotFoundException -> 0x02d1 }
            int r2 = r11.mContainerId     // Catch:{ NotFoundException -> 0x02d1 }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x02d1 }
        L_0x01dc:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = "No view found for id 0x"
            java.lang.StringBuilder r4 = r4.append(r8)
            int r8 = r11.mContainerId
            java.lang.String r8 = java.lang.Integer.toHexString(r8)
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r8 = " ("
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.StringBuilder r1 = r4.append(r1)
            java.lang.String r4 = ") for fragment "
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            r10.throwException(r2)
        L_0x0211:
            r11.mContainer = r0
            android.os.Bundle r1 = r11.mSavedFragmentState
            android.view.LayoutInflater r1 = r11.getLayoutInflater(r1)
            android.os.Bundle r2 = r11.mSavedFragmentState
            android.view.View r1 = r11.performCreateView(r1, r0, r2)
            r11.mView = r1
            android.view.View r1 = r11.mView
            if (r1 == 0) goto L_0x02e0
            android.view.View r1 = r11.mView
            r11.mInnerView = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 11
            if (r1 < r2) goto L_0x02d6
            android.view.View r1 = r11.mView
            android.support.p009v4.view.C0247by.m899a((android.view.View) r1, (boolean) r3)
        L_0x0234:
            if (r0 == 0) goto L_0x024b
            android.view.animation.Animation r1 = r10.loadAnimation(r11, r13, r5, r14)
            if (r1 == 0) goto L_0x0246
            android.view.View r2 = r11.mView
            r10.setHWLayerAnimListenerIfAlpha(r2, r1)
            android.view.View r2 = r11.mView
            r2.startAnimation(r1)
        L_0x0246:
            android.view.View r1 = r11.mView
            r0.addView(r1)
        L_0x024b:
            boolean r0 = r11.mHidden
            if (r0 == 0) goto L_0x0256
            android.view.View r0 = r11.mView
            r1 = 8
            r0.setVisibility(r1)
        L_0x0256:
            android.view.View r0 = r11.mView
            android.os.Bundle r1 = r11.mSavedFragmentState
            r11.onViewCreated(r0, r1)
        L_0x025d:
            android.os.Bundle r0 = r11.mSavedFragmentState
            r11.performActivityCreated(r0)
            android.view.View r0 = r11.mView
            if (r0 == 0) goto L_0x026b
            android.os.Bundle r0 = r11.mSavedFragmentState
            r11.restoreViewState(r0)
        L_0x026b:
            r11.mSavedFragmentState = r7
        L_0x026d:
            r0 = 2
            if (r12 <= r0) goto L_0x0272
            r11.mState = r6
        L_0x0272:
            if (r12 <= r6) goto L_0x0293
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x0290
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto STARTED: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x0290:
            r11.performStart()
        L_0x0293:
            if (r12 <= r9) goto L_0x0045
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x02b1
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto RESUMED: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x02b1:
            r11.performResume()
            r11.mSavedFragmentState = r7
            r11.mSavedViewState = r7
            goto L_0x0045
        L_0x02ba:
            android.os.Bundle r0 = r11.mSavedFragmentState
            r11.restoreChildFragmentState(r0)
            r11.mState = r5
            goto L_0x013d
        L_0x02c3:
            android.view.View r0 = r11.mView
            android.view.ViewGroup r0 = android.support.p009v4.app.NoSaveStateFrameLayout.wrap(r0)
            r11.mView = r0
            goto L_0x0164
        L_0x02cd:
            r11.mInnerView = r7
            goto L_0x0176
        L_0x02d1:
            r1 = move-exception
            java.lang.String r1 = "unknown"
            goto L_0x01dc
        L_0x02d6:
            android.view.View r1 = r11.mView
            android.view.ViewGroup r1 = android.support.p009v4.app.NoSaveStateFrameLayout.wrap(r1)
            r11.mView = r1
            goto L_0x0234
        L_0x02e0:
            r11.mInnerView = r7
            goto L_0x025d
        L_0x02e4:
            int r0 = r11.mState
            if (r0 <= r12) goto L_0x0045
            int r0 = r11.mState
            switch(r0) {
                case 1: goto L_0x02ef;
                case 2: goto L_0x036d;
                case 3: goto L_0x034c;
                case 4: goto L_0x032b;
                case 5: goto L_0x0309;
                default: goto L_0x02ed;
            }
        L_0x02ed:
            goto L_0x0045
        L_0x02ef:
            if (r12 >= r5) goto L_0x0045
            boolean r0 = r10.mDestroyed
            if (r0 == 0) goto L_0x0300
            android.view.View r0 = r11.mAnimatingAway
            if (r0 == 0) goto L_0x0300
            android.view.View r0 = r11.mAnimatingAway
            r11.mAnimatingAway = r7
            r0.clearAnimation()
        L_0x0300:
            android.view.View r0 = r11.mAnimatingAway
            if (r0 == 0) goto L_0x03dc
            r11.mStateAfterAnimating = r12
            r12 = r5
            goto L_0x0045
        L_0x0309:
            r0 = 5
            if (r12 >= r0) goto L_0x032b
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x0328
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom RESUMED: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x0328:
            r11.performPause()
        L_0x032b:
            if (r12 >= r9) goto L_0x034c
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x0349
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom STARTED: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x0349:
            r11.performStop()
        L_0x034c:
            if (r12 >= r6) goto L_0x036d
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x036a
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom STOPPED: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x036a:
            r11.performReallyStop()
        L_0x036d:
            r0 = 2
            if (r12 >= r0) goto L_0x02ef
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x038c
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom ACTIVITY_CREATED: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x038c:
            android.view.View r0 = r11.mView
            if (r0 == 0) goto L_0x039f
            android.support.v4.app.FragmentHostCallback r0 = r10.mHost
            boolean r0 = r0.onShouldSaveFragmentState(r11)
            if (r0 == 0) goto L_0x039f
            android.util.SparseArray r0 = r11.mSavedViewState
            if (r0 != 0) goto L_0x039f
            r10.saveFragmentViewState(r11)
        L_0x039f:
            r11.performDestroyView()
            android.view.View r0 = r11.mView
            if (r0 == 0) goto L_0x03d4
            android.view.ViewGroup r0 = r11.mContainer
            if (r0 == 0) goto L_0x03d4
            int r0 = r10.mCurState
            if (r0 <= 0) goto L_0x043d
            boolean r0 = r10.mDestroyed
            if (r0 != 0) goto L_0x043d
            android.view.animation.Animation r0 = r10.loadAnimation(r11, r13, r3, r14)
        L_0x03b6:
            if (r0 == 0) goto L_0x03cd
            android.view.View r1 = r11.mView
            r11.mAnimatingAway = r1
            r11.mStateAfterAnimating = r12
            android.view.View r1 = r11.mView
            android.support.v4.app.FragmentManagerImpl$5 r2 = new android.support.v4.app.FragmentManagerImpl$5
            r2.<init>(r1, r0, r11)
            r0.setAnimationListener(r2)
            android.view.View r1 = r11.mView
            r1.startAnimation(r0)
        L_0x03cd:
            android.view.ViewGroup r0 = r11.mContainer
            android.view.View r1 = r11.mView
            r0.removeView(r1)
        L_0x03d4:
            r11.mContainer = r7
            r11.mView = r7
            r11.mInnerView = r7
            goto L_0x02ef
        L_0x03dc:
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x03f8
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom CREATED: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x03f8:
            boolean r0 = r11.mRetaining
            if (r0 != 0) goto L_0x0427
            r11.performDestroy()
        L_0x03ff:
            r11.mCalled = r3
            r11.onDetach()
            boolean r0 = r11.mCalled
            if (r0 != 0) goto L_0x042a
            android.support.v4.app.SuperNotCalledException r0 = new android.support.v4.app.SuperNotCalledException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Fragment "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r2 = " did not call through to super.onDetach()"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0427:
            r11.mState = r5
            goto L_0x03ff
        L_0x042a:
            if (r15 != 0) goto L_0x0045
            boolean r0 = r11.mRetaining
            if (r0 != 0) goto L_0x0435
            r10.makeInactive(r11)
            goto L_0x0045
        L_0x0435:
            r11.mHost = r7
            r11.mParentFragment = r7
            r11.mFragmentManager = r7
            goto L_0x0045
        L_0x043d:
            r0 = r7
            goto L_0x03b6
        L_0x0440:
            r0 = r7
            goto L_0x0211
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p009v4.app.FragmentManagerImpl.moveToState(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    public void noteStateNotSaved() {
        this.mStateSaved = HONEYCOMB;
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
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
        if (!Fragment.isSupportFragmentClass(this.mHost.getContext(), string)) {
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
            instantiate.mHost = this.mHost;
            instantiate.onInflate(this.mHost.getContext(), attributeSet, instantiate.mSavedFragmentState);
            addFragment(instantiate, true);
            fragment = instantiate;
        } else if (findFragmentById.mInLayout) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            findFragmentById.mInLayout = true;
            findFragmentById.mHost = this.mHost;
            if (!findFragmentById.mRetaining) {
                findFragmentById.onInflate(this.mHost.getContext(), attributeSet, findFragmentById.mSavedFragmentState);
            }
            fragment = findFragmentById;
        }
        if (this.mCurState >= 1 || !fragment.mFromLayout) {
            moveToState(fragment);
        } else {
            moveToState(fragment, 1, 0, 0, HONEYCOMB);
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

    public void performPendingDeferredStart(Fragment fragment) {
        if (!fragment.mDeferStart) {
            return;
        }
        if (this.mExecutingActions) {
            this.mHavePendingDeferredStart = true;
            return;
        }
        fragment.mDeferStart = HONEYCOMB;
        moveToState(fragment, this.mCurState, 0, 0, HONEYCOMB);
    }

    public void popBackStack() {
        enqueueAction(new Runnable() {
            public void run() {
                FragmentManagerImpl.this.popBackStackState(FragmentManagerImpl.this.mHost.getHandler(), (String) null, -1, 0);
            }
        }, HONEYCOMB);
    }

    public void popBackStack(final int i, final int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        enqueueAction(new Runnable() {
            public void run() {
                FragmentManagerImpl.this.popBackStackState(FragmentManagerImpl.this.mHost.getHandler(), (String) null, i, i2);
            }
        }, HONEYCOMB);
    }

    public void popBackStack(final String str, final int i) {
        enqueueAction(new Runnable() {
            public void run() {
                FragmentManagerImpl.this.popBackStackState(FragmentManagerImpl.this.mHost.getHandler(), str, -1, i);
            }
        }, HONEYCOMB);
    }

    public boolean popBackStackImmediate() {
        checkStateLoss();
        executePendingTransactions();
        return popBackStackState(this.mHost.getHandler(), (String) null, -1, 0);
    }

    public boolean popBackStackImmediate(int i, int i2) {
        checkStateLoss();
        executePendingTransactions();
        if (i >= 0) {
            return popBackStackState(this.mHost.getHandler(), (String) null, i, i2);
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    public boolean popBackStackImmediate(String str, int i) {
        checkStateLoss();
        executePendingTransactions();
        return popBackStackState(this.mHost.getHandler(), str, -1, i);
    }

    /* access modifiers changed from: package-private */
    public boolean popBackStackState(Handler handler, String str, int i, int i2) {
        int i3;
        if (this.mBackStack == null) {
            return HONEYCOMB;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = this.mBackStack.size() - 1;
            if (size < 0) {
                return HONEYCOMB;
            }
            BackStackRecord backStackRecord = (BackStackRecord) this.mBackStack.remove(size);
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            if (this.mCurState >= 1) {
                backStackRecord.calculateBackFragments(sparseArray, sparseArray2);
            }
            backStackRecord.popFromBackStack(true, (BackStackRecord.TransitionState) null, sparseArray, sparseArray2);
            reportBackStackChanged();
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
                    return HONEYCOMB;
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
                return HONEYCOMB;
            }
            ArrayList arrayList = new ArrayList();
            for (int size3 = this.mBackStack.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.mBackStack.remove(size3));
            }
            int size4 = arrayList.size() - 1;
            SparseArray sparseArray3 = new SparseArray();
            SparseArray sparseArray4 = new SparseArray();
            if (this.mCurState >= 1) {
                for (int i5 = 0; i5 <= size4; i5++) {
                    ((BackStackRecord) arrayList.get(i5)).calculateBackFragments(sparseArray3, sparseArray4);
                }
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
            reportBackStackChanged();
        }
        return true;
    }

    public void putFragment(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mIndex < 0) {
            throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.mIndex);
    }

    public void removeFragment(Fragment fragment, int i, int i2) {
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
            fragment.mAdded = HONEYCOMB;
            fragment.mRemoving = true;
            moveToState(fragment, z ? 0 : 1, i, i2, HONEYCOMB);
        }
    }

    public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener onBackStackChangedListener) {
        if (this.mBackStackChangeListeners != null) {
            this.mBackStackChangeListeners.remove(onBackStackChangedListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void reportBackStackChanged() {
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
    public void restoreAllState(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        List list;
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.mActive != null) {
                if (fragmentManagerNonConfig != null) {
                    List fragments = fragmentManagerNonConfig.getFragments();
                    List childNonConfigs = fragmentManagerNonConfig.getChildNonConfigs();
                    int size = fragments != null ? fragments.size() : 0;
                    for (int i = 0; i < size; i++) {
                        Fragment fragment = (Fragment) fragments.get(i);
                        if (DEBUG) {
                            Log.v(TAG, "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.mActive[fragment.mIndex];
                        fragmentState.mInstance = fragment;
                        fragment.mSavedViewState = null;
                        fragment.mBackStackNesting = 0;
                        fragment.mInLayout = HONEYCOMB;
                        fragment.mAdded = HONEYCOMB;
                        fragment.mTarget = null;
                        if (fragmentState.mSavedFragmentState != null) {
                            fragmentState.mSavedFragmentState.setClassLoader(this.mHost.getContext().getClassLoader());
                            fragment.mSavedViewState = fragmentState.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
                            fragment.mSavedFragmentState = fragmentState.mSavedFragmentState;
                        }
                    }
                    list = childNonConfigs;
                } else {
                    list = null;
                }
                this.mActive = new ArrayList(fragmentManagerState.mActive.length);
                if (this.mAvailIndices != null) {
                    this.mAvailIndices.clear();
                }
                int i2 = 0;
                while (i2 < fragmentManagerState.mActive.length) {
                    FragmentState fragmentState2 = fragmentManagerState.mActive[i2];
                    if (fragmentState2 != null) {
                        Fragment instantiate = fragmentState2.instantiate(this.mHost, this.mParent, (list == null || i2 >= list.size()) ? null : (FragmentManagerNonConfig) list.get(i2));
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
                    i2++;
                }
                if (fragmentManagerNonConfig != null) {
                    List fragments2 = fragmentManagerNonConfig.getFragments();
                    int size2 = fragments2 != null ? fragments2.size() : 0;
                    for (int i3 = 0; i3 < size2; i3++) {
                        Fragment fragment2 = (Fragment) fragments2.get(i3);
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
                            instantiate2.dump("  ", new PrintWriter(new C0140e(TAG)), HONEYCOMB);
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
    public FragmentManagerNonConfig retainNonConfig() {
        ArrayList arrayList;
        ArrayList arrayList2;
        boolean z;
        FragmentManagerNonConfig retainNonConfig;
        ArrayList arrayList3;
        if (this.mActive != null) {
            int i = 0;
            arrayList2 = null;
            arrayList = null;
            while (i < this.mActive.size()) {
                Fragment fragment = (Fragment) this.mActive.get(i);
                if (fragment != null) {
                    if (fragment.mRetainInstance) {
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
                    if (fragment.mChildFragmentManager == null || (retainNonConfig = fragment.mChildFragmentManager.retainNonConfig()) == null) {
                        z = false;
                    } else {
                        if (arrayList2 == null) {
                            arrayList3 = new ArrayList();
                            for (int i2 = 0; i2 < i; i2++) {
                                arrayList3.add((Object) null);
                            }
                        } else {
                            arrayList3 = arrayList2;
                        }
                        arrayList3.add(retainNonConfig);
                        arrayList2 = arrayList3;
                        z = true;
                    }
                    if (arrayList2 != null && !z) {
                        arrayList2.add((Object) null);
                    }
                }
                i++;
                arrayList = arrayList;
            }
        } else {
            arrayList2 = null;
            arrayList = null;
        }
        if (arrayList == null && arrayList2 == null) {
            return null;
        }
        return new FragmentManagerNonConfig(arrayList, arrayList2);
    }

    /* access modifiers changed from: package-private */
    public Parcelable saveAllState() {
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
                    backStackStateArr[i3] = new BackStackState((BackStackRecord) this.mBackStack.get(i3));
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
    public Bundle saveFragmentBasicState(Fragment fragment) {
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

    public Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
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
    public void saveFragmentViewState(Fragment fragment) {
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

    public void setBackStackIndex(int i, BackStackRecord backStackRecord) {
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

    public void showFragment(Fragment fragment, int i, int i2) {
        if (DEBUG) {
            Log.v(TAG, "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = HONEYCOMB;
            if (fragment.mView != null) {
                Animation loadAnimation = loadAnimation(fragment, i, true, i2);
                if (loadAnimation != null) {
                    setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                    fragment.mView.startAnimation(loadAnimation);
                }
                fragment.mView.setVisibility(0);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.onHiddenChanged(HONEYCOMB);
        }
    }

    /* access modifiers changed from: package-private */
    public void startPendingDeferredFragments() {
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

    public String toString() {
        StringBuilder sb = new StringBuilder(NotificationCompat.FLAG_HIGH_PRIORITY);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (this.mParent != null) {
            C0139d.m341a(this.mParent, sb);
        } else {
            C0139d.m341a(this.mHost, sb);
        }
        sb.append("}}");
        return sb.toString();
    }
}
