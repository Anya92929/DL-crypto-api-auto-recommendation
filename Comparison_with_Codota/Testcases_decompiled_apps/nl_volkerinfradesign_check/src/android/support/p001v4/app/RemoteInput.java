package android.support.p001v4.app;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.p001v4.app.RemoteInputCompatBase;
import android.util.Log;

/* renamed from: android.support.v4.app.RemoteInput */
public class RemoteInput extends RemoteInputCompatBase.RemoteInput {
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    public static final RemoteInputCompatBase.RemoteInput.Factory FACTORY = new RemoteInputCompatBase.RemoteInput.Factory() {
        /* renamed from: a */
        public RemoteInput build(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle) {
            return new RemoteInput(str, charSequence, charSequenceArr, z, bundle);
        }

        /* renamed from: a */
        public RemoteInput[] newArray(int i) {
            return new RemoteInput[i];
        }
    };
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";

    /* renamed from: f */
    private static final C0094a f391f;

    /* renamed from: a */
    private final String f392a;

    /* renamed from: b */
    private final CharSequence f393b;

    /* renamed from: c */
    private final CharSequence[] f394c;

    /* renamed from: d */
    private final boolean f395d;

    /* renamed from: e */
    private final Bundle f396e;

    /* renamed from: android.support.v4.app.RemoteInput$a */
    interface C0094a {
        /* renamed from: a */
        Bundle mo699a(Intent intent);

        /* renamed from: a */
        void mo700a(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle);
    }

    RemoteInput(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle) {
        this.f392a = str;
        this.f393b = charSequence;
        this.f394c = charSequenceArr;
        this.f395d = z;
        this.f396e = bundle;
    }

    public String getResultKey() {
        return this.f392a;
    }

    public CharSequence getLabel() {
        return this.f393b;
    }

    public CharSequence[] getChoices() {
        return this.f394c;
    }

    public boolean getAllowFreeFormInput() {
        return this.f395d;
    }

    public Bundle getExtras() {
        return this.f396e;
    }

    /* renamed from: android.support.v4.app.RemoteInput$Builder */
    public static final class Builder {

        /* renamed from: a */
        private final String f397a;

        /* renamed from: b */
        private CharSequence f398b;

        /* renamed from: c */
        private CharSequence[] f399c;

        /* renamed from: d */
        private boolean f400d = true;

        /* renamed from: e */
        private Bundle f401e = new Bundle();

        public Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Result key can't be null");
            }
            this.f397a = str;
        }

        public Builder setLabel(CharSequence charSequence) {
            this.f398b = charSequence;
            return this;
        }

        public Builder setChoices(CharSequence[] charSequenceArr) {
            this.f399c = charSequenceArr;
            return this;
        }

        public Builder setAllowFreeFormInput(boolean z) {
            this.f400d = z;
            return this;
        }

        public Builder addExtras(Bundle bundle) {
            if (bundle != null) {
                this.f401e.putAll(bundle);
            }
            return this;
        }

        public Bundle getExtras() {
            return this.f401e;
        }

        public RemoteInput build() {
            return new RemoteInput(this.f397a, this.f398b, this.f399c, this.f400d, this.f401e);
        }
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        return f391f.mo699a(intent);
    }

    public static void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        f391f.mo700a(remoteInputArr, intent, bundle);
    }

    /* renamed from: android.support.v4.app.RemoteInput$c */
    static class C0096c implements C0094a {
        C0096c() {
        }

        /* renamed from: a */
        public Bundle mo699a(Intent intent) {
            Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
            return null;
        }

        /* renamed from: a */
        public void mo700a(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
            Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
        }
    }

    /* renamed from: android.support.v4.app.RemoteInput$d */
    static class C0097d implements C0094a {
        C0097d() {
        }

        /* renamed from: a */
        public Bundle mo699a(Intent intent) {
            return C0005ae.m10a(intent);
        }

        /* renamed from: a */
        public void mo700a(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
            C0005ae.m13a(remoteInputArr, intent, bundle);
        }
    }

    /* renamed from: android.support.v4.app.RemoteInput$b */
    static class C0095b implements C0094a {
        C0095b() {
        }

        /* renamed from: a */
        public Bundle mo699a(Intent intent) {
            return C0004ad.m6a(intent);
        }

        /* renamed from: a */
        public void mo700a(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
            C0004ad.m7a(remoteInputArr, intent, bundle);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 20) {
            f391f = new C0095b();
        } else if (Build.VERSION.SDK_INT >= 16) {
            f391f = new C0097d();
        } else {
            f391f = new C0096c();
        }
    }
}
