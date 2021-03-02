package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.actionbarsherlock.C0051R;
import com.actionbarsherlock.widget.ActivityChooserView;

public class IcsListPopupWindow {
    private static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private ListAdapter mAdapter;
    private Context mContext;
    private View mDropDownAnchorView;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    /* access modifiers changed from: private */
    public DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    /* access modifiers changed from: private */
    public Handler mHandler;
    private final ListSelectorHider mHideSelector;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    /* access modifiers changed from: private */
    public int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    /* access modifiers changed from: private */
    public PopupWindow mPopup;
    private int mPromptPosition;
    private View mPromptView;
    /* access modifiers changed from: private */
    public final ResizePopupRunnable mResizePopupRunnable;
    private final PopupScrollListener mScrollListener;
    private Rect mTempRect;
    private final PopupTouchInterceptor mTouchInterceptor;

    public IcsListPopupWindow(Context context) {
        this(context, (AttributeSet) null, C0051R.attr.listPopupWindowStyle);
    }

    public IcsListPopupWindow(Context context, AttributeSet attrs, int defStyleAttr) {
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mListItemExpandMaximum = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new ResizePopupRunnable(this, (ResizePopupRunnable) null);
        this.mTouchInterceptor = new PopupTouchInterceptor(this, (PopupTouchInterceptor) null);
        this.mScrollListener = new PopupScrollListener(this, (PopupScrollListener) null);
        this.mHideSelector = new ListSelectorHider(this, (ListSelectorHider) null);
        this.mHandler = new Handler();
        this.mTempRect = new Rect();
        this.mContext = context;
        this.mPopup = new PopupWindow(context, attrs, defStyleAttr);
        this.mPopup.setInputMethodMode(1);
    }

    public IcsListPopupWindow(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mListItemExpandMaximum = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new ResizePopupRunnable(this, (ResizePopupRunnable) null);
        this.mTouchInterceptor = new PopupTouchInterceptor(this, (PopupTouchInterceptor) null);
        this.mScrollListener = new PopupScrollListener(this, (PopupScrollListener) null);
        this.mHideSelector = new ListSelectorHider(this, (ListSelectorHider) null);
        this.mHandler = new Handler();
        this.mTempRect = new Rect();
        this.mContext = context;
        if (Build.VERSION.SDK_INT < 11) {
            this.mPopup = new PopupWindow(new ContextThemeWrapper(context, defStyleRes), attrs, defStyleAttr);
        } else {
            this.mPopup = new PopupWindow(context, attrs, defStyleAttr, defStyleRes);
        }
        this.mPopup.setInputMethodMode(1);
    }

