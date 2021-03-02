package android.support.p004v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.p004v7.widget.FitWindowsViewGroup;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* renamed from: android.support.v7.widget.FitWindowsFrameLayout */
public class FitWindowsFrameLayout extends FrameLayout implements FitWindowsViewGroup {

    /* renamed from: a */
    private FitWindowsViewGroup.OnFitSystemWindowsListener f2074a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(FitWindowsViewGroup.OnFitSystemWindowsListener onFitSystemWindowsListener) {
        this.f2074a = onFitSystemWindowsListener;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        if (this.f2074a != null) {
            this.f2074a.onFitSystemWindows(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
