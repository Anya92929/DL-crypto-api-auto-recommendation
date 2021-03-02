package android.support.p003v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;
import android.widget.AdapterView;

/* renamed from: android.support.v7.internal.widget.AdapterViewICS */
abstract class AdapterViewICS<T extends Adapter> extends ViewGroup {
    public static final int INVALID_POSITION = -1;
    public static final long INVALID_ROW_ID = Long.MIN_VALUE;
    static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2;
    static final int ITEM_VIEW_TYPE_IGNORE = -1;
    static final int SYNC_FIRST_POSITION = 1;
    static final int SYNC_MAX_DURATION_MILLIS = 100;
    static final int SYNC_SELECTED_POSITION = 0;
    boolean mBlockLayoutRequests = false;
    boolean mDataChanged;
    private boolean mDesiredFocusableInTouchModeState;
    private boolean mDesiredFocusableState;
    private View mEmptyView;
    @ViewDebug.ExportedProperty(category = "scrolling")
    int mFirstPosition = 0;
    boolean mInLayout = false;
    @ViewDebug.ExportedProperty(category = "list")
    int mItemCount;
    private int mLayoutHeight;
    boolean mNeedSync = false;
    @ViewDebug.ExportedProperty(category = "list")
    int mNextSelectedPosition = -1;
    long mNextSelectedRowId = Long.MIN_VALUE;
    int mOldItemCount;
    int mOldSelectedPosition = -1;
    long mOldSelectedRowId = Long.MIN_VALUE;
    OnItemClickListener mOnItemClickListener;
    OnItemLongClickListener mOnItemLongClickListener;
    OnItemSelectedListener mOnItemSelectedListener;
    @ViewDebug.ExportedProperty(category = "list")
    int mSelectedPosition = -1;
    long mSelectedRowId = Long.MIN_VALUE;
    private AdapterViewICS<T>.SelectionNotifier mSelectionNotifier;
    int mSpecificTop;
    long mSyncHeight;
    int mSyncMode;
    int mSyncPosition;
    long mSyncRowId = Long.MIN_VALUE;

    /* renamed from: android.support.v7.internal.widget.AdapterViewICS$OnItemClickListener */
    public interface OnItemClickListener {
        void onItemClick(AdapterViewICS<?> adapterViewICS, View view, int i, long j);
    }

    /* renamed from: android.support.v7.internal.widget.AdapterViewICS$OnItemLongClickListener */
    public interface OnItemLongClickListener {
        boolean onItemLongClick(AdapterViewICS<?> adapterViewICS, View view, int i, long j);
    }

    /* renamed from: android.support.v7.internal.widget.AdapterViewICS$OnItemSelectedListener */
    public interface OnItemSelectedListener {
        void onItemSelected(AdapterViewICS<?> adapterViewICS, View view, int i, long j);

        void onNothingSelected(AdapterViewICS<?> adapterViewICS);
    }

    public abstract T getAdapter();

    public abstract View getSelectedView();

    public abstract void setAdapter(T t);

    public abstract void setSelection(int i);

    AdapterViewICS(Context context) {
        super(context);
    }

    AdapterViewICS(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    AdapterViewICS(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /* renamed from: android.support.v7.internal.widget.AdapterViewICS$OnItemClickListenerWrapper */
    class OnItemClickListenerWrapper implements AdapterView.OnItemClickListener {
        private final OnItemClickListener mWrappedListener;

        public OnItemClickListenerWrapper(OnItemClickListener listener) {
            this.mWrappedListener = listener;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            this.mWrappedListener.onItemClick(AdapterViewICS.this, view, position, id);
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public boolean performItemClick(View view, int position, long id) {
        if (this.mOnItemClickListener == null) {
            return false;
        }
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        this.mOnItemClickListener.onItemClick(this, view, position, id);
        return true;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.mOnItemLongClickListener = listener;
    }

    public final OnItemLongClickListener getOnItemLongClickListener() {
        return this.mOnItemLongClickListener;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener listener) {
        this.mOnItemSelectedListener = listener;
    }

    public final OnItemSelectedListener getOnItemSelectedListener() {
        return this.mOnItemSelectedListener;
    }

    /* renamed from: android.support.v7.internal.widget.AdapterViewICS$AdapterContextMenuInfo */
    public static class AdapterContextMenuInfo implements ContextMenu.ContextMenuInfo {

        /* renamed from: id */
        public long f6id;
        public int position;
        public View targetView;

        public AdapterContextMenuInfo(View targetView2, int position2, long id) {
            this.targetView = targetView2;
            this.position = position2;
            this.f6id = id;
        }
    }

    public void addView(View child) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    public void addView(View child, int index) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    public void addView(View child, ViewGroup.LayoutParams params) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    public void removeView(View child) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    public void removeViewAt(int index) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.mLayoutHeight = getHeight();
    }

    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        return this.mNextSelectedPosition;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.mNextSelectedRowId;
    }

    public Object getSelectedItem() {
        T adapter = getAdapter();
        int selection = getSelectedItemPosition();
        if (adapter == null || adapter.getCount() <= 0 || selection < 0) {
            return null;
        }
        return adapter.getItem(selection);
    }

    @ViewDebug.CapturedViewProperty
    public int getCount() {
        return this.mItemCount;
    }

    public int getPositionForView(View view) {
        View listItem = view;
        while (true) {
            try {
                View v = (View) listItem.getParent();
                if (v.equals(this)) {
                    break;
                }
                listItem = v;
            } catch (ClassCastException e) {
                return -1;
            }
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).equals(listItem)) {
                return this.mFirstPosition + i;
            }
        }
        return -1;
    }

