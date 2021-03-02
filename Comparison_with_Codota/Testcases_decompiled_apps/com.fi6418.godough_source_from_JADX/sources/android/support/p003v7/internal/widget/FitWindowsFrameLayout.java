package android.support.p003v7.internal.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.p003v7.internal.widget.FitWindowsViewGroup;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* renamed from: android.support.v7.internal.widget.FitWindowsFrameLayout */
public class FitWindowsFrameLayout extends FrameLayout implements FitWindowsViewGroup {

    /* renamed from: a */
    private FitWindowsViewGroup.OnFitSystemWindowsListener f2320a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        if (this.f2320a != null) {
            this.f2320a.onFitSystemWindows(rect);
        }
        return super.fitSystemWindows(rect);
    }

    public void setOnFitSystemWindowsListener(FitWindowsViewGroup.OnFitSystemWindowsListener onFitSystemWindowsListener) {
        this.f2320a = onFitSystemWindowsListener;
    }
}
