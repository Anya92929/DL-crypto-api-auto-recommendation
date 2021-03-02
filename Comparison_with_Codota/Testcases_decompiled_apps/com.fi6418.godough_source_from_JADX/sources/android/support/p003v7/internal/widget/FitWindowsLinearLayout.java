package android.support.p003v7.internal.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.p003v7.internal.widget.FitWindowsViewGroup;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* renamed from: android.support.v7.internal.widget.FitWindowsLinearLayout */
public class FitWindowsLinearLayout extends LinearLayout implements FitWindowsViewGroup {

    /* renamed from: a */
    private FitWindowsViewGroup.OnFitSystemWindowsListener f2321a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        if (this.f2321a != null) {
            this.f2321a.onFitSystemWindows(rect);
        }
        return super.fitSystemWindows(rect);
    }

    public void setOnFitSystemWindowsListener(FitWindowsViewGroup.OnFitSystemWindowsListener onFitSystemWindowsListener) {
        this.f2321a = onFitSystemWindowsListener;
    }
}
