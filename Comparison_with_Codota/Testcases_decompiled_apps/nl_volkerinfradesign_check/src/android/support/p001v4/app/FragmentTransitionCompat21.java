package android.support.p001v4.app;

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
    public static class EpicenterView {
        public View epicenter;
    }

    /* renamed from: android.support.v4.app.FragmentTransitionCompat21$ViewRetriever */
    public interface ViewRetriever {
        View getView();
    }

    /* renamed from: a */
    public static String m221a(View view) {
        return view.getTransitionName();
    }

    /* renamed from: a */
    public static Object m218a(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return obj;
    }

    /* renamed from: a */
    public static Object m219a(Object obj, View view, ArrayList<View> arrayList, Map<String, View> map, View view2) {
        if (obj == null) {
            return obj;
        }
        m239b(arrayList, view);
        if (map != null) {
            arrayList.removeAll(map.values());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        arrayList.add(view2);
        m238b((Object) (Transition) obj, arrayList);
        return obj;
    }

    /* renamed from: a */
    public static void m227a(Object obj, View view, boolean z) {
        ((Transition) obj).excludeTarget(view, z);
    }

    /* renamed from: a */
    public static void m224a(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    /* renamed from: a */
    public static void m225a(Object obj, View view) {
        final Rect c = m240c(view);
        ((Transition) obj).setEpicenterCallback(new Transition.EpicenterCallback() {
            public Rect onGetEpicenter(Transition transition) {
                return c;
            }
        });
    }

    /* renamed from: b */
    public static Object m237b(Object obj) {
        Transition transition;
        if (obj == null || (transition = (Transition) obj) == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(transition);
        return transitionSet;
    }

    /* renamed from: a */
    public static void m228a(Object obj, Object obj2, View view, ViewRetriever viewRetriever, View view2, EpicenterView epicenterView, Map<String, String> map, ArrayList<View> arrayList, Map<String, View> map2, Map<String, View> map3, ArrayList<View> arrayList2) {
        if (obj != null || obj2 != null) {
            final Transition transition = (Transition) obj;
            if (transition != null) {
                transition.addTarget(view2);
            }
            if (obj2 != null) {
                m226a(obj2, view2, map2, arrayList2);
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
                            FragmentTransitionCompat21.m232a((Map<String, View>) map5, view);
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
                        FragmentTransitionCompat21.m239b((ArrayList<View>) arrayList3, view);
                        arrayList3.removeAll(map5.values());
                        arrayList3.add(view4);
                        FragmentTransitionCompat21.m238b((Object) transition, (ArrayList<View>) arrayList3);
                        return true;
                    }
                });
            }
            m222a(transition, epicenterView);
        }
    }

    /* renamed from: a */
    public static Object m220a(Object obj, Object obj2, Object obj3, boolean z) {
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

    /* renamed from: a */
    public static void m226a(Object obj, View view, Map<String, View> map, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        arrayList.clear();
        arrayList.addAll(map.values());
        List targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            m231a((List<View>) targets, arrayList.get(i));
        }
        arrayList.add(view);
        m238b((Object) transitionSet, arrayList);
    }

    /* renamed from: a */
    private static void m231a(List<View> list, View view) {
        int size = list.size();
        if (!m235a(list, view, size)) {
            list.add(view);
            for (int i = size; i < list.size(); i++) {
                View view2 = list.get(i);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!m235a(list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m235a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static void m222a(Transition transition, final EpicenterView epicenterView) {
        if (transition != null) {
            transition.setEpicenterCallback(new Transition.EpicenterCallback() {

                /* renamed from: b */
                private Rect f248b;

                public Rect onGetEpicenter(Transition transition) {
                    if (this.f248b == null && epicenterView.epicenter != null) {
                        this.f248b = FragmentTransitionCompat21.m240c(epicenterView.epicenter);
                    }
                    return this.f248b;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static Rect m240c(View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        return rect;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m239b(ArrayList<View> arrayList, View view) {
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
                m239b(arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    /* renamed from: a */
    public static void m232a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m232a(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* renamed from: a */
    public static void m223a(View view, View view2, Object obj, ArrayList<View> arrayList, Object obj2, ArrayList<View> arrayList2, Object obj3, ArrayList<View> arrayList3, Object obj4, ArrayList<View> arrayList4, Map<String, View> map) {
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
                        FragmentTransitionCompat21.m229a((Object) transition, (ArrayList<View>) arrayList5);
                    }
                    if (transition2 != null) {
                        FragmentTransitionCompat21.m229a((Object) transition2, (ArrayList<View>) arrayList6);
                    }
                    if (transition3 != null) {
                        FragmentTransitionCompat21.m229a((Object) transition3, (ArrayList<View>) arrayList7);
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

    /* renamed from: a */
    public static void m229a(Object obj, ArrayList<View> arrayList) {
        List<View> targets;
        Transition transition = (Transition) obj;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            for (int i = 0; i < transitionCount; i++) {
                m229a((Object) transitionSet.getTransitionAt(i), arrayList);
            }
        } else if (!m233a(transition) && (targets = transition.getTargets()) != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                transition.removeTarget(arrayList.get(size));
            }
        }
    }

    /* renamed from: b */
    public static void m238b(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            for (int i = 0; i < transitionCount; i++) {
                m238b((Object) transitionSet.getTransitionAt(i), arrayList);
            }
        } else if (!m233a(transition) && m234a((List) transition.getTargets())) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                transition.addTarget(arrayList.get(i2));
            }
        }
    }

    /* renamed from: a */
    private static boolean m233a(Transition transition) {
        return !m234a((List) transition.getTargetIds()) || !m234a((List) transition.getTargetNames()) || !m234a((List) transition.getTargetTypes());
    }

    /* renamed from: a */
    private static boolean m234a(List list) {
        return list == null || list.isEmpty();
    }
}
