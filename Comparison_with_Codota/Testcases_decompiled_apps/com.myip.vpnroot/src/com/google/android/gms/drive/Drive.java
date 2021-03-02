package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.p003v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.drive.internal.C0430o;
import com.google.android.gms.drive.internal.C0452q;
import com.google.android.gms.drive.internal.C0468t;
import com.google.android.gms.drive.internal.C0488x;
import java.util.List;

public final class Drive {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>(new C0358a<Api.ApiOptions.NoOptions>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Bundle mo4572a(Api.ApiOptions.NoOptions noOptions) {
            return new Bundle();
        }
    }, f807CU, new Scope[0]);

    /* renamed from: CU */
    public static final Api.C0268c<C0452q> f807CU = new Api.C0268c<>();
    public static final DriveApi DriveApi = new C0430o();

    /* renamed from: MU */
    public static final Scope f808MU = new Scope("https://www.googleapis.com/auth/drive");

    /* renamed from: MV */
    public static final Scope f809MV = new Scope("https://www.googleapis.com/auth/drive.apps");

    /* renamed from: MW */
    public static final Api<C0359b> f810MW = new Api<>(new C0358a<C0359b>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Bundle mo4572a(C0359b bVar) {
            return bVar == null ? new Bundle() : bVar.mo4575hM();
        }
    }, f807CU, new Scope[0]);

    /* renamed from: MX */
    public static final C0363b f811MX = new C0468t();

    /* renamed from: MY */
    public static final C0366e f812MY = new C0488x();
    public static final Scope SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
    public static final Scope SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);

    /* renamed from: com.google.android.gms.drive.Drive$a */
    public static abstract class C0358a<O extends Api.ApiOptions> implements Api.C0267b<C0452q, O> {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract Bundle mo4572a(O o);

        /* renamed from: a */
        public C0452q mo3762a(Context context, Looper looper, ClientSettings clientSettings, O o, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            List<String> scopes = clientSettings.getScopes();
            return new C0452q(context, looper, clientSettings, connectionCallbacks, onConnectionFailedListener, (String[]) scopes.toArray(new String[scopes.size()]), mo4572a(o));
        }

        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    /* renamed from: com.google.android.gms.drive.Drive$b */
    public static class C0359b implements Api.ApiOptions.Optional {

        /* renamed from: MZ */
        private final Bundle f813MZ;

        private C0359b() {
            this(new Bundle());
        }

        private C0359b(Bundle bundle) {
            this.f813MZ = bundle;
        }

        /* renamed from: hM */
        public Bundle mo4575hM() {
            return this.f813MZ;
        }
    }

    private Drive() {
    }
}
