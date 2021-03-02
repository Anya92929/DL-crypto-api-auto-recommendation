package android.support.p000v4.app;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.app.RemoteInputCompatBase;
import android.util.Log;

/* renamed from: android.support.v4.app.RemoteInput */
public class RemoteInput extends RemoteInputCompatBase.RemoteInput {
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    public static final RemoteInputCompatBase.RemoteInput.Factory FACTORY = new RemoteInputCompatBase.RemoteInput.Factory() {
        public RemoteInput build(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle) {
            return new RemoteInput(str, charSequence, charSequenceArr, z, bundle);
        }

        public RemoteInput[] newArray(int i) {
            return new RemoteInput[i];
        }
    };
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";

    /* renamed from: f */
    private static final Impl f685f;

    /* renamed from: a */
    private final String f686a;

    /* renamed from: b */
    private final CharSequence f687b;

    /* renamed from: c */
    private final CharSequence[] f688c;

    /* renamed from: d */
    private final boolean f689d;

    /* renamed from: e */
    private final Bundle f690e;

    /* renamed from: android.support.v4.app.RemoteInput$Builder */
    public final class Builder {

        /* renamed from: a */
        private final String f691a;

        /* renamed from: b */
        private CharSequence f692b;

        /* renamed from: c */
        private CharSequence[] f693c;

        /* renamed from: d */
        private boolean f694d = true;

        /* renamed from: e */
        private Bundle f695e = new Bundle();

        public Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Result key can't be null");
            }
            this.f691a = str;
        }

        public Builder addExtras(Bundle bundle) {
            if (bundle != null) {
                this.f695e.putAll(bundle);
            }
            return this;
        }

        public RemoteInput build() {
            return new RemoteInput(this.f691a, this.f692b, this.f693c, this.f694d, this.f695e);
        }

        public Bundle getExtras() {
            return this.f695e;
        }

        public Builder setAllowFreeFormInput(boolean z) {
            this.f694d = z;
            return this;
        }

        public Builder setChoices(CharSequence[] charSequenceArr) {
            this.f693c = charSequenceArr;
            return this;
        }

        public Builder setLabel(CharSequence charSequence) {
            this.f692b = charSequence;
            return this;
        }
    }

    /* renamed from: android.support.v4.app.RemoteInput$Impl */
    interface Impl {
        void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle);

        Bundle getResultsFromIntent(Intent intent);
    }

    /* renamed from: android.support.v4.app.RemoteInput$ImplApi20 */
    class ImplApi20 implements Impl {
        ImplApi20() {
        }

        public void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
            RemoteInputCompatApi20.m590a(remoteInputArr, intent, bundle);
        }

        public Bundle getResultsFromIntent(Intent intent) {
            return RemoteInputCompatApi20.m589a(intent);
        }
    }

    /* renamed from: android.support.v4.app.RemoteInput$ImplBase */
    class ImplBase implements Impl {
        ImplBase() {
        }

        public void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
            Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
        }

        public Bundle getResultsFromIntent(Intent intent) {
            Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
            return null;
        }
    }

    /* renamed from: android.support.v4.app.RemoteInput$ImplJellybean */
    class ImplJellybean implements Impl {
        ImplJellybean() {
        }

        public void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
            RemoteInputCompatJellybean.m596a(remoteInputArr, intent, bundle);
        }

        public Bundle getResultsFromIntent(Intent intent) {
            return RemoteInputCompatJellybean.m593a(intent);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 20) {
            f685f = new ImplApi20();
        } else if (Build.VERSION.SDK_INT >= 16) {
            f685f = new ImplJellybean();
        } else {
            f685f = new ImplBase();
        }
    }

    RemoteInput(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle) {
        this.f686a = str;
        this.f687b = charSequence;
        this.f688c = charSequenceArr;
        this.f689d = z;
        this.f690e = bundle;
    }

    public static void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        f685f.addResultsToIntent(remoteInputArr, intent, bundle);
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        return f685f.getResultsFromIntent(intent);
    }

    public boolean getAllowFreeFormInput() {
        return this.f689d;
    }

    public CharSequence[] getChoices() {
        return this.f688c;
    }

    public Bundle getExtras() {
        return this.f690e;
    }

    public CharSequence getLabel() {
        return this.f687b;
    }

    public String getResultKey() {
        return this.f686a;
    }
}
