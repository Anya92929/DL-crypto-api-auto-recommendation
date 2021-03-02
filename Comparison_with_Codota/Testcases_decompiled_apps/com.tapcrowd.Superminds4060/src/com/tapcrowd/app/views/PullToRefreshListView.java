package com.tapcrowd.app.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tapcrowd.Superminds4060.C0846R;
import java.lang.reflect.InvocationTargetException;

public class PullToRefreshListView extends ListView implements AbsListView.OnScrollListener {
    private static final int PULL_TO_REFRESH = 2;
    private static final int REFRESHING = 4;
    private static final int RELEASE_TO_REFRESH = 3;
    private static final String TAG = "PullToRefreshListView";
    private static final int TAP_TO_REFRESH = 1;
    private int mCurrentScrollState;
    private RotateAnimation mFlipAnimation;
    private LayoutInflater mInflater;
    private int mLastMotionY;
    private OnRefreshListener mOnRefreshListener;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mRefreshOriginalTopPadding;
    /* access modifiers changed from: private */
    public int mRefreshState;
    private RelativeLayout mRefreshView;
    private int mRefreshViewHeight;
    private ImageView mRefreshViewImage;
    private TextView mRefreshViewLastUpdated;
    private ProgressBar mRefreshViewProgress;
    private TextView mRefreshViewText;
    private RotateAnimation mReverseFlipAnimation;

    public interface OnRefreshListener {
        void onRefresh();
    }

    public PullToRefreshListView(Context context) {
        super(context);
        init(context);
    }

