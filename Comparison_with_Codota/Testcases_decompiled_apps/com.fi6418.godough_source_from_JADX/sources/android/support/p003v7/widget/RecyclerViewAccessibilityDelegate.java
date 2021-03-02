package android.support.p003v7.widget;

import android.os.Bundle;
import android.support.p000v4.view.AccessibilityDelegateCompat;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v7.widget.RecyclerViewAccessibilityDelegate */
public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {

    /* renamed from: b */
    final RecyclerView f3052b;

    /* renamed from: c */
    final AccessibilityDelegateCompat f3053c = new AccessibilityDelegateCompat() {
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!RecyclerViewAccessibilityDelegate.this.m2181c() && RecyclerViewAccessibilityDelegate.this.f3052b.getLayoutManager() != null) {
                RecyclerViewAccessibilityDelegate.this.f3052b.getLayoutManager().mo5707a(view, accessibilityNodeInfoCompat);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (RecyclerViewAccessibilityDelegate.this.m2181c() || RecyclerViewAccessibilityDelegate.this.f3052b.getLayoutManager() == null) {
                return false;
            }
            return RecyclerViewAccessibilityDelegate.this.f3052b.getLayoutManager().mo5709a(view, i, bundle);
        }
    };

    public RecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        this.f3052b = recyclerView;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m2181c() {
        return this.f3052b.hasPendingAdapterUpdates();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public AccessibilityDelegateCompat mo5942b() {
        return this.f3053c;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !m2181c()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(RecyclerView.class.getName());
        if (!m2181c() && this.f3052b.getLayoutManager() != null) {
            this.f3052b.getLayoutManager().mo5703a(accessibilityNodeInfoCompat);
        }
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (m2181c() || this.f3052b.getLayoutManager() == null) {
            return false;
        }
        return this.f3052b.getLayoutManager().mo5708a(i, bundle);
    }
}
