package android.support.p000v4.view.accessibility;

import android.os.Build;
import android.os.Parcelable;
import android.view.View;
import java.util.Collections;
import java.util.List;

/* renamed from: android.support.v4.view.accessibility.AccessibilityRecordCompat */
public class AccessibilityRecordCompat {

    /* renamed from: a */
    private static final AccessibilityRecordImpl f1371a;

    /* renamed from: b */
    private final Object f1372b;

    /* renamed from: android.support.v4.view.accessibility.AccessibilityRecordCompat$AccessibilityRecordIcsImpl */
    class AccessibilityRecordIcsImpl extends AccessibilityRecordStubImpl {
        AccessibilityRecordIcsImpl() {
        }

        public int getAddedCount(Object obj) {
            return AccessibilityRecordCompatIcs.getAddedCount(obj);
        }

        public CharSequence getBeforeText(Object obj) {
            return AccessibilityRecordCompatIcs.getBeforeText(obj);
        }

        public CharSequence getClassName(Object obj) {
            return AccessibilityRecordCompatIcs.getClassName(obj);
        }

        public CharSequence getContentDescription(Object obj) {
            return AccessibilityRecordCompatIcs.getContentDescription(obj);
        }

        public int getCurrentItemIndex(Object obj) {
            return AccessibilityRecordCompatIcs.getCurrentItemIndex(obj);
        }

        public int getFromIndex(Object obj) {
            return AccessibilityRecordCompatIcs.getFromIndex(obj);
        }

        public int getItemCount(Object obj) {
            return AccessibilityRecordCompatIcs.getItemCount(obj);
        }

        public Parcelable getParcelableData(Object obj) {
            return AccessibilityRecordCompatIcs.getParcelableData(obj);
        }

        public int getRemovedCount(Object obj) {
            return AccessibilityRecordCompatIcs.getRemovedCount(obj);
        }

        public int getScrollX(Object obj) {
            return AccessibilityRecordCompatIcs.getScrollX(obj);
        }

        public int getScrollY(Object obj) {
            return AccessibilityRecordCompatIcs.getScrollY(obj);
        }

        public AccessibilityNodeInfoCompat getSource(Object obj) {
            return AccessibilityNodeInfoCompat.m958a(AccessibilityRecordCompatIcs.getSource(obj));
        }

        public List<CharSequence> getText(Object obj) {
            return AccessibilityRecordCompatIcs.getText(obj);
        }

        public int getToIndex(Object obj) {
            return AccessibilityRecordCompatIcs.getToIndex(obj);
        }

        public int getWindowId(Object obj) {
            return AccessibilityRecordCompatIcs.getWindowId(obj);
        }

        public boolean isChecked(Object obj) {
            return AccessibilityRecordCompatIcs.isChecked(obj);
        }

        public boolean isEnabled(Object obj) {
            return AccessibilityRecordCompatIcs.isEnabled(obj);
        }

        public boolean isFullScreen(Object obj) {
            return AccessibilityRecordCompatIcs.isFullScreen(obj);
        }

        public boolean isPassword(Object obj) {
            return AccessibilityRecordCompatIcs.isPassword(obj);
        }

        public boolean isScrollable(Object obj) {
            return AccessibilityRecordCompatIcs.isScrollable(obj);
        }

        public Object obtain() {
            return AccessibilityRecordCompatIcs.obtain();
        }

        public Object obtain(Object obj) {
            return AccessibilityRecordCompatIcs.obtain(obj);
        }

        public void recycle(Object obj) {
            AccessibilityRecordCompatIcs.recycle(obj);
        }

        public void setAddedCount(Object obj, int i) {
            AccessibilityRecordCompatIcs.setAddedCount(obj, i);
        }

        public void setBeforeText(Object obj, CharSequence charSequence) {
            AccessibilityRecordCompatIcs.setBeforeText(obj, charSequence);
        }

        public void setChecked(Object obj, boolean z) {
            AccessibilityRecordCompatIcs.setChecked(obj, z);
        }

        public void setClassName(Object obj, CharSequence charSequence) {
            AccessibilityRecordCompatIcs.setClassName(obj, charSequence);
        }

        public void setContentDescription(Object obj, CharSequence charSequence) {
            AccessibilityRecordCompatIcs.setContentDescription(obj, charSequence);
        }

        public void setCurrentItemIndex(Object obj, int i) {
            AccessibilityRecordCompatIcs.setCurrentItemIndex(obj, i);
        }

