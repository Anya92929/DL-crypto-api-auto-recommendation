package android.support.p000v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompatApi21;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompatKitKat;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat */
public class AccessibilityNodeInfoCompat {
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 1048576;
    public static final int ACTION_EXPAND = 262144;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 2097152;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final AccessibilityNodeInfoImpl f1357a;

    /* renamed from: b */
    private final Object f1358b;

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat */
    public class AccessibilityActionCompat {
        public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_CLICK = new AccessibilityActionCompat(16, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_COLLAPSE = new AccessibilityActionCompat(524288, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_COPY = new AccessibilityActionCompat(16384, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_CUT = new AccessibilityActionCompat(65536, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_DISMISS = new AccessibilityActionCompat(1048576, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_EXPAND = new AccessibilityActionCompat(262144, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_FOCUS = new AccessibilityActionCompat(1, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_LONG_CLICK = new AccessibilityActionCompat(32, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_PASTE = new AccessibilityActionCompat(32768, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_SELECT = new AccessibilityActionCompat(4, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_SET_TEXT = new AccessibilityActionCompat(2097152, (CharSequence) null);
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Object f1359a;

        public AccessibilityActionCompat(int i, CharSequence charSequence) {
            this(AccessibilityNodeInfoCompat.f1357a.newAccessibilityAction(i, charSequence));
        }

        private AccessibilityActionCompat(Object obj) {
            this.f1359a = obj;
        }

        public int getId() {
            return AccessibilityNodeInfoCompat.f1357a.getAccessibilityActionId(this.f1359a);
        }

        public CharSequence getLabel() {
            return AccessibilityNodeInfoCompat.f1357a.getAccessibilityActionLabel(this.f1359a);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoApi21Impl */
    class AccessibilityNodeInfoApi21Impl extends AccessibilityNodeInfoKitKatImpl {
        AccessibilityNodeInfoApi21Impl() {
        }

        public void addAction(Object obj, Object obj2) {
            AccessibilityNodeInfoCompatApi21.m965a(obj, obj2);
        }

        public int getAccessibilityActionId(Object obj) {
            return AccessibilityNodeInfoCompatApi21.m966b(obj);
        }

        public CharSequence getAccessibilityActionLabel(Object obj) {
            return AccessibilityNodeInfoCompatApi21.m967c(obj);
        }

        public List<Object> getActionList(Object obj) {
            return AccessibilityNodeInfoCompatApi21.m964a(obj);
        }

        public CharSequence getError(Object obj) {
            return AccessibilityNodeInfoCompatApi21.getError(obj);
        }

        public int getMaxTextLength(Object obj) {
            return AccessibilityNodeInfoCompatApi21.getMaxTextLength(obj);
        }

        public Object getWindow(Object obj) {
            return AccessibilityNodeInfoCompatApi21.getWindow(obj);
        }

        public boolean isCollectionItemSelected(Object obj) {
            return AccessibilityNodeInfoCompatApi21.CollectionItemInfo.isSelected(obj);
        }

        public Object newAccessibilityAction(int i, CharSequence charSequence) {
            return AccessibilityNodeInfoCompatApi21.m963a(i, charSequence);
        }

        public Object obtainCollectionInfo(int i, int i2, boolean z, int i3) {
            return AccessibilityNodeInfoCompatApi21.obtainCollectionInfo(i, i2, z, i3);
        }

        public Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return AccessibilityNodeInfoCompatApi21.obtainCollectionItemInfo(i, i2, i3, i4, z, z2);
        }

        public boolean removeAction(Object obj, Object obj2) {
            return AccessibilityNodeInfoCompatApi21.removeAction(obj, obj2);
        }

        public boolean removeChild(Object obj, View view) {
            return AccessibilityNodeInfoCompatApi21.removeChild(obj, view);
        }

        public boolean removeChild(Object obj, View view, int i) {
            return AccessibilityNodeInfoCompatApi21.removeChild(obj, view, i);
        }

        public void setError(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatApi21.setError(obj, charSequence);
        }

        public void setMaxTextLength(Object obj, int i) {
            AccessibilityNodeInfoCompatApi21.setMaxTextLength(obj, i);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoApi22Impl */
    class AccessibilityNodeInfoApi22Impl extends AccessibilityNodeInfoApi21Impl {
        AccessibilityNodeInfoApi22Impl() {
        }

        public Object getTraversalAfter(Object obj) {
            return AccessibilityNodeInfoCompatApi22.getTraversalAfter(obj);
        }

        public Object getTraversalBefore(Object obj) {
            return AccessibilityNodeInfoCompatApi22.getTraversalBefore(obj);
        }

        public void setTraversalAfter(Object obj, View view) {
            AccessibilityNodeInfoCompatApi22.setTraversalAfter(obj, view);
        }

        public void setTraversalAfter(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatApi22.setTraversalAfter(obj, view, i);
        }

        public void setTraversalBefore(Object obj, View view) {
            AccessibilityNodeInfoCompatApi22.setTraversalBefore(obj, view);
        }

        public void setTraversalBefore(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatApi22.setTraversalBefore(obj, view, i);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoIcsImpl */
    class AccessibilityNodeInfoIcsImpl extends AccessibilityNodeInfoStubImpl {
        AccessibilityNodeInfoIcsImpl() {
        }

        public void addAction(Object obj, int i) {
            AccessibilityNodeInfoCompatIcs.addAction(obj, i);
        }

        public void addChild(Object obj, View view) {
            AccessibilityNodeInfoCompatIcs.addChild(obj, view);
        }

        public List<Object> findAccessibilityNodeInfosByText(Object obj, String str) {
            return AccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(obj, str);
        }

        public int getActions(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getActions(obj);
        }

        public void getBoundsInParent(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.getBoundsInParent(obj, rect);
        }

        public void getBoundsInScreen(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.getBoundsInScreen(obj, rect);
        }

        public Object getChild(Object obj, int i) {
            return AccessibilityNodeInfoCompatIcs.getChild(obj, i);
        }

        public int getChildCount(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getChildCount(obj);
        }

        public CharSequence getClassName(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getClassName(obj);
        }

        public CharSequence getContentDescription(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getContentDescription(obj);
        }

        public CharSequence getPackageName(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getPackageName(obj);
        }

        public Object getParent(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getParent(obj);
        }

        public CharSequence getText(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getText(obj);
        }

        public int getWindowId(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getWindowId(obj);
        }

        public boolean isCheckable(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isCheckable(obj);
        }

        public boolean isChecked(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isChecked(obj);
        }

        public boolean isClickable(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isClickable(obj);
        }

        public boolean isEnabled(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isEnabled(obj);
        }

        public boolean isFocusable(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isFocusable(obj);
        }

        public boolean isFocused(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isFocused(obj);
        }

        public boolean isLongClickable(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isLongClickable(obj);
        }

        public boolean isPassword(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isPassword(obj);
        }

        public boolean isScrollable(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isScrollable(obj);
        }

        public boolean isSelected(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isSelected(obj);
        }

        public Object obtain() {
            return AccessibilityNodeInfoCompatIcs.obtain();
        }

        public Object obtain(View view) {
            return AccessibilityNodeInfoCompatIcs.obtain(view);
        }

        public Object obtain(Object obj) {
            return AccessibilityNodeInfoCompatIcs.obtain(obj);
        }

        public boolean performAction(Object obj, int i) {
            return AccessibilityNodeInfoCompatIcs.performAction(obj, i);
        }

        public void recycle(Object obj) {
            AccessibilityNodeInfoCompatIcs.recycle(obj);
        }

        public void setBoundsInParent(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.setBoundsInParent(obj, rect);
        }

        public void setBoundsInScreen(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.setBoundsInScreen(obj, rect);
        }

        public void setCheckable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setCheckable(obj, z);
        }

        public void setChecked(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setChecked(obj, z);
        }

        public void setClassName(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.setClassName(obj, charSequence);
        }

        public void setClickable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setClickable(obj, z);
        }

        public void setContentDescription(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.setContentDescription(obj, charSequence);
        }

        public void setEnabled(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setEnabled(obj, z);
        }

        public void setFocusable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setFocusable(obj, z);
        }

        public void setFocused(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setFocused(obj, z);
        }

        public void setLongClickable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setLongClickable(obj, z);
        }

        public void setPackageName(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.setPackageName(obj, charSequence);
        }

        public void setParent(Object obj, View view) {
            AccessibilityNodeInfoCompatIcs.setParent(obj, view);
        }

        public void setPassword(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setPassword(obj, z);
        }

        public void setScrollable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setScrollable(obj, z);
        }

        public void setSelected(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setSelected(obj, z);
        }

        public void setSource(Object obj, View view) {
            AccessibilityNodeInfoCompatIcs.setSource(obj, view);
        }

        public void setText(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.setText(obj, charSequence);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoImpl */
    interface AccessibilityNodeInfoImpl {
        void addAction(Object obj, int i);

        void addAction(Object obj, Object obj2);

        void addChild(Object obj, View view);

        void addChild(Object obj, View view, int i);

        boolean canOpenPopup(Object obj);

        List<Object> findAccessibilityNodeInfosByText(Object obj, String str);

        List<Object> findAccessibilityNodeInfosByViewId(Object obj, String str);

        Object findFocus(Object obj, int i);

        Object focusSearch(Object obj, int i);

        int getAccessibilityActionId(Object obj);

        CharSequence getAccessibilityActionLabel(Object obj);

        List<Object> getActionList(Object obj);

        int getActions(Object obj);

        void getBoundsInParent(Object obj, Rect rect);

        void getBoundsInScreen(Object obj, Rect rect);

        Object getChild(Object obj, int i);

        int getChildCount(Object obj);

        CharSequence getClassName(Object obj);

        Object getCollectionInfo(Object obj);

        int getCollectionInfoColumnCount(Object obj);

        int getCollectionInfoRowCount(Object obj);

        int getCollectionItemColumnIndex(Object obj);

        int getCollectionItemColumnSpan(Object obj);

        Object getCollectionItemInfo(Object obj);

        int getCollectionItemRowIndex(Object obj);

        int getCollectionItemRowSpan(Object obj);

        CharSequence getContentDescription(Object obj);

        CharSequence getError(Object obj);

        Bundle getExtras(Object obj);

        int getInputType(Object obj);

        Object getLabelFor(Object obj);

        Object getLabeledBy(Object obj);

        int getLiveRegion(Object obj);

        int getMaxTextLength(Object obj);

        int getMovementGranularities(Object obj);

        CharSequence getPackageName(Object obj);

        Object getParent(Object obj);

        Object getRangeInfo(Object obj);

        CharSequence getText(Object obj);

        int getTextSelectionEnd(Object obj);

        int getTextSelectionStart(Object obj);

        Object getTraversalAfter(Object obj);

        Object getTraversalBefore(Object obj);

        String getViewIdResourceName(Object obj);

        Object getWindow(Object obj);

        int getWindowId(Object obj);

        boolean isAccessibilityFocused(Object obj);

        boolean isCheckable(Object obj);

        boolean isChecked(Object obj);

        boolean isClickable(Object obj);

        boolean isCollectionInfoHierarchical(Object obj);

        boolean isCollectionItemHeading(Object obj);

        boolean isCollectionItemSelected(Object obj);

        boolean isContentInvalid(Object obj);

        boolean isDismissable(Object obj);

        boolean isEditable(Object obj);

        boolean isEnabled(Object obj);

        boolean isFocusable(Object obj);

        boolean isFocused(Object obj);

        boolean isLongClickable(Object obj);

        boolean isMultiLine(Object obj);

        boolean isPassword(Object obj);

        boolean isScrollable(Object obj);

        boolean isSelected(Object obj);

        boolean isVisibleToUser(Object obj);

        Object newAccessibilityAction(int i, CharSequence charSequence);

        Object obtain();

        Object obtain(View view);

        Object obtain(View view, int i);

        Object obtain(Object obj);

        Object obtainCollectionInfo(int i, int i2, boolean z, int i3);

        Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2);

        boolean performAction(Object obj, int i);

        boolean performAction(Object obj, int i, Bundle bundle);

        void recycle(Object obj);

        boolean refresh(Object obj);

        boolean removeAction(Object obj, Object obj2);

        boolean removeChild(Object obj, View view);

        boolean removeChild(Object obj, View view, int i);

        void setAccessibilityFocused(Object obj, boolean z);

        void setBoundsInParent(Object obj, Rect rect);

        void setBoundsInScreen(Object obj, Rect rect);

        void setCanOpenPopup(Object obj, boolean z);

        void setCheckable(Object obj, boolean z);

        void setChecked(Object obj, boolean z);

        void setClassName(Object obj, CharSequence charSequence);

        void setClickable(Object obj, boolean z);

        void setCollectionInfo(Object obj, Object obj2);

        void setCollectionItemInfo(Object obj, Object obj2);

        void setContentDescription(Object obj, CharSequence charSequence);

        void setContentInvalid(Object obj, boolean z);

        void setDismissable(Object obj, boolean z);

        void setEditable(Object obj, boolean z);

        void setEnabled(Object obj, boolean z);

        void setError(Object obj, CharSequence charSequence);

        void setFocusable(Object obj, boolean z);

        void setFocused(Object obj, boolean z);

        void setInputType(Object obj, int i);

        void setLabelFor(Object obj, View view);

        void setLabelFor(Object obj, View view, int i);

        void setLabeledBy(Object obj, View view);

        void setLabeledBy(Object obj, View view, int i);

        void setLiveRegion(Object obj, int i);

        void setLongClickable(Object obj, boolean z);

        void setMaxTextLength(Object obj, int i);

        void setMovementGranularities(Object obj, int i);

        void setMultiLine(Object obj, boolean z);

        void setPackageName(Object obj, CharSequence charSequence);

        void setParent(Object obj, View view);

        void setParent(Object obj, View view, int i);

        void setPassword(Object obj, boolean z);

        void setRangeInfo(Object obj, Object obj2);

        void setScrollable(Object obj, boolean z);

        void setSelected(Object obj, boolean z);

        void setSource(Object obj, View view);

        void setSource(Object obj, View view, int i);

        void setText(Object obj, CharSequence charSequence);

        void setTextSelection(Object obj, int i, int i2);

        void setTraversalAfter(Object obj, View view);

        void setTraversalAfter(Object obj, View view, int i);

        void setTraversalBefore(Object obj, View view);

        void setTraversalBefore(Object obj, View view, int i);

        void setViewIdResourceName(Object obj, String str);

        void setVisibleToUser(Object obj, boolean z);
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanImpl */
    class AccessibilityNodeInfoJellybeanImpl extends AccessibilityNodeInfoIcsImpl {
        AccessibilityNodeInfoJellybeanImpl() {
        }

        public void addChild(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatJellyBean.addChild(obj, view, i);
        }

        public Object findFocus(Object obj, int i) {
            return AccessibilityNodeInfoCompatJellyBean.findFocus(obj, i);
        }

        public Object focusSearch(Object obj, int i) {
            return AccessibilityNodeInfoCompatJellyBean.focusSearch(obj, i);
        }

        public int getMovementGranularities(Object obj) {
            return AccessibilityNodeInfoCompatJellyBean.getMovementGranularities(obj);
        }

        public boolean isAccessibilityFocused(Object obj) {
            return AccessibilityNodeInfoCompatJellyBean.isAccessibilityFocused(obj);
        }

        public boolean isVisibleToUser(Object obj) {
            return AccessibilityNodeInfoCompatJellyBean.isVisibleToUser(obj);
        }

        public Object obtain(View view, int i) {
            return AccessibilityNodeInfoCompatJellyBean.obtain(view, i);
        }

        public boolean performAction(Object obj, int i, Bundle bundle) {
            return AccessibilityNodeInfoCompatJellyBean.performAction(obj, i, bundle);
        }

        public void setAccessibilityFocused(Object obj, boolean z) {
            AccessibilityNodeInfoCompatJellyBean.setAccesibilityFocused(obj, z);
        }

        public void setMovementGranularities(Object obj, int i) {
            AccessibilityNodeInfoCompatJellyBean.setMovementGranularities(obj, i);
        }

        public void setParent(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatJellyBean.setParent(obj, view, i);
        }

        public void setSource(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatJellyBean.setSource(obj, view, i);
        }

        public void setVisibleToUser(Object obj, boolean z) {
            AccessibilityNodeInfoCompatJellyBean.setVisibleToUser(obj, z);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanMr1Impl */
    class AccessibilityNodeInfoJellybeanMr1Impl extends AccessibilityNodeInfoJellybeanImpl {
        AccessibilityNodeInfoJellybeanMr1Impl() {
        }

        public Object getLabelFor(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr1.getLabelFor(obj);
        }

        public Object getLabeledBy(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr1.getLabeledBy(obj);
        }

        public void setLabelFor(Object obj, View view) {
            AccessibilityNodeInfoCompatJellybeanMr1.setLabelFor(obj, view);
        }

        public void setLabelFor(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatJellybeanMr1.setLabelFor(obj, view, i);
        }

        public void setLabeledBy(Object obj, View view) {
            AccessibilityNodeInfoCompatJellybeanMr1.setLabeledBy(obj, view);
        }

        public void setLabeledBy(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatJellybeanMr1.setLabeledBy(obj, view, i);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanMr2Impl */
    class AccessibilityNodeInfoJellybeanMr2Impl extends AccessibilityNodeInfoJellybeanMr1Impl {
        AccessibilityNodeInfoJellybeanMr2Impl() {
        }

        public List<Object> findAccessibilityNodeInfosByViewId(Object obj, String str) {
            return AccessibilityNodeInfoCompatJellybeanMr2.findAccessibilityNodeInfosByViewId(obj, str);
        }

        public int getTextSelectionEnd(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr2.getTextSelectionEnd(obj);
        }

        public int getTextSelectionStart(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr2.getTextSelectionStart(obj);
        }

        public String getViewIdResourceName(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr2.getViewIdResourceName(obj);
        }

        public boolean isEditable(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr2.isEditable(obj);
        }

        public boolean refresh(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr2.refresh(obj);
        }

        public void setEditable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatJellybeanMr2.setEditable(obj, z);
        }

        public void setTextSelection(Object obj, int i, int i2) {
            AccessibilityNodeInfoCompatJellybeanMr2.setTextSelection(obj, i, i2);
        }

        public void setViewIdResourceName(Object obj, String str) {
            AccessibilityNodeInfoCompatJellybeanMr2.setViewIdResourceName(obj, str);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoKitKatImpl */
    class AccessibilityNodeInfoKitKatImpl extends AccessibilityNodeInfoJellybeanMr2Impl {
        AccessibilityNodeInfoKitKatImpl() {
        }

        public boolean canOpenPopup(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.canOpenPopup(obj);
        }

        public Object getCollectionInfo(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.m970b(obj);
        }

        public int getCollectionInfoColumnCount(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionInfo.m973a(obj);
        }

        public int getCollectionInfoRowCount(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionInfo.m974b(obj);
        }

        public int getCollectionItemColumnIndex(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.m976a(obj);
        }

        public int getCollectionItemColumnSpan(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.m977b(obj);
        }

        public Object getCollectionItemInfo(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.m971c(obj);
        }

        public int getCollectionItemRowIndex(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.m978c(obj);
        }

        public int getCollectionItemRowSpan(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.m979d(obj);
        }

        public Bundle getExtras(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.getExtras(obj);
        }

        public int getInputType(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.getInputType(obj);
        }

        public int getLiveRegion(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.m968a(obj);
        }

        public Object getRangeInfo(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.m972d(obj);
        }

        public boolean isCollectionInfoHierarchical(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionInfo.m975c(obj);
        }

        public boolean isCollectionItemHeading(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.m980e(obj);
        }

        public boolean isContentInvalid(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.isContentInvalid(obj);
        }

        public boolean isDismissable(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.isDismissable(obj);
        }

        public boolean isMultiLine(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.isMultiLine(obj);
        }

        public Object obtainCollectionInfo(int i, int i2, boolean z, int i3) {
            return AccessibilityNodeInfoCompatKitKat.obtainCollectionInfo(i, i2, z, i3);
        }

        public Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return AccessibilityNodeInfoCompatKitKat.obtainCollectionItemInfo(i, i2, i3, i4, z);
        }

        public void setCanOpenPopup(Object obj, boolean z) {
            AccessibilityNodeInfoCompatKitKat.setCanOpenPopup(obj, z);
        }

        public void setCollectionInfo(Object obj, Object obj2) {
            AccessibilityNodeInfoCompatKitKat.setCollectionInfo(obj, obj2);
        }

        public void setCollectionItemInfo(Object obj, Object obj2) {
            AccessibilityNodeInfoCompatKitKat.setCollectionItemInfo(obj, obj2);
        }

        public void setContentInvalid(Object obj, boolean z) {
            AccessibilityNodeInfoCompatKitKat.setContentInvalid(obj, z);
        }

        public void setDismissable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatKitKat.setDismissable(obj, z);
        }

        public void setInputType(Object obj, int i) {
            AccessibilityNodeInfoCompatKitKat.setInputType(obj, i);
        }

        public void setLiveRegion(Object obj, int i) {
            AccessibilityNodeInfoCompatKitKat.m969a(obj, i);
        }

        public void setMultiLine(Object obj, boolean z) {
            AccessibilityNodeInfoCompatKitKat.setMultiLine(obj, z);
        }

        public void setRangeInfo(Object obj, Object obj2) {
            AccessibilityNodeInfoCompatKitKat.setRangeInfo(obj, obj2);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoStubImpl */
    class AccessibilityNodeInfoStubImpl implements AccessibilityNodeInfoImpl {
        AccessibilityNodeInfoStubImpl() {
        }

        public void addAction(Object obj, int i) {
        }

        public void addAction(Object obj, Object obj2) {
        }

        public void addChild(Object obj, View view) {
        }

        public void addChild(Object obj, View view, int i) {
        }

        public boolean canOpenPopup(Object obj) {
            return false;
        }

        public List<Object> findAccessibilityNodeInfosByText(Object obj, String str) {
            return Collections.emptyList();
        }

        public List<Object> findAccessibilityNodeInfosByViewId(Object obj, String str) {
            return Collections.emptyList();
        }

        public Object findFocus(Object obj, int i) {
            return null;
        }

        public Object focusSearch(Object obj, int i) {
            return null;
        }

        public int getAccessibilityActionId(Object obj) {
            return 0;
        }

        public CharSequence getAccessibilityActionLabel(Object obj) {
            return null;
        }

        public List<Object> getActionList(Object obj) {
            return null;
        }

        public int getActions(Object obj) {
            return 0;
        }

        public void getBoundsInParent(Object obj, Rect rect) {
        }

        public void getBoundsInScreen(Object obj, Rect rect) {
        }

        public Object getChild(Object obj, int i) {
            return null;
        }

        public int getChildCount(Object obj) {
            return 0;
        }

        public CharSequence getClassName(Object obj) {
            return null;
        }

        public Object getCollectionInfo(Object obj) {
            return null;
        }

        public int getCollectionInfoColumnCount(Object obj) {
            return 0;
        }

        public int getCollectionInfoRowCount(Object obj) {
            return 0;
        }

        public int getCollectionItemColumnIndex(Object obj) {
            return 0;
        }

        public int getCollectionItemColumnSpan(Object obj) {
            return 0;
        }

        public Object getCollectionItemInfo(Object obj) {
            return null;
        }

        public int getCollectionItemRowIndex(Object obj) {
            return 0;
        }

        public int getCollectionItemRowSpan(Object obj) {
            return 0;
        }

        public CharSequence getContentDescription(Object obj) {
            return null;
        }

        public CharSequence getError(Object obj) {
            return null;
        }

        public Bundle getExtras(Object obj) {
            return new Bundle();
        }

        public int getInputType(Object obj) {
            return 0;
        }

        public Object getLabelFor(Object obj) {
            return null;
        }

        public Object getLabeledBy(Object obj) {
            return null;
        }

        public int getLiveRegion(Object obj) {
            return 0;
        }

        public int getMaxTextLength(Object obj) {
            return -1;
        }

        public int getMovementGranularities(Object obj) {
            return 0;
        }

        public CharSequence getPackageName(Object obj) {
            return null;
        }

        public Object getParent(Object obj) {
            return null;
        }

        public Object getRangeInfo(Object obj) {
            return null;
        }

        public CharSequence getText(Object obj) {
            return null;
        }

        public int getTextSelectionEnd(Object obj) {
            return -1;
        }

        public int getTextSelectionStart(Object obj) {
            return -1;
        }

        public Object getTraversalAfter(Object obj) {
            return null;
        }

        public Object getTraversalBefore(Object obj) {
            return null;
        }

        public String getViewIdResourceName(Object obj) {
            return null;
        }

        public Object getWindow(Object obj) {
            return null;
        }

        public int getWindowId(Object obj) {
            return 0;
        }

        public boolean isAccessibilityFocused(Object obj) {
            return false;
        }

        public boolean isCheckable(Object obj) {
            return false;
        }

        public boolean isChecked(Object obj) {
            return false;
        }

        public boolean isClickable(Object obj) {
            return false;
        }

        public boolean isCollectionInfoHierarchical(Object obj) {
            return false;
        }

        public boolean isCollectionItemHeading(Object obj) {
            return false;
        }

        public boolean isCollectionItemSelected(Object obj) {
            return false;
        }

        public boolean isContentInvalid(Object obj) {
            return false;
        }

        public boolean isDismissable(Object obj) {
            return false;
        }

        public boolean isEditable(Object obj) {
            return false;
        }

        public boolean isEnabled(Object obj) {
            return false;
        }

        public boolean isFocusable(Object obj) {
            return false;
        }

        public boolean isFocused(Object obj) {
            return false;
        }

        public boolean isLongClickable(Object obj) {
            return false;
        }

        public boolean isMultiLine(Object obj) {
            return false;
        }

        public boolean isPassword(Object obj) {
            return false;
        }

        public boolean isScrollable(Object obj) {
            return false;
        }

        public boolean isSelected(Object obj) {
            return false;
        }

        public boolean isVisibleToUser(Object obj) {
            return false;
        }

        public Object newAccessibilityAction(int i, CharSequence charSequence) {
            return null;
        }

        public Object obtain() {
            return null;
        }

        public Object obtain(View view) {
            return null;
        }

        public Object obtain(View view, int i) {
            return null;
        }

        public Object obtain(Object obj) {
            return null;
        }

        public Object obtainCollectionInfo(int i, int i2, boolean z, int i3) {
            return null;
        }

        public Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return null;
        }

        public boolean performAction(Object obj, int i) {
            return false;
        }

        public boolean performAction(Object obj, int i, Bundle bundle) {
            return false;
        }

        public void recycle(Object obj) {
        }

        public boolean refresh(Object obj) {
            return false;
        }

        public boolean removeAction(Object obj, Object obj2) {
            return false;
        }

        public boolean removeChild(Object obj, View view) {
            return false;
        }

        public boolean removeChild(Object obj, View view, int i) {
            return false;
        }

        public void setAccessibilityFocused(Object obj, boolean z) {
        }

        public void setBoundsInParent(Object obj, Rect rect) {
        }

        public void setBoundsInScreen(Object obj, Rect rect) {
        }

        public void setCanOpenPopup(Object obj, boolean z) {
        }

        public void setCheckable(Object obj, boolean z) {
        }

        public void setChecked(Object obj, boolean z) {
        }

        public void setClassName(Object obj, CharSequence charSequence) {
        }

        public void setClickable(Object obj, boolean z) {
        }

        public void setCollectionInfo(Object obj, Object obj2) {
        }

        public void setCollectionItemInfo(Object obj, Object obj2) {
        }

        public void setContentDescription(Object obj, CharSequence charSequence) {
        }

        public void setContentInvalid(Object obj, boolean z) {
        }

        public void setDismissable(Object obj, boolean z) {
        }

        public void setEditable(Object obj, boolean z) {
        }

        public void setEnabled(Object obj, boolean z) {
        }

        public void setError(Object obj, CharSequence charSequence) {
        }

        public void setFocusable(Object obj, boolean z) {
        }

        public void setFocused(Object obj, boolean z) {
        }

        public void setInputType(Object obj, int i) {
        }

        public void setLabelFor(Object obj, View view) {
        }

        public void setLabelFor(Object obj, View view, int i) {
        }

        public void setLabeledBy(Object obj, View view) {
        }

        public void setLabeledBy(Object obj, View view, int i) {
        }

        public void setLiveRegion(Object obj, int i) {
        }

        public void setLongClickable(Object obj, boolean z) {
        }

        public void setMaxTextLength(Object obj, int i) {
        }

        public void setMovementGranularities(Object obj, int i) {
        }

        public void setMultiLine(Object obj, boolean z) {
        }

        public void setPackageName(Object obj, CharSequence charSequence) {
        }

        public void setParent(Object obj, View view) {
        }

        public void setParent(Object obj, View view, int i) {
        }

        public void setPassword(Object obj, boolean z) {
        }

        public void setRangeInfo(Object obj, Object obj2) {
        }

        public void setScrollable(Object obj, boolean z) {
        }

        public void setSelected(Object obj, boolean z) {
        }

        public void setSource(Object obj, View view) {
        }

        public void setSource(Object obj, View view, int i) {
        }

        public void setText(Object obj, CharSequence charSequence) {
        }

        public void setTextSelection(Object obj, int i, int i2) {
        }

        public void setTraversalAfter(Object obj, View view) {
        }

        public void setTraversalAfter(Object obj, View view, int i) {
        }

        public void setTraversalBefore(Object obj, View view) {
        }

        public void setTraversalBefore(Object obj, View view, int i) {
        }

        public void setViewIdResourceName(Object obj, String str) {
        }

        public void setVisibleToUser(Object obj, boolean z) {
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat */
    public class CollectionInfoCompat {
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;

        /* renamed from: a */
        final Object f1360a;

        private CollectionInfoCompat(Object obj) {
            this.f1360a = obj;
        }

        public static CollectionInfoCompat obtain(int i, int i2, boolean z, int i3) {
            return new CollectionInfoCompat(AccessibilityNodeInfoCompat.f1357a.obtainCollectionInfo(i, i2, z, i3));
        }

        public int getColumnCount() {
            return AccessibilityNodeInfoCompat.f1357a.getCollectionInfoColumnCount(this.f1360a);
        }

        public int getRowCount() {
            return AccessibilityNodeInfoCompat.f1357a.getCollectionInfoRowCount(this.f1360a);
        }

        public boolean isHierarchical() {
            return AccessibilityNodeInfoCompat.f1357a.isCollectionInfoHierarchical(this.f1360a);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat */
    public class CollectionItemInfoCompat {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Object f1361a;

        private CollectionItemInfoCompat(Object obj) {
            this.f1361a = obj;
        }

        public static CollectionItemInfoCompat obtain(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfoCompat.f1357a.obtainCollectionItemInfo(i, i2, i3, i4, z, z2));
        }

        public int getColumnIndex() {
            return AccessibilityNodeInfoCompat.f1357a.getCollectionItemColumnIndex(this.f1361a);
        }

        public int getColumnSpan() {
            return AccessibilityNodeInfoCompat.f1357a.getCollectionItemColumnSpan(this.f1361a);
        }

        public int getRowIndex() {
            return AccessibilityNodeInfoCompat.f1357a.getCollectionItemRowIndex(this.f1361a);
        }

        public int getRowSpan() {
            return AccessibilityNodeInfoCompat.f1357a.getCollectionItemRowSpan(this.f1361a);
        }

        public boolean isHeading() {
            return AccessibilityNodeInfoCompat.f1357a.isCollectionItemHeading(this.f1361a);
        }

        public boolean isSelected() {
            return AccessibilityNodeInfoCompat.f1357a.isCollectionItemSelected(this.f1361a);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$RangeInfoCompat */
    public class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Object f1362a;

        private RangeInfoCompat(Object obj) {
            this.f1362a = obj;
        }

        public float getCurrent() {
            return AccessibilityNodeInfoCompatKitKat.RangeInfo.m981a(this.f1362a);
        }

        public float getMax() {
            return AccessibilityNodeInfoCompatKitKat.RangeInfo.m982b(this.f1362a);
        }

        public float getMin() {
            return AccessibilityNodeInfoCompatKitKat.RangeInfo.m983c(this.f1362a);
        }

        public int getType() {
            return AccessibilityNodeInfoCompatKitKat.RangeInfo.m984d(this.f1362a);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 22) {
            f1357a = new AccessibilityNodeInfoApi22Impl();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f1357a = new AccessibilityNodeInfoApi21Impl();
        } else if (Build.VERSION.SDK_INT >= 19) {
            f1357a = new AccessibilityNodeInfoKitKatImpl();
        } else if (Build.VERSION.SDK_INT >= 18) {
            f1357a = new AccessibilityNodeInfoJellybeanMr2Impl();
        } else if (Build.VERSION.SDK_INT >= 17) {
            f1357a = new AccessibilityNodeInfoJellybeanMr1Impl();
        } else if (Build.VERSION.SDK_INT >= 16) {
            f1357a = new AccessibilityNodeInfoJellybeanImpl();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f1357a = new AccessibilityNodeInfoIcsImpl();
        } else {
            f1357a = new AccessibilityNodeInfoStubImpl();
        }
    }

    public AccessibilityNodeInfoCompat(Object obj) {
        this.f1358b = obj;
    }

    /* renamed from: a */
    static AccessibilityNodeInfoCompat m958a(Object obj) {
        if (obj != null) {
            return new AccessibilityNodeInfoCompat(obj);
        }
        return null;
    }

    /* renamed from: a */
    private static String m959a(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public static AccessibilityNodeInfoCompat obtain() {
        return m958a(f1357a.obtain());
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return m958a(f1357a.obtain(accessibilityNodeInfoCompat.f1358b));
    }

    public static AccessibilityNodeInfoCompat obtain(View view) {
        return m958a(f1357a.obtain(view));
    }

    public static AccessibilityNodeInfoCompat obtain(View view, int i) {
        return m958a(f1357a.obtain(view, i));
    }

    public void addAction(int i) {
        f1357a.addAction(this.f1358b, i);
    }

    public void addAction(AccessibilityActionCompat accessibilityActionCompat) {
        f1357a.addAction(this.f1358b, accessibilityActionCompat.f1359a);
    }

    public void addChild(View view) {
        f1357a.addChild(this.f1358b, view);
    }

    public void addChild(View view, int i) {
        f1357a.addChild(this.f1358b, view, i);
    }

    public boolean canOpenPopup() {
        return f1357a.canOpenPopup(this.f1358b);
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
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        return this.f1358b == null ? accessibilityNodeInfoCompat.f1358b == null : this.f1358b.equals(accessibilityNodeInfoCompat.f1358b);
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String str) {
        ArrayList arrayList = new ArrayList();
        List<Object> findAccessibilityNodeInfosByText = f1357a.findAccessibilityNodeInfosByText(this.f1358b, str);
        int size = findAccessibilityNodeInfosByText.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new AccessibilityNodeInfoCompat(findAccessibilityNodeInfosByText.get(i)));
        }
        return arrayList;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String str) {
        List<Object> findAccessibilityNodeInfosByViewId = f1357a.findAccessibilityNodeInfosByViewId(this.f1358b, str);
        if (findAccessibilityNodeInfosByViewId == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object accessibilityNodeInfoCompat : findAccessibilityNodeInfosByViewId) {
            arrayList.add(new AccessibilityNodeInfoCompat(accessibilityNodeInfoCompat));
        }
        return arrayList;
    }

    public AccessibilityNodeInfoCompat findFocus(int i) {
        return m958a(f1357a.findFocus(this.f1358b, i));
    }

    public AccessibilityNodeInfoCompat focusSearch(int i) {
        return m958a(f1357a.focusSearch(this.f1358b, i));
    }

    public List<AccessibilityActionCompat> getActionList() {
        List<Object> actionList = f1357a.getActionList(this.f1358b);
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new AccessibilityActionCompat(actionList.get(i)));
        }
        return arrayList;
    }

    public int getActions() {
        return f1357a.getActions(this.f1358b);
    }

    public void getBoundsInParent(Rect rect) {
        f1357a.getBoundsInParent(this.f1358b, rect);
    }

    public void getBoundsInScreen(Rect rect) {
        f1357a.getBoundsInScreen(this.f1358b, rect);
    }

    public AccessibilityNodeInfoCompat getChild(int i) {
        return m958a(f1357a.getChild(this.f1358b, i));
    }

    public int getChildCount() {
        return f1357a.getChildCount(this.f1358b);
    }

    public CharSequence getClassName() {
        return f1357a.getClassName(this.f1358b);
    }

    public CollectionInfoCompat getCollectionInfo() {
        Object collectionInfo = f1357a.getCollectionInfo(this.f1358b);
        if (collectionInfo == null) {
            return null;
        }
        return new CollectionInfoCompat(collectionInfo);
    }

    public CollectionItemInfoCompat getCollectionItemInfo() {
        Object collectionItemInfo = f1357a.getCollectionItemInfo(this.f1358b);
        if (collectionItemInfo == null) {
            return null;
        }
        return new CollectionItemInfoCompat(collectionItemInfo);
    }

    public CharSequence getContentDescription() {
        return f1357a.getContentDescription(this.f1358b);
    }

    public CharSequence getError() {
        return f1357a.getError(this.f1358b);
    }

    public Bundle getExtras() {
        return f1357a.getExtras(this.f1358b);
    }

    public Object getInfo() {
        return this.f1358b;
    }

    public int getInputType() {
        return f1357a.getInputType(this.f1358b);
    }

    public AccessibilityNodeInfoCompat getLabelFor() {
        return m958a(f1357a.getLabelFor(this.f1358b));
    }

    public AccessibilityNodeInfoCompat getLabeledBy() {
        return m958a(f1357a.getLabeledBy(this.f1358b));
    }

    public int getLiveRegion() {
        return f1357a.getLiveRegion(this.f1358b);
    }

    public int getMaxTextLength() {
        return f1357a.getMaxTextLength(this.f1358b);
    }

    public int getMovementGranularities() {
        return f1357a.getMovementGranularities(this.f1358b);
    }

    public CharSequence getPackageName() {
        return f1357a.getPackageName(this.f1358b);
    }

    public AccessibilityNodeInfoCompat getParent() {
        return m958a(f1357a.getParent(this.f1358b));
    }

    public RangeInfoCompat getRangeInfo() {
        Object rangeInfo = f1357a.getRangeInfo(this.f1358b);
        if (rangeInfo == null) {
            return null;
        }
        return new RangeInfoCompat(rangeInfo);
    }

    public CharSequence getText() {
        return f1357a.getText(this.f1358b);
    }

    public int getTextSelectionEnd() {
        return f1357a.getTextSelectionEnd(this.f1358b);
    }

    public int getTextSelectionStart() {
        return f1357a.getTextSelectionStart(this.f1358b);
    }

    public AccessibilityNodeInfoCompat getTraversalAfter() {
        return m958a(f1357a.getTraversalAfter(this.f1358b));
    }

    public AccessibilityNodeInfoCompat getTraversalBefore() {
        return m958a(f1357a.getTraversalBefore(this.f1358b));
    }

    public String getViewIdResourceName() {
        return f1357a.getViewIdResourceName(this.f1358b);
    }

    public AccessibilityWindowInfoCompat getWindow() {
        return AccessibilityWindowInfoCompat.m985a(f1357a.getWindow(this.f1358b));
    }

    public int getWindowId() {
        return f1357a.getWindowId(this.f1358b);
    }

    public int hashCode() {
        if (this.f1358b == null) {
            return 0;
        }
        return this.f1358b.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return f1357a.isAccessibilityFocused(this.f1358b);
    }

    public boolean isCheckable() {
        return f1357a.isCheckable(this.f1358b);
    }

    public boolean isChecked() {
        return f1357a.isChecked(this.f1358b);
    }

    public boolean isClickable() {
        return f1357a.isClickable(this.f1358b);
    }

    public boolean isContentInvalid() {
        return f1357a.isContentInvalid(this.f1358b);
    }

    public boolean isDismissable() {
        return f1357a.isDismissable(this.f1358b);
    }

    public boolean isEditable() {
        return f1357a.isEditable(this.f1358b);
    }

    public boolean isEnabled() {
        return f1357a.isEnabled(this.f1358b);
    }

    public boolean isFocusable() {
        return f1357a.isFocusable(this.f1358b);
    }

    public boolean isFocused() {
        return f1357a.isFocused(this.f1358b);
    }

    public boolean isLongClickable() {
        return f1357a.isLongClickable(this.f1358b);
    }

    public boolean isMultiLine() {
        return f1357a.isMultiLine(this.f1358b);
    }

    public boolean isPassword() {
        return f1357a.isPassword(this.f1358b);
    }

    public boolean isScrollable() {
        return f1357a.isScrollable(this.f1358b);
    }

    public boolean isSelected() {
        return f1357a.isSelected(this.f1358b);
    }

    public boolean isVisibleToUser() {
        return f1357a.isVisibleToUser(this.f1358b);
    }

    public boolean performAction(int i) {
        return f1357a.performAction(this.f1358b, i);
    }

    public boolean performAction(int i, Bundle bundle) {
        return f1357a.performAction(this.f1358b, i, bundle);
    }

    public void recycle() {
        f1357a.recycle(this.f1358b);
    }

    public boolean refresh() {
        return f1357a.refresh(this.f1358b);
    }

    public boolean removeAction(AccessibilityActionCompat accessibilityActionCompat) {
        return f1357a.removeAction(this.f1358b, accessibilityActionCompat.f1359a);
    }

    public boolean removeChild(View view) {
        return f1357a.removeChild(this.f1358b, view);
    }

    public boolean removeChild(View view, int i) {
        return f1357a.removeChild(this.f1358b, view, i);
    }

    public void setAccessibilityFocused(boolean z) {
        f1357a.setAccessibilityFocused(this.f1358b, z);
    }

    public void setBoundsInParent(Rect rect) {
        f1357a.setBoundsInParent(this.f1358b, rect);
    }

    public void setBoundsInScreen(Rect rect) {
        f1357a.setBoundsInScreen(this.f1358b, rect);
    }

    public void setCanOpenPopup(boolean z) {
        f1357a.setCanOpenPopup(this.f1358b, z);
    }

    public void setCheckable(boolean z) {
        f1357a.setCheckable(this.f1358b, z);
    }

    public void setChecked(boolean z) {
        f1357a.setChecked(this.f1358b, z);
    }

    public void setClassName(CharSequence charSequence) {
        f1357a.setClassName(this.f1358b, charSequence);
    }

    public void setClickable(boolean z) {
        f1357a.setClickable(this.f1358b, z);
    }

    public void setCollectionInfo(Object obj) {
        f1357a.setCollectionInfo(this.f1358b, ((CollectionInfoCompat) obj).f1360a);
    }

    public void setCollectionItemInfo(Object obj) {
        f1357a.setCollectionItemInfo(this.f1358b, ((CollectionItemInfoCompat) obj).f1361a);
    }

    public void setContentDescription(CharSequence charSequence) {
        f1357a.setContentDescription(this.f1358b, charSequence);
    }

    public void setContentInvalid(boolean z) {
        f1357a.setContentInvalid(this.f1358b, z);
    }

    public void setDismissable(boolean z) {
        f1357a.setDismissable(this.f1358b, z);
    }

    public void setEditable(boolean z) {
        f1357a.setEditable(this.f1358b, z);
    }

    public void setEnabled(boolean z) {
        f1357a.setEnabled(this.f1358b, z);
    }

    public void setError(CharSequence charSequence) {
        f1357a.setError(this.f1358b, charSequence);
    }

    public void setFocusable(boolean z) {
        f1357a.setFocusable(this.f1358b, z);
    }

    public void setFocused(boolean z) {
        f1357a.setFocused(this.f1358b, z);
    }

    public void setInputType(int i) {
        f1357a.setInputType(this.f1358b, i);
    }

    public void setLabelFor(View view) {
        f1357a.setLabelFor(this.f1358b, view);
    }

    public void setLabelFor(View view, int i) {
        f1357a.setLabelFor(this.f1358b, view, i);
    }

    public void setLabeledBy(View view) {
        f1357a.setLabeledBy(this.f1358b, view);
    }

    public void setLabeledBy(View view, int i) {
        f1357a.setLabeledBy(this.f1358b, view, i);
    }

    public void setLiveRegion(int i) {
        f1357a.setLiveRegion(this.f1358b, i);
    }

    public void setLongClickable(boolean z) {
        f1357a.setLongClickable(this.f1358b, z);
    }

    public void setMaxTextLength(int i) {
        f1357a.setMaxTextLength(this.f1358b, i);
    }

    public void setMovementGranularities(int i) {
        f1357a.setMovementGranularities(this.f1358b, i);
    }

    public void setMultiLine(boolean z) {
        f1357a.setMultiLine(this.f1358b, z);
    }

    public void setPackageName(CharSequence charSequence) {
        f1357a.setPackageName(this.f1358b, charSequence);
    }

    public void setParent(View view) {
        f1357a.setParent(this.f1358b, view);
    }

    public void setParent(View view, int i) {
        f1357a.setParent(this.f1358b, view, i);
    }

    public void setPassword(boolean z) {
        f1357a.setPassword(this.f1358b, z);
    }

    public void setRangeInfo(RangeInfoCompat rangeInfoCompat) {
        f1357a.setRangeInfo(this.f1358b, rangeInfoCompat.f1362a);
    }

    public void setScrollable(boolean z) {
        f1357a.setScrollable(this.f1358b, z);
    }

    public void setSelected(boolean z) {
        f1357a.setSelected(this.f1358b, z);
    }

    public void setSource(View view) {
        f1357a.setSource(this.f1358b, view);
    }

    public void setSource(View view, int i) {
        f1357a.setSource(this.f1358b, view, i);
    }

    public void setText(CharSequence charSequence) {
        f1357a.setText(this.f1358b, charSequence);
    }

    public void setTextSelection(int i, int i2) {
        f1357a.setTextSelection(this.f1358b, i, i2);
    }

    public void setTraversalAfter(View view) {
        f1357a.setTraversalAfter(this.f1358b, view);
    }

    public void setTraversalAfter(View view, int i) {
        f1357a.setTraversalAfter(this.f1358b, view, i);
    }

    public void setTraversalBefore(View view) {
        f1357a.setTraversalBefore(this.f1358b, view);
    }

    public void setTraversalBefore(View view, int i) {
        f1357a.setTraversalBefore(this.f1358b, view, i);
    }

    public void setViewIdResourceName(String str) {
        f1357a.setViewIdResourceName(this.f1358b, str);
    }

    public void setVisibleToUser(boolean z) {
        f1357a.setVisibleToUser(this.f1358b, z);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        getBoundsInParent(rect);
        sb.append("; boundsInParent: " + rect);
        getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ").append(getPackageName());
        sb.append("; className: ").append(getClassName());
        sb.append("; text: ").append(getText());
        sb.append("; contentDescription: ").append(getContentDescription());
        sb.append("; viewId: ").append(getViewIdResourceName());
        sb.append("; checkable: ").append(isCheckable());
        sb.append("; checked: ").append(isChecked());
        sb.append("; focusable: ").append(isFocusable());
        sb.append("; focused: ").append(isFocused());
        sb.append("; selected: ").append(isSelected());
        sb.append("; clickable: ").append(isClickable());
        sb.append("; longClickable: ").append(isLongClickable());
        sb.append("; enabled: ").append(isEnabled());
        sb.append("; password: ").append(isPassword());
        sb.append("; scrollable: " + isScrollable());
        sb.append("; [");
        int actions = getActions();
        while (actions != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(actions);
            actions &= numberOfTrailingZeros ^ -1;
            sb.append(m959a(numberOfTrailingZeros));
            if (actions != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
