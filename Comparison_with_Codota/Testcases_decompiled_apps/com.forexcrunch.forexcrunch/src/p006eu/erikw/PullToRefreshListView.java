package p006eu.erikw;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: eu.erikw.PullToRefreshListView */
public class PullToRefreshListView extends ListView {
    private static /* synthetic */ int[] $SWITCH_TABLE$eu$erikw$PullToRefreshListView$State = null;
    private static final int BOUNCE_ANIMATION_DELAY = 100;
    private static final int BOUNCE_ANIMATION_DURATION = 700;
    private static final float BOUNCE_OVERSHOOT_TENSION = 1.4f;
    private static final float PULL_RESISTANCE = 1.7f;
    private static final int ROTATE_ARROW_ANIMATION_DURATION = 250;
    /* access modifiers changed from: private */
    public static int measuredHeaderHeight;
    private final int IDLE_DISTANCE = 5;
    /* access modifiers changed from: private */
    public boolean bounceBackHeader;
    private RotateAnimation flipAnimation;
    /* access modifiers changed from: private */
    public boolean hasResetHeader;
    /* access modifiers changed from: private */
    public RelativeLayout header;
    /* access modifiers changed from: private */
    public LinearLayout headerContainer;
    private int headerPadding;
    private ImageView image;
    private long lastUpdated = -1;
    private SimpleDateFormat lastUpdatedDateFormat = new SimpleDateFormat("dd/MM HH:mm");
    private String lastUpdatedText;
    private TextView lastUpdatedTextView;
    private boolean lockScrollWhileRefreshing;
    private float mScrollStartY;
    /* access modifiers changed from: private */
    public AdapterView.OnItemClickListener onItemClickListener;
    /* access modifiers changed from: private */
    public AdapterView.OnItemLongClickListener onItemLongClickListener;
    private OnRefreshListener onRefreshListener;
    private float previousY;
    private String pullToRefreshText;
    private String refreshingText;
    private String releaseToRefreshText;
    private RotateAnimation reverseFlipAnimation;
    /* access modifiers changed from: private */
    public boolean scrollbarEnabled;
    private boolean showLastUpdatedText;
    private ProgressBar spinner;
    /* access modifiers changed from: private */
    public State state;
    private TextView text;

    /* renamed from: eu.erikw.PullToRefreshListView$OnRefreshListener */
    public interface OnRefreshListener {
        void onRefresh();
    }

    /* renamed from: eu.erikw.PullToRefreshListView$State */
    private enum State {
        PULL_TO_REFRESH,
        RELEASE_TO_REFRESH,
        REFRESHING
    }

