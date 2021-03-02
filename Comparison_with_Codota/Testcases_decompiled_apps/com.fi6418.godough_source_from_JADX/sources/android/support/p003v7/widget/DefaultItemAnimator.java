package android.support.p003v7.widget;

import android.support.p000v4.animation.AnimatorCompatHelper;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.ViewPropertyAnimatorCompat;
import android.support.p000v4.view.ViewPropertyAnimatorListener;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v7.widget.DefaultItemAnimator */
public class DefaultItemAnimator extends RecyclerView.ItemAnimator {

    /* renamed from: a */
    private ArrayList<RecyclerView.ViewHolder> f2717a = new ArrayList<>();

    /* renamed from: b */
    private ArrayList<RecyclerView.ViewHolder> f2718b = new ArrayList<>();

    /* renamed from: c */
    private ArrayList<MoveInfo> f2719c = new ArrayList<>();

    /* renamed from: d */
    private ArrayList<ChangeInfo> f2720d = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ArrayList<ArrayList<RecyclerView.ViewHolder>> f2721e = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ArrayList<ArrayList<MoveInfo>> f2722f = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ArrayList<ArrayList<ChangeInfo>> f2723g = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ArrayList<RecyclerView.ViewHolder> f2724h = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ArrayList<RecyclerView.ViewHolder> f2725i = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ArrayList<RecyclerView.ViewHolder> f2726j = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ArrayList<RecyclerView.ViewHolder> f2727k = new ArrayList<>();

    /* renamed from: android.support.v7.widget.DefaultItemAnimator$ChangeInfo */
    class ChangeInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder newHolder;
        public RecyclerView.ViewHolder oldHolder;
        public int toX;
        public int toY;

