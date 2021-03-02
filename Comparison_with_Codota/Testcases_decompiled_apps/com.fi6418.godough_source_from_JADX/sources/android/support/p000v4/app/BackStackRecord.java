package android.support.p000v4.app;

import android.os.Build;
import android.support.p000v4.app.FragmentManager;
import android.support.p000v4.app.FragmentTransitionCompat21;
import android.support.p000v4.util.ArrayMap;
import android.support.p000v4.util.LogWriter;
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

    /* renamed from: a */
    static final boolean f286a = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: b */
    final FragmentManagerImpl f287b;

    /* renamed from: c */
    C0093Op f288c;

    /* renamed from: d */
    C0093Op f289d;

    /* renamed from: e */
    int f290e;

    /* renamed from: f */
    int f291f;

    /* renamed from: g */
    int f292g;

    /* renamed from: h */
    int f293h;

    /* renamed from: i */
    int f294i;

    /* renamed from: j */
    int f295j;

    /* renamed from: k */
    int f296k;

    /* renamed from: l */
    boolean f297l;

    /* renamed from: m */
    boolean f298m = true;

    /* renamed from: n */
    String f299n;

    /* renamed from: o */
    boolean f300o;

    /* renamed from: p */
    int f301p = -1;

    /* renamed from: q */
    int f302q;

    /* renamed from: r */
    CharSequence f303r;

    /* renamed from: s */
    int f304s;

    /* renamed from: t */
    CharSequence f305t;

    /* renamed from: u */
    ArrayList<String> f306u;

    /* renamed from: v */
    ArrayList<String> f307v;

    /* renamed from: android.support.v4.app.BackStackRecord$Op */
    final class C0093Op {

        /* renamed from: a */
        C0093Op f323a;

        /* renamed from: b */
        C0093Op f324b;

        /* renamed from: c */
        int f325c;

        /* renamed from: d */
        Fragment f326d;

        /* renamed from: e */
        int f327e;

        /* renamed from: f */
        int f328f;

        /* renamed from: g */
        int f329g;

        /* renamed from: h */
        int f330h;

        /* renamed from: i */
        ArrayList<Fragment> f331i;

        C0093Op() {
        }
    }

    /* renamed from: android.support.v4.app.BackStackRecord$TransitionState */
    public class TransitionState {
        public FragmentTransitionCompat21.EpicenterView enteringEpicenterView = new FragmentTransitionCompat21.EpicenterView();
        public ArrayList<View> hiddenFragmentViews = new ArrayList<>();
        public ArrayMap<String, String> nameOverrides = new ArrayMap<>();
        public View nonExistentView;

        public TransitionState() {
        }
    }

    public BackStackRecord(FragmentManagerImpl fragmentManagerImpl) {
        this.f287b = fragmentManagerImpl;
    }

    /* renamed from: a */
    private TransitionState m401a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        TransitionState transitionState = new TransitionState();
        transitionState.nonExistentView = new View(this.f287b.f454o.mo696b());
        int i = 0;
        boolean z2 = false;
        while (i < sparseArray.size()) {
            boolean z3 = m423a(sparseArray.keyAt(i), transitionState, z, sparseArray, sparseArray2) ? true : z2;
            i++;
            z2 = z3;
        }
        for (int i2 = 0; i2 < sparseArray2.size(); i2++) {
            int keyAt = sparseArray2.keyAt(i2);
            if (sparseArray.get(keyAt) == null && m423a(keyAt, transitionState, z, sparseArray, sparseArray2)) {
                z2 = true;
            }
        }
        if (!z2) {
            return null;
        }
        return transitionState;
    }

    /* renamed from: a */
    private ArrayMap<String, View> m402a(TransitionState transitionState, Fragment fragment, boolean z) {
        ArrayMap<String, View> arrayMap = new ArrayMap<>();
        if (this.f306u != null) {
            FragmentTransitionCompat21.findNamedViews(arrayMap, fragment.getView());
            if (z) {
                arrayMap.retainAll(this.f307v);
            } else {
                arrayMap = m405a(this.f306u, this.f307v, arrayMap);
            }
        }
        if (z) {
            if (fragment.f392ah != null) {
                fragment.f392ah.onMapSharedElements(this.f307v, arrayMap);
            }
            m412a(transitionState, arrayMap, false);
        } else {
            if (fragment.f393ai != null) {
                fragment.f393ai.onMapSharedElements(this.f307v, arrayMap);
            }
            m426b(transitionState, arrayMap, false);
        }
        return arrayMap;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public ArrayMap<String, View> m403a(TransitionState transitionState, boolean z, Fragment fragment) {
        ArrayMap<String, View> b = m424b(transitionState, fragment, z);
        if (z) {
            if (fragment.f393ai != null) {
                fragment.f393ai.onMapSharedElements(this.f307v, b);
            }
            m412a(transitionState, b, true);
        } else {
            if (fragment.f392ah != null) {
                fragment.f392ah.onMapSharedElements(this.f307v, b);
            }
            m426b(transitionState, b, true);
        }
        return b;
    }

    /* renamed from: a */
    private static ArrayMap<String, View> m405a(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayMap<String, View> arrayMap) {
        if (arrayMap.isEmpty()) {
            return arrayMap;
        }
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = arrayMap.get(arrayList.get(i));
            if (view != null) {
                arrayMap2.put(arrayList2.get(i), view);
            }
        }
        return arrayMap2;
    }

    /* renamed from: a */
    private static Object m406a(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return FragmentTransitionCompat21.wrapSharedElementTransition(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition());
    }

    /* renamed from: a */
    private static Object m407a(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return FragmentTransitionCompat21.cloneTransition(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    /* renamed from: a */
    private static Object m408a(Object obj, Fragment fragment, ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, View view) {
        return obj != null ? FragmentTransitionCompat21.captureExitingViews(obj, fragment.getView(), arrayList, arrayMap, view) : obj;
    }

    /* renamed from: a */
    private void m409a(int i, Fragment fragment, String str, int i2) {
        fragment.f361C = this.f287b;
        if (str != null) {
            if (fragment.f367I == null || str.equals(fragment.f367I)) {
                fragment.f367I = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f367I + " now " + str);
            }
        }
        if (i != 0) {
            if (fragment.f365G == 0 || fragment.f365G == i) {
                fragment.f365G = i;
                fragment.f366H = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f365G + " now " + i);
            }
        }
        C0093Op op = new C0093Op();
        op.f325c = i2;
        op.f326d = fragment;
        mo414a(op);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m410a(TransitionState transitionState, int i, Object obj) {
        if (this.f287b.f446g != null) {
            for (int i2 = 0; i2 < this.f287b.f446g.size(); i2++) {
                Fragment fragment = this.f287b.f446g.get(i2);
                if (!(fragment.f377S == null || fragment.f376R == null || fragment.f366H != i)) {
                    if (!fragment.f368J) {
                        FragmentTransitionCompat21.excludeTarget(obj, fragment.f377S, false);
                        transitionState.hiddenFragmentViews.remove(fragment.f377S);
                    } else if (!transitionState.hiddenFragmentViews.contains(fragment.f377S)) {
                        FragmentTransitionCompat21.excludeTarget(obj, fragment.f377S, true);
                        transitionState.hiddenFragmentViews.add(fragment.f377S);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m411a(TransitionState transitionState, Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap) {
        SharedElementCallback sharedElementCallback = z ? fragment2.f392ah : fragment.f392ah;
        if (sharedElementCallback != null) {
            sharedElementCallback.onSharedElementEnd(new ArrayList(arrayMap.keySet()), new ArrayList(arrayMap.values()), (List<View>) null);
        }
    }

    /* renamed from: a */
    private void m412a(TransitionState transitionState, ArrayMap<String, View> arrayMap, boolean z) {
        int size = this.f307v == null ? 0 : this.f307v.size();
        for (int i = 0; i < size; i++) {
            String str = this.f306u.get(i);
            View view = arrayMap.get(this.f307v.get(i));
            if (view != null) {
                String transitionName = FragmentTransitionCompat21.getTransitionName(view);
                if (z) {
                    m419a(transitionState.nameOverrides, str, transitionName);
                } else {
                    m419a(transitionState.nameOverrides, transitionName, str);
                }
            }
        }
    }

    /* renamed from: a */
    private void m413a(TransitionState transitionState, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList) {
        final View view2 = view;
        final Object obj2 = obj;
        final ArrayList<View> arrayList2 = arrayList;
        final TransitionState transitionState2 = transitionState;
        final boolean z2 = z;
        final Fragment fragment3 = fragment;
        final Fragment fragment4 = fragment2;
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                if (obj2 == null) {
                    return true;
                }
                FragmentTransitionCompat21.removeTargets(obj2, arrayList2);
                arrayList2.clear();
                ArrayMap a = BackStackRecord.this.m403a(transitionState2, z2, fragment3);
                FragmentTransitionCompat21.setSharedElementTargets(obj2, transitionState2.nonExistentView, a, arrayList2);
                BackStackRecord.this.m418a((ArrayMap<String, View>) a, transitionState2);
                BackStackRecord.this.m411a(transitionState2, fragment3, fragment4, z2, (ArrayMap<String, View>) a);
                return true;
            }
        });
    }

    /* renamed from: a */
    private static void m414a(TransitionState transitionState, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    m419a(transitionState.nameOverrides, arrayList.get(i2), arrayList2.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m418a(ArrayMap<String, View> arrayMap, TransitionState transitionState) {
        View view;
        if (this.f307v != null && !arrayMap.isEmpty() && (view = arrayMap.get(this.f307v.get(0))) != null) {
            transitionState.enteringEpicenterView.epicenter = view;
        }
    }

    /* renamed from: a */
    private static void m419a(ArrayMap<String, String> arrayMap, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < arrayMap.size(); i++) {
                if (str.equals(arrayMap.valueAt(i))) {
                    arrayMap.setValueAt(i, str2);
                    return;
                }
            }
            arrayMap.put(str, str2);
        }
    }

    /* renamed from: a */
    private static void m420a(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i;
        if (fragment != null && (i = fragment.f366H) != 0 && !fragment.isHidden() && fragment.isAdded() && fragment.getView() != null && sparseArray.get(i) == null) {
            sparseArray.put(i, fragment);
        }
    }

    /* renamed from: a */
    private void m421a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Fragment fragment;
        if (this.f287b.f455p.onHasView()) {
            for (C0093Op op = this.f288c; op != null; op = op.f323a) {
                switch (op.f325c) {
                    case 1:
                        m427b(sparseArray2, op.f326d);
                        break;
                    case 2:
                        Fragment fragment2 = op.f326d;
                        if (this.f287b.f446g != null) {
                            int i = 0;
                            fragment = fragment2;
                            while (true) {
                                int i2 = i;
                                if (i2 < this.f287b.f446g.size()) {
                                    Fragment fragment3 = this.f287b.f446g.get(i2);
                                    if (fragment == null || fragment3.f366H == fragment.f366H) {
                                        if (fragment3 == fragment) {
                                            fragment = null;
                                        } else {
                                            m420a(sparseArray, fragment3);
                                        }
                                    }
                                    i = i2 + 1;
                                }
                            }
                        } else {
                            fragment = fragment2;
                        }
                        m427b(sparseArray2, fragment);
                        break;
                    case 3:
                        m420a(sparseArray, op.f326d);
                        break;
                    case 4:
                        m420a(sparseArray, op.f326d);
                        break;
                    case 5:
                        m427b(sparseArray2, op.f326d);
                        break;
                    case 6:
                        m420a(sparseArray, op.f326d);
                        break;
                    case 7:
                        m427b(sparseArray2, op.f326d);
                        break;
                }
            }
        }
    }

    /* renamed from: a */
    private void m422a(View view, TransitionState transitionState, int i, Object obj) {
        final View view2 = view;
        final TransitionState transitionState2 = transitionState;
        final int i2 = i;
        final Object obj2 = obj;
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                BackStackRecord.this.m410a(transitionState2, i2, obj2);
                return true;
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x013b A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0143 A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m423a(int r34, android.support.p000v4.app.BackStackRecord.TransitionState r35, boolean r36, android.util.SparseArray<android.support.p000v4.app.Fragment> r37, android.util.SparseArray<android.support.p000v4.app.Fragment> r38) {
        /*
            r33 = this;
            r0 = r33
            android.support.v4.app.FragmentManagerImpl r4 = r0.f287b
            android.support.v4.app.FragmentContainer r4 = r4.f455p
            r0 = r34
            android.view.View r6 = r4.onFindViewById(r0)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            if (r6 != 0) goto L_0x0012
            r4 = 0
        L_0x0011:
            return r4
        L_0x0012:
            r0 = r38
            r1 = r34
            java.lang.Object r8 = r0.get(r1)
            android.support.v4.app.Fragment r8 = (android.support.p000v4.app.Fragment) r8
            r0 = r37
            r1 = r34
            java.lang.Object r9 = r0.get(r1)
            android.support.v4.app.Fragment r9 = (android.support.p000v4.app.Fragment) r9
            r0 = r36
            java.lang.Object r12 = m407a((android.support.p000v4.app.Fragment) r8, (boolean) r0)
            r0 = r36
            java.lang.Object r7 = m406a((android.support.p000v4.app.Fragment) r8, (android.support.p000v4.app.Fragment) r9, (boolean) r0)
            r0 = r36
            java.lang.Object r14 = m425b((android.support.p000v4.app.Fragment) r9, (boolean) r0)
            r20 = 0
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            if (r7 == 0) goto L_0x0082
            r0 = r33
            r1 = r35
            r2 = r36
            android.support.v4.util.ArrayMap r20 = r0.m402a((android.support.p000v4.app.BackStackRecord.TransitionState) r1, (android.support.p000v4.app.Fragment) r9, (boolean) r2)
            boolean r4 = r20.isEmpty()
            if (r4 == 0) goto L_0x005d
            r7 = 0
            r20 = 0
            r13 = r7
        L_0x0055:
            if (r12 != 0) goto L_0x0087
            if (r13 != 0) goto L_0x0087
            if (r14 != 0) goto L_0x0087
            r4 = 0
            goto L_0x0011
        L_0x005d:
            if (r36 == 0) goto L_0x0084
            android.support.v4.app.SharedElementCallback r4 = r9.f392ah
        L_0x0061:
            if (r4 == 0) goto L_0x0079
            java.util.ArrayList r5 = new java.util.ArrayList
            java.util.Set r10 = r20.keySet()
            r5.<init>(r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            java.util.Collection r13 = r20.values()
            r10.<init>(r13)
            r13 = 0
            r4.onSharedElementStart(r5, r10, r13)
        L_0x0079:
            r4 = r33
            r5 = r35
            r10 = r36
            r4.m413a(r5, r6, r7, r8, r9, r10, r11)
        L_0x0082:
            r13 = r7
            goto L_0x0055
        L_0x0084:
            android.support.v4.app.SharedElementCallback r4 = r8.f392ah
            goto L_0x0061
        L_0x0087:
            java.util.ArrayList r27 = new java.util.ArrayList
            r27.<init>()
            r0 = r35
            android.view.View r4 = r0.nonExistentView
            r0 = r27
            r1 = r20
            java.lang.Object r26 = m408a((java.lang.Object) r14, (android.support.p000v4.app.Fragment) r9, (java.util.ArrayList<android.view.View>) r0, (android.support.p000v4.util.ArrayMap<java.lang.String, android.view.View>) r1, (android.view.View) r4)
            r0 = r33
            java.util.ArrayList<java.lang.String> r4 = r0.f307v
            if (r4 == 0) goto L_0x00bf
            if (r20 == 0) goto L_0x00bf
            r0 = r33
            java.util.ArrayList<java.lang.String> r4 = r0.f307v
            r5 = 0
            java.lang.Object r4 = r4.get(r5)
            r0 = r20
            java.lang.Object r4 = r0.get(r4)
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L_0x00bf
            if (r26 == 0) goto L_0x00ba
            r0 = r26
            android.support.p000v4.app.FragmentTransitionCompat21.setEpicenter(r0, r4)
        L_0x00ba:
            if (r13 == 0) goto L_0x00bf
            android.support.p000v4.app.FragmentTransitionCompat21.setEpicenter(r13, r4)
        L_0x00bf:
            android.support.v4.app.BackStackRecord$1 r15 = new android.support.v4.app.BackStackRecord$1
            r0 = r33
            r15.<init>(r8)
            java.util.ArrayList r19 = new java.util.ArrayList
            r19.<init>()
            android.support.v4.util.ArrayMap r21 = new android.support.v4.util.ArrayMap
            r21.<init>()
            r4 = 1
            if (r8 == 0) goto L_0x00d9
            if (r36 == 0) goto L_0x013e
            boolean r4 = r8.getAllowReturnTransitionOverlap()
        L_0x00d9:
            r0 = r26
            java.lang.Object r30 = android.support.p000v4.app.FragmentTransitionCompat21.mergeTransitions(r12, r0, r13, r4)
            if (r30 == 0) goto L_0x0139
            r0 = r35
            android.view.View r0 = r0.nonExistentView
            r16 = r0
            r0 = r35
            android.support.v4.app.FragmentTransitionCompat21$EpicenterView r0 = r0.enteringEpicenterView
            r17 = r0
            r0 = r35
            android.support.v4.util.ArrayMap<java.lang.String, java.lang.String> r0 = r0.nameOverrides
            r18 = r0
            r14 = r6
            r22 = r11
            android.support.p000v4.app.FragmentTransitionCompat21.addTransitionTargets(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0 = r33
            r1 = r35
            r2 = r34
            r3 = r30
            r0.m422a((android.view.View) r6, (android.support.p000v4.app.BackStackRecord.TransitionState) r1, (int) r2, (java.lang.Object) r3)
            r0 = r35
            android.view.View r4 = r0.nonExistentView
            r5 = 1
            r0 = r30
            android.support.p000v4.app.FragmentTransitionCompat21.excludeTarget(r0, r4, r5)
            r0 = r33
            r1 = r35
            r2 = r34
            r3 = r30
            r0.m410a((android.support.p000v4.app.BackStackRecord.TransitionState) r1, (int) r2, (java.lang.Object) r3)
            r0 = r30
            android.support.p000v4.app.FragmentTransitionCompat21.beginDelayedTransition(r6, r0)
            r0 = r35
            android.view.View r0 = r0.nonExistentView
            r23 = r0
            r0 = r35
            java.util.ArrayList<android.view.View> r0 = r0.hiddenFragmentViews
            r31 = r0
            r22 = r6
            r24 = r12
            r25 = r19
            r28 = r13
            r29 = r11
            r32 = r21
            android.support.p000v4.app.FragmentTransitionCompat21.cleanupTransitions(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
        L_0x0139:
            if (r30 == 0) goto L_0x0143
            r4 = 1
            goto L_0x0011
        L_0x013e:
            boolean r4 = r8.getAllowEnterTransitionOverlap()
            goto L_0x00d9
        L_0x0143:
            r4 = 0
            goto L_0x0011
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.app.BackStackRecord.m423a(int, android.support.v4.app.BackStackRecord$TransitionState, boolean, android.util.SparseArray, android.util.SparseArray):boolean");
    }

    /* renamed from: b */
    private ArrayMap<String, View> m424b(TransitionState transitionState, Fragment fragment, boolean z) {
        ArrayMap<String, View> arrayMap = new ArrayMap<>();
        View view = fragment.getView();
        if (view == null || this.f306u == null) {
            return arrayMap;
        }
        FragmentTransitionCompat21.findNamedViews(arrayMap, view);
        if (z) {
            return m405a(this.f306u, this.f307v, arrayMap);
        }
        arrayMap.retainAll(this.f307v);
        return arrayMap;
    }

    /* renamed from: b */
    private static Object m425b(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return FragmentTransitionCompat21.cloneTransition(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    /* renamed from: b */
    private void m426b(TransitionState transitionState, ArrayMap<String, View> arrayMap, boolean z) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            String keyAt = arrayMap.keyAt(i);
            String transitionName = FragmentTransitionCompat21.getTransitionName(arrayMap.valueAt(i));
            if (z) {
                m419a(transitionState.nameOverrides, keyAt, transitionName);
            } else {
                m419a(transitionState.nameOverrides, transitionName, keyAt);
            }
        }
    }

    /* renamed from: b */
    private void m427b(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i;
        if (fragment != null && (i = fragment.f366H) != 0) {
            sparseArray.put(i, fragment);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo412a(boolean z) {
        if (this.f300o) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManagerImpl.f439a) {
            Log.v("FragmentManager", "Commit: " + this);
            dump("  ", (FileDescriptor) null, new PrintWriter(new LogWriter("FragmentManager")), (String[]) null);
        }
        this.f300o = true;
        if (this.f297l) {
            this.f301p = this.f287b.allocBackStackIndex(this);
        } else {
            this.f301p = -1;
        }
        this.f287b.enqueueAction(this, z);
        return this.f301p;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo413a(int i) {
        if (this.f297l) {
            if (FragmentManagerImpl.f439a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (C0093Op op = this.f288c; op != null; op = op.f323a) {
                if (op.f326d != null) {
                    op.f326d.f360B += i;
                    if (FragmentManagerImpl.f439a) {
                        Log.v("FragmentManager", "Bump nesting of " + op.f326d + " to " + op.f326d.f360B);
                    }
                }
                if (op.f331i != null) {
                    for (int size = op.f331i.size() - 1; size >= 0; size--) {
                        Fragment fragment = op.f331i.get(size);
                        fragment.f360B += i;
                        if (FragmentManagerImpl.f439a) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.f360B);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo414a(C0093Op op) {
        if (this.f288c == null) {
            this.f289d = op;
            this.f288c = op;
        } else {
            op.f324b = this.f289d;
            this.f289d.f323a = op;
            this.f289d = op;
        }
        op.f327e = this.f291f;
        op.f328f = this.f292g;
        op.f329g = this.f293h;
        op.f330h = this.f294i;
        this.f290e++;
    }

    public FragmentTransaction add(int i, Fragment fragment) {
        m409a(i, fragment, (String) null, 1);
        return this;
    }

    public FragmentTransaction add(int i, Fragment fragment, String str) {
        m409a(i, fragment, str, 1);
        return this;
    }

    public FragmentTransaction add(Fragment fragment, String str) {
        m409a(0, fragment, str, 1);
        return this;
    }

    public FragmentTransaction addSharedElement(View view, String str) {
        if (f286a) {
            String transitionName = FragmentTransitionCompat21.getTransitionName(view);
            if (transitionName == null) {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            if (this.f306u == null) {
                this.f306u = new ArrayList<>();
                this.f307v = new ArrayList<>();
            }
            this.f306u.add(transitionName);
            this.f307v.add(str);
        }
        return this;
    }

    public FragmentTransaction addToBackStack(String str) {
        if (!this.f298m) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.f297l = true;
        this.f299n = str;
        return this;
    }

    public FragmentTransaction attach(Fragment fragment) {
        C0093Op op = new C0093Op();
        op.f325c = 7;
        op.f326d = fragment;
        mo414a(op);
        return this;
    }

    public void calculateBackFragments(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f287b.f455p.onHasView()) {
            for (C0093Op op = this.f288c; op != null; op = op.f323a) {
                switch (op.f325c) {
                    case 1:
                        m420a(sparseArray, op.f326d);
                        break;
                    case 2:
                        if (op.f331i != null) {
                            for (int size = op.f331i.size() - 1; size >= 0; size--) {
                                m427b(sparseArray2, op.f331i.get(size));
                            }
                        }
                        m420a(sparseArray, op.f326d);
                        break;
                    case 3:
                        m427b(sparseArray2, op.f326d);
                        break;
                    case 4:
                        m427b(sparseArray2, op.f326d);
                        break;
                    case 5:
                        m420a(sparseArray, op.f326d);
                        break;
                    case 6:
                        m427b(sparseArray2, op.f326d);
                        break;
                    case 7:
                        m420a(sparseArray, op.f326d);
                        break;
                }
            }
        }
    }

    public int commit() {
        return mo412a(false);
    }

    public int commitAllowingStateLoss() {
        return mo412a(true);
    }

    public FragmentTransaction detach(Fragment fragment) {
        C0093Op op = new C0093Op();
        op.f325c = 6;
        op.f326d = fragment;
        mo414a(op);
        return this;
    }

    public FragmentTransaction disallowAddToBackStack() {
        if (this.f297l) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f298m = false;
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
            printWriter.print(this.f299n);
            printWriter.print(" mIndex=");
            printWriter.print(this.f301p);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f300o);
            if (this.f295j != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f295j));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f296k));
            }
            if (!(this.f291f == 0 && this.f292g == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f291f));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f292g));
            }
            if (!(this.f293h == 0 && this.f294i == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f293h));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f294i));
            }
            if (!(this.f302q == 0 && this.f303r == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f302q));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f303r);
            }
            if (!(this.f304s == 0 && this.f305t == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f304s));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f305t);
            }
        }
        if (this.f288c != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str3 = str + "    ";
            int i = 0;
            C0093Op op = this.f288c;
            while (op != null) {
                switch (op.f325c) {
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
                        str2 = "cmd=" + op.f325c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(op.f326d);
                if (z) {
                    if (!(op.f327e == 0 && op.f328f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(op.f327e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(op.f328f));
                    }
                    if (!(op.f329g == 0 && op.f330h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(op.f329g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(op.f330h));
                    }
                }
                if (op.f331i != null && op.f331i.size() > 0) {
                    for (int i2 = 0; i2 < op.f331i.size(); i2++) {
                        printWriter.print(str3);
                        if (op.f331i.size() == 1) {
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
                        printWriter.println(op.f331i.get(i2));
                    }
                }
                op = op.f323a;
                i++;
            }
        }
    }

    public CharSequence getBreadCrumbShortTitle() {
        return this.f304s != 0 ? this.f287b.f454o.mo696b().getText(this.f304s) : this.f305t;
    }

    public int getBreadCrumbShortTitleRes() {
        return this.f304s;
    }

    public CharSequence getBreadCrumbTitle() {
        return this.f302q != 0 ? this.f287b.f454o.mo696b().getText(this.f302q) : this.f303r;
    }

    public int getBreadCrumbTitleRes() {
        return this.f302q;
    }

    public int getId() {
        return this.f301p;
    }

    public String getName() {
        return this.f299n;
    }

    public int getTransition() {
        return this.f295j;
    }

    public int getTransitionStyle() {
        return this.f296k;
    }

    public FragmentTransaction hide(Fragment fragment) {
        C0093Op op = new C0093Op();
        op.f325c = 4;
        op.f326d = fragment;
        mo414a(op);
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return this.f298m;
    }

    public boolean isEmpty() {
        return this.f290e == 0;
    }

    public TransitionState popFromBackStack(boolean z, TransitionState transitionState, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (FragmentManagerImpl.f439a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            dump("  ", (FileDescriptor) null, new PrintWriter(new LogWriter("FragmentManager")), (String[]) null);
        }
        if (f286a) {
            if (transitionState == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    transitionState = m401a(sparseArray, sparseArray2, true);
                }
            } else if (!z) {
                m414a(transitionState, this.f307v, this.f306u);
            }
        }
        mo413a(-1);
        int i = transitionState != null ? 0 : this.f296k;
        int i2 = transitionState != null ? 0 : this.f295j;
        for (C0093Op op = this.f289d; op != null; op = op.f324b) {
            int i3 = transitionState != null ? 0 : op.f329g;
            int i4 = transitionState != null ? 0 : op.f330h;
            switch (op.f325c) {
                case 1:
                    Fragment fragment = op.f326d;
                    fragment.f375Q = i4;
                    this.f287b.removeFragment(fragment, FragmentManagerImpl.reverseTransit(i2), i);
                    break;
                case 2:
                    Fragment fragment2 = op.f326d;
                    if (fragment2 != null) {
                        fragment2.f375Q = i4;
                        this.f287b.removeFragment(fragment2, FragmentManagerImpl.reverseTransit(i2), i);
                    }
                    if (op.f331i == null) {
                        break;
                    } else {
                        for (int i5 = 0; i5 < op.f331i.size(); i5++) {
                            Fragment fragment3 = op.f331i.get(i5);
                            fragment3.f375Q = i3;
                            this.f287b.addFragment(fragment3, false);
                        }
                        break;
                    }
                case 3:
                    Fragment fragment4 = op.f326d;
                    fragment4.f375Q = i3;
                    this.f287b.addFragment(fragment4, false);
                    break;
                case 4:
                    Fragment fragment5 = op.f326d;
                    fragment5.f375Q = i3;
                    this.f287b.showFragment(fragment5, FragmentManagerImpl.reverseTransit(i2), i);
                    break;
                case 5:
                    Fragment fragment6 = op.f326d;
                    fragment6.f375Q = i4;
                    this.f287b.hideFragment(fragment6, FragmentManagerImpl.reverseTransit(i2), i);
                    break;
                case 6:
                    Fragment fragment7 = op.f326d;
                    fragment7.f375Q = i3;
                    this.f287b.attachFragment(fragment7, FragmentManagerImpl.reverseTransit(i2), i);
                    break;
                case 7:
                    Fragment fragment8 = op.f326d;
                    fragment8.f375Q = i3;
                    this.f287b.detachFragment(fragment8, FragmentManagerImpl.reverseTransit(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.f325c);
            }
        }
        if (z) {
            this.f287b.mo729a(this.f287b.f453n, FragmentManagerImpl.reverseTransit(i2), i, true);
            transitionState = null;
        }
        if (this.f301p >= 0) {
            this.f287b.freeBackStackIndex(this.f301p);
            this.f301p = -1;
        }
        return transitionState;
    }

    public FragmentTransaction remove(Fragment fragment) {
        C0093Op op = new C0093Op();
        op.f325c = 3;
        op.f326d = fragment;
        mo414a(op);
        return this;
    }

    public FragmentTransaction replace(int i, Fragment fragment) {
        return replace(i, fragment, (String) null);
    }

    public FragmentTransaction replace(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        m409a(i, fragment, str, 2);
        return this;
    }

    public void run() {
        TransitionState transitionState;
        Fragment fragment;
        if (FragmentManagerImpl.f439a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.f297l || this.f301p >= 0) {
            mo413a(1);
            if (f286a) {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                m421a((SparseArray<Fragment>) sparseArray, (SparseArray<Fragment>) sparseArray2);
                transitionState = m401a((SparseArray<Fragment>) sparseArray, (SparseArray<Fragment>) sparseArray2, false);
            } else {
                transitionState = null;
            }
            int i = transitionState != null ? 0 : this.f296k;
            int i2 = transitionState != null ? 0 : this.f295j;
            for (C0093Op op = this.f288c; op != null; op = op.f323a) {
                int i3 = transitionState != null ? 0 : op.f327e;
                int i4 = transitionState != null ? 0 : op.f328f;
                switch (op.f325c) {
                    case 1:
                        Fragment fragment2 = op.f326d;
                        fragment2.f375Q = i3;
                        this.f287b.addFragment(fragment2, false);
                        break;
                    case 2:
                        Fragment fragment3 = op.f326d;
                        int i5 = fragment3.f366H;
                        if (this.f287b.f446g != null) {
                            int i6 = 0;
                            fragment = fragment3;
                            while (true) {
                                int i7 = i6;
                                if (i7 < this.f287b.f446g.size()) {
                                    Fragment fragment4 = this.f287b.f446g.get(i7);
                                    if (FragmentManagerImpl.f439a) {
                                        Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment + " old=" + fragment4);
                                    }
                                    if (fragment4.f366H == i5) {
                                        if (fragment4 == fragment) {
                                            fragment = null;
                                            op.f326d = null;
                                        } else {
                                            if (op.f331i == null) {
                                                op.f331i = new ArrayList<>();
                                            }
                                            op.f331i.add(fragment4);
                                            fragment4.f375Q = i4;
                                            if (this.f297l) {
                                                fragment4.f360B++;
                                                if (FragmentManagerImpl.f439a) {
                                                    Log.v("FragmentManager", "Bump nesting of " + fragment4 + " to " + fragment4.f360B);
                                                }
                                            }
                                            this.f287b.removeFragment(fragment4, i2, i);
                                        }
                                    }
                                    i6 = i7 + 1;
                                }
                            }
                        } else {
                            fragment = fragment3;
                        }
                        if (fragment == null) {
                            break;
                        } else {
                            fragment.f375Q = i3;
                            this.f287b.addFragment(fragment, false);
                            break;
                        }
                    case 3:
                        Fragment fragment5 = op.f326d;
                        fragment5.f375Q = i4;
                        this.f287b.removeFragment(fragment5, i2, i);
                        break;
                    case 4:
                        Fragment fragment6 = op.f326d;
                        fragment6.f375Q = i4;
                        this.f287b.hideFragment(fragment6, i2, i);
                        break;
                    case 5:
                        Fragment fragment7 = op.f326d;
                        fragment7.f375Q = i3;
                        this.f287b.showFragment(fragment7, i2, i);
                        break;
                    case 6:
                        Fragment fragment8 = op.f326d;
                        fragment8.f375Q = i4;
                        this.f287b.detachFragment(fragment8, i2, i);
                        break;
                    case 7:
                        Fragment fragment9 = op.f326d;
                        fragment9.f375Q = i3;
                        this.f287b.attachFragment(fragment9, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + op.f325c);
                }
            }
            this.f287b.mo729a(this.f287b.f453n, i2, i, true);
            if (this.f297l) {
                this.f287b.mo732a(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    public FragmentTransaction setBreadCrumbShortTitle(int i) {
        this.f304s = i;
        this.f305t = null;
        return this;
    }

    public FragmentTransaction setBreadCrumbShortTitle(CharSequence charSequence) {
        this.f304s = 0;
        this.f305t = charSequence;
        return this;
    }

    public FragmentTransaction setBreadCrumbTitle(int i) {
        this.f302q = i;
        this.f303r = null;
        return this;
    }

    public FragmentTransaction setBreadCrumbTitle(CharSequence charSequence) {
        this.f302q = 0;
        this.f303r = charSequence;
        return this;
    }

    public FragmentTransaction setCustomAnimations(int i, int i2) {
        return setCustomAnimations(i, i2, 0, 0);
    }

    public FragmentTransaction setCustomAnimations(int i, int i2, int i3, int i4) {
        this.f291f = i;
        this.f292g = i2;
        this.f293h = i3;
        this.f294i = i4;
        return this;
    }

    public FragmentTransaction setTransition(int i) {
        this.f295j = i;
        return this;
    }

    public FragmentTransaction setTransitionStyle(int i) {
        this.f296k = i;
        return this;
    }

    public FragmentTransaction show(Fragment fragment) {
        C0093Op op = new C0093Op();
        op.f325c = 5;
        op.f326d = fragment;
        mo414a(op);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f301p >= 0) {
            sb.append(" #");
            sb.append(this.f301p);
        }
        if (this.f299n != null) {
            sb.append(" ");
            sb.append(this.f299n);
        }
        sb.append("}");
        return sb.toString();
    }
}
