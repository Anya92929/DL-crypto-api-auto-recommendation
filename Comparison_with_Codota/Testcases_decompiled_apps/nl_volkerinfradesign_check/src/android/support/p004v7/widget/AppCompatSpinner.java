package android.support.p004v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.p001v4.view.TintableBackgroundView;
import android.support.p001v4.view.ViewCompat;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.widget.ListPopupWindow;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

/* renamed from: android.support.v7.widget.AppCompatSpinner */
public class AppCompatSpinner extends Spinner implements TintableBackgroundView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final boolean f2036a;

    /* renamed from: b */
    private static final boolean f2037b;

    /* renamed from: c */
    private static final int[] f2038c = {16843505};

    /* renamed from: d */
    private TintManager f2039d;

    /* renamed from: e */
    private C1172gp f2040e;

    /* renamed from: f */
    private Context f2041f;

    /* renamed from: g */
    private ListPopupWindow.ForwardingListener f2042g;

    /* renamed from: h */
    private SpinnerAdapter f2043h;

    /* renamed from: i */
    private boolean f2044i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C0549b f2045j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f2046k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final Rect f2047l;

    static {
        boolean z;
        boolean z2;
        if (Build.VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        f2036a = z;
        if (Build.VERSION.SDK_INT >= 16) {
            z2 = true;
        } else {
            z2 = false;
        }
        f2037b = z2;
    }

    public AppCompatSpinner(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatSpinner(Context context, int i) {
        this(context, (AttributeSet) null, C0505R.attr.spinnerStyle, i);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0505R.attr.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, (Resources.Theme) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppCompatSpinner(android.content.Context r9, android.util.AttributeSet r10, int r11, int r12, android.content.res.Resources.Theme r13) {
        /*
            r8 = this;
            r1 = 0
            r3 = 1
            r7 = 0
            r8.<init>(r9, r10, r11)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r8.f2047l = r0
            int[] r0 = android.support.p004v7.appcompat.C0505R.styleable.Spinner
            android.support.v7.widget.TintTypedArray r4 = android.support.p004v7.widget.TintTypedArray.obtainStyledAttributes(r9, r10, r0, r11, r7)
            android.support.v7.widget.TintManager r0 = r4.getTintManager()
            r8.f2039d = r0
            gp r0 = new gp
            android.support.v7.widget.TintManager r2 = r8.f2039d
            r0.<init>(r8, r2)
            r8.f2040e = r0
            if (r13 == 0) goto L_0x009f
            android.support.v7.view.ContextThemeWrapper r0 = new android.support.v7.view.ContextThemeWrapper
            r0.<init>((android.content.Context) r9, (android.content.res.Resources.Theme) r13)
            r8.f2041f = r0
        L_0x002b:
            android.content.Context r0 = r8.f2041f
            if (r0 == 0) goto L_0x0089
            r0 = -1
            if (r12 != r0) goto L_0x0051
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 11
            if (r0 < r2) goto L_0x00d2
            int[] r0 = f2038c     // Catch:{ Exception -> 0x00bb, all -> 0x00ca }
            r2 = 0
            android.content.res.TypedArray r2 = r9.obtainStyledAttributes(r10, r0, r11, r2)     // Catch:{ Exception -> 0x00bb, all -> 0x00ca }
            r0 = 0
            boolean r0 = r2.hasValue(r0)     // Catch:{ Exception -> 0x00d7 }
            if (r0 == 0) goto L_0x004c
            r0 = 0
            r5 = 0
            int r12 = r2.getInt(r0, r5)     // Catch:{ Exception -> 0x00d7 }
        L_0x004c:
            if (r2 == 0) goto L_0x0051
            r2.recycle()
        L_0x0051:
            if (r12 != r3) goto L_0x0089
            android.support.v7.widget.AppCompatSpinner$b r0 = new android.support.v7.widget.AppCompatSpinner$b
            android.content.Context r2 = r8.f2041f
            r0.<init>(r2, r10, r11)
            android.content.Context r2 = r8.f2041f
            int[] r5 = android.support.p004v7.appcompat.C0505R.styleable.Spinner
            android.support.v7.widget.TintTypedArray r2 = android.support.p004v7.widget.TintTypedArray.obtainStyledAttributes(r2, r10, r5, r11, r7)
            int r5 = android.support.p004v7.appcompat.C0505R.styleable.Spinner_android_dropDownWidth
            r6 = -2
            int r5 = r2.getLayoutDimension((int) r5, (int) r6)
            r8.f2046k = r5
            int r5 = android.support.p004v7.appcompat.C0505R.styleable.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r5 = r2.getDrawable(r5)
            r0.setBackgroundDrawable(r5)
            int r5 = android.support.p004v7.appcompat.C0505R.styleable.Spinner_android_prompt
            java.lang.String r5 = r4.getString(r5)
            r0.mo4171a((java.lang.CharSequence) r5)
            r2.recycle()
            r8.f2045j = r0
            android.support.v7.widget.AppCompatSpinner$1 r2 = new android.support.v7.widget.AppCompatSpinner$1
            r2.<init>(r8, r0)
            r8.f2042g = r2
        L_0x0089:
            r4.recycle()
            r8.f2044i = r3
            android.widget.SpinnerAdapter r0 = r8.f2043h
            if (r0 == 0) goto L_0x0099
            android.widget.SpinnerAdapter r0 = r8.f2043h
            r8.setAdapter((android.widget.SpinnerAdapter) r0)
            r8.f2043h = r1
        L_0x0099:
            gp r0 = r8.f2040e
            r0.mo8186a(r10, r11)
            return
        L_0x009f:
            int r0 = android.support.p004v7.appcompat.C0505R.styleable.Spinner_popupTheme
            int r0 = r4.getResourceId(r0, r7)
            if (r0 == 0) goto L_0x00b0
            android.support.v7.view.ContextThemeWrapper r2 = new android.support.v7.view.ContextThemeWrapper
            r2.<init>((android.content.Context) r9, (int) r0)
            r8.f2041f = r2
            goto L_0x002b
        L_0x00b0:
            boolean r0 = f2036a
            if (r0 != 0) goto L_0x00b9
            r0 = r9
        L_0x00b5:
            r8.f2041f = r0
            goto L_0x002b
        L_0x00b9:
            r0 = r1
            goto L_0x00b5
        L_0x00bb:
            r0 = move-exception
            r2 = r1
        L_0x00bd:
            java.lang.String r5 = "AppCompatSpinner"
            java.lang.String r6 = "Could not read android:spinnerMode"
            android.util.Log.i(r5, r6, r0)     // Catch:{ all -> 0x00d5 }
            if (r2 == 0) goto L_0x0051
            r2.recycle()
            goto L_0x0051
        L_0x00ca:
            r0 = move-exception
            r2 = r1
        L_0x00cc:
            if (r2 == 0) goto L_0x00d1
            r2.recycle()
        L_0x00d1:
            throw r0
        L_0x00d2:
            r12 = r3
            goto L_0x0051
        L_0x00d5:
            r0 = move-exception
            goto L_0x00cc
        L_0x00d7:
            r0 = move-exception
            goto L_0x00bd
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p004v7.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    public Context getPopupContext() {
        if (this.f2045j != null) {
            return this.f2041f;
        }
        if (f2036a) {
            return super.getPopupContext();
        }
        return null;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.f2045j != null) {
            this.f2045j.setBackgroundDrawable(drawable);
        } else if (f2037b) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(@DrawableRes int i) {
        setPopupBackgroundDrawable(getPopupContext().getDrawable(i));
    }

    public Drawable getPopupBackground() {
        if (this.f2045j != null) {
            return this.f2045j.getBackground();
        }
        if (f2037b) {
            return super.getPopupBackground();
        }
        return null;
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.f2045j != null) {
            this.f2045j.setVerticalOffset(i);
        } else if (f2037b) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public int getDropDownVerticalOffset() {
        if (this.f2045j != null) {
            return this.f2045j.getVerticalOffset();
        }
        if (f2037b) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.f2045j != null) {
            this.f2045j.setHorizontalOffset(i);
        } else if (f2037b) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.f2045j != null) {
            return this.f2045j.getHorizontalOffset();
        }
        if (f2037b) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public void setDropDownWidth(int i) {
        if (this.f2045j != null) {
            this.f2046k = i;
        } else if (f2037b) {
            super.setDropDownWidth(i);
        }
    }

    public int getDropDownWidth() {
        if (this.f2045j != null) {
            return this.f2046k;
        }
        if (f2037b) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f2044i) {
            this.f2043h = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f2045j != null) {
            this.f2045j.setAdapter(new C0548a(spinnerAdapter, (this.f2041f == null ? getContext() : this.f2041f).getTheme()));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2045j != null && this.f2045j.isShowing()) {
            this.f2045j.dismiss();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f2042g == null || !this.f2042g.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2045j != null && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m3188a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        if (this.f2045j == null || this.f2045j.isShowing()) {
            return super.performClick();
        }
        this.f2045j.show();
        return true;
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.f2045j != null) {
            this.f2045j.mo4171a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        return this.f2045j != null ? this.f2045j.mo4170a() : super.getPrompt();
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        if (this.f2040e != null) {
            this.f2040e.mo8182a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2040e != null) {
            this.f2040e.mo8185a(drawable);
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.f2040e != null) {
            this.f2040e.mo8183a(colorStateList);
        }
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f2040e != null) {
            return this.f2040e.mo8181a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f2040e != null) {
            this.f2040e.mo8184a(mode);
        }
    }

    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f2040e != null) {
            return this.f2040e.mo8187b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2040e != null) {
            this.f2040e.mo8189c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m3188a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        View view;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view2 = null;
        int i = 0;
        int i2 = 0;
        while (max2 < min) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
            } else {
                itemViewType = i2;
                view = view2;
            }
            view2 = spinnerAdapter.getView(max2, view, this);
            if (view2.getLayoutParams() == null) {
                view2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view2.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view2.getMeasuredWidth());
            max2++;
            i2 = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.f2047l);
        return this.f2047l.left + this.f2047l.right + i;
    }

    /* renamed from: android.support.v7.widget.AppCompatSpinner$a */
    static class C0548a implements ListAdapter, SpinnerAdapter {

        /* renamed from: a */
        private SpinnerAdapter f2050a;

        /* renamed from: b */
        private ListAdapter f2051b;

        public C0548a(@Nullable SpinnerAdapter spinnerAdapter, @Nullable Resources.Theme theme) {
            this.f2050a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f2051b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (AppCompatSpinner.f2036a && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                ThemedSpinnerAdapter themedSpinnerAdapter2 = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter2.getDropDownViewTheme() == null) {
                    themedSpinnerAdapter2.setDropDownViewTheme(theme);
                }
            }
        }

        public int getCount() {
            if (this.f2050a == null) {
                return 0;
            }
            return this.f2050a.getCount();
        }

        public Object getItem(int i) {
            if (this.f2050a == null) {
                return null;
            }
            return this.f2050a.getItem(i);
        }

        public long getItemId(int i) {
            if (this.f2050a == null) {
                return -1;
            }
            return this.f2050a.getItemId(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.f2050a == null) {
                return null;
            }
            return this.f2050a.getDropDownView(i, view, viewGroup);
        }

        public boolean hasStableIds() {
            return this.f2050a != null && this.f2050a.hasStableIds();
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f2050a != null) {
                this.f2050a.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f2050a != null) {
                this.f2050a.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f2051b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f2051b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* renamed from: android.support.v7.widget.AppCompatSpinner$b */
    class C0549b extends ListPopupWindow {

        /* renamed from: c */
        private CharSequence f2053c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public ListAdapter f2054d;

        /* renamed from: e */
        private final Rect f2055e = new Rect();

        public C0549b(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            setAnchorView(AppCompatSpinner.this);
            setModal(true);
            setPromptPosition(0);
            setOnItemClickListener(new AdapterView.OnItemClickListener(AppCompatSpinner.this) {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppCompatSpinner.this.setSelection(i);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        AppCompatSpinner.this.performItemClick(view, i, C0549b.this.f2054d.getItemId(i));
                    }
                    C0549b.this.dismiss();
                }
            });
        }

        public void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.f2054d = listAdapter;
        }

        /* renamed from: a */
        public CharSequence mo4170a() {
            return this.f2053c;
        }

        /* renamed from: a */
        public void mo4171a(CharSequence charSequence) {
            this.f2053c = charSequence;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo4172b() {
            int i;
            int i2;
            Drawable background = getBackground();
            if (background != null) {
                background.getPadding(AppCompatSpinner.this.f2047l);
                i = ViewUtils.isLayoutRtl(AppCompatSpinner.this) ? AppCompatSpinner.this.f2047l.right : -AppCompatSpinner.this.f2047l.left;
            } else {
                Rect b = AppCompatSpinner.this.f2047l;
                AppCompatSpinner.this.f2047l.right = 0;
                b.left = 0;
                i = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            if (AppCompatSpinner.this.f2046k == -2) {
                int a = AppCompatSpinner.this.m3188a((SpinnerAdapter) this.f2054d, getBackground());
                int i3 = (AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.f2047l.left) - AppCompatSpinner.this.f2047l.right;
                if (a <= i3) {
                    i3 = a;
                }
                setContentWidth(Math.max(i3, (width - paddingLeft) - paddingRight));
            } else if (AppCompatSpinner.this.f2046k == -1) {
                setContentWidth((width - paddingLeft) - paddingRight);
            } else {
                setContentWidth(AppCompatSpinner.this.f2046k);
            }
            if (ViewUtils.isLayoutRtl(AppCompatSpinner.this)) {
                i2 = ((width - paddingRight) - getWidth()) + i;
            } else {
                i2 = i + paddingLeft;
            }
            setHorizontalOffset(i2);
        }

        public void show() {
            ViewTreeObserver viewTreeObserver;
            boolean isShowing = isShowing();
            mo4172b();
            setInputMethodMode(2);
            super.show();
            getListView().setChoiceMode(1);
            setSelection(AppCompatSpinner.this.getSelectedItemPosition());
            if (!isShowing && (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) != null) {
                final C05512 r1 = new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        if (!C0549b.this.m3195a((View) AppCompatSpinner.this)) {
                            C0549b.this.dismiss();
                            return;
                        }
                        C0549b.this.mo4172b();
                        C0549b.super.show();
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener(r1);
                setOnDismissListener(new PopupWindow.OnDismissListener() {
                    public void onDismiss() {
                        ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.removeGlobalOnLayoutListener(r1);
                        }
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public boolean m3195a(View view) {
            return ViewCompat.isAttachedToWindow(view) && view.getGlobalVisibleRect(this.f2055e);
        }
    }
}