        public void setEnabled(Object obj, boolean z) {
            AccessibilityRecordCompatIcs.setEnabled(obj, z);
        }

        public void setFromIndex(Object obj, int i) {
            AccessibilityRecordCompatIcs.setFromIndex(obj, i);
        }

        public void setFullScreen(Object obj, boolean z) {
            AccessibilityRecordCompatIcs.setFullScreen(obj, z);
        }

        public void setItemCount(Object obj, int i) {
            AccessibilityRecordCompatIcs.setItemCount(obj, i);
        }

        public void setParcelableData(Object obj, Parcelable parcelable) {
            AccessibilityRecordCompatIcs.setParcelableData(obj, parcelable);
        }

        public void setPassword(Object obj, boolean z) {
            AccessibilityRecordCompatIcs.setPassword(obj, z);
        }

        public void setRemovedCount(Object obj, int i) {
            AccessibilityRecordCompatIcs.setRemovedCount(obj, i);
        }

        public void setScrollX(Object obj, int i) {
            AccessibilityRecordCompatIcs.setScrollX(obj, i);
        }

        public void setScrollY(Object obj, int i) {
            AccessibilityRecordCompatIcs.setScrollY(obj, i);
        }

        public void setScrollable(Object obj, boolean z) {
            AccessibilityRecordCompatIcs.setScrollable(obj, z);
        }

        public void setSource(Object obj, View view) {
            AccessibilityRecordCompatIcs.setSource(obj, view);
        }

