package android.support.p003v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p003v7.internal.widget.AdapterViewCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;

/* renamed from: android.support.v7.internal.widget.AbsSpinnerCompat */
abstract class AbsSpinnerCompat extends AdapterViewCompat {
    SpinnerAdapter mAdapter;
    private DataSetObserver mDataSetObserver;
    int mHeightMeasureSpec;
    final RecycleBin mRecycler;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    final Rect mSpinnerPadding;
    private Rect mTouchFrame;
    int mWidthMeasureSpec;

    /* renamed from: android.support.v7.internal.widget.AbsSpinnerCompat$RecycleBin */
    class RecycleBin {
        private final SparseArray mScrapHeap = new SparseArray();

        RecycleBin() {
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            SparseArray sparseArray = this.mScrapHeap;
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                View view = (View) sparseArray.valueAt(i);
                if (view != null) {
                    AbsSpinnerCompat.this.removeDetachedView(view, true);
                }
            }
            sparseArray.clear();
        }

        /* access modifiers changed from: package-private */
        public View get(int i) {
            View view = (View) this.mScrapHeap.get(i);
            if (view != null) {
                this.mScrapHeap.delete(i);
            }
            return view;
        }

        public void put(int i, View view) {
            this.mScrapHeap.put(i, view);
        }
    }

    /* renamed from: android.support.v7.internal.widget.AbsSpinnerCompat$SavedState */
    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int position;
        long selectedId;

        SavedState(Parcel parcel) {
            super(parcel);
            this.selectedId = parcel.readLong();
            this.position = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " position=" + this.position + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.selectedId);
            parcel.writeInt(this.position);
        }
    }

    AbsSpinnerCompat(Context context) {
        super(context);
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mSpinnerPadding = new Rect();
        this.mRecycler = new RecycleBin();
        initAbsSpinner();
    }

    AbsSpinnerCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    AbsSpinnerCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mSpinnerPadding = new Rect();
        this.mRecycler = new RecycleBin();
        initAbsSpinner();
    }

    private void initAbsSpinner() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public SpinnerAdapter getAdapter() {
        return this.mAdapter;
    }

    /* access modifiers changed from: package-private */
    public int getChildHeight(View view) {
        return view.getMeasuredHeight();
    }

    /* access modifiers changed from: package-private */
    public int getChildWidth(View view) {
        return view.getMeasuredWidth();
    }

    public int getCount() {
        return this.mItemCount;
    }

    public View getSelectedView() {
        if (this.mItemCount <= 0 || this.mSelectedPosition < 0) {
            return null;
        }
        return getChildAt(this.mSelectedPosition - this.mFirstPosition);
    }

    /* access modifiers changed from: package-private */
    public abstract void layout(int i, boolean z);

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r10, int r11) {
        /*
            r9 = this;
            r5 = 1
            r4 = 0
            int r6 = android.view.View.MeasureSpec.getMode(r10)
            int r0 = r9.getPaddingLeft()
            int r1 = r9.getPaddingTop()
            int r2 = r9.getPaddingRight()
            int r3 = r9.getPaddingBottom()
            android.graphics.Rect r7 = r9.mSpinnerPadding
            int r8 = r9.mSelectionLeftPadding
            if (r0 <= r8) goto L_0x00cf
        L_0x001c:
            r7.left = r0
            android.graphics.Rect r7 = r9.mSpinnerPadding
            int r0 = r9.mSelectionTopPadding
            if (r1 <= r0) goto L_0x00d3
            r0 = r1
        L_0x0025:
            r7.top = r0
            android.graphics.Rect r1 = r9.mSpinnerPadding
            int r0 = r9.mSelectionRightPadding
            if (r2 <= r0) goto L_0x00d7
            r0 = r2
        L_0x002e:
            r1.right = r0
            android.graphics.Rect r1 = r9.mSpinnerPadding
            int r0 = r9.mSelectionBottomPadding
            if (r3 <= r0) goto L_0x00db
            r0 = r3
        L_0x0037:
            r1.bottom = r0
            boolean r0 = r9.mDataChanged
            if (r0 == 0) goto L_0x0040
            r9.handleDataChanged()
        L_0x0040:
            int r1 = r9.getSelectedItemPosition()
            if (r1 < 0) goto L_0x00df
            android.widget.SpinnerAdapter r0 = r9.mAdapter
            if (r0 == 0) goto L_0x00df
            android.widget.SpinnerAdapter r0 = r9.mAdapter
            int r0 = r0.getCount()
            if (r1 >= r0) goto L_0x00df
            android.support.v7.internal.widget.AbsSpinnerCompat$RecycleBin r0 = r9.mRecycler
            android.view.View r0 = r0.get(r1)
            if (r0 != 0) goto L_0x0061
            android.widget.SpinnerAdapter r0 = r9.mAdapter
            r2 = 0
            android.view.View r0 = r0.getView(r1, r2, r9)
        L_0x0061:
            if (r0 == 0) goto L_0x00df
            android.support.v7.internal.widget.AbsSpinnerCompat$RecycleBin r2 = r9.mRecycler
            r2.put(r1, r0)
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
            if (r1 != 0) goto L_0x0079
            r9.mBlockLayoutRequests = r5
            android.view.ViewGroup$LayoutParams r1 = r9.generateDefaultLayoutParams()
            r0.setLayoutParams(r1)
            r9.mBlockLayoutRequests = r4
        L_0x0079:
            r9.measureChild(r0, r10, r11)
            int r1 = r9.getChildHeight(r0)
            android.graphics.Rect r2 = r9.mSpinnerPadding
            int r2 = r2.top
            int r1 = r1 + r2
            android.graphics.Rect r2 = r9.mSpinnerPadding
            int r2 = r2.bottom
            int r1 = r1 + r2
            int r0 = r9.getChildWidth(r0)
            android.graphics.Rect r2 = r9.mSpinnerPadding
            int r2 = r2.left
            int r0 = r0 + r2
            android.graphics.Rect r2 = r9.mSpinnerPadding
            int r2 = r2.right
            int r0 = r0 + r2
            r2 = r4
        L_0x0099:
            if (r2 == 0) goto L_0x00af
            android.graphics.Rect r1 = r9.mSpinnerPadding
            int r1 = r1.top
            android.graphics.Rect r2 = r9.mSpinnerPadding
            int r2 = r2.bottom
            int r1 = r1 + r2
            if (r6 != 0) goto L_0x00af
            android.graphics.Rect r0 = r9.mSpinnerPadding
            int r0 = r0.left
            android.graphics.Rect r2 = r9.mSpinnerPadding
            int r2 = r2.right
            int r0 = r0 + r2
        L_0x00af:
            int r2 = r9.getSuggestedMinimumHeight()
            int r1 = java.lang.Math.max(r1, r2)
            int r2 = r9.getSuggestedMinimumWidth()
            int r0 = java.lang.Math.max(r0, r2)
            int r1 = android.support.p000v4.view.ViewCompat.resolveSizeAndState(r1, r11, r4)
            int r0 = android.support.p000v4.view.ViewCompat.resolveSizeAndState(r0, r10, r4)
            r9.setMeasuredDimension(r0, r1)
            r9.mHeightMeasureSpec = r11
            r9.mWidthMeasureSpec = r10
            return
        L_0x00cf:
            int r0 = r9.mSelectionLeftPadding
            goto L_0x001c
        L_0x00d3:
            int r0 = r9.mSelectionTopPadding
            goto L_0x0025
        L_0x00d7:
            int r0 = r9.mSelectionRightPadding
            goto L_0x002e
        L_0x00db:
            int r0 = r9.mSelectionBottomPadding
            goto L_0x0037
        L_0x00df:
            r2 = r5
            r0 = r4
            r1 = r4
            goto L_0x0099
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.internal.widget.AbsSpinnerCompat.onMeasure(int, int):void");
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.selectedId >= 0) {
            this.mDataChanged = true;
            this.mNeedSync = true;
            this.mSyncRowId = savedState.selectedId;
            this.mSyncPosition = savedState.position;
            this.mSyncMode = 0;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.selectedId = getSelectedItemId();
        if (savedState.selectedId >= 0) {
            savedState.position = getSelectedItemPosition();
        } else {
            savedState.position = -1;
        }
        return savedState;
    }

    public int pointToPosition(int i, int i2) {
        Rect rect = this.mTouchFrame;
        if (rect == null) {
            this.mTouchFrame = new Rect();
            rect = this.mTouchFrame;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return this.mFirstPosition + childCount;
                }
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void recycleAllViews() {
        int childCount = getChildCount();
        RecycleBin recycleBin = this.mRecycler;
        int i = this.mFirstPosition;
        for (int i2 = 0; i2 < childCount; i2++) {
            recycleBin.put(i + i2, getChildAt(i2));
        }
    }

    public void requestLayout() {
        if (!this.mBlockLayoutRequests) {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void resetList() {
        this.mDataChanged = false;
        this.mNeedSync = false;
        removeAllViewsInLayout();
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        invalidate();
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        int i = -1;
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
            resetList();
        }
        this.mAdapter = spinnerAdapter;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        if (this.mAdapter != null) {
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
            checkFocus();
            this.mDataSetObserver = new AdapterViewCompat.AdapterDataSetObserver();
            this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
            if (this.mItemCount > 0) {
                i = 0;
            }
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            if (this.mItemCount == 0) {
                checkSelectionChanged();
            }
        } else {
            checkFocus();
            resetList();
            checkSelectionChanged();
        }
        requestLayout();
    }

    public void setSelection(int i) {
        setNextSelectedPositionInt(i);
        requestLayout();
        invalidate();
    }

    public void setSelection(int i, boolean z) {
        setSelectionInt(i, z && this.mFirstPosition <= i && i <= (this.mFirstPosition + getChildCount()) + -1);
    }

    /* access modifiers changed from: package-private */
    public void setSelectionInt(int i, boolean z) {
        if (i != this.mOldSelectedPosition) {
            this.mBlockLayoutRequests = true;
            setNextSelectedPositionInt(i);
            layout(i - this.mSelectedPosition, z);
            this.mBlockLayoutRequests = false;
        }
    }
}
