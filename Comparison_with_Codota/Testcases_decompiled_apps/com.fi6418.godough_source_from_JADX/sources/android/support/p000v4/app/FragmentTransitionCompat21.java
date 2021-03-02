package android.support.p000v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: android.support.v4.app.FragmentTransitionCompat21 */
class FragmentTransitionCompat21 {

    /* renamed from: android.support.v4.app.FragmentTransitionCompat21$EpicenterView */
    public class EpicenterView {
        public View epicenter;
    }

    /* renamed from: android.support.v4.app.FragmentTransitionCompat21$ViewRetriever */
    public interface ViewRetriever {
        View getView();
    }

    FragmentTransitionCompat21() {
    }

    /* renamed from: a */
    private static void m518a(Transition transition, final EpicenterView epicenterView) {
        if (transition != null) {
            transition.setEpicenterCallback(new Transition.EpicenterCallback() {

                /* renamed from: b */
                private Rect f524b;

                public Rect onGetEpicenter(Transition transition) {
                    if (this.f524b == null && EpicenterView.this.epicenter != null) {
                        this.f524b = FragmentTransitionCompat21.m524b(EpicenterView.this.epicenter);
                    }
                    return this.f524b;
                }
            });
        }
    }

    /* renamed from: a */
    private static void m520a(List<View> list, View view) {
        int size = list.size();
        if (!m523a(list, view, size)) {
            list.add(view);
            for (int i = size; i < list.size(); i++) {
                View view2 = list.get(i);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!m523a(list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m521a(Transition transition) {
        return !m522a((List) transition.getTargetIds()) || !m522a((List) transition.getTargetNames()) || !m522a((List) transition.getTargetTypes());
    }

    /* renamed from: a */
    private static boolean m522a(List list) {
        return list == null || list.isEmpty();
    }

    /* renamed from: a */
    private static boolean m523a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    public static void addTargets(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            for (int i = 0; i < transitionCount; i++) {
                addTargets(transitionSet.getTransitionAt(i), arrayList);
            }
        } else if (!m521a(transition) && m522a((List) transition.getTargets())) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                transition.addTarget(arrayList.get(i2));
            }
        }
    }

    public static void addTransitionTargets(Object obj, Object obj2, View view, ViewRetriever viewRetriever, View view2, EpicenterView epicenterView, Map<String, String> map, ArrayList<View> arrayList, Map<String, View> map2, Map<String, View> map3, ArrayList<View> arrayList2) {
        if (obj != null || obj2 != null) {
            final Transition transition = (Transition) obj;
            if (transition != null) {
                transition.addTarget(view2);
            }
            if (obj2 != null) {
                setSharedElementTargets(obj2, view2, map2, arrayList2);
            }
            if (viewRetriever != null) {
                final View view3 = view;
                final View view4 = view2;
                final ViewRetriever viewRetriever2 = viewRetriever;
                final Map<String, String> map4 = map;
                final Map<String, View> map5 = map3;
                final ArrayList<View> arrayList3 = arrayList;
                view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        view3.getViewTreeObserver().removeOnPreDrawListener(this);
                        if (transition != null) {
                            transition.removeTarget(view4);
                        }
                        View view = viewRetriever2.getView();
                        if (view == null) {
                            return true;
                        }
                        if (!map4.isEmpty()) {
                            FragmentTransitionCompat21.findNamedViews(map5, view);
                            map5.keySet().retainAll(map4.values());
                            for (Map.Entry entry : map4.entrySet()) {
                                View view2 = (View) map5.get((String) entry.getValue());
                                if (view2 != null) {
                                    view2.setTransitionName((String) entry.getKey());
                                }
                            }
                        }
                        if (transition == null) {
                            return true;
                        }
                        FragmentTransitionCompat21.m525b(arrayList3, view);
                        arrayList3.removeAll(map5.values());
                        arrayList3.add(view4);
                        FragmentTransitionCompat21.addTargets(transition, arrayList3);
                        return true;
                    }
                });
            }
            m518a(transition, epicenterView);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Rect m524b(View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        return rect;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m525b(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.isTransitionGroup()) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                m525b(arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    public static void beginDelayedTransition(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public static Object captureExitingViews(Object obj, View view, ArrayList<View> arrayList, Map<String, View> map, View view2) {
        if (obj == null) {
            return obj;
        }
        m525b(arrayList, view);
        if (map != null) {
            arrayList.removeAll(map.values());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        arrayList.add(view2);
        addTargets((Transition) obj, arrayList);
        return obj;
    }

    public static void cleanupTransitions(View view, View view2, Object obj, ArrayList<View> arrayList, Object obj2, ArrayList<View> arrayList2, Object obj3, ArrayList<View> arrayList3, Object obj4, ArrayList<View> arrayList4, Map<String, View> map) {
        final Transition transition = (Transition) obj;
        final Transition transition2 = (Transition) obj2;
        final Transition transition3 = (Transition) obj3;
        final Transition transition4 = (Transition) obj4;
        if (transition4 != null) {
            final View view3 = view;
            final ArrayList<View> arrayList5 = arrayList;
            final ArrayList<View> arrayList6 = arrayList2;
            final ArrayList<View> arrayList7 = arrayList3;
            final Map<String, View> map2 = map;
            final ArrayList<View> arrayList8 = arrayList4;
            final View view4 = view2;
            view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    view3.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (transition != null) {
                        FragmentTransitionCompat21.removeTargets(transition, arrayList5);
                    }
                    if (transition2 != null) {
                        FragmentTransitionCompat21.removeTargets(transition2, arrayList6);
                    }
                    if (transition3 != null) {
                        FragmentTransitionCompat21.removeTargets(transition3, arrayList7);
                    }
                    for (Map.Entry entry : map2.entrySet()) {
                        ((View) entry.getValue()).setTransitionName((String) entry.getKey());
                    }
                    int size = arrayList8.size();
                    for (int i = 0; i < size; i++) {
                        transition4.excludeTarget((View) arrayList8.get(i), false);
                    }
                    transition4.excludeTarget(view4, false);
                    return true;
                }
            });
        }
    }

    public static Object cloneTransition(Object obj) {
        return obj != null ? ((Transition) obj).clone() : obj;
    }

    public static void excludeTarget(Object obj, View view, boolean z) {
        ((Transition) obj).excludeTarget(view, z);
    }

    public static void findNamedViews(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    findNamedViews(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public static String getTransitionName(View view) {
        return view.getTransitionName();
    }

    public static Object mergeTransitions(Object obj, Object obj2, Object obj3, boolean z) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition == null || transition2 == null) {
            z = true;
        }
        if (z) {
            TransitionSet transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            if (transition2 != null) {
                transitionSet.addTransition(transition2);
            }
            if (transition3 == null) {
                return transitionSet;
            }
            transitionSet.addTransition(transition3);
            return transitionSet;
        }
        Transition transition4 = null;
        if (transition2 != null && transition != null) {
            transition4 = new TransitionSet().addTransition(transition2).addTransition(transition).setOrdering(1);
        } else if (transition2 != null) {
            transition4 = transition2;
        } else if (transition != null) {
            transition4 = transition;
        }
        if (transition3 == null) {
            return transition4;
        }
        TransitionSet transitionSet2 = new TransitionSet();
        if (transition4 != null) {
            transitionSet2.addTransition(transition4);
        }
        transitionSet2.addTransition(transition3);
        return transitionSet2;
    }

    public static void removeTargets(Object obj, ArrayList<View> arrayList) {
        List<View> targets;
        Transition transition = (Transition) obj;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            for (int i = 0; i < transitionCount; i++) {
                removeTargets(transitionSet.getTransitionAt(i), arrayList);
            }
        } else if (!m521a(transition) && (targets = transition.getTargets()) != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                transition.removeTarget(arrayList.get(size));
            }
        }
    }

    public static void setEpicenter(Object obj, View view) {
        final Rect b = m524b(view);
        ((Transition) obj).setEpicenterCallback(new Transition.EpicenterCallback() {
            public Rect onGetEpicenter(Transition transition) {
                return b;
            }
        });
    }

    public static void setSharedElementTargets(Object obj, View view, Map<String, View> map, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        arrayList.clear();
        arrayList.addAll(map.values());
        List targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            m520a((List<View>) targets, arrayList.get(i));
        }
        arrayList.add(view);
        addTargets(transitionSet, arrayList);
    }

    public static Object wrapSharedElementTransition(Object obj) {
        Transition transition;
        if (obj == null || (transition = (Transition) obj) == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(transition);
        return transitionSet;
    }
}
