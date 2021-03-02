package android.support.p003v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.p000v4.widget.ExploreByTouchHelper;
import android.support.p003v7.appcompat.C0091R;
import android.support.p003v7.internal.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.Locale;

/* renamed from: android.support.v7.internal.widget.ListPopupWindow */
public class ListPopupWindow {
    private static final boolean DEBUG = false;
    private static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int FILL_PARENT = -1;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible;
    private View mDropDownAnchorView;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    /* access modifiers changed from: private */
    public DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private boolean mForceIgnoreOutsideTouch;
    /* access modifiers changed from: private */
    public Handler mHandler;
    private final ListSelectorHider mHideSelector;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    private int mLayoutDirection;
    int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    /* access modifiers changed from: private */
    public PopupWindow mPopup;
    private int mPromptPosition;
    private View mPromptView;
    /* access modifiers changed from: private */
    public final ResizePopupRunnable mResizePopupRunnable;
    private final PopupScrollListener mScrollListener;
    private Runnable mShowDropDownRunnable;
    private Rect mTempRect;
    private final PopupTouchInterceptor mTouchInterceptor;

    public ListPopupWindow(Context context) {
        this(context, (AttributeSet) null, C0091R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attrs) {
        this(context, attrs, C0091R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attrs, int defStyleAttr) {
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mDropDownAlwaysVisible = false;
        this.mForceIgnoreOutsideTouch = false;
        this.mListItemExpandMaximum = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new ResizePopupRunnable();
        this.mTouchInterceptor = new PopupTouchInterceptor();
        this.mScrollListener = new PopupScrollListener();
        this.mHideSelector = new ListSelectorHider();
        this.mHandler = new Handler();
        this.mTempRect = new Rect();
        this.mContext = context;
        this.mPopup = new PopupWindow(context, attrs, defStyleAttr);
        this.mPopup.setInputMethodMode(1);
        Locale locale = this.mContext.getResources().getConfiguration().locale;
    }

    public void setAdapter(ListAdapter adapter) {
        if (this.mObserver == null) {
            this.mObserver = new PopupDataSetObserver();
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

    public int getPromptPosition() {
        return this.mPromptPosition;
    }

    public void setModal(boolean modal) {
        this.mModal = true;
        this.mPopup.setFocusable(modal);
    }

    public boolean isModal() {
        return this.mModal;
    }

    public void setForceIgnoreOutsideTouch(boolean forceIgnoreOutsideTouch) {
        this.mForceIgnoreOutsideTouch = forceIgnoreOutsideTouch;
    }

    public void setDropDownAlwaysVisible(boolean dropDownAlwaysVisible) {
        this.mDropDownAlwaysVisible = dropDownAlwaysVisible;
    }

    public boolean isDropDownAlwaysVisible() {
        return this.mDropDownAlwaysVisible;
    }

    public void setSoftInputMode(int mode) {
        this.mPopup.setSoftInputMode(mode);
    }

    public int getSoftInputMode() {
        return this.mPopup.getSoftInputMode();
    }

    public void setListSelector(Drawable selector) {
        this.mDropDownListHighlight = selector;
    }

    public Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    public void setBackgroundDrawable(Drawable d) {
        this.mPopup.setBackgroundDrawable(d);
    }

    public void setAnimationStyle(int animationStyle) {
        this.mPopup.setAnimationStyle(animationStyle);
    }

    public int getAnimationStyle() {
        return this.mPopup.getAnimationStyle();
    }

    public View getAnchorView() {
        return this.mDropDownAnchorView;
    }

    public void setAnchorView(View anchor) {
        this.mDropDownAnchorView = anchor;
    }

    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    public void setHorizontalOffset(int offset) {
        this.mDropDownHorizontalOffset = offset;
    }

    public int getVerticalOffset() {
        if (!this.mDropDownVerticalOffsetSet) {
            return 0;
        }
        return this.mDropDownVerticalOffset;
    }

    public void setVerticalOffset(int offset) {
        this.mDropDownVerticalOffset = offset;
        this.mDropDownVerticalOffsetSet = true;
    }

    public int getWidth() {
        return this.mDropDownWidth;
    }

    public void setWidth(int width) {
        this.mDropDownWidth = width;
    }

    public void setContentWidth(int width) {
        Drawable popupBackground = this.mPopup.getBackground();
        if (popupBackground != null) {
            popupBackground.getPadding(this.mTempRect);
            this.mDropDownWidth = this.mTempRect.left + this.mTempRect.right + width;
            return;
        }
        setWidth(width);
    }

    public int getHeight() {
        return this.mDropDownHeight;
    }

    public void setHeight(int height) {
        this.mDropDownHeight = height;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener clickListener) {
        this.mItemClickListener = clickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener selectedListener) {
        this.mItemSelectedListener = selectedListener;
    }

    public void setPromptView(View prompt) {
        boolean showing = isShowing();
        if (showing) {
            removePromptView();
        }
        this.mPromptView = prompt;
        if (showing) {
            show();
        }
    }

    public void postShow() {
        this.mHandler.post(this.mShowDropDownRunnable);
    }

    public void show() {
        int widthSpec;
        int heightSpec;
        boolean z = true;
        boolean z2 = false;
        int i = -1;
        int height = buildDropDown();
        int widthSpec2 = 0;
        int heightSpec2 = 0;
        boolean noInputMethod = isInputMethodNotNeeded();
        if (this.mPopup.isShowing()) {
            if (this.mDropDownWidth == -1) {
                widthSpec = -1;
            } else if (this.mDropDownWidth == -2) {
                widthSpec = getAnchorView().getWidth();
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
                        i = 0;
                    }
                    popupWindow.setWindowLayoutMode(i, 0);
                } else {
                    this.mPopup.setWindowLayoutMode(this.mDropDownWidth == -1 ? -1 : 0, -1);
                }
            } else if (this.mDropDownHeight == -2) {
                heightSpec = height;
            } else {
                heightSpec = this.mDropDownHeight;
            }
            PopupWindow popupWindow2 = this.mPopup;
            if (!this.mForceIgnoreOutsideTouch && !this.mDropDownAlwaysVisible) {
                z2 = true;
            }
            popupWindow2.setOutsideTouchable(z2);
            this.mPopup.update(getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, widthSpec, heightSpec);
            return;
        }
        if (this.mDropDownWidth == -1) {
            widthSpec2 = -1;
        } else if (this.mDropDownWidth == -2) {
            this.mPopup.setWidth(getAnchorView().getWidth());
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
        PopupWindow popupWindow3 = this.mPopup;
        if (this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
            z = false;
        }
        popupWindow3.setOutsideTouchable(z);
        this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
        this.mPopup.showAsDropDown(getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset);
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
        removePromptView();
        this.mPopup.setContentView((View) null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks(this.mResizePopupRunnable);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        this.mPopup.setOnDismissListener(listener);
    }

    private void removePromptView() {
        if (this.mPromptView != null) {
            ViewParent parent = this.mPromptView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mPromptView);
            }
        }
    }

    public void setInputMethodMode(int mode) {
        this.mPopup.setInputMethodMode(mode);
    }

    public int getInputMethodMode() {
        return this.mPopup.getInputMethodMode();
    }

    public void setSelection(int position) {
        DropDownListView list = this.mDropDownList;
        if (isShowing() && list != null) {
            boolean unused = list.mListSelectionHidden = false;
            list.setSelection(position);
            if (list.getChoiceMode() != 0) {
                list.setItemChecked(position, true);
            }
        }
    }

    public void clearListSelection() {
        DropDownListView list = this.mDropDownList;
        if (list != null) {
            boolean unused = list.mListSelectionHidden = true;
            list.requestLayout();
        }
    }

    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public boolean isInputMethodNotNeeded() {
        return this.mPopup.getInputMethodMode() == 2;
    }

    public boolean performItemClick(int position) {
        if (!isShowing()) {
            return false;
        }
        if (this.mItemClickListener != null) {
            DropDownListView list = this.mDropDownList;
            int i = position;
            this.mItemClickListener.onItemClick(list, list.getChildAt(position - list.getFirstVisiblePosition()), i, list.getAdapter().getItemId(position));
        }
        return true;
    }

    public Object getSelectedItem() {
        if (!isShowing()) {
            return null;
        }
        return this.mDropDownList.getSelectedItem();
    }

    public int getSelectedItemPosition() {
        if (!isShowing()) {
            return -1;
        }
        return this.mDropDownList.getSelectedItemPosition();
    }

    public long getSelectedItemId() {
        if (!isShowing()) {
            return Long.MIN_VALUE;
        }
        return this.mDropDownList.getSelectedItemId();
    }

    public View getSelectedView() {
        if (!isShowing()) {
            return null;
        }
        return this.mDropDownList.getSelectedView();
    }

    public ListView getListView() {
        return this.mDropDownList;
    }

    /* access modifiers changed from: package-private */
    public void setListItemExpandMax(int max) {
        this.mListItemExpandMaximum = max;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean below;
        if (isShowing() && keyCode != 62 && (this.mDropDownList.getSelectedItemPosition() >= 0 || !(keyCode == 66 || keyCode == 23))) {
            int curIndex = this.mDropDownList.getSelectedItemPosition();
            if (!this.mPopup.isAboveAnchor()) {
                below = true;
            } else {
                below = false;
            }
            ListAdapter adapter = this.mAdapter;
            int firstItem = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int lastItem = ExploreByTouchHelper.INVALID_ID;
            if (adapter != null) {
                boolean allEnabled = adapter.areAllItemsEnabled();
                firstItem = allEnabled ? 0 : this.mDropDownList.lookForSelectablePosition(0, true);
                if (allEnabled) {
                    lastItem = adapter.getCount() - 1;
                } else {
                    lastItem = this.mDropDownList.lookForSelectablePosition(adapter.getCount() - 1, false);
                }
            }
            if ((!below || keyCode != 19 || curIndex > firstItem) && (below || keyCode != 20 || curIndex < lastItem)) {
                boolean unused = this.mDropDownList.mListSelectionHidden = false;
                if (this.mDropDownList.onKeyDown(keyCode, event)) {
                    this.mPopup.setInputMethodMode(2);
                    this.mDropDownList.requestFocusFromTouch();
                    show();
                    switch (keyCode) {
                        case 19:
                        case FitnessActivities.BOXING /*20*/:
                        case FitnessActivities.CRICKET /*23*/:
                        case FitnessActivities.SKIING_BACK_COUNTRY /*66*/:
                            return true;
                    }
                } else if (!below || keyCode != 20) {
                    if (!below && keyCode == 19 && curIndex == firstItem) {
                        return true;
                    }
                } else if (curIndex == lastItem) {
                    return true;
                }
            } else {
                clearListSelection();
                this.mPopup.setInputMethodMode(1);
                show();
                return true;
            }
        }
        return false;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (!isShowing() || this.mDropDownList.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean consumed = this.mDropDownList.onKeyUp(keyCode, event);
        if (!consumed) {
            return consumed;
        }
        switch (keyCode) {
            case FitnessActivities.CRICKET /*23*/:
            case FitnessActivities.SKIING_BACK_COUNTRY /*66*/:
                dismiss();
                return consumed;
            default:
                return consumed;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: android.support.v7.internal.widget.ListPopupWindow$DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: android.support.v7.internal.widget.ListPopupWindow$DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: android.support.v7.internal.widget.ListPopupWindow$DropDownListView} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int buildDropDown() {
        /*
            r21 = this;
            r17 = 0
            r0 = r21
            android.support.v7.internal.widget.ListPopupWindow$DropDownListView r1 = r0.mDropDownList
            if (r1 != 0) goto L_0x015f
            r0 = r21
            android.content.Context r8 = r0.mContext
            android.support.v7.internal.widget.ListPopupWindow$1 r1 = new android.support.v7.internal.widget.ListPopupWindow$1
            r0 = r21
            r1.<init>()
            r0 = r21
            r0.mShowDropDownRunnable = r1
            android.support.v7.internal.widget.ListPopupWindow$DropDownListView r3 = new android.support.v7.internal.widget.ListPopupWindow$DropDownListView
            r0 = r21
            boolean r1 = r0.mModal
            if (r1 != 0) goto L_0x014c
            r1 = 1
        L_0x0020:
            r3.<init>(r8, r1)
            r0 = r21
            r0.mDropDownList = r3
            r0 = r21
            android.graphics.drawable.Drawable r1 = r0.mDropDownListHighlight
            if (r1 == 0) goto L_0x0038
            r0 = r21
            android.support.v7.internal.widget.ListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r0 = r21
            android.graphics.drawable.Drawable r3 = r0.mDropDownListHighlight
            r1.setSelector(r3)
        L_0x0038:
            r0 = r21
            android.support.v7.internal.widget.ListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r0 = r21
            android.widget.ListAdapter r3 = r0.mAdapter
            r1.setAdapter(r3)
            r0 = r21
            android.support.v7.internal.widget.ListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r0 = r21
            android.widget.AdapterView$OnItemClickListener r3 = r0.mItemClickListener
            r1.setOnItemClickListener(r3)
            r0 = r21
            android.support.v7.internal.widget.ListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r3 = 1
            r1.setFocusable(r3)
            r0 = r21
            android.support.v7.internal.widget.ListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r3 = 1
            r1.setFocusableInTouchMode(r3)
            r0 = r21
            android.support.v7.internal.widget.ListPopupWindow$DropDownListView r1 = r0.mDropDownList
            android.support.v7.internal.widget.ListPopupWindow$2 r3 = new android.support.v7.internal.widget.ListPopupWindow$2
            r0 = r21
            r3.<init>()
            r1.setOnItemSelectedListener(r3)
            r0 = r21
            android.support.v7.internal.widget.ListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r0 = r21
            android.support.v7.internal.widget.ListPopupWindow$PopupScrollListener r3 = r0.mScrollListener
            r1.setOnScrollListener(r3)
            r0 = r21
            android.widget.AdapterView$OnItemSelectedListener r1 = r0.mItemSelectedListener
            if (r1 == 0) goto L_0x0088
            r0 = r21
            android.support.v7.internal.widget.ListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r0 = r21
            android.widget.AdapterView$OnItemSelectedListener r3 = r0.mItemSelectedListener
            r1.setOnItemSelectedListener(r3)
        L_0x0088:
            r0 = r21
            android.support.v7.internal.widget.ListPopupWindow$DropDownListView r9 = r0.mDropDownList
            r0 = r21
            android.view.View r13 = r0.mPromptView
            if (r13 == 0) goto L_0x00e9
            android.widget.LinearLayout r11 = new android.widget.LinearLayout
            r11.<init>(r8)
            r1 = 1
            r11.setOrientation(r1)
            android.widget.LinearLayout$LayoutParams r12 = new android.widget.LinearLayout$LayoutParams
            r1 = -1
            r3 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r12.<init>(r1, r3, r4)
            r0 = r21
            int r1 = r0.mPromptPosition
            switch(r1) {
                case 0: goto L_0x0157;
                case 1: goto L_0x014f;
                default: goto L_0x00ab;
            }
        L_0x00ab:
            java.lang.String r1 = "ListPopupWindow"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Invalid hint position "
            java.lang.StringBuilder r3 = r3.append(r4)
            r0 = r21
            int r4 = r0.mPromptPosition
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r1, r3)
        L_0x00c7:
            r0 = r21
            int r1 = r0.mDropDownWidth
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            int r20 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r3)
            r10 = 0
            r0 = r20
            r13.measure(r0, r10)
            android.view.ViewGroup$LayoutParams r12 = r13.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r12 = (android.widget.LinearLayout.LayoutParams) r12
            int r1 = r13.getMeasuredHeight()
            int r3 = r12.topMargin
            int r1 = r1 + r3
            int r3 = r12.bottomMargin
            int r17 = r1 + r3
            r9 = r11
        L_0x00e9:
            r0 = r21
            android.widget.PopupWindow r1 = r0.mPopup
            r1.setContentView(r9)
        L_0x00f0:
            r18 = 0
            r0 = r21
            android.widget.PopupWindow r1 = r0.mPopup
            android.graphics.drawable.Drawable r7 = r1.getBackground()
            if (r7 == 0) goto L_0x0184
            r0 = r21
            android.graphics.Rect r1 = r0.mTempRect
            r7.getPadding(r1)
            r0 = r21
            android.graphics.Rect r1 = r0.mTempRect
            int r1 = r1.top
            r0 = r21
            android.graphics.Rect r3 = r0.mTempRect
            int r3 = r3.bottom
            int r18 = r1 + r3
            r0 = r21
            boolean r1 = r0.mDropDownVerticalOffsetSet
            if (r1 != 0) goto L_0x0122
            r0 = r21
            android.graphics.Rect r1 = r0.mTempRect
            int r1 = r1.top
            int r1 = -r1
            r0 = r21
            r0.mDropDownVerticalOffset = r1
        L_0x0122:
            r0 = r21
            android.widget.PopupWindow r1 = r0.mPopup
            int r1 = r1.getInputMethodMode()
            r3 = 2
            if (r1 != r3) goto L_0x018c
            r14 = 1
        L_0x012e:
            android.view.View r1 = r21.getAnchorView()
            r0 = r21
            int r3 = r0.mDropDownVerticalOffset
            r0 = r21
            int r16 = r0.getMaxAvailableHeight(r1, r3, r14)
            r0 = r21
            boolean r1 = r0.mDropDownAlwaysVisible
            if (r1 != 0) goto L_0x0149
            r0 = r21
            int r1 = r0.mDropDownHeight
            r3 = -1
            if (r1 != r3) goto L_0x018e
        L_0x0149:
            int r1 = r16 + r18
        L_0x014b:
            return r1
        L_0x014c:
            r1 = 0
            goto L_0x0020
        L_0x014f:
            r11.addView(r9, r12)
            r11.addView(r13)
            goto L_0x00c7
        L_0x0157:
            r11.addView(r13)
            r11.addView(r9, r12)
            goto L_0x00c7
        L_0x015f:
            r0 = r21
            android.widget.PopupWindow r1 = r0.mPopup
            android.view.View r9 = r1.getContentView()
            android.view.ViewGroup r9 = (android.view.ViewGroup) r9
            r0 = r21
            android.view.View r0 = r0.mPromptView
            r19 = r0
            if (r19 == 0) goto L_0x00f0
            android.view.ViewGroup$LayoutParams r12 = r19.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r12 = (android.widget.LinearLayout.LayoutParams) r12
            int r1 = r19.getMeasuredHeight()
            int r3 = r12.topMargin
            int r1 = r1 + r3
            int r3 = r12.bottomMargin
            int r17 = r1 + r3
            goto L_0x00f0
        L_0x0184:
            r0 = r21
            android.graphics.Rect r1 = r0.mTempRect
            r1.setEmpty()
            goto L_0x0122
        L_0x018c:
            r14 = 0
            goto L_0x012e
        L_0x018e:
            r0 = r21
            int r1 = r0.mDropDownWidth
            switch(r1) {
                case -2: goto L_0x01b3;
                case -1: goto L_0x01d6;
                default: goto L_0x0195;
            }
        L_0x0195:
            r0 = r21
            int r1 = r0.mDropDownWidth
            r3 = 1073741824(0x40000000, float:2.0)
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r3)
        L_0x019f:
            r0 = r21
            android.support.v7.internal.widget.ListPopupWindow$DropDownListView r1 = r0.mDropDownList
            r3 = 0
            r4 = -1
            int r5 = r16 - r17
            r6 = -1
            int r15 = r1.measureHeightOfChildrenCompat(r2, r3, r4, r5, r6)
            if (r15 <= 0) goto L_0x01b0
            int r17 = r17 + r18
        L_0x01b0:
            int r1 = r15 + r17
            goto L_0x014b
        L_0x01b3:
            r0 = r21
            android.content.Context r1 = r0.mContext
            android.content.res.Resources r1 = r1.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            int r1 = r1.widthPixels
            r0 = r21
            android.graphics.Rect r3 = r0.mTempRect
            int r3 = r3.left
            r0 = r21
            android.graphics.Rect r4 = r0.mTempRect
            int r4 = r4.right
            int r3 = r3 + r4
            int r1 = r1 - r3
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r3)
            goto L_0x019f
        L_0x01d6:
            r0 = r21
            android.content.Context r1 = r0.mContext
            android.content.res.Resources r1 = r1.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            int r1 = r1.widthPixels
            r0 = r21
            android.graphics.Rect r3 = r0.mTempRect
            int r3 = r3.left
            r0 = r21
            android.graphics.Rect r4 = r0.mTempRect
            int r4 = r4.right
            int r3 = r3 + r4
            int r1 = r1 - r3
            r3 = 1073741824(0x40000000, float:2.0)
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r3)
            goto L_0x019f
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.internal.widget.ListPopupWindow.buildDropDown():int");
    }

    public int getMaxAvailableHeight(View anchor, int yOffset, boolean ignoreBottomDecorations) {
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

    /* renamed from: android.support.v7.internal.widget.ListPopupWindow$DropDownListView */
    private static class DropDownListView extends ListView {
        public static final int INVALID_POSITION = -1;
        static final int NO_POSITION = -1;
        private static final String TAG = "ListPopupWindow.DropDownListView";
        private boolean mHijackFocus;
        /* access modifiers changed from: private */
        public boolean mListSelectionHidden;

        public DropDownListView(Context context, boolean hijackFocus) {
            super(context, (AttributeSet) null, C0091R.attr.dropDownListViewStyle);
            this.mHijackFocus = hijackFocus;
            setCacheColorHint(0);
        }

        /* access modifiers changed from: private */
        public int lookForSelectablePosition(int position, boolean lookDown) {
            int position2;
            ListAdapter adapter = getAdapter();
            if (adapter == null || isInTouchMode()) {
                return -1;
            }
            int count = adapter.getCount();
            if (!getAdapter().areAllItemsEnabled()) {
                if (lookDown) {
                    position2 = Math.max(0, position);
                    while (position2 < count && !adapter.isEnabled(position2)) {
                        position2++;
                    }
                } else {
                    int position3 = Math.min(position, count - 1);
                    while (position2 >= 0 && !adapter.isEnabled(position2)) {
                        position3 = position2 - 1;
                    }
                }
                if (position2 < 0 || position2 >= count) {
                    return -1;
                }
                return position2;
            } else if (position < 0 || position >= count) {
                return -1;
            } else {
                return position;
            }
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

        /* access modifiers changed from: package-private */
        public final int measureHeightOfChildrenCompat(int widthMeasureSpec, int startPosition, int endPosition, int maxHeight, int disallowPartialChildPosition) {
            int heightMeasureSpec;
            int paddingTop = getListPaddingTop();
            int paddingBottom = getListPaddingBottom();
            int listPaddingLeft = getListPaddingLeft();
            int listPaddingRight = getListPaddingRight();
            int reportedDividerHeight = getDividerHeight();
            Drawable divider = getDivider();
            ListAdapter adapter = getAdapter();
            if (adapter == null) {
                return paddingTop + paddingBottom;
            }
            int returnedHeight = paddingTop + paddingBottom;
            int dividerHeight = (reportedDividerHeight <= 0 || divider == null) ? 0 : reportedDividerHeight;
            int prevHeightWithoutPartialChild = 0;
            View child = null;
            int viewType = 0;
            int count = adapter.getCount();
            int i = 0;
            while (i < count) {
                int newType = adapter.getItemViewType(i);
                if (newType != viewType) {
                    child = null;
                    viewType = newType;
                }
                child = adapter.getView(i, child, this);
                ViewGroup.LayoutParams childLp = child.getLayoutParams();
                if (childLp == null || childLp.height <= 0) {
                    heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                } else {
                    heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(childLp.height, 1073741824);
                }
                child.measure(widthMeasureSpec, heightMeasureSpec);
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
    }

    /* renamed from: android.support.v7.internal.widget.ListPopupWindow$PopupDataSetObserver */
    private class PopupDataSetObserver extends DataSetObserver {
        private PopupDataSetObserver() {
        }

        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* renamed from: android.support.v7.internal.widget.ListPopupWindow$ListSelectorHider */
    private class ListSelectorHider implements Runnable {
        private ListSelectorHider() {
        }

        public void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    /* renamed from: android.support.v7.internal.widget.ListPopupWindow$ResizePopupRunnable */
    private class ResizePopupRunnable implements Runnable {
        private ResizePopupRunnable() {
        }

        public void run() {
            if (ListPopupWindow.this.mDropDownList != null && ListPopupWindow.this.mDropDownList.getCount() > ListPopupWindow.this.mDropDownList.getChildCount() && ListPopupWindow.this.mDropDownList.getChildCount() <= ListPopupWindow.this.mListItemExpandMaximum) {
                ListPopupWindow.this.mPopup.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

    /* renamed from: android.support.v7.internal.widget.ListPopupWindow$PopupTouchInterceptor */
    private class PopupTouchInterceptor implements View.OnTouchListener {
        private PopupTouchInterceptor() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            int x = (int) event.getX();
            int y = (int) event.getY();
            if (action == 0 && ListPopupWindow.this.mPopup != null && ListPopupWindow.this.mPopup.isShowing() && x >= 0 && x < ListPopupWindow.this.mPopup.getWidth() && y >= 0 && y < ListPopupWindow.this.mPopup.getHeight()) {
                ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.mResizePopupRunnable, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
                return false;
            }
        }
    }

    /* renamed from: android.support.v7.internal.widget.ListPopupWindow$PopupScrollListener */
    private class PopupScrollListener implements AbsListView.OnScrollListener {
        private PopupScrollListener() {
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        }

        public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (scrollState == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.mPopup.getContentView() != null) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
                ListPopupWindow.this.mResizePopupRunnable.run();
            }
        }
    }
}
