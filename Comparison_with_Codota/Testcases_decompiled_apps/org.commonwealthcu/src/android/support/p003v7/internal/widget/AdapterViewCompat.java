package android.support.p003v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;
import android.widget.AdapterView;

/* renamed from: android.support.v7.internal.widget.AdapterViewCompat */
public abstract class AdapterViewCompat extends ViewGroup {
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
    int mFirstPosition = 0;
    boolean mInLayout = false;
    int mItemCount;
    private int mLayoutHeight;
    boolean mNeedSync = false;
    int mNextSelectedPosition = -1;
    long mNextSelectedRowId = Long.MIN_VALUE;
    int mOldItemCount;
    int mOldSelectedPosition = -1;
    long mOldSelectedRowId = Long.MIN_VALUE;
    OnItemClickListener mOnItemClickListener;
    OnItemLongClickListener mOnItemLongClickListener;
    OnItemSelectedListener mOnItemSelectedListener;
    int mSelectedPosition = -1;
    long mSelectedRowId = Long.MIN_VALUE;
    private SelectionNotifier mSelectionNotifier;
    int mSpecificTop;
    long mSyncHeight;
    int mSyncMode;
    int mSyncPosition;
    long mSyncRowId = Long.MIN_VALUE;

    /* renamed from: android.support.v7.internal.widget.AdapterViewCompat$AdapterContextMenuInfo */
    public class AdapterContextMenuInfo implements ContextMenu.ContextMenuInfo {

        /* renamed from: id */
        public long f13id;
        public int position;
        public View targetView;

        public AdapterContextMenuInfo(View view, int i, long j) {
            this.targetView = view;
            this.position = i;
            this.f13id = j;
        }
    }

    /* renamed from: android.support.v7.internal.widget.AdapterViewCompat$AdapterDataSetObserver */
    class AdapterDataSetObserver extends DataSetObserver {
        private Parcelable mInstanceState = null;

        AdapterDataSetObserver() {
        }

        public void clearSavedState() {
            this.mInstanceState = null;
        }

        public void onChanged() {
            AdapterViewCompat.this.mDataChanged = true;
            AdapterViewCompat.this.mOldItemCount = AdapterViewCompat.this.mItemCount;
            AdapterViewCompat.this.mItemCount = AdapterViewCompat.this.getAdapter().getCount();
            if (!AdapterViewCompat.this.getAdapter().hasStableIds() || this.mInstanceState == null || AdapterViewCompat.this.mOldItemCount != 0 || AdapterViewCompat.this.mItemCount <= 0) {
                AdapterViewCompat.this.rememberSyncState();
            } else {
                AdapterViewCompat.this.onRestoreInstanceState(this.mInstanceState);
                this.mInstanceState = null;
            }
            AdapterViewCompat.this.checkFocus();
            AdapterViewCompat.this.requestLayout();
        }

        public void onInvalidated() {
            AdapterViewCompat.this.mDataChanged = true;
            if (AdapterViewCompat.this.getAdapter().hasStableIds()) {
                this.mInstanceState = AdapterViewCompat.this.onSaveInstanceState();
            }
            AdapterViewCompat.this.mOldItemCount = AdapterViewCompat.this.mItemCount;
            AdapterViewCompat.this.mItemCount = 0;
            AdapterViewCompat.this.mSelectedPosition = -1;
            AdapterViewCompat.this.mSelectedRowId = Long.MIN_VALUE;
            AdapterViewCompat.this.mNextSelectedPosition = -1;
            AdapterViewCompat.this.mNextSelectedRowId = Long.MIN_VALUE;
            AdapterViewCompat.this.mNeedSync = false;
            AdapterViewCompat.this.checkFocus();
            AdapterViewCompat.this.requestLayout();
        }
    }

    /* renamed from: android.support.v7.internal.widget.AdapterViewCompat$OnItemClickListener */
    public interface OnItemClickListener {
        void onItemClick(AdapterViewCompat adapterViewCompat, View view, int i, long j);
    }