    public PullToRefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PullToRefreshListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        this.mFlipAnimation = new RotateAnimation(BitmapDescriptorFactory.HUE_RED, -180.0f, 1, 0.5f, 1, 0.5f);
        this.mFlipAnimation.setInterpolator(new LinearInterpolator());
        this.mFlipAnimation.setDuration(250);
        this.mFlipAnimation.setFillAfter(true);
        this.mReverseFlipAnimation = new RotateAnimation(-180.0f, BitmapDescriptorFactory.HUE_RED, 1, 0.5f, 1, 0.5f);
        this.mReverseFlipAnimation.setInterpolator(new LinearInterpolator());
        this.mReverseFlipAnimation.setDuration(250);
        this.mReverseFlipAnimation.setFillAfter(true);
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mRefreshView = (RelativeLayout) this.mInflater.inflate(C0846R.layout.pull_to_refresh_header, this, false);
        this.mRefreshViewText = (TextView) this.mRefreshView.findViewById(C0846R.C0847id.pull_to_refresh_text);
        this.mRefreshViewImage = (ImageView) this.mRefreshView.findViewById(C0846R.C0847id.pull_to_refresh_image);
        this.mRefreshViewProgress = (ProgressBar) this.mRefreshView.findViewById(C0846R.C0847id.pull_to_refresh_progress);
        this.mRefreshViewLastUpdated = (TextView) this.mRefreshView.findViewById(C0846R.C0847id.pull_to_refresh_updated_at);
        this.mRefreshViewImage.setMinimumHeight(50);
        this.mRefreshView.setOnClickListener(new OnClickRefreshListener(this, (OnClickRefreshListener) null));
        this.mRefreshOriginalTopPadding = this.mRefreshView.getPaddingTop();
        this.mRefreshState = 1;
        addHeaderView(this.mRefreshView);
        super.setOnScrollListener(this);
        measureView(this.mRefreshView);
        this.mRefreshViewHeight = this.mRefreshView.getMeasuredHeight();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        setSelection(1);
    }

    public void setAdapter(ListAdapter adapter) {
        super.setAdapter(adapter);
        setSelection(1);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener l) {
        this.mOnScrollListener = l;
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.mOnRefreshListener = onRefreshListener;
    }

    public void setLastUpdated(CharSequence lastUpdated) {
        if (lastUpdated != null) {
            this.mRefreshViewLastUpdated.setVisibility(0);
            this.mRefreshViewLastUpdated.setText(lastUpdated);
            return;
        }
        this.mRefreshViewLastUpdated.setVisibility(8);
    }

    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        switch (event.getAction()) {
            case 0:
                this.mLastMotionY = y;
                break;
            case 1:
                if (!isVerticalScrollBarEnabled()) {
                    setVerticalScrollBarEnabled(true);
                }
                if (getFirstVisiblePosition() == 0 && this.mRefreshState != 4) {
                    if ((this.mRefreshView.getBottom() <= this.mRefreshViewHeight && this.mRefreshView.getTop() < 0) || this.mRefreshState != 3) {
                        if (this.mRefreshView.getBottom() < this.mRefreshViewHeight || this.mRefreshView.getTop() < 0) {
                            resetHeader();
                            setSelection(1);
                            break;
                        }
                    } else {
                        this.mRefreshState = 4;
                        prepareForRefresh();
                        onRefresh();
                        break;
                    }
                }
                break;
            case 2:
                applyHeaderPadding(event);
                break;
        }
        return super.onTouchEvent(event);
    }

    private void applyHeaderPadding(MotionEvent ev) {
        int historySize = ev.getHistorySize();
        int pointerCount = 1;
        try {
            pointerCount = ((Integer) MotionEvent.class.getMethod("getPointerCount", new Class[0]).invoke(ev, new Object[0])).intValue();
        } catch (NoSuchMethodException e) {
            pointerCount = 1;
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (IllegalAccessException e3) {
            System.err.println("unexpected " + e3);
        } catch (InvocationTargetException e4) {
            System.err.println("unexpected " + e4);
        }
        for (int h = 0; h < historySize; h++) {
            for (int p = 0; p < pointerCount; p++) {
                if (this.mRefreshState == 3) {
                    if (isVerticalFadingEdgeEnabled()) {
                        setVerticalScrollBarEnabled(false);
                    }
                    int historicalY = 0;
                    Class<MotionEvent> cls = MotionEvent.class;
                    try {
                        historicalY = ((Float) cls.getMethod("getHistoricalY", new Class[]{Integer.TYPE, Integer.TYPE}).invoke(ev, new Object[]{Integer.valueOf(p), Integer.valueOf(h)})).intValue();
                    } catch (NoSuchMethodException e5) {
                        historicalY = (int) ev.getHistoricalY(h);
                    } catch (IllegalArgumentException e6) {
                        throw e6;
                    } catch (IllegalAccessException e7) {
                        System.err.println("unexpected " + e7);
                    } catch (InvocationTargetException e8) {
                        System.err.println("unexpected " + e8);
                    }
                    this.mRefreshView.setPadding(this.mRefreshView.getPaddingLeft(), (int) (((double) ((historicalY - this.mLastMotionY) - this.mRefreshViewHeight)) / 1.7d), this.mRefreshView.getPaddingRight(), this.mRefreshView.getPaddingBottom());
                }
            }
        }
    }

    private void resetHeaderPadding() {
        this.mRefreshView.setPadding(this.mRefreshView.getPaddingLeft(), this.mRefreshOriginalTopPadding, this.mRefreshView.getPaddingRight(), this.mRefreshView.getPaddingBottom());
    }

    private void resetHeader() {
        if (this.mRefreshState != 1) {
            this.mRefreshState = 1;
            resetHeaderPadding();
            this.mRefreshViewImage.setImageResource(C0846R.drawable.ic_pulltorefresh_arrow);
            this.mRefreshViewImage.clearAnimation();
            this.mRefreshViewImage.setVisibility(8);
            this.mRefreshViewProgress.setVisibility(8);
        }
    }

    private void measureView(View child) {
        int childHeightSpec;
        ViewGroup.LayoutParams p = child.getLayoutParams();
        if (p == null) {
            p = new ViewGroup.LayoutParams(-1, -2);
        }
        int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0, p.width);
        int lpHeight = p.height;
        if (lpHeight > 0) {
            childHeightSpec = View.MeasureSpec.makeMeasureSpec(lpHeight, 1073741824);
        } else {
            childHeightSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (this.mCurrentScrollState != 1 || this.mRefreshState == 4) {
            if (this.mCurrentScrollState == 2 && firstVisibleItem == 0 && this.mRefreshState != 4) {
                setSelection(1);
            }
        } else if (firstVisibleItem == 0) {
            this.mRefreshViewImage.setVisibility(0);
            if ((this.mRefreshView.getBottom() > this.mRefreshViewHeight + 20 || this.mRefreshView.getTop() >= 0) && this.mRefreshState != 3) {
                this.mRefreshViewText.setText(C0846R.string.pull_to_refresh_release_label);
                this.mRefreshViewImage.clearAnimation();
                this.mRefreshViewImage.startAnimation(this.mFlipAnimation);
                this.mRefreshState = 3;
            } else if (this.mRefreshView.getBottom() < this.mRefreshViewHeight + 20 && this.mRefreshState != 2) {
                this.mRefreshViewText.setText(C0846R.string.pull_to_refresh_pull_label);
                if (this.mRefreshState != 1) {
                    this.mRefreshViewImage.clearAnimation();
                    this.mRefreshViewImage.startAnimation(this.mReverseFlipAnimation);
                }
                this.mRefreshState = 2;
            }
        } else {
            this.mRefreshViewImage.setVisibility(8);
            resetHeader();
        }
        if (this.mOnScrollListener != null) {
            this.mOnScrollListener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
        }
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
        this.mCurrentScrollState = scrollState;
        if (this.mOnScrollListener != null) {
            this.mOnScrollListener.onScrollStateChanged(view, scrollState);
        }
    }

    public void prepareForRefresh() {
        resetHeaderPadding();
        this.mRefreshViewImage.setVisibility(8);
        this.mRefreshViewImage.setImageDrawable((Drawable) null);
        this.mRefreshViewProgress.setVisibility(0);
        this.mRefreshViewText.setText(C0846R.string.pull_to_refresh_refreshing_label);
        this.mRefreshState = 4;
    }

    public void onRefresh() {
        Log.d(TAG, "onRefresh");
        if (this.mOnRefreshListener != null) {
            this.mOnRefreshListener.onRefresh();
        }
    }

    public void onRefreshComplete(CharSequence lastUpdated) {
        setLastUpdated(lastUpdated);
        onRefreshComplete();
    }

    public void onRefreshComplete() {
        Log.d(TAG, "onRefreshComplete");
        resetHeader();
        if (this.mRefreshView.getBottom() > 0) {
            invalidateViews();
            setSelection(1);
        }
    }

    private class OnClickRefreshListener implements View.OnClickListener {
        private OnClickRefreshListener() {
        }

        /* synthetic */ OnClickRefreshListener(PullToRefreshListView pullToRefreshListView, OnClickRefreshListener onClickRefreshListener) {
            this();
        }

        public void onClick(View v) {
            if (PullToRefreshListView.this.mRefreshState != 4) {
                PullToRefreshListView.this.prepareForRefresh();
                PullToRefreshListView.this.onRefresh();
            }
        }
    }
}
