package com.jeremyfeinstein.slidingmenu.lib;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class SlidingMenu extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f7551a = SlidingMenu.class.getSimpleName();

    /* renamed from: b */
    private boolean f7552b;

    /* renamed from: c */
    private C1990a f7553c;

    /* renamed from: d */
    private C1995f f7554d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C2004o f7555e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C2004o f7556f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C2002m f7557g;

    public class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR = new C2006q();

        /* renamed from: a */
        private final int f7558a;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f7558a = parcel.readInt();
        }

        /* synthetic */ SavedState(Parcel parcel, C1999j jVar) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.f7558a = i;
        }

        /* renamed from: a */
        public int mo9975a() {
            return this.f7558a;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f7558a);
        }
    }

    public SlidingMenu(Activity activity, int i) {
        this((Context) activity, (AttributeSet) null);
        mo9922a(activity, i);
    }

    public SlidingMenu(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlidingMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7552b = false;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.f7554d = new C1995f(context);
        addView(this.f7554d, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        this.f7553c = new C1990a(context);
        addView(this.f7553c, layoutParams2);
        this.f7553c.setCustomViewBehind(this.f7554d);
        this.f7554d.setCustomViewAbove(this.f7553c);
        this.f7553c.setOnPageChangeListener(new C1999j(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1998i.SlidingMenu);
        setMode(obtainStyledAttributes.getInt(C1998i.SlidingMenu_mode, 0));
        int resourceId = obtainStyledAttributes.getResourceId(C1998i.SlidingMenu_viewAbove, -1);
        if (resourceId != -1) {
            setContent(resourceId);
        } else {
            setContent((View) new FrameLayout(context));
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(C1998i.SlidingMenu_viewBehind, -1);
        if (resourceId2 != -1) {
            setMenu(resourceId2);
        } else {
            setMenu((View) new FrameLayout(context));
        }
        setTouchModeAbove(obtainStyledAttributes.getInt(C1998i.SlidingMenu_touchModeAbove, 0));
        setTouchModeBehind(obtainStyledAttributes.getInt(C1998i.SlidingMenu_touchModeBehind, 0));
        int dimension = (int) obtainStyledAttributes.getDimension(C1998i.SlidingMenu_behindOffset, -1.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(C1998i.SlidingMenu_behindWidth, -1.0f);
        if (dimension == -1 || dimension2 == -1) {
            if (dimension != -1) {
                setBehindOffset(dimension);
            } else if (dimension2 != -1) {
                setBehindWidth(dimension2);
            } else {
                setBehindOffset(0);
            }
            setBehindScrollScale(obtainStyledAttributes.getFloat(C1998i.SlidingMenu_behindScrollScale, 0.33f));
            int resourceId3 = obtainStyledAttributes.getResourceId(C1998i.SlidingMenu_shadowDrawable, -1);
            if (resourceId3 != -1) {
                setShadowDrawable(resourceId3);
            }
            setShadowWidth((int) obtainStyledAttributes.getDimension(C1998i.SlidingMenu_shadowWidth, 0.0f));
            setFadeEnabled(obtainStyledAttributes.getBoolean(C1998i.SlidingMenu_fadeEnabled, true));
            setFadeDegree(obtainStyledAttributes.getFloat(C1998i.SlidingMenu_fadeDegree, 0.33f));
            setSelectorEnabled(obtainStyledAttributes.getBoolean(C1998i.SlidingMenu_selectorEnabled, false));
            int resourceId4 = obtainStyledAttributes.getResourceId(C1998i.SlidingMenu_selectorDrawable, -1);
            if (resourceId4 != -1) {
                setSelectorDrawable(resourceId4);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException("Cannot set both behindOffset and behindWidth for a SlidingMenu");
    }

    /* renamed from: a */
    public void mo9920a() {
        mo9924a(true);
    }

    @TargetApi(11)
    /* renamed from: a */
    public void mo9921a(float f) {
        int i = 0;
        if (Build.VERSION.SDK_INT >= 11) {
            if (f > 0.0f && f < 1.0f) {
                i = 2;
            }
            if (i != getContent().getLayerType()) {
                getHandler().post(new C2000k(this, i));
            }
        }
    }

    /* renamed from: a */
    public void mo9922a(Activity activity, int i) {
        mo9923a(activity, i, false);
    }

    /* renamed from: a */
    public void mo9923a(Activity activity, int i, boolean z) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("slideStyle must be either SLIDING_WINDOW or SLIDING_CONTENT");
        } else if (getParent() != null) {
            throw new IllegalStateException("This SlidingMenu appears to already be attached");
        } else {
            TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{16842836});
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            obtainStyledAttributes.recycle();
            switch (i) {
                case 0:
                    this.f7552b = false;
                    ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                    ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
                    viewGroup2.setBackgroundResource(resourceId);
                    viewGroup.removeView(viewGroup2);
                    viewGroup.addView(this);
                    setContent((View) viewGroup2);
                    return;
                case 1:
                    this.f7552b = z;
                    ViewGroup viewGroup3 = (ViewGroup) activity.findViewById(16908290);
                    View childAt = viewGroup3.getChildAt(0);
                    viewGroup3.removeView(childAt);
                    viewGroup3.addView(this);
                    setContent(childAt);
                    if (childAt.getBackground() == null) {
                        childAt.setBackgroundResource(resourceId);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    public void mo9924a(boolean z) {
        this.f7553c.mo9983a(1, z);
    }

    public void addIgnoredView(View view) {
        this.f7553c.addIgnoredView(view);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public boolean fitSystemWindows(Rect rect) {
        int i = rect.left;
        int i2 = rect.right;
        int i3 = rect.top;
        int i4 = rect.bottom;
        if (this.f7552b) {
            return true;
        }
        Log.v(f7551a, "setting padding!");
        setPadding(i, i3, i2, i4);
        return true;
    }

    public int getBehindOffset() {
        return ((RelativeLayout.LayoutParams) this.f7554d.getLayoutParams()).rightMargin;
    }

    public float getBehindScrollScale() {
        return this.f7554d.getScrollScale();
    }

    public View getContent() {
        return this.f7553c.getContent();
    }

    public View getMenu() {
        return this.f7554d.getContent();
    }

    public int getMode() {
        return this.f7554d.getMode();
    }

    public View getSecondaryMenu() {
        return this.f7554d.getSecondaryContent();
    }

    public int getTouchModeAbove() {
        return this.f7553c.getTouchMode();
    }

    public int getTouchmodeMarginThreshold() {
        return this.f7554d.getMarginThreshold();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f7553c.setCurrentItem(savedState.mo9975a());
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f7553c.getCurrentItem());
    }

    public void removeIgnoredView(View view) {
        this.f7553c.removeIgnoredView(view);
    }

    public void setAboveOffset(int i) {
        this.f7553c.setAboveOffset(i);
    }

    public void setAboveOffsetRes(int i) {
        setAboveOffset((int) getContext().getResources().getDimension(i));
    }

    public void setBehindCanvasTransformer(C2001l lVar) {
        this.f7554d.setCanvasTransformer(lVar);
    }

    public void setBehindOffset(int i) {
        this.f7554d.setWidthOffset(i);
    }

    public void setBehindOffsetRes(int i) {
        setBehindOffset((int) getContext().getResources().getDimension(i));
    }

    public void setBehindScrollScale(float f) {
        if (f >= 0.0f || f <= 1.0f) {
            this.f7554d.setScrollScale(f);
            return;
        }
        throw new IllegalStateException("ScrollScale must be between 0 and 1");
    }

    public void setBehindWidth(int i) {
        int width;
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        Class<Display> cls = Display.class;
        try {
            Point point = new Point();
            cls.getMethod("getSize", new Class[]{Point.class}).invoke(defaultDisplay, new Object[]{point});
            width = point.x;
        } catch (Exception e) {
            width = defaultDisplay.getWidth();
        }
        setBehindOffset(width - i);
    }

    public void setBehindWidthRes(int i) {
        setBehindWidth((int) getContext().getResources().getDimension(i));
    }

    public void setContent(int i) {
        setContent(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null));
    }

    public void setContent(View view) {
        this.f7553c.setContent(view);
        mo9920a();
    }

    public void setFadeDegree(float f) {
        this.f7554d.setFadeDegree(f);
    }

    public void setFadeEnabled(boolean z) {
        this.f7554d.setFadeEnabled(z);
    }

    public void setMenu(int i) {
        setMenu(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null));
    }

    public void setMenu(View view) {
        this.f7554d.setContent(view);
    }

    public void setMode(int i) {
        if (i == 0 || i == 1 || i == 2) {
            this.f7554d.setMode(i);
            return;
        }
        throw new IllegalStateException("SlidingMenu mode must be LEFT, RIGHT, or LEFT_RIGHT");
    }

    public void setOnCloseListener(C2002m mVar) {
        this.f7557g = mVar;
    }

    public void setOnClosedListener(C2003n nVar) {
        this.f7553c.setOnClosedListener(nVar);
    }

    public void setOnOpenListener(C2004o oVar) {
        this.f7555e = oVar;
    }

    public void setOnOpenedListener(C2005p pVar) {
        this.f7553c.setOnOpenedListener(pVar);
    }

    public void setSecondaryMenu(int i) {
        setSecondaryMenu(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null));
    }

    public void setSecondaryMenu(View view) {
        this.f7554d.setSecondaryContent(view);
    }

    public void setSecondaryOnOpenListner(C2004o oVar) {
        this.f7556f = oVar;
    }

    public void setSecondaryShadowDrawable(int i) {
        setSecondaryShadowDrawable(getContext().getResources().getDrawable(i));
    }

    public void setSecondaryShadowDrawable(Drawable drawable) {
        this.f7554d.setSecondaryShadowDrawable(drawable);
    }

    public void setSelectedView(View view) {
        this.f7554d.setSelectedView(view);
    }

    public void setSelectorBitmap(Bitmap bitmap) {
        this.f7554d.setSelectorBitmap(bitmap);
    }

    public void setSelectorDrawable(int i) {
        this.f7554d.setSelectorBitmap(BitmapFactory.decodeResource(getResources(), i));
    }

    public void setSelectorEnabled(boolean z) {
        this.f7554d.setSelectorEnabled(true);
    }

    public void setShadowDrawable(int i) {
        setShadowDrawable(getContext().getResources().getDrawable(i));
    }

    public void setShadowDrawable(Drawable drawable) {
        this.f7554d.setShadowDrawable(drawable);
    }

    public void setShadowWidth(int i) {
        this.f7554d.setShadowWidth(i);
    }

    public void setShadowWidthRes(int i) {
        setShadowWidth((int) getResources().getDimension(i));
    }

    public void setSlidingEnabled(boolean z) {
        this.f7553c.setSlidingEnabled(z);
    }

    public void setStatic(boolean z) {
        if (z) {
            setSlidingEnabled(false);
            this.f7553c.setCustomViewBehind((C1995f) null);
            this.f7553c.setCurrentItem(1);
            return;
        }
        this.f7553c.setCurrentItem(1);
        this.f7553c.setCustomViewBehind(this.f7554d);
        setSlidingEnabled(true);
    }

    public void setTouchModeAbove(int i) {
        if (i == 1 || i == 0 || i == 2) {
            this.f7553c.setTouchMode(i);
            return;
        }
        throw new IllegalStateException("TouchMode must be set to eitherTOUCHMODE_FULLSCREEN or TOUCHMODE_MARGIN or TOUCHMODE_NONE.");
    }

    public void setTouchModeBehind(int i) {
        if (i == 1 || i == 0 || i == 2) {
            this.f7554d.setTouchMode(i);
            return;
        }
        throw new IllegalStateException("TouchMode must be set to eitherTOUCHMODE_FULLSCREEN or TOUCHMODE_MARGIN or TOUCHMODE_NONE.");
    }

    public void setTouchmodeMarginThreshold(int i) {
        this.f7554d.setMarginThreshold(i);
    }
}