    /* renamed from: android.support.v7.internal.widget.AdapterViewCompat$OnItemClickListenerWrapper */
    class OnItemClickListenerWrapper implements AdapterView.OnItemClickListener {
        private final OnItemClickListener mWrappedListener;

        public OnItemClickListenerWrapper(OnItemClickListener onItemClickListener) {
            this.mWrappedListener = onItemClickListener;
        }

        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            this.mWrappedListener.onItemClick(AdapterViewCompat.this, view, i, j);
        }
    }

    /* renamed from: android.support.v7.internal.widget.AdapterViewCompat$OnItemLongClickListener */
    public interface OnItemLongClickListener {
        boolean onItemLongClick(AdapterViewCompat adapterViewCompat, View view, int i, long j);
    }

    /* renamed from: android.support.v7.internal.widget.AdapterViewCompat$OnItemSelectedListener */
    public interface OnItemSelectedListener {
        void onItemSelected(AdapterViewCompat adapterViewCompat, View view, int i, long j);

        void onNothingSelected(AdapterViewCompat adapterViewCompat);
    }

    /* renamed from: android.support.v7.internal.widget.AdapterViewCompat$SelectionNotifier */
    class SelectionNotifier implements Runnable {
        private SelectionNotifier() {
        }

        public void run() {
            if (!AdapterViewCompat.this.mDataChanged) {
                AdapterViewCompat.this.fireOnSelected();
            } else if (AdapterViewCompat.this.getAdapter() != null) {
                AdapterViewCompat.this.post(this);
            }
        }
    }

    AdapterViewCompat(Context context) {
        super(context);
    }

    AdapterViewCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    AdapterViewCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: private */
    public void fireOnSelected() {
        if (this.mOnItemSelectedListener != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                View selectedView = getSelectedView();
                this.mOnItemSelectedListener.onItemSelected(this, selectedView, selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.mOnItemSelectedListener.onNothingSelected(this);
        }
    }

    private void updateEmptyStatus(boolean z) {
        if (isInFilterMode()) {
            z = false;
        }
        if (z) {
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

    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    public void addView(View view, int i) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    /* access modifiers changed from: protected */
    public boolean canAnimate() {
        return super.canAnimate() && this.mItemCount > 0;
    }

    /* access modifiers changed from: package-private */
    public void checkFocus() {
        boolean z = false;
        Adapter adapter = getAdapter();
        boolean z2 = !(adapter == null || adapter.getCount() == 0) || isInFilterMode();
        super.setFocusableInTouchMode(z2 && this.mDesiredFocusableInTouchModeState);
        super.setFocusable(z2 && this.mDesiredFocusableState);
        if (this.mEmptyView != null) {
            if (adapter == null || adapter.isEmpty()) {
                z = true;
            }
            updateEmptyStatus(z);
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

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View selectedView = getSelectedView();
        return selectedView != null && selectedView.getVisibility() == 0 && selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: CFG modification limit reached, blocks count: 140 */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005f, code lost:
        if (r4 == false) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0066, code lost:
        r3 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int findSyncPosition() {
        /*
            r12 = this;
            int r6 = r12.mItemCount
            if (r6 != 0) goto L_0x0006
            r3 = -1
        L_0x0005:
            return r3
        L_0x0006:
            long r8 = r12.mSyncRowId
            int r0 = r12.mSyncPosition
            r2 = -9223372036854775808
            int r1 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x0012
            r3 = -1
            goto L_0x0005
        L_0x0012:
            r1 = 0
            int r0 = java.lang.Math.max(r1, r0)
            int r1 = r6 + -1
            int r1 = java.lang.Math.min(r1, r0)
            long r2 = android.os.SystemClock.uptimeMillis()
            r4 = 100
            long r10 = r2 + r4
            r0 = 0
            android.widget.Adapter r7 = r12.getAdapter()
            if (r7 != 0) goto L_0x0068
            r3 = -1
            goto L_0x0005
        L_0x002e:
            int r4 = r6 + -1
            if (r1 != r4) goto L_0x0056
            r4 = 1
            r5 = r4
        L_0x0034:
            if (r2 != 0) goto L_0x0059
            r4 = 1
        L_0x0037:
            if (r5 == 0) goto L_0x003b
            if (r4 != 0) goto L_0x0066
        L_0x003b:
            if (r4 != 0) goto L_0x0041
            if (r0 == 0) goto L_0x005b
            if (r5 != 0) goto L_0x005b
        L_0x0041:
            int r1 = r1 + 1
            r0 = 0
            r3 = r1
        L_0x0045:
            long r4 = android.os.SystemClock.uptimeMillis()
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 > 0) goto L_0x0066
            long r4 = r7.getItemId(r3)
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x002e
            goto L_0x0005
        L_0x0056:
            r4 = 0
            r5 = r4
            goto L_0x0034
        L_0x0059:
            r4 = 0
            goto L_0x0037
        L_0x005b:
            if (r5 != 0) goto L_0x0061
            if (r0 != 0) goto L_0x0045
            if (r4 != 0) goto L_0x0045
        L_0x0061:
            int r2 = r2 + -1
            r0 = 1
            r3 = r2
            goto L_0x0045
        L_0x0066:
            r3 = -1
            goto L_0x0005
        L_0x0068:
            r2 = r1
            r3 = r1
            goto L_0x0045
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.internal.widget.AdapterViewCompat.findSyncPosition():int");
    }

    public abstract Adapter getAdapter();

    public int getCount() {
        return this.mItemCount;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public int getFirstVisiblePosition() {
        return this.mFirstPosition;
    }

    public Object getItemAtPosition(int i) {
        Adapter adapter = getAdapter();
        if (adapter == null || i < 0) {
            return null;
        }
        return adapter.getItem(i);
    }

    public long getItemIdAtPosition(int i) {
        Adapter adapter = getAdapter();
        if (adapter == null || i < 0) {
            return Long.MIN_VALUE;
        }
        return adapter.getItemId(i);
    }

    public int getLastVisiblePosition() {
        return (this.mFirstPosition + getChildCount()) - 1;
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public final OnItemLongClickListener getOnItemLongClickListener() {
        return this.mOnItemLongClickListener;
    }

    public final OnItemSelectedListener getOnItemSelectedListener() {
        return this.mOnItemSelectedListener;
    }

    public int getPositionForView(View view) {
        while (true) {
            try {
                View view2 = (View) view.getParent();
                if (view2.equals(this)) {
                    break;
                }
                view = view2;
            } catch (ClassCastException e) {
                return -1;
            }
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).equals(view)) {
                return i + this.mFirstPosition;
            }
        }
        return -1;
    }

    public Object getSelectedItem() {
        Adapter adapter = getAdapter();
        int selectedItemPosition = getSelectedItemPosition();
        if (adapter == null || adapter.getCount() <= 0 || selectedItemPosition < 0) {
            return null;
        }
        return adapter.getItem(selectedItemPosition);
    }

    public long getSelectedItemId() {
        return this.mNextSelectedRowId;
    }

    public int getSelectedItemPosition() {
        return this.mNextSelectedPosition;
    }

    public abstract View getSelectedView();

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleDataChanged() {
        /*
            r8 = this;
            r6 = -9223372036854775808
            r5 = -1
            r2 = 1
            r1 = 0
            int r4 = r8.mItemCount
            if (r4 <= 0) goto L_0x0055
            boolean r0 = r8.mNeedSync
            if (r0 == 0) goto L_0x0053
            r8.mNeedSync = r1
            int r0 = r8.findSyncPosition()
            if (r0 < 0) goto L_0x0053
            int r3 = r8.lookForSelectablePosition(r0, r2)
            if (r3 != r0) goto L_0x0053
            r8.setNextSelectedPositionInt(r0)
            r3 = r2
        L_0x001f:
            if (r3 != 0) goto L_0x004f
            int r0 = r8.getSelectedItemPosition()
            if (r0 < r4) goto L_0x0029
            int r0 = r4 + -1
        L_0x0029:
            if (r0 >= 0) goto L_0x002c
            r0 = r1
        L_0x002c:
            int r4 = r8.lookForSelectablePosition(r0, r2)
            if (r4 >= 0) goto L_0x0051
            int r0 = r8.lookForSelectablePosition(r0, r1)
        L_0x0036:
            if (r0 < 0) goto L_0x004f
            r8.setNextSelectedPositionInt(r0)
            r8.checkSelectionChanged()
            r0 = r2
        L_0x003f:
            if (r0 != 0) goto L_0x004e
            r8.mSelectedPosition = r5
            r8.mSelectedRowId = r6
            r8.mNextSelectedPosition = r5
            r8.mNextSelectedRowId = r6
            r8.mNeedSync = r1
            r8.checkSelectionChanged()
        L_0x004e:
            return
        L_0x004f:
            r0 = r3
            goto L_0x003f
        L_0x0051:
            r0 = r4
            goto L_0x0036
        L_0x0053:
            r3 = r1
            goto L_0x001f
        L_0x0055:
            r0 = r1
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.internal.widget.AdapterViewCompat.handleDataChanged():void");
    }

    /* access modifiers changed from: package-private */
    public boolean isInFilterMode() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public int lookForSelectablePosition(int i, boolean z) {
        return i;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mSelectionNotifier);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mLayoutHeight = getHeight();
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.mOnItemClickListener == null) {
            return false;
        }
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        this.mOnItemClickListener.onItemClick(this, view, i, j);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void rememberSyncState() {
        if (getChildCount() > 0) {
            this.mNeedSync = true;
            this.mSyncHeight = (long) this.mLayoutHeight;
            if (this.mSelectedPosition >= 0) {
                View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
                this.mSyncRowId = this.mNextSelectedRowId;
                this.mSyncPosition = this.mNextSelectedPosition;
                if (childAt != null) {
                    this.mSpecificTop = childAt.getTop();
                }
                this.mSyncMode = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            Adapter adapter = getAdapter();
            if (this.mFirstPosition < 0 || this.mFirstPosition >= adapter.getCount()) {
                this.mSyncRowId = -1;
            } else {
                this.mSyncRowId = adapter.getItemId(this.mFirstPosition);
            }
            this.mSyncPosition = this.mFirstPosition;
            if (childAt2 != null) {
                this.mSpecificTop = childAt2.getTop();
            }
            this.mSyncMode = 1;
        }
    }

    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    public void removeViewAt(int i) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
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

    public abstract void setAdapter(Adapter adapter);

    public void setEmptyView(View view) {
        this.mEmptyView = view;
        Adapter adapter = getAdapter();
        updateEmptyStatus(adapter == null || adapter.isEmpty());
    }

    public void setFocusable(boolean z) {
        boolean z2 = true;
        Adapter adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.mDesiredFocusableState = z;
        if (!z) {
            this.mDesiredFocusableInTouchModeState = false;
        }
        if (!z || (z3 && !isInFilterMode())) {
            z2 = false;
        }
        super.setFocusable(z2);
    }

    public void setFocusableInTouchMode(boolean z) {
        boolean z2 = true;
        Adapter adapter = getAdapter();
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.mDesiredFocusableInTouchModeState = z;
        if (z) {
            this.mDesiredFocusableState = true;
        }
        if (!z || (z3 && !isInFilterMode())) {
            z2 = false;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* access modifiers changed from: package-private */
    public void setNextSelectedPositionInt(int i) {
        this.mNextSelectedPosition = i;
        this.mNextSelectedRowId = getItemIdAtPosition(i);
        if (this.mNeedSync && this.mSyncMode == 0 && i >= 0) {
            this.mSyncPosition = i;
            this.mSyncRowId = this.mNextSelectedRowId;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.mOnItemLongClickListener = onItemLongClickListener;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.mOnItemSelectedListener = onItemSelectedListener;
    }

    /* access modifiers changed from: package-private */
    public void setSelectedPositionInt(int i) {
        this.mSelectedPosition = i;
        this.mSelectedRowId = getItemIdAtPosition(i);
    }

    public abstract void setSelection(int i);
}
