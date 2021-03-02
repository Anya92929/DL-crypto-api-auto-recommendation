package android.support.p004v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p004v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;

/* renamed from: android.support.v7.widget.ThemedSpinnerAdapter */
public interface ThemedSpinnerAdapter extends SpinnerAdapter {
    @Nullable
    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(@Nullable Resources.Theme theme);

    /* renamed from: android.support.v7.widget.ThemedSpinnerAdapter$Helper */
    public static final class Helper {

        /* renamed from: a */
        private final Context f2301a;

        /* renamed from: b */
        private final LayoutInflater f2302b;

        /* renamed from: c */
        private LayoutInflater f2303c;

        public Helper(@NonNull Context context) {
            this.f2301a = context;
            this.f2302b = LayoutInflater.from(context);
        }

        public void setDropDownViewTheme(@Nullable Resources.Theme theme) {
            if (theme == null) {
                this.f2303c = null;
            } else if (theme == this.f2301a.getTheme()) {
                this.f2303c = this.f2302b;
            } else {
                this.f2303c = LayoutInflater.from(new ContextThemeWrapper(this.f2301a, theme));
            }
        }

        @Nullable
        public Resources.Theme getDropDownViewTheme() {
            if (this.f2303c == null) {
                return null;
            }
            return this.f2303c.getContext().getTheme();
        }

        @NonNull
        public LayoutInflater getDropDownViewInflater() {
            return this.f2303c != null ? this.f2303c : this.f2302b;
        }
    }
}
