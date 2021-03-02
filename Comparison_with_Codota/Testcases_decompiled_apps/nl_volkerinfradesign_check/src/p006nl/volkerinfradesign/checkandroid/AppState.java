package p006nl.volkerinfradesign.checkandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.gson.JsonObject;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.lang3.StringUtils;
import p006nl.volkerinfradesign.checkandroid.environments.Model;
import p006nl.volkerinfradesign.checkandroid.environments.implementation.EnvironmentFactory;
import p006nl.volkerinfradesign.checkandroid.p007ui.login.LoginActivity;

/* renamed from: nl.volkerinfradesign.checkandroid.AppState */
public abstract class AppState {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static AppState f4624b;

    /* renamed from: a */
    boolean f4625a;

    /* renamed from: c */
    private final PublishState f4626c;

    /* renamed from: nl.volkerinfradesign.checkandroid.AppState$Logger */
    public interface Logger {
        /* renamed from: e */
        void mo8930e(String str, Throwable th);

        /* renamed from: i */
        void mo8931i(String str);
    }

    public abstract String getDomainFolder();

    public abstract Model getModel();

    public abstract String getName();

    public abstract File getPicturesDir();

    public static AppState getInstance() {
        if (f4624b != null) {
            return f4624b;
        }
        throw new IllegalStateException("The AppState is not yet initialized!");
    }

    /* renamed from: a */
    static void m5772a(App app, String str) {
        m5773a(app, PublishState.PRODUCTION, str);
    }

    /* renamed from: a */
    private static void m5773a(App app, PublishState publishState, String str) {
        EnvironmentFactory environmentFactory = new EnvironmentFactory();
        if ("wave".equals(str)) {
            f4624b = new C1351d(publishState, environmentFactory, app);
        } else if ("stenaline".equals(str)) {
            f4624b = new C1350c(publishState, environmentFactory, app);
        } else if ("isaladelta".equals(str)) {
            f4624b = new C1349b(publishState, environmentFactory, app);
        } else {
            f4624b = new C1348a(publishState, environmentFactory, app);
        }
    }

    private AppState(PublishState publishState) {
        this.f4625a = false;
        this.f4626c = publishState;
    }

    public final URL getTreeStructureGETUrl() {
        return this.f4626c.f4631c;
    }

    public final URL getFormsGETUrl() {
        return this.f4626c.f4630b;
    }

    public final URL getSaveInspectionsUrl() {
        return this.f4626c.f4632d;
    }

    public URL getUserGETUrl() {
        return this.f4626c.f4635g;
    }

    public URL getUserPOSTUrl() {
        return this.f4626c.f4636h;
    }

    public URL getPassCodeUrl() {
        return this.f4626c.f4638j;
    }

    public URL getUserSessionUrl() {
        return this.f4626c.f4637i;
    }

    public URL getLogoutUrl() {
        return this.f4626c.f4642n;
    }

    public final URL getInspectionItemUploadUrl() {
        return this.f4626c.f4639k;
    }

    public final URL getUserFinderUrl() throws MalformedURLException {
        return this.f4626c.getUserFinderUrl();
    }

    public final URL getProjectPUTUrl() {
        return this.f4626c.f4641m;
    }

    public final URL getProjectsGETUrl() {
        return this.f4626c.f4640l;
    }

    public URL getTasksPOSTUrl() {
        return this.f4626c.f4634f;
    }

    public URL getDownloadInspectionsUrl() {
        return this.f4626c.f4633e;
    }

    public final boolean isDebugable() {
        return this.f4626c.f4629a;
    }

    public PublishState getPublishState() {
        return this.f4626c;
    }

    public final Logger log() {
        return this.f4626c;
    }

    public void setLoggingInAgain(boolean z) {
        this.f4625a = z;
    }

    public boolean isLoggingInAgain() {
        return this.f4625a;
    }

    public JsonObject getSIDJSON() {
        return getModel().getSessionId();
    }

    public boolean isThereASession() {
        return getSIDJSON() != null;
    }

    public void setSID(String str) {
        getModel().setSessionId(str);
    }

    public boolean hasValidSession(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection != null ? httpURLConnection.getHeaderField("X-Error-Code") : null;
        return isThereASession() && (StringUtils.isBlank(headerField) || !headerField.equals("399"));
    }

    public void invalidateLogin(HttpURLConnection httpURLConnection) {
        if (!hasValidSession(httpURLConnection)) {
            invalidateLogin();
        }
    }

