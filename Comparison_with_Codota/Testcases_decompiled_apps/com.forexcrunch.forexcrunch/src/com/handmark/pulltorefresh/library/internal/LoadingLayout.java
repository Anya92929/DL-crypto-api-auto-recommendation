package com.handmark.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.C0836R;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

@SuppressLint({"ViewConstructor"})
public abstract class LoadingLayout extends FrameLayout implements ILoadingLayout {

    /* renamed from: $SWITCH_TABLE$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode */
    private static /* synthetic */ int[] f1756x57a4d715 = null;

    /* renamed from: $SWITCH_TABLE$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation */
    private static /* synthetic */ int[] f1757x9c6cb41e = null;
    static final Interpolator ANIMATION_INTERPOLATOR = new LinearInterpolator();
    static final String LOG_TAG = "PullToRefresh-LoadingLayout";
    protected final ImageView mHeaderImage;
    protected final ProgressBar mHeaderProgress;
    private final TextView mHeaderText;
    private FrameLayout mInnerLayout;
    protected final PullToRefreshBase.Mode mMode;
    private CharSequence mPullLabel;
    private CharSequence mRefreshingLabel;
    private CharSequence mReleaseLabel;
    protected final PullToRefreshBase.Orientation mScrollDirection;
    private final TextView mSubHeaderText;
    private boolean mUseIntrinsicAnimation;

    /* access modifiers changed from: protected */
    public abstract int getDefaultDrawableResId();

    /* access modifiers changed from: protected */
    public abstract void onLoadingDrawableSet(Drawable drawable);

    /* access modifiers changed from: protected */
    public abstract void onPullImpl(float f);

    /* access modifiers changed from: protected */
    public abstract void pullToRefreshImpl();

    /* access modifiers changed from: protected */
    public abstract void refreshingImpl();

    /* access modifiers changed from: protected */
    public abstract void releaseToRefreshImpl();

    /* access modifiers changed from: protected */
    public abstract void resetImpl();