        private ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.oldHolder = viewHolder;
            this.newHolder = viewHolder2;
        }

        private ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
            this(viewHolder, viewHolder2);
            this.fromX = i;
            this.fromY = i2;
            this.toX = i3;
            this.toY = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.oldHolder + ", newHolder=" + this.newHolder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + '}';
        }
    }

    /* renamed from: android.support.v7.widget.DefaultItemAnimator$MoveInfo */
    class MoveInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder holder;
        public int toX;
        public int toY;

        private MoveInfo(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
            this.holder = viewHolder;
            this.fromX = i;
            this.fromY = i2;
            this.toX = i3;
            this.toY = i4;
        }
    }

    /* renamed from: android.support.v7.widget.DefaultItemAnimator$VpaListenerAdapter */
    class VpaListenerAdapter implements ViewPropertyAnimatorListener {
        private VpaListenerAdapter() {
        }

        public void onAnimationCancel(View view) {
        }

        public void onAnimationEnd(View view) {
        }

        public void onAnimationStart(View view) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1796a() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1797a(final ChangeInfo changeInfo) {
        final View view = null;
        RecyclerView.ViewHolder viewHolder = changeInfo.oldHolder;
        View view2 = viewHolder == null ? null : viewHolder.itemView;
        RecyclerView.ViewHolder viewHolder2 = changeInfo.newHolder;
        if (viewHolder2 != null) {
            view = viewHolder2.itemView;
        }
        if (view2 != null) {
            final ViewPropertyAnimatorCompat duration = ViewCompat.animate(view2).setDuration(getChangeDuration());
            this.f2727k.add(changeInfo.oldHolder);
            duration.translationX((float) (changeInfo.toX - changeInfo.fromX));
            duration.translationY((float) (changeInfo.toY - changeInfo.fromY));
            duration.alpha(BitmapDescriptorFactory.HUE_RED).setListener(new VpaListenerAdapter() {
                public void onAnimationEnd(View view) {
                    duration.setListener((ViewPropertyAnimatorListener) null);
                    ViewCompat.setAlpha(view, 1.0f);
                    ViewCompat.setTranslationX(view, BitmapDescriptorFactory.HUE_RED);
                    ViewCompat.setTranslationY(view, BitmapDescriptorFactory.HUE_RED);
                    DefaultItemAnimator.this.dispatchChangeFinished(changeInfo.oldHolder, true);
                    DefaultItemAnimator.this.f2727k.remove(changeInfo.oldHolder);
                    DefaultItemAnimator.this.m1796a();
                }

                public void onAnimationStart(View view) {
                    DefaultItemAnimator.this.dispatchChangeStarting(changeInfo.oldHolder, true);
                }
            }).start();
        }
        if (view != null) {
            final ViewPropertyAnimatorCompat animate = ViewCompat.animate(view);
            this.f2727k.add(changeInfo.newHolder);
            animate.translationX(BitmapDescriptorFactory.HUE_RED).translationY(BitmapDescriptorFactory.HUE_RED).setDuration(getChangeDuration()).alpha(1.0f).setListener(new VpaListenerAdapter() {
                public void onAnimationEnd(View view) {
                    animate.setListener((ViewPropertyAnimatorListener) null);
                    ViewCompat.setAlpha(view, 1.0f);
                    ViewCompat.setTranslationX(view, BitmapDescriptorFactory.HUE_RED);
                    ViewCompat.setTranslationY(view, BitmapDescriptorFactory.HUE_RED);
                    DefaultItemAnimator.this.dispatchChangeFinished(changeInfo.newHolder, false);
                    DefaultItemAnimator.this.f2727k.remove(changeInfo.newHolder);
                    DefaultItemAnimator.this.m1796a();
                }

                public void onAnimationStart(View view) {
                    DefaultItemAnimator.this.dispatchChangeStarting(changeInfo.newHolder, false);
                }
            }).start();
        }
    }

    /* renamed from: a */
    private void m1801a(final RecyclerView.ViewHolder viewHolder) {
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(viewHolder.itemView);
        this.f2726j.add(viewHolder);
        animate.setDuration(getRemoveDuration()).alpha(BitmapDescriptorFactory.HUE_RED).setListener(new VpaListenerAdapter() {
            public void onAnimationEnd(View view) {
                animate.setListener((ViewPropertyAnimatorListener) null);
                ViewCompat.setAlpha(view, 1.0f);
                DefaultItemAnimator.this.dispatchRemoveFinished(viewHolder);
                DefaultItemAnimator.this.f2726j.remove(viewHolder);
                DefaultItemAnimator.this.m1796a();
            }

            public void onAnimationStart(View view) {
                DefaultItemAnimator.this.dispatchRemoveStarting(viewHolder);
            }
        }).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1802a(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.itemView;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            ViewCompat.animate(view).translationX(BitmapDescriptorFactory.HUE_RED);
        }
        if (i6 != 0) {
            ViewCompat.animate(view).translationY(BitmapDescriptorFactory.HUE_RED);
        }
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(view);
        this.f2725i.add(viewHolder);
        final RecyclerView.ViewHolder viewHolder2 = viewHolder;
        animate.setDuration(getMoveDuration()).setListener(new VpaListenerAdapter() {
            public void onAnimationCancel(View view) {
                if (i5 != 0) {
                    ViewCompat.setTranslationX(view, BitmapDescriptorFactory.HUE_RED);
                }
                if (i6 != 0) {
                    ViewCompat.setTranslationY(view, BitmapDescriptorFactory.HUE_RED);
                }
            }

            public void onAnimationEnd(View view) {
                animate.setListener((ViewPropertyAnimatorListener) null);
                DefaultItemAnimator.this.dispatchMoveFinished(viewHolder2);
                DefaultItemAnimator.this.f2725i.remove(viewHolder2);
                DefaultItemAnimator.this.m1796a();
            }

            public void onAnimationStart(View view) {
                DefaultItemAnimator.this.dispatchMoveStarting(viewHolder2);
            }
        }).start();
    }

    /* renamed from: a */
    private void m1803a(List<ChangeInfo> list, RecyclerView.ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = list.get(size);
            if (m1804a(changeInfo, viewHolder) && changeInfo.oldHolder == null && changeInfo.newHolder == null) {
                list.remove(changeInfo);
            }
        }
    }

    /* renamed from: a */
    private boolean m1804a(ChangeInfo changeInfo, RecyclerView.ViewHolder viewHolder) {
        boolean z = false;
        if (changeInfo.newHolder == viewHolder) {
            changeInfo.newHolder = null;
        } else if (changeInfo.oldHolder != viewHolder) {
            return false;
        } else {
            changeInfo.oldHolder = null;
            z = true;
        }
        ViewCompat.setAlpha(viewHolder.itemView, 1.0f);
        ViewCompat.setTranslationX(viewHolder.itemView, BitmapDescriptorFactory.HUE_RED);
        ViewCompat.setTranslationY(viewHolder.itemView, BitmapDescriptorFactory.HUE_RED);
        dispatchChangeFinished(viewHolder, z);
        return true;
    }

    /* renamed from: b */
    private void m1806b(ChangeInfo changeInfo) {
        if (changeInfo.oldHolder != null) {
            m1804a(changeInfo, changeInfo.oldHolder);
        }
        if (changeInfo.newHolder != null) {
            m1804a(changeInfo, changeInfo.newHolder);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1807b(final RecyclerView.ViewHolder viewHolder) {
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(viewHolder.itemView);
        this.f2724h.add(viewHolder);
        animate.alpha(1.0f).setDuration(getAddDuration()).setListener(new VpaListenerAdapter() {
            public void onAnimationCancel(View view) {
                ViewCompat.setAlpha(view, 1.0f);
            }

            public void onAnimationEnd(View view) {
                animate.setListener((ViewPropertyAnimatorListener) null);
                DefaultItemAnimator.this.dispatchAddFinished(viewHolder);
                DefaultItemAnimator.this.f2724h.remove(viewHolder);
                DefaultItemAnimator.this.m1796a();
            }

            public void onAnimationStart(View view) {
                DefaultItemAnimator.this.dispatchAddStarting(viewHolder);
            }
        }).start();
    }

    /* renamed from: c */
    private void m1809c(RecyclerView.ViewHolder viewHolder) {
        AnimatorCompatHelper.clearInterpolator(viewHolder.itemView);
        endAnimation(viewHolder);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5225a(List<RecyclerView.ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ViewCompat.animate(list.get(size).itemView).cancel();
        }
    }

    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        m1809c(viewHolder);
        ViewCompat.setAlpha(viewHolder.itemView, BitmapDescriptorFactory.HUE_RED);
        this.f2718b.add(viewHolder);
        return true;
    }

    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        float translationX = ViewCompat.getTranslationX(viewHolder.itemView);
        float translationY = ViewCompat.getTranslationY(viewHolder.itemView);
        float alpha = ViewCompat.getAlpha(viewHolder.itemView);
        m1809c(viewHolder);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        ViewCompat.setTranslationX(viewHolder.itemView, translationX);
        ViewCompat.setTranslationY(viewHolder.itemView, translationY);
        ViewCompat.setAlpha(viewHolder.itemView, alpha);
        if (!(viewHolder2 == null || viewHolder2.itemView == null)) {
            m1809c(viewHolder2);
            ViewCompat.setTranslationX(viewHolder2.itemView, (float) (-i5));
            ViewCompat.setTranslationY(viewHolder2.itemView, (float) (-i6));
            ViewCompat.setAlpha(viewHolder2.itemView, BitmapDescriptorFactory.HUE_RED);
        }
        this.f2720d.add(new ChangeInfo(viewHolder, viewHolder2, i, i2, i3, i4));
        return true;
    }

    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.itemView;
        int translationX = (int) (((float) i) + ViewCompat.getTranslationX(viewHolder.itemView));
        int translationY = (int) (((float) i2) + ViewCompat.getTranslationY(viewHolder.itemView));
        m1809c(viewHolder);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        if (i5 != 0) {
            ViewCompat.setTranslationX(view, (float) (-i5));
        }
        if (i6 != 0) {
            ViewCompat.setTranslationY(view, (float) (-i6));
        }
        this.f2719c.add(new MoveInfo(viewHolder, translationX, translationY, i3, i4));
        return true;
    }

    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        m1809c(viewHolder);
        this.f2717a.add(viewHolder);
        return true;
    }

    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ViewCompat.animate(view).cancel();
        for (int size = this.f2719c.size() - 1; size >= 0; size--) {
            if (this.f2719c.get(size).holder == viewHolder) {
                ViewCompat.setTranslationY(view, BitmapDescriptorFactory.HUE_RED);
                ViewCompat.setTranslationX(view, BitmapDescriptorFactory.HUE_RED);
                dispatchMoveFinished(viewHolder);
                this.f2719c.remove(size);
            }
        }
        m1803a((List<ChangeInfo>) this.f2720d, viewHolder);
        if (this.f2717a.remove(viewHolder)) {
            ViewCompat.setAlpha(view, 1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.f2718b.remove(viewHolder)) {
            ViewCompat.setAlpha(view, 1.0f);
            dispatchAddFinished(viewHolder);
        }
        for (int size2 = this.f2723g.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.f2723g.get(size2);
            m1803a((List<ChangeInfo>) arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.f2723g.remove(size2);
            }
        }
        for (int size3 = this.f2722f.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.f2722f.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((MoveInfo) arrayList2.get(size4)).holder == viewHolder) {
                    ViewCompat.setTranslationY(view, BitmapDescriptorFactory.HUE_RED);
                    ViewCompat.setTranslationX(view, BitmapDescriptorFactory.HUE_RED);
                    dispatchMoveFinished(viewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f2722f.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f2721e.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.f2721e.get(size5);
            if (arrayList3.remove(viewHolder)) {
                ViewCompat.setAlpha(view, 1.0f);
                dispatchAddFinished(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.f2721e.remove(size5);
                }
            }
        }
        if (this.f2726j.remove(viewHolder)) {
        }
        if (this.f2724h.remove(viewHolder)) {
        }
        if (this.f2727k.remove(viewHolder)) {
        }
        if (this.f2725i.remove(viewHolder)) {
        }
        m1796a();
    }

    public void endAnimations() {
        for (int size = this.f2719c.size() - 1; size >= 0; size--) {
            MoveInfo moveInfo = this.f2719c.get(size);
            View view = moveInfo.holder.itemView;
            ViewCompat.setTranslationY(view, BitmapDescriptorFactory.HUE_RED);
            ViewCompat.setTranslationX(view, BitmapDescriptorFactory.HUE_RED);
            dispatchMoveFinished(moveInfo.holder);
            this.f2719c.remove(size);
        }
        for (int size2 = this.f2717a.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.f2717a.get(size2));
            this.f2717a.remove(size2);
        }
        for (int size3 = this.f2718b.size() - 1; size3 >= 0; size3--) {
            RecyclerView.ViewHolder viewHolder = this.f2718b.get(size3);
            ViewCompat.setAlpha(viewHolder.itemView, 1.0f);
            dispatchAddFinished(viewHolder);
            this.f2718b.remove(size3);
        }
        for (int size4 = this.f2720d.size() - 1; size4 >= 0; size4--) {
            m1806b(this.f2720d.get(size4));
        }
        this.f2720d.clear();
        if (isRunning()) {
            for (int size5 = this.f2722f.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.f2722f.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    MoveInfo moveInfo2 = (MoveInfo) arrayList.get(size6);
                    View view2 = moveInfo2.holder.itemView;
                    ViewCompat.setTranslationY(view2, BitmapDescriptorFactory.HUE_RED);
                    ViewCompat.setTranslationX(view2, BitmapDescriptorFactory.HUE_RED);
                    dispatchMoveFinished(moveInfo2.holder);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f2722f.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f2721e.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.f2721e.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ViewHolder viewHolder2 = (RecyclerView.ViewHolder) arrayList2.get(size8);
                    ViewCompat.setAlpha(viewHolder2.itemView, 1.0f);
                    dispatchAddFinished(viewHolder2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f2721e.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f2723g.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.f2723g.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    m1806b((ChangeInfo) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f2723g.remove(arrayList3);
                    }
                }
            }
            mo5225a((List<RecyclerView.ViewHolder>) this.f2726j);
            mo5225a((List<RecyclerView.ViewHolder>) this.f2725i);
            mo5225a((List<RecyclerView.ViewHolder>) this.f2724h);
            mo5225a((List<RecyclerView.ViewHolder>) this.f2727k);
            dispatchAnimationsFinished();
        }
    }

    public boolean isRunning() {
        return !this.f2718b.isEmpty() || !this.f2720d.isEmpty() || !this.f2719c.isEmpty() || !this.f2717a.isEmpty() || !this.f2725i.isEmpty() || !this.f2726j.isEmpty() || !this.f2724h.isEmpty() || !this.f2727k.isEmpty() || !this.f2722f.isEmpty() || !this.f2721e.isEmpty() || !this.f2723g.isEmpty();
    }

    public void runPendingAnimations() {
        boolean z = !this.f2717a.isEmpty();
        boolean z2 = !this.f2719c.isEmpty();
        boolean z3 = !this.f2720d.isEmpty();
        boolean z4 = !this.f2718b.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.ViewHolder> it = this.f2717a.iterator();
            while (it.hasNext()) {
                m1801a(it.next());
            }
            this.f2717a.clear();
            if (z2) {
                final ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f2719c);
                this.f2722f.add(arrayList);
                this.f2719c.clear();
                C02891 r8 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MoveInfo moveInfo = (MoveInfo) it.next();
                            DefaultItemAnimator.this.m1802a(moveInfo.holder, moveInfo.fromX, moveInfo.fromY, moveInfo.toX, moveInfo.toY);
                        }
                        arrayList.clear();
                        DefaultItemAnimator.this.f2722f.remove(arrayList);
                    }
                };
                if (z) {
                    ViewCompat.postOnAnimationDelayed(((MoveInfo) arrayList.get(0)).holder.itemView, r8, getRemoveDuration());
                } else {
                    r8.run();
                }
            }
            if (z3) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f2720d);
                this.f2723g.add(arrayList2);
                this.f2720d.clear();
                C02902 r82 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            DefaultItemAnimator.this.m1797a((ChangeInfo) it.next());
                        }
                        arrayList2.clear();
                        DefaultItemAnimator.this.f2723g.remove(arrayList2);
                    }
                };
                if (z) {
                    ViewCompat.postOnAnimationDelayed(((ChangeInfo) arrayList2.get(0)).oldHolder.itemView, r82, getRemoveDuration());
                } else {
                    r82.run();
                }
            }
            if (z4) {
                final ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.f2718b);
                this.f2721e.add(arrayList3);
                this.f2718b.clear();
                C02913 r12 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            DefaultItemAnimator.this.m1807b((RecyclerView.ViewHolder) it.next());
                        }
                        arrayList3.clear();
                        DefaultItemAnimator.this.f2721e.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    ViewCompat.postOnAnimationDelayed(((RecyclerView.ViewHolder) arrayList3.get(0)).itemView, r12, (z ? getRemoveDuration() : 0) + Math.max(z2 ? getMoveDuration() : 0, z3 ? getChangeDuration() : 0));
                } else {
                    r12.run();
                }
            }
        }
    }
}