    public int getFirstVisiblePosition() {
        return this.mFirstPosition;
    }

    public int getLastVisiblePosition() {
        return (this.mFirstPosition + getChildCount()) - 1;
    }

    public void setEmptyView(View emptyView) {
        this.mEmptyView = emptyView;
        T adapter = getAdapter();
        updateEmptyStatus(adapter == null || adapter.isEmpty());
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    /* access modifiers changed from: package-private */
    public boolean isInFilterMode() {
        return false;
    }

    public void setFocusable(boolean focusable) {
        boolean empty;
        boolean z = true;
        T adapter = getAdapter();
        if (adapter == null || adapter.getCount() == 0) {
            empty = true;
        } else {
            empty = false;
        }
        this.mDesiredFocusableState = focusable;
        if (!focusable) {
            this.mDesiredFocusableInTouchModeState = false;
        }
        if (!focusable || (empty && !isInFilterMode())) {
            z = false;
        }
        super.setFocusable(z);
    }

    public void setFocusableInTouchMode(boolean focusable) {
        boolean empty;
        boolean z = true;
        T adapter = getAdapter();
        if (adapter == null || adapter.getCount() == 0) {
            empty = true;
        } else {
            empty = false;
        }
        this.mDesiredFocusableInTouchModeState = focusable;
        if (focusable) {
            this.mDesiredFocusableState = true;
        }
        if (!focusable || (empty && !isInFilterMode())) {
            z = false;
        }
        super.setFocusableInTouchMode(z);
    }

    /* access modifiers changed from: package-private */
    public void checkFocus() {
        boolean empty;
        boolean focusable;
        boolean z;
        boolean z2;
        boolean z3 = false;
        T adapter = getAdapter();
        if (adapter == null || adapter.getCount() == 0) {
            empty = true;
        } else {
            empty = false;
        }
        if (!empty || isInFilterMode()) {
            focusable = true;
        } else {
            focusable = false;
        }
        if (!focusable || !this.mDesiredFocusableInTouchModeState) {
            z = false;
        } else {
            z = true;
        }
        super.setFocusableInTouchMode(z);
        if (!focusable || !this.mDesiredFocusableState) {
            z2 = false;
        } else {
            z2 = true;
        }
        super.setFocusable(z2);
        if (this.mEmptyView != null) {
            if (adapter == null || adapter.isEmpty()) {
                z3 = true;
            }
            updateEmptyStatus(z3);
        }
    }

    private void updateEmptyStatus(boolean empty) {
        if (isInFilterMode()) {
            empty = false;
        }
        if (empty) {
            if (this.mEmptyView != null) {
                this.mEmptyView.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.mDataChanged) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        if (this.mEmptyView != null) {
            this.mEmptyView.setVisibility(8);
        }
        setVisibility(0);
    }

    public Object getItemAtPosition(int position) {
        T adapter = getAdapter();
        if (adapter == null || position < 0) {
            return null;
        }
        return adapter.getItem(position);
    }

    public long getItemIdAtPosition(int position) {
        T adapter = getAdapter();
        if (adapter == null || position < 0) {
            return Long.MIN_VALUE;
        }
        return adapter.getItemId(position);
    }

    public void setOnClickListener(View.OnClickListener l) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dispatchFreezeSelfOnly(container);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dispatchThawSelfOnly(container);
    }

    /* renamed from: android.support.v7.internal.widget.AdapterViewICS$AdapterDataSetObserver */
    class AdapterDataSetObserver extends DataSetObserver {
        private Parcelable mInstanceState = null;

        AdapterDataSetObserver() {
        }

        public void onChanged() {
            AdapterViewICS.this.mDataChanged = true;
            AdapterViewICS.this.mOldItemCount = AdapterViewICS.this.mItemCount;
            AdapterViewICS.this.mItemCount = AdapterViewICS.this.getAdapter().getCount();
            if (!AdapterViewICS.this.getAdapter().hasStableIds() || this.mInstanceState == null || AdapterViewICS.this.mOldItemCount != 0 || AdapterViewICS.this.mItemCount <= 0) {
                AdapterViewICS.this.rememberSyncState();
            } else {
                AdapterViewICS.this.onRestoreInstanceState(this.mInstanceState);
                this.mInstanceState = null;
            }
            AdapterViewICS.this.checkFocus();
            AdapterViewICS.this.requestLayout();
        }

        public void onInvalidated() {
            AdapterViewICS.this.mDataChanged = true;
            if (AdapterViewICS.this.getAdapter().hasStableIds()) {
                this.mInstanceState = AdapterViewICS.this.onSaveInstanceState();
            }
            AdapterViewICS.this.mOldItemCount = AdapterViewICS.this.mItemCount;
            AdapterViewICS.this.mItemCount = 0;
            AdapterViewICS.this.mSelectedPosition = -1;
            AdapterViewICS.this.mSelectedRowId = Long.MIN_VALUE;
            AdapterViewICS.this.mNextSelectedPosition = -1;
            AdapterViewICS.this.mNextSelectedRowId = Long.MIN_VALUE;
            AdapterViewICS.this.mNeedSync = false;
            AdapterViewICS.this.checkFocus();
            AdapterViewICS.this.requestLayout();
        }

        public void clearSavedState() {
            this.mInstanceState = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mSelectionNotifier);
    }

    /* renamed from: android.support.v7.internal.widget.AdapterViewICS$SelectionNotifier */
    private class SelectionNotifier implements Runnable {
        private SelectionNotifier() {
        }

        public void run() {
            if (!AdapterViewICS.this.mDataChanged) {
                AdapterViewICS.this.fireOnSelected();
            } else if (AdapterViewICS.this.getAdapter() != null) {
                AdapterViewICS.this.post(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void selectionChanged() {
        if (this.mOnItemSelectedListener != null) {
            if (this.mInLayout || this.mBlockLayoutRequests) {
                if (this.mSelectionNotifier == null) {
                    this.mSelectionNotifier = new SelectionNotifier();
                }
                post(this.mSelectionNotifier);
            } else {
                fireOnSelected();
            }
        }
        if (this.mSelectedPosition != -1 && isShown() && !isInTouchMode()) {
            sendAccessibilityEvent(4);
        }
    }

    /* access modifiers changed from: private */
    public void fireOnSelected() {
        if (this.mOnItemSelectedListener != null) {
            int selection = getSelectedItemPosition();
            if (selection >= 0) {
                View v = getSelectedView();
                this.mOnItemSelectedListener.onItemSelected(this, v, selection, getAdapter().getItemId(selection));
                return;
            }
            this.mOnItemSelectedListener.onNothingSelected(this);
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        View selectedView = getSelectedView();
        if (selectedView == null || selectedView.getVisibility() != 0 || !selectedView.dispatchPopulateAccessibilityEvent(event)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean canAnimate() {
        return super.canAnimate() && this.mItemCount > 0;
    }

    /* access modifiers changed from: package-private */
    public void handleDataChanged() {
        int count = this.mItemCount;
        boolean found = false;
        if (count > 0) {
            if (this.mNeedSync) {
                this.mNeedSync = false;
                int newPos = findSyncPosition();
                if (newPos >= 0 && lookForSelectablePosition(newPos, true) == newPos) {
                    setNextSelectedPositionInt(newPos);
                    found = true;
                }
            }
            if (!found) {
                int newPos2 = getSelectedItemPosition();
                if (newPos2 >= count) {
                    newPos2 = count - 1;
                }
                if (newPos2 < 0) {
                    newPos2 = 0;
                }
                int selectablePos = lookForSelectablePosition(newPos2, true);
                if (selectablePos < 0) {
                    selectablePos = lookForSelectablePosition(newPos2, false);
                }
                if (selectablePos >= 0) {
                    setNextSelectedPositionInt(selectablePos);
                    checkSelectionChanged();
                    found = true;
                }
            }
        }
        if (!found) {
            this.mSelectedPosition = -1;
            this.mSelectedRowId = Long.MIN_VALUE;
            this.mNextSelectedPosition = -1;
            this.mNextSelectedRowId = Long.MIN_VALUE;
            this.mNeedSync = false;
            checkSelectionChanged();
        }
    }

    /* access modifiers changed from: package-private */
    public void checkSelectionChanged() {
        if (this.mSelectedPosition != this.mOldSelectedPosition || this.mSelectedRowId != this.mOldSelectedRowId) {
            selectionChanged();
            this.mOldSelectedPosition = this.mSelectedPosition;
            this.mOldSelectedRowId = this.mSelectedRowId;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: CFG modification limit reached, blocks count: 139 */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
        r14 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0066, code lost:
        if (r6 == false) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int findSyncPosition() {
        /*
            r19 = this;
            r0 = r19
            int r2 = r0.mItemCount
            if (r2 != 0) goto L_0x0008
            r14 = -1
        L_0x0007:
            return r14
        L_0x0008:
            r0 = r19
            long r8 = r0.mSyncRowId
            r0 = r19
            int r14 = r0.mSyncPosition
            r15 = -9223372036854775808
            int r15 = (r8 > r15 ? 1 : (r8 == r15 ? 0 : -1))
            if (r15 != 0) goto L_0x0018
            r14 = -1
            goto L_0x0007
        L_0x0018:
            r15 = 0
            int r14 = java.lang.Math.max(r15, r14)
            int r15 = r2 + -1
            int r14 = java.lang.Math.min(r15, r14)
            long r15 = android.os.SystemClock.uptimeMillis()
            r17 = 100
            long r3 = r15 + r17
            r5 = r14
            r10 = r14
            r11 = 0
            android.widget.Adapter r1 = r19.getAdapter()
            if (r1 != 0) goto L_0x0040
            r14 = -1
            goto L_0x0007
        L_0x0036:
            if (r6 != 0) goto L_0x003c
            if (r11 == 0) goto L_0x0062
            if (r7 != 0) goto L_0x0062
        L_0x003c:
            int r10 = r10 + 1
            r14 = r10
            r11 = 0
        L_0x0040:
            long r15 = android.os.SystemClock.uptimeMillis()
            int r15 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r15 > 0) goto L_0x005c
            long r12 = r1.getItemId(r14)
            int r15 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r15 == 0) goto L_0x0007
            int r15 = r2 + -1
            if (r10 != r15) goto L_0x005e
            r7 = 1
        L_0x0055:
            if (r5 != 0) goto L_0x0060
            r6 = 1
        L_0x0058:
            if (r7 == 0) goto L_0x0036
            if (r6 == 0) goto L_0x0036
        L_0x005c:
            r14 = -1
            goto L_0x0007
        L_0x005e:
            r7 = 0
            goto L_0x0055
        L_0x0060:
            r6 = 0
            goto L_0x0058
        L_0x0062:
            if (r7 != 0) goto L_0x0068
            if (r11 != 0) goto L_0x0040
            if (r6 != 0) goto L_0x0040
        L_0x0068:
            int r5 = r5 + -1
            r14 = r5
            r11 = 1
            goto L_0x0040
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.internal.widget.AdapterViewICS.findSyncPosition():int");
    }

    /* access modifiers changed from: package-private */
    public int lookForSelectablePosition(int position, boolean lookDown) {
        return position;
    }

    /* access modifiers changed from: package-private */
    public void setSelectedPositionInt(int position) {
        this.mSelectedPosition = position;
        this.mSelectedRowId = getItemIdAtPosition(position);
    }

    /* access modifiers changed from: package-private */
    public void setNextSelectedPositionInt(int position) {
        this.mNextSelectedPosition = position;
        this.mNextSelectedRowId = getItemIdAtPosition(position);
        if (this.mNeedSync && this.mSyncMode == 0 && position >= 0) {
            this.mSyncPosition = position;
            this.mSyncRowId = this.mNextSelectedRowId;
        }
    }

    /* access modifiers changed from: package-private */
    public void rememberSyncState() {
        if (getChildCount() > 0) {
            this.mNeedSync = true;
            this.mSyncHeight = (long) this.mLayoutHeight;
            if (this.mSelectedPosition >= 0) {
                View v = getChildAt(this.mSelectedPosition - this.mFirstPosition);
                this.mSyncRowId = this.mNextSelectedRowId;
                this.mSyncPosition = this.mNextSelectedPosition;
                if (v != null) {
                    this.mSpecificTop = v.getTop();
                }
                this.mSyncMode = 0;
                return;
            }
            View v2 = getChildAt(0);
            T adapter = getAdapter();
            if (this.mFirstPosition < 0 || this.mFirstPosition >= adapter.getCount()) {
                this.mSyncRowId = -1;
            } else {
                this.mSyncRowId = adapter.getItemId(this.mFirstPosition);
            }
            this.mSyncPosition = this.mFirstPosition;
            if (v2 != null) {
                this.mSpecificTop = v2.getTop();
            }
            this.mSyncMode = 1;
        }
    }
}