    /* renamed from: $SWITCH_TABLE$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode */
    static /* synthetic */ int[] m2143x57a4d715() {
        int[] iArr = f1756x57a4d715;
        if (iArr == null) {
            iArr = new int[PullToRefreshBase.Mode.values().length];
            try {
                iArr[PullToRefreshBase.Mode.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PullToRefreshBase.Mode.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PullToRefreshBase.Mode.MANUAL_REFRESH_ONLY.ordinal()] = 5;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            f1756x57a4d715 = iArr;
        }
        return iArr;
    }

    /* renamed from: $SWITCH_TABLE$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation */
    static /* synthetic */ int[] m2144x9c6cb41e() {
        int[] iArr = f1757x9c6cb41e;
        if (iArr == null) {
            iArr = new int[PullToRefreshBase.Orientation.values().length];
            try {
                iArr[PullToRefreshBase.Orientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PullToRefreshBase.Orientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            f1757x9c6cb41e = iArr;
        }
        return iArr;
    }

    public LoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation scrollDirection, TypedArray attrs) {
        super(context);
        ColorStateList colors;
        ColorStateList colors2;
        Drawable background;
        this.mMode = mode;
        this.mScrollDirection = scrollDirection;
        switch (m2144x9c6cb41e()[scrollDirection.ordinal()]) {
            case 2:
                LayoutInflater.from(context).inflate(C0836R.layout.pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(C0836R.layout.pull_to_refresh_header_vertical, this);
                break;
        }
        this.mInnerLayout = (FrameLayout) findViewById(C0836R.C0837id.fl_inner);
        this.mHeaderText = (TextView) this.mInnerLayout.findViewById(C0836R.C0837id.pull_to_refresh_text);
        this.mHeaderProgress = (ProgressBar) this.mInnerLayout.findViewById(C0836R.C0837id.pull_to_refresh_progress);
        this.mSubHeaderText = (TextView) this.mInnerLayout.findViewById(C0836R.C0837id.pull_to_refresh_sub_text);
        this.mHeaderImage = (ImageView) this.mInnerLayout.findViewById(C0836R.C0837id.pull_to_refresh_image);
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) this.mInnerLayout.getLayoutParams();
        switch (m2143x57a4d715()[mode.ordinal()]) {
            case 3:
                lp.gravity = scrollDirection == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
                this.mPullLabel = context.getString(C0836R.string.pull_to_refresh_from_bottom_pull_label);
                this.mRefreshingLabel = context.getString(C0836R.string.pull_to_refresh_from_bottom_refreshing_label);
                this.mReleaseLabel = context.getString(C0836R.string.pull_to_refresh_from_bottom_release_label);
                break;
            default:
                lp.gravity = scrollDirection == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
                this.mPullLabel = context.getString(C0836R.string.pull_to_refresh_pull_label);
                this.mRefreshingLabel = context.getString(C0836R.string.pull_to_refresh_refreshing_label);
                this.mReleaseLabel = context.getString(C0836R.string.pull_to_refresh_release_label);
                break;
        }
        if (attrs.hasValue(1) && (background = attrs.getDrawable(1)) != null) {
            ViewCompat.setBackground(this, background);
        }
        if (attrs.hasValue(10)) {
            TypedValue styleID = new TypedValue();
            attrs.getValue(10, styleID);
            setTextAppearance(styleID.data);
        }
        if (attrs.hasValue(11)) {
            TypedValue styleID2 = new TypedValue();
            attrs.getValue(11, styleID2);
            setSubTextAppearance(styleID2.data);
        }
        if (attrs.hasValue(2) && (colors2 = attrs.getColorStateList(2)) != null) {
            setTextColor(colors2);
        }
        if (attrs.hasValue(3) && (colors = attrs.getColorStateList(3)) != null) {
            setSubTextColor(colors);
        }
        Drawable imageDrawable = attrs.hasValue(6) ? attrs.getDrawable(6) : null;
        switch (m2143x57a4d715()[mode.ordinal()]) {
            case 3:
                if (!attrs.hasValue(8)) {
                    if (attrs.hasValue(18)) {
                        Utils.warnDeprecation("ptrDrawableBottom", "ptrDrawableEnd");
                        imageDrawable = attrs.getDrawable(18);
                        break;
                    }
                } else {
                    imageDrawable = attrs.getDrawable(8);
                    break;
                }
                break;
            default:
                if (!attrs.hasValue(7)) {
                    if (attrs.hasValue(17)) {
                        Utils.warnDeprecation("ptrDrawableTop", "ptrDrawableStart");
                        imageDrawable = attrs.getDrawable(17);
                        break;
                    }
                } else {
                    imageDrawable = attrs.getDrawable(7);
                    break;
                }
                break;
        }
        setLoadingDrawable(imageDrawable == null ? context.getResources().getDrawable(getDefaultDrawableResId()) : imageDrawable);
        reset();
    }

    public final void setHeight(int height) {
        getLayoutParams().height = height;
        requestLayout();
    }

    public final void setWidth(int width) {
        getLayoutParams().width = width;
        requestLayout();
    }

    public final int getContentSize() {
        switch (m2144x9c6cb41e()[this.mScrollDirection.ordinal()]) {
            case 2:
                return this.mInnerLayout.getWidth();
            default:
                return this.mInnerLayout.getHeight();
        }
    }

    public final void hideAllViews() {
        if (this.mHeaderText.getVisibility() == 0) {
            this.mHeaderText.setVisibility(4);
        }
        if (this.mHeaderProgress.getVisibility() == 0) {
            this.mHeaderProgress.setVisibility(4);
        }
        if (this.mHeaderImage.getVisibility() == 0) {
            this.mHeaderImage.setVisibility(4);
        }
        if (this.mSubHeaderText.getVisibility() == 0) {
            this.mSubHeaderText.setVisibility(4);
        }
    }

    public final void onPull(float scaleOfLayout) {
        if (!this.mUseIntrinsicAnimation) {
            onPullImpl(scaleOfLayout);
        }
    }

    public final void pullToRefresh() {
        if (this.mHeaderText != null) {
            this.mHeaderText.setText(this.mPullLabel);
        }
        pullToRefreshImpl();
    }

    public final void refreshing() {
        if (this.mHeaderText != null) {
            this.mHeaderText.setText(this.mRefreshingLabel);
        }
        if (this.mUseIntrinsicAnimation) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            refreshingImpl();
        }
        if (this.mSubHeaderText != null) {
            this.mSubHeaderText.setVisibility(8);
        }
    }

    public final void releaseToRefresh() {
        if (this.mHeaderText != null) {
            this.mHeaderText.setText(this.mReleaseLabel);
        }
        releaseToRefreshImpl();
    }

    public final void reset() {
        if (this.mHeaderText != null) {
            this.mHeaderText.setText(this.mPullLabel);
        }
        this.mHeaderImage.setVisibility(0);
        if (this.mUseIntrinsicAnimation) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
        if (this.mSubHeaderText == null) {
            return;
        }
        if (TextUtils.isEmpty(this.mSubHeaderText.getText())) {
            this.mSubHeaderText.setVisibility(8);
        } else {
            this.mSubHeaderText.setVisibility(0);
        }
    }

    public void setLastUpdatedLabel(CharSequence label) {
        setSubHeaderText(label);
    }

    public final void setLoadingDrawable(Drawable imageDrawable) {
        this.mHeaderImage.setImageDrawable(imageDrawable);
        this.mUseIntrinsicAnimation = imageDrawable instanceof AnimationDrawable;
        onLoadingDrawableSet(imageDrawable);
    }

    public void setPullLabel(CharSequence pullLabel) {
        this.mPullLabel = pullLabel;
    }

    public void setRefreshingLabel(CharSequence refreshingLabel) {
        this.mRefreshingLabel = refreshingLabel;
    }

    public void setReleaseLabel(CharSequence releaseLabel) {
        this.mReleaseLabel = releaseLabel;
    }

    public void setTextTypeface(Typeface tf) {
        this.mHeaderText.setTypeface(tf);
    }

    public final void showInvisibleViews() {
        if (4 == this.mHeaderText.getVisibility()) {
            this.mHeaderText.setVisibility(0);
        }
        if (4 == this.mHeaderProgress.getVisibility()) {
            this.mHeaderProgress.setVisibility(0);
        }
        if (4 == this.mHeaderImage.getVisibility()) {
            this.mHeaderImage.setVisibility(0);
        }
        if (4 == this.mSubHeaderText.getVisibility()) {
            this.mSubHeaderText.setVisibility(0);
        }
    }

    private void setSubHeaderText(CharSequence label) {
        if (this.mSubHeaderText == null) {
            return;
        }
        if (TextUtils.isEmpty(label)) {
            this.mSubHeaderText.setVisibility(8);
            return;
        }
        this.mSubHeaderText.setText(label);
        if (8 == this.mSubHeaderText.getVisibility()) {
            this.mSubHeaderText.setVisibility(0);
        }
    }

    private void setSubTextAppearance(int value) {
        if (this.mSubHeaderText != null) {
            this.mSubHeaderText.setTextAppearance(getContext(), value);
        }
    }

    private void setSubTextColor(ColorStateList color) {
        if (this.mSubHeaderText != null) {
            this.mSubHeaderText.setTextColor(color);
        }
    }

    private void setTextAppearance(int value) {
        if (this.mHeaderText != null) {
            this.mHeaderText.setTextAppearance(getContext(), value);
        }
        if (this.mSubHeaderText != null) {
            this.mSubHeaderText.setTextAppearance(getContext(), value);
        }
    }

    private void setTextColor(ColorStateList color) {
        if (this.mHeaderText != null) {
            this.mHeaderText.setTextColor(color);
        }
        if (this.mSubHeaderText != null) {
            this.mSubHeaderText.setTextColor(color);
        }
    }
}