    static /* synthetic */ int[] $SWITCH_TABLE$eu$erikw$PullToRefreshListView$State() {
        int[] iArr = $SWITCH_TABLE$eu$erikw$PullToRefreshListView$State;
        if (iArr == null) {
            iArr = new int[State.values().length];
            try {
                iArr[State.PULL_TO_REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[State.REFRESHING.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[State.RELEASE_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$eu$erikw$PullToRefreshListView$State = iArr;
        }
        return iArr;
    }

    public PullToRefreshListView(Context context) {
        super(context);
        init();
    }

    public PullToRefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PullToRefreshListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener2) {
        this.onItemClickListener = onItemClickListener2;
    }

    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener2) {
        this.onItemLongClickListener = onItemLongClickListener2;
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener2) {
        this.onRefreshListener = onRefreshListener2;
    }

    public boolean isRefreshing() {
        return this.state == State.REFRESHING;
    }

    public void setLockScrollWhileRefreshing(boolean lockScrollWhileRefreshing2) {
        this.lockScrollWhileRefreshing = lockScrollWhileRefreshing2;
    }

    public void setShowLastUpdatedText(boolean showLastUpdatedText2) {
        this.showLastUpdatedText = showLastUpdatedText2;
        if (!showLastUpdatedText2) {
            this.lastUpdatedTextView.setVisibility(8);
        }
    }

    public void setLastUpdatedDateFormat(SimpleDateFormat lastUpdatedDateFormat2) {
        this.lastUpdatedDateFormat = lastUpdatedDateFormat2;
    }

    public void setRefreshing() {
        this.state = State.REFRESHING;
        scrollTo(0, 0);
        setUiRefreshing();
        setHeaderPadding(0);
    }

    public void onRefreshComplete() {
        this.state = State.PULL_TO_REFRESH;
        resetHeader();
        this.lastUpdated = System.currentTimeMillis();
    }

    public void setTextPullToRefresh(String pullToRefreshText2) {
        this.pullToRefreshText = pullToRefreshText2;
        if (this.state == State.PULL_TO_REFRESH) {
            this.text.setText(pullToRefreshText2);
        }
    }

    public void setTextReleaseToRefresh(String releaseToRefreshText2) {
        this.releaseToRefreshText = releaseToRefreshText2;
        if (this.state == State.RELEASE_TO_REFRESH) {
            this.text.setText(releaseToRefreshText2);
        }
    }

    public void setTextRefreshing(String refreshingText2) {
        this.refreshingText = refreshingText2;
        if (this.state == State.REFRESHING) {
            this.text.setText(refreshingText2);
        }
    }

    private void init() {
        setVerticalFadingEdgeEnabled(false);
        this.headerContainer = (LinearLayout) LayoutInflater.from(getContext()).inflate(C1062R.layout.ptr_header, (ViewGroup) null);
        this.headerContainer.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        this.header = (RelativeLayout) this.headerContainer.findViewById(C1062R.C1063id.ptr_id_header);
        if (this.header != null) {
            this.text = (TextView) this.header.findViewById(C1062R.C1063id.ptr_id_text);
        }
        this.lastUpdatedTextView = (TextView) this.header.findViewById(C1062R.C1063id.ptr_id_last_updated);
        this.image = (ImageView) this.header.findViewById(C1062R.C1063id.ptr_id_image);
        this.spinner = (ProgressBar) this.header.findViewById(C1062R.C1063id.ptr_id_spinner);
        this.pullToRefreshText = getContext().getString(C1062R.string.ptr_pull_to_refresh);
        this.releaseToRefreshText = getContext().getString(C1062R.string.ptr_release_to_refresh);
        this.refreshingText = getContext().getString(C1062R.string.ptr_refreshing);
        this.lastUpdatedText = getContext().getString(C1062R.string.ptr_last_updated);
        this.flipAnimation = new RotateAnimation(BitmapDescriptorFactory.HUE_RED, -180.0f, 1, 0.5f, 1, 0.5f);
        this.flipAnimation.setInterpolator(new LinearInterpolator());
        this.flipAnimation.setDuration(250);
        this.flipAnimation.setFillAfter(true);
        this.reverseFlipAnimation = new RotateAnimation(-180.0f, BitmapDescriptorFactory.HUE_RED, 1, 0.5f, 1, 0.5f);
        this.reverseFlipAnimation.setInterpolator(new LinearInterpolator());
        this.reverseFlipAnimation.setDuration(250);
        this.reverseFlipAnimation.setFillAfter(true);
        addHeaderView(this.headerContainer);
        setState(State.PULL_TO_REFRESH);
        this.scrollbarEnabled = isVerticalScrollBarEnabled();
        this.header.getViewTreeObserver().addOnGlobalLayoutListener(new PTROnGlobalLayoutListener(this, (PTROnGlobalLayoutListener) null));
        super.setOnItemClickListener(new PTROnItemClickListener(this, (PTROnItemClickListener) null));
        super.setOnItemLongClickListener(new PTROnItemLongClickListener(this, (PTROnItemLongClickListener) null));
    }

    /* access modifiers changed from: private */
    public void setHeaderPadding(int padding) {
        this.headerPadding = padding;
        ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) this.header.getLayoutParams();
        mlp.setMargins(0, Math.round((float) padding), 0, 0);
        this.header.setLayoutParams(mlp);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.lockScrollWhileRefreshing && (this.state == State.REFRESHING || (getAnimation() != null && !getAnimation().hasEnded()))) {
            return true;
        }
        switch (event.getAction()) {
            case 0:
                if (getFirstVisiblePosition() == 0) {
                    this.previousY = event.getY();
                } else {
                    this.previousY = -1.0f;
                }
                this.mScrollStartY = event.getY();
                break;
            case 1:
                if (this.previousY != -1.0f && (this.state == State.RELEASE_TO_REFRESH || getFirstVisiblePosition() == 0)) {
                    switch ($SWITCH_TABLE$eu$erikw$PullToRefreshListView$State()[this.state.ordinal()]) {
                        case 1:
                            resetHeader();
                            break;
                        case 2:
                            setState(State.REFRESHING);
                            bounceBackHeader();
                            break;
                    }
                }
                break;
            case 2:
                if (this.previousY != -1.0f && getFirstVisiblePosition() == 0 && Math.abs(this.mScrollStartY - event.getY()) > 5.0f) {
                    float y = event.getY();
                    float diff = y - this.previousY;
                    if (diff > BitmapDescriptorFactory.HUE_RED) {
                        diff /= PULL_RESISTANCE;
                    }
                    this.previousY = y;
                    int newHeaderPadding = Math.max(Math.round(((float) this.headerPadding) + diff), -this.header.getHeight());
                    if (!(newHeaderPadding == this.headerPadding || this.state == State.REFRESHING)) {
                        setHeaderPadding(newHeaderPadding);
                        if (this.state != State.PULL_TO_REFRESH || this.headerPadding <= 0) {
                            if (this.state == State.RELEASE_TO_REFRESH && this.headerPadding < 0) {
                                setState(State.PULL_TO_REFRESH);
                                this.image.clearAnimation();
                                this.image.startAnimation(this.reverseFlipAnimation);
                                break;
                            }
                        } else {
                            setState(State.RELEASE_TO_REFRESH);
                            this.image.clearAnimation();
                            this.image.startAnimation(this.flipAnimation);
                            break;
                        }
                    }
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    private void bounceBackHeader() {
        int yTranslate;
        if (this.state == State.REFRESHING) {
            yTranslate = this.header.getHeight() - this.headerContainer.getHeight();
        } else {
            yTranslate = ((-this.headerContainer.getHeight()) - this.headerContainer.getTop()) + getPaddingTop();
        }
        TranslateAnimation bounceAnimation = new TranslateAnimation(0, BitmapDescriptorFactory.HUE_RED, 0, BitmapDescriptorFactory.HUE_RED, 0, BitmapDescriptorFactory.HUE_RED, 0, (float) yTranslate);
        bounceAnimation.setDuration(700);
        bounceAnimation.setFillEnabled(true);
        bounceAnimation.setFillAfter(false);
        bounceAnimation.setFillBefore(true);
        bounceAnimation.setInterpolator(new OvershootInterpolator(BOUNCE_OVERSHOOT_TENSION));
        bounceAnimation.setAnimationListener(new HeaderAnimationListener(yTranslate));
        startAnimation(bounceAnimation);
    }

    /* access modifiers changed from: private */
    public void resetHeader() {
        if (getFirstVisiblePosition() > 0) {
            setHeaderPadding(-this.header.getHeight());
            setState(State.PULL_TO_REFRESH);
        } else if (getAnimation() == null || getAnimation().hasEnded()) {
            bounceBackHeader();
        } else {
            this.bounceBackHeader = true;
        }
    }

    private void setUiRefreshing() {
        this.spinner.setVisibility(0);
        this.image.clearAnimation();
        this.image.setVisibility(4);
        this.text.setText(this.refreshingText);
    }

    /* access modifiers changed from: private */
    public void setState(State state2) {
        this.state = state2;
        switch ($SWITCH_TABLE$eu$erikw$PullToRefreshListView$State()[state2.ordinal()]) {
            case 1:
                this.spinner.setVisibility(4);
                this.image.setVisibility(0);
                this.text.setText(this.pullToRefreshText);
                if (this.showLastUpdatedText && this.lastUpdated != -1) {
                    this.lastUpdatedTextView.setVisibility(0);
                    this.lastUpdatedTextView.setText(String.format(this.lastUpdatedText, new Object[]{this.lastUpdatedDateFormat.format(new Date(this.lastUpdated))}));
                    return;
                }
                return;
            case 2:
                this.spinner.setVisibility(4);
                this.image.setVisibility(0);
                this.text.setText(this.releaseToRefreshText);
                return;
            case 3:
                setUiRefreshing();
                this.lastUpdated = System.currentTimeMillis();
                if (this.onRefreshListener == null) {
                    setState(State.PULL_TO_REFRESH);
                    return;
                } else {
                    this.onRefreshListener.onRefresh();
                    return;
                }
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (!this.hasResetHeader) {
            if (measuredHeaderHeight > 0 && this.state != State.REFRESHING) {
                setHeaderPadding(-measuredHeaderHeight);
            }
            this.hasResetHeader = true;
        }
    }

    /* renamed from: eu.erikw.PullToRefreshListView$HeaderAnimationListener */
    private class HeaderAnimationListener implements Animation.AnimationListener {
        private int height;
        private State stateAtAnimationStart;
        private int translation;

        public HeaderAnimationListener(int translation2) {
            this.translation = translation2;
        }

        public void onAnimationStart(Animation animation) {
            this.stateAtAnimationStart = PullToRefreshListView.this.state;
            ViewGroup.LayoutParams lp = PullToRefreshListView.this.getLayoutParams();
            this.height = lp.height;
            lp.height = PullToRefreshListView.this.getHeight() - this.translation;
            PullToRefreshListView.this.setLayoutParams(lp);
            if (PullToRefreshListView.this.scrollbarEnabled) {
                PullToRefreshListView.this.setVerticalScrollBarEnabled(false);
            }
        }

        public void onAnimationEnd(Animation animation) {
            int top;
            PullToRefreshListView pullToRefreshListView = PullToRefreshListView.this;
            if (this.stateAtAnimationStart == State.REFRESHING) {
                top = 0;
            } else {
                top = (-PullToRefreshListView.measuredHeaderHeight) - PullToRefreshListView.this.headerContainer.getTop();
            }
            pullToRefreshListView.setHeaderPadding(top);
            PullToRefreshListView.this.setSelection(0);
            ViewGroup.LayoutParams lp = PullToRefreshListView.this.getLayoutParams();
            lp.height = this.height;
            PullToRefreshListView.this.setLayoutParams(lp);
            if (PullToRefreshListView.this.scrollbarEnabled) {
                PullToRefreshListView.this.setVerticalScrollBarEnabled(true);
            }
            if (PullToRefreshListView.this.bounceBackHeader) {
                PullToRefreshListView.this.bounceBackHeader = false;
                PullToRefreshListView.this.postDelayed(new Runnable() {
                    public void run() {
                        PullToRefreshListView.this.resetHeader();
                    }
                }, 100);
            } else if (this.stateAtAnimationStart != State.REFRESHING) {
                PullToRefreshListView.this.setState(State.PULL_TO_REFRESH);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: eu.erikw.PullToRefreshListView$PTROnGlobalLayoutListener */
    private class PTROnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private PTROnGlobalLayoutListener() {
        }

        /* synthetic */ PTROnGlobalLayoutListener(PullToRefreshListView pullToRefreshListView, PTROnGlobalLayoutListener pTROnGlobalLayoutListener) {
            this();
        }

        public void onGlobalLayout() {
            int initialHeaderHeight = PullToRefreshListView.this.header.getHeight();
            if (initialHeaderHeight > 0) {
                PullToRefreshListView.measuredHeaderHeight = initialHeaderHeight;
                if (PullToRefreshListView.measuredHeaderHeight > 0 && PullToRefreshListView.this.state != State.REFRESHING) {
                    PullToRefreshListView.this.setHeaderPadding(-PullToRefreshListView.measuredHeaderHeight);
                    PullToRefreshListView.this.requestLayout();
                }
            }
            PullToRefreshListView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    /* renamed from: eu.erikw.PullToRefreshListView$PTROnItemClickListener */
    private class PTROnItemClickListener implements AdapterView.OnItemClickListener {
        private PTROnItemClickListener() {
        }

        /* synthetic */ PTROnItemClickListener(PullToRefreshListView pullToRefreshListView, PTROnItemClickListener pTROnItemClickListener) {
            this();
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            PullToRefreshListView.this.hasResetHeader = false;
            if (PullToRefreshListView.this.onItemClickListener != null && PullToRefreshListView.this.state == State.PULL_TO_REFRESH) {
                PullToRefreshListView.this.onItemClickListener.onItemClick(adapterView, view, position - PullToRefreshListView.this.getHeaderViewsCount(), id);
            }
        }
    }

    /* renamed from: eu.erikw.PullToRefreshListView$PTROnItemLongClickListener */
    private class PTROnItemLongClickListener implements AdapterView.OnItemLongClickListener {
        private PTROnItemLongClickListener() {
        }

        /* synthetic */ PTROnItemLongClickListener(PullToRefreshListView pullToRefreshListView, PTROnItemLongClickListener pTROnItemLongClickListener) {
            this();
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
            PullToRefreshListView.this.hasResetHeader = false;
            if (PullToRefreshListView.this.onItemLongClickListener == null || PullToRefreshListView.this.state != State.PULL_TO_REFRESH) {
                return false;
            }
            return PullToRefreshListView.this.onItemLongClickListener.onItemLongClick(adapterView, view, position - PullToRefreshListView.this.getHeaderViewsCount(), id);
        }
    }
}
