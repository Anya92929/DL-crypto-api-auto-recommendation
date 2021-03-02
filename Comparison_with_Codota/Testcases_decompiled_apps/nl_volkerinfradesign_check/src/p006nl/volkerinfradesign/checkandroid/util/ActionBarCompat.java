package p006nl.volkerinfradesign.checkandroid.util;

import android.app.ActionBar;
import android.app.Activity;
import android.support.p004v7.app.AppCompatActivity;

/* renamed from: nl.volkerinfradesign.checkandroid.util.ActionBarCompat */
public final class ActionBarCompat {

    /* renamed from: a */
    private final Activity f5662a;

    /* renamed from: nl.volkerinfradesign.checkandroid.util.ActionBarCompat$a */
    interface C1744a {
        /* renamed from: a */
        void mo10464a(ActionBar actionBar);

        /* renamed from: a */
        void mo10465a(android.support.p004v7.app.ActionBar actionBar);
    }

    public ActionBarCompat(Activity activity) {
        this.f5662a = activity;
    }

    public void setDisplayHomeAsUpEnabled(final boolean z) {
        m6457a(new C1744a() {
            /* renamed from: a */
            public void mo10464a(ActionBar actionBar) {
                actionBar.setDisplayHomeAsUpEnabled(z);
            }

            /* renamed from: a */
            public void mo10465a(android.support.p004v7.app.ActionBar actionBar) {
                actionBar.setDisplayHomeAsUpEnabled(z);
            }
        });
    }

    public void setTitle(final String str) {
        m6457a(new C1744a() {
            /* renamed from: a */
            public void mo10464a(ActionBar actionBar) {
                actionBar.setTitle(str);
            }

            /* renamed from: a */
            public void mo10465a(android.support.p004v7.app.ActionBar actionBar) {
                actionBar.setTitle((CharSequence) str);
            }
        });
    }

    public void setTitle(final CharSequence charSequence) {
        m6457a(new C1744a() {
            /* renamed from: a */
            public void mo10464a(ActionBar actionBar) {
                actionBar.setTitle(charSequence);
            }

            /* renamed from: a */
            public void mo10465a(android.support.p004v7.app.ActionBar actionBar) {
                actionBar.setTitle(charSequence);
            }
        });
    }

    public void setIcon(final int i) {
        m6457a(new C1744a() {
            /* renamed from: a */
            public void mo10464a(ActionBar actionBar) {
                actionBar.setIcon(i);
            }

            /* renamed from: a */
            public void mo10465a(android.support.p004v7.app.ActionBar actionBar) {
                actionBar.setIcon(i);
            }
        });
    }

    public void setDisplayShowTitleEnabled(final boolean z) {
        m6457a(new C1744a() {
            /* renamed from: a */
            public void mo10464a(ActionBar actionBar) {
                actionBar.setDisplayShowTitleEnabled(z);
            }

            /* renamed from: a */
            public void mo10465a(android.support.p004v7.app.ActionBar actionBar) {
                actionBar.setDisplayShowTitleEnabled(z);
            }
        });
    }

    /* renamed from: a */
    private void m6457a(C1744a aVar) {
        try {
            ActionBar actionBar = this.f5662a.getActionBar();
            if (actionBar != null) {
                aVar.mo10464a(actionBar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f5662a instanceof AppCompatActivity) {
            try {
                android.support.p004v7.app.ActionBar supportActionBar = ((AppCompatActivity) this.f5662a).getSupportActionBar();
                if (supportActionBar != null) {
                    aVar.mo10465a(supportActionBar);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