        public void setToIndex(Object obj, int i) {
            AccessibilityRecordCompatIcs.setToIndex(obj, i);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityRecordCompat$AccessibilityRecordIcsMr1Impl */
    class AccessibilityRecordIcsMr1Impl extends AccessibilityRecordIcsImpl {
        AccessibilityRecordIcsMr1Impl() {
        }

        public int getMaxScrollX(Object obj) {
            return AccessibilityRecordCompatIcsMr1.getMaxScrollX(obj);
        }

        public int getMaxScrollY(Object obj) {
            return AccessibilityRecordCompatIcsMr1.getMaxScrollY(obj);
        }

        public void setMaxScrollX(Object obj, int i) {
            AccessibilityRecordCompatIcsMr1.setMaxScrollX(obj, i);
        }

        public void setMaxScrollY(Object obj, int i) {
            AccessibilityRecordCompatIcsMr1.setMaxScrollY(obj, i);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityRecordCompat$AccessibilityRecordImpl */
    interface AccessibilityRecordImpl {
        int getAddedCount(Object obj);

        CharSequence getBeforeText(Object obj);

        CharSequence getClassName(Object obj);

        CharSequence getContentDescription(Object obj);

        int getCurrentItemIndex(Object obj);

        int getFromIndex(Object obj);

        int getItemCount(Object obj);

        int getMaxScrollX(Object obj);

        int getMaxScrollY(Object obj);

        Parcelable getParcelableData(Object obj);

        int getRemovedCount(Object obj);

        int getScrollX(Object obj);

        int getScrollY(Object obj);

        AccessibilityNodeInfoCompat getSource(Object obj);

        List<CharSequence> getText(Object obj);

        int getToIndex(Object obj);

        int getWindowId(Object obj);

        boolean isChecked(Object obj);

        boolean isEnabled(Object obj);

        boolean isFullScreen(Object obj);

        boolean isPassword(Object obj);

        boolean isScrollable(Object obj);

        Object obtain();

        Object obtain(Object obj);

        void recycle(Object obj);

        void setAddedCount(Object obj, int i);

        void setBeforeText(Object obj, CharSequence charSequence);

        void setChecked(Object obj, boolean z);

        void setClassName(Object obj, CharSequence charSequence);

        void setContentDescription(Object obj, CharSequence charSequence);

        void setCurrentItemIndex(Object obj, int i);

        void setEnabled(Object obj, boolean z);

        void setFromIndex(Object obj, int i);

        void setFullScreen(Object obj, boolean z);

        void setItemCount(Object obj, int i);

        void setMaxScrollX(Object obj, int i);

        void setMaxScrollY(Object obj, int i);

        void setParcelableData(Object obj, Parcelable parcelable);

        void setPassword(Object obj, boolean z);

        void setRemovedCount(Object obj, int i);

        void setScrollX(Object obj, int i);

        void setScrollY(Object obj, int i);

        void setScrollable(Object obj, boolean z);

        void setSource(Object obj, View view);

        void setSource(Object obj, View view, int i);

        void setToIndex(Object obj, int i);
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityRecordCompat$AccessibilityRecordJellyBeanImpl */
    class AccessibilityRecordJellyBeanImpl extends AccessibilityRecordIcsMr1Impl {
        AccessibilityRecordJellyBeanImpl() {
        }

        public void setSource(Object obj, View view, int i) {
            AccessibilityRecordCompatJellyBean.setSource(obj, view, i);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityRecordCompat$AccessibilityRecordStubImpl */
    class AccessibilityRecordStubImpl implements AccessibilityRecordImpl {
        AccessibilityRecordStubImpl() {
        }

        public int getAddedCount(Object obj) {
            return 0;
        }

        public CharSequence getBeforeText(Object obj) {
            return null;
        }

        public CharSequence getClassName(Object obj) {
            return null;
        }

        public CharSequence getContentDescription(Object obj) {
            return null;
        }

        public int getCurrentItemIndex(Object obj) {
            return 0;
        }

        public int getFromIndex(Object obj) {
            return 0;
        }

        public int getItemCount(Object obj) {
            return 0;
        }

        public int getMaxScrollX(Object obj) {
            return 0;
        }

        public int getMaxScrollY(Object obj) {
            return 0;
        }

        public Parcelable getParcelableData(Object obj) {
            return null;
        }

        public int getRemovedCount(Object obj) {
            return 0;
        }

        public int getScrollX(Object obj) {
            return 0;
        }

        public int getScrollY(Object obj) {
            return 0;
        }

        public AccessibilityNodeInfoCompat getSource(Object obj) {
            return null;
        }

        public List<CharSequence> getText(Object obj) {
            return Collections.emptyList();
        }

        public int getToIndex(Object obj) {
            return 0;
        }

        public int getWindowId(Object obj) {
            return 0;
        }

        public boolean isChecked(Object obj) {
            return false;
        }

        public boolean isEnabled(Object obj) {
            return false;
        }

        public boolean isFullScreen(Object obj) {
            return false;
        }

        public boolean isPassword(Object obj) {
            return false;
        }

        public boolean isScrollable(Object obj) {
            return false;
        }

        public Object obtain() {
            return null;
        }

        public Object obtain(Object obj) {
            return null;
        }

        public void recycle(Object obj) {
        }

        public void setAddedCount(Object obj, int i) {
        }

        public void setBeforeText(Object obj, CharSequence charSequence) {
        }

        public void setChecked(Object obj, boolean z) {
        }

        public void setClassName(Object obj, CharSequence charSequence) {
        }

        public void setContentDescription(Object obj, CharSequence charSequence) {
        }

        public void setCurrentItemIndex(Object obj, int i) {
        }

        public void setEnabled(Object obj, boolean z) {
        }

        public void setFromIndex(Object obj, int i) {
        }

        public void setFullScreen(Object obj, boolean z) {
        }

        public void setItemCount(Object obj, int i) {
        }

        public void setMaxScrollX(Object obj, int i) {
        }

        public void setMaxScrollY(Object obj, int i) {
        }

        public void setParcelableData(Object obj, Parcelable parcelable) {
        }

        public void setPassword(Object obj, boolean z) {
        }

        public void setRemovedCount(Object obj, int i) {
        }

        public void setScrollX(Object obj, int i) {
        }

        public void setScrollY(Object obj, int i) {
        }

        public void setScrollable(Object obj, boolean z) {
        }

        public void setSource(Object obj, View view) {
        }

        public void setSource(Object obj, View view, int i) {
        }

        public void setToIndex(Object obj, int i) {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f1371a = new AccessibilityRecordJellyBeanImpl();
        } else if (Build.VERSION.SDK_INT >= 15) {
            f1371a = new AccessibilityRecordIcsMr1Impl();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f1371a = new AccessibilityRecordIcsImpl();
        } else {
            f1371a = new AccessibilityRecordStubImpl();
        }
    }

    public AccessibilityRecordCompat(Object obj) {
        this.f1372b = obj;
    }

    public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(f1371a.obtain());
    }

    public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat accessibilityRecordCompat) {
        return new AccessibilityRecordCompat(f1371a.obtain(accessibilityRecordCompat.f1372b));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AccessibilityRecordCompat accessibilityRecordCompat = (AccessibilityRecordCompat) obj;
        return this.f1372b == null ? accessibilityRecordCompat.f1372b == null : this.f1372b.equals(accessibilityRecordCompat.f1372b);
    }

    public int getAddedCount() {
        return f1371a.getAddedCount(this.f1372b);
    }

    public CharSequence getBeforeText() {
        return f1371a.getBeforeText(this.f1372b);
    }

    public CharSequence getClassName() {
        return f1371a.getClassName(this.f1372b);
    }

    public CharSequence getContentDescription() {
        return f1371a.getContentDescription(this.f1372b);
    }

    public int getCurrentItemIndex() {
        return f1371a.getCurrentItemIndex(this.f1372b);
    }

    public int getFromIndex() {
        return f1371a.getFromIndex(this.f1372b);
    }

    public Object getImpl() {
        return this.f1372b;
    }

    public int getItemCount() {
        return f1371a.getItemCount(this.f1372b);
    }

    public int getMaxScrollX() {
        return f1371a.getMaxScrollX(this.f1372b);
    }

    public int getMaxScrollY() {
        return f1371a.getMaxScrollY(this.f1372b);
    }

    public Parcelable getParcelableData() {
        return f1371a.getParcelableData(this.f1372b);
    }

    public int getRemovedCount() {
        return f1371a.getRemovedCount(this.f1372b);
    }

    public int getScrollX() {
        return f1371a.getScrollX(this.f1372b);
    }

    public int getScrollY() {
        return f1371a.getScrollY(this.f1372b);
    }

    public AccessibilityNodeInfoCompat getSource() {
        return f1371a.getSource(this.f1372b);
    }

    public List<CharSequence> getText() {
        return f1371a.getText(this.f1372b);
    }

    public int getToIndex() {
        return f1371a.getToIndex(this.f1372b);
    }

    public int getWindowId() {
        return f1371a.getWindowId(this.f1372b);
    }

    public int hashCode() {
        if (this.f1372b == null) {
            return 0;
        }
        return this.f1372b.hashCode();
    }

    public boolean isChecked() {
        return f1371a.isChecked(this.f1372b);
    }

    public boolean isEnabled() {
        return f1371a.isEnabled(this.f1372b);
    }

    public boolean isFullScreen() {
        return f1371a.isFullScreen(this.f1372b);
    }

    public boolean isPassword() {
        return f1371a.isPassword(this.f1372b);
    }

    public boolean isScrollable() {
        return f1371a.isScrollable(this.f1372b);
    }

    public void recycle() {
        f1371a.recycle(this.f1372b);
    }

    public void setAddedCount(int i) {
        f1371a.setAddedCount(this.f1372b, i);
    }

    public void setBeforeText(CharSequence charSequence) {
        f1371a.setBeforeText(this.f1372b, charSequence);
    }

    public void setChecked(boolean z) {
        f1371a.setChecked(this.f1372b, z);
    }

    public void setClassName(CharSequence charSequence) {
        f1371a.setClassName(this.f1372b, charSequence);
    }

    public void setContentDescription(CharSequence charSequence) {
        f1371a.setContentDescription(this.f1372b, charSequence);
    }

    public void setCurrentItemIndex(int i) {
        f1371a.setCurrentItemIndex(this.f1372b, i);
    }

    public void setEnabled(boolean z) {
        f1371a.setEnabled(this.f1372b, z);
    }

    public void setFromIndex(int i) {
        f1371a.setFromIndex(this.f1372b, i);
    }

    public void setFullScreen(boolean z) {
        f1371a.setFullScreen(this.f1372b, z);
    }

    public void setItemCount(int i) {
        f1371a.setItemCount(this.f1372b, i);
    }

    public void setMaxScrollX(int i) {
        f1371a.setMaxScrollX(this.f1372b, i);
    }

    public void setMaxScrollY(int i) {
        f1371a.setMaxScrollY(this.f1372b, i);
    }

    public void setParcelableData(Parcelable parcelable) {
        f1371a.setParcelableData(this.f1372b, parcelable);
    }

    public void setPassword(boolean z) {
        f1371a.setPassword(this.f1372b, z);
    }

    public void setRemovedCount(int i) {
        f1371a.setRemovedCount(this.f1372b, i);
    }

    public void setScrollX(int i) {
        f1371a.setScrollX(this.f1372b, i);
    }

    public void setScrollY(int i) {
        f1371a.setScrollY(this.f1372b, i);
    }

    public void setScrollable(boolean z) {
        f1371a.setScrollable(this.f1372b, z);
    }

    public void setSource(View view) {
        f1371a.setSource(this.f1372b, view);
    }

    public void setSource(View view, int i) {
        f1371a.setSource(this.f1372b, view, i);
    }

    public void setToIndex(int i) {
        f1371a.setToIndex(this.f1372b, i);
    }
}
