package android.support.p003v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.p003v7.internal.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;

/* renamed from: android.support.v7.widget.ThemedSpinnerAdapter */
public interface ThemedSpinnerAdapter extends SpinnerAdapter {

    /* renamed from: android.support.v7.widget.ThemedSpinnerAdapter$Helper */
    public final class Helper {

        /* renamed from: a */
        private final Context f3237a;

        /* renamed from: b */
        private final LayoutInflater f3238b;

        /* renamed from: c */
        private LayoutInflater f3239c;

        public Helper(Context context) {
            this.f3237a = context;
            this.f3238b = LayoutInflater.from(context);
        }

        public LayoutInflater getDropDownViewInflater() {
            return this.f3239c != null ? this.f3239c : this.f3238b;
        }

        public Resources.Theme getDropDownViewTheme() {
            if (this.f3239c == null) {
                return null;
            }
            return this.f3239c.getContext().getTheme();
        }

        public void setDropDownViewTheme(Resources.Theme theme) {
            if (theme == null) {
                this.f3239c = null;
            } else if (theme == this.f3237a.getTheme()) {
                this.f3239c = this.f3238b;
            } else {
                this.f3239c = LayoutInflater.from(new ContextThemeWrapper(this.f3237a, theme));
            }
        }
    }

    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(Resources.Theme theme);
}