    public void invalidateLogin() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                if (!AppState.this.isLoggingInAgain()) {
                    try {
                        Intent intent = new Intent(App.getAppContext(), LoginActivity.class);
                        AppState.this.setLoggingInAgain(true);
                        AppState.this.setSID((String) null);
                        AppState.this.getModel().resetSetup();
                        intent.setFlags(335544320);
                        App.getAppContext().startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.AppState$a */
    static final class C1348a extends AppState {

        /* renamed from: b */
        private final Model f4644b;

        /* renamed from: c */
        private final File f4645c;

        C1348a(PublishState publishState, EnvironmentFactory environmentFactory, App app) {
            super(publishState);
            this.f4644b = environmentFactory.getCheckInstance(app);
            this.f4645c = new File(app.getFilesDir(), "Check_afbeeldingen");
        }

        public String getDomainFolder() {
            return "keuringen";
        }

        public Model getModel() {
            return this.f4644b;
        }

        public String getName() {
            return "Check";
        }

        public File getPicturesDir() {
            return this.f4645c;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.AppState$PublishState */
    public enum PublishState implements Logger {
        ALPHA(true, "https://"),
        BETA(true, "https://"),
        PRODUCTION(false, "https://");
        

        /* renamed from: a */
        final boolean f4629a;

        /* renamed from: b */
        final URL f4630b;

        /* renamed from: c */
        final URL f4631c;

        /* renamed from: d */
        final URL f4632d;

        /* renamed from: e */
        final URL f4633e;

        /* renamed from: f */
        final URL f4634f;

        /* renamed from: g */
        final URL f4635g;

        /* renamed from: h */
        final URL f4636h;

        /* renamed from: i */
        final URL f4637i;

        /* renamed from: j */
        final URL f4638j;

        /* renamed from: k */
        final URL f4639k;

        /* renamed from: l */
        final URL f4640l;

        /* renamed from: m */
        final URL f4641m;

        /* renamed from: n */
        final URL f4642n;

        /* renamed from: o */
        final String f4643o;

        private PublishState(boolean z, String str) {
            String str2 = str + "volkerwesselswave.appspot.com";
            this.f4629a = z;
            this.f4643o = str2 + "/users/GET";
            try {
                this.f4640l = new URL(str2 + "/projects/GET");
                this.f4641m = new URL(str2 + "/project/POST");
                this.f4630b = new URL(str2 + "/formInspections/GET");
                this.f4631c = new URL(str2 + "/treeStructure/GET");
                this.f4632d = new URL(str2 + "/inspections/POST");
                this.f4633e = new URL(str2 + "/inspections/GET");
                this.f4634f = new URL(str2 + "/actions/POST");
                this.f4635g = new URL(str2 + "/user/GET");
                this.f4636h = new URL(str2 + "/user/POST");
                this.f4637i = new URL(str2 + "/user/session/GET");
                this.f4638j = new URL(str2 + "/user/passCode/GET");
                this.f4639k = new URL(str2 + "/inspectionItem/photo/uploadUrl/GET");
                this.f4642n = new URL(str2 + "/user/session/DELETE");
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new Error(e);
            }
        }

        public URL getUserFinderUrl() throws MalformedURLException {
            return new URL(this.f4643o);
        }

        /* renamed from: i */
        public void mo8931i(String str) {
            if (this.f4629a) {
                Log.i("check:info_tag", str);
                AppState.f4624b.getModel().getLogger().info(str);
            }
        }

        /* renamed from: e */
        public void mo8930e(String str, Throwable th) {
            if (this.f4629a) {
                Log.e("check:info_tag", str, th);
                AppState.f4624b.getModel().getLogger().logError(str, th);
            }
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.AppState$c */
    static final class C1350c extends AppState {

        /* renamed from: b */
        private final Model f4648b;

        /* renamed from: c */
        private final File f4649c;

        C1350c(PublishState publishState, EnvironmentFactory environmentFactory, App app) {
            super(publishState);
            this.f4648b = environmentFactory.getStenaLineInstance(app);
            this.f4649c = new File(app.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "StenaLine_afbeeldingen");
        }

        public String getDomainFolder() {
            return "Stenaline";
        }

        public Model getModel() {
            return this.f4648b;
        }

        public String getName() {
            return "StenaLine";
        }

        public File getPicturesDir() {
            return this.f4649c;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.AppState$b */
    static final class C1349b extends AppState {

        /* renamed from: b */
        private final Model f4646b;

        /* renamed from: c */
        private final File f4647c;

        C1349b(PublishState publishState, EnvironmentFactory environmentFactory, App app) {
            super(publishState);
            this.f4646b = environmentFactory.getIsalaDeltaInstance(app);
            this.f4647c = new File(app.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "IsalaDeltaState_afbeeldingen");
        }

        public String getDomainFolder() {
            return "IsalaDelta";
        }

        public Model getModel() {
            return this.f4646b;
        }

        public String getName() {
            return "IsalaDelta";
        }

        public File getPicturesDir() {
            return this.f4647c;
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.AppState$d */
    static final class C1351d extends AppState {

        /* renamed from: b */
        private final Model f4650b;

        /* renamed from: c */
        private final File f4651c;

        C1351d(PublishState publishState, EnvironmentFactory environmentFactory, Context context) {
            super(publishState);
            this.f4650b = environmentFactory.getWaveInstance(context);
            this.f4651c = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "WAVE afbeeldingen");
        }

        public String getDomainFolder() {
            return "veiligheid";
        }

        public Model getModel() {
            return this.f4650b;
        }

        public String getName() {
            return "WAVE";
        }

        public File getPicturesDir() {
            return this.f4651c;
        }
    }
}
