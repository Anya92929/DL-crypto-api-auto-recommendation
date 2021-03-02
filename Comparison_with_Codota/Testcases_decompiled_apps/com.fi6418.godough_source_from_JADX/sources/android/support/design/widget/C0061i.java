package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.design.C0007h;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* renamed from: android.support.design.widget.i */
public class C0061i extends ViewGroup.MarginLayoutParams {

    /* renamed from: a */
    C0059g f200a;

    /* renamed from: b */
    boolean f201b = false;

    /* renamed from: c */
    public int f202c = 0;

    /* renamed from: d */
    public int f203d = 0;

    /* renamed from: e */
    public int f204e = -1;

    /* renamed from: f */
    int f205f = -1;

    /* renamed from: g */
    View f206g;

    /* renamed from: h */
    View f207h;

    /* renamed from: i */
    final Rect f208i = new Rect();

    /* renamed from: j */
    Object f209j;

    /* renamed from: k */
    private boolean f210k;

    /* renamed from: l */
    private boolean f211l;

    /* renamed from: m */
    private boolean f212m;

    public C0061i(int i, int i2) {
        super(i, i2);
    }

    C0061i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0007h.CoordinatorLayout_LayoutParams);
        this.f202c = obtainStyledAttributes.getInteger(C0007h.CoordinatorLayout_LayoutParams_android_layout_gravity, 0);
        this.f205f = obtainStyledAttributes.getResourceId(C0007h.CoordinatorLayout_LayoutParams_layout_anchor, -1);
        this.f203d = obtainStyledAttributes.getInteger(C0007h.CoordinatorLayout_LayoutParams_layout_anchorGravity, 0);
        this.f204e = obtainStyledAttributes.getInteger(C0007h.CoordinatorLayout_LayoutParams_layout_keyline, -1);
        this.f201b = obtainStyledAttributes.hasValue(C0007h.CoordinatorLayout_LayoutParams_layout_behavior);
        if (this.f201b) {
            this.f200a = CoordinatorLayout.m49a(context, attributeSet, obtainStyledAttributes.getString(C0007h.CoordinatorLayout_LayoutParams_layout_behavior));
        }
        obtainStyledAttributes.recycle();
    }

    public C0061i(C0061i iVar) {
        super(iVar);
    }

    public C0061i(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public C0061i(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    /* renamed from: a */
    private void m326a(View view, CoordinatorLayout coordinatorLayout) {
        this.f206g = coordinatorLayout.findViewById(this.f205f);
        if (this.f206g != null) {
            View view2 = this.f206g;
            ViewParent parent = this.f206g.getParent();
            while (parent != coordinatorLayout && parent != null) {
                if (parent != view) {
                    if (parent instanceof View) {
                        view2 = (View) parent;
                    }
                    parent = parent.getParent();
                } else if (coordinatorLayout.isInEditMode()) {
                    this.f207h = null;
                    this.f206g = null;
                    return;
                } else {
                    throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                }
            }
            this.f207h = view2;
        } else if (coordinatorLayout.isInEditMode()) {
            this.f207h = null;
            this.f206g = null;
        } else {
            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f205f) + " to anchor view " + view);
        }
    }

    /* renamed from: b */
    private boolean m327b(View view, CoordinatorLayout coordinatorLayout) {
        if (this.f206g.getId() != this.f205f) {
            return false;
        }
        View view2 = this.f206g;
        for (ViewParent parent = this.f206g.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
            if (parent == null || parent == view) {
                this.f207h = null;
                this.f206g = null;
                return false;
            }
            if (parent instanceof View) {
                view2 = (View) parent;
            }
        }
        this.f207h = view2;
        return true;
    }

    /* renamed from: a */
    public int mo276a() {
        return this.f205f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo277a(Rect rect) {
        this.f208i.set(rect);
    }

    /* renamed from: a */
    public void mo278a(C0059g gVar) {
        if (this.f200a != gVar) {
            this.f200a = gVar;
            this.f209j = null;
            this.f201b = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo279a(boolean z) {
        this.f211l = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo280a(CoordinatorLayout coordinatorLayout, View view) {
        if (this.f210k) {
            return true;
        }
        boolean d = (this.f200a != null ? this.f200a.mo273d(coordinatorLayout, view) : false) | this.f210k;
        this.f210k = d;
        return d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo281a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 == this.f207h || (this.f200a != null && this.f200a.mo63b(coordinatorLayout, view, view2));
    }

    /* renamed from: b */
    public C0059g mo282b() {
        return this.f200a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public View mo283b(CoordinatorLayout coordinatorLayout, View view) {
        if (this.f205f == -1) {
            this.f207h = null;
            this.f206g = null;
            return null;
        }
        if (this.f206g == null || !m327b(view, coordinatorLayout)) {
            m326a(view, coordinatorLayout);
        }
        return this.f206g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo284b(boolean z) {
        this.f212m = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Rect mo285c() {
        return this.f208i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo286c(CoordinatorLayout coordinatorLayout, View view) {
        return this.f200a != null && this.f200a.mo274e(coordinatorLayout, view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo287d() {
        return this.f206g == null && this.f205f != -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo288e() {
        if (this.f200a == null) {
            this.f210k = false;
        }
        return this.f210k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo289f() {
        this.f210k = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo290g() {
        this.f211l = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo291h() {
        return this.f211l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo292i() {
        return this.f212m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo293j() {
        this.f212m = false;
    }
}