    public void setAdapter(ListAdapter adapter) {
        if (this.mObserver == null) {
            this.mObserver = new PopupDataSetObserver(this, (PopupDataSetObserver) null);
        } else if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mObserver);
        }
        this.mAdapter = adapter;
        if (this.mAdapter != null) {
            adapter.registerDataSetObserver(this.mObserver);
        }
        if (this.mDropDownList != null) {
            this.mDropDownList.setAdapter(this.mAdapter);
        }
    }

    public void setPromptPosition(int position) {
        this.mPromptPosition = position;
    }

    public void setModal(boolean modal) {
        this.mModal = true;
        this.mPopup.setFocusable(modal);
    }

    public void setBackgroundDrawable(Drawable d) {
        this.mPopup.setBackgroundDrawable(d);
    }

    public void setAnchorView(View anchor) {
        this.mDropDownAnchorView = anchor;
    }

    public void setHorizontalOffset(int offset) {
        this.mDropDownHorizontalOffset = offset;
    }

    public void setVerticalOffset(int offset) {
        this.mDropDownVerticalOffset = offset;
        this.mDropDownVerticalOffsetSet = true;
    }

    public void setContentWidth(int width) {
        Drawable popupBackground = this.mPopup.getBackground();
        if (popupBackground != null) {
            popupBackground.getPadding(this.mTempRect);
            this.mDropDownWidth = this.mTempRect.left + this.mTempRect.right + width;
            return;
        }
        this.mDropDownWidth = width;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener clickListener) {
        this.mItemClickListener = clickListener;
    }

    public void show() {
        int widthSpec;
        int heightSpec;
        int i = 0;
        int i2 = -1;
        int height = buildDropDown();
        int widthSpec2 = 0;
        int heightSpec2 = 0;
        boolean noInputMethod = isInputMethodNotNeeded();
        if (this.mPopup.isShowing()) {
            if (this.mDropDownWidth == -1) {
                widthSpec = -1;
            } else if (this.mDropDownWidth == -2) {
                widthSpec = this.mDropDownAnchorView.getWidth();
            } else {
                widthSpec = this.mDropDownWidth;
            }
            if (this.mDropDownHeight == -1) {
                if (noInputMethod) {
                    heightSpec = height;
                } else {
                    heightSpec = -1;
                }
                if (noInputMethod) {
                    PopupWindow popupWindow = this.mPopup;
                    if (this.mDropDownWidth != -1) {
                        i2 = 0;
                    }
                    popupWindow.setWindowLayoutMode(i2, 0);
                } else {
                    PopupWindow popupWindow2 = this.mPopup;
                    if (this.mDropDownWidth == -1) {
                        i = -1;
                    }
                    popupWindow2.setWindowLayoutMode(i, -1);
                }
            } else if (this.mDropDownHeight == -2) {
                heightSpec = height;
            } else {
                heightSpec = this.mDropDownHeight;
            }
            this.mPopup.setOutsideTouchable(true);
            this.mPopup.update(this.mDropDownAnchorView, this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, widthSpec, heightSpec);
            return;
        }
        if (this.mDropDownWidth == -1) {
            widthSpec2 = -1;
        } else if (this.mDropDownWidth == -2) {
            this.mPopup.setWidth(this.mDropDownAnchorView.getWidth());
        } else {
            this.mPopup.setWidth(this.mDropDownWidth);
        }
        if (this.mDropDownHeight == -1) {
            heightSpec2 = -1;
        } else if (this.mDropDownHeight == -2) {
            this.mPopup.setHeight(height);
        } else {
            this.mPopup.setHeight(this.mDropDownHeight);
        }
        this.mPopup.setWindowLayoutMode(widthSpec2, heightSpec2);
        this.mPopup.setOutsideTouchable(true);
        this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
        this.mPopup.showAsDropDown(this.mDropDownAnchorView, this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset);
        this.mDropDownList.setSelection(-1);
        if (!this.mModal || this.mDropDownList.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.mModal) {
            this.mHandler.post(this.mHideSelector);
        }
    }

    public void dismiss() {
        this.mPopup.dismiss();
        if (this.mPromptView != null) {
            ViewParent parent = this.mPromptView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mPromptView);
            }
        }
        this.mPopup.setContentView((View) null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks(this.mResizePopupRunnable);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        this.mPopup.setOnDismissListener(listener);
    }

    public void setInputMethodMode(int mode) {
        this.mPopup.setInputMethodMode(mode);
    }

    public void clearListSelection() {
        DropDownListView list = this.mDropDownList;
        if (list != null) {
            list.mListSelectionHidden = true;
            list.requestLayout();
        }
    }

    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    /* access modifiers changed from: private */
    public boolean isInputMethodNotNeeded() {
        return this.mPopup.getInputMethodMode() == 2;
    }

    public ListView getListView() {
        return this.mDropDownList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: com.actionbarsherlock.internal.widget.IcsListPopupWindow$DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: com.actionbarsherlock.internal.widget.IcsListPopupWindow$DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: com.actionbarsherlock.internal.widget.IcsListPopupWindow$DropDownListView} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int buildDropDown() {
        /*
            r21 = this;
            r17 = 0
            r0 = r21
            com.actionbarsherlock.internal.widget.IcsListPopupWindow$DropDownListView r1 = r0.mDropDownList
            if (r1 != 0) goto L_0x0132
            r0 = r21
            android.content.Context r8 = r0.mContext
            com.actionbarsherlock.internal.widget.IcsListPopupWindow$DropDownListView r2 = new com.actionbarsherlock.internal.widget.IcsListPopupWindow$DropDownListView
            r0 = r21
            boolean r1 = r0.mModal
            if (r1 == 0) goto L_0x011f
            r1 = 0
        L_0x0015:
            r2.<init>(r8, r1)
            r0 = r21
            r0.mDropDownList = r2
            r0 = r21
            android.graphics.drawable.Drawable r1 = r0.mDropDownListHighlight
            if (r1 == 0) goto L_0x002d
            r0 = r21
            com.actionbarsherlock.internal.widget.IcsListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r0 = r21
            android.graphics.drawable.Drawable r2 = r0.mDropDownListHighlight
            r1.setSelector(r2)
        L_0x002d:
            r0 = r21
            com.actionbarsherlock.internal.widget.IcsListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r0 = r21
            android.widget.ListAdapter r2 = r0.mAdapter
            r1.setAdapter(r2)
            r0 = r21
            com.actionbarsherlock.internal.widget.IcsListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r0 = r21
            android.widget.AdapterView$OnItemClickListener r2 = r0.mItemClickListener
            r1.setOnItemClickListener(r2)
            r0 = r21
            com.actionbarsherlock.internal.widget.IcsListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r2 = 1
            r1.setFocusable(r2)
            r0 = r21
            com.actionbarsherlock.internal.widget.IcsListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r2 = 1
            r1.setFocusableInTouchMode(r2)
            r0 = r21
            com.actionbarsherlock.internal.widget.IcsListPopupWindow$DropDownListView r1 = r0.mDropDownList
            com.actionbarsherlock.internal.widget.IcsListPopupWindow$1 r2 = new com.actionbarsherlock.internal.widget.IcsListPopupWindow$1
            r0 = r21
            r2.<init>()
            r1.setOnItemSelectedListener(r2)
            r0 = r21
            com.actionbarsherlock.internal.widget.IcsListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r0 = r21
            com.actionbarsherlock.internal.widget.IcsListPopupWindow$PopupScrollListener r2 = r0.mScrollListener
            r1.setOnScrollListener(r2)
            r0 = r21
            android.widget.AdapterView$OnItemSelectedListener r1 = r0.mItemSelectedListener
            if (r1 == 0) goto L_0x007d
            r0 = r21
            com.actionbarsherlock.internal.widget.IcsListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r0 = r21
            android.widget.AdapterView$OnItemSelectedListener r2 = r0.mItemSelectedListener
            r1.setOnItemSelectedListener(r2)
        L_0x007d:
            r0 = r21
            com.actionbarsherlock.internal.widget.IcsListPopupWindow$DropDownListView r9 = r0.mDropDownList
            r0 = r21
            android.view.View r13 = r0.mPromptView
            if (r13 == 0) goto L_0x00c2
            android.widget.LinearLayout r11 = new android.widget.LinearLayout
            r11.<init>(r8)
            r1 = 1
            r11.setOrientation(r1)
            android.widget.LinearLayout$LayoutParams r12 = new android.widget.LinearLayout$LayoutParams
            r1 = -1
            r2 = 0
            r3 = 1065353216(0x3f800000, float:1.0)
            r12.<init>(r1, r2, r3)
            r0 = r21
            int r1 = r0.mPromptPosition
            switch(r1) {
                case 0: goto L_0x012a;
                case 1: goto L_0x0122;
                default: goto L_0x00a0;
            }
        L_0x00a0:
            r0 = r21
            int r1 = r0.mDropDownWidth
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            int r20 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r2)
            r10 = 0
            r0 = r20
            r13.measure(r0, r10)
            android.view.ViewGroup$LayoutParams r12 = r13.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r12 = (android.widget.LinearLayout.LayoutParams) r12
            int r1 = r13.getMeasuredHeight()
            int r2 = r12.topMargin
            int r1 = r1 + r2
            int r2 = r12.bottomMargin
            int r17 = r1 + r2
            r9 = r11
        L_0x00c2:
            r0 = r21
            android.widget.PopupWindow r1 = r0.mPopup
            r1.setContentView(r9)
        L_0x00c9:
            r18 = 0
            r0 = r21
            android.widget.PopupWindow r1 = r0.mPopup
            android.graphics.drawable.Drawable r7 = r1.getBackground()
            if (r7 == 0) goto L_0x00fb
            r0 = r21
            android.graphics.Rect r1 = r0.mTempRect
            r7.getPadding(r1)
            r0 = r21
            android.graphics.Rect r1 = r0.mTempRect
            int r1 = r1.top
            r0 = r21
            android.graphics.Rect r2 = r0.mTempRect
            int r2 = r2.bottom
            int r18 = r1 + r2
            r0 = r21
            boolean r1 = r0.mDropDownVerticalOffsetSet
            if (r1 != 0) goto L_0x00fb
            r0 = r21
            android.graphics.Rect r1 = r0.mTempRect
            int r1 = r1.top
            int r1 = -r1
            r0 = r21
            r0.mDropDownVerticalOffset = r1
        L_0x00fb:
            r0 = r21
            android.widget.PopupWindow r1 = r0.mPopup
            int r1 = r1.getInputMethodMode()
            r2 = 2
            if (r1 != r2) goto L_0x0157
            r14 = 1
        L_0x0107:
            r0 = r21
            android.view.View r1 = r0.mDropDownAnchorView
            r0 = r21
            int r2 = r0.mDropDownVerticalOffset
            r0 = r21
            int r16 = r0.getMaxAvailableHeight(r1, r2, r14)
            r0 = r21
            int r1 = r0.mDropDownHeight
            r2 = -1
            if (r1 != r2) goto L_0x0159
            int r1 = r16 + r18
        L_0x011e:
            return r1
        L_0x011f:
            r1 = 1
            goto L_0x0015
        L_0x0122:
            r11.addView(r9, r12)
            r11.addView(r13)
            goto L_0x00a0
        L_0x012a:
            r11.addView(r13)
            r11.addView(r9, r12)
            goto L_0x00a0
        L_0x0132:
            r0 = r21
            android.widget.PopupWindow r1 = r0.mPopup
            android.view.View r9 = r1.getContentView()
            android.view.ViewGroup r9 = (android.view.ViewGroup) r9
            r0 = r21
            android.view.View r0 = r0.mPromptView
            r19 = r0
            if (r19 == 0) goto L_0x00c9
            android.view.ViewGroup$LayoutParams r12 = r19.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r12 = (android.widget.LinearLayout.LayoutParams) r12
            int r1 = r19.getMeasuredHeight()
            int r2 = r12.topMargin
            int r1 = r1 + r2
            int r2 = r12.bottomMargin
            int r17 = r1 + r2
            goto L_0x00c9
        L_0x0157:
            r14 = 0
            goto L_0x0107
        L_0x0159:
            r2 = 0
            r3 = 0
            r4 = -1
            int r5 = r16 - r17
            r6 = -1
            r1 = r21
            int r15 = r1.measureHeightOfChildren(r2, r3, r4, r5, r6)
            if (r15 <= 0) goto L_0x0169
            int r17 = r17 + r18
        L_0x0169:
            int r1 = r15 + r17
            goto L_0x011e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.actionbarsherlock.internal.widget.IcsListPopupWindow.buildDropDown():int");
    }

    private int getMaxAvailableHeight(View anchor, int yOffset, boolean ignoreBottomDecorations) {
        Rect displayFrame = new Rect();
        anchor.getWindowVisibleDisplayFrame(displayFrame);
        int[] anchorPos = new int[2];
        anchor.getLocationOnScreen(anchorPos);
        int bottomEdge = displayFrame.bottom;
        if (ignoreBottomDecorations) {
            bottomEdge = anchor.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        int returnedHeight = Math.max((bottomEdge - (anchorPos[1] + anchor.getHeight())) - yOffset, (anchorPos[1] - displayFrame.top) + yOffset);
        if (this.mPopup.getBackground() == null) {
            return returnedHeight;
        }
        this.mPopup.getBackground().getPadding(this.mTempRect);
        return returnedHeight - (this.mTempRect.top + this.mTempRect.bottom);
    }

    private int measureHeightOfChildren(int widthMeasureSpec, int startPosition, int endPosition, int maxHeight, int disallowPartialChildPosition) {
        ListAdapter adapter = this.mAdapter;
        if (adapter == null) {
            return this.mDropDownList.getListPaddingTop() + this.mDropDownList.getListPaddingBottom();
        }
        int returnedHeight = this.mDropDownList.getListPaddingTop() + this.mDropDownList.getListPaddingBottom();
        int dividerHeight = (this.mDropDownList.getDividerHeight() <= 0 || this.mDropDownList.getDivider() == null) ? 0 : this.mDropDownList.getDividerHeight();
        int prevHeightWithoutPartialChild = 0;
        if (endPosition == -1) {
            endPosition = adapter.getCount() - 1;
        }
        int i = startPosition;
        while (i <= endPosition) {
            View child = this.mAdapter.getView(i, (View) null, this.mDropDownList);
            if (this.mDropDownList.getCacheColorHint() != 0) {
                child.setDrawingCacheBackgroundColor(this.mDropDownList.getCacheColorHint());
            }
            measureScrapChild(child, i, widthMeasureSpec);
            if (i > 0) {
                returnedHeight += dividerHeight;
            }
            returnedHeight += child.getMeasuredHeight();
            if (returnedHeight < maxHeight) {
                if (disallowPartialChildPosition >= 0 && i >= disallowPartialChildPosition) {
                    prevHeightWithoutPartialChild = returnedHeight;
                }
                i++;
            } else if (disallowPartialChildPosition < 0 || i <= disallowPartialChildPosition || prevHeightWithoutPartialChild <= 0 || returnedHeight == maxHeight) {
                return maxHeight;
            } else {
                return prevHeightWithoutPartialChild;
            }
        }
        return returnedHeight;
    }

    private void measureScrapChild(View child, int position, int widthMeasureSpec) {
        int childHeightSpec;
        AbsListView.LayoutParams p = (AbsListView.LayoutParams) child.getLayoutParams();
        if (p == null) {
            p = new AbsListView.LayoutParams(-1, -2, 0);
            child.setLayoutParams(p);
        }
        int childWidthSpec = ViewGroup.getChildMeasureSpec(widthMeasureSpec, this.mDropDownList.getPaddingLeft() + this.mDropDownList.getPaddingRight(), p.width);
        int lpHeight = p.height;
        if (lpHeight > 0) {
            childHeightSpec = View.MeasureSpec.makeMeasureSpec(lpHeight, 1073741824);
        } else {
            childHeightSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

    private static class DropDownListView extends ListView {
        private boolean mHijackFocus;
        /* access modifiers changed from: private */
        public boolean mListSelectionHidden;

        public DropDownListView(Context context, boolean hijackFocus) {
            super(context, (AttributeSet) null, C0051R.attr.dropDownListViewStyle);
            this.mHijackFocus = hijackFocus;
            setCacheColorHint(0);
        }

        public boolean isInTouchMode() {
            return (this.mHijackFocus && this.mListSelectionHidden) || super.isInTouchMode();
        }

        public boolean hasWindowFocus() {
            return this.mHijackFocus || super.hasWindowFocus();
        }

        public boolean isFocused() {
            return this.mHijackFocus || super.isFocused();
        }

        public boolean hasFocus() {
            return this.mHijackFocus || super.hasFocus();
        }
    }

    private class PopupDataSetObserver extends DataSetObserver {
        private PopupDataSetObserver() {
        }

        /* synthetic */ PopupDataSetObserver(IcsListPopupWindow icsListPopupWindow, PopupDataSetObserver popupDataSetObserver) {
            this();
        }

        public void onChanged() {
            if (IcsListPopupWindow.this.isShowing()) {
                IcsListPopupWindow.this.show();
            }
        }

        public void onInvalidated() {
            IcsListPopupWindow.this.dismiss();
        }
    }

    private class ListSelectorHider implements Runnable {
        private ListSelectorHider() {
        }

        /* synthetic */ ListSelectorHider(IcsListPopupWindow icsListPopupWindow, ListSelectorHider listSelectorHider) {
            this();
        }

        public void run() {
            IcsListPopupWindow.this.clearListSelection();
        }
    }

    private class ResizePopupRunnable implements Runnable {
        private ResizePopupRunnable() {
        }

        /* synthetic */ ResizePopupRunnable(IcsListPopupWindow icsListPopupWindow, ResizePopupRunnable resizePopupRunnable) {
            this();
        }

        public void run() {
            if (IcsListPopupWindow.this.mDropDownList != null && IcsListPopupWindow.this.mDropDownList.getCount() > IcsListPopupWindow.this.mDropDownList.getChildCount() && IcsListPopupWindow.this.mDropDownList.getChildCount() <= IcsListPopupWindow.this.mListItemExpandMaximum) {
                IcsListPopupWindow.this.mPopup.setInputMethodMode(2);
                IcsListPopupWindow.this.show();
            }
        }
    }

    private class PopupTouchInterceptor implements View.OnTouchListener {
        private PopupTouchInterceptor() {
        }

        /* synthetic */ PopupTouchInterceptor(IcsListPopupWindow icsListPopupWindow, PopupTouchInterceptor popupTouchInterceptor) {
            this();
        }

        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            int x = (int) event.getX();
            int y = (int) event.getY();
            if (action == 0 && IcsListPopupWindow.this.mPopup != null && IcsListPopupWindow.this.mPopup.isShowing() && x >= 0 && x < IcsListPopupWindow.this.mPopup.getWidth() && y >= 0 && y < IcsListPopupWindow.this.mPopup.getHeight()) {
                IcsListPopupWindow.this.mHandler.postDelayed(IcsListPopupWindow.this.mResizePopupRunnable, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                IcsListPopupWindow.this.mHandler.removeCallbacks(IcsListPopupWindow.this.mResizePopupRunnable);
                return false;
            }
        }
    }

    private class PopupScrollListener implements AbsListView.OnScrollListener {
        private PopupScrollListener() {
        }

        /* synthetic */ PopupScrollListener(IcsListPopupWindow icsListPopupWindow, PopupScrollListener popupScrollListener) {
            this();
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        }

        public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (scrollState == 1 && !IcsListPopupWindow.this.isInputMethodNotNeeded() && IcsListPopupWindow.this.mPopup.getContentView() != null) {
                IcsListPopupWindow.this.mHandler.removeCallbacks(IcsListPopupWindow.this.mResizePopupRunnable);
                IcsListPopupWindow.this.mResizePopupRunnable.run();
            }
        }
    }
}
