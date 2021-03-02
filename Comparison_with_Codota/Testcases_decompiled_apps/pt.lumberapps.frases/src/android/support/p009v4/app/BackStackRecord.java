package android.support.p009v4.app;

import android.os.Build;
import android.support.p009v4.app.FragmentManager;
import android.support.p009v4.app.FragmentTransitionCompat21;
import android.support.p009v4.p019f.C0136a;
import android.support.p009v4.p019f.C0140e;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewTreeObserver;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.app.BackStackRecord */
final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, Runnable {
    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SHOW = 5;
    static final boolean SUPPORTS_TRANSITIONS = (Build.VERSION.SDK_INT >= 21 ? true : SUPPORTS_TRANSITIONS);
    static final String TAG = "FragmentManager";
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack = true;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    boolean mCommitted;
    int mEnterAnim;
    int mExitAnim;
    C0067Op mHead;
    int mIndex = -1;
    final FragmentManagerImpl mManager;
    String mName;
    int mNumOp;
    int mPopEnterAnim;
    int mPopExitAnim;
    ArrayList mSharedElementSourceNames;
    ArrayList mSharedElementTargetNames;
    C0067Op mTail;
    int mTransition;
    int mTransitionStyle;

    /* renamed from: android.support.v4.app.BackStackRecord$Op */
    final class C0067Op {
        int cmd;
        int enterAnim;
        int exitAnim;
        Fragment fragment;
        C0067Op next;
        int popEnterAnim;
        int popExitAnim;
        C0067Op prev;
        ArrayList removed;

        C0067Op() {
        }
    }

    /* renamed from: android.support.v4.app.BackStackRecord$TransitionState */
    public class TransitionState {
        public FragmentTransitionCompat21.EpicenterView enteringEpicenterView = new FragmentTransitionCompat21.EpicenterView();
        public ArrayList hiddenFragmentViews = new ArrayList();
        public C0136a nameOverrides = new C0136a();
        public View nonExistentView;

        public TransitionState() {
        }
    }

    public BackStackRecord(FragmentManagerImpl fragmentManagerImpl) {
        this.mManager = fragmentManagerImpl;
    }

    private TransitionState beginTransition(SparseArray sparseArray, SparseArray sparseArray2, boolean z) {
        TransitionState transitionState = new TransitionState();
        transitionState.nonExistentView = new View(this.mManager.mHost.getContext());
        int i = 0;
        boolean z2 = false;
        while (i < sparseArray.size()) {
            boolean z3 = configureTransitions(sparseArray.keyAt(i), transitionState, z, sparseArray, sparseArray2) ? true : z2;
            i++;
            z2 = z3;
        }
        for (int i2 = 0; i2 < sparseArray2.size(); i2++) {
            int keyAt = sparseArray2.keyAt(i2);
            if (sparseArray.get(keyAt) == null && configureTransitions(keyAt, transitionState, z, sparseArray, sparseArray2)) {
                z2 = true;
            }
        }
        if (!z2) {
            return null;
        }
        return transitionState;
    }

    private void calculateFragments(SparseArray sparseArray, SparseArray sparseArray2) {
        if (this.mManager.mContainer.onHasView()) {
            for (C0067Op op = this.mHead; op != null; op = op.next) {
                switch (op.cmd) {
                    case 1:
                        setLastIn(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 2:
                        Fragment fragment = op.fragment;
                        if (this.mManager.mAdded != null) {
                            int i = 0;
                            Fragment fragment2 = fragment;
                            while (true) {
                                int i2 = i;
                                if (i2 < this.mManager.mAdded.size()) {
                                    Fragment fragment3 = (Fragment) this.mManager.mAdded.get(i2);
                                    if (fragment2 == null || fragment3.mContainerId == fragment2.mContainerId) {
                                        if (fragment3 == fragment2) {
                                            fragment2 = null;
                                            sparseArray2.remove(fragment3.mContainerId);
                                        } else {
                                            setFirstOut(sparseArray, sparseArray2, fragment3);
                                        }
                                    }
                                    i = i2 + 1;
                                }
                            }
                        }
                        setLastIn(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 3:
                        setFirstOut(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 4:
                        setFirstOut(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 5:
                        setLastIn(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 6:
                        setFirstOut(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 7:
                        setLastIn(sparseArray, sparseArray2, op.fragment);
                        break;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void callSharedElementEnd(TransitionState transitionState, Fragment fragment, Fragment fragment2, boolean z, C0136a aVar) {
        SharedElementCallback sharedElementCallback = z ? fragment2.mEnterTransitionCallback : fragment.mEnterTransitionCallback;
        if (sharedElementCallback != null) {
            sharedElementCallback.onSharedElementEnd(new ArrayList(aVar.keySet()), new ArrayList(aVar.values()), (List) null);
        }
    }

    private static Object captureExitingViews(Object obj, Fragment fragment, ArrayList arrayList, C0136a aVar, View view) {
        return obj != null ? FragmentTransitionCompat21.captureExitingViews(obj, fragment.getView(), arrayList, aVar, view) : obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0143 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x014b A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean configureTransitions(int r36, android.support.p009v4.app.BackStackRecord.TransitionState r37, boolean r38, android.util.SparseArray r39, android.util.SparseArray r40) {
        /*
            r35 = this;
            r0 = r35
            android.support.v4.app.FragmentManagerImpl r4 = r0.mManager
            android.support.v4.app.FragmentContainer r4 = r4.mContainer
            r0 = r36
            android.view.View r6 = r4.onFindViewById(r0)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            if (r6 != 0) goto L_0x0012
            r4 = 0
        L_0x0011:
            return r4
        L_0x0012:
            r0 = r40
            r1 = r36
            java.lang.Object r8 = r0.get(r1)
            android.support.v4.app.Fragment r8 = (android.support.p009v4.app.Fragment) r8
            r0 = r39
            r1 = r36
            java.lang.Object r9 = r0.get(r1)
            android.support.v4.app.Fragment r9 = (android.support.p009v4.app.Fragment) r9
            r0 = r38
            java.lang.Object r12 = getEnterTransition(r8, r0)
            r0 = r38
            java.lang.Object r7 = getSharedElementTransition(r8, r9, r0)
            r0 = r38
            java.lang.Object r13 = getExitTransition(r9, r0)
            r22 = 0
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            if (r7 == 0) goto L_0x0083
            r0 = r35
            r1 = r37
            r2 = r38
            android.support.v4.f.a r22 = r0.remapSharedElements(r1, r9, r2)
            boolean r4 = r22.isEmpty()
            if (r4 == 0) goto L_0x005e
            r7 = 0
            r22 = 0
            r30 = r7
        L_0x0056:
            if (r12 != 0) goto L_0x0089
            if (r30 != 0) goto L_0x0089
            if (r13 != 0) goto L_0x0089
            r4 = 0
            goto L_0x0011
        L_0x005e:
            if (r38 == 0) goto L_0x0086
            android.support.v4.app.SharedElementCallback r4 = r9.mEnterTransitionCallback
        L_0x0062:
            if (r4 == 0) goto L_0x007a
            java.util.ArrayList r5 = new java.util.ArrayList
            java.util.Set r10 = r22.keySet()
            r5.<init>(r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            java.util.Collection r14 = r22.values()
            r10.<init>(r14)
            r14 = 0
            r4.onSharedElementStart(r5, r10, r14)
        L_0x007a:
            r4 = r35
            r5 = r37
            r10 = r38
            r4.prepareSharedElementTransition(r5, r6, r7, r8, r9, r10, r11, r12, r13)
        L_0x0083:
            r30 = r7
            goto L_0x0056
        L_0x0086:
            android.support.v4.app.SharedElementCallback r4 = r8.mEnterTransitionCallback
            goto L_0x0062
        L_0x0089:
            java.util.ArrayList r21 = new java.util.ArrayList
            r21.<init>()
            r0 = r37
            android.view.View r4 = r0.nonExistentView
            r0 = r21
            r1 = r22
            java.lang.Object r14 = captureExitingViews(r13, r9, r0, r1, r4)
            r0 = r35
            java.util.ArrayList r4 = r0.mSharedElementTargetNames
            if (r4 == 0) goto L_0x00c1
            if (r22 == 0) goto L_0x00c1
            r0 = r35
            java.util.ArrayList r4 = r0.mSharedElementTargetNames
            r5 = 0
            java.lang.Object r4 = r4.get(r5)
            r0 = r22
            java.lang.Object r4 = r0.get(r4)
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L_0x00c1
            if (r14 == 0) goto L_0x00ba
            android.support.p009v4.app.FragmentTransitionCompat21.setEpicenter(r14, r4)
        L_0x00ba:
            if (r30 == 0) goto L_0x00c1
            r0 = r30
            android.support.p009v4.app.FragmentTransitionCompat21.setEpicenter(r0, r4)
        L_0x00c1:
            android.support.v4.app.BackStackRecord$1 r16 = new android.support.v4.app.BackStackRecord$1
            r0 = r16
            r1 = r35
            r0.<init>(r8)
            java.util.ArrayList r20 = new java.util.ArrayList
            r20.<init>()
            android.support.v4.f.a r23 = new android.support.v4.f.a
            r23.<init>()
            r4 = 1
            if (r8 == 0) goto L_0x00dd
            if (r38 == 0) goto L_0x0146
            boolean r4 = r8.getAllowReturnTransitionOverlap()
        L_0x00dd:
            r0 = r30
            java.lang.Object r32 = android.support.p009v4.app.FragmentTransitionCompat21.mergeTransitions(r12, r14, r0, r4)
            if (r32 == 0) goto L_0x0141
            r0 = r37
            android.view.View r0 = r0.nonExistentView
            r17 = r0
            r0 = r37
            android.support.v4.app.FragmentTransitionCompat21$EpicenterView r0 = r0.enteringEpicenterView
            r18 = r0
            r0 = r37
            android.support.v4.f.a r0 = r0.nameOverrides
            r19 = r0
            r13 = r30
            r15 = r6
            r24 = r11
            android.support.p009v4.app.FragmentTransitionCompat21.addTransitionTargets(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r0 = r35
            r1 = r37
            r2 = r36
            r3 = r32
            r0.excludeHiddenFragmentsAfterEnter(r6, r1, r2, r3)
            r0 = r37
            android.view.View r4 = r0.nonExistentView
            r5 = 1
            r0 = r32
            android.support.p009v4.app.FragmentTransitionCompat21.excludeTarget(r0, r4, r5)
            r0 = r35
            r1 = r37
            r2 = r36
            r3 = r32
            r0.excludeHiddenFragments(r1, r2, r3)
            r0 = r32
            android.support.p009v4.app.FragmentTransitionCompat21.beginDelayedTransition(r6, r0)
            r0 = r37
            android.view.View r0 = r0.nonExistentView
            r25 = r0
            r0 = r37
            java.util.ArrayList r0 = r0.hiddenFragmentViews
            r33 = r0
            r24 = r6
            r26 = r12
            r27 = r20
            r28 = r14
            r29 = r21
            r31 = r11
            r34 = r23
            android.support.p009v4.app.FragmentTransitionCompat21.cleanupTransitions(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
        L_0x0141:
            if (r32 == 0) goto L_0x014b
            r4 = 1
            goto L_0x0011
        L_0x0146:
            boolean r4 = r8.getAllowEnterTransitionOverlap()
            goto L_0x00dd
        L_0x014b:
            r4 = 0
            goto L_0x0011
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p009v4.app.BackStackRecord.configureTransitions(int, android.support.v4.app.BackStackRecord$TransitionState, boolean, android.util.SparseArray, android.util.SparseArray):boolean");
    }

    private void doAddOp(int i, Fragment fragment, String str, int i2) {
        fragment.mFragmentManager = this.mManager;
        if (str != null) {
            if (fragment.mTag == null || str.equals(fragment.mTag)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            } else if (fragment.mFragmentId == 0 || fragment.mFragmentId == i) {
                fragment.mFragmentId = i;
                fragment.mContainerId = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
        }
        C0067Op op = new C0067Op();
        op.cmd = i2;
        op.fragment = fragment;
        addOp(op);
    }

    /* access modifiers changed from: private */
    public void excludeHiddenFragments(TransitionState transitionState, int i, Object obj) {
        if (this.mManager.mAdded != null) {
            for (int i2 = 0; i2 < this.mManager.mAdded.size(); i2++) {
                Fragment fragment = (Fragment) this.mManager.mAdded.get(i2);
                if (!(fragment.mView == null || fragment.mContainer == null || fragment.mContainerId != i)) {
                    if (!fragment.mHidden) {
                        FragmentTransitionCompat21.excludeTarget(obj, fragment.mView, SUPPORTS_TRANSITIONS);
                        transitionState.hiddenFragmentViews.remove(fragment.mView);
                    } else if (!transitionState.hiddenFragmentViews.contains(fragment.mView)) {
                        FragmentTransitionCompat21.excludeTarget(obj, fragment.mView, true);
                        transitionState.hiddenFragmentViews.add(fragment.mView);
                    }
                }
            }
        }
    }

    private void excludeHiddenFragmentsAfterEnter(View view, TransitionState transitionState, int i, Object obj) {
        final View view2 = view;
        final TransitionState transitionState2 = transitionState;
        final int i2 = i;
        final Object obj2 = obj;
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                BackStackRecord.this.excludeHiddenFragments(transitionState2, i2, obj2);
                return true;
            }
        });
    }

    private static Object getEnterTransition(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return FragmentTransitionCompat21.cloneTransition(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Object getExitTransition(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return FragmentTransitionCompat21.cloneTransition(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    private static Object getSharedElementTransition(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return FragmentTransitionCompat21.wrapSharedElementTransition(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition());
    }

    private C0136a mapEnteringSharedElements(TransitionState transitionState, Fragment fragment, boolean z) {
        C0136a aVar = new C0136a();
        View view = fragment.getView();
        if (view == null || this.mSharedElementSourceNames == null) {
            return aVar;
        }
        FragmentTransitionCompat21.findNamedViews(aVar, view);
        if (z) {
            return remapNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames, aVar);
        }
        aVar.mo1036a(this.mSharedElementTargetNames);
        return aVar;
    }

    /* access modifiers changed from: private */
    public C0136a mapSharedElementsIn(TransitionState transitionState, boolean z, Fragment fragment) {
        C0136a mapEnteringSharedElements = mapEnteringSharedElements(transitionState, fragment, z);
        if (z) {
            if (fragment.mExitTransitionCallback != null) {
                fragment.mExitTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, mapEnteringSharedElements);
            }
            setBackNameOverrides(transitionState, mapEnteringSharedElements, true);
        } else {
            if (fragment.mEnterTransitionCallback != null) {
                fragment.mEnterTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, mapEnteringSharedElements);
            }
            setNameOverrides(transitionState, mapEnteringSharedElements, true);
        }
        return mapEnteringSharedElements;
    }

    private void prepareSharedElementTransition(TransitionState transitionState, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList, Object obj2, Object obj3) {
        if (obj != null) {
            final View view2 = view;
            final Object obj4 = obj;
            final ArrayList arrayList2 = arrayList;
            final TransitionState transitionState2 = transitionState;
            final Object obj5 = obj2;
            final Object obj6 = obj3;
            final boolean z2 = z;
            final Fragment fragment3 = fragment;
            final Fragment fragment4 = fragment2;
            view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    view2.getViewTreeObserver().removeOnPreDrawListener(this);
                    FragmentTransitionCompat21.removeTargets(obj4, arrayList2);
                    arrayList2.remove(transitionState2.nonExistentView);
                    FragmentTransitionCompat21.excludeSharedElementViews(obj5, obj6, obj4, arrayList2, BackStackRecord.SUPPORTS_TRANSITIONS);
                    arrayList2.clear();
                    C0136a access$000 = BackStackRecord.this.mapSharedElementsIn(transitionState2, z2, fragment3);
                    FragmentTransitionCompat21.setSharedElementTargets(obj4, transitionState2.nonExistentView, access$000, arrayList2);
                    BackStackRecord.this.setEpicenterIn(access$000, transitionState2);
                    BackStackRecord.this.callSharedElementEnd(transitionState2, fragment3, fragment4, z2, access$000);
                    FragmentTransitionCompat21.excludeSharedElementViews(obj5, obj6, obj4, arrayList2, true);
                    return true;
                }
            });
        }
    }

    private static C0136a remapNames(ArrayList arrayList, ArrayList arrayList2, C0136a aVar) {
        if (aVar.isEmpty()) {
            return aVar;
        }
        C0136a aVar2 = new C0136a();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) aVar.get(arrayList.get(i));
            if (view != null) {
                aVar2.put(arrayList2.get(i), view);
            }
        }
        return aVar2;
    }

    private C0136a remapSharedElements(TransitionState transitionState, Fragment fragment, boolean z) {
        C0136a aVar = new C0136a();
        if (this.mSharedElementSourceNames != null) {
            FragmentTransitionCompat21.findNamedViews(aVar, fragment.getView());
            if (z) {
                aVar.mo1036a(this.mSharedElementTargetNames);
            } else {
                aVar = remapNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames, aVar);
            }
        }
        if (z) {
            if (fragment.mEnterTransitionCallback != null) {
                fragment.mEnterTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, aVar);
            }
            setBackNameOverrides(transitionState, aVar, SUPPORTS_TRANSITIONS);
        } else {
            if (fragment.mExitTransitionCallback != null) {
                fragment.mExitTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, aVar);
            }
            setNameOverrides(transitionState, aVar, (boolean) SUPPORTS_TRANSITIONS);
        }
        return aVar;
    }

    private void setBackNameOverrides(TransitionState transitionState, C0136a aVar, boolean z) {
        int size = this.mSharedElementTargetNames == null ? 0 : this.mSharedElementTargetNames.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.mSharedElementSourceNames.get(i);
            View view = (View) aVar.get((String) this.mSharedElementTargetNames.get(i));
            if (view != null) {
                String transitionName = FragmentTransitionCompat21.getTransitionName(view);
                if (z) {
                    setNameOverride(transitionState.nameOverrides, str, transitionName);
                } else {
                    setNameOverride(transitionState.nameOverrides, transitionName, str);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void setEpicenterIn(C0136a aVar, TransitionState transitionState) {
        View view;
        if (this.mSharedElementTargetNames != null && !aVar.isEmpty() && (view = (View) aVar.get(this.mSharedElementTargetNames.get(0))) != null) {
            transitionState.enteringEpicenterView.epicenter = view;
        }
    }

    private static void setFirstOut(SparseArray sparseArray, SparseArray sparseArray2, Fragment fragment) {
        int i;
        if (fragment != null && (i = fragment.mContainerId) != 0 && !fragment.isHidden()) {
            if (fragment.isAdded() && fragment.getView() != null && sparseArray.get(i) == null) {
                sparseArray.put(i, fragment);
            }
            if (sparseArray2.get(i) == fragment) {
                sparseArray2.remove(i);
            }
        }
    }

    private void setLastIn(SparseArray sparseArray, SparseArray sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.mContainerId;
            if (i != 0) {
                if (!fragment.isAdded()) {
                    sparseArray2.put(i, fragment);
                }
                if (sparseArray.get(i) == fragment) {
                    sparseArray.remove(i);
                }
            }
            if (fragment.mState < 1 && this.mManager.mCurState >= 1) {
                this.mManager.makeActive(fragment);
                this.mManager.moveToState(fragment, 1, 0, 0, SUPPORTS_TRANSITIONS);
            }
        }
    }

    private static void setNameOverride(C0136a aVar, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < aVar.size(); i++) {
                if (str.equals(aVar.mo1153c(i))) {
                    aVar.mo1148a(i, (Object) str2);
                    return;
                }
            }
            aVar.put(str, str2);
        }
    }

    private void setNameOverrides(TransitionState transitionState, C0136a aVar, boolean z) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            String str = (String) aVar.mo1152b(i);
            String transitionName = FragmentTransitionCompat21.getTransitionName((View) aVar.mo1153c(i));
            if (z) {
                setNameOverride(transitionState.nameOverrides, str, transitionName);
            } else {
                setNameOverride(transitionState.nameOverrides, transitionName, str);
            }
        }
    }

    private static void setNameOverrides(TransitionState transitionState, ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    setNameOverride(transitionState.nameOverrides, (String) arrayList.get(i2), (String) arrayList2.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public FragmentTransaction add(int i, Fragment fragment) {
        doAddOp(i, fragment, (String) null, 1);
        return this;
    }

    public FragmentTransaction add(int i, Fragment fragment, String str) {
        doAddOp(i, fragment, str, 1);
        return this;
    }

    public FragmentTransaction add(Fragment fragment, String str) {
        doAddOp(0, fragment, str, 1);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void addOp(C0067Op op) {
        if (this.mHead == null) {
            this.mTail = op;
            this.mHead = op;
        } else {
            op.prev = this.mTail;
            this.mTail.next = op;
            this.mTail = op;
        }
        op.enterAnim = this.mEnterAnim;
        op.exitAnim = this.mExitAnim;
        op.popEnterAnim = this.mPopEnterAnim;
        op.popExitAnim = this.mPopExitAnim;
        this.mNumOp++;
    }

    public FragmentTransaction addSharedElement(View view, String str) {
        if (SUPPORTS_TRANSITIONS) {
            String transitionName = FragmentTransitionCompat21.getTransitionName(view);
            if (transitionName == null) {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            if (this.mSharedElementSourceNames == null) {
                this.mSharedElementSourceNames = new ArrayList();
                this.mSharedElementTargetNames = new ArrayList();
            }
            this.mSharedElementSourceNames.add(transitionName);
            this.mSharedElementTargetNames.add(str);
        }
        return this;
    }

    public FragmentTransaction addToBackStack(String str) {
        if (!this.mAllowAddToBackStack) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.mAddToBackStack = true;
        this.mName = str;
        return this;
    }

    public FragmentTransaction attach(Fragment fragment) {
        C0067Op op = new C0067Op();
        op.cmd = 7;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void bumpBackStackNesting(int i) {
        if (this.mAddToBackStack) {
            if (FragmentManagerImpl.DEBUG) {
                Log.v(TAG, "Bump nesting in " + this + " by " + i);
            }
            for (C0067Op op = this.mHead; op != null; op = op.next) {
                if (op.fragment != null) {
                    op.fragment.mBackStackNesting += i;
                    if (FragmentManagerImpl.DEBUG) {
                        Log.v(TAG, "Bump nesting of " + op.fragment + " to " + op.fragment.mBackStackNesting);
                    }
                }
                if (op.removed != null) {
                    for (int size = op.removed.size() - 1; size >= 0; size--) {
                        Fragment fragment = (Fragment) op.removed.get(size);
                        fragment.mBackStackNesting += i;
                        if (FragmentManagerImpl.DEBUG) {
                            Log.v(TAG, "Bump nesting of " + fragment + " to " + fragment.mBackStackNesting);
                        }
                    }
                }
            }
        }
    }

    public void calculateBackFragments(SparseArray sparseArray, SparseArray sparseArray2) {
        if (this.mManager.mContainer.onHasView()) {
            for (C0067Op op = this.mTail; op != null; op = op.prev) {
                switch (op.cmd) {
                    case 1:
                        setFirstOut(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 2:
                        if (op.removed != null) {
                            for (int size = op.removed.size() - 1; size >= 0; size--) {
                                setLastIn(sparseArray, sparseArray2, (Fragment) op.removed.get(size));
                            }
                        }
                        setFirstOut(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 3:
                        setLastIn(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 4:
                        setLastIn(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 5:
                        setFirstOut(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 6:
                        setLastIn(sparseArray, sparseArray2, op.fragment);
                        break;
                    case 7:
                        setFirstOut(sparseArray, sparseArray2, op.fragment);
                        break;
                }
            }
        }
    }

    public int commit() {
        return commitInternal(SUPPORTS_TRANSITIONS);
    }

    public int commitAllowingStateLoss() {
        return commitInternal(true);
    }

    /* access modifiers changed from: package-private */
    public int commitInternal(boolean z) {
        if (this.mCommitted) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManagerImpl.DEBUG) {
            Log.v(TAG, "Commit: " + this);
            dump("  ", (FileDescriptor) null, new PrintWriter(new C0140e(TAG)), (String[]) null);
        }
        this.mCommitted = true;
        if (this.mAddToBackStack) {
            this.mIndex = this.mManager.allocBackStackIndex(this);
        } else {
            this.mIndex = -1;
        }
        this.mManager.enqueueAction(this, z);
        return this.mIndex;
    }

    public void commitNow() {
        disallowAddToBackStack();
        this.mManager.execSingleAction(this, SUPPORTS_TRANSITIONS);
    }

    public void commitNowAllowingStateLoss() {
        disallowAddToBackStack();
        this.mManager.execSingleAction(this, true);
    }

    public FragmentTransaction detach(Fragment fragment) {
        C0067Op op = new C0067Op();
        op.cmd = 6;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    public FragmentTransaction disallowAddToBackStack() {
        if (this.mAddToBackStack) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.mAllowAddToBackStack = SUPPORTS_TRANSITIONS;
        return this;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        dump(str, printWriter, true);
    }

    public void dump(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.mCommitted);
            if (this.mTransition != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.mTransition));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.mTransitionStyle));
            }
            if (!(this.mEnterAnim == 0 && this.mExitAnim == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mEnterAnim));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.mExitAnim));
            }
            if (!(this.mPopEnterAnim == 0 && this.mPopExitAnim == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mPopEnterAnim));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (!(this.mBreadCrumbTitleRes == 0 && this.mBreadCrumbTitleText == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.mBreadCrumbTitleText);
            }
            if (!(this.mBreadCrumbShortTitleRes == 0 && this.mBreadCrumbShortTitleText == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.mBreadCrumbShortTitleText);
            }
        }
        if (this.mHead != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str3 = str + "    ";
            int i = 0;
            C0067Op op = this.mHead;
            while (op != null) {
                switch (op.cmd) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    default:
                        str2 = "cmd=" + op.cmd;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(op.fragment);
                if (z) {
                    if (!(op.enterAnim == 0 && op.exitAnim == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(op.enterAnim));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(op.exitAnim));
                    }
                    if (!(op.popEnterAnim == 0 && op.popExitAnim == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(op.popEnterAnim));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(op.popExitAnim));
                    }
                }
                if (op.removed != null && op.removed.size() > 0) {
                    for (int i2 = 0; i2 < op.removed.size(); i2++) {
                        printWriter.print(str3);
                        if (op.removed.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str3);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(op.removed.get(i2));
                    }
                }
                op = op.next;
                i++;
            }
        }
    }

    public CharSequence getBreadCrumbShortTitle() {
        return this.mBreadCrumbShortTitleRes != 0 ? this.mManager.mHost.getContext().getText(this.mBreadCrumbShortTitleRes) : this.mBreadCrumbShortTitleText;
    }

    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }

    public CharSequence getBreadCrumbTitle() {
        return this.mBreadCrumbTitleRes != 0 ? this.mManager.mHost.getContext().getText(this.mBreadCrumbTitleRes) : this.mBreadCrumbTitleText;
    }

    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }

    public int getId() {
        return this.mIndex;
    }

    public String getName() {
        return this.mName;
    }

    public int getTransition() {
        return this.mTransition;
    }

    public int getTransitionStyle() {
        return this.mTransitionStyle;
    }

    public FragmentTransaction hide(Fragment fragment) {
        C0067Op op = new C0067Op();
        op.cmd = 4;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    public boolean isEmpty() {
        if (this.mNumOp == 0) {
            return true;
        }
        return SUPPORTS_TRANSITIONS;
    }

    public TransitionState popFromBackStack(boolean z, TransitionState transitionState, SparseArray sparseArray, SparseArray sparseArray2) {
        if (FragmentManagerImpl.DEBUG) {
            Log.v(TAG, "popFromBackStack: " + this);
            dump("  ", (FileDescriptor) null, new PrintWriter(new C0140e(TAG)), (String[]) null);
        }
        if (SUPPORTS_TRANSITIONS && this.mManager.mCurState >= 1) {
            if (transitionState == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    transitionState = beginTransition(sparseArray, sparseArray2, true);
                }
            } else if (!z) {
                setNameOverrides(transitionState, this.mSharedElementTargetNames, this.mSharedElementSourceNames);
            }
        }
        bumpBackStackNesting(-1);
        int i = transitionState != null ? 0 : this.mTransitionStyle;
        int i2 = transitionState != null ? 0 : this.mTransition;
        for (C0067Op op = this.mTail; op != null; op = op.prev) {
            int i3 = transitionState != null ? 0 : op.popEnterAnim;
            int i4 = transitionState != null ? 0 : op.popExitAnim;
            switch (op.cmd) {
                case 1:
                    Fragment fragment = op.fragment;
                    fragment.mNextAnim = i4;
                    this.mManager.removeFragment(fragment, FragmentManagerImpl.reverseTransit(i2), i);
                    break;
                case 2:
                    Fragment fragment2 = op.fragment;
                    if (fragment2 != null) {
                        fragment2.mNextAnim = i4;
                        this.mManager.removeFragment(fragment2, FragmentManagerImpl.reverseTransit(i2), i);
                    }
                    if (op.removed == null) {
                        break;
                    } else {
                        for (int i5 = 0; i5 < op.removed.size(); i5++) {
                            Fragment fragment3 = (Fragment) op.removed.get(i5);
                            fragment3.mNextAnim = i3;
                            this.mManager.addFragment(fragment3, SUPPORTS_TRANSITIONS);
                        }
                        break;
                    }
                case 3:
                    Fragment fragment4 = op.fragment;
                    fragment4.mNextAnim = i3;
                    this.mManager.addFragment(fragment4, SUPPORTS_TRANSITIONS);
                    break;
                case 4:
                    Fragment fragment5 = op.fragment;
                    fragment5.mNextAnim = i3;
                    this.mManager.showFragment(fragment5, FragmentManagerImpl.reverseTransit(i2), i);
                    break;
                case 5:
                    Fragment fragment6 = op.fragment;
                    fragment6.mNextAnim = i4;
                    this.mManager.hideFragment(fragment6, FragmentManagerImpl.reverseTransit(i2), i);
                    break;
                case 6:
                    Fragment fragment7 = op.fragment;
                    fragment7.mNextAnim = i3;
                    this.mManager.attachFragment(fragment7, FragmentManagerImpl.reverseTransit(i2), i);
                    break;
                case 7:
                    Fragment fragment8 = op.fragment;
                    fragment8.mNextAnim = i3;
                    this.mManager.detachFragment(fragment8, FragmentManagerImpl.reverseTransit(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.cmd);
            }
        }
        if (z) {
            this.mManager.moveToState(this.mManager.mCurState, FragmentManagerImpl.reverseTransit(i2), i, true);
            transitionState = null;
        }
        if (this.mIndex >= 0) {
            this.mManager.freeBackStackIndex(this.mIndex);
            this.mIndex = -1;
        }
        return transitionState;
    }

    public FragmentTransaction remove(Fragment fragment) {
        C0067Op op = new C0067Op();
        op.cmd = 3;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    public FragmentTransaction replace(int i, Fragment fragment) {
        return replace(i, fragment, (String) null);
    }

    public FragmentTransaction replace(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        doAddOp(i, fragment, str, 2);
        return this;
    }

    public void run() {
        TransitionState transitionState;
        Fragment fragment;
        if (FragmentManagerImpl.DEBUG) {
            Log.v(TAG, "Run: " + this);
        }
        if (!this.mAddToBackStack || this.mIndex >= 0) {
            bumpBackStackNesting(1);
            if (!SUPPORTS_TRANSITIONS || this.mManager.mCurState < 1) {
                transitionState = null;
            } else {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                calculateFragments(sparseArray, sparseArray2);
                transitionState = beginTransition(sparseArray, sparseArray2, SUPPORTS_TRANSITIONS);
            }
            int i = transitionState != null ? 0 : this.mTransitionStyle;
            int i2 = transitionState != null ? 0 : this.mTransition;
            for (C0067Op op = this.mHead; op != null; op = op.next) {
                int i3 = transitionState != null ? 0 : op.enterAnim;
                int i4 = transitionState != null ? 0 : op.exitAnim;
                switch (op.cmd) {
                    case 1:
                        Fragment fragment2 = op.fragment;
                        fragment2.mNextAnim = i3;
                        this.mManager.addFragment(fragment2, SUPPORTS_TRANSITIONS);
                        break;
                    case 2:
                        Fragment fragment3 = op.fragment;
                        int i5 = fragment3.mContainerId;
                        if (this.mManager.mAdded != null) {
                            int size = this.mManager.mAdded.size() - 1;
                            while (size >= 0) {
                                Fragment fragment4 = (Fragment) this.mManager.mAdded.get(size);
                                if (FragmentManagerImpl.DEBUG) {
                                    Log.v(TAG, "OP_REPLACE: adding=" + fragment3 + " old=" + fragment4);
                                }
                                if (fragment4.mContainerId == i5) {
                                    if (fragment4 == fragment3) {
                                        fragment = null;
                                        op.fragment = null;
                                        size--;
                                        fragment3 = fragment;
                                    } else {
                                        if (op.removed == null) {
                                            op.removed = new ArrayList();
                                        }
                                        op.removed.add(fragment4);
                                        fragment4.mNextAnim = i4;
                                        if (this.mAddToBackStack) {
                                            fragment4.mBackStackNesting++;
                                            if (FragmentManagerImpl.DEBUG) {
                                                Log.v(TAG, "Bump nesting of " + fragment4 + " to " + fragment4.mBackStackNesting);
                                            }
                                        }
                                        this.mManager.removeFragment(fragment4, i2, i);
                                    }
                                }
                                fragment = fragment3;
                                size--;
                                fragment3 = fragment;
                            }
                        }
                        if (fragment3 == null) {
                            break;
                        } else {
                            fragment3.mNextAnim = i3;
                            this.mManager.addFragment(fragment3, SUPPORTS_TRANSITIONS);
                            break;
                        }
                    case 3:
                        Fragment fragment5 = op.fragment;
                        fragment5.mNextAnim = i4;
                        this.mManager.removeFragment(fragment5, i2, i);
                        break;
                    case 4:
                        Fragment fragment6 = op.fragment;
                        fragment6.mNextAnim = i4;
                        this.mManager.hideFragment(fragment6, i2, i);
                        break;
                    case 5:
                        Fragment fragment7 = op.fragment;
                        fragment7.mNextAnim = i3;
                        this.mManager.showFragment(fragment7, i2, i);
                        break;
                    case 6:
                        Fragment fragment8 = op.fragment;
                        fragment8.mNextAnim = i4;
                        this.mManager.detachFragment(fragment8, i2, i);
                        break;
                    case 7:
                        Fragment fragment9 = op.fragment;
                        fragment9.mNextAnim = i3;
                        this.mManager.attachFragment(fragment9, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + op.cmd);
                }
            }
            this.mManager.moveToState(this.mManager.mCurState, i2, i, true);
            if (this.mAddToBackStack) {
                this.mManager.addBackStackState(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    public FragmentTransaction setBreadCrumbShortTitle(int i) {
        this.mBreadCrumbShortTitleRes = i;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    public FragmentTransaction setBreadCrumbShortTitle(CharSequence charSequence) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = charSequence;
        return this;
    }

    public FragmentTransaction setBreadCrumbTitle(int i) {
        this.mBreadCrumbTitleRes = i;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    public FragmentTransaction setBreadCrumbTitle(CharSequence charSequence) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = charSequence;
        return this;
    }

    public FragmentTransaction setCustomAnimations(int i, int i2) {
        return setCustomAnimations(i, i2, 0, 0);
    }

    public FragmentTransaction setCustomAnimations(int i, int i2, int i3, int i4) {
        this.mEnterAnim = i;
        this.mExitAnim = i2;
        this.mPopEnterAnim = i3;
        this.mPopExitAnim = i4;
        return this;
    }

    public FragmentTransaction setTransition(int i) {
        this.mTransition = i;
        return this;
    }

    public FragmentTransaction setTransitionStyle(int i) {
        this.mTransitionStyle = i;
        return this;
    }

    public FragmentTransaction show(Fragment fragment) {
        C0067Op op = new C0067Op();
        op.cmd = 5;
        op.fragment = fragment;
        addOp(op);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(NotificationCompat.FLAG_HIGH_PRIORITY);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            sb.append(" #");
            sb.append(this.mIndex);
        }
        if (this.mName != null) {
            sb.append(" ");
            sb.append(this.mName);
        }
        sb.append("}");
        return sb.toString();
    }
}
